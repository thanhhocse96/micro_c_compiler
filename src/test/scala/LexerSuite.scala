import org.scalatest.FunSuite

/**
  * Created by nhphung on 4/28/17.
  */
class LexerSuite extends FunSuite with TestLexer {

  test("001 - A simple identifier") {
    val input = "abc"
    val expect = "abc,<EOF>"
    assert(checkLex(input,expect,1))
  }

  test("002 - Half function declare") {
    val input = "main int {"
    val expect = """main,int,{,<EOF>"""
    assert(checkLex(input,expect,2))
  }

  test("003 - Open and close parentheses"){
    val input = "} int main {"
    val expect = """},int,main,{,<EOF>"""
    assert(checkLex(input,expect,3))
  }

  test("004 - Block comment"){
    val input = """/*
comment $#@!``043//kldsauheu \n \r
llsiajssa(()))//pjsidj*/
int main {}"""
    val expect = """int,main,{,},<EOF>"""
    assert(checkLex(input,expect,4))
  }

  test("005 - Block comment & line comment - no error"){
    val input = """/*block-comment 123
456790 abcxyz*/
//line comment \n \n
int main()"""
    val expect = """int,main,(,),<EOF>"""
    assert(checkLex(input,expect,5))
  }

  test("006 - Boolean literal - no error"){
    val input = """boolean a;
a = true;
a = false;"""
    val expect = """boolean,a,;,a,=,true,;,a,=,false,;,<EOF>"""
    assert(checkLex(input,expect,6))
  }

  test("007 - String literal - no error"){
    val input = """a = "string lit \n \r \t bef";"""
    val expect = """a,=,string lit \n \r \t bef,;,<EOF>"""
    assert(checkLex(input,expect,7))
  }

  test("008 - Operator testing - no error"){
    val input = """a = b + c - a / 3 * 4;
b >= a || b && c == a;"""
    val expect = """a,=,b,+,c,-,a,/,3,*,4,;,b,>=,a,||,b,&&,c,==,a,;,<EOF>"""
    assert(checkLex(input,expect,8))
  }

  test("009 - Boolean & int literal - no error"){
    val input = """a = true;
b = false;
c = 0;
d = 1;
e == 10;"""
    val expect = """a,=,true,;,b,=,false,;,c,=,0,;,d,=,1,;,e,==,10,;,<EOF>"""
    assert(checkLex(input,expect,9))
  }

  test("010 - Float literal - no error"){
    val input = """a = 1.2;
b = 0.;
c = .9;
d = .9223e3;
e == 1.e-4;
f = 3.444e-0;"""
    val expect = """a,=,1.2,;,b,=,0.,;,c,=,.9,;,d,=,.9223e3,;,e,==,1.e-4,;,f,=,3.444e-0,;,<EOF>"""
    assert(checkLex(input,expect,10))
  }

  test("011 - Not Float literal - error token - no fractional part"){
    val input = """a = .e-10;"""
    val expect = """a,=,ErrorToken ."""
    assert(checkLex(input,expect,11))
  }

  test("012 - Not Float literal - No digit after exponent"){
    val input = """a = 143e;"""
    val expect = """a,=,143,e,;,<EOF>"""
    assert(checkLex(input,expect,12))
  }

  test("013 - String with [enter] - illegal escape"){
    val input = """a = "The string
is poo";"""
    val expect = """a,=,Illegal escape in string: The string"""
    assert(checkLex(input, expect, 13))
  }
  
  test("014 - Unclosed string"){
    val input = """a = "string;"""
    val expect = """a,=,Unclosed string: string;"""
    assert(checkLex(input, expect, 14))
  }
}