package dc10.scalaq.twelf

import _root_.scala.language.implicitConversions
import dc10.scala.compiler.{compile, toString}
import dc10.scalaq.twelf.`1.7.1+`
import dc10.scalaq.dsl.{*, given}
import munit.FunSuite

class NatsSuite extends FunSuite:

  test("Twelf declaration of even-implies-even2"):

    def ast =
      TYPE("evenImpliesEven2", (VAL("n", NAT) ==> (n => EVEN(n) ==> EVEN2(n))))

    val obtained =
      ast.compile.toString["Twelf 1.7.1+"]
          
    val expected =
      "even-implies-even2 : {N:nat} -> even N -> even2 N"
      
    assertEquals(obtained, expected)