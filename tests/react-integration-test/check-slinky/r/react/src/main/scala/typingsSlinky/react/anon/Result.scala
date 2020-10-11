package typingsSlinky.react.anon

import slinky.core.ReactComponentClass
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

@js.native
trait Result[T /* <: ReactComponentClass[_] */] extends js.Object {
  val _result: T = js.native
}

object Result {
  @scala.inline
  def apply[T /* <: ReactComponentClass[_] */](_result: T): Result[T] = {
    val __obj = js.Dynamic.literal(_result = _result.asInstanceOf[js.Any])
    __obj.asInstanceOf[Result[T]]
  }
  @scala.inline
  implicit class ResultOps[Self <: Result[_], T /* <: ReactComponentClass[_] */] (val x: Self with Result[T]) extends AnyVal {
    @scala.inline
    def duplicate: Self = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x)).asInstanceOf[Self]
    @scala.inline
    def combineWith[Other <: js.Any](other: Other): Self with Other = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x, other.asInstanceOf[js.Any])).asInstanceOf[Self with Other]
    @scala.inline
    def set(key: String, value: js.Any): Self = {
        x.asInstanceOf[js.Dynamic].updateDynamic(key)(value)
        x
    }
    @scala.inline
    def set_result(value: T): Self = this.set("_result", value.asInstanceOf[js.Any])
  }
  
}

