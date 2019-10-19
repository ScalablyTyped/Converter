package typings.numjs.mod

import typings.ndarray.mod.Data
import typings.ndarray.mod.ndarray
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

trait NdArray[T] extends ndarray[T] {
  @JSName("T")
  var T_NdArray: NdArray[T]
  var ndim: Double
  def slice(args: Double*): NdArray[T]
}

object NdArray {
  @scala.inline
  def apply[T](T: NdArray[T], data: Data[T], ndim: Double, slice: /* repeated */ Double => NdArray[T]): NdArray[T] = {
    val __obj = js.Dynamic.literal(T = T.asInstanceOf[js.Any], data = data.asInstanceOf[js.Any], ndim = ndim.asInstanceOf[js.Any], slice = js.Any.fromFunction1(slice))
  
    __obj.asInstanceOf[NdArray[T]]
  }
}

