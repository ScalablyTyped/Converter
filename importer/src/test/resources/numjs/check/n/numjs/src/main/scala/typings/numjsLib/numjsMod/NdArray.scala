package typings
package numjsLib.numjsMod

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

trait NdArray[T]
  extends ndarrayLib.ndarrayMod.ndarray[T] {
  @JSName("T")
  var T_NdArray: NdArray[T]
  var ndim: scala.Double
  def slice(args: scala.Double*): NdArray[T]
}

