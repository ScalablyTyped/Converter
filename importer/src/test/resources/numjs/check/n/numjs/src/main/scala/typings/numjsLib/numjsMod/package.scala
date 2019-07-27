package typings.numjsLib

import typings.ndarrayLib.ndarrayMod.Data
import typings.ndarrayLib.ndarrayMod.DataType
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

package object numjsMod {
  type NdType[T] = DataType | Data[T]
}
