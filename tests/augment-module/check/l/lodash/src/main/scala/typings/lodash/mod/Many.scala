package typings.lodash.mod

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

/* Rewritten from type alias, can be one of: 
  - T
  - js.Array[T]
*/
trait Many[T] extends js.Object

object Many {
  @scala.inline
  implicit def apply[T](value: js.Array[T]): Many[T] = value.asInstanceOf[Many[T]]
  @scala.inline
  implicit def apply[T](value: T): Many[T] = value.asInstanceOf[Many[T]]
}

