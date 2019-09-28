package typings.angular

import scala.scalajs.js
import scala.scalajs.js.`|`

package object angularMod {
  import typings.angular.angularMod._Global_.Function

  type Injectable[T /* <: Function */] = T | (js.Array[String | T])
}
