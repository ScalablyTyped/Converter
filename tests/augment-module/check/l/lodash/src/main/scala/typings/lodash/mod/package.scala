package typings.lodash

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

package object mod {
  type List[T] = typings.std.ArrayLike[T]
  type PartialObject[T] = typings.lodash.GlobalPartial[T]
  type PropertyPath = typings.lodash.mod.Many[typings.lodash.mod.PropertyName]
}
