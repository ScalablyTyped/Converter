package typings.numjs

import typings.ndarray.ndarrayMod.Data
import typings.ndarray.ndarrayMod.DataType
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

package object numjsMod {
  type NdType[T] = DataType | Data[T]
}
