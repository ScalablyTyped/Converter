package typingsJapgolly.materialUi.__MaterialUI.Styles

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

trait MuiTheme extends js.Object {
  var spacing: js.UndefOr[js.Any] = js.undefined
}

object MuiTheme {
  @scala.inline
  def apply(spacing: js.Any = null): MuiTheme = {
    val __obj = js.Dynamic.literal()
    if (spacing != null) __obj.updateDynamic("spacing")(spacing.asInstanceOf[js.Any])
    __obj.asInstanceOf[MuiTheme]
  }
}

