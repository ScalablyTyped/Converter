package typings

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

package object unionDashToDashInheritanceLib {
  /* Rewritten from type alias, can be one of: 
    - unionDashToDashInheritanceLib.unionDashToDashInheritanceLibStrings.a1
    - unionDashToDashInheritanceLib.unionDashToDashInheritanceLibStrings.a2
    - java.lang.String
  */
  type A = _A | java.lang.String
  /* Rewritten from type alias, can be one of: 
    - unionDashToDashInheritanceLib.unionDashToDashInheritanceLibStrings.b1
    - unionDashToDashInheritanceLib.unionDashToDashInheritanceLibStrings.b2
    - scala.Double
    - A
  */
  type B = _B | scala.Double | java.lang.String
  /* Rewritten from type alias, can be one of: 
    - unionDashToDashInheritanceLib.unionDashToDashInheritanceLibNumbers.`1`
    - unionDashToDashInheritanceLib.unionDashToDashInheritanceLibNumbers.`2`
    - stdLib.HTMLInputElement
    - js.Array[B]
    - B
  */
  type C = _C | js.Array[B] | stdLib.HTMLInputElement | scala.Double | java.lang.String
  /* Rewritten from type alias, can be one of: 
    - unionDashToDashInheritanceLib.unionDashToDashInheritanceLibStrings.foo
    - unionDashToDashInheritanceLib.unionDashToDashInheritanceLibStrings.bar
    - Foo[java.lang.String]
  */
  type Illegal1 = _Illegal1 | Foo[java.lang.String]
  /* Rewritten from type alias, can be one of: 
    - unionDashToDashInheritanceLib.unionDashToDashInheritanceLibStrings.foo
    - unionDashToDashInheritanceLib.unionDashToDashInheritanceLibStrings.bar
    - Foo[A]
  */
  type Illegal2 = _Illegal2 | Foo[A]
  /* Rewritten from type alias, can be one of: 
    - unionDashToDashInheritanceLib.unionDashToDashInheritanceLibStrings.foo
    - unionDashToDashInheritanceLib.unionDashToDashInheritanceLibStrings.bar
    - Foo2[T, T]
  */
  type Illegal3[T] = _Illegal3[T] | (Foo2[T, T])
  /* Rewritten from type alias, can be one of: 
    - unionDashToDashInheritanceLib.unionDashToDashInheritanceLibStrings.foo
    - unionDashToDashInheritanceLib.unionDashToDashInheritanceLibStrings.bar
    - stdLib.TwoFoo[T3, T1]
    - Either[T2, T3]
    - Foo2[T1, T3]
  */
  type Test[T1, T2, T3] = (_Test[T1, T2, T3]) | (stdLib.TwoFoo[T3, T1])
  /* Rewritten from type alias, can be one of: 
    - Test[O1, O1, O2]
    - Either[O2, O1]
    - Legal1[O2]
  */
  type Test2[O1, O2] = (_Test2[O1, O2]) | (Test[O1, O1, O2])
}
