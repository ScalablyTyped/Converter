package typings

import typings.stdLib.HTMLInputElement
import typings.stdLib.TwoFoo
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

package object unionDashToDashInheritanceLib {
  /* Rewritten from type alias, can be one of: 
    - typings.unionDashToDashInheritanceLib.unionDashToDashInheritanceLibStrings.a1
    - typings.unionDashToDashInheritanceLib.unionDashToDashInheritanceLibStrings.a2
    - java.lang.String
  */
  type A = _A | String
  /* Rewritten from type alias, can be one of: 
    - typings.unionDashToDashInheritanceLib.unionDashToDashInheritanceLibStrings.b1
    - typings.unionDashToDashInheritanceLib.unionDashToDashInheritanceLibStrings.b2
    - scala.Double
    - typings.unionDashToDashInheritanceLib.A
  */
  type B = _B | Double | String
  /* Rewritten from type alias, can be one of: 
    - typings.unionDashToDashInheritanceLib.unionDashToDashInheritanceLibNumbers.`1`
    - typings.unionDashToDashInheritanceLib.unionDashToDashInheritanceLibNumbers.`2`
    - typings.stdLib.HTMLInputElement
    - js.Array[typings.unionDashToDashInheritanceLib.B]
    - typings.unionDashToDashInheritanceLib.B
  */
  type C = _C | js.Array[B] | HTMLInputElement | Double | String
  /* Rewritten from type alias, can be one of: 
    - typings.unionDashToDashInheritanceLib.unionDashToDashInheritanceLibStrings.foo
    - typings.unionDashToDashInheritanceLib.unionDashToDashInheritanceLibStrings.bar
    - typings.unionDashToDashInheritanceLib.Foo[java.lang.String]
  */
  type Illegal1 = _Illegal1 | Foo[String]
  /* Rewritten from type alias, can be one of: 
    - typings.unionDashToDashInheritanceLib.unionDashToDashInheritanceLibStrings.foo
    - typings.unionDashToDashInheritanceLib.unionDashToDashInheritanceLibStrings.bar
    - typings.unionDashToDashInheritanceLib.Foo[typings.unionDashToDashInheritanceLib.A]
  */
  type Illegal2 = _Illegal2 | Foo[A]
  /* Rewritten from type alias, can be one of: 
    - typings.unionDashToDashInheritanceLib.unionDashToDashInheritanceLibStrings.foo
    - typings.unionDashToDashInheritanceLib.unionDashToDashInheritanceLibStrings.bar
    - typings.unionDashToDashInheritanceLib.Foo2[T, T]
  */
  type Illegal3[T] = _Illegal3[T] | (Foo2[T, T])
  /* Rewritten from type alias, can be one of: 
    - typings.unionDashToDashInheritanceLib.unionDashToDashInheritanceLibStrings.foo
    - typings.unionDashToDashInheritanceLib.unionDashToDashInheritanceLibStrings.bar
    - typings.stdLib.TwoFoo[T3, T1]
    - typings.unionDashToDashInheritanceLib.Either[T2, T3]
    - typings.unionDashToDashInheritanceLib.Foo2[T1, T3]
  */
  type Test[T1, T2, T3] = (_Test[T1, T2, T3]) | (TwoFoo[T3, T1])
  /* Rewritten from type alias, can be one of: 
    - typings.unionDashToDashInheritanceLib.Test[O1, O1, O2]
    - typings.unionDashToDashInheritanceLib.Either[O2, O1]
    - typings.unionDashToDashInheritanceLib.Legal1[O2]
  */
  type Test2[O1, O2] = (_Test2[O1, O2]) | (Test[O1, O1, O2])
}
