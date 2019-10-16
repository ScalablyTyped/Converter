package typings.semanticUiReact.ScalaJsReact

import japgolly.scalajs.react.Callback
import japgolly.scalajs.react.CtorType.ChildArg
import japgolly.scalajs.react.ReactMouseEventFrom
import japgolly.scalajs.react.component.JsForwardRef.UnmountedWithRoot
import japgolly.scalajs.react.vdom.VdomNode
import org.scalablytyped.runtime.StringDictionary
import org.scalajs.dom.raw.HTMLElement
import typings.react.reactMod.CSSProperties
import typings.semanticUiReact.genericMod.SemanticShorthandItem
import typings.semanticUiReact.modulesModalMod.default
import typings.semanticUiReact.modulesModalModalActionsMod.ModalActionsProps
import typings.semanticUiReact.modulesModalModalContentMod.ModalContentProps
import typings.semanticUiReact.modulesModalModalHeaderMod.ModalHeaderProps
import typings.semanticUiReact.modulesModalModalMod.ModalProps
import typings.semanticUiReact.semanticUiReactNumbers.`true`
import typings.semanticUiReact.semanticUiReactStrings.blurring
import typings.semanticUiReact.semanticUiReactStrings.fullscreen
import typings.semanticUiReact.semanticUiReactStrings.inverted
import typings.semanticUiReact.semanticUiReactStrings.large
import typings.semanticUiReact.semanticUiReactStrings.mini
import typings.semanticUiReact.semanticUiReactStrings.small
import typings.semanticUiReact.semanticUiReactStrings.tiny
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

object Modal {
  def apply(
    StringDictionary: /* key */ StringDictionary[js.Any] = null,
    actions: SemanticShorthandItem[ModalActionsProps] = null,
    as: js.Any = null,
    basic: js.UndefOr[Boolean] = js.undefined,
    centered: js.UndefOr[Boolean] = js.undefined,
    className: String = null,
    closeIcon: js.Any = null,
    closeOnDimmerClick: js.UndefOr[Boolean] = js.undefined,
    closeOnDocumentClick: js.UndefOr[Boolean] = js.undefined,
    content: SemanticShorthandItem[ModalContentProps] = null,
    defaultOpen: js.UndefOr[Boolean] = js.undefined,
    dimmer: `true` | blurring | inverted = null,
    eventPool: String = null,
    header: SemanticShorthandItem[ModalHeaderProps] = null,
    mountNode: js.Any = null,
    onActionClick: (/* event */ ReactMouseEventFrom[HTMLElement], /* data */ ModalProps) => Callback = null,
    onClose: (/* event */ ReactMouseEventFrom[HTMLElement], /* data */ ModalProps) => Callback = null,
    onMount: (/* nothing */ Null, /* data */ ModalProps) => Callback = null,
    onOpen: (/* event */ ReactMouseEventFrom[HTMLElement], /* data */ ModalProps) => Callback = null,
    onUnmount: (/* nothing */ Null, /* data */ ModalProps) => Callback = null,
    open: js.UndefOr[Boolean] = js.undefined,
    size: mini | tiny | small | large | fullscreen = null,
    style: CSSProperties = null,
    trigger: VdomNode = null
  )(
    children: ChildArg*
  ): UnmountedWithRoot[ModalProps, default, Unit, ModalProps] = {
    val __obj = js.Dynamic.literal()
  
      js.Dynamic.global.Object.assign(__obj, StringDictionary)
    if (actions != null) __obj.updateDynamic("actions")(actions.asInstanceOf[js.Any])
    if (as != null) __obj.updateDynamic("as")(as)
    if (!js.isUndefined(basic)) __obj.updateDynamic("basic")(basic)
    if (!js.isUndefined(centered)) __obj.updateDynamic("centered")(centered)
    if (className != null) __obj.updateDynamic("className")(className)
    if (closeIcon != null) __obj.updateDynamic("closeIcon")(closeIcon)
    if (!js.isUndefined(closeOnDimmerClick)) __obj.updateDynamic("closeOnDimmerClick")(closeOnDimmerClick)
    if (!js.isUndefined(closeOnDocumentClick)) __obj.updateDynamic("closeOnDocumentClick")(closeOnDocumentClick)
    if (content != null) __obj.updateDynamic("content")(content.asInstanceOf[js.Any])
    if (!js.isUndefined(defaultOpen)) __obj.updateDynamic("defaultOpen")(defaultOpen)
    if (dimmer != null) __obj.updateDynamic("dimmer")(dimmer.asInstanceOf[js.Any])
    if (eventPool != null) __obj.updateDynamic("eventPool")(eventPool)
    if (header != null) __obj.updateDynamic("header")(header.asInstanceOf[js.Any])
    if (mountNode != null) __obj.updateDynamic("mountNode")(mountNode)
    if (onActionClick != null) __obj.updateDynamic("onActionClick")(js.Any.fromFunction2(((t0: /* event */ japgolly.scalajs.react.ReactMouseEventFrom[org.scalajs.dom.raw.HTMLElement], t1: /* data */ typings.semanticUiReact.modulesModalModalMod.ModalProps) => onActionClick(t0, t1).runNow())))
    if (onClose != null) __obj.updateDynamic("onClose")(js.Any.fromFunction2(((t0: /* event */ japgolly.scalajs.react.ReactMouseEventFrom[org.scalajs.dom.raw.HTMLElement], t1: /* data */ typings.semanticUiReact.modulesModalModalMod.ModalProps) => onClose(t0, t1).runNow())))
    if (onMount != null) __obj.updateDynamic("onMount")(js.Any.fromFunction2(((t0: /* nothing */ scala.Null, t1: /* data */ typings.semanticUiReact.modulesModalModalMod.ModalProps) => onMount(t0, t1).runNow())))
    if (onOpen != null) __obj.updateDynamic("onOpen")(js.Any.fromFunction2(((t0: /* event */ japgolly.scalajs.react.ReactMouseEventFrom[org.scalajs.dom.raw.HTMLElement], t1: /* data */ typings.semanticUiReact.modulesModalModalMod.ModalProps) => onOpen(t0, t1).runNow())))
    if (onUnmount != null) __obj.updateDynamic("onUnmount")(js.Any.fromFunction2(((t0: /* nothing */ scala.Null, t1: /* data */ typings.semanticUiReact.modulesModalModalMod.ModalProps) => onUnmount(t0, t1).runNow())))
    if (!js.isUndefined(open)) __obj.updateDynamic("open")(open)
    if (size != null) __obj.updateDynamic("size")(size.asInstanceOf[js.Any])
    if (style != null) __obj.updateDynamic("style")(style)
    if (trigger != null) __obj.updateDynamic("trigger")(trigger.rawNode.asInstanceOf[js.Any])
  
    val f = japgolly.scalajs.react.JsForwardRefComponent.force[
  typings.semanticUiReact.modulesModalModalMod.ModalProps, 
  japgolly.scalajs.react.Children.Varargs, 
  typings.semanticUiReact.modulesModalMod.default](js.constructorOf[typings.semanticUiReact.modulesModalMod.default])
    f(__obj.asInstanceOf[typings.semanticUiReact.modulesModalModalMod.ModalProps])(children: _*)
  }
}

