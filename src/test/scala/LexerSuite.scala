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
    val expect = """a,=,"string lit \n \r \t bef",;,<EOF>"""
    assert(checkLex(input,expect,7))
  }
}