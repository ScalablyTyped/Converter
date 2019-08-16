package typings.angular

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

package object angularMod {
  import typings.angular.angularMod.Global.Function

  type Injectable[T /* <: Function */] = T | (js.Array[String | T])
}
