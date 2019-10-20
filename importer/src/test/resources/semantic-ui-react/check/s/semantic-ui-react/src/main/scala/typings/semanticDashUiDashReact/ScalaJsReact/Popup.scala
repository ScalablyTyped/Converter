package typings.semanticDashUiDashReact.ScalaJsReact

import japgolly.scalajs.react.Callback
import japgolly.scalajs.react.CtorType.ChildArg
import japgolly.scalajs.react.ReactMouseEventFrom
import japgolly.scalajs.react.component.JsForwardRef.UnmountedWithRoot
import japgolly.scalajs.react.vdom.VdomNode
import org.scalablytyped.runtime.StringDictionary
import org.scalajs.dom.raw.HTMLElement
import typings.react.reactMod.RefObject
import typings.semanticDashUiDashReact.semanticDashUiDashReactStrings.`bottom center`
import typings.semanticDashUiDashReact.semanticDashUiDashReactStrings.`bottom left`
import typings.semanticDashUiDashReact.semanticDashUiDashReactStrings.`bottom right`
import typings.semanticDashUiDashReact.semanticDashUiDashReactStrings.`left center`
import typings.semanticDashUiDashReact.semanticDashUiDashReactStrings.`right center`
import typings.semanticDashUiDashReact.semanticDashUiDashReactStrings.`top center`
import typings.semanticDashUiDashReact.semanticDashUiDashReactStrings.`top left`
import typings.semanticDashUiDashReact.semanticDashUiDashReactStrings.`top right`
import typings.semanticDashUiDashReact.semanticDashUiDashReactStrings.click
import typings.semanticDashUiDashReact.semanticDashUiDashReactStrings.focus
import typings.semanticDashUiDashReact.semanticDashUiDashReactStrings.hover
import typings.semanticDashUiDashReact.semanticDashUiDashReactStrings.huge
import typings.semanticDashUiDashReact.semanticDashUiDashReactStrings.large
import typings.semanticDashUiDashReact.semanticDashUiDashReactStrings.mini
import typings.semanticDashUiDashReact.semanticDashUiDashReactStrings.small
import typings.semanticDashUiDashReact.semanticDashUiDashReactStrings.tiny
import typings.semanticDashUiDashReact.semanticDashUiDashReactStrings.very
import typings.semanticDashUiDashReact.srcGenericMod.SemanticShorthandItem
import typings.semanticDashUiDashReact.srcModulesPopupMod.default
import typings.semanticDashUiDashReact.srcModulesPopupPopupContentMod.PopupContentProps
import typings.semanticDashUiDashReact.srcModulesPopupPopupHeaderMod.PopupHeaderProps
import typings.semanticDashUiDashReact.srcModulesPopupPopupMod.PopupProps
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

object Popup {
  def apply(
    StringDictionary: /* key */ StringDictionary[js.Any] = null,
    as: js.Any = null,
    basic: js.UndefOr[Boolean] = js.undefined,
    className: String = null,
    content: SemanticShorthandItem[PopupContentProps] = null,
    context: js.Object | RefObject[HTMLElement] = null,
    disabled: js.UndefOr[Boolean] = js.undefined,
    eventsEnabled: js.UndefOr[Boolean] = js.undefined,
    flowing: js.UndefOr[Boolean] = js.undefined,
    header: SemanticShorthandItem[PopupHeaderProps] = null,
    hideOnScroll: js.UndefOr[Boolean] = js.undefined,
    hoverable: js.UndefOr[Boolean] = js.undefined,
    inverted: js.UndefOr[Boolean] = js.undefined,
    offset: Double | String = null,
    on: hover | click | focus | (js.Array[hover | click | focus]) = null,
    onClose: (/* event */ ReactMouseEventFrom[HTMLElement], /* data */ PopupProps) => Callback = null,
    onMount: (/* nothing */ Null, /* data */ PopupProps) => Callback = null,
    onOpen: (/* event */ ReactMouseEventFrom[HTMLElement], /* data */ PopupProps) => Callback = null,
    onUnmount: (/* nothing */ Null, /* data */ PopupProps) => Callback = null,
    pinned: js.UndefOr[Boolean] = js.undefined,
    popperDependencies: js.Array[js.Any] = null,
    popperModifiers: js.Object = null,
    position: (`top left`) | (`top right`) | (`bottom right`) | (`bottom left`) | (`right center`) | (`left center`) | (`top center`) | (`bottom center`) = null,
    positionFixed: js.UndefOr[Boolean] = js.undefined,
    size: mini | tiny | small | large | huge = null,
    style: /* import warning: QualifyReferences.resolveTypeRef many Couldn't qualify Object */ js.Any = null,
    trigger: VdomNode = null,
    wide: Boolean | very = null
  )(
    children: ChildArg*
  ): UnmountedWithRoot[PopupProps, default, Unit, PopupProps] = {
    val __obj = js.Dynamic.literal()
  
      js.Dynamic.global.Object.assign(__obj, StringDictionary)
    if (as != null) __obj.updateDynamic("as")(as)
    if (!js.isUndefined(basic)) __obj.updateDynamic("basic")(basic)
    if (className != null) __obj.updateDynamic("className")(className)
    if (content != null) __obj.updateDynamic("content")(content.asInstanceOf[js.Any])
    if (context != null) __obj.updateDynamic("context")(context.asInstanceOf[js.Any])
    if (!js.isUndefined(disabled)) __obj.updateDynamic("disabled")(disabled)
    if (!js.isUndefined(eventsEnabled)) __obj.updateDynamic("eventsEnabled")(eventsEnabled)
    if (!js.isUndefined(flowing)) __obj.updateDynamic("flowing")(flowing)
    if (header != null) __obj.updateDynamic("header")(header.asInstanceOf[js.Any])
    if (!js.isUndefined(hideOnScroll)) __obj.updateDynamic("hideOnScroll")(hideOnScroll)
    if (!js.isUndefined(hoverable)) __obj.updateDynamic("hoverable")(hoverable)
    if (!js.isUndefined(inverted)) __obj.updateDynamic("inverted")(inverted)
    if (offset != null) __obj.updateDynamic("offset")(offset.asInstanceOf[js.Any])
    if (on != null) __obj.updateDynamic("on")(on.asInstanceOf[js.Any])
    if (onClose != null) __obj.updateDynamic("onClose")(js.Any.fromFunction2(((t0: /* event */ japgolly.scalajs.react.ReactMouseEventFrom[org.scalajs.dom.raw.HTMLElement], t1: /* data */ typings.semanticDashUiDashReact.srcModulesPopupPopupMod.PopupProps) => onClose(t0, t1).runNow())))
    if (onMount != null) __obj.updateDynamic("onMount")(js.Any.fromFunction2(((t0: /* nothing */ scala.Null, t1: /* data */ typings.semanticDashUiDashReact.srcModulesPopupPopupMod.PopupProps) => onMount(t0, t1).runNow())))
    if (onOpen != null) __obj.updateDynamic("onOpen")(js.Any.fromFunction2(((t0: /* event */ japgolly.scalajs.react.ReactMouseEventFrom[org.scalajs.dom.raw.HTMLElement], t1: /* data */ typings.semanticDashUiDashReact.srcModulesPopupPopupMod.PopupProps) => onOpen(t0, t1).runNow())))
    if (onUnmount != null) __obj.updateDynamic("onUnmount")(js.Any.fromFunction2(((t0: /* nothing */ scala.Null, t1: /* data */ typings.semanticDashUiDashReact.srcModulesPopupPopupMod.PopupProps) => onUnmount(t0, t1).runNow())))
    if (!js.isUndefined(pinned)) __obj.updateDynamic("pinned")(pinned)
    if (popperDependencies != null) __obj.updateDynamic("popperDependencies")(popperDependencies)
    if (popperModifiers != null) __obj.updateDynamic("popperModifiers")(popperModifiers)
    if (position != null) __obj.updateDynamic("position")(position.asInstanceOf[js.Any])
    if (!js.isUndefined(positionFixed)) __obj.updateDynamic("positionFixed")(positionFixed)
    if (size != null) __obj.updateDynamic("size")(size.asInstanceOf[js.Any])
    if (style != null) __obj.updateDynamic("style")(style)
    if (trigger != null) __obj.updateDynamic("trigger")(trigger.rawNode.asInstanceOf[js.Any])
    if (wide != null) __obj.updateDynamic("wide")(wide.asInstanceOf[js.Any])
  
    val f = japgolly.scalajs.react.JsForwardRefComponent.force[
  typings.semanticDashUiDashReact.srcModulesPopupPopupMod.PopupProps, 
  japgolly.scalajs.react.Children.Varargs, 
  typings.semanticDashUiDashReact.srcModulesPopupMod.default](js.constructorOf[typings.semanticDashUiDashReact.srcModulesPopupMod.default])
    f(__obj.asInstanceOf[typings.semanticDashUiDashReact.srcModulesPopupPopupMod.PopupProps])(children: _*)
  }
}

