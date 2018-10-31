package ScalablyTyped
package LodashLib.LodashModule

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

package object UnderscoreNamespace {
  type List[T] = StdLib.ArrayLike[T]
  type Many[T] = T | js.Array[T]
  type PartialObject[T] = LodashLib.GlobalPartial[T]
  type PropertyName = java.lang.String | scala.Double | js.Symbol
  type PropertyPath = Many[PropertyName]
}
