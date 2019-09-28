package typings.ndarray.ndarrayMod

import scala.scalajs.js.annotation.ScalaJSDefined
import scala.scalajs.js
import scala.scalajs.js.`|`

trait ndarray[T] extends js.Object {
  var T: typings.ndarray.ndarrayMod.ndarray[T]
  var data: Data[T]
}

object ndarray {
  @inline
  def apply[T](T: typings.ndarray.ndarrayMod.ndarray[T], data: Data[T]): ndarray[T] = {
    val __obj = js.Dynamic.literal(T = T, data = data)
  
    __obj.asInstanceOf[ndarray[T]]
  }
}

