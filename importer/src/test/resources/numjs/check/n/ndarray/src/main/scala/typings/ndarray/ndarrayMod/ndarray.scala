package typings.ndarray.ndarrayMod

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@js.native
trait ndarray[T] extends js.Object {
  var T: typings.ndarray.ndarrayMod.ndarray[T] = js.native
  var data: Data[T] = js.native
}

object ndarray {
  @scala.inline
  def apply[T](T: typings.ndarray.ndarrayMod.ndarray[T], data: Data[T]): ndarray[T] = {
    val __obj = js.Dynamic.literal(T = T.asInstanceOf[js.Any], data = data.asInstanceOf[js.Any])
  
    __obj.asInstanceOf[ndarray[T]]
  }
}

