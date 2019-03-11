package typings

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

package object unionDashToDashInheritanceLib {
  type A = _A | java.lang.String
  type B = _B | scala.Double | java.lang.String
  type C = _C | js.Array[B] | stdLib.HTMLInputElement | scala.Double | java.lang.String
  type Illegal1 = _Illegal1 | Foo[java.lang.String]
  type Illegal2 = _Illegal2 | Foo[A]
  type Illegal3[T] = _Illegal3[T] | (Foo2[T, T])
  type Test[T1, T2, T3] = (_Test[T1, T2, T3]) | (stdLib.TwoFoo[T3, T1])
  type Test2[O1, O2] = (_Test2[O1, O2]) | (Test[O1, O1, O2])
}
