package typings.numjs

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

package object numjsMod {
  import typings.ndarray.ndarrayMod.Data
  import typings.ndarray.ndarrayMod.DataType

  type NdType[T] = DataType | Data[T]
}
