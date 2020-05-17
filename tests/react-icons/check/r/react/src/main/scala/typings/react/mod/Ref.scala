package typings.react.mod

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

/* Rewritten from type alias, can be one of: 
  - java.lang.String
  - js.Function1[/ * instance * / T | scala.Null, js.Any]
*/
trait Ref[T] extends js.Object

object Ref {
  @scala.inline
  implicit def apply[T](value: js.Function1[/* instance */ T | Null, js.Any]): Ref[T] = value.asInstanceOf[Ref[T]]
  @scala.inline
  implicit def apply[T](value: String): Ref[T] = value.asInstanceOf[Ref[T]]
}

