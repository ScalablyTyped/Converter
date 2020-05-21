package typings.numjs.mod

import typings.ndarray.mod.Data
import typings.ndarray.mod.ndarray
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
  @scala.inline
  implicit class NdArrayOps[Self <: NdArray[_], T] (val x: Self with NdArray[T]) extends AnyVal {
    @scala.inline
    def duplicate: Self = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x)).asInstanceOf[Self]
    @scala.inline
    def combineWith[Other <: js.Any](other: Other): Self with Other = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x, other.asInstanceOf[js.Any])).asInstanceOf[Self with Other]
    @scala.inline
    def set(key: String, value: js.Any): Self = {
        x.asInstanceOf[js.Dynamic].updateDynamic(key)(value)
        x
    }
    @scala.inline
    def setT(value: NdArray[T]): Self = this.set("T", value.asInstanceOf[js.Any])
    @scala.inline
    def setNdim(value: Double): Self = this.set("ndim", value.asInstanceOf[js.Any])
    @scala.inline
    def setSlice(value: /* repeated */ Double => NdArray[T]): Self = this.set("slice", js.Any.fromFunction1(value))
  }
  
}

