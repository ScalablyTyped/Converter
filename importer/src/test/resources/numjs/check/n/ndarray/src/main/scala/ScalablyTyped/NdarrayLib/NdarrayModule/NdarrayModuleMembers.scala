package ScalablyTyped
package NdarrayLib.NdarrayModule

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@JSImport("ndarray", JSImport.Namespace)
@js.native
object NdarrayModuleMembers extends js.Object {
  def apply[T](data: NdarrayLib.NdarrayModule.ndarrayNamespace.Data[T]): ndarray[T] = js.native
  def apply[T](data: NdarrayLib.NdarrayModule.ndarrayNamespace.Data[T], shape: js.Array[scala.Double]): ndarray[T] = js.native
  def apply[T](
    data: NdarrayLib.NdarrayModule.ndarrayNamespace.Data[T],
    shape: js.Array[scala.Double],
    stride: js.Array[scala.Double]
  ): ndarray[T] = js.native
  def apply[T](
    data: NdarrayLib.NdarrayModule.ndarrayNamespace.Data[T],
    shape: js.Array[scala.Double],
    stride: js.Array[scala.Double],
    offset: scala.Double
  ): ndarray[T] = js.native
}

