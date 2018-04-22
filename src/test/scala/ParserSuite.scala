import org.scalatest.FunSuite

/**
  * Created by nhphung on 4/28/17.
  */
class ParserSuite  extends FunSuite with TestParser {

  test("101 - test variable declaration in block") {
    val input = """int main(){}"""
    val expect = "sucessful"
    assert(checkRec(input, expect, 101))
  }
  test("102 - test variable declaration in block") {
    val input = """int main(){
int a;
}"""
    val expect = "sucessful"
    assert(checkRec(input, expect, 102))
  }
  test("103 - test variable declaration in block") {
    val input = """int main () {
float a,b;
}"""
    val expect = "sucessful"
    assert(checkRec(input, expect, 103))
  }

  test("104 - test variable declaration in block") {
    val input = """int main () {
string a[1];
}"""
    val expect = "sucessful"
    assert(checkRec(input, expect, 104))
  }
  test("105 - test variable declaration in block") {
    val input = """int main () {
boolean a[1],b[1];
}"""
    val expect = "sucessful"
    assert(checkRec(input, expect, 105))
  }
  test("106 - test variable declaration in block") {
    val input = """int main () {
int a,b,c[1],d[1];
}"""
    val expect = "sucessful"
    assert(checkRec(input, expect, 106))
  }
  test("107 - test variable declaration in block") {
    val input = """int main () {
int a;
int b;
int c[1];
int d[1];
}"""
    val expect = "sucessful"
    assert(checkRec(input, expect, 107))
  }
  test("108 - test variable declaration in block") {
    val input = """int main () {
int a,c[1];
int b,d[2];
}"""
    val expect = "sucessful"
    assert(checkRec(input, expect, 108))
  }
  test("109 - test variable declaration in block") {
    val input = """int main () {
int a[];
}"""
    val expect = "Error on line 2 col 7: ]"
    assert(checkRec(input, expect, 109))
  }
  test("110 - test variable declaration in block") {
    val input = """int main(){
int a,b[];
}"""
    val expect = "Error on line 2 col 9: ]"
    assert(checkRec(input, expect, 110))
  }
  test("111 - test variable declaration") {
    val input = """int a;"""
    val expect = "sucessful"
    assert(checkRec(input, expect, 111))
  }
  test("112 - test variable declaration") {
    val input = """float a,b;"""
    val expect = "sucessful"
    assert(checkRec(input, expect, 112))
  }
  test("113 - test variable declaration") {
    val input = """string a[1];"""
    val expect = "sucessful"
    assert(checkRec(input, expect, 113))
  }
  test("114 - test variable declaration") {
    val input = """int a[1],b[1];"""
    val expect = "sucessful"
    assert(checkRec(input, expect, 114))
  }
  test("115 - test variable declaration") {
    val input = """int a,b,c[1],d[1];"""
    val expect = "sucessful"
    assert(checkRec(input, expect, 115))
  }
  test("116 - test variable declaration") {
    val input = """int a;
int b;
int c[1];
int d[1];"""
    val expect = "sucessful"
    assert(checkRec(input, expect, 116))
  }
  test("117 - test variable declaration") {
    val input = """int a,b[1];
int c,d[1];"""
    val expect = "sucessful"
    assert(checkRec(input, expect, 117))
  }
  test("118 - test variable declaration") {
    val input = """int a[];"""
    val expect = "Error on line 1 col 7: ]"
    assert(checkRec(input, expect, 118))
  }
  test("119 - test variable declaration") {
    val input = """int a,b[];"""
    val expect = "Error on line 1 col 9: ]"
    assert(checkRec(input, expect, 119))
  }
  test("120 - test variable declaration") {
    val input = """int a;
int main(){}"""
    val expect = "sucessful"
    assert(checkRec(input, expect, 120))
  }
  test("121 - test function declaration") {
    val input = """int a;
void main(){}"""
    val expect = "sucessful"
    assert(checkRec(input, expect, 121))
  }
  test("122 - test function declaration") {
    val input = """string a;
int[] main(){}"""
    val expect = "sucessful"
    assert(checkRec(input, expect, 122))
  }
  test("123 - test function declaration") {
    val input = """int a;
int[3] main(){}"""
    val expect = "Error on line 2 col 5: 3"
    assert(checkRec(input, expect, 123))
  }
  test("124 - test function declaration") {
    val input = """int a;
void if(){}"""
    val expect = "Error on line 2 col 6: if"
    assert(checkRec(input, expect, 124))
  }
  test("125 - test function declaration") {
    val input = """int a;
int main(int a){}"""
    val expect = "sucessful"
    assert(checkRec(input, expect, 125))
  }
  test("126 - test function declaration") {
    val input = """int a;
int main(int a, string b){}"""
    val expect = "sucessful"
    assert(checkRec(input, expect, 126))
  }
  test("127 - test function declaration") {
    val input = """float temp;
int main(int a[]){}"""
    val expect = "sucessful"
    assert(checkRec(input, expect, 127))
  }
  test("128 - test function declaration") {
    val input = """float a;
int main(int a[], float b[]){}"""
    val expect = "sucessful"
    assert(checkRec(input, expect, 128))
  }
  test("129 - test function declaration") {
    val input = """int main(int a, float b[]){}"""
    val expect = "sucessful"
    assert(checkRec(input, expect, 129))
  }
  test("130 - test function declaration") {
    val input = """int main(float a, string b[3]){}"""
    val expect = "Error on line 1 col 28: 3"
    assert(checkRec(input, expect, 130))
  }
  test("131 - test variable & function declaration") {
    val input = """int a;
void foo(){}
int main(){}"""
    val expect = "sucessful"
    assert(checkRec(input, expect, 131))
  }
  test("132") {
    val input = """void foo(int i){
int child_of_foo (float f) {} //ERROR
}"""
    val expect = "Error on line 2 col 18: ("
    assert(checkRec(input, expect, 132))
  }
  test("133") {
    val input = """int main(){
int i = 0;
}"""
    val expect = "Error on line 2 col 7: ="
    assert(checkRec(input, expect, 133))
  }
  test("134") {
    val input = """int i = 3;
int main(){}"""
    val expect = "Error on line 1 col 7: ="
    assert(checkRec(input, expect, 134))
  }
  test("135") {
    val input = """boolean boo[2]={true,false};;
int main(){}"""
    val expect = "Error on line 1 col 15: ="
    assert(checkRec(input, expect, 135))
  }
  test("136") {
    val input = """int main(){}"""
    val expect = "sucessful"
    assert(checkRec(input, expect, 136))
  }
  test("137") {
    val input = """int main(){
boolean b ; // local boolean variable
int i ; // local int variable
i = 3;
if (i > 0) putInt (i);
}"""
    val expect = "sucessful"
    assert(checkRec(input, expect, 137))
  }
  test("138") {
    val input = """int main(){
int i ; // local int variable
i = 3;
if (i > 0) putInt (i);
boolean b ;
}"""
    val expect = "Error on line 5 col 1: boolean"
    assert(checkRec(input, expect, 138))
  }
  test("139 - test Statement") {
    val input = """int main(){
int i, j;
i = 0;
j = 2;
if (i == j)
  j = 1;
else
  j = 3;
}"""
    val expect = "sucessful"
    assert(checkRec(input, expect, 139))
  }
  test("140 - test Statement") {
    val input = """int main(){
do
  do
    break;
    return;
    continue;
  while true;
while true;
}"""
    val expect = "sucessful"
    assert(checkRec(input, expect, 140))
  }
  test("141 - test Statement") {
    val input = """int main(){
do {}
while true;
}"""
    val expect = "sucessful"
    assert(checkRec(input, expect, 141))
  }
  test("142 - test Statement") {
    val input = """int main(){
for(;;){}
}"""
    val expect = "Error on line 2 col 5: ;"
    assert(checkRec(input, expect, 142))
  }
  test("143") {
    val input = """int main(){
+3;
}"""
    val expect = "Error on line 2 col 1: +"
    assert(checkRec(input, expect, 143))
  }
  test("144") {
    val input = """int main(){
foo(1,2)
}"""
    val expect = "Error on line 3 col 1: }"
    assert(checkRec(input, expect, 144))
  }
  test("145") {
    val input = """int main(){
int a, b, c;
float f[5];
// end declaration part
// start statement part
a=b=2;
if (a = b) f[0] = 1.0;
// end statement part
}"""
    val expect = "sucessful"
    assert(checkRec(input, expect, 145))
  }
  test("146") {
    val input = """int main(){}
int getInt(){}"""
    val expect = "sucessful"
    assert(checkRec(input, expect, 146))
  }
  test("147") {
    val input = """int i;
int f(){
  return 200;
}
void main(){
  int main ;
  main = f();
  putIntLn(i);
  {
    int i ;
    int main;
    int f;
    main = f = i = 100;
    putIntLn(i);
    putIntLn(main);
    putIntLn(f);
  }
  putIntLn(main);
}"""
    val expect = "sucessful"
    assert(checkRec(input, expect, 147))
  }
  test("148") {
    val input = """int main(){}
int k;
break;
int foo(){}"""
    val expect = "Error on line 3 col 1: break"
    assert(checkRec(input, expect, 148))
  }
  test("149") {
    val input = """int main(){
int a,c;
do a = 0;
while ()
return 0;
}"""
    val expect = "Error on line 4 col 8: )"
    assert(checkRec(input, expect, 149))
  }
  test("150") {
    val input = """int main(){
for (1;i<5;i=i+1){}
}"""
    val expect = "sucessful"
    assert(checkRec(input, expect, 150))
  }
  test("151") {
    val input = """int main(){
for (1.2e3;i<5;i=i+1){}
}"""
    val expect = "sucessful"
    assert(checkRec(input, expect, 151))
  }
  test("152") {
    val input = """int main(){
for (i =1 ;i<5;i=i+1.2e3){} 
}"""
    val expect = "sucessful"
    assert(checkRec(input, expect, 152))
  }
  test("153") {
    val input = """int main(){}
int a;
void add(int a){}
int b
int[] main () {}"""
    val expect = "Error on line 5 col 1: int"
    assert(checkRec(input, expect, 153))
  }
  test("154") {
    val input = """int main(){
a = b == c = d;
}"""
    val expect = "sucessful"
    assert(checkRec(input, expect, 154))
  }
  test("155") {
    val input = """int main(){
a = b == c = d == e;
}"""
    val expect = "sucessful"
    assert(checkRec(input, expect, 155))
  }
  test("156") {
    val input = """int main(){
foo(2)[3+x] = a[b[2]] +3;
}"""
    val expect = "sucessful"
    assert(checkRec(input, expect, 156))
  }
  test("157") {
    val input = """int main(){}"""
    val expect = "sucessful"
    assert(checkRec(input, expect, 157))
  }
  test("158") {
    val input = """int main(){
a = b;
}"""
    val expect = "sucessful"
    assert(checkRec(input, expect, 158))
  }
  test("159") {
    val input = """int main(){
a = b||c;
}"""
    val expect = "sucessful"
    assert(checkRec(input, expect, 159))
  }
  test("160") {
    val input = """int main(){
a = b || c && d;
}"""
    val expect = "sucessful"
    assert(checkRec(input, expect, 160))
  }
  test("161 - test Expression 1") {
    val input = """int main(){
a = b || c && d == e;  
}"""
    val expect = "sucessful"
    assert(checkRec(input, expect, 161))
  }
  test("162 - test Expression 2") {
    val input = """int main(){
a = b || c && d == e < f;
}"""
    val expect = "sucessful"
    assert(checkRec(input, expect, 162))
  }
  test("163 - test Expression 3") {
    val input = """int main(){
a = b || c && d == e < f + g;
}"""
    val expect = "sucessful"
    assert(checkRec(input, expect, 163))
  }
  test("164 - test Expression 4") {
    val input = """int main(){
a = b || c && d == e < f + g / h;
}"""
    val expect = "sucessful"
    assert(checkRec(input, expect, 164))
  }
  test("165 - test Expression 5") {
    val input = """int main(){
b = -3;
a = b || c && d == e < f + g / h ;
}"""
    val expect = "sucessful"
    assert(checkRec(input, expect, 165))
  }
  test("166 - test Expression 6") {
    val input = """int main(){
a = b || c && d == e < f + g / h[1];
}"""
    val expect = "sucessful"
    assert(checkRec(input, expect, 166))
  }
  test("167") {
    val input = """int main(){
a = b || c && d == e < f + g / h[h[1]];
}"""
    val expect = "sucessful"
    assert(checkRec(input, expect, 167))
  }
  test("168") {
    val input = """void f(int a[10]) { }"""
    val expect = "Error on line 1 col 14: 10"
    assert(checkRec(input, expect, 168))
  }
  test("169") {
    val input = """void goo(float x[]){
float y[10];
int z[10];
foo (x); //CORRECT
foo (y); //CORRECT
foo (z); //WRONG
}"""
    val expect = "sucessful"
    assert(checkRec(input, expect, 169))
  }
  test("170") {
    val input = """void foo(){
if (true) return; //CORRECT
else return 2 ; //WRONG
}"""
    val expect = "sucessful"
    assert(checkRec(input, expect, 170))
  }

  test("171") {
    val input = "void main(){int a; a = 1;}"
    val expect = "sucessful"
    assert(checkRec(input, expect, 171))
  }
  test("172") {
    val input = """void main(){string a; a = "a";} """
    val expect = "sucessful"
    assert(checkRec(input, expect, 172))
  }
  test("173") {
    val input = "void main(){float a; a = 1.;}"
    val expect = "sucessful"
    assert(checkRec(input, expect, 173))
  }
  test("174") {
    val input = "void main(){float a; a = .1;}"
    val expect = "sucessful"
    assert(checkRec(input, expect, 174))
  }
  test("175") {
    val input = "void main(){float a; a = 1.2E3;}"
    val expect = "sucessful"
    assert(checkRec(input, expect, 175))
  }
  test("176") {
    val input = "void main(){int a; a = 12;}"
    val expect = "sucessful"
    assert(checkRec(input, expect, 176))
  }
  test("177") {
    val input = "void main(){int a; a = 2018;}"
    val expect = "sucessful"
    assert(checkRec(input, expect, 177))
  }
  test("178") {
    val input = "void main(){int a,b; a = 1; b = 20;}"
    val expect = "sucessful"
    assert(checkRec(input, expect, 178))
  }
  test("179") {
    val input = "void main(){float a,b,c; a = 1; c = a;}"
    val expect = "sucessful"
    assert(checkRec(input, expect, 179))
  }
  test("180") {
    val input = "void main(){int a,c,b; a = 1; b = a; c = b;}"
    val expect = "sucessful"
    assert(checkRec(input, expect, 180))
  }
  test("181") {
    val input = "void main(){foo(2,2)[a+b];}"
    val expect = "sucessful"
    assert(checkRec(input, expect, 181))
  }
  test("182") {
    val input = "void main(){foo(2)[a+b];}"
    val expect = "sucessful"
    assert(checkRec(input, expect, 182))
  }
  test("183") {
    val input = "void main(){foo(2,3,4)[a+b+c];}"
    val expect = "sucessful"
    assert(checkRec(input, expect, 183))
  }
  test("184") {
    val input = "void main(){foo(2,2)[a+b] == fuu(3);}"
    val expect = "sucessful"
    assert(checkRec(input, expect, 184))
  }
  test("185") {
    val input = "void main(){foo(2,2)[a+b] == fuu(3,2)[2];}"
    val expect = "sucessful"
    assert(checkRec(input, expect, 185))
  }
  test("186") {
    val input = "void main(){foo(2,2)[a+b] == fuu(3,2,9)[2];}"
    val expect = "sucessful"
    assert(checkRec(input, expect, 186))
  }
  test("187") {
    val input = "void main(){foo(2,2)[a+b] == fuu(a-b,a+b)[2];}"
    val expect = "sucessful"
    assert(checkRec(input, expect, 187))
  }
  test("188") {
    val input = "void main(){foo(2,2)[a+b] == fuu(a*2,b/2)[2];}"
    val expect = "sucessful"
    assert(checkRec(input, expect, 188))
  }
  test("189") {
    val input = "void main(){foo(2,2)[a+b] == fuu(s,z)[z];}"
    val expect = "sucessful"
    assert(checkRec(input, expect, 189))
  }
  test("190") {
    val input = "void main(){foo(2,2)[a+b] == fuu(99,99)[99];}"
    val expect = "sucessful"
    assert(checkRec(input, expect, 190))
  }
  test("191") {
    val input = "void main(){foo(2,2)[a+b] == fuu(a % b)[99];}"
    val expect = "sucessful"
    assert(checkRec(input, expect, 191))
  }
  test("192") {
    val input = "void main(){foo(2,2)[a+b] || fuu(99,99)[99];}"
    val expect = "sucessful"
    assert(checkRec(input, expect, 192))
  }
  test("193") {
    val input = "void main(){foo(2,2)[a+b] && fuu(99,99)[99];}"
    val expect = "sucessful"
    assert(checkRec(input, expect, 193))
  }
  test("194") {
    val input = "void main(){a || b && c;}"
    val expect = "sucessful"
    assert(checkRec(input, expect, 194))
  }
  test("195") {
    val input = "void main(){foo(2,2)[a+b] = fuu(c % d)[a % d];}"
    val expect = "sucessful"
    assert(checkRec(input, expect, 195))
  }
  test("196") {
    val input = "void main(){foo(2,2)[a+b] != fuu(99)[99];}"
    val expect = "sucessful"
    assert(checkRec(input, expect, 196))
  }
  test("197") {
    val input = "void main(){foo(2,2)[a+b] > 2017;}"
    val expect = "sucessful"
    assert(checkRec(input, expect, 197))
  }
  test("198") {
    val input = "void main(){foo(2,2)[a+b] >= 29;}"
    val expect = "sucessful"
    assert(checkRec(input, expect, 198))
  }
  test("199") {
    val input = "void main(){a = foo(2,2)[a+b] == 241096;}"
    val expect = "sucessful"
    assert(checkRec(input, expect, 199))
  }
  test("200") {
    val input = "void main(){myid = foo(2,2)[a+b] == 123;}"
    val expect = "sucessful"
    assert(checkRec(input, expect, 200))
  }
}