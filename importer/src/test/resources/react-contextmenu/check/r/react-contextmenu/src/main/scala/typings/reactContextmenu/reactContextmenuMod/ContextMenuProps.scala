package typings.reactContextmenu.reactContextmenuMod

import typings.reactContextmenu.Fn_Data
import typings.reactContextmenu.Fn_Event
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

trait ContextMenuProps extends js.Object {
  var className: js.UndefOr[String] = js.undefined
  var data: js.UndefOr[js.Any] = js.undefined
  var hideOnLeave: js.UndefOr[Boolean] = js.undefined
  var id: String
  var onHide: js.UndefOr[Fn_Event] = js.undefined
  var onMouseLeave: js.UndefOr[Fn_Data | js.Function] = js.undefined
  var onShow: js.UndefOr[Fn_Event] = js.undefined
  var rtl: js.UndefOr[Boolean] = js.undefined
}

object ContextMenuProps {
  @scala.inline
  def apply(
    id: String,
    className: String = null,
    data: js.Any = null,
    hideOnLeave: js.UndefOr[Boolean] = js.undefined,
    onHide: Fn_Event = null,
    onMouseLeave: Fn_Data | js.Function = null,
    onShow: Fn_Event = null,
    rtl: js.UndefOr[Boolean] = js.undefined
  ): ContextMenuProps = {
    val __obj = js.Dynamic.literal(id = id)
    if (className != null) __obj.updateDynamic("className")(className)
    if (data != null) __obj.updateDynamic("data")(data)
    if (!js.isUndefined(hideOnLeave)) __obj.updateDynamic("hideOnLeave")(hideOnLeave)
    if (onHide != null) __obj.updateDynamic("onHide")(onHide)
    if (onMouseLeave != null) __obj.updateDynamic("onMouseLeave")(onMouseLeave.asInstanceOf[js.Any])
    if (onShow != null) __obj.updateDynamic("onShow")(onShow)
    if (!js.isUndefined(rtl)) __obj.updateDynamic("rtl")(rtl)
    __obj.asInstanceOf[ContextMenuProps]
  }
}

