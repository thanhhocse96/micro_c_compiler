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

  test("206 - Simple many var declares with c is Array type - type Int") {
    val input = "int a, b, c[1];"
    val expected = Program(List(VarDecl(Id("a"),IntType),VarDecl(Id("b"),IntType),VarDecl(Id("c"),ArrayType(IntLiteral(1),IntType))))
    assert(checkAst(input,expected,206))
  }

  test("207 - Simple many var declares with c is Array type - type String") {
    val input = "string a, b, c[1];"
    val expected = Program(List(VarDecl(Id("a"),StringType),VarDecl(Id("b"),StringType),VarDecl(Id("c"),ArrayType(IntLiteral(1),StringType))))
    assert(checkAst(input,expected,207))
  }

  test("208 - Simple many var declares with c is Array type - type String + simple Function declare") {
    val input = """string a, b, c[1];
int main(){}"""
    val expected = Program(List(VarDecl(Id("a"),StringType),VarDecl(Id("b"),StringType),VarDecl(Id("c"),ArrayType(IntLiteral(1),StringType)),FuncDecl(Id("main"),List(),IntType,Block(List(),List()))))
    assert(checkAst(input,expected,208))
  }

  test("209 - Simple many var declares with c is Array type - type String + 2 simple Function declares") {
    val input = """string a, b, c[1];
int main(){}
string foo(){}"""
    val expected = Program(List(VarDecl(Id("a"),StringType),VarDecl(Id("b"),StringType),VarDecl(Id("c"),ArrayType(IntLiteral(1),StringType)),FuncDecl(Id("main"),List(),IntType,Block(List(),List())),FuncDecl(Id("foo"),List(),StringType,Block(List(),List()))))
    assert(checkAst(input,expected,209))
  }

  test("210 - Simple many var-declares + 2 simple Function declares (1 array pointer type)") {
    val input = """string a, b, c[1];
int main(){}
string []foo(){}"""
    val expected = Program(List(VarDecl(Id("a"),StringType),VarDecl(Id("b"),StringType),VarDecl(Id("c"),ArrayType(IntLiteral(1),StringType)),FuncDecl(Id("main"),List(),IntType,Block(List(),List())),FuncDecl(Id("foo"),List(),ArrayPointerType(StringType),Block(List(),List()))))
    assert(checkAst(input,expected,210))
  }

  test("211 - Simple many varDecls + simple Function declare has parameters") {
    val input = """string a, b, c[1];
int main(int a, int b[]){}"""
    val expected = Program(List(VarDecl(Id("a"),StringType),VarDecl(Id("b"),StringType),VarDecl(Id("c"),ArrayType(IntLiteral(1),StringType)),FuncDecl(Id("main"),List(VarDecl(Id("a"),IntType),VarDecl(Id("b"),ArrayPointerType(IntType))),IntType,Block(List(),List()))))
    assert(checkAst(input,expected,211))
  }
}
