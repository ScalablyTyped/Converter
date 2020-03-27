package typings.commander.mod

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@js.native
trait CommandOptions extends js.Object {
  var isDefault: js.UndefOr[Boolean] = js.native
  var noHelp: js.UndefOr[Boolean] = js.native
}

object CommandOptions {
  @scala.inline
  def apply(isDefault: js.UndefOr[Boolean] = js.undefined, noHelp: js.UndefOr[Boolean] = js.undefined): CommandOptions = {
    val __obj = js.Dynamic.literal()
    if (!js.isUndefined(isDefault)) __obj.updateDynamic("isDefault")(isDefault.asInstanceOf[js.Any])
    if (!js.isUndefined(noHelp)) __obj.updateDynamic("noHelp")(noHelp.asInstanceOf[js.Any])
    __obj.asInstanceOf[CommandOptions]
  }
}

