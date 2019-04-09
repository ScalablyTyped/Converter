package typings
package numjsLib

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

package object numjsMod {
  type NdType[T] = ndarrayLib.ndarrayMod.DataType | ndarrayLib.ndarrayMod.Data[T]
}
