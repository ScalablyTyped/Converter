package typings.lodashLib

import typings.lodashLib.GlobalPartial
import typings.stdLib.ArrayLike
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

package object lodashMod {
  type List[T] = ArrayLike[T]
  type Many[T] = T | js.Array[T]
  type PartialObject[T] = GlobalPartial[T]
  type PropertyName = String | Double | js.Symbol
  type PropertyPath = Many[PropertyName]
}
