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
  implicit class NdArrayOps[Self[t] <: NdArray[t], T] (val x: Self[T]) extends AnyVal {
    @scala.inline
    def duplicate: Self[T] = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x)).asInstanceOf[Self[T]]
    @scala.inline
    def combineWith[Other /* <: js.Any */](other: Other): Self[T] with Other = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x, other.asInstanceOf[js.Any])).asInstanceOf[Self[T] with Other]
    @scala.inline
    def withT(T: NdArray[T]): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        ret.updateDynamic("T")(T.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withNdim(ndim: Double): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        ret.updateDynamic("ndim")(ndim.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withSlice(slice: /* repeated */ Double => NdArray[T]): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        ret.updateDynamic("slice")(js.Any.fromFunction1(slice))
        ret.asInstanceOf[Self[T]]
    }
  }
  
}

