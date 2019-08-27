package typings.commander.commanderMod

import org.scalablytyped.runtime.UndefOr
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

trait CommandOptions extends js.Object {
  var isDefault: UndefOr[Boolean] = js.undefined
  var noHelp: UndefOr[Boolean] = js.undefined
}

object CommandOptions {
  @scala.inline
  def apply(isDefault: `<undefined>` | Boolean = js.undefined, noHelp: `<undefined>` | Boolean = js.undefined): CommandOptions = {
    val __obj = js.Dynamic.literal()
    if (!js.isUndefined(isDefault)) __obj.updateDynamic("isDefault")(isDefault)
    if (!js.isUndefined(noHelp)) __obj.updateDynamic("noHelp")(noHelp)
    __obj.asInstanceOf[CommandOptions]
  }
}

