package mc.astgen
import org.antlr.v4.runtime.Token
import org.antlr.v4.runtime.CommonTokenStream
import org.antlr.v4.runtime.ParserRuleContext
import java.io.{PrintWriter,File}
import org.antlr.v4.runtime.ANTLRFileStream
import mc.utils._
import scala.collection.JavaConverters._
import org.antlr.v4.runtime.tree._
import mc.parser._
import mc.parser.MCParser._

class ASTGeneration extends MCBaseVisitor[Any] {

  // Using to flat the List
  // Need to cast from Any to the type referenced
  def flatten(lst: List[Any]): List[Any] = lst flatMap {
    case i: List[_] => flatten(i)
    case e => List(e)
  }

  override def visitProgram(ctx:ProgramContext) = {
        val declLst = visitDeclList(ctx.declList)
        Program(declLst)
  }
  			
  override def visitDeclList(ctx: DeclListContext) : List[Decl]= 
        flatten(ctx.decl.asScala.toList.map(_.accept(this))).asInstanceOf[List[Decl]]

  override def visitDecl(ctx: DeclContext) =
        ctx.getChild(0).accept(this)
  
  // Variable declaration

  // -- Cach 1
  override def visitVarDecl(ctx: VarDeclContext): List[Decl] = {
        val vartype : Type = visitPrimitiveType(ctx.primitiveType)
        val idLst = visitVarList(ctx.varList)
      
        val vartypeLst : List[Type] = ctx.varList.variable.asScala.toList.map(x => 
            if (x.getChildCount() == 1){
                  vartype
            }
            else{
                  ArrayType(IntLiteral(x.INTLIT.getText.toInt),vartype)
            }
        )

        var vardeclLst = idLst.zip(vartypeLst)
        vardeclLst.map(a => VarDecl(a._1, a._2))
  }

  // -- Cach 2
  // override def visitVarDecl(ctx: VarDeclContext): List[Decl] = {
  //   var vartype: Type = ctx.primitiveType.accept(this).asInstanceOf[Type]
  //   ctx.variable.asScala.toList.map(a => VarDecl(Id(a.ID.getText),
  //     if (a.getChildCount == 1)
  //       vartype
  //     else
  //       ArrayType(IntLiteral(a.INTLIT.getText.toInt), vartype)))
  // }
  
  override def visitPrimitiveType(ctx: PrimitiveTypeContext): Type = 
        if(ctx.BOOLTYPE != null) BoolType
        else if(ctx.FLOATTYPE != null) FloatType
        else if(ctx.INTTYPE != null) IntType
        else StringType

  // -- Cach 1    
  override def visitVarList(ctx: VarListContext): List[Id] = {
        ctx.variable.asScala.toList.map(x => Id(x.ID.getText))
  }

// Function declaration
  override def visitFuncDecl(ctx: FuncDeclContext): Decl = {
    val funcType : Type = visitFuncType(ctx.funcType)
    val funcName = Id(ctx.ID.getText)
    val paramList : List[VarDecl] = visitParaList(ctx.paraList)
    val body : Stmt = visitBlockStmt(ctx.blockStmt)
    FuncDecl(funcName, paramList, funcType, body)
  }

  // -- Function type
  override def visitFuncType(ctx: FuncTypeContext): Type = 
    ctx.getChild(0).getText match{
      case "void" => VoidType
      case _ => 
        {
          if (ctx.getChild(0).isInstanceOf[PrimitiveTypeContext]){
            visitPrimitiveType(ctx.getChild(0).asInstanceOf[PrimitiveTypeContext])
          }
          else{
            ArrayPointerType(visitPrimitiveType(ctx.getChild(0).getChild(0).asInstanceOf[PrimitiveTypeContext]))
          }
        }
  }

// -- Parameter List
  override def visitParaList(ctx: ParaListContext): List[VarDecl] = 
    ctx.getChildCount() match{
      case 0 => List()
      case _ => visitParaListNonNull(ctx.paraListNonNull)
    }
  
  override def visitParaListNonNull(ctx: ParaListNonNullContext): List[VarDecl] = 
    ctx.paraDecl.asScala.toList.map(_.accept(this)).asInstanceOf[List[VarDecl]]
  
  override def visitParaDecl(ctx: ParaDeclContext) = 
    VarDecl(Id(ctx.param.getChild(0).getText), 
      if(ctx.param.getChildCount() == 1)
        visitPrimitiveType(ctx.primitiveType)
      else
        ArrayPointerType(visitPrimitiveType(ctx.primitiveType))
    )

  // -- Stmt - Block Statement
  override def visitBlockStmt(ctx: BlockStmtContext): Stmt = {
    val declPartLst = visitDeclPart(ctx.declPart)
    // Uncomment after test decl part
    val stmtPart : List[Stmt] = visitStmtPart(ctx.stmtPart)
    Block(declPartLst, stmtPart) 
  }

  // -- Stmt - Block Statement ---- Declare part
  override def visitDeclPart(ctx: DeclPartContext) : List[Decl] = 
    if (ctx.getChildCount == 0){
      List()
    }
    else{
      visitVarDeclListNonNull(ctx.varDeclListNonNull)
    }

  override def visitVarDeclListNonNull(ctx : VarDeclListNonNullContext) : List[Decl] = 
    flatten(ctx.varDecl.asScala.toList.map(visitVarDecl(_))).asInstanceOf[List[Decl]]

  // -- Stmt - Block Statement ---- statement part
  override def visitStmtPart(ctx: StmtPartContext) : List[Stmt] = {
    ctx.stmt.asScala.toList.map(_.accept(this)).asInstanceOf[List[Stmt]]
  }

  override def visitStmt(ctx: StmtContext) = 
    ctx.getChild(0).accept(this)

  override def visitOtherStmt(ctx: OtherStmtContext) = {
    ctx.getChild(0).accept(this)
  }

  // // -- Stmt ---- statement part -- If stmt
  override def visitIfStmt(ctx: IfStmtContext) = {
    ctx.getChild(0).accept(this)
  }

  override def visitIfmatch(ctx: IfmatchContext) : Stmt = {
    val expr : Expr = visitExp0(ctx.exp0)
    val thenStmt : Stmt = visitStmtmatch(ctx.stmtmatch(0))
    val elseStmt : Stmt = visitStmtmatch(ctx.stmtmatch(1))
    // elseStmt - Stmt, elseStmt (If) - Option[Stmt]
    If(expr, thenStmt, Some(elseStmt))
  }

  override def visitIfunmatch(ctx: IfunmatchContext) : Stmt = {
    val expr : Expr = visitExp0(ctx.exp0)
    if(ctx.getChildCount == 5){
      val thenStmt = visitStmt(ctx.stmt).asInstanceOf[Stmt]
      If(expr,thenStmt,None)
    }
    else{
      val thenStmt = visitStmtmatch(ctx.stmtmatch)
      val elseStmt = visitStmtunmatch(ctx.stmtunmatch)
      If(expr, thenStmt,Some(elseStmt))
    }
    
  }

  // -- Stmt ---- statement part -- If stmt -- stmt match & unmatch
  override def visitStmtmatch(ctx: StmtmatchContext) : Stmt = {
    ctx.getChild(0).accept(this).asInstanceOf[Stmt]
  }

  override def visitStmtunmatch(ctx: StmtunmatchContext) : Stmt = {
    ctx.getChild(0).accept(this).asInstanceOf[Stmt]
  }

  // -- Stmt ---- statement part -- For Stmt
  override def visitForStmt(ctx: ForStmtContext) : Stmt = {
    val expr1 : Expr = visitExp0(ctx.exp0(0))
    val expr2 : Expr = visitExp0(ctx.exp0(1))
    val expr3 : Expr = visitExp0(ctx.exp0(2))
    val loop : Stmt = visitStmt(ctx.stmt).asInstanceOf[Stmt]
    For(expr1, expr2, expr3, loop)
  }

  // -- Stmt ---- statement part -- Do While
  override def visitDowhileStmt(ctx: DowhileStmtContext) : Stmt = {
    val stmtLst = ctx.stmt.asScala.toList.map(visitStmt(_)).asInstanceOf[List[Stmt]]
    val exp0 = visitExp0(ctx.exp0)
    Dowhile(stmtLst,exp0)
  }

  // -- Stmt ---- statement part -- Break
  override def visitBreakStmt(ctx: BreakStmtContext) = {
    Break
  }

  // -- Stmt ---- statement part -- Continue
  override def visitContinueStmt(ctx: ContinueStmtContext) = {
    Continue
  }

  // -- Stmt ---- statement part -- Return
  override def visitReturnStmt(ctx: ReturnStmtContext) = {
    ctx.getChild(0).accept(this)
  }

  override def visitNoExpReturn(ctx: NoExpReturnContext) = {
    Return(None)
  }

  override def visitAExpReturn(ctx: AExpReturnContext) = {
    val exp0 = visitExp0(ctx.exp0)
    Return(Some(exp0))
  }

  // -- Stmt ---- Expression 
  override def visitExpStmt(ctx: ExpStmtContext): Stmt = {
    visitExp0(ctx.exp0)
  }

// Expression
  // ---- Assign
  override def visitExp0(ctx: Exp0Context) : Expr = {
    if(ctx.getChildCount == 3){
      BinaryOp(ctx.ASSIGNOP.getText,
        ctx.exp1.accept(this).asInstanceOf[Expr],
        ctx.exp0.accept(this).asInstanceOf[Expr])
    }
    else{
      visitExp1(ctx.exp1)
    }
  }
  // ---- Or operator
  override def visitExp1(ctx: Exp1Context) : Expr = {
    if(ctx.getChildCount == 3){
      BinaryOp(ctx.OROP.getText,
        ctx.exp1.accept(this).asInstanceOf[Expr],
        ctx.exp2.accept(this).asInstanceOf[Expr])
    }
    else{
      visitExp2(ctx.exp2)
    }
  }
  // ---- And operator
  override def visitExp2(ctx: Exp2Context) : Expr = {
    if(ctx.getChildCount == 3){
      BinaryOp(ctx.ANDOP.getText,
        ctx.exp2.accept(this).asInstanceOf[Expr],
        ctx.exp3.accept(this).asInstanceOf[Expr])
    }
    else{
      visitExp3(ctx.exp3)
    }
  }
  // ---- == and != operator
  override def visitExp3(ctx: Exp3Context) : Expr = {
    if(ctx.getChildCount == 3){
      BinaryOp(ctx.getChild(1).getText,
        ctx.exp4(0).accept(this).asInstanceOf[Expr],
        ctx.exp4(1).accept(this).asInstanceOf[Expr])
    }
    else{
      visitExp4(ctx.exp4(0))
    }
  }
  // ---- >=, <=, <, > operator
  override def visitExp4(ctx: Exp4Context) : Expr = {
    if(ctx.getChildCount == 3){
      BinaryOp(ctx.getChild(1).getText,
        ctx.exp5(0).accept(this).asInstanceOf[Expr],
        ctx.exp5(1).accept(this).asInstanceOf[Expr])
    }
    else{
      visitExp5(ctx.exp5(0))
    }
  }
  // ---- + -
  override def visitExp5(ctx: Exp5Context) : Expr = {
    if(ctx.getChildCount == 3){
      BinaryOp(ctx.getChild(1).getText,
        ctx.exp5.accept(this).asInstanceOf[Expr],
        ctx.exp6.accept(this).asInstanceOf[Expr])
    }
    else{
      visitExp6(ctx.exp6)
    }
  }
  // ---- /, *, % operator
  override def visitExp6(ctx: Exp6Context) : Expr = {
    if(ctx.getChildCount == 3){
      BinaryOp(ctx.getChild(1).getText,
        ctx.exp6.accept(this).asInstanceOf[Expr],
        ctx.exp7.accept(this).asInstanceOf[Expr])
    }
    else{
      visitExp7(ctx.exp7)
    }
  }
  // ---- Negative (-, !) operator
  override def visitExp7(ctx: Exp7Context) : Expr = {
    if(ctx.getChildCount == 2){
      UnaryOp(ctx.getChild(0).getText,
        ctx.exp7.accept(this).asInstanceOf[Expr])
    }
    else{
      visitExp8(ctx.exp8)
    }
  }
  // ---- () operator
  override def visitExp8(ctx: Exp8Context) : Expr = {
    if(ctx.getChildCount == 3){
      visitExp0(ctx.exp0)
    }
    else{
      ctx.exp9.accept(this).asInstanceOf[Expr]
    }
  }
  // ---- Literal, function call, index
  override def visitExp9(ctx: Exp9Context) = {
    if(ctx.INTLIT != null) IntLiteral(ctx.INTLIT.getText.toInt)
    else if(ctx.FLOATLIT != null) FloatLiteral(ctx.FLOATLIT.getText.toFloat)
    else if(ctx.BOOLLIT != null) BooleanLiteral(ctx.BOOLLIT.getText.toBoolean)
    else if(ctx.STRINGLIT != null) StringLiteral(ctx.STRINGLIT.getText)
    else if(ctx.ID != null) Id(ctx.ID.getText)
    else ctx.getChild(0).accept(this)
  }
  // ---- Index Expression
  override def visitIndexExp(ctx: IndexExpContext) : LHS = {
    val indexer = visitIndexer(ctx.indexer).asInstanceOf[Expr]
    val exp0 = visitExp0(ctx.exp0)
    ArrayCell(indexer, exp0)
  }
  override def visitIndexer(ctx: IndexerContext) = {
    if(ctx.ID != null){
      Id(ctx.ID.getText)
    }
    else{
      ctx.funcCall.accept(this)
    }
  }

  // ---- Function call
  override def visitFuncCall(ctx: FuncCallContext) : Expr= {
    val id = Id(ctx.ID.getText)
    val argList = visitArgList(ctx.argList)
    CallExpr(id, argList)
  }

  override def visitArgList(ctx: ArgListContext) : List[Expr] = {
    if(ctx.getChildCount == 0){
      List()
    }
    else{
      visitArgListNonNull(ctx.argListNonNull)
    }
  }

  override def visitArgListNonNull(ctx: ArgListNonNullContext) : List[Expr] = {
    ctx.exp0.asScala.toList.map(visitExp0(_))
  }
}