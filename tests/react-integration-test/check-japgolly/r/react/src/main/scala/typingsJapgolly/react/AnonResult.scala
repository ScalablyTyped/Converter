package typingsJapgolly.react

import typingsJapgolly.react.mod.ComponentType
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@js.native
trait AnonResult[T /* <: ComponentType[_] */] extends js.Object {
  val _result: T = js.native
}

object AnonResult {
  @scala.inline
  def apply[T /* <: ComponentType[_] */](_result: T): AnonResult[T] = {
    val __obj = js.Dynamic.literal(_result = _result.asInstanceOf[js.Any])
  
    __obj.asInstanceOf[AnonResult[T]]
  }
}

