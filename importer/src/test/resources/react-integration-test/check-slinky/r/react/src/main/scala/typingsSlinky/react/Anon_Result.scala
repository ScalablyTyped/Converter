package typingsSlinky.react

import slinky.core.ReactComponentClass
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@js.native
trait Anon_Result[T /* <: ReactComponentClass[_] */] extends js.Object {
  val _result: T = js.native
}

object Anon_Result {
  @scala.inline
  def apply[T /* <: ReactComponentClass[_] */](_result: T): Anon_Result[T] = {
    val __obj = js.Dynamic.literal(_result = _result.asInstanceOf[js.Any])
  
    __obj.asInstanceOf[Anon_Result[T]]
  }
}

