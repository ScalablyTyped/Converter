package typings.unionToInheritance

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@js.native
trait Either[L, R]
  extends Legal3[js.Any, L, R]
     with _Test[js.Any, L, R]
     with _Test2[R, L] {
  var value: R = js.native
}

object Either {
  @scala.inline
  def apply[L, R](value: R): Either[L, R] = {
    val __obj = js.Dynamic.literal(value = value.asInstanceOf[js.Any])
    __obj.asInstanceOf[Either[L, R]]
  }
  @scala.inline
  implicit class EitherOps[Self[l, r] <: Either[l, r], L, R] (val x: Self[L, R]) extends AnyVal {
    @scala.inline
    def duplicate: Self[L, R] = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x)).asInstanceOf[Self[L, R]]
    @scala.inline
    def combineWith[Other /* <: js.Any */](other: Other): (Self[L, R]) with Other = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x, other.asInstanceOf[js.Any])).asInstanceOf[(Self[L, R]) with Other]
    @scala.inline
    def withValue(value: R): Self[L, R] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        ret.updateDynamic("value")(value.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[L, R]]
    }
  }
  
}

