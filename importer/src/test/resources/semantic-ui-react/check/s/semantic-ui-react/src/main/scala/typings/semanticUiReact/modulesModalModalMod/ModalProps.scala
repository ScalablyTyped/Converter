package typings.semanticUiReact.modulesModalModalMod

import org.scalablytyped.runtime.StringDictionary
import typings.react.HTMLElement
import typings.react.NativeMouseEvent
import typings.react.reactMod.CSSProperties
import typings.react.reactMod.MouseEvent
import typings.react.reactMod.ReactNode
import typings.semanticUiReact.genericMod.SemanticShorthandItem
import typings.semanticUiReact.modulesModalModalActionsMod.ModalActionsProps
import typings.semanticUiReact.modulesModalModalContentMod.ModalContentProps
import typings.semanticUiReact.modulesModalModalHeaderMod.ModalHeaderProps
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

trait ModalProps
  extends StrictModalProps
     with /* key */ StringDictionary[js.Any]

object ModalProps {
  @scala.inline
  def apply(
    StringDictionary: /* key */ StringDictionary[js.Any] = null,
    actions: SemanticShorthandItem[ModalActionsProps] = null,
    as: js.Any = null,
    basic: js.UndefOr[Boolean] = js.undefined,
    centered: js.UndefOr[Boolean] = js.undefined,
    children: ReactNode = null,
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
    onActionClick: (/* event */ MouseEvent[HTMLElement, NativeMouseEvent], /* data */ ModalProps) => Unit = null,
    onClose: (/* event */ MouseEvent[HTMLElement, NativeMouseEvent], /* data */ ModalProps) => Unit = null,
    onMount: (/* nothing */ Null, /* data */ ModalProps) => Unit = null,
    onOpen: (/* event */ MouseEvent[HTMLElement, NativeMouseEvent], /* data */ ModalProps) => Unit = null,
    onUnmount: (/* nothing */ Null, /* data */ ModalProps) => Unit = null,
    open: js.UndefOr[Boolean] = js.undefined,
    size: mini | tiny | small | large | fullscreen = null,
    style: CSSProperties = null,
    trigger: ReactNode = null
  ): ModalProps = {
    val __obj = js.Dynamic.literal()
    js.Dynamic.global.Object.assign(__obj, StringDictionary)
    if (actions != null) __obj.updateDynamic("actions")(actions.asInstanceOf[js.Any])
    if (as != null) __obj.updateDynamic("as")(as)
    if (!js.isUndefined(basic)) __obj.updateDynamic("basic")(basic)
    if (!js.isUndefined(centered)) __obj.updateDynamic("centered")(centered)
    if (children != null) __obj.updateDynamic("children")(children.asInstanceOf[js.Any])
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
    if (onActionClick != null) __obj.updateDynamic("onActionClick")(js.Any.fromFunction2(onActionClick))
    if (onClose != null) __obj.updateDynamic("onClose")(js.Any.fromFunction2(onClose))
    if (onMount != null) __obj.updateDynamic("onMount")(js.Any.fromFunction2(onMount))
    if (onOpen != null) __obj.updateDynamic("onOpen")(js.Any.fromFunction2(onOpen))
    if (onUnmount != null) __obj.updateDynamic("onUnmount")(js.Any.fromFunction2(onUnmount))
    if (!js.isUndefined(open)) __obj.updateDynamic("open")(open)
    if (size != null) __obj.updateDynamic("size")(size.asInstanceOf[js.Any])
    if (style != null) __obj.updateDynamic("style")(style)
    if (trigger != null) __obj.updateDynamic("trigger")(trigger.asInstanceOf[js.Any])
    __obj.asInstanceOf[ModalProps]
  }
}

