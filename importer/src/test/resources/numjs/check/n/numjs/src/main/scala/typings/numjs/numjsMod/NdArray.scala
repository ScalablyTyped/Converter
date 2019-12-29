package typings.numjs.numjsMod

import typings.ndarray.ndarrayMod.Data
import typings.ndarray.ndarrayMod.ndarray
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@js.native
trait NdArray[T] extends ndarray[T] {
  @JSName("T")
  var T_NdArray: NdArray[T] = js.native
  var ndim: Double = js.native
  def slice(args: Double*): NdArray[T] = js.native
}

object NdArray {
  @scala.inline
  def apply[T](T: NdArray[T], data: Data[T], ndim: Double, slice: /* repeated */ Double => NdArray[T]): NdArray[T] = {
    val __obj = js.Dynamic.literal(T = T.asInstanceOf[js.Any], data = data.asInstanceOf[js.Any], ndim = ndim.asInstanceOf[js.Any], slice = js.Any.fromFunction1(slice))
  
    __obj.asInstanceOf[NdArray[T]]
  }
}

