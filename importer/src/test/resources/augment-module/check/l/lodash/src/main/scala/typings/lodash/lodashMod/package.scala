package typings.lodash

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

package object lodashMod {
  import typings.lodash.GlobalPartial
  import typings.std.ArrayLike

  type List[T] = ArrayLike[T]
  type Many[T] = T | js.Array[T]
  type PartialObject[T] = GlobalPartial[T]
  type PropertyName = String | Double | js.Symbol
  type PropertyPath = Many[PropertyName]
}
