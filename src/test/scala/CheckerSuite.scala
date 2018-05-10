import org.scalatest.FunSuite
import mc.checker._
import mc.utils._

/**
  * Created by nhphung on 4/29/17.
  */
class CheckerSuite extends FunSuite with TestChecker {
  test("401 - Undeclared Function") {
    val input = "void main () {writeIntLn(3);}"
    val expected = "Undeclared Function: writeIntLn"
    assert(checkCkr(input,expected,401))
  } 

  test("402 - Type Mismatch In Expression: getInt") {
    val input = "void main () {getInt(3);}"
    val expected = "Type Mismatch In Expression: "+CallExpr(Id("getInt"),List(IntLiteral(3))).toString
    assert(checkCkr(input,expected,402))
  } 

  test("403 - Type Mismatch In Expression: putIntLn") {

    val input = "void main () {putIntLn();}"
    val expected = "Type Mismatch In Expression: "+CallExpr(Id("putIntLn"),List()).toString
    assert(checkCkr(input,expected,403))
  }

  test("404 - Check with AST") {
    val input = Program(List(
      FuncDecl(Id("main"),List(),VoidType,
        Block(List(),
          List(CallExpr(Id("putIntLn"),List()))))))
    val expected = "Type Mismatch In Expression: "+CallExpr(Id("putIntLn"),List()).toString
    assert(checkAst(input,expected,404))
  }

  test("405 - Check with AST putIntLn with float") {
    val input = Program(List(
      FuncDecl(Id("main"),List(),VoidType,
        Block(List(),
          List(CallExpr(Id("putIntLn"),List(FloatLiteral(1.2f))))))))
    val expected = "Type Mismatch In Expression: "+CallExpr(Id("putIntLn"),List(FloatLiteral(1.2f))).toString
    assert(checkAst(input,expected,405))

  }

  // test("406 - Check Simple declare - No Error") {
  //   val a = VarDecl(Id("a"),IntType)
  //   val m = FuncDecl(Id("main"),List(),VoidType,
  //       Block(List(),List()))
  //   val b = VarDecl(Id("b"),FloatType)
  //   val input = Program(List(a, m, b))
  //   val result = new StaticChecker(input).check()
  //   val expected = List(Symbol("b",FloatType,null),Symbol("main", FunctionType(List(),VoidType),null),Symbol("a",IntType,null))
  //   assert(result == expected)
  // }
  test("406 - Check Simple declare - No Error") {
  val input = """void main () {}
int a;
float b;"""
  val expected = ""
  assert(checkCkr(input,expected,406))
  }

  test("407 - Redeclared variables") {
  val input = """void main () {}
int a;
float a;"""
  val expected = "Redeclared Variable: a"
  assert(checkCkr(input,expected,407))
  }

  test("408 - Redeclared function") {
  val input = """void main () {}
int a;
float main(){}"""
  val expected = "Redeclared Function: main"
  assert(checkCkr(input,expected,408))
  }

  test("409 - Redeclared function with variable before") {
  val input = """void main () {}
int a;
float a(){}"""
  val expected = "Redeclared Function: a"
  assert(checkCkr(input,expected,409))
  }

  test("410 - Redeclared variable with function before") {
  val input = """void main () {}
int main;
float a(){}"""
  val expected = "Redeclared Variable: main"
  assert(checkCkr(input,expected,410))
  }

  test("411 - Redeclared parameter") {
  val input = """void main (int a, float a) {}"""
  val expected = "Redeclared Parameter: a"
  assert(checkCkr(input,expected,411))
  }

  test("412 - Redeclared vardeclare") {
  val input = """void main (int a) {
int b;
string b;
  }"""
  val expected = "Redeclared Variable: b"
  assert(checkCkr(input,expected,412))
  }

  test("413 - Redeclared vardeclare with parameter") {
  val input = """void main (int a, float b) {
float a;
  }"""
  val expected = "Redeclared Variable: a"
  assert(checkCkr(input,expected,413))
  }

  test("414 - Redeclared variable in block with function") {
  val input = """void main (int a, float b) {
float a;
}
float main(){}"""
  val expected = "Redeclared Variable: a"
  assert(checkCkr(input,expected,414))
  }

  test("415 - Redeclared function with parameter") {
  val input = """float main(){}
void main (int a, float b) {
float a;
}"""
  val expected = "Redeclared Function: main"
  assert(checkCkr(input,expected,415))
  }

  test("416 - Redeclared function with parameter") {
  val input = """float getInt(){}
void main (int a, float b) {
float getInt;
}"""
  val expected = "Redeclared Function: getInt"
  assert(checkCkr(input,expected,416))
  }

  test("417 - Redeclared builtin function in function") {
  val input = """void getInt(){}
void main (int a, float b) {
float getInt;
}"""
  val expected = "Redeclared Function: getInt"
  assert(checkCkr(input,expected,417))
  }

  test("418 - Type Mismatch function call") {
  val input = """float foo(int a){}
void main (int a, float b) {
float getInt;
foo(1.4);
}"""
  val expected = "Type Mismatch In Expression: foo(1.4)"
  assert(checkCkr(input,expected,418))
  }

  test("419 - Undeclared function") {
  val input = """void main (int a, float b) {
float getInt;
foo(1.4);
}"""
  val expected = "Undeclared Function: foo"
  assert(checkCkr(input,expected,419))
  }

  test("420 - No Entry point") {
  val input = """void foo (int a, float b) {
float getInt;
}
float abc(){}"""
  val expected = "No Entry Point"
  assert(checkCkr(input,expected,420))
  }
}