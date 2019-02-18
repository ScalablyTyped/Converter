package typings
package ndarrayLib.ndarrayMod

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

trait ndarray[T] extends js.Object {
  var T: ndarray[T]
  var data: ndarrayLib.ndarrayMod.ndarrayNs.Data[T]
}

object ndarray {
  @scala.inline
  def apply[T](T: ndarray[T], data: ndarrayLib.ndarrayMod.ndarrayNs.Data[T]): ndarray[T] = {
    val __obj = js.Dynamic.literal(T = T, data = data)
  
    __obj.asInstanceOf[ndarray[T]]
  }
}

