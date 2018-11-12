package typings
package angularLib.angularMod

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

package object angularNs {
  type Injectable[T /* <: js.Function */] = T | (js.Array[java.lang.String | T])
}
