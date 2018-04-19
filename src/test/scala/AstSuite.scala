import org.scalatest.FunSuite
import mc.utils._

/**
  * Created by nhphung on 4/29/17.
  */
class AstSuite extends FunSuite with TestAst {
  test("201 - a simple program with void as return type of main") {
    val input = "void main () {}"
    val expected = Program(List(FuncDecl(Id("main"),List(),VoidType,Block(List(),List()))))
    assert(checkAst(input,expected,201))
  }
  test("202 - another simple program with int as return type of main") {
    val input = "int main () {}"
    val expected = Program(List(FuncDecl(Id("main"),List(),IntType,Block(List(),List()))))
    assert(checkAst(input,expected,202))
  }
  test("203 - a simple program has a simple call putIntLn") {
    val input = "void main () {putIntLn(5);}"
    val expected = Program(List(FuncDecl(Id("main"),List(),VoidType,Block(List(),List(CallExpr(Id("putIntLn"),List(IntLiteral(5))))))))
    assert(checkAst(input,expected,203))
  }

  test("204 - Simple var declare") {
    val input = "int a;"
    val expected = Program(List(VarDecl(Id("a"),IntType)))
    assert(checkAst(input,expected,204))
  }

  test("205 - Simple many var declares") {
    val input = "int a, b;"
    val expected = Program(List(VarDecl(Id("a"),IntType),VarDecl(Id("b"),IntType)))
    assert(checkAst(input,expected,205))
  }

  test("206 - Simple many var declares with c is Array type") {
    val input = "int a, b, c[1];"
    val expected = Program(List(VarDecl(Id("a"),IntType),VarDecl(Id("b"),IntType),VarDecl(Id("c"),ArrayType(IntLiteral(1),IntType))))
    assert(checkAst(input,expected,206))
  }

  test("207 - Simple many var declares with c is Array type - type String") {
    val input = "string a, b, c[1];"
    val expected = Program(List(VarDecl(Id("a"),StringType),VarDecl(Id("b"),StringType),VarDecl(Id("c"),ArrayType(IntLiteral(1),StringType))))
    assert(checkAst(input,expected,206))
  }
}
