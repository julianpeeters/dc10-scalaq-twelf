# dc10-scalaq-twelf
Render to Twelf as a target lang.
 - Status: Proof of Concept
 - Artifact available on Maven Central
 - Based on Chris Martens' course [CM500: Logical Frameworks](https://github.com/chrisamaphone/lf-class)

## Usage
For use with the dc10-scalaq code generator:
 - Libraries for Scala @SCALA@ (JS, JVM, and Native platforms)
 - Renders code for Twelf @TWELF@

### Installation

Add the following dependecies to your `build.sbt` file:

```scala
"com.julianpeeters" %% "dc10-scalaq" % "@SCALAQ@"
"com.julianpeeters" %% "dc10-scalaq-twelf" % "@VERSION@"
```

### Examples

##### Type declaration of `even-implies-even2`:

```scala mdoc:reset
import dc10.scala.compiler.{compile, toString}
import dc10.scalaq.dsl.{*, given}
import dc10.scalaq.twelf.`@TWELF@`
import scala.language.implicitConversions // for references to n

val ast = TYPE("evenImpliesEven2", (VAL("n", NAT) ==> (n => EVEN(n) ==> EVEN2(n))))

val res = ast.compile.toString["Twelf @TWELF@"]
```