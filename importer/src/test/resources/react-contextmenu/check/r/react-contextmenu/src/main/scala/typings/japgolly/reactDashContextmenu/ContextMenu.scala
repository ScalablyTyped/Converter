package typings.japgolly.reactDashContextmenu

import japgolly.scalajs.react.Callback
import japgolly.scalajs.react.CtorType.ChildArg
import japgolly.scalajs.react.Key
import japgolly.scalajs.react.ReactMouseEventFrom
import japgolly.scalajs.react.component.JsForwardRef.UnmountedWithRoot
import org.scalablytyped.runtime.StringDictionary
import org.scalajs.dom.raw.HTMLElement
import typings.reactDashContextmenu.reactDashContextmenuMod.ContextMenuProps
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

object ContextMenu {
  def apply(
    id: String,
    className: String = null,
    data: js.Any = null,
    hideOnLeave: js.UndefOr[Boolean] = js.undefined,
    onHide: js.UndefOr[/* event */ js.Any => Callback] = js.undefined,
    onMouseLeave: (js.Function3[
      /* event */ ReactMouseEventFrom[HTMLElement], 
      /* import warning: QualifyReferences.resolveTypeRef many Couldn't qualify Object */ /* data */ js.Any, 
      /* target */ HTMLElement, 
      Unit
    ]) | js.Function = null,
    onShow: js.UndefOr[/* event */ js.Any => Callback] = js.undefined,
    rtl: js.UndefOr[Boolean] = js.undefined,
    key: js.UndefOr[Key] = js.undefined,
    overrides: StringDictionary[js.Any] = null
  )(
    children: ChildArg*
  ): UnmountedWithRoot[
    ContextMenuProps, 
    typings.reactDashContextmenu.reactDashContextmenuMod.ContextMenu, 
    Unit, 
    ContextMenuProps
  ] = {
    val __obj = js.Dynamic.literal(id = id)
  
      if (className != null) __obj.updateDynamic("className")(className)
    if (data != null) __obj.updateDynamic("data")(data)
    if (!js.isUndefined(hideOnLeave)) __obj.updateDynamic("hideOnLeave")(hideOnLeave)
    onHide.foreach(p => __obj.updateDynamic("onHide")(js.Any.fromFunction1(((t0: /* event */ js.Any) => p(t0).runNow()))))
    if (onMouseLeave != null) __obj.updateDynamic("onMouseLeave")(onMouseLeave.asInstanceOf[js.Any])
    onShow.foreach(p => __obj.updateDynamic("onShow")(js.Any.fromFunction1(((t0: /* event */ js.Any) => p(t0).runNow()))))
    if (!js.isUndefined(rtl)) __obj.updateDynamic("rtl")(rtl)
    key.foreach(k => __obj.updateDynamic("key")(k.asInstanceOf[js.Any]))
    if (overrides != null) js.Dynamic.global.Object.assign(__obj, overrides)
  
    val f = japgolly.scalajs.react.JsForwardRefComponent.force[
  typings.reactDashContextmenu.reactDashContextmenuMod.ContextMenuProps, 
  japgolly.scalajs.react.Children.Varargs, 
  typings.reactDashContextmenu.reactDashContextmenuMod.ContextMenu](js.constructorOf[typings.reactDashContextmenu.reactDashContextmenuMod.ContextMenu])
    f(__obj.asInstanceOf[typings.reactDashContextmenu.reactDashContextmenuMod.ContextMenuProps])(children: _*)
  }
}

