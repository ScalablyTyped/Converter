package typings.unionToInheritance

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@js.native
trait Either[L, R]
  extends Legal3[js.Any, L, R]
     with Test[js.Any, L, R]
     with Test2[R, L] {
  var value: R = js.native
}

object Either {
  @scala.inline
  def apply[L, R](value: R): Either[L, R] = {
    val __obj = js.Dynamic.literal(value = value.asInstanceOf[js.Any])
    __obj.asInstanceOf[Either[L, R]]
  }
  @scala.inline
  implicit class EitherOps[Self <: Either[_, _], L, R] (val x: Self with (Either[L, R])) extends AnyVal {
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
    def setValue(value: R): Self = this.set("value", value.asInstanceOf[js.Any])
  }
  
}

