import org.scalatest.FunSuite

/**
  * Created by nhphung on 4/30/17.
  */
class CodeGenSuite extends FunSuite with TestCodeGen {
  test("501 - simple program => print 5") {
    val input = "void main () {putIntLn(5);}"
    val expected = "5"
    assert(checkCode(input,expected,501))
  }
  test("502 - another simple program => print 125") {
    val input = "void main () {putIntLn(125);}"
    val expected = "125"
    assert(checkCode(input,expected,502))
  }
  test("503 - special program => print 0") {
    val input = "void main () {putIntLn(000);}"
    val expected = "0"
    assert(checkCode(input,expected,503))
  }
  test("504 - simple program => print 1.2341") {
    val input = "void main () {putFloatLn(1.2341);}"
    val expected = "1.2341"
    assert(checkCode(input,expected,504))
  }

  test("505 - simple program => 1 + 1") {
    val input = "void main () {putIntLn(1 + 1);}"
    val expected = "2"
    assert(checkCode(input,expected,504))
  }

  test("506 - simple program => 1 + 1.0") {
    val input = "void main () {putFloatLn(1 + 1.0);}"
    val expected = "2.0"
    assert(checkCode(input,expected,506))
  }

  test("507 - simple program => 1.0 + 1.0") {
    val input = "void main () {putFloatLn(1.0 + 1.0);}"
    val expected = "2.0"
    assert(checkCode(input,expected,507))
  }

  test("508 - simple program => 1.0 - 2.0") {
    val input = "void main () {putFloatLn(1.0 - 2.0);}"
    val expected = "-1.0"
    assert(checkCode(input,expected,508))
  }

  test("509 - simple program => 3.5 * 2") {
    val input = "void main () {putFloatLn(3.5 * 2);}"
    val expected = "7.0"
    assert(checkCode(input,expected,509))
  }

  test("510 - simple program => 2 * 3.5") {
    val input = "void main () {putFloatLn(2 * 3.5);}"
    val expected = "7.0"
    assert(checkCode(input,expected,510))
  }

  test("511 - simple program => 2 * 3.5e-3") {
    val input = "void main () {putFloatLn(2 * 3.5e-3);}"
    val expected = "0.007"
    assert(checkCode(input,expected,511))
  }

  test("512 - simple program => true (false)") {
    val input = "void main () {putBoolLn(false);}"
    val expected = "false"
    assert(checkCode(input,expected,512))
  }
  
  // What happen to MC: You don't have cast type so that is what happen when Float devide in Int
  test("513 - simple program => 15.9 / 3") {
    val input = "void main () {putFloatLn(15.9 / 3);}"
    val expected = "5.3"
    assert(checkCode(input,expected,513))
  }

  test("514 - simple program => 15 / 3.0") {
    val input = "void main () {putFloatLn(15 / 3.0);}"
    val expected = "5.0"
    assert(checkCode(input,expected,514))
  }

  test("515 - simple program => 16 / 3") {
    val input = "void main () {putInt(16 / 3);}"
    val expected = "5"
    assert(checkCode(input,expected,515))
  }

  
  // Fail
  // test("513 - simple program => string") {
  //   val input = """void main () {putString("string");}"""
  //   val expected = """string"""
  //   assert(checkCode(input,expected,513))
  // }
}
