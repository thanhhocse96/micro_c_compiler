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

  test("015 - test INTLIT 2") {
    val input = "999"
    val expect = "999,<EOF>"
    assert(checkLex(input,expect,15))
  }
  test("016 - test INTLIT 3") {
    val input = "999999"
    val expect = "999999,<EOF>"
    assert(checkLex(input,expect,16))
  }
  test("017 - test FLOATLIT 1") {
    val input = "1.2"
    val expect = "1.2,<EOF>"
    assert(checkLex(input,expect,17))
  }
  test("018 - test FLOATLIT 2") {
    val input = "1."
    val expect = "1.,<EOF>"
    assert(checkLex(input,expect,18))
  }
  test("019 - test FLOATLIT 3") {
    val input = ".1"
    val expect = ".1,<EOF>"
    assert(checkLex(input,expect,19))
  }
  test("020 - test FLOATLIT 4") {
    val input = "1e2"
    val expect = "1e2,<EOF>"
    assert(checkLex(input,expect,20))
  }
  test("021 - test FLOATLIT 5") {
    val input = "1.2E-2"
    val expect = "1.2E-2,<EOF>"
    assert(checkLex(input,expect,21))
  }
  test("022 - test FLOATLIT 6") {
    val input = "1.2e-2"
    val expect = "1.2e-2,<EOF>"
    assert(checkLex(input,expect,22))
  }
  test("023 - test FLOATLIT 7") {
    val input = ".1E2"
    val expect = ".1E2,<EOF>"
    assert(checkLex(input,expect,23))
  }
  test("024 - test FLOATLIT 8") {
    val input = "9.0"
    val expect = "9.0,<EOF>"
    assert(checkLex(input,expect,24))
  }
  test("025 - test FLOATLIT 9") {
    val input = "12e8"
    val expect = "12e8,<EOF>"
    assert(checkLex(input,expect,25))
  }
  test("026 - test FLOATLIT 10") {
    val input = "0.33E-3"
    val expect = "0.33E-3,<EOF>"
    assert(checkLex(input,expect,26))
  }
  test("027 - test FLOATLIT 11") {
    val input = "128e-42"
    val expect = "128e-42,<EOF>"
    assert(checkLex(input,expect,27))
  }
  test("028 - test FLOATLIT 12") {
    val input = "1.e-1"
    val expect = "1.e-1,<EOF>"
    assert(checkLex(input,expect,28))
  }
  test("029 - test BOOLIT 1") {
    val input = "true"
    val expect = "true,<EOF>"
    assert(checkLex(input,expect,29))
  }
  test("030 - test BOOLIT 2") {
    val input = "false"
    val expect = "false,<EOF>"
    assert(checkLex(input,expect,30))
  }
  test("031 - test BOOLIT 3") {
    val input = "true false"
    val expect = "true,false,<EOF>"
    assert(checkLex(input,expect,31))
  }
  test("032 - test KEYWORD 1") {
    val input = "main boolean break continue else for float if int return void do while true false string"
    val expect = "main,boolean,break,continue,else,for,float,if,int,return,void,do,while,true,false,string,<EOF>"
    assert(checkLex(input,expect,32))
  }
  test("033 - test OPERATOR 1") {
    val input = "+ - * / % ! || && == != < > <= >= ="
    val expect = "+,-,*,/,%,!,||,&&,==,!=,<,>,<=,>=,=,<EOF>"
    assert(checkLex(input,expect,33))
  }
  test("034 - test SEPARATOR 1") {
    val input = "( ) [ ] { } ; ,"
    val expect = "(,),[,],{,},;,,,<EOF>"
    assert(checkLex(input,expect,34))
  }
  test("035 - test SRINGLIT 1") {
    val input = "\"\""
    val expect = ",<EOF>"
    assert(checkLex(input,expect,35))
  }
  test("036 - test SRINGLIT 2") {
    val input = "\"s\""
    val expect = "s,<EOF>"
    assert(checkLex(input,expect,36))
  }
  test("037 - test SRINGLIT 3") {
    val input = "\"sss\""
    val expect = "sss,<EOF>"
    assert(checkLex(input,expect,37))
  }
  test("038 - test SRINGLIT 4") {
    val input = "\"sss \\b \\f \\r \\n \\t \\\' \\\" \\\\\""
    val expect = "sss \\b \\f \\r \\n \\t \\\' \\\" \\\\,<EOF>"
    assert(checkLex(input,expect,38))
  }
  test("039 - test Identifier 1") {
    val input = "sss"
    val expect = "sss,<EOF>"
    assert(checkLex(input,expect,39))
  }
  test("040 - test Identifier 2") {
    val input = "sss_"
    val expect = "sss_,<EOF>"
    assert(checkLex(input,expect,40))
  }
  test("041 - test Identifier 3") {
    val input = "sss_999"
    val expect = "sss_999,<EOF>"
    assert(checkLex(input,expect,41))
  }
  test("042 - test Identifier 4") {
    val input = "sss999_"
    val expect = "sss999_,<EOF>"
    assert(checkLex(input,expect,42))
  }
  test("043 - test Identifier 5") {
    val input = "_sss"
    val expect = "_sss,<EOF>"
    assert(checkLex(input,expect,43))
  }
  test("044 - test Identifier 6") {
    val input = "_sss_"
    val expect = "_sss_,<EOF>"
    assert(checkLex(input,expect,44))
  }
  test("045 - test Identifier 7") {
    val input = "_sss_999"
    val expect = "_sss_999,<EOF>"
    assert(checkLex(input,expect,45))
  }
  test("046 - test Identifier 8") {
    val input = "_sss999_"
    val expect = "_sss999_,<EOF>"
    assert(checkLex(input,expect,46))
  }
  test("047 - test Identifier 9") {
    val input = "_"
    val expect = "_,<EOF>"
    assert(checkLex(input,expect,47))
  }
  test("048 - test Unclosed string 1") {
    val input = "\"s"
    val expect = "Unclosed string: s"
    assert(checkLex(input,expect,48))
  }
  test("049 - test Unclosed string 2") {
    val input = "\"s\n"
    val expect = "Unclosed string: s"
    assert(checkLex(input,expect,49))
  }
  test("050 - test Illegal escape 1") {
    val input = "\"\\a\""
    val expect = "Illegal escape in string: \\a"
    assert(checkLex(input,expect,50))
  }
  test("051 - test Illegal escape 2") {
    val input = "\"s\\a\""
    val expect = "Illegal escape in string: s\\a"
    assert(checkLex(input,expect,51))
  }
  test("052 - test Illegal escape 3") {
    val input = "\"\\\""
    val expect = "Unclosed string: \\\""
    assert(checkLex(input,expect,52))
  }
  test("053 - test Error token 1") {
    val input = "12#12"
    val expect = "12,ErrorToken #"
    assert(checkLex(input,expect,53))
  }
  test("054 - test Others 1") {
    val input = "_123 a_123 1_2adv"
    val expect = "_123,a_123,1,_2adv,<EOF>"
    assert(checkLex(input,expect,54))
  }
  test("055 - test Others 2") {
    val input = "/*comment ne /*nest ne*/ end */ abcxyz"
    val expect = "end,*,/,abcxyz,<EOF>"
    assert(checkLex(input,expect,55))
  }
  test("056 - test Others 3") {
    val input = "/* fdsd /* */"
    val expect = "<EOF>"
    assert(checkLex(input,expect,56))
  }
  test("057 - test Others 4") {
    val input = "/*/**/*/"
    val expect = "*,/,<EOF>"
    assert(checkLex(input,expect,57))
  }
  test("058 - test Others 5") {
    val input = "/*/**/*/"
    val expect = "*,/,<EOF>"
    assert(checkLex(input,expect,58))
  }
  test("059 - test Others 6") {
    val input = "float f = 1 . 0 ;"
    val expect = "float,f,=,1,ErrorToken ."
    assert(checkLex(input,expect,59))
  }
  test("060 - test Others 7") {
    val input = "float f ;"
    val expect = "float,f,;,<EOF>"
    assert(checkLex(input,expect,60))
  }
  test("061 - test Others 8") {
    val input = "int i [ ] ;"
    val expect = "int,i,[,],;,<EOF>"
    assert(checkLex(input,expect,61))
  }
  test("062 - test Others 9") {
    val input = "int i [ 5 ] ;"
    val expect = "int,i,[,5,],;,<EOF>"
    assert(checkLex(input,expect,62))
  }
  test("063 - test Others 10") {
    val input = "int i [ 5 ] ; //Corect"
    val expect = "int,i,[,5,],;,<EOF>"
    assert(checkLex(input,expect,63))
  }
  test("064 - test Others 11") {
    val input = "Program Structure"
    val expect = "Program,Structure,<EOF>"
    assert(checkLex(input,expect,64))
  }
  test("065 - test Others 12") {
    val input = "<primitive type> <variable>"
    val expect = "<,primitive,type,>,<,variable,>,<EOF>"
    assert(checkLex(input,expect,65))
  }
  test("066 - test Others 13") {
    val input = "<primitive type> <many-variables>"
    val expect = "<,primitive,type,>,<,many,-,variables,>,<EOF>"
    assert(checkLex(input,expect,66))
  }
  test("067 - test Others 14") {
    val input = "<type> <function-name> ( <parameter-list> ) <block-statement>"
    val expect = "<,type,>,<,function,-,name,>,(,<,parameter,-,list,>,),<,block,-,statement,>,<EOF>"
    assert(checkLex(input,expect,67))
  }
  test("068 - test Others 15") {
    val input = "<primitive type> <identifier> or <primitive type> <identifier> [ ]"
    val expect = "<,primitive,type,>,<,identifier,>,or,<,primitive,type,>,<,identifier,>,[,],<EOF>"
    assert(checkLex(input,expect,68))
  }
  test("069 - test Others 16") {
    val input = """void foo ( int i ) {
                      int child_of_foo ( float f ) { } //ERROR
                      }"""
    val expect = """void,foo,(,int,i,),{,int,child_of_foo,(,float,f,),{,},},<EOF>"""
    assert(checkLex(input,expect,69))
  }
  test("070 - test Others 17") {
    val input = """/* This is
                    a block comment */"""
    val expect = "<EOF>"
    assert(checkLex(input,expect,79))
  }
  test("071 - test Others 18") {
    val input = """ "\b backspace \f formfeed \r carriage return \n newline \t horizontal tab \' single quote" """
    val expect = """\b backspace \f formfeed \r carriage return \n newline \t horizontal tab \' single quote,<EOF>"""
    assert(checkLex(input,expect,71))
  }
  test("072 - test Others 19") {
    val input = "boolean[3]"
    val expect = "boolean,[,3,],<EOF>"
    assert(checkLex(input,expect,72))
  }
  test("073 - test Others 20") {
    val input = "boolean[]"
    val expect = "boolean,[,],<EOF>"
    assert(checkLex(input,expect,73))
  }
  test("074 - test Others 21") {
    val input = "putStringLn()"
    val expect = "putStringLn,(,),<EOF>"
    assert(checkLex(input,expect,74))
  }
  test("075 - test Others 22") {
    val input = "int i=5; float f[]; float f[5]; boolean boo[2]={true;false};"
    val expect = "int,i,=,5,;,float,f,[,],;,float,f,[,5,],;,boolean,boo,[,2,],=,{,true,;,false,},;,<EOF>"
    assert(checkLex(input,expect,75))
  }
  test("076 - test Others 23") {
    val input = """{
                      boolean b; // local boolean variable
                      int i; // local int variable
                      i =3;
                      if (i > 0)
                        putInt (i);
                    }"""
    val expect = "{,boolean,b,;,int,i,;,i,=,3,;,if,(,i,>,0,),putInt,(,i,),;,},<EOF>"
    assert(checkLex(input,expect,77))
  }
  test("077 - test Others 24") {
    val input = """{
                      int i ; // local int variable
                      i =3;
                      if (i > 0)
                        putInt (i);
                      boolean b; //ERROR
                    }"""
    val expect = "{,int,i,;,i,=,3,;,if,(,i,>,0,),putInt,(,i,),;,boolean,b,;,},<EOF>"
    assert(checkLex(input,expect,77))
  }
  test("078 - test Others 25") {
    val input = "foo(2)[3+x] = a[b[2]] + 3;"
    val expect = "foo,(,2,),[,3,+,x,],=,a,[,b,[,2,],],+,3,;,<EOF>"
    assert(checkLex(input,expect,7))
  }
  test("079 - test Others 26") {
    val input = "void f(int a[10]) { }"
    val expect = "void,f,(,int,a,[,10,],),{,},<EOF>"
    assert(checkLex(input,expect,79))
  }
  test("080 - test Others 27") {
    val input = "void foo (float a [])"
    val expect = "void,foo,(,float,a,[,],),<EOF>"
    assert(checkLex(input,expect,8))
  }
  test("081 - test Others 28") {
    val input = """void goo (float x []) {
                      float y [10];
                      int z [10];
                      foo (x); //CORRECT
                      foo (y); //CORRECT
                      foo (z); //WRONG
                    }"""
    val expect = "void,goo,(,float,x,[,],),{,float,y,[,10,],;,int,z,[,10,],;,foo,(,x,),;,foo,(,y,),;,foo,(,z,),;,},<EOF>"
    assert(checkLex(input,expect,81))
  }
  test("082 - test Others 29") {
    val input = """void foo () {
                      if () return; //CORRECT
                      else return 2; //WRONG
                    }"""
    val expect = "void,foo,(,),{,if,(,),return,;,else,return,2,;,},<EOF>"
    assert(checkLex(input,expect,82))
  }
  test("083 - test Others 30") {
    val input = """int [] foo (int b []) {
                      int a [1];
                      if () return a; //CORRECT
                      else return b; //CORRECT
                    }"""
    val expect = "int,[,],foo,(,int,b,[,],),{,int,a,[,1,],;,if,(,),return,a,;,else,return,b,;,},<EOF>"
    assert(checkLex(input,expect,83))
  }
  test("084 - test Others 31") {
    val input = """ if ( <expression> )
                      <statement1>
                    else
                      <statement2>"""
    val expect = "if,(,<,expression,>,),<,statement1,>,else,<,statement2,>,<EOF>"
    assert(checkLex(input,expect,84))
  }
  test("085 - test Others 32") {
    val input = """ i = 1;
                    foo (1.2);
                    15i + 2 - 100"""
    val expect = "i,=,1,;,foo,(,1.2,),;,15,i,+,2,-,100,<EOF>"
    assert(checkLex(input,expect,85))
  }
  test("086 - test Others 33") {
    val input = """ i = 1;
                    foo (1.2);
                    i + 2;
                    100;"""
    val expect = "i,=,1,;,foo,(,1.2,),;,i,+,2,;,100,;,<EOF>"
    assert(checkLex(input,expect,86))
  }
  test("087 - test Others 34") {
    val input = """{
                      int a,b,c;
                      float f [5];
                    }"""
    val expect = "{,int,a,,,b,,,c,;,float,f,[,5,],;,},<EOF>"
    assert(checkLex(input,expect,87))
  }
  test("088 - test Others 35") {
    val input = """a=b=2;
                  if (a=b) f[0] = 1.0;"""
    val expect = "a,=,b,=,2,;,if,(,a,=,b,),f,[,0,],=,1.0,;,<EOF>"
    assert(checkLex(input,expect,88))
  }
  test("089 - test Others 36") {
    val input = """int i ;
                    int f ( ) {
                      return 200;
                    }"""
    val expect = "int,i,;,int,f,(,),{,return,200,;,},<EOF>"
    assert(checkLex(input,expect,89))
  }
  test("090 - test Others 37") {
    val input = """void main () {
                      int main ;
                      main = f ();"""
    val expect = "void,main,(,),{,int,main,;,main,=,f,(,),;,<EOF>"
    assert(checkLex(input,expect,90))
  }
  test("091 - test Others 38") {
    val input = """ putIntLn(i);
                    putIntLn(main);
                    putIntLn(f);"""
    val expect = "putIntLn,(,i,),;,putIntLn,(,main,),;,putIntLn,(,f,),;,<EOF>"
    assert(checkLex(input,expect,91))
  }
  test("092 - test Others 39") {
    val input = """ putIntLn(i);
                    {
                      int main;
                      main = f = i = 100;
                      putIntLn (i);
                      putIntLn (main);
                      }
                      putIntLn(main);"""
    val expect = "putIntLn,(,i,),;,{,int,main,;,main,=,f,=,i,=,100,;,putIntLn,(,i,),;,putIntLn,(,main,),;,},putIntLn,(,main,),;,<EOF>"
    assert(checkLex(input,expect,92))
  }
  test("093 - test Others 40") {
    val input = """ int i;
                    int f () {
                      return 200;
                    }
                    void main () {
                      int main;
                      main = f ();
                      putIntLn(i);
                      {
                        int i;
                        int main;
                        int f;
                        main = f = i = 100;
                        putIntLn(i);
                        putIntLn(main);
                      }
                      putIntLn(main);
                    }"""
    val expect = "int,i,;,int,f,(,),{,return,200,;,},void,main,(,),{,int,main,;,main,=,f,(,),;,putIntLn,(,i,),;,{,int,i,;,int,main,;,int,f,;,main,=,f,=,i,=,100,;,putIntLn,(,i,),;,putIntLn,(,main,),;,},putIntLn,(,main,),;,},<EOF>"
    assert(checkLex(input,expect,93))
  }
  test("094 - test Others 41") {
    val input = """void main() { // no parameters are allowed
                      int a;
                    }"""
    val expect = "void,main,(,),{,int,a,;,},<EOF>"
    assert(checkLex(input,expect,94))
  }
  test("095 - test Others 42") {
    val input = "int a = 3;"
    val expect = "int,a,=,3,;,<EOF>"
    assert(checkLex(input,expect,95))
  }
  test("096 - test Others 43") {
    val input = "10 + 2 - 7 * 46 / 999;"
    val expect = "10,+,2,-,7,*,46,/,999,;,<EOF>"
    assert(checkLex(input,expect,96))
  }
  test("097 - test Others 44") {
    val input = "int a[5];"
    val expect = "int,a,[,5,],;,<EOF>"
    assert(checkLex(input,expect,97))
  }
  test("098 - test Others 45") {
    val input = "return 2+2;"
    val expect = "return,2,+,2,;,<EOF>"
    assert(checkLex(input,expect,98))
  }
  test("099 - test Others 46") {
    val input = """if (true)
                    //something
                    a = b;"""
    val expect = "if,(,true,),a,=,b,;,<EOF>"
    assert(checkLex(input,expect,99))
  }
  test("100 - test Others 47") {
    val input = "Welcome - Final"
    val expect = "Welcome,-,Final,<EOF>"
    assert(checkLex(input,expect,100))
  }
}