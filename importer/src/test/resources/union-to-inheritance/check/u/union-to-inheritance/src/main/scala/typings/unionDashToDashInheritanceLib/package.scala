package typings

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

package object unionDashToDashInheritanceLib {
  type A = _A | java.lang.String
  type B = _B | scala.Double
  type C = _C | js.Array[B] | stdLib.HTMLInputElement
  type Illegal1 = _Illegal1 | Foo[java.lang.String]
  type Illegal2 = _Illegal2 | Foo[A]
  type Illegal3[T] = _Illegal3[T] | (Foo2[T, T])
}
