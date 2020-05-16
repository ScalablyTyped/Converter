package typings.materialUi.MaterialUI.Styles

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@js.native
trait MuiTheme extends js.Object {
  var spacing: js.UndefOr[js.Any] = js.native
}

object MuiTheme {
  @scala.inline
  def apply(spacing: js.Any = null): MuiTheme = {
    val __obj = js.Dynamic.literal()
    if (spacing != null) __obj.updateDynamic("spacing")(spacing.asInstanceOf[js.Any])
    __obj.asInstanceOf[MuiTheme]
  }
  @scala.inline
  implicit class MuiThemeOps[Self <: MuiTheme] (val x: Self) extends AnyVal {
    @scala.inline
    def duplicate: Self = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x)).asInstanceOf[Self]
    @scala.inline
    def combineWith[Other /* <: js.Any */](other: Other): Self with Other = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x, other.asInstanceOf[js.Any])).asInstanceOf[Self with Other]
    @scala.inline
    def withSpacing(spacing: js.Any): Self = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (spacing != null) ret.updateDynamic("spacing")(spacing.asInstanceOf[js.Any])
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withoutSpacing: Self = {
        val ret = this.duplicate
        js.special.delete(ret, "spacing")
        ret.asInstanceOf[Self]
    }
  }
  
}

