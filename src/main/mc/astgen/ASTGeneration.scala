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
  // Need to cast from Any to the Type you reference
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
  
  override def visitPrimitiveType(ctx: PrimitiveTypeContext): Type = 
        if(ctx.BOOLTYPE != null) BoolType
        else if(ctx.FLOATTYPE != null) FloatType
        else if(ctx.INTTYPE != null) IntType
        else StringType
        
  override def visitVarList(ctx: VarListContext): List[Id] = {
        ctx.variable.asScala.toList.map(x => Id(x.ID.getText))
  }

  override def visitFuncDecl(ctx: FuncDeclContext) = {
    
  }
}