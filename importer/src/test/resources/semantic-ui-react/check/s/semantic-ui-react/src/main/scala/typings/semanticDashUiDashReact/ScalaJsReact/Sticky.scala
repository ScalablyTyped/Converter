package typings.semanticDashUiDashReact.ScalaJsReact

import japgolly.scalajs.react.Callback
import japgolly.scalajs.react.CtorType.ChildArg
import japgolly.scalajs.react.ReactMouseEventFrom
import japgolly.scalajs.react.component.JsForwardRef.UnmountedWithRoot
import org.scalablytyped.runtime.StringDictionary
import org.scalajs.dom.raw.HTMLElement
import typings.react.reactMod.Ref
import typings.semanticDashUiDashReact.srcModulesStickyMod.default
import typings.semanticDashUiDashReact.srcModulesStickyStickyMod.StickyProps
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

/* The following DOM/SVG props were specified: children, className */
object Sticky {
  def apply(
    StringDictionary: /* key */ StringDictionary[js.Any] = null,
    active: js.UndefOr[Boolean] = js.undefined,
    as: js.Any = null,
    bottomOffset: Int | Double = null,
    context: js.Object | Ref[HTMLElement] = null,
    offset: Int | Double = null,
    onBottom: (/* event */ ReactMouseEventFrom[HTMLElement], /* data */ StickyProps) => Callback = null,
    onStick: (/* event */ ReactMouseEventFrom[HTMLElement], /* data */ StickyProps) => Callback = null,
    onTop: (/* event */ ReactMouseEventFrom[HTMLElement], /* data */ StickyProps) => Callback = null,
    onUnstick: (/* event */ ReactMouseEventFrom[HTMLElement], /* data */ StickyProps) => Callback = null,
    pushing: js.UndefOr[Boolean] = js.undefined,
    scrollContext: js.Object | Ref[HTMLElement] = null,
    styleElement: js.Object = null
  )(
    children: /** Primary content. */
  ChildArg*
  ): UnmountedWithRoot[StickyProps, default, Unit, StickyProps] = {
    val __obj = js.Dynamic.literal()
  
      js.Dynamic.global.Object.assign(__obj, StringDictionary)
    if (!js.isUndefined(active)) __obj.updateDynamic("active")(active)
    if (as != null) __obj.updateDynamic("as")(as)
    if (bottomOffset != null) __obj.updateDynamic("bottomOffset")(bottomOffset.asInstanceOf[js.Any])
    if (context != null) __obj.updateDynamic("context")(context.asInstanceOf[js.Any])
    if (offset != null) __obj.updateDynamic("offset")(offset.asInstanceOf[js.Any])
        if (onBottom != null) __obj.updateDynamic("onBottom")(js.Any.fromFunction2(((t0: /* event */ japgolly.scalajs.react.ReactMouseEventFrom[org.scalajs.dom.raw.HTMLElement], t1: /* data */ typings.semanticDashUiDashReact.srcModulesStickyStickyMod.StickyProps) => onBottom(t0, t1).runNow())))
        if (onStick != null) __obj.updateDynamic("onStick")(js.Any.fromFunction2(((t0: /* event */ japgolly.scalajs.react.ReactMouseEventFrom[org.scalajs.dom.raw.HTMLElement], t1: /* data */ typings.semanticDashUiDashReact.srcModulesStickyStickyMod.StickyProps) => onStick(t0, t1).runNow())))
        if (onTop != null) __obj.updateDynamic("onTop")(js.Any.fromFunction2(((t0: /* event */ japgolly.scalajs.react.ReactMouseEventFrom[org.scalajs.dom.raw.HTMLElement], t1: /* data */ typings.semanticDashUiDashReact.srcModulesStickyStickyMod.StickyProps) => onTop(t0, t1).runNow())))
        if (onUnstick != null) __obj.updateDynamic("onUnstick")(js.Any.fromFunction2(((t0: /* event */ japgolly.scalajs.react.ReactMouseEventFrom[org.scalajs.dom.raw.HTMLElement], t1: /* data */ typings.semanticDashUiDashReact.srcModulesStickyStickyMod.StickyProps) => onUnstick(t0, t1).runNow())))
    if (!js.isUndefined(pushing)) __obj.updateDynamic("pushing")(pushing)
    if (scrollContext != null) __obj.updateDynamic("scrollContext")(scrollContext.asInstanceOf[js.Any])
    if (styleElement != null) __obj.updateDynamic("styleElement")(styleElement)
  
    val f = japgolly.scalajs.react.JsForwardRefComponent[
  typings.semanticDashUiDashReact.srcModulesStickyStickyMod.StickyProps, 
  japgolly.scalajs.react.Children.Varargs, 
  typings.semanticDashUiDashReact.srcModulesStickyMod.default](js.constructorOf[typings.semanticDashUiDashReact.srcModulesStickyMod.default])
    f(__obj.asInstanceOf[typings.semanticDashUiDashReact.srcModulesStickyStickyMod.StickyProps])(children: _*)
  }
}

