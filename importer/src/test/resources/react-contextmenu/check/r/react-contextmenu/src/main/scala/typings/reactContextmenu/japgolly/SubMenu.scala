package typings.reactContextmenu.japgolly

import japgolly.scalajs.react.CtorType.ChildArg
import japgolly.scalajs.react.Key
import japgolly.scalajs.react.component.JsForwardRef.UnmountedWithRoot
import japgolly.scalajs.react.raw.React.Element
import typings.react.reactMod.ReactText
import typings.reactContextmenu.Fn_DataEvent
import typings.reactContextmenu.reactContextmenuMod.SubMenuProps
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

object SubMenu {
  def apply(
    title: Element | ReactText,
    key: js.UndefOr[Key] = js.undefined,
    className: String = null,
    disabled: js.UndefOr[Boolean] = js.undefined,
    hoverDelay: Int | Double = null,
    onClick: Fn_DataEvent | js.Function = null,
    preventCloseOnClick: js.UndefOr[Boolean] = js.undefined,
    rtl: js.UndefOr[Boolean] = js.undefined
  )(
    children: ChildArg*
  ): UnmountedWithRoot[SubMenuProps, typings.reactContextmenu.reactContextmenuMod.SubMenu, Unit, SubMenuProps] = {
    val __obj = js.Dynamic.literal(title = title.asInstanceOf[js.Any])
  
      key.foreach(k => __obj.updateDynamic("key")(k.asInstanceOf[js.Any]))
    if (className != null) __obj.updateDynamic("className")(className)
    if (!js.isUndefined(disabled)) __obj.updateDynamic("disabled")(disabled)
    if (hoverDelay != null) __obj.updateDynamic("hoverDelay")(hoverDelay.asInstanceOf[js.Any])
    if (onClick != null) __obj.updateDynamic("onClick")(onClick.asInstanceOf[js.Any])
    if (!js.isUndefined(preventCloseOnClick)) __obj.updateDynamic("preventCloseOnClick")(preventCloseOnClick)
    if (!js.isUndefined(rtl)) __obj.updateDynamic("rtl")(rtl)
  
    val f = japgolly.scalajs.react.JsForwardRefComponent.force[
  typings.reactContextmenu.reactContextmenuMod.SubMenuProps, 
  japgolly.scalajs.react.Children.Varargs, 
  typings.reactContextmenu.reactContextmenuMod.SubMenu](js.constructorOf[typings.reactContextmenu.reactContextmenuMod.SubMenu])
    f(__obj.asInstanceOf[typings.reactContextmenu.reactContextmenuMod.SubMenuProps])(children: _*)
  }
}

