package typings.angular

import typings.angular.angularMod.Global.Function
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

package object angularMod {
  type Injectable[T /* <: Function */] = T | (js.Array[String | T])
}
