package typings
package numjsLib

import ndarrayLib.ndarrayMod.Data
import ndarrayLib.ndarrayMod.DataType
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

package object numjsMod {
  type NdType[T] = DataType | Data[T]
}
