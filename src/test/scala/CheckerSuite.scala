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

  test("406 - Redeclared variables") {
  val input = """void main () {}
int a;
float a;"""
  val expected = "Redeclared Variable: a"
  assert(checkCkr(input,expected,406))
  }

  test("407 - Redeclared parameter") {
  val input = """void main (int a, float a) {}
int a;
float a;"""
  val expected = "Redeclared Parameter: a"
  assert(checkCkr(input,expected,407))
  }

  test("408 - Redeclared variables") {
  val input = """void main (int b) {
int a;
float b;
}"""
  val expected = "Redeclared Variable: b"
  assert(checkCkr(input,expected,408))
  }
  
  test("409 - No entry point") {
  val input = """void foo (int b) {
int a;
float c;
}"""
  val expected = "No Entry Point"
  assert(checkCkr(input,expected,409))
  }

  test("409 - Unary expr - (-)BoolType") {
  val input = """void foo (int b) {
boolean a;
float c;
-a;
}"""
  val expected = """Type Mismatch In Expression: UnaryOp(-,Id(a))"""
  assert(checkCkr(input,expected,409))
  }

  test("409 - Unary expr - (-)BoolType with multi var in Env") {
  val input = """float b;
void main (int b) {
boolean a;
float c;
-a;
}
int a;
"""
  val expected = """Type Mismatch In Expression: UnaryOp(-,Id(a))"""
  assert(checkCkr(input,expected,409))
  }

  test("410 - Unary expr - (-)BoolType from Parameter") {
  val input = """float b;
void foo (int b) {
boolean a;
float c;
!b;
}
int a;
"""
  val expected = """Type Mismatch In Expression: UnaryOp(!,Id(b))"""
  assert(checkCkr(input,expected,410))
  }

  test("411 - Unary expr - (-)BoolType from Array") {
  val input = """float b;
void foo (int b) {
boolean a[5];
float c;
-a[1];
}
"""
  val expected = """Type Mismatch In Expression: UnaryOp(-,ArrayCell(Id(a),IntLiteral(1)))"""
  assert(checkCkr(input,expected,411))
  }

  test("412 - Unary expr - (-)IntType from Array Pointer") {
  val input = """float b;
void foo (int b[]) {
boolean a[5];
float c;
! b[1];
}
"""
  val expected = """Type Mismatch In Expression: UnaryOp(!,ArrayCell(Id(b),IntLiteral(1)))"""
  assert(checkCkr(input,expected,412))
  }

  test("413 - Unary expr - (-)BoolType from Array Pointer") {
  val input = """float a;
void main (int b[]) {
boolean a[5];
float c;
- a[1];
}
"""
  val expected = """Type Mismatch In Expression: UnaryOp(-,ArrayCell(Id(a),IntLiteral(1)))"""
  assert(checkCkr(input,expected,413))
  }

  test("414 - Unary expr - (Unary -)getInt(IntType - wrong type)") {
  val input = """float a;
void main (int b[]) {
- getInt(1);
}
"""
  val expected = """Type Mismatch In Expression: CallExpr(Id(getInt),List(IntLiteral(1)))"""
  assert(checkCkr(input,expected,414))
  }

  test("415 - Unary expr - (Unary -)putInt(IntType)") {
  val input = """float a;
void main (int b[]) {
- putInt(1);
}
"""
  val expected = """Type Mismatch In Expression: UnaryOp(-,CallExpr(Id(putInt),List(IntLiteral(1))))"""
  assert(checkCkr(input,expected,415))
  }

  test("416 - Unary expr - (Unary -)putInt(IntType)") {
  val input = """float a;
void main (int b[]) {
- putFloat(1);
}
"""
  val expected = """Type Mismatch In Expression: UnaryOp(-,CallExpr(Id(putFloat),List(IntLiteral(1))))"""
  assert(checkCkr(input,expected,416))
  }

  test("417 - BinOp expr - Unary wrong") {
  val input = """float a;
void main (int b[]) {
a + !b[0];
}
"""
  val expected = """Type Mismatch In Expression: UnaryOp(!,ArrayCell(Id(b),IntLiteral(0)))"""
  assert(checkCkr(input,expected,417))
  }

  test("418 - BinOp expr && || - Unary wrong") {
  val input = """float a;
void main (int b[]) {
a || b[0];
}
"""
  val expected = """Type Mismatch In Expression: BinaryOp(||,Id(a),ArrayCell(Id(b),IntLiteral(0)))"""
  assert(checkCkr(input,expected,418))
  }

  test("419 - BinOp expr && || > - Unary wrong") {
  val input = """float a;
void main (int b[]) {
a || b[0] > 3;
}
"""
  val expected = """Type Mismatch In Expression: BinaryOp(||,Id(a),BinaryOp(>,ArrayCell(Id(b),IntLiteral(0)),IntLiteral(3)))"""
  assert(checkCkr(input,expected,419))
  }

  test("420 - UnaryOp(-, Binop(==))") {
  val input = """float a;
void main (int b[]) {
  - (b[0] == 0);
}
"""
  val expected = """Type Mismatch In Expression: UnaryOp(-,BinaryOp(==,ArrayCell(Id(b),IntLiteral(0)),IntLiteral(0)))"""
  assert(checkCkr(input,expected,420))
  }

  test("421 - Redeclare Var in If Statement") {
  val input = """float a;
void main (int b[]) {
  if(b[0] == 0){
    int a;
    float a;
  }
}
"""
  val expected = """Redeclared Variable: a"""
  assert(checkCkr(input,expected,421))
  }

  test("422 - Type mismatch If Statement") {
  val input = """float a;
void main (int b[]) {
  if(b[0]){
    int a;
    float a;
  }
}
"""
  val expected = """Type Mismatch In Statement: If(ArrayCell(Id(b),IntLiteral(0)),Block(List(VarDecl(Id(a),IntType),VarDecl(Id(a),FloatType)),List()),None)"""
  assert(checkCkr(input,expected,422))
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

  test("454 - Type Mismatch In Expression: ArrayCell - index is StringType") {
    val input = """int a;
    int b[9];
    void main() {
      a = b["1.0"];
    }"""
    val expected = """Type Mismatch In Expression: ArrayCell(Id(b),StringLiteral(1.0))"""
    assert(checkCkr(input, expected, 454))
  }

  test("455 - Type Mismatch In Expression: ArrayCell - index is ArrayType") {
    val input = """int a;
    int b[9];
    void main() {
      a = b[b];
    }"""
    val expected = """Type Mismatch In Expression: ArrayCell(Id(b),Id(b))"""
    assert(checkCkr(input, expected, 455))
  }

  test("456 - Type Mismatch In Expression: ArrayCell - index is ArrayPointerType") {
    val input = """int a;
    int b[9];
    void main(int c[]) {
      a = b[c];  
    }"""
    val expected = """Type Mismatch In Expression: ArrayCell(Id(b),Id(c))"""
    assert(checkCkr(input, expected, 456))
  }

  test("457 - Type Mismatch In Expression: ArrayCell - index is VoidType") {
    val input = """int a;
    int b[9];
    void main(int c[]) {
      a = b[example()];  
    }
    void example(){}"""
    val expected = """Type Mismatch In Expression: ArrayCell(Id(b),CallExpr(Id(example),List()))"""
    assert(checkCkr(input, expected, 457))
  }

  test("458 - Type Mismatch In Expression: ArrayCell - arr is IntType") {
    val input = """int a;
    int b[9];
    void main(int c) {
      a = c[0];  
    }
    void example(){}"""
    val expected = """Type Mismatch In Expression: ArrayCell(Id(c),IntLiteral(0))"""
    assert(checkCkr(input, expected, 458))
  }

  test("459 - Type Mismatch In Expression: ArrayCell - arr is FloatType") {
    val input = """int a;
    int b[9];
    void main(float c) {
      a = c[1.0];  
    }
    void example(){}"""
    val expected = """Type Mismatch In Expression: ArrayCell(Id(c),FloatLiteral(1.0))"""
    assert(checkCkr(input, expected, 459))
  }

  test("460 - Type Mismatch In Expression: ArrayCell - arr is StringType") {
    val input = """int a;
    int b[9];
    void main(string c) {
      a = c["1.0"];  
    }
    void example(){}"""
    val expected = """Type Mismatch In Expression: ArrayCell(Id(c),StringLiteral(1.0))"""
    assert(checkCkr(input, expected, 460))
  }

  test("461 - Type Mismatch In Expression: ArrayCell - arr is VoidType") {
    val input = """int a;
    void main(float c) {
      a = example["1.0"];  
    }
    void example(){}"""
    val expected = """Type Mismatch In Expression: ArrayCell(Id(example),StringLiteral(1.0))"""
    assert(checkCkr(input, expected, 461))
  }

  test("462 - Type Mismatch In Expression: Id Undeclared") {
    val input = """int a;
    void main(float c) {
      b = 1;  
    }
    void example(){}"""
    val expected = """Undeclared Identifier: b"""
    assert(checkCkr(input, expected, 462))
  }

  test("463 - Type Mismatch In Expression: CallExpr - not equal number of actual parameters") {
    val input = """int a;
    void main(float c) {
      a = example(1);  
    }
    void example(){}"""
    val expected = """Type Mismatch In Expression: CallExpr(Id(example),List(IntLiteral(1)))"""
    assert(checkCkr(input, expected, 463))
  }

  test("464 - Type Mismatch In Expression: CallExpr - not equal number of actual parameters") {
    val input = """int a;
    void main(float c) {
      a = example(1);  
    }
    void example(int b, int c){}"""
    val expected = """Type Mismatch In Expression: CallExpr(Id(example),List(IntLiteral(1)))"""
    assert(checkCkr(input, expected, 464))
  }

  test("465 - Type Mismatch In Expression: CallExpr - type mismatch passing parameters") {
    val input = """int a;
    void main(float c) {
      a = example(1.0);  
    }
    void example(int b){}"""
    val expected = """Type Mismatch In Expression: CallExpr(Id(example),List(FloatLiteral(1.0)))"""
    assert(checkCkr(input, expected, 465))
  }

  test("466 - CallExpr - passing parameters success") {
    val input = """int a;
    void main(float c) {
      a = example(1);  
    }
    int example(float b){
      return 1;
    }"""
    val expected = """"""
    assert(checkCkr(input, expected, 466))
  }

  test("467 - CallExpr - passing parameters success") {
    val input = """int a[9];
    void main(float c) {
      a[1] = example(a);  
    }
    int example(int a[]){
      return 1;
    }"""
    val expected = """"""
    assert(checkCkr(input, expected, 467))
  }

  test("468 - CallExpr - passing parameters success") {
    val input = """int a[9];
    void main(int c[]) {
      a[1] = example(c);  
    }
    int example(int a[]){
      return 1;
    }"""
    val expected = """"""
    assert(checkCkr(input, expected, 468))
  }

  test("469 - UnaryOp - '!' with IntType") {
    val input = """int a;
    void main() {
      a = !1;
    }"""
    val expected = """Type Mismatch In Expression: UnaryOp(!,IntLiteral(1))"""
    assert(checkCkr(input, expected, 469))
  }

  test("470 - UnaryOp - '!' with FloatType") {
    val input = """int a;
    void main() {
      a = !1.0;
    }"""
    val expected = """Type Mismatch In Expression: UnaryOp(!,FloatLiteral(1.0))"""
    assert(checkCkr(input, expected, 470))
  }

  test("471 - UnaryOp - '!' with StringType") {
    val input = """int a;
    void main() {
      a = !"1.0";
    }"""
    val expected = """Type Mismatch In Expression: UnaryOp(!,StringLiteral(1.0))"""
    assert(checkCkr(input, expected, 471))
  }

  test("472 - UnaryOp - '-' with StringType") {
    val input = """int a;
    void main() {
      a = -"1.0";
    }"""
    val expected = """Type Mismatch In Expression: UnaryOp(-,StringLiteral(1.0))"""
    assert(checkCkr(input, expected, 472))
  }

  test("473 - UnaryOp - '-' with BooleanType") {
    val input = """int a;
    void main() {
      a = -true;
    }"""
    val expected = """Type Mismatch In Expression: UnaryOp(-,BooleanLiteral(true))"""
    assert(checkCkr(input, expected, 473))
  }

  test("474 - UnaryOp - '-' with VoidType") {
    val input = """int a;
    void main() {
      a = -example();
    }
    void example(){}"""
    val expected = """Type Mismatch In Expression: UnaryOp(-,CallExpr(Id(example),List()))"""
    assert(checkCkr(input, expected, 474))
  }

  test("475 - BinaryOp - assign - success") {
    val input = """int a;
    int b(){
      float a;
      a = c();
      return 1;
    }
    float c(){
      string a;
      a = d();
      return 2.0;
    }
    string d(){
      return "";
    }
    void main() {
      a = -b();
    }
    void example(){}"""
    val expected = """"""
    assert(checkCkr(input, expected, 475))
  }

  test("476 - Type Mismatch In Expression - BinaryOp - assign - lhs is VoidType") {
    val input = """int a;
    void b(){}
    void main() {
      b() = -a;
    }
    void example(){}"""
    val expected = """Type Mismatch In Expression: BinaryOp(=,CallExpr(Id(b),List()),UnaryOp(-,Id(a)))"""
    assert(checkCkr(input, expected, 476))
  }

  test("477 - Type Mismatch In Expression - BinaryOp - assign - lhs is ArrayType") {
    val input = """int a;
    int b[9];
    void main() {
      b = -a;
    }
    void example(){}"""
    val expected = """Type Mismatch In Expression: BinaryOp(=,Id(b),UnaryOp(-,Id(a)))"""
    assert(checkCkr(input, expected, 477))
  }

  test("478 - Type Mismatch In Expression - BinaryOp - assign - lhs is ArrayPointerType") {
    val input = """int a;
    int d[9];
    int[] b(int c[]){
      return c;
    }
    void main() {
      b(d) = -a;
    }
    void example(){}"""
    val expected = """Type Mismatch In Expression: BinaryOp(=,CallExpr(Id(b),List(Id(d))),UnaryOp(-,Id(a)))"""
    assert(checkCkr(input, expected, 478))
  }

  test("479 - Type Mismatch In Expression - BinaryOp +-*/ IntType StringType") {
    val input = """int a;
    void main() {
      a = 1 + "a";
    }
    void example(){}"""
    val expected = """Type Mismatch In Expression: BinaryOp(+,IntLiteral(1),StringLiteral(a))"""
    assert(checkCkr(input, expected, 479))
  }

  test("480 - Type Mismatch In Expression - BinaryOp +-*/ IntType BooleanType") {
    val input = """int a;
    void main() {
      a = 1 + true;
    }
    void example(){}"""
    val expected = """Type Mismatch In Expression: BinaryOp(+,IntLiteral(1),BooleanLiteral(true))"""
    assert(checkCkr(input, expected, 480))
  }

  test("481 - Type Mismatch In Expression - BinaryOp +-*/ IntType VoidType") {
    val input = """int a;
    void b(){}
    void main() {
      a = 1 + b();
    }
    void example(){}"""
    val expected = """Type Mismatch In Expression: BinaryOp(+,IntLiteral(1),CallExpr(Id(b),List()))"""
    assert(checkCkr(input, expected, 481))
  }

  test("482 - Type Mismatch In Expression - BinaryOp <<=>>= IntType BooleanType") {
    val input = """boolean a;
    void main() {
      a = 1 < true;
    }
    void example(){}"""
    val expected = """Type Mismatch In Expression: BinaryOp(<,IntLiteral(1),BooleanLiteral(true))"""
    assert(checkCkr(input, expected, 482))
  }

  test("483 - Type Mismatch In Expression - BinaryOp <<=>>= IntType StringType") {
    val input = """boolean a;
    void main() {
      a = 1 < "a";
    }
    void example(){}"""
    val expected = """Type Mismatch In Expression: BinaryOp(<,IntLiteral(1),StringLiteral(a))"""
    assert(checkCkr(input, expected, 483))
  }

  test("484 - Type Mismatch In Expression - BinaryOp <<=>>= IntType VoidType") {
    val input = """boolean a;
    void b(){}
    void main() {
      a = 1 < b();
    }
    void example(){}"""
    val expected = """Type Mismatch In Expression: BinaryOp(<,IntLiteral(1),CallExpr(Id(b),List()))"""
    assert(checkCkr(input, expected, 484))
  }

  test("485 - Type Mismatch In Expression - BinaryOp ||&& IntType BooleanType") {
    val input = """boolean a;
    boolean b;
    void main() {
      a = 1 || b;
    }
    void example(){}"""
    val expected = """Type Mismatch In Expression: BinaryOp(||,IntLiteral(1),Id(b))"""
    assert(checkCkr(input, expected, 485))
  }

  test("486 - Type Mismatch In Expression - BinaryOp ||&& FloatType BooleanType") {
    val input = """boolean a;
    boolean b;
    void main() {
      a = 1.0 || b;
    }
    void example(){}"""
    val expected = """Type Mismatch In Expression: BinaryOp(||,FloatLiteral(1.0),Id(b))"""
    assert(checkCkr(input, expected, 486))
  }

  test("487 - Type Mismatch In Expression - BinaryOp ||&& StringType BooleanType") {
    val input = """boolean a;
    boolean b;
    void main() {
      a = "1.0" || b;
    }
    void example(){}"""
    val expected = """Type Mismatch In Expression: BinaryOp(||,StringLiteral(1.0),Id(b))"""
    assert(checkCkr(input, expected, 487))
  }

  test("488 - Type Mismatch In Expression - BinaryOp ||&& VoidType BooleanType") {
    val input = """boolean a;
    boolean b;
    void c(){}
    void main() {
      a = c() || b;
    }
    void example(){}"""
    val expected = """Type Mismatch In Expression: BinaryOp(||,CallExpr(Id(c),List()),Id(b))"""
    assert(checkCkr(input, expected, 488))
  }

  test("489 - Type Mismatch In Expression - BinaryOp ==!= FloatType IntType") {
    val input = """boolean a;
    boolean b;
    void main() {
      a = 1.0 == b;
    }
    void example(){}"""
    val expected = """Type Mismatch In Expression: BinaryOp(==,FloatLiteral(1.0),Id(b))"""
    assert(checkCkr(input, expected, 489))
  }

  test("490 - Type Mismatch In Expression - BinaryOp ==!= StringType IntType") {
    val input = """boolean a;
    boolean b;
    void main() {
      a = "1.0" == b;
    }
    void example(){}"""
    val expected = """Type Mismatch In Expression: BinaryOp(==,StringLiteral(1.0),Id(b))"""
    assert(checkCkr(input, expected, 490))
  }

  test("491 - Type Mismatch In Expression - BinaryOp ==!= VoidType IntType") {
    val input = """boolean a;
    boolean b;
    void c(){}
    void main() {
      a = c() == b;
    }
    void example(){}"""
    val expected = """Type Mismatch In Expression: BinaryOp(==,CallExpr(Id(c),List()),Id(b))"""
    assert(checkCkr(input, expected, 491))
  }

  test("492 - Type Mismatch In Expression: getInt") {
    val input = "void main () {getInt(3);}"
    val expected = "Type Mismatch In Expression: CallExpr(Id(getInt),List(IntLiteral(3)))"
    assert(checkCkr(input, expected, 492))
  }

  test("493 - Undeclared Identifier: i") {
    val input = """
    int foo(int i) {
      return 200;
    }
    void main() {
      foo(i);
    }"""
    val expected = "Undeclared Identifier: i"
    assert(checkCkr(input, expected, 493))
  }

  test("494 - Undeclared Identifier: main") {
    val input = """
    int i;
    int f() {
      return 200;
    }
    void main() {
      int i;
      main = f();
    }"""
    val expected = "Undeclared Identifier: main"
    assert(checkCkr(input, expected, 494))
  }

  test("495 - Redeclared function after declared variable") {
    val input = """
    int a;
    int b;
    float d;
    void m() {int n;}
    void n() {int c;}
    float c(int a, int b) { return 1.0; }
    void d() {}
    void main() {
      return;
    }"""
    val expect = """Redeclared Function: d"""
    assert(checkCkr(input, expect, 495))
  }

  test("496 - Undeclared Function: funy") {
    val input = """int a;
    int b;
    int foo(int a) {
      if (a > b) a = 1 + b;
      else a = b + 2;
      return a;
    }
    int foo1(int a){
      int b;
      int c;
      int d;
      b = 2;
      c = 3;
      if (a > b)
        d = a + c;
      else 
        d = b + foo(1);
      return d;
    }
    void main() {
      funy(4);
      return 1;
    }"""
    val expect = """Undeclared Function: funy"""
    assert(checkCkr(input, expect, 496))
  }

  test("497 - Type Mismatch In Statement return") {
    val input = """int a;
    int b;
    int foo(int a) {
      if (a > b) a = 1 + b;
      else a = b + 2;
      return a;
    }
    int foo1(int a){
      int b;
      int c;
      int d;
      b = 2;
      c = 3;
      if (a > b)
        d = a + c;
      else 
        d = b + foo(1);
      return d;
    }
    void main() {
      foo(4);
      return 1;
    }"""
    val expect = """Type Mismatch In Statement: Return(Some(IntLiteral(1)))"""
    assert(checkCkr(input, expect, 497))
  }

  test("498 - 16") {
    val input = """
    int foo(){
      return 1;
    }
    int foo1(){
      return 1.0;
    }
    void main() {
      return ;
    }"""
    val expect = """Type Mismatch In Statement: Return(Some(FloatLiteral(1.0)))"""
    assert(checkCkr(input, expect, 498))
  }

  test("499 - Type Mismatch In Statement return") {
    val input = """
    boolean foo(){
      return 2 > 1;
    }
    boolean foo1(int a){
      return a == 1;
    }
    boolean foo2(int a){
      return a;
    }
    void main() {
      return;
    }"""
    val expect = """Type Mismatch In Statement: Return(Some(Id(a)))"""
    assert(checkCkr(input, expect, 499))
  }

  test("500 - Type Mismatch In Expression ArrayCell") {
    val input = """
    int a;
    int b;
    int c;
    boolean d;
    float e;
    int m[100];
    int foo(){
      return 0;
    }
    void main(){
      d = true;
      a = m[0] + 1;
      c = m[d] + 1;
      return;
    }"""
    val expect = """Type Mismatch In Expression: ArrayCell(Id(m),Id(d))"""
    assert(checkCkr(input, expect, 500))
  }

}