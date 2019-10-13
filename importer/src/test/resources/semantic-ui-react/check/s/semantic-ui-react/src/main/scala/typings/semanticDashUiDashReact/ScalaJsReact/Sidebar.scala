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
import typings.semanticDashUiDashReact.semanticDashUiDashReactStrings.overlay
import typings.semanticDashUiDashReact.semanticDashUiDashReactStrings.push
import typings.semanticDashUiDashReact.semanticDashUiDashReactStrings.uncover
import typings.semanticDashUiDashReact.srcGenericMod.SemanticShorthandContent
import typings.semanticDashUiDashReact.srcModulesSidebarMod.default
import typings.semanticDashUiDashReact.srcModulesSidebarSidebarMod.SidebarProps
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

/* The following DOM/SVG props were specified: children, className, direction, width */
object Sidebar {
  def apply(
    StringDictionary: /* key */ StringDictionary[js.Any] = null,
    animation: overlay | push | (`scale down`) | uncover | (`slide out`) | (`slide along`) = null,
    as: js.Any = null,
    content: SemanticShorthandContent = null,
    onHidden: (/* event */ ReactMouseEventFrom[HTMLElement], /* data */ SidebarProps) => Callback = null,
    onHide: (/* event */ ReactMouseEventFrom[HTMLElement], /* data */ SidebarProps) => Callback = null,
    onShow: (/* event */ ReactMouseEventFrom[HTMLElement], /* data */ SidebarProps) => Callback = null,
    onVisible: (/* event */ ReactMouseEventFrom[HTMLElement], /* data */ SidebarProps) => Callback = null,
    target: js.Object | RefObject[HTMLElement] = null,
    visible: js.UndefOr[Boolean] = js.undefined
  )(
    children: /** Primary content. */
  ChildArg*
  ): UnmountedWithRoot[SidebarProps, default, Unit, SidebarProps] = {
    import japgolly.scalajs.react.Children
    import japgolly.scalajs.react.JsForwardRefComponent
  
    val __obj = js.Dynamic.literal()
  
    type SidebarType = typings.semanticDashUiDashReact.srcModulesSidebarMod.default
  
      js.Dynamic.global.Object.assign(__obj, StringDictionary)
    if (animation != null) __obj.updateDynamic("animation")(animation.asInstanceOf[js.Any])
    if (as != null) __obj.updateDynamic("as")(as)
    if (content != null) __obj.updateDynamic("content")(content.asInstanceOf[js.Any])
        if (onHidden != null) __obj.updateDynamic("onHidden")(js.Any.fromFunction2(((t0: /* event */ japgolly.scalajs.react.ReactMouseEventFrom[org.scalajs.dom.raw.HTMLElement], t1: /* data */ typings.semanticDashUiDashReact.srcModulesSidebarSidebarMod.SidebarProps) => onHidden(t0, t1).runNow())))
        if (onHide != null) __obj.updateDynamic("onHide")(js.Any.fromFunction2(((t0: /* event */ japgolly.scalajs.react.ReactMouseEventFrom[org.scalajs.dom.raw.HTMLElement], t1: /* data */ typings.semanticDashUiDashReact.srcModulesSidebarSidebarMod.SidebarProps) => onHide(t0, t1).runNow())))
        if (onShow != null) __obj.updateDynamic("onShow")(js.Any.fromFunction2(((t0: /* event */ japgolly.scalajs.react.ReactMouseEventFrom[org.scalajs.dom.raw.HTMLElement], t1: /* data */ typings.semanticDashUiDashReact.srcModulesSidebarSidebarMod.SidebarProps) => onShow(t0, t1).runNow())))
        if (onVisible != null) __obj.updateDynamic("onVisible")(js.Any.fromFunction2(((t0: /* event */ japgolly.scalajs.react.ReactMouseEventFrom[org.scalajs.dom.raw.HTMLElement], t1: /* data */ typings.semanticDashUiDashReact.srcModulesSidebarSidebarMod.SidebarProps) => onVisible(t0, t1).runNow())))
    if (target != null) __obj.updateDynamic("target")(target.asInstanceOf[js.Any])
    if (!js.isUndefined(visible)) __obj.updateDynamic("visible")(visible)
  
    val props = __obj.asInstanceOf[Props]
    val f = JsForwardRefComponent.force[Props, Children.Varargs, SidebarType](js.constructorOf[SidebarType])
  
    f(props)(children: _*)
  }
  type Props = SidebarProps
}

