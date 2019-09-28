package typings.commander.commanderMod

import scala.scalajs.js.annotation.ScalaJSDefined
import scala.scalajs.js
import scala.scalajs.js.`|`

trait CommandOptions extends js.Object {
  var isDefault: js.UndefOr[Boolean] = js.undefined
  var noHelp: js.UndefOr[Boolean] = js.undefined
}

object CommandOptions {
  @inline
  def apply(isDefault: js.UndefOr[Boolean] = js.undefined, noHelp: js.UndefOr[Boolean] = js.undefined): CommandOptions = {
    val __obj = js.Dynamic.literal()
    if (!js.isUndefined(isDefault)) __obj.updateDynamic("isDefault")(isDefault)
    if (!js.isUndefined(noHelp)) __obj.updateDynamic("noHelp")(noHelp)
    __obj.asInstanceOf[CommandOptions]
  }
}

