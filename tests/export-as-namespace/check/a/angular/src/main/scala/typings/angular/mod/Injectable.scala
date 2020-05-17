package typings.angular.mod

import typings.angular.mod.global.Function
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

/* Rewritten from type alias, can be one of: 
  - T
  - js.Array[java.lang.String | T]
*/
trait Injectable[T /* <: Function */] extends js.Object

object Injectable {
  @scala.inline
  implicit def apply[/* <: typings.angular.mod.global.Function */ T](value: js.Array[String | T]): Injectable[T] = value.asInstanceOf[Injectable[T]]
  @scala.inline
  implicit def apply[/* <: typings.angular.mod.global.Function */ T](value: T): Injectable[T] = value.asInstanceOf[Injectable[T]]
}

