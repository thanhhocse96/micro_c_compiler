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

  // Binary Type check
  def binaryTypeCheck(exp: BinaryOp, op: String, lhs: Type, rhs: Type): Unit ={
    val matchedType = op match{
      case "=" => {
        (lhs, rhs) match{
          case (IntType, IntType) | (FloatType, IntType) | (FloatType, FloatType) | (BoolType, BoolType) => true
          case _ => throw TypeMismatchInExpression(exp)
        } 
      }
      case ("==" | "!=") => {
        (lhs, rhs) match {
          case (IntType, IntType) | (BoolType, BoolType)=> true
          case _ => throw TypeMismatchInExpression(exp)
        }
      }
      case ("||" | "&&") => {
        (lhs, rhs) match {
          case (BoolType, BoolType) => true
          case _ => throw TypeMismatchInExpression(exp)
        }
      }
      case ("+" | "-" | "*" | "/" | "<" | "<=" | ">" | ">=") => {
        (lhs, rhs) match{
          case (IntType, IntType) | (IntType, FloatType) | (FloatType, FloatType) | (FloatType, IntType) => true
          case _ => throw TypeMismatchInExpression(exp)
        }
      }
      case("%") =>{
        (lhs, rhs) match{
          case (IntType, IntType) => true
          case _ => throw TypeMismatchInExpression(exp) 
        }
      }
    }
  } 

  // Get Name of Declaration
  def getDeclName(x: Decl): String = x match {
    case VarDecl(Id(a), _) => a
    case FuncDecl(Id(a), _, _, _) => a
  }

  // Get Type of Declaration
  def getDeclType(x: Decl): Type = x match {
    case VarDecl(_, a) => a
    case FuncDecl(_, a, b, _) => FunctionType(a.map(_.varType), b)
  }

  // Program: List[Symbol] of Global Enviroment
  override def visitProgram(ast: Program, c: Any): Any = 
    ast.decl.foldLeft(c.asInstanceOf[List[Symbol]])((x,y) => {
      y.accept(this, x).asInstanceOf[Symbol] :: x
    })

  // Variable declare
  override def visitVarDecl(ast: VarDecl, c: Any): Symbol = {
    val varName = getDeclName(ast)
    val varType = getDeclType(ast)

    if(lookup(varName, c.asInstanceOf[List[Symbol]], (x : Symbol)=> x.name) == None){
      Symbol(varName, varType, null) 
    }
    else{
      throw Redeclared(Variable, varName)
    }
  }

  // Current Function output
  var curFuncReturn : Type = null
  // Function declare
  override def visitFuncDecl(ast: FuncDecl, c: Any): Symbol = {
    val env = c.asInstanceOf[List[Symbol]]
    val funcName = getDeclName(ast)
    val funcType = getDeclType(ast).asInstanceOf[FunctionType]

    if(lookup(funcName, c.asInstanceOf[List[Symbol]], (x : Symbol) => x.name) != None){
      throw Redeclared(Function, funcName)
    }else{
      // Use Try Catch to get Redeclared Variable -> Parameter
      val param = ast.param.foldLeft(List[Symbol]())((x, y) => {
        try{
          visitVarDecl(y.asInstanceOf[VarDecl], x) :: x
        }
        catch{ 
          case x: Redeclared => throw Redeclared(Parameter, x.n)
        }
      })
      
      // Function - Block
      val block = ast.body.asInstanceOf[Block]
      // Block - Visit Variable Declare
      // Reuse visitVarDecl()
      val local = block.decl.foldLeft(param)((x, y) => {
        visitVarDecl(y.asInstanceOf[VarDecl], x) :: x
      })

      // Reference Environment
      val refEnv = local ++ c.asInstanceOf[List[Symbol]]
      
      // Block - Visit Statement
      val stmt = block.stmt.map(_.accept(this, refEnv))
      
      // Get current function return type
      curFuncReturn = funcType.output

      Symbol(funcName, funcType, null)
    }
  }

  // Visit Expression return Type
  // Expr -->> Call Expression
  override def visitCallExpr(ast: CallExpr, c: Any): Type = {
    // Environment for binary operator
    val env = c.asInstanceOf[List[Symbol]]
    
    val funcCallName = ast.method.name

    val funcLookUp = lookup(funcCallName, env, (x: Symbol) => x.name)

    funcLookUp match {
      case None => throw Undeclared(Function, funcCallName)
      case Some(func) => {
        // lhs: Input type of Function Declare
        val lhs = func.typ

        // rhs: Parameter of Call Expression
        val rhs = ast.params.map(_.accept(this,env).asInstanceOf[Type])

        if(typeCheck(lhs, FunctionType(rhs, null)) == false){
          throw TypeMismatchInExpression(ast)
        } else{
          lhs.asInstanceOf[FunctionType].output
        }
      }
    }
  }

  // Expr -->> Binary Operator
  override def visitBinaryOp(ast: BinaryOp, c: Any): Type = {
    // Environment for binary operator
    val env = c.asInstanceOf[List[Symbol]]

    val op = ast.op
    val lhs = ast.left.accept(this, env).asInstanceOf[Type]
    val rhs = ast.right.accept(this, env).asInstanceOf[Type]

    binaryTypeCheck(ast, op, lhs, rhs)

    op match{
      case ("*" | "/" | "+" | "-")  => {
        (lhs, rhs) match{
          case (FloatType, FloatType) => FloatType
          case (IntType, FloatType) => FloatType
          case (FloatType, IntType) => FloatType
          case (IntType, IntType) => IntType
          case _ => throw TypeMismatchInExpression(ast)
        }
      }
      case ("%") => IntType
      case ("<" | ">" | "<=" | ">=" | "==" | "!=" | "&&" | "||") => BoolType
      case ("=") => {
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
  override def visitUnaryOp(ast: UnaryOp, c: Any): Type = {
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

  // Statement
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
    ast.expr.accept(this, c) match {
      case BoolType => {
        ast.thenStmt.accept(this, c)
        ast.elseStmt match {
          case Some(x) => x.accept(this, c)
          case None => null
        }
      }
      case _ => throw TypeMismatchInStatement(ast)
    }
    null
  }

  // Stmt - For
  override def visitFor(ast: For, c: Any): Any = {
    if (ast.expr1.accept(this, c) == IntType
      && ast.expr2.accept(this, c) == BoolType
      && ast.expr3.accept(this, c) == IntType)
      ast.loop.accept(this, c)
    else
      throw TypeMismatchInStatement(ast)
    null
  }

  // Stmt - Return
  override def visitReturn(ast: Return, c: Any): Any = {
    val returnType = ast.expr match {
      case Some(x) => x.accept(this, c).asInstanceOf[Type]
      case None => VoidType
    }
    if (!typeCheck(curFuncReturn, returnType))
      throw TypeMismatchInStatement(ast)
    null
  }

  // Stmt - Do While
  override def visitDowhile(ast: Dowhile, c: Any): Any = {
    if (ast.exp.accept(this, c) == BoolType)
      ast.sl.map(_.accept(this, c))
    else
      throw TypeMismatchInStatement(ast)
    null
  }

  // Visit LHS - ID & Array Cell
  // ID
  override def visitId(ast: Id, c: Any): Type = {
    // Environment for binary operator
    val env = c.asInstanceOf[List[Symbol]]

    val lookupVar = lookup(ast.name, env, (x: Symbol) => x.name)

    lookupVar match {
      case None => throw Undeclared(Identifier, ast.name)
      case Some(id) => {
        if(id.typ.isInstanceOf[FunctionType]){
          throw Undeclared(Identifier, ast.name)
        }else{
          id.typ
        }
      }
    }
  }

  // Array Cell
  override def visitArrayCell(ast: ArrayCell, c: Any): Any = {
    // Environment for binary operator
    val env = c.asInstanceOf[List[Symbol]]

    ast.idx.accept(this, env) match {
      case IntType => {
        ast.arr.accept(this, c) match {
          case ArrayType(_, x) => x
          case ArrayPointerType(x) => x
          case _ => throw TypeMismatchInExpression(ast)
        }
      }
      case _ => throw TypeMismatchInExpression(ast)
    }
  }

  // Visit Type 
  override def visitIntType(ast: IntType.type, c: Any): Type = IntType
  override def visitFloatType(ast: FloatType.type, c: Any): Type = FloatType
  override def visitBoolType(ast: BoolType.type, c: Any): Type = BoolType
  override def visitStringType(ast: StringType.type, c: Any) : Type= StringType
  override def visitArrayType(ast: ArrayType, c: Any): Type = ast.eleType
  override def visitArrayPointerType(ast: ArrayPointerType, c: Any): Type = ast.eleType

  // Literal
  override def visitIntLiteral(ast: IntLiteral, c: Any) : Type = IntType
  override def visitFloatLiteral(ast: FloatLiteral, c: Any) : Type = FloatType
  override def visitStringLiteral(ast: StringLiteral, c: Any): Type = StringType
  override def visitBooleanLiteral(ast: BooleanLiteral, c: Any): Type = BoolType
}
