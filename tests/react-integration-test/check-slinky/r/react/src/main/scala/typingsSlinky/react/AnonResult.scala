package typingsSlinky.react

import slinky.core.ReactComponentClass
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@js.native
trait AnonResult[T /* <: ReactComponentClass[_] */] extends js.Object {
  val _result: T = js.native
}

object AnonResult {
  @scala.inline
  def apply[T /* <: ReactComponentClass[_] */](_result: T): AnonResult[T] = {
    val __obj = js.Dynamic.literal(_result = _result.asInstanceOf[js.Any])
    __obj.asInstanceOf[AnonResult[T]]
  }
  @scala.inline
  implicit class AnonResultOps[Self[t /* <: typingsSlinky.react.mod.ComponentType[_] */] <: AnonResult[t], T] (val x: Self[T]) extends AnyVal {
    @scala.inline
    def duplicate: Self[T] = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x)).asInstanceOf[Self[T]]
    @scala.inline
    def combineWith[Other /* <: js.Any */](other: Other): Self[T] with Other = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x, other.asInstanceOf[js.Any])).asInstanceOf[Self[T] with Other]
    @scala.inline
    def with_result(value: T): Self[T] = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("_result")(value.asInstanceOf[js.Any])
        ret
    }
  }
  
}

