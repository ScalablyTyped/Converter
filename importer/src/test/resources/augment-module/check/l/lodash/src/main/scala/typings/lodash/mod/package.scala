package typings.lodash

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

package object mod {
  type List[T] = typings.std.ArrayLike[T]
  type Many[T] = T | js.Array[T]
  type PartialObject[T] = typings.lodash.GlobalPartial[T]
  type PropertyName = java.lang.String | scala.Double | js.Symbol
  type PropertyPath = typings.lodash.mod.Many[typings.lodash.mod.PropertyName]
}
