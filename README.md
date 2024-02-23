# dc10-scalaq-twelf
Render to Twelf as a target lang.
 - Status: Proof of Concept
 - Artifact available on Maven Central
 - Based on Chris Martens' course [CM500: Logical Frameworks](https://github.com/chrisamaphone/lf-class)

## Usage
For use with the dc10-scalaq code generator:
 - Libraries for Scala 3 (JS, JVM, and Native platforms)
 - Renders code for Twelf 1.7.1+

### Installation

Add the following dependecies to your `build.sbt` file:

```scala
"com.julianpeeters" %% "dc10-scalaq" % "0.6.0"
"com.julianpeeters" %% "dc10-scalaq-twelf" % "0.1.0"
```

### Examples

##### Type declaration of `even-implies-even2`:

```scala
import dc10.scala.compiler.{compile, toString}
import dc10.scalaq.dsl.{*, given}
import dc10.scalaq.twelf.`1.7.1+`
import scala.language.implicitConversions // for references to n

val ast = TYPE("evenImpliesEven2", (VAL("n", NAT) ==> (n => EVEN(n) ==> EVEN2(n))))
// ast: IndexedStateT[ErrorF, List[Statement], List[Statement], TypeExpr[Function1[Nat, Function1[Even, Even2]], Nat]] = cats.data.IndexedStateT@6ba58270

val res = ast.compile.toString["Twelf 1.7.1+"]
// res: String = "even-implies-even2 : {N:nat} -> even N -> even2 N"
```