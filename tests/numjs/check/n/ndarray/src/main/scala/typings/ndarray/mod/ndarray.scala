package typings.ndarray.mod

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@js.native
trait ndarray[T] extends js.Object {
  var T: ndarray[T] = js.native
  var data: Data[T] = js.native
}

object ndarray {
  @scala.inline
  def apply[T](T: ndarray[T], data: Data[T]): ndarray[T] = {
    val __obj = js.Dynamic.literal(T = T.asInstanceOf[js.Any], data = data.asInstanceOf[js.Any])
    __obj.asInstanceOf[ndarray[T]]
  }
  @scala.inline
  implicit class ndarrayOps[Self <: ndarray[_], T] (val x: Self with ndarray[T]) extends AnyVal {
    @scala.inline
    def duplicate: Self = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x)).asInstanceOf[Self]
    @scala.inline
    def combineWith[Other <: js.Any](other: Other): Self with Other = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x, other.asInstanceOf[js.Any])).asInstanceOf[Self with Other]
    @scala.inline
    def withT(value: ndarray[T]): Self = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("T")(value.asInstanceOf[js.Any])
        ret
    }
    @scala.inline
    def withData(value: Data[T]): Self = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("data")(value.asInstanceOf[js.Any])
        ret
    }
  }
  
}

