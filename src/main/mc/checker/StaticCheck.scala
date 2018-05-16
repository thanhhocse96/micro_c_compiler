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
    
    // Fix for Return (lhs: VoidType, rhs: IntType => fail to catch exception)
    def typeCheckReturn(lhs: Type, rhs: Type): Boolean = (lhs, rhs) match{
      case (VoidType, VoidType) => true
      case (FloatType, FloatType) | (FloatType, IntType) => true
      case (FloatType, x) => (x == FloatType || x == IntType)
      case (StringType, StringType) => true
      case (BoolType, BoolType) => true
      case (ArrayPointerType(x), ArrayType(_, y)) => typeCheckReturn(x, y)
      case (ArrayPointerType(x), ArrayPointerType(y)) => typeCheckReturn(x, y)
      case _ => false
    }
    // Binary Type Check
    // Type Coercions - Check the type of LHS & RHS match with the rule of Binary Operation
    def binaryTypeCheck(exp: BinaryOp, env: Any): Unit = {
      val lhs = exp.left.accept(this, env).asInstanceOf[Type]
      val rhs = exp.right.accept(this, env).asInstanceOf[Type]

      val op = exp.op
      val matchedType = op match{
        case ("||" | "&&") => {
          (lhs, rhs) match {
            case (BoolType, BoolType) => true
            case _ => throw TypeMismatchInExpression(exp)
          }
        }
        case ("+" | "-" | "*" | "/" | "<" | "<=" | ">" | ">=") => {
          (lhs, rhs) match {
            case (IntType, FloatType) | (IntType, FloatType) | (FloatType, IntType) | (FloatType, FloatType) => true
            case _ => throw TypeMismatchInExpression(exp)
          }
        }
        case ("%") => {
          if(lhs != IntType || rhs != IntType){
            throw TypeMismatchInExpression(exp)
          }
        }
        case ("==" | "!=" | "=") => {
          (lhs, rhs) match {
            case (IntType, FloatType) | (IntType, FloatType) | (FloatType, IntType) | (FloatType, FloatType) | (BoolType, BoolType)=> true
            case _ => throw TypeMismatchInExpression(exp)
          }
        }
      }

    }

    // Program: List[Symbol] of Global Enviroment
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
    
    // Use to compare with Return Type
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
        // Get current function return type
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
    // Expr -->> Call Expression 
    override def visitCallExpr(ast: CallExpr, c: Any): Type ={
      // Environment to find Type of 1 call expr
      val env = c.asInstanceOf[List[Symbol]]

      val lookedUpFunc = lookup(ast.method.name, env, (x:Symbol) => x.name)
      lookedUpFunc match{
        case None => throw Undeclared(Function, ast.method.name)
        case Some(lkFunc) => {
          // lhs: Input of Function
          val lhs = lkFunc.typ
          // rhs: visit List Expression -> visitExpr return Type
          val rhs = ast.params.map(_.accept(this,env).asInstanceOf[Type])

          if(typeCheck(lhs,FunctionType(rhs, null)) == false){
            throw TypeMismatchInExpression(ast)
          }
          else{
            lhs.asInstanceOf[FunctionType].output
          }          
        }
      }
    }
    // Expr -->> Binary Operator
    override def visitBinaryOp(ast: BinaryOp, c: Any): Type = {
      // Environment for binary operator
      val env = c.asInstanceOf[List[Symbol]]

      val lhs = ast.left.accept(this, env).asInstanceOf[Type]
      val rhs = ast.right.accept(this, env).asInstanceOf[Type]

      binaryTypeCheck(ast, env)
      
      ast.op match{
        case ("*" | "/" | "+" | "-")  => {
          (lhs, rhs) match{
            case (_, FloatType) => FloatType
            case (FloatType, _) => FloatType
            case (IntType, IntType) => IntType
            case _ => throw TypeMismatchInExpression(ast)
          }
        }
        case ("<" | ">" | "<=" | ">=" | "==" | "!=" | "&&" | "||") => BoolType
        case ("%") => IntType
        case _ => {
          if(typeCheck(lhs, rhs) == false){
            throw TypeMismatchInExpression(ast)
          }
          else{
            lhs 
          }
        }
      }
    }   
    
    // Expr -->> Unary Operator
    override def visitUnaryOp(ast: UnaryOp, c: Any) ={
      // Environment for binary operator
      val env = c.asInstanceOf[List[Symbol]]

      val unaryOp = ast.op
      val unaryBodyType = ast.body.accept(this, env).asInstanceOf[Type]

      (unaryOp, unaryBodyType) match {
        case ("!", BoolType) => BoolType
        case ("-", IntType) => IntType
        case ("-", FloatType) => FloatType
        case _ => throw TypeMismatchInExpression(ast)
      }
    }

    // Expr -->> LHS -->> Id: return Type
    override def visitId(ast: Id, c: Any): Type = {
      // Environment for binary operator
      val env = c.asInstanceOf[List[Symbol]]

      val idLookup = lookup(ast.name, env, (x: Symbol) => x.name)
      
      idLookup match {
        case None => throw Undeclared(Identifier, ast.name)
        case Some(id) => {
          // Nearest declared Id
          if (id.typ.isInstanceOf[FunctionType]){
            throw Undeclared(Identifier, ast.name)
          }else{
            id.typ
          }
        }
      }
    }
    
    override def visitArrayCell(ast: ArrayCell, c: Any): Type = {
      // Environment for binary operator
      val env = c.asInstanceOf[List[Symbol]]

      // Index must be Int
      val index = ast.idx.accept(this, env).asInstanceOf[Type]
      
      if(index != IntType){
        throw TypeMismatchInExpression(ast)
      }else{
        val arr = ast.arr.accept(this, env).asInstanceOf[Type]

        val arrType = if(arr.isInstanceOf[ArrayType] == true || arr.isInstanceOf[ArrayPointerType]){
          arr
        }else{
          throw TypeMismatchInExpression(ast)
        }
        // Return: Array type 
        arrType
      }
    }

    // Stmt - Block
    override def visitBlock(ast: Block, c: Any): Any = {
      // Environment for binary operator
      val env = c.asInstanceOf[List[Symbol]]

      val local = ast.decl.foldLeft(List[Symbol]())((x, y) => {
        visitVarDecl(y.asInstanceOf[VarDecl], x) :: x
      })

      // Referrence Environment of Block
      val refEnv = local ++ env

      ast.stmt.map(_.accept(this, refEnv))

      null
    }

    // Stmt - If
    override def visitIf(ast: If, c: Any): Any = {
      // Environment for binary operator
      val env = c.asInstanceOf[List[Symbol]]

      val ifExpr = ast.expr.accept(this, env).asInstanceOf[Type]

      if(ifExpr == BoolType){
        ast.thenStmt.accept(this, env)
        ast.elseStmt match{
          case Some(i) => i.accept(this, env)
          case None => null
        }
      }else{
        throw TypeMismatchInStatement(ast)
      }
    }

    // Stmt - For
    override def visitFor(ast: For, c: Any): Any = {
      // Environment for binary operator
      val env = c.asInstanceOf[List[Symbol]]

      val expr1 = ast.expr1.accept(this, env)
      val expr2 = ast.expr2.accept(this, env)
      val expr3 = ast.expr3.accept(this, env)

      (expr1, expr2, expr3) match{
        case (IntType, BoolType, IntType) => {
          ast.loop.accept(this, env)
          null
        }
        case _ => throw TypeMismatchInStatement(ast)
      }
    }

    // Stmt - Return
    override def visitReturn(ast: Return, c: Any): Any = {
      // Environment for binary operator
      val env = c.asInstanceOf[List[Symbol]]

      // Right hand side
      val returnExpType = ast.expr match{
        case None => VoidType
        case Some(i) => i.accept(this, env).asInstanceOf[Type]
      }
      // Left hand side
      val funcEnv = env.filter((x: Symbol) => x.typ.isInstanceOf[FunctionType] == true)
      val curFuncType = funcEnv.head.typ.asInstanceOf[FunctionType]

      if(typeCheckReturn(curFuncType.output,returnExpType) == false){
        throw TypeMismatchInStatement(ast)
      }

      null
    }

    // Stmt - Do While
    override def visitDowhile(ast: Dowhile, c: Any): Any = {
      // Environment for binary operator
      val env = c.asInstanceOf[List[Symbol]]

      val exp = ast.exp.accept(this, env)

      if(exp != BoolType){
        throw TypeMismatchInStatement(ast)
      }else{
        ast.sl.map(_.accept(this, env))
        null
      }
    }

    // Literal
    override def visitIntLiteral(ast: IntLiteral, c: Any) : Type = IntType
    override def visitFloatLiteral(ast: FloatLiteral, c: Any) : Type = FloatType
    override def visitStringLiteral(ast: StringLiteral, c: Any): Type = StringType
    override def visitBooleanLiteral(ast: BooleanLiteral, c: Any): Type = BoolType
}
