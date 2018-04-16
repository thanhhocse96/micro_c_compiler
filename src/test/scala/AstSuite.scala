import org.scalatest.FunSuite
import mc.utils._

/**
  * Created by nhphung on 4/29/17.
  */
class AstSuite extends FunSuite with TestAst {

  test("001 - Simple var declare") {
    val input = "int a;"
    val expected = Program(List(VarDecl(Id("a"),IntType)))
    assert(checkAst(input,expected,201))
  }

  test("002 - a simple program with void as return type of main") {
    val input = "void main () {}"
    val expected = Program(List(FuncDecl(Id("main"),List(),VoidType,Block(List(),List()))))
    assert(checkAst(input,expected,202))
  }
  test("003 - another simple program with int as return type of main") {
    val input = "int main () {}"
    val expected = Program(List(FuncDecl(Id("main"),List(),IntType,Block(List(),List()))))
    assert(checkAst(input,expected,203))
  }
  test("004 - a simple program has a simple call putIntLn") {
    val input = "void main () {putIntLn(5);}"
    val expected = Program(List(FuncDecl(Id("main"),List(),VoidType,Block(List(),List(CallExpr(Id("putIntLn"),List(IntLiteral(5))))))))
    assert(checkAst(input,expected,204))
  }
}
