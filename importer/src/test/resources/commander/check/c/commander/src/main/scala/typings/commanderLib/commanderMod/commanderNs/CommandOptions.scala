package typings
package commanderLib.commanderMod.commanderNs

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

trait CommandOptions extends js.Object {
  var isDefault: js.UndefOr[scala.Boolean] = js.undefined
  var noHelp: js.UndefOr[scala.Boolean] = js.undefined
}

object CommandOptions {
  @scala.inline
  def apply(
    isDefault: js.UndefOr[scala.Boolean] = js.undefined,
    noHelp: js.UndefOr[scala.Boolean] = js.undefined
  ): CommandOptions = {
    val __obj = js.Dynamic.literal()
    if (!js.isUndefined(isDefault)) __obj.updateDynamic("isDefault")(isDefault)
    if (!js.isUndefined(noHelp)) __obj.updateDynamic("noHelp")(noHelp)
    __obj.asInstanceOf[CommandOptions]
  }
}

