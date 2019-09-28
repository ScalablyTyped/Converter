package typings.numjs.numjsMod

import scala.scalajs.js.annotation.JSName
import scala.scalajs.js.annotation.ScalaJSDefined
import typings.ndarray.ndarrayMod.Data
import typings.ndarray.ndarrayMod.ndarray
import scala.scalajs.js
import scala.scalajs.js.`|`

trait NdArray[T] extends ndarray[T] {
  @JSName("T")
  var T_NdArray: NdArray[T]
  var ndim: Double
  def slice(args: Double*): NdArray[T]
}

object NdArray {
  @inline
  def apply[T](
    T: NdArray[T],
    data: Data[T],
    hasOwnProperty: String => Boolean,
    isPrototypeOf: js.Object => Boolean,
    ndim: Double,
    propertyIsEnumerable: String => Boolean,
    slice: /* repeated */ Double => NdArray[T],
    toLocaleString: () => String,
    valueOf: () => js.Any
  ): NdArray[T] = {
    val __obj = js.Dynamic.literal(T = T, data = data, hasOwnProperty = js.Any.fromFunction1(hasOwnProperty), isPrototypeOf = js.Any.fromFunction1(isPrototypeOf), ndim = ndim, propertyIsEnumerable = js.Any.fromFunction1(propertyIsEnumerable), slice = js.Any.fromFunction1(slice), toLocaleString = js.Any.fromFunction0(toLocaleString), valueOf = js.Any.fromFunction0(valueOf))
  
    __obj.asInstanceOf[NdArray[T]]
  }
}

