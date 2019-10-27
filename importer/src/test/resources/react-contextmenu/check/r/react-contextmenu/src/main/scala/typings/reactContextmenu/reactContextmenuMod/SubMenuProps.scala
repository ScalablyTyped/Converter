package typings.reactContextmenu.reactContextmenuMod

import typings.react.reactMod.ReactElement
import typings.react.reactMod.ReactText
import typings.reactContextmenu.Fn_DataEvent
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

trait SubMenuProps extends js.Object {
  var className: js.UndefOr[String] = js.undefined
  var disabled: js.UndefOr[Boolean] = js.undefined
  var hoverDelay: js.UndefOr[Double] = js.undefined
  var onClick: js.UndefOr[Fn_DataEvent | js.Function] = js.undefined
  var preventCloseOnClick: js.UndefOr[Boolean] = js.undefined
  var rtl: js.UndefOr[Boolean] = js.undefined
  var title: ReactElement | ReactText
}

object SubMenuProps {
  @scala.inline
  def apply(
    title: ReactElement | ReactText,
    className: String = null,
    disabled: js.UndefOr[Boolean] = js.undefined,
    hoverDelay: Int | Double = null,
    onClick: Fn_DataEvent | js.Function = null,
    preventCloseOnClick: js.UndefOr[Boolean] = js.undefined,
    rtl: js.UndefOr[Boolean] = js.undefined
  ): SubMenuProps = {
    val __obj = js.Dynamic.literal(title = title.asInstanceOf[js.Any])
    if (className != null) __obj.updateDynamic("className")(className)
    if (!js.isUndefined(disabled)) __obj.updateDynamic("disabled")(disabled)
    if (hoverDelay != null) __obj.updateDynamic("hoverDelay")(hoverDelay.asInstanceOf[js.Any])
    if (onClick != null) __obj.updateDynamic("onClick")(onClick.asInstanceOf[js.Any])
    if (!js.isUndefined(preventCloseOnClick)) __obj.updateDynamic("preventCloseOnClick")(preventCloseOnClick)
    if (!js.isUndefined(rtl)) __obj.updateDynamic("rtl")(rtl)
    __obj.asInstanceOf[SubMenuProps]
  }
}

