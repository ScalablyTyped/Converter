package typings.node

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@js.native
trait Error extends js.Object {
  var stack: js.UndefOr[String] = js.native
}

object Error {
  @scala.inline
  def apply(stack: String = null): Error = {
    val __obj = js.Dynamic.literal()
    if (stack != null) __obj.updateDynamic("stack")(stack.asInstanceOf[js.Any])
    __obj.asInstanceOf[Error]
  }
  @scala.inline
  implicit class ErrorOps[Self <: Error] (val x: Self) extends AnyVal {
    @scala.inline
    def duplicate: Self = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x)).asInstanceOf[Self]
    @scala.inline
    def combineWith[Other /* <: js.Any */](other: Other): Self with Other = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x, other.asInstanceOf[js.Any])).asInstanceOf[Self with Other]
    @scala.inline
    def withStack(stack: String): Self = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (stack != null) ret.updateDynamic("stack")(stack.asInstanceOf[js.Any])
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withoutStack: Self = {
        val ret = this.duplicate
        js.special.delete(ret, "stack")
        ret.asInstanceOf[Self]
    }
  }
  
}

