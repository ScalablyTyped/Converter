package typings

import typings.std.HTMLInputElement
import typings.std.TwoFoo
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

package object unionDashToDashInheritance {
  /* Rewritten from type alias, can be one of: 
    - typings.unionDashToDashInheritance.unionDashToDashInheritanceStrings.a1
    - typings.unionDashToDashInheritance.unionDashToDashInheritanceStrings.a2
    - java.lang.String
  */
  type A = _A | String
  /* Rewritten from type alias, can be one of: 
    - typings.unionDashToDashInheritance.unionDashToDashInheritanceStrings.b1
    - typings.unionDashToDashInheritance.unionDashToDashInheritanceStrings.b2
    - scala.Double
    - typings.unionDashToDashInheritance.A
  */
  type B = _B | Double | String
  /* Rewritten from type alias, can be one of: 
    - typings.unionDashToDashInheritance.unionDashToDashInheritanceNumbers.`1`
    - typings.unionDashToDashInheritance.unionDashToDashInheritanceNumbers.`2`
    - typings.std.HTMLInputElement
    - js.Array[typings.unionDashToDashInheritance.B]
    - typings.unionDashToDashInheritance.B
  */
  type C = _C | js.Array[B] | HTMLInputElement | Double | String
  /* Rewritten from type alias, can be one of: 
    - typings.unionDashToDashInheritance.unionDashToDashInheritanceStrings.foo
    - typings.unionDashToDashInheritance.unionDashToDashInheritanceStrings.bar
    - typings.unionDashToDashInheritance.Foo[java.lang.String]
  */
  type Illegal1 = _Illegal1 | Foo[String]
  /* Rewritten from type alias, can be one of: 
    - typings.unionDashToDashInheritance.unionDashToDashInheritanceStrings.foo
    - typings.unionDashToDashInheritance.unionDashToDashInheritanceStrings.bar
    - typings.unionDashToDashInheritance.Foo[typings.unionDashToDashInheritance.A]
  */
  type Illegal2 = _Illegal2 | Foo[A]
  /* Rewritten from type alias, can be one of: 
    - typings.unionDashToDashInheritance.unionDashToDashInheritanceStrings.foo
    - typings.unionDashToDashInheritance.unionDashToDashInheritanceStrings.bar
    - typings.unionDashToDashInheritance.Foo2[T, T]
  */
  type Illegal3[T] = _Illegal3[T] | (Foo2[T, T])
  /* Rewritten from type alias, can be one of: 
    - typings.unionDashToDashInheritance.unionDashToDashInheritanceStrings.foo
    - typings.unionDashToDashInheritance.unionDashToDashInheritanceStrings.bar
    - typings.std.TwoFoo[T3, T1]
    - typings.unionDashToDashInheritance.Either[T2, T3]
    - typings.unionDashToDashInheritance.Foo2[T1, T3]
  */
  type Test[T1, T2, T3] = (_Test[T1, T2, T3]) | (TwoFoo[T3, T1])
  /* Rewritten from type alias, can be one of: 
    - typings.unionDashToDashInheritance.Test[O1, O1, O2]
    - typings.unionDashToDashInheritance.Either[O2, O1]
    - typings.unionDashToDashInheritance.Legal1[O2]
  */
  type Test2[O1, O2] = (_Test2[O1, O2]) | (Test[O1, O1, O2])
}
