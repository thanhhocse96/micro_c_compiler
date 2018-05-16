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
  val expected = "Type Mismatch In Expression: CallExpr(Id(foo),List(FloatLiteral(1.4)))"
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

  test("421 - Type Mismatch function call") {
  val input = """float foo(int a){}
void main (int a, float b) {
float getInt;
foo(b);
}"""
  val expected = "Type Mismatch In Expression: CallExpr(Id(foo),List(Id(b)))"
  assert(checkCkr(input,expected,421))
  }

  test("422 - Type Mismatch In Expression: ArrayCell - index FloatType") {
    val input = """int a;
    int b[9];
    void main() {
      a = b[1.0];
    }"""
    val expected = """Type Mismatch In Expression: ArrayCell(Id(b),FloatLiteral(1.0))"""
    assert(checkCkr(input, expected, 422))
  }

  test("423 - Type Mismatch In Expression: ArrayCell - index is BooleanType") {
    val input = """int a;
    int b[9];
    void main() {
      a = b[true];
    }"""
    val expected = """Type Mismatch In Expression: ArrayCell(Id(b),BooleanLiteral(true))"""
    assert(checkCkr(input, expected, 423))
  }

  test("424 - Type Mismatch In Expression: ArrayCell - index is StringType") {
    val input = """int a;
    int b[9];
    void main() {
      a = b["1.0"];
    }"""
    val expected = """Type Mismatch In Expression: ArrayCell(Id(b),StringLiteral(1.0))"""
    assert(checkCkr(input, expected, 424))
  }

  test("425 - Type Mismatch In Expression: ArrayCell - index is ArrayType") {
    val input = """int a;
    int b[9];
    void main() {
      a = b[b];
    }"""
    val expected = """Type Mismatch In Expression: ArrayCell(Id(b),Id(b))"""
    assert(checkCkr(input, expected, 425))
  }

  test("426 - Type Mismatch In Expression: ArrayCell - index is ArrayPointerType") {
    val input = """int a;
    int b[9];
    void main(int c[]) {
      a = b[c];  
    }"""
    val expected = """Type Mismatch In Expression: ArrayCell(Id(b),Id(c))"""
    assert(checkCkr(input, expected, 426))
  }

  test("427 - Type Mismatch In Expression: ArrayCell - index is VoidType") {
    val input = """void example(){}
int a;
int b[9];
void main(int c[]) {
  a = b[example()];  
}
 """
    val expected = """Type Mismatch In Expression: ArrayCell(Id(b),CallExpr(Id(example),List()))"""
    assert(checkCkr(input, expected, 427))
  }

  test("428 - Type Mismatch In Expression: ArrayCell - arr is IntType") {
    val input = """int a;
    int b[9];
    void main(int c) {
      a = c[0];  
    }
    void example(){}"""
    val expected = """Type Mismatch In Expression: ArrayCell(Id(c),IntLiteral(0))"""
    assert(checkCkr(input, expected, 428))
  }

  test("429 - Type Mismatch In Expression: ArrayCell - arr is FloatType") {
    val input = """int a;
    int b[9];
    void main(float c) {
      a = c[1.0];  
    }
    void example(){}"""
    val expected = """Type Mismatch In Expression: ArrayCell(Id(c),FloatLiteral(1.0))"""
    assert(checkCkr(input, expected, 429))
  }

  test("430 - Type Mismatch In Expression: ArrayCell - arr is StringType") {
    val input = """int a;
    int b[9];
    void main(string c) {
      a = c["1.0"];  
    }
    void example(){}"""
    val expected = """Type Mismatch In Expression: ArrayCell(Id(c),StringLiteral(1.0))"""
    assert(checkCkr(input, expected, 430))
  }

  test("431 - Type Mismatch In Expression: ArrayCell - arr is VoidType") {
    val input = """int a;
    void main(float c) {
      a = example["1.0"];  
    }
    void example(){}"""
    val expected = """Type Mismatch In Expression: ArrayCell(Id(example),StringLiteral(1.0))"""
    assert(checkCkr(input, expected, 431))
  }

  test("432 - Type Mismatch In Expression: Id Undeclared") {
    val input = """int a;
    void main(float c) {
      b = 1;  
    }
    void example(){}"""
    val expected = """Undeclared Identifier: b"""
    assert(checkCkr(input, expected, 432))
  }

  test("433 - Function not Declared") {
    val input = """int a;
    void main(float c) {
      a = example(1);  
    }
    void example(){}"""
    val expected = """Undeclared Function: example"""
    assert(checkCkr(input, expected, 433))
  }

  test("434 - Type Mismatch In Expression: CallExpr - not equal number of actual parameters") {
    val input = """void example(int b, int c){}
    int a;
    void main(float c) {
      a = example(1);  
    }
    """
    val expected = """Type Mismatch In Expression: CallExpr(Id(example),List(IntLiteral(1)))"""
    assert(checkCkr(input, expected, 434))
  }

  test("435 - Type Mismatch In Expression: CallExpr - type mismatch passing parameters") {
    val input = """void example(int b){}
    int a;
    void main(float c) {
      a = example(1.0);  
    }
    """
    val expected = """Type Mismatch In Expression: CallExpr(Id(example),List(FloatLiteral(1.0)))"""
    assert(checkCkr(input, expected, 435))
  }

  test("436 - Return false") {
    val input = Program(List(
      FuncDecl(Id("example"),List(),VoidType,
        Block(List(),
          List(
            Return(Some(StringLiteral("a")))
          ))),
      FuncDecl(Id("main"),List(),VoidType,
        Block(List(),
          List()))))

    val expected = """Type Mismatch In Statement: Return(Some(StringLiteral(a)))"""
    assert(checkAst(input, expected, 436))
  }

  test("437 - Return false") {
    val input = """void example0(int b){}
void example1(int b){
  return;
}
void example2(int b){
  return 2;
}
int a;
void main(float c) {
  a = example(1.0);  
}"""
    val expected = """Type Mismatch In Statement: Return(Some(IntLiteral(2)))"""
    assert(checkCkr(input, expected, 437))
  }

  test("438 - Type mismatch at return ") {
    val input = """void example0(int b){}
    void example1(int b){
    }
    void example2(int b){
    }
    int example3(int b){
      int a;
      return a;
    }
    int example4(int b){
      string a;
      return a;
    }
    int a;
    int main(float c) {
      a = example0(1);  
    }
    """
    val expected = """Type Mismatch In Statement: Return(Some(Id(a)))"""
    assert(checkCkr(input, expected, 438))
  }

  test("439 - Type Mismatch In Expression - BinaryOp <<=>>= IntType BooleanType") {
    val input = """boolean a;
    void main() {
      a = 1 < true;
    }
    void example(){}"""
    val expected = """Type Mismatch In Expression: BinaryOp(<,IntLiteral(1),BooleanLiteral(true))"""
    assert(checkCkr(input, expected, 439))
  }

  test("440 - Type Mismatch In Expression - BinaryOp <<=>>= IntType VoidType") {
    val input = """void example(){}
boolean a;
void main() {
  a = 1 < example();
}
  """
    val expected = """Type Mismatch In Expression: BinaryOp(<,IntLiteral(1),CallExpr(Id(example),List()))"""
    assert(checkCkr(input, expected, 440))
  }

  test("441 - Type Mismatch In Expression - BinaryOp +-*/ IntType VoidType") {
    val input = """int a;
    void b(){}
    void main() {
      a = 1 + b();
    }
    void example(){}"""
    val expected = """Type Mismatch In Expression: BinaryOp(+,IntLiteral(1),CallExpr(Id(b),List()))"""
    assert(checkCkr(input, expected, 441))
  }

  test("442 - Type Mismatch In Expression - BinaryOp == IntType VoidType") {
    val input = """int a;
    void b(){}
    void main() {
      a = 1 == b();
    }"""
    val expected = """Type Mismatch In Expression: BinaryOp(==,IntLiteral(1),CallExpr(Id(b),List()))"""
    assert(checkCkr(input, expected, 442))
  }

  test("443 - Type Mismatch In Expression - BinaryOp <<=>>= IntType StringType") {
    val input = """boolean a;
    void main() {
      a = 1 < "a";
    }
    void example(){}"""
    val expected = """Type Mismatch In Expression: BinaryOp(<,IntLiteral(1),StringLiteral(a))"""
    assert(checkCkr(input, expected, 443))
  }

  test("444 - Type Mismatch In Expression - BinaryOp <<=>>= IntType VoidType") {
    val input = """boolean a;
    void b(){}
    void main() {
      a = 1 < b();
    }
    void example(){}"""
    val expected = """Type Mismatch In Expression: BinaryOp(<,IntLiteral(1),CallExpr(Id(b),List()))"""
    assert(checkCkr(input, expected, 444))
  }

  test("445 - Type Mismatch In Expression - BinaryOp ||&& IntType BooleanType") {
    val input = """boolean a;
    boolean b;
    void main() {
      a = 1 || b;
    }
    void example(){}"""
    val expected = """Type Mismatch In Expression: BinaryOp(||,IntLiteral(1),Id(b))"""
    assert(checkCkr(input, expected, 445))
  }

  test("446 - Type Mismatch In Expression - BinaryOp ||&& FloatType BooleanType") {
    val input = """boolean a;
    boolean b;
    void main() {
      a = 1.0 || b;
    }
    void example(){}"""
    val expected = """Type Mismatch In Expression: BinaryOp(||,FloatLiteral(1.0),Id(b))"""
    assert(checkCkr(input, expected, 446))
  }

  test("447 - Type Mismatch In Expression - BinaryOp ||&& StringType BooleanType") {
    val input = """boolean a;
    boolean b;
    void main() {
      a = "1.0" || b;
    }
    void example(){}"""
    val expected = """Type Mismatch In Expression: BinaryOp(||,StringLiteral(1.0),Id(b))"""
    assert(checkCkr(input, expected, 447))
  }

  test("448 - Type Mismatch In Expression - BinaryOp ||&& VoidType BooleanType") {
    val input = """boolean a;
    boolean b;
    void c(){}
    void main() {
      a = c() || b;
    }
    void example(){}"""
    val expected = """Type Mismatch In Expression: BinaryOp(||,CallExpr(Id(c),List()),Id(b))"""
    assert(checkCkr(input, expected, 448))
  }

  test("449 - Type Mismatch In Expression - BinaryOp ==!= FloatType IntType") {
    val input = """boolean a;
    boolean b;
    void main() {
      a = 1.0 == b;
    }
    void example(){}"""
    val expected = """Type Mismatch In Expression: BinaryOp(==,FloatLiteral(1.0),Id(b))"""
    assert(checkCkr(input, expected, 449))
  }

  test("450 - Type Mismatch In Statement If: expr StringLiteral") {
    val input = """int a;
    void main(int b){
      if ("1.0"){
      }
    }"""
    val expected = """Type Mismatch In Statement: If(StringLiteral(1.0),Block(List(),List()),None)"""
    assert(checkCkr(input, expected, 450))
  }

  test("451 - Type Mismatch In Statement If: expr IntLiteral") {
    val input = """int a;
    void main(int b){
      if (a){
      }
    }"""
    val expected = """Type Mismatch In Statement: If(Id(a),Block(List(),List()),None)"""
    assert(checkCkr(input, expected, 451))
  }

  test("452 - Type Mismatch In Statement For: expr1 BoolLiteral") {
    val input = """int a;
    void main(int b){
      for (true; true; 1)
        return;
    }"""
    val expected = """Type Mismatch In Statement: For(BooleanLiteral(true),BooleanLiteral(true),IntLiteral(1),Return(None))"""
    assert(checkCkr(input, expected, 452))
  }

  test("453 - Type Mismatch In Statement Return") {
    val input = """int a;
    void main(int b){
      int a;
      return 2;
    }"""
    val expected = """Type Mismatch In Statement: Return(Some(IntLiteral(2)))"""
    assert(checkCkr(input, expected, 453))
  }

  test("454 - Type Mismatch In Statement Return Array pointer type") {
    val input = """int a;
    int[] main(int b[]){
      int a;
      return b;
    }"""
    val expected = """Type Mismatch In Statement: Return(Some(IntLiteral(2)))"""
    assert(checkCkr(input, expected, 454))
  }
}