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

  //Using to flat the List
  def flatten(lst: List[Any]): List[Any] = lst flatMap {
    case i: List[_] => flatten(i)
    case e => List(e)
  }

  override def visitProgram(ctx:ProgramContext) = 
  			Program(ctx.declList.asInstanceOf[List[Decl]])

  override def visitDeclList(ctx: DeclListContext) = 
        flatten(ctx.decl.asScala.toList.map(_.accept(this)))

  override def visitDecl(ctx: DeclContext) =
        ctx.getChild(0).accept(this)

  override def visitPrimitiveType(ctx: PrimitiveTypeContext) = 
        if(ctx.BOOLTYPE) BoolType()
        else if(ctx.FLOATTYPE) FloatType 
        else if(ctx.INTTYPE) IntType 
        else StringType

  override def visitVarDecl(ctx: VarDeclContext) = {
        var type = ctx.primitiveType.accept(this).asInstanceOf[Type]
        ctx.manyVar.asScala.toList.map(_.accept(this))
  }
  
}