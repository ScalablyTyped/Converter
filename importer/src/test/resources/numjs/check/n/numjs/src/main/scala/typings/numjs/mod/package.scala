package typings.numjs

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

package object mod {
  import typings.ndarray.mod.Data
  import typings.ndarray.mod.DataType

  type NdType[T] = DataType | Data[T]
}
