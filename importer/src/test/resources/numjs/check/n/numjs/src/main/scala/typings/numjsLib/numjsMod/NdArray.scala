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

object NdArray {
  @scala.inline
  def apply[T](
    T: NdArray[T],
    data: ndarrayLib.ndarrayMod.Data[T],
    ndim: scala.Double,
    slice: /* repeated */ scala.Double => NdArray[T]
  ): NdArray[T] = {
    val __obj = js.Dynamic.literal(T = T, data = data, ndim = ndim, slice = js.Any.fromFunction1(slice))
  
    __obj.asInstanceOf[NdArray[T]]
  }
}

