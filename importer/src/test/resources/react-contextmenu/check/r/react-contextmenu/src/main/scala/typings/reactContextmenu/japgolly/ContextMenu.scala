package typings.reactContextmenu.japgolly

import japgolly.scalajs.react.CtorType.ChildArg
import japgolly.scalajs.react.Key
import japgolly.scalajs.react.component.JsForwardRef.UnmountedWithRoot
import typings.reactContextmenu.Fn_Data
import typings.reactContextmenu.Fn_Event
import typings.reactContextmenu.reactContextmenuMod.ContextMenuProps
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

object ContextMenu {
  def apply(
    id: String,
    key: js.UndefOr[Key] = js.undefined,
    className: String = null,
    data: js.Any = null,
    hideOnLeave: js.UndefOr[Boolean] = js.undefined,
    onHide: Fn_Event = null,
    onMouseLeave: Fn_Data | js.Function = null,
    onShow: Fn_Event = null,
    rtl: js.UndefOr[Boolean] = js.undefined
  )(
    children: ChildArg*
  ): UnmountedWithRoot[
    ContextMenuProps, 
    typings.reactContextmenu.reactContextmenuMod.ContextMenu, 
    Unit, 
    ContextMenuProps
  ] = {
    val __obj = js.Dynamic.literal(id = id)
  
      key.foreach(k => __obj.updateDynamic("key")(k.asInstanceOf[js.Any]))
    if (className != null) __obj.updateDynamic("className")(className)
    if (data != null) __obj.updateDynamic("data")(data)
    if (!js.isUndefined(hideOnLeave)) __obj.updateDynamic("hideOnLeave")(hideOnLeave)
    if (onHide != null) __obj.updateDynamic("onHide")(onHide)
    if (onMouseLeave != null) __obj.updateDynamic("onMouseLeave")(onMouseLeave.asInstanceOf[js.Any])
    if (onShow != null) __obj.updateDynamic("onShow")(onShow)
    if (!js.isUndefined(rtl)) __obj.updateDynamic("rtl")(rtl)
  
    val f = japgolly.scalajs.react.JsForwardRefComponent.force[
  typings.reactContextmenu.reactContextmenuMod.ContextMenuProps, 
  japgolly.scalajs.react.Children.Varargs, 
  typings.reactContextmenu.reactContextmenuMod.ContextMenu](js.constructorOf[typings.reactContextmenu.reactContextmenuMod.ContextMenu])
    f(__obj.asInstanceOf[typings.reactContextmenu.reactContextmenuMod.ContextMenuProps])(children: _*)
  }
}

