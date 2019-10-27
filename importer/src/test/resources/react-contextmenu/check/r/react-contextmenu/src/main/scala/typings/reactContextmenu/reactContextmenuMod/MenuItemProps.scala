package typings.reactContextmenu.reactContextmenuMod

import typings.react.reactMod.HTMLAttributes
import typings.reactContextmenu.Fn_DataEvent
import typings.std.HTMLDivElement
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

trait MenuItemProps extends js.Object {
  var attributes: js.UndefOr[HTMLAttributes[HTMLDivElement]] = js.undefined
  var className: js.UndefOr[String] = js.undefined
  var data: js.UndefOr[
    /* import warning: QualifyReferences.resolveTypeRef many Couldn't qualify Object */ js.Any
  ] = js.undefined
  var disabled: js.UndefOr[Boolean] = js.undefined
  var divider: js.UndefOr[Boolean] = js.undefined
  var onClick: js.UndefOr[Fn_DataEvent | js.Function] = js.undefined
  var preventClose: js.UndefOr[Boolean] = js.undefined
}

object MenuItemProps {
  @scala.inline
  def apply(
    attributes: HTMLAttributes[HTMLDivElement] = null,
    className: String = null,
    data: /* import warning: QualifyReferences.resolveTypeRef many Couldn't qualify Object */ js.Any = null,
    disabled: js.UndefOr[Boolean] = js.undefined,
    divider: js.UndefOr[Boolean] = js.undefined,
    onClick: Fn_DataEvent | js.Function = null,
    preventClose: js.UndefOr[Boolean] = js.undefined
  ): MenuItemProps = {
    val __obj = js.Dynamic.literal()
    if (attributes != null) __obj.updateDynamic("attributes")(attributes)
    if (className != null) __obj.updateDynamic("className")(className)
    if (data != null) __obj.updateDynamic("data")(data)
    if (!js.isUndefined(disabled)) __obj.updateDynamic("disabled")(disabled)
    if (!js.isUndefined(divider)) __obj.updateDynamic("divider")(divider)
    if (onClick != null) __obj.updateDynamic("onClick")(onClick.asInstanceOf[js.Any])
    if (!js.isUndefined(preventClose)) __obj.updateDynamic("preventClose")(preventClose)
    __obj.asInstanceOf[MenuItemProps]
  }
}

