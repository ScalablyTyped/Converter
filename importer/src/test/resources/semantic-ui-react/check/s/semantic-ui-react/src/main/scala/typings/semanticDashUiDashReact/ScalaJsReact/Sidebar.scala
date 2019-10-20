package typings.semanticDashUiDashReact.ScalaJsReact

import japgolly.scalajs.react.Callback
import japgolly.scalajs.react.CtorType.ChildArg
import japgolly.scalajs.react.ReactMouseEventFrom
import japgolly.scalajs.react.component.JsForwardRef.UnmountedWithRoot
import org.scalablytyped.runtime.StringDictionary
import org.scalajs.dom.raw.HTMLElement
import typings.react.reactMod.RefObject
import typings.semanticDashUiDashReact.semanticDashUiDashReactStrings.`scale down`
import typings.semanticDashUiDashReact.semanticDashUiDashReactStrings.`slide along`
import typings.semanticDashUiDashReact.semanticDashUiDashReactStrings.`slide out`
import typings.semanticDashUiDashReact.semanticDashUiDashReactStrings.`very thin`
import typings.semanticDashUiDashReact.semanticDashUiDashReactStrings.`very wide`
import typings.semanticDashUiDashReact.semanticDashUiDashReactStrings.bottom
import typings.semanticDashUiDashReact.semanticDashUiDashReactStrings.left
import typings.semanticDashUiDashReact.semanticDashUiDashReactStrings.overlay
import typings.semanticDashUiDashReact.semanticDashUiDashReactStrings.push
import typings.semanticDashUiDashReact.semanticDashUiDashReactStrings.right
import typings.semanticDashUiDashReact.semanticDashUiDashReactStrings.thin
import typings.semanticDashUiDashReact.semanticDashUiDashReactStrings.top
import typings.semanticDashUiDashReact.semanticDashUiDashReactStrings.uncover
import typings.semanticDashUiDashReact.semanticDashUiDashReactStrings.wide
import typings.semanticDashUiDashReact.srcGenericMod.SemanticShorthandContent
import typings.semanticDashUiDashReact.srcModulesSidebarMod.default
import typings.semanticDashUiDashReact.srcModulesSidebarSidebarMod.SidebarProps
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

object Sidebar {
  def apply(
    StringDictionary: /* key */ StringDictionary[js.Any] = null,
    animation: overlay | push | (`scale down`) | uncover | (`slide out`) | (`slide along`) = null,
    as: js.Any = null,
    className: String = null,
    content: SemanticShorthandContent = null,
    direction: top | right | bottom | left = null,
    onHidden: (/* event */ ReactMouseEventFrom[HTMLElement], /* data */ SidebarProps) => Callback = null,
    onHide: (/* event */ ReactMouseEventFrom[HTMLElement], /* data */ SidebarProps) => Callback = null,
    onShow: (/* event */ ReactMouseEventFrom[HTMLElement], /* data */ SidebarProps) => Callback = null,
    onVisible: (/* event */ ReactMouseEventFrom[HTMLElement], /* data */ SidebarProps) => Callback = null,
    target: js.Object | RefObject[HTMLElement] = null,
    visible: js.UndefOr[Boolean] = js.undefined,
    width: (`very thin`) | thin | wide | (`very wide`) = null
  )(
    children: ChildArg*
  ): UnmountedWithRoot[SidebarProps, default, Unit, SidebarProps] = {
    val __obj = js.Dynamic.literal()
  
      js.Dynamic.global.Object.assign(__obj, StringDictionary)
    if (animation != null) __obj.updateDynamic("animation")(animation.asInstanceOf[js.Any])
    if (as != null) __obj.updateDynamic("as")(as)
    if (className != null) __obj.updateDynamic("className")(className)
    if (content != null) __obj.updateDynamic("content")(content.asInstanceOf[js.Any])
    if (direction != null) __obj.updateDynamic("direction")(direction.asInstanceOf[js.Any])
    if (onHidden != null) __obj.updateDynamic("onHidden")(js.Any.fromFunction2(((t0: /* event */ japgolly.scalajs.react.ReactMouseEventFrom[org.scalajs.dom.raw.HTMLElement], t1: /* data */ typings.semanticDashUiDashReact.srcModulesSidebarSidebarMod.SidebarProps) => onHidden(t0, t1).runNow())))
    if (onHide != null) __obj.updateDynamic("onHide")(js.Any.fromFunction2(((t0: /* event */ japgolly.scalajs.react.ReactMouseEventFrom[org.scalajs.dom.raw.HTMLElement], t1: /* data */ typings.semanticDashUiDashReact.srcModulesSidebarSidebarMod.SidebarProps) => onHide(t0, t1).runNow())))
    if (onShow != null) __obj.updateDynamic("onShow")(js.Any.fromFunction2(((t0: /* event */ japgolly.scalajs.react.ReactMouseEventFrom[org.scalajs.dom.raw.HTMLElement], t1: /* data */ typings.semanticDashUiDashReact.srcModulesSidebarSidebarMod.SidebarProps) => onShow(t0, t1).runNow())))
    if (onVisible != null) __obj.updateDynamic("onVisible")(js.Any.fromFunction2(((t0: /* event */ japgolly.scalajs.react.ReactMouseEventFrom[org.scalajs.dom.raw.HTMLElement], t1: /* data */ typings.semanticDashUiDashReact.srcModulesSidebarSidebarMod.SidebarProps) => onVisible(t0, t1).runNow())))
    if (target != null) __obj.updateDynamic("target")(target.asInstanceOf[js.Any])
    if (!js.isUndefined(visible)) __obj.updateDynamic("visible")(visible)
    if (width != null) __obj.updateDynamic("width")(width.asInstanceOf[js.Any])
  
    val f = japgolly.scalajs.react.JsForwardRefComponent.force[
  typings.semanticDashUiDashReact.srcModulesSidebarSidebarMod.SidebarProps, 
  japgolly.scalajs.react.Children.Varargs, 
  typings.semanticDashUiDashReact.srcModulesSidebarMod.default](js.constructorOf[typings.semanticDashUiDashReact.srcModulesSidebarMod.default])
    f(__obj.asInstanceOf[typings.semanticDashUiDashReact.srcModulesSidebarSidebarMod.SidebarProps])(children: _*)
  }
}

