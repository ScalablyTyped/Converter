package typings
package lodashLib

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

package object lodashMod {
  type List[T] = stdLib.ArrayLike[T]
  type Many[T] = T | js.Array[T]
  type PartialObject[T] = lodashLib.GlobalPartial[T]
  type PropertyName = java.lang.String | scala.Double | js.Symbol
  type PropertyPath = Many[PropertyName]
}
