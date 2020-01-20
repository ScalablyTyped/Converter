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
}

