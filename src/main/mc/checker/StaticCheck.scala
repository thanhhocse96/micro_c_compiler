package mc.checker

/**
 * @author nhphung
 * @author Ho Quang Thanh
 */

import mc.parser._
import mc.utils._
import java.io.{File, PrintWriter}

//import mc.codegen.Val
import org.antlr.v4.runtime.ANTLRFileStream
import org.antlr.v4.runtime.CommonTokenStream
import org.antlr.v4.runtime.tree._

import scala.collection.JavaConverters._

case class Symbol(name: String, typ: Type, value: Val)
trait Val
case class FunctionType(input: List[Type], output: Type) extends Type

class StaticChecker(ast:AST) extends BaseVisitor with Utils {
    
    def check() = {
      val builtinFunc = List(
        Symbol("getInt", FunctionType(List(), IntType), null),
        Symbol("putInt", FunctionType(List(IntType), VoidType), null),
        Symbol("putIntLn", FunctionType(List(IntType), VoidType), null),
        Symbol("getFloat", FunctionType(List(), FloatType), null),
        Symbol("putFloat", FunctionType(List(FloatType), VoidType), null),
        Symbol("putFloatLn", FunctionType(List(FloatType), VoidType), null),
        Symbol("putBool", FunctionType(List(BoolType), VoidType), null),
        Symbol("putBoolLn", FunctionType(List(BoolType), VoidType), null),
        Symbol("putString", FunctionType(List(StringType), VoidType), null),
        Symbol("putStringLn", FunctionType(List(StringType), VoidType), null),
        Symbol("putLn", FunctionType(List(), VoidType), null)
      )
      // Pass Built-in Function down to Visit
      // visit return Symbol List
      val symbolLst = visit(ast,builtinFunc)

      // val symbolLst = visitProgram(ast, builtinFunc).asInstanceOf[List[Symbol]]
      if(lookup("main", symbolLst.asInstanceOf[List[Symbol]], (x: Symbol) => x.name) == None){
        throw NoEntryPoint
      }
      else{
        symbolLst
      }
    }

    // Type check
    def typeCheck(lhs: Type, rhs: Type): Boolean = (lhs, rhs) match{
      case (FloatType, IntType) => true
      case (ArrayPointerType(x), ArrayType(_,y)) => typeCheck(x, y)
      case (ArrayPointerType(x), ArrayPointerType(y)) => typeCheck(x, y)
      // Check Function Type
      case (FunctionType(xLst,_), FunctionType(yLst, _)) => xLst.length == yLst.length && xLst.zip(yLst).forall(
        (x) => typeCheck(x._1, x._2))
      case (x, y) => x == y
      case _ => false 
    }

    // Binary Type Check
    def binaryTypeCheck(exp: BinaryOp): Unit = {
      null
    }

    override def visitProgram(ast: Program, c: Any): Any = 
      ast.decl.foldLeft(c.asInstanceOf[List[Symbol]])((x,y) => {
        y.accept(this, x).asInstanceOf[Symbol] :: x
      })

    override def visitVarDecl(ast: VarDecl, c: Any): Symbol =
      if(lookup(ast.variable.name, c.asInstanceOf[List[Symbol]], (x : Symbol)=> x.name) == None){
        Symbol(ast.variable.name, ast.varType, null) 
      }
      else{
        throw Redeclared(Variable, ast.variable.name)
      }
    
    override def visitFuncDecl(ast: FuncDecl, c: Any): Symbol = {
      if(lookup(ast.name.name, c.asInstanceOf[List[Symbol]], (x : Symbol) => x.name) != None){
        throw Redeclared(Function, ast.name.name)
      }else{
        // Use Try Catch to get Redeclared Variable -> Parameter
        val param = ast.param.foldLeft(List[Symbol]())((x, y) => {
          try{
            y.accept(this, x).asInstanceOf[Symbol] :: x
          }
          catch{ 
            case x: Redeclared => throw Redeclared(Parameter, x.n)
          }
        })
        
        // Function Block
        val block = ast.body.asInstanceOf[Block]
        // Visit Var Declare in Block
        // Reuse visitVarDecl()
        val local = block.decl.foldLeft(param)((x, y) => {
          visitVarDecl(y.asInstanceOf[VarDecl], x) :: x
        })

        // Reference Environment
        val refEnv = local ++ c.asInstanceOf[List[Symbol]]
        
        // Visit Statement in Block
        val stmt = block.stmt.map(_.accept(this, refEnv))
        Symbol(ast.name.name, FunctionType(ast.param.map(_.varType), ast.returnType), null)
      }
    }

    // Visit Type 
    override def visitIntType(ast: IntType.type, c: Any) = IntType
    override def visitFloatType(ast: FloatType.type, c: Any) = FloatType
    override def visitBoolType(ast: BoolType.type, c: Any) = BoolType
    override def visitStringType(ast: StringType.type, c: Any) = StringType
    override def visitArrayType(ast: ArrayType, c: Any) = ast.eleType
    override def visitArrayPointerType(ast: ArrayPointerType, c: Any) = ast.eleType

    // Visit Expression return Type

    override def visitCallExpr(ast: CallExpr, c: Any): Type ={
      // Environment to find Type of 1 call expr
      val env = c.asInstanceOf[List[Symbol]]

      val lookedUpFunc = lookup(ast.method.name, env, (x:Symbol) => x.name)
      
      if (lookedUpFunc == None) {
        throw Undeclared(Function, ast.method.name)
      }else{
        // lhs: Input of Function
        val lhs = lookedUpFunc.asInstanceOf[Symbol].typ
        // rhs: visit List Expression -> visitExpr return Type
        val rhs = ast.params.map(_.accept(this,env).asInstanceOf[Type])

        if(typeCheck(lhs,FunctionType(rhs, null)) == false){
          throw TypeMismatchInExpression(ast)
        }

        lhs.asInstanceOf[FunctionType].output
      }
    }

    override def visitBinaryOp(ast: BinaryOp, c: Any): Type = {
      // Environment for binary operator
      val env = c.asInstanceOf[List[Symbol]]

      val lhs = ast.left.accept(this, env)
      null    
    }   
    
    // Literal
    override def visitIntLiteral(ast: IntLiteral, c: Any) : Type = IntType
    override def visitFloatLiteral(ast: FloatLiteral, c: Any) : Type = FloatType
    override def visitStringLiteral(ast: StringLiteral, c: Any): Type = StringType
    override def visitBooleanLiteral(ast: BooleanLiteral, c: Any): Type = BoolType
}
