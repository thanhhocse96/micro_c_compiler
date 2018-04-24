import org.scalatest.FunSuite
import mc.utils._

/**
  * Created by nhphung on 4/29/17.
  Edit by HQThanh
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

  test("212 - Simple many var declares with c is Array type - type String") {
    val input = """string a, b;
    int c[1];"""
    val expected = Program(List(VarDecl(Id("a"),StringType),VarDecl(Id("b"),StringType),VarDecl(Id("c"),ArrayType(IntLiteral(1),IntType))))
    assert(checkAst(input,expected,212))
  }

  test("213 - a simple program with declare part in main") {
    val input = "void main () {int a;}"
    val expected = Program(List(FuncDecl(Id("main"),List(),VoidType,Block(List(VarDecl(Id("a"),IntType)),List()))))
    assert(checkAst(input,expected,213))
  }

  test("214 - a simple program with many declare parts in main") {
    val input = "void main () {int a, b;}"
    val expected = Program(List(FuncDecl(Id("main"),List(),VoidType,Block(List(VarDecl(Id("a"),IntType),VarDecl(Id("b"),IntType)),List()))))
    assert(checkAst(input,expected,214))
  }

  test("215 - a simple program with many declare parts in main") {
    val input = "void main () {int a, b; string c;}"
    val expected = Program(List(FuncDecl(Id("main"),List(),VoidType,Block(List(VarDecl(Id("a"),IntType),VarDecl(Id("b"),IntType),VarDecl(Id("c"),StringType)),List()))))
    assert(checkAst(input,expected,215))
  }
  
  test("216 - a simple program with declare array part in main") {
    val input = "void main () {int a[3];}"
    val expected = Program(List(FuncDecl(Id("main"),List(),VoidType,Block(List(VarDecl(Id("a"),ArrayType(IntLiteral(3),IntType))),List()))))
    assert(checkAst(input,expected,216))
  }

  test("217 - a simple program with declare array part in main") {
    val input = "void main () {int a[3];string b[1];}"
    val expected = Program(List(FuncDecl(Id("main"),List(),VoidType,Block(List(VarDecl(Id("a"),ArrayType(IntLiteral(3),IntType)),VarDecl(Id("b"),ArrayType(IntLiteral(1),StringType))),List()))))
    assert(checkAst(input,expected,217))
  }
  
  test("218 - a simple program with declare array part in foo function & main - array pointer type ") {
    val input = """void foo () {int a[3];string b[1];}
int [] main(){} """
    val expected = Program(List(FuncDecl(Id("foo"),List(),VoidType,Block(List(VarDecl(Id("a"),ArrayType(IntLiteral(3),IntType)),VarDecl(Id("b"),ArrayType(IntLiteral(1),StringType))),List())),FuncDecl(Id("main"),List(),ArrayPointerType(IntType),Block(List(),List()))))
    assert(checkAst(input,expected,218))
  }

  // Test Expression
  test("219 - a simple math expression + & *") {
    val input = """void main () {
a = b + c;
a = b * c;}"""
    val expected = Program(List(FuncDecl(Id("main"),List(),VoidType,Block(List(),List(BinaryOp("=",Id("a"),BinaryOp("+",Id("b"),Id("c"))),BinaryOp("=",Id("a"),BinaryOp("*",Id("b"),Id("c"))))))))
    assert(checkAst(input,expected,219))
  }

  test("220 - a simple math expression / %") {
    val input = """void main () {
a = b / c;
a = b % c;}"""
    val expected = Program(List(FuncDecl(Id("main"),List(),VoidType,Block(List(),List(BinaryOp("=",Id("a"),BinaryOp("/",Id("b"),Id("c"))),BinaryOp("=",Id("a"),BinaryOp("%",Id("b"),Id("c"))))))))
    assert(checkAst(input,expected,220))
  }

  test("221 - a simple math expression && ||") {
    val input = """void main () {
a = b && c;
a = b || c;}"""
    val expected = Program(List(FuncDecl(Id("main"),List(),VoidType,Block(List(),List(BinaryOp("=",Id("a"),BinaryOp("&&",Id("b"),Id("c"))),BinaryOp("=",Id("a"),BinaryOp("||",Id("b"),Id("c"))))))))
    assert(checkAst(input,expected,221))
  }

  test("222 - a simple math expression >= & <") {
    val input = """void main () {
a = b >= c;
a = b < c;}"""
    val expected = Program(List(FuncDecl(Id("main"),List(),VoidType,Block(List(),List(BinaryOp("=",Id("a"),BinaryOp(">=",Id("b"),Id("c"))),BinaryOp("=",Id("a"),BinaryOp("<",Id("b"),Id("c"))))))))
    assert(checkAst(input,expected,222))
  }

  test("223 - a simple math expression == & !=") {
    val input = """void main () {
a = b == c;
a = b != c;}"""
    val expected = Program(List(FuncDecl(Id("main"),List(),VoidType,Block(List(),List(BinaryOp("=",Id("a"),BinaryOp("==",Id("b"),Id("c"))),BinaryOp("=",Id("a"),BinaryOp("!=",Id("b"),Id("c"))))))))
    assert(checkAst(input,expected,223))
  }

  test("224 - a simple math expression - & !") {
    val input = """void main () {
a = - c;
a = !c;}"""
    val expected = Program(List(FuncDecl(Id("main"),List(),VoidType,Block(List(),List(BinaryOp("=",Id("a"),UnaryOp("-",Id("c"))),BinaryOp("=",Id("a"),UnaryOp("!",Id("c"))))))))
    assert(checkAst(input,expected,224))
  }

  test("225 - Expression statement - Index expression") {
    val input = """void main () {a[9];}"""
    val expected = Program(List(FuncDecl(Id("main"), List(), VoidType, Block(List(), List(ArrayCell(Id("a"), IntLiteral(9)))))))
    assert(checkAst(input, expected, 225))
  }

  test("226 - Expression statement - Index expression") {
    val input = """void main () {a[b[9]];}"""
    val expected = Program(List(FuncDecl(Id("main"), List(), VoidType, Block(List(), List(ArrayCell(Id("a"), ArrayCell(Id("b"), IntLiteral(9))))))))
    assert(checkAst(input, expected, 226))
  }

  test("227 - Expression statement - Invocation expression with parameters") {
    val input = """void main () {foo(9,9);}"""
    val expected = Program(List(FuncDecl(Id("main"), List(), VoidType, Block(List(), List(CallExpr(Id("foo"), List(IntLiteral(9), IntLiteral(9))))))))
    assert(checkAst(input, expected, 227))
  }

  test("228 - Expression ||") {
    val input = """void main () { a || b || c;}"""
    val expected = Program(List(FuncDecl(Id("main"), List(), VoidType, Block(List(), List(BinaryOp("||", BinaryOp("||", Id("a"), Id("b")), Id("c")))))))
    assert(checkAst(input, expected, 228))
  }

  test("229 - Expression ==") {
    val input = """void main () {a + b == c + d;}"""
    val expected = Program(List(FuncDecl(Id("main"), List(), VoidType, Block(List(), List(BinaryOp("==", BinaryOp("+", Id("a"), Id("b")), BinaryOp("+", Id("c"), Id("d"))))))))
    assert(checkAst(input, expected, 229))
  }

  test("230 - Expression <") {
    val input = """void main () {a + b < c + d;}"""
    val expected = Program(List(FuncDecl(Id("main"), List(), VoidType, Block(List(), List(BinaryOp("<", BinaryOp("+", Id("a"), Id("b")), BinaryOp("+", Id("c"), Id("d"))))))))
    assert(checkAst(input, expected, 230))
  }

  test("231 - Expression +") {
    val input = """void main () {a + b + c;}"""
    val expected = Program(List(FuncDecl(Id("main"), List(), VoidType, Block(List(), List(BinaryOp("+", BinaryOp("+", Id("a"), Id("b")), Id("c")))))))
    assert(checkAst(input, expected, 231))
  }

  test("232 - Expression Not") {
    val input = """void main () {!!a;}"""
    val expected = Program(List(FuncDecl(Id("main"), List(), VoidType, Block(List(), List(UnaryOp("!", UnaryOp("!", Id("a"))))))))
    assert(checkAst(input, expected, 232))
  }

  test("233 - Expression mix && and ==") {
    val input = """void main () {a && b == c;}"""
    val expected = Program(List(FuncDecl(Id("main"), List(), VoidType, Block(List(), List(BinaryOp("&&", Id("a"), BinaryOp("==", Id("b"), Id("c"))))))))
    assert(checkAst(input, expected, 233))
  }

  test("234 - Expression mix Invocation expression") {
    val input = """void main () {a + foo(9);}"""
    val expected = Program(List(FuncDecl(Id("main"), List(), VoidType, Block(List(), List(BinaryOp("+", Id("a"), CallExpr(Id("foo"), List(IntLiteral(9)))))))))
    assert(checkAst(input, expected, 234))
  }

  test("235 - Expression mix * and negative") {
    val input = """void main () {a * -b;}"""
    val expected = Program(List(FuncDecl(Id("main"), List(), VoidType, Block(List(), List(BinaryOp("*", Id("a"), UnaryOp("-", Id("b"))))))))
    assert(checkAst(input, expected, 235))
  }

  test("236 - Expression mix with ()") {
    val input = """void main () {a * (b + c);}"""
    val expected = Program(List(FuncDecl(Id("main"), List(), VoidType, Block(List(), List(BinaryOp("*", Id("a"), BinaryOp("+", Id("b"), Id("c"))))))))
    assert(checkAst(input, expected, 236))
  }

  test("236 - Expression mix () with  negative") {
    val input = """void main () {-a - -(b + c);}"""
    val expected = Program(List(FuncDecl(Id("main"), List(), VoidType, Block(List(), List(BinaryOp("-", UnaryOp("-", Id("a")), UnaryOp("-", BinaryOp("+", Id("b"), Id("c")))))))))
    assert(checkAst(input, expected, 236))
  }
  
  test("237 - Expression statement - Invocation expression with a parameter") {
    val input = """void main () {foo(9);}"""
    val expected = Program(List(FuncDecl(Id("main"), List(), VoidType, Block(List(), List(CallExpr(Id("foo"), List(IntLiteral(9))))))))
    assert(checkAst(input, expected, 237))
  }

  test("238 - Expression statement - array call with foo") {
    val input = """void main () {foo(2, a)[3];}"""
    val expected = Program(List(FuncDecl(Id("main"), List(), VoidType, Block(List(), List(
      ArrayCell(CallExpr(Id("foo"),List(IntLiteral(2),Id("a"))),IntLiteral(3)))))))
    assert(checkAst(input, expected, 238))  
  }

  test("239 - Expression statement - Invocation expression with index expression") {
    val input = """void main () {
      foo(2)[3+x] = a[b[2]] + 3;
    }"""
    val expected = Program(List(FuncDecl(Id("main"), List(), VoidType, Block(List(),
      List(BinaryOp("=",
        ArrayCell(CallExpr(Id("foo"), List(IntLiteral(2))), BinaryOp("+", IntLiteral(3), Id("x"))),
        BinaryOp("+", ArrayCell(Id("a"), ArrayCell(Id("b"), IntLiteral(2))), IntLiteral(3))))))))
    assert(checkAst(input, expected, 239))
  }

  // If Stmt  
  test("240 - If statement and else") {
    val input = """void main () {
      if (a) 
        b = 9;
      else
        b = 1;
    }"""
    val expected = Program(List(FuncDecl(Id("main"), List(), VoidType, Block(List(), List(If(Id("a"), BinaryOp("=", Id("b"), IntLiteral(9)), Some(BinaryOp("=", Id("b"), IntLiteral(1)))))))))
    assert(checkAst(input, expected, 240))
  }

  test("241 - If statement no else") {
    val input = """void main () {
      if (a) b = 9; 
    }"""
    val expected = Program(List(FuncDecl(Id("main"), List(), VoidType, Block(List(), List(If(Id("a"), BinaryOp("=", Id("b"), IntLiteral(9)), None))))))
    assert(checkAst(input, expected, 241))
  }

  test("242 - Nested If statement") {
    val input = """void main () {
      if (true)
        if (true)
          a = b;
        else
          b = c;
    }"""
    val expected = Program(List(FuncDecl(Id("main"), List(), VoidType, Block(List(), List(
      If(BooleanLiteral(true),
        If(BooleanLiteral(true),
          BinaryOp("=", Id("a"), Id("b")),
          Some(BinaryOp("=", Id("b"), Id("c")))),
        None))))))
    assert(checkAst(input, expected, 242))
  }

  test("243 - Nested If statement") {
    val input = """void main () {
      if (true)
        if (true)
          a = b;
        else
          if (true)
            a = b;
          else
            a = b;
      else
        if (true)
          a = b;
    }"""
    val expected = Program(List(FuncDecl(Id("main"), List(), VoidType, Block(List(), List(
      If(BooleanLiteral(true),
        If(BooleanLiteral(true),
          BinaryOp("=", Id("a"), Id("b")),
          Some(If(BooleanLiteral(true),
            BinaryOp("=", Id("a"), Id("b")),
            Some(BinaryOp("=", Id("a"), Id("b")))))),
        Some(If(BooleanLiteral(true),
          BinaryOp("=", Id("a"), Id("b")),
          None))))))))
    assert(checkAst(input, expected, 243))
  }

  test("244 - For statement with a statement") {
    val input = """void main () {
      for (i = 0; i < 10; i = i + 1)
        a = a + 9;
    }"""
    val expected = Program(List(FuncDecl(Id("main"), List(), VoidType, Block(List(), List(
      For(BinaryOp("=", Id("i"), IntLiteral(0)),
        BinaryOp("<", Id("i"), IntLiteral(10)),
        BinaryOp("=", Id("i"), BinaryOp("+", Id("i"), IntLiteral(1))),
        BinaryOp("=", Id("a"), BinaryOp("+", Id("a"), IntLiteral(9)))))))))
    assert(checkAst(input, expected, 244))
  }

  test("245 - For statement with block statement") {
    val input = """void main () {
      for (i = 0; i < 10; i = i + 1) {
        a = a + 9;
        b = b + 9;
      }
    }"""
    val expected = Program(List(FuncDecl(Id("main"), List(), VoidType, Block(List(), List(
      For(BinaryOp("=", Id("i"), IntLiteral(0)),
        BinaryOp("<", Id("i"), IntLiteral(10)),
        BinaryOp("=", Id("i"), BinaryOp("+", Id("i"), IntLiteral(1))),
        Block(List(), List(BinaryOp("=", Id("a"), BinaryOp("+", Id("a"), IntLiteral(9))), BinaryOp("=", Id("b"), BinaryOp("+", Id("b"), IntLiteral(9)))))))))))
    assert(checkAst(input, expected, 245))
  }

  test("245 - For statement with block statement with break") {
    val input = """void main () {
      for (i = 0; i < 10; i = i + 1) {
        a = a + 9;
        b = b + 9;
        break;
      }
    }"""
    val expected = Program(List(FuncDecl(Id("main"), List(), VoidType, Block(List(), List(
      For(BinaryOp("=", Id("i"), IntLiteral(0)),
        BinaryOp("<", Id("i"), IntLiteral(10)),
        BinaryOp("=", Id("i"), BinaryOp("+", Id("i"), IntLiteral(1))),
        Block(List(), List(BinaryOp("=", Id("a"), BinaryOp("+", Id("a"), IntLiteral(9))), BinaryOp("=", Id("b"), BinaryOp("+", Id("b"), IntLiteral(9))),Break))))))))
    assert(checkAst(input, expected, 245))
  }

  test("245 - For statement with block statement with continue") {
    val input = """void main () {
      for (i = 0; i < 10; i = i + 1) {
        a = a + 9;
        break;
      }
    }"""
    val expected = Program(List(FuncDecl(Id("main"), List(), VoidType, Block(List(), List(
      For(BinaryOp("=", Id("i"), IntLiteral(0)),
        BinaryOp("<", Id("i"), IntLiteral(10)),
        BinaryOp("=", Id("i"), BinaryOp("+", Id("i"), IntLiteral(1))),
        Block(List(), List(BinaryOp("=", Id("a"), BinaryOp("+", Id("a"), IntLiteral(9))),Break))))))))
    assert(checkAst(input, expected, 245))
  }

  test("246 - For statement with 2 statement") {
    val input = """void main () {
      for (i = 0; i < 10; i = i + 1)
        a = a + 9;
      b = 9;
    }"""
    val expected = Program(List(FuncDecl(Id("main"), List(), VoidType, Block(List(), List(
      For(BinaryOp("=", Id("i"), IntLiteral(0)),
        BinaryOp("<", Id("i"), IntLiteral(10)),
        BinaryOp("=", Id("i"), BinaryOp("+", Id("i"), IntLiteral(1))),
        BinaryOp("=", Id("a"), BinaryOp("+", Id("a"), IntLiteral(9)))),
      BinaryOp("=", Id("b"), IntLiteral(9)))))))
    assert(checkAst(input, expected, 246))
  }

  test("247 - For statement with For inside") {
    val input = """void main () {
      for (i = 0; i < 10; i = i + 1)
        for (i = 0; i < 10; i = i + 1)
          b =a + 9;
    }"""
    val expected = Program(List(FuncDecl(Id("main"), List(), VoidType, Block(List(), List(
      For(BinaryOp("=", Id("i"), IntLiteral(0)),
        BinaryOp("<", Id("i"), IntLiteral(10)),
        BinaryOp("=", Id("i"), BinaryOp("+", Id("i"), IntLiteral(1))),
        For(BinaryOp("=", Id("i"), IntLiteral(0)),
          BinaryOp("<", Id("i"), IntLiteral(10)),
          BinaryOp("=", Id("i"), BinaryOp("+", Id("i"), IntLiteral(1))),
          BinaryOp("=", Id("b"), BinaryOp("+", Id("a"), IntLiteral(9))))),
    )))))
    assert(checkAst(input, expected, 246))
  }

  test("248 - Dowhile statement with a statement") {
    val input = """void main () {
      do
        a = 9;
      while(true);
    }"""
    val expected = Program(List(FuncDecl(Id("main"), List(), VoidType, Block(List(), List(Dowhile(List(BinaryOp("=", Id("a"), IntLiteral(9))), BooleanLiteral(true)))))))
    assert(checkAst(input, expected, 248))
  }

  test("249 - Dowhile statement with statements") {
    val input = """void main () {
      do
        a = 9;
        b = 9;
      while(true);
    }"""
    val expected = Program(List(FuncDecl(Id("main"), List(), VoidType, Block(List(), List(Dowhile(List(BinaryOp("=", Id("a"), IntLiteral(9)), BinaryOp("=", Id("b"), IntLiteral(9))), BooleanLiteral(true)))))))
    assert(checkAst(input, expected, 249))
  }

  test("250 - Dowhile statement with statements (return)") {
    val input = """void main () {
      do
        a = 9;
        return;
      while(true);
    }"""
    val expected = Program(List(FuncDecl(Id("main"), List(), VoidType, Block(List(), List(
      Dowhile( 
        List(
          BinaryOp("=", Id("a"), IntLiteral(9)),
          Return(None)
        ),
        BooleanLiteral(true)))))))
    assert(checkAst(input, expected, 250))
  }

  test("251 - Dowhile statement with statements (for & return)") {
    val input = """void main () {
      do
        a = 9;
        for (i = 0; i < 10; i = i + 1)
          return ;
        b = a + 9;
      while(true);
    }"""
    val expected = Program(List(FuncDecl(Id("main"), List(), VoidType, Block(List(), List(
      Dowhile( 
        List(
          BinaryOp("=", Id("a"), IntLiteral(9)),
          For(BinaryOp("=", Id("i"), IntLiteral(0)),
            BinaryOp("<", Id("i"), IntLiteral(10)),
            BinaryOp("=", Id("i"), BinaryOp("+", Id("i"), IntLiteral(1))),
            Return(None)),
          BinaryOp("=", Id("b"), BinaryOp("+", Id("a"), IntLiteral(9)))
        ),
        BooleanLiteral(true)))))))
    assert(checkAst(input, expected, 251))
  }

  test("252 - Dowhile statement with statements (for & return(expression))") {
    val input = """void main () {
      do
        for (i = 0; i < 10; i = i + 1)
          return a + 9;
        b = a + 9;
      while(true);
    }"""
    val expected = Program(List(FuncDecl(Id("main"), List(), VoidType, Block(List(), List(
      Dowhile( 
        List(          
          For(BinaryOp("=", Id("i"), IntLiteral(0)),
            BinaryOp("<", Id("i"), IntLiteral(10)),
            BinaryOp("=", Id("i"), BinaryOp("+", Id("i"), IntLiteral(1))),
            Return(Some(BinaryOp("+", Id("a"), IntLiteral(9))))),
          BinaryOp("=", Id("b"), BinaryOp("+", Id("a"), IntLiteral(9)))
        ),
        BooleanLiteral(true)))))))
    assert(checkAst(input, expected, 252))
  }

  test("253 - Expression mix Invocation expression") {
    val input = """void main () {a + foo(9);}"""
    val expected = Program(List(FuncDecl(Id("main"), List(), VoidType, Block(List(), List(BinaryOp("+", Id("a"), CallExpr(Id("foo"), List(IntLiteral(9)))))))))
    assert(checkAst(input, expected, 253))
  }
  test("254 - Expression mix () and Index expression") {
    val input = """void main () {a[9] + (b + c);}"""
    val expected = Program(List(FuncDecl(Id("main"), List(), VoidType, Block(List(), List(BinaryOp("+", ArrayCell(Id("a"), IntLiteral(9)), BinaryOp("+", Id("b"), Id("c"))))))))
    assert(checkAst(input, expected, 254))
  }
}
