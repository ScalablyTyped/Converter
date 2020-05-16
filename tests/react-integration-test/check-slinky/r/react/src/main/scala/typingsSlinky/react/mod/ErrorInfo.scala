package typingsSlinky.react.mod

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

//
// Error Interfaces
// ----------------------------------------------------------------------
@js.native
trait ErrorInfo extends js.Object {
  /**
    * Captures which component contained the exception, and its ancestors.
    */
  var componentStack: String = js.native
}

object ErrorInfo {
  @scala.inline
  def apply(componentStack: String): ErrorInfo = {
    val __obj = js.Dynamic.literal(componentStack = componentStack.asInstanceOf[js.Any])
    __obj.asInstanceOf[ErrorInfo]
  }
  @scala.inline
  implicit class ErrorInfoOps[Self <: ErrorInfo] (val x: Self) extends AnyVal {
    @scala.inline
    def duplicate: Self = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x)).asInstanceOf[Self]
    @scala.inline
    def combineWith[Other /* <: js.Any */](other: Other): Self with Other = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x, other.asInstanceOf[js.Any])).asInstanceOf[Self with Other]
    @scala.inline
    def withComponentStack(componentStack: String): Self = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        ret.updateDynamic("componentStack")(componentStack.asInstanceOf[js.Any])
        ret.asInstanceOf[Self]
    }
  }
  
}

