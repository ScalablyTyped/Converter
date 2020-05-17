package typings.numjs.mod

import typings.ndarray.mod.Data
import typings.ndarray.mod.DataType
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

/* Rewritten from type alias, can be one of: 
  - typings.ndarray.mod.DataType
  - typings.ndarray.mod.Data[T]
*/
trait NdType[T] extends js.Object

object NdType {
  @scala.inline
  implicit def apply[T](value: Data[T]): NdType[T] = value.asInstanceOf[NdType[T]]
  @scala.inline
  implicit def apply[T](value: DataType): NdType[T] = value.asInstanceOf[NdType[T]]
}

