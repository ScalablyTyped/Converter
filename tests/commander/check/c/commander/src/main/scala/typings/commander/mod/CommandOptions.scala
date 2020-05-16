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
  def apply(): CommandOptions = {
    val __obj = js.Dynamic.literal()
    __obj.asInstanceOf[CommandOptions]
  }
  @scala.inline
  implicit class CommandOptionsOps[Self <: CommandOptions] (val x: Self) extends AnyVal {
    @scala.inline
    def duplicate: Self = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x)).asInstanceOf[Self]
    @scala.inline
    def combineWith[Other /* <: js.Any */](other: Other): Self with Other = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x, other.asInstanceOf[js.Any])).asInstanceOf[Self with Other]
    @scala.inline
    def withIsDefault(value: Boolean): Self = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("isDefault")(value.asInstanceOf[js.Any])
        ret
    }
    @scala.inline
    def withoutIsDefault: Self = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("isDefault")(js.undefined)
        ret
    }
    @scala.inline
    def withNoHelp(value: Boolean): Self = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("noHelp")(value.asInstanceOf[js.Any])
        ret
    }
    @scala.inline
    def withoutNoHelp: Self = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("noHelp")(js.undefined)
        ret
    }
  }
  
}

