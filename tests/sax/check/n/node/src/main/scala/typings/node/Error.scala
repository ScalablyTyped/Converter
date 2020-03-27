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
}

