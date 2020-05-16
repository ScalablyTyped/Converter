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
  @scala.inline
  implicit class CommandOptionsOps[Self <: CommandOptions] (val x: Self) extends AnyVal {
    @scala.inline
    def duplicate: Self = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x)).asInstanceOf[Self]
    @scala.inline
    def combineWith[Other /* <: js.Any */](other: Other): Self with Other = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x, other.asInstanceOf[js.Any])).asInstanceOf[Self with Other]
    @scala.inline
    def withIsDefault(isDefault: js.UndefOr[Boolean]): Self = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (!js.isUndefined(isDefault)) ret.updateDynamic("isDefault")(isDefault.asInstanceOf[js.Any])
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withoutIsDefault: Self = {
        val ret = this.duplicate
        js.special.delete(ret, "isDefault")
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withNoHelp(noHelp: js.UndefOr[Boolean]): Self = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (!js.isUndefined(noHelp)) ret.updateDynamic("noHelp")(noHelp.asInstanceOf[js.Any])
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withoutNoHelp: Self = {
        val ret = this.duplicate
        js.special.delete(ret, "noHelp")
        ret.asInstanceOf[Self]
    }
  }
  
}

