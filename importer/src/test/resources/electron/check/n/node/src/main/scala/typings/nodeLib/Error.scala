package typings.nodeLib

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

trait Error extends js.Object {
  var stack: js.UndefOr[String] = js.undefined
}

object Error {
  @scala.inline
  def apply(stack: String = null): Error = {
    val __obj = js.Dynamic.literal()
    if (stack != null) __obj.updateDynamic("stack")(stack)
    __obj.asInstanceOf[Error]
  }
}

