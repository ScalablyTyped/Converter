package typingsJapgolly.react.reactMod

import japgolly.scalajs.react.Callback
import japgolly.scalajs.react.ReactAnimationEventFrom
import japgolly.scalajs.react.ReactClipboardEventFrom
import japgolly.scalajs.react.ReactCompositionEventFrom
import japgolly.scalajs.react.ReactDragEventFrom
import japgolly.scalajs.react.ReactEventFrom
import japgolly.scalajs.react.ReactFocusEventFrom
import japgolly.scalajs.react.ReactKeyboardEventFrom
import japgolly.scalajs.react.ReactMouseEventFrom
import japgolly.scalajs.react.ReactPointerEventFrom
import japgolly.scalajs.react.ReactTouchEventFrom
import japgolly.scalajs.react.ReactTransitionEventFrom
import japgolly.scalajs.react.ReactUIEventFrom
import japgolly.scalajs.react.ReactWheelEventFrom
import japgolly.scalajs.react.raw.React.Node
import japgolly.scalajs.react.vdom.VdomNode
import org.scalajs.dom.raw.Element
import typingsJapgolly.react.Anon_Html
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

trait DOMAttributes[T] extends js.Object {
  var children: js.UndefOr[Node] = js.undefined
  var dangerouslySetInnerHTML: js.UndefOr[Anon_Html] = js.undefined
  // Media Events
  var onAbort: js.UndefOr[ReactEventHandler[T]] = js.undefined
  var onAnimationEnd: js.UndefOr[AnimationEventHandler[T]] = js.undefined
  var onAnimationIteration: js.UndefOr[AnimationEventHandler[T]] = js.undefined
  // Animation Events
  var onAnimationStart: js.UndefOr[AnimationEventHandler[T]] = js.undefined
  // MouseEvents
  var onAuxClick: js.UndefOr[MouseEventHandler[T]] = js.undefined
  var onBeforeInput: js.UndefOr[FormEventHandler[T]] = js.undefined
  var onBlur: js.UndefOr[FocusEventHandler[T]] = js.undefined
  var onCanPlay: js.UndefOr[ReactEventHandler[T]] = js.undefined
  var onCanPlayThrough: js.UndefOr[ReactEventHandler[T]] = js.undefined
  // Form Events
  var onChange: js.UndefOr[FormEventHandler[T]] = js.undefined
  var onClick: js.UndefOr[MouseEventHandler[T]] = js.undefined
  // Composition Events
  var onCompositionEnd: js.UndefOr[CompositionEventHandler[T]] = js.undefined
  var onCompositionStart: js.UndefOr[CompositionEventHandler[T]] = js.undefined
  var onCompositionUpdate: js.UndefOr[CompositionEventHandler[T]] = js.undefined
  var onContextMenu: js.UndefOr[MouseEventHandler[T]] = js.undefined
  // Clipboard Events
  var onCopy: js.UndefOr[ClipboardEventHandler[T]] = js.undefined
  var onCut: js.UndefOr[ClipboardEventHandler[T]] = js.undefined
  var onDoubleClick: js.UndefOr[MouseEventHandler[T]] = js.undefined
  var onDrag: js.UndefOr[DragEventHandler[T]] = js.undefined
  var onDragEnd: js.UndefOr[DragEventHandler[T]] = js.undefined
  var onDragEnter: js.UndefOr[DragEventHandler[T]] = js.undefined
  var onDragExit: js.UndefOr[DragEventHandler[T]] = js.undefined
  var onDragLeave: js.UndefOr[DragEventHandler[T]] = js.undefined
  var onDragOver: js.UndefOr[DragEventHandler[T]] = js.undefined
  var onDragStart: js.UndefOr[DragEventHandler[T]] = js.undefined
  var onDrop: js.UndefOr[DragEventHandler[T]] = js.undefined
  var onDurationChange: js.UndefOr[ReactEventHandler[T]] = js.undefined
  var onEmptied: js.UndefOr[ReactEventHandler[T]] = js.undefined
  var onEncrypted: js.UndefOr[ReactEventHandler[T]] = js.undefined
  var onEnded: js.UndefOr[ReactEventHandler[T]] = js.undefined
  var onError: js.UndefOr[ReactEventHandler[T]] = js.undefined
  // Focus Events
  var onFocus: js.UndefOr[FocusEventHandler[T]] = js.undefined
  var onInput: js.UndefOr[FormEventHandler[T]] = js.undefined
  var onInvalid: js.UndefOr[FormEventHandler[T]] = js.undefined
   // also a Media Event
  // Keyboard Events
  var onKeyDown: js.UndefOr[KeyboardEventHandler[T]] = js.undefined
  var onKeyPress: js.UndefOr[KeyboardEventHandler[T]] = js.undefined
  var onKeyUp: js.UndefOr[KeyboardEventHandler[T]] = js.undefined
  // Image Events
  var onLoad: js.UndefOr[ReactEventHandler[T]] = js.undefined
  var onLoadStart: js.UndefOr[ReactEventHandler[T]] = js.undefined
  var onLoadedData: js.UndefOr[ReactEventHandler[T]] = js.undefined
  var onLoadedMetadata: js.UndefOr[ReactEventHandler[T]] = js.undefined
  var onMouseDown: js.UndefOr[MouseEventHandler[T]] = js.undefined
  var onMouseEnter: js.UndefOr[MouseEventHandler[T]] = js.undefined
  var onMouseLeave: js.UndefOr[MouseEventHandler[T]] = js.undefined
  var onMouseMove: js.UndefOr[MouseEventHandler[T]] = js.undefined
  var onMouseOut: js.UndefOr[MouseEventHandler[T]] = js.undefined
  var onMouseOver: js.UndefOr[MouseEventHandler[T]] = js.undefined
  var onMouseUp: js.UndefOr[MouseEventHandler[T]] = js.undefined
  var onPaste: js.UndefOr[ClipboardEventHandler[T]] = js.undefined
  var onPause: js.UndefOr[ReactEventHandler[T]] = js.undefined
  var onPlay: js.UndefOr[ReactEventHandler[T]] = js.undefined
  var onPlaying: js.UndefOr[ReactEventHandler[T]] = js.undefined
  var onPointerCancel: js.UndefOr[PointerEventHandler[T]] = js.undefined
  // Pointer Events
  var onPointerDown: js.UndefOr[PointerEventHandler[T]] = js.undefined
  var onPointerEnter: js.UndefOr[PointerEventHandler[T]] = js.undefined
  var onPointerLeave: js.UndefOr[PointerEventHandler[T]] = js.undefined
  var onPointerMove: js.UndefOr[PointerEventHandler[T]] = js.undefined
  var onPointerOut: js.UndefOr[PointerEventHandler[T]] = js.undefined
  var onPointerOver: js.UndefOr[PointerEventHandler[T]] = js.undefined
  var onPointerUp: js.UndefOr[PointerEventHandler[T]] = js.undefined
  var onProgress: js.UndefOr[ReactEventHandler[T]] = js.undefined
  var onRateChange: js.UndefOr[ReactEventHandler[T]] = js.undefined
  var onReset: js.UndefOr[FormEventHandler[T]] = js.undefined
  // UI Events
  var onScroll: js.UndefOr[UIEventHandler[T]] = js.undefined
  var onSeeked: js.UndefOr[ReactEventHandler[T]] = js.undefined
  var onSeeking: js.UndefOr[ReactEventHandler[T]] = js.undefined
  // Selection Events
  var onSelect: js.UndefOr[ReactEventHandler[T]] = js.undefined
  var onStalled: js.UndefOr[ReactEventHandler[T]] = js.undefined
  var onSubmit: js.UndefOr[FormEventHandler[T]] = js.undefined
  var onSuspend: js.UndefOr[ReactEventHandler[T]] = js.undefined
  var onTimeUpdate: js.UndefOr[ReactEventHandler[T]] = js.undefined
  // Touch Events
  var onTouchCancel: js.UndefOr[TouchEventHandler[T]] = js.undefined
  var onTouchEnd: js.UndefOr[TouchEventHandler[T]] = js.undefined
  var onTouchMove: js.UndefOr[TouchEventHandler[T]] = js.undefined
  var onTouchStart: js.UndefOr[TouchEventHandler[T]] = js.undefined
  // Transition Events
  var onTransitionEnd: js.UndefOr[TransitionEventHandler[T]] = js.undefined
  var onVolumeChange: js.UndefOr[ReactEventHandler[T]] = js.undefined
  var onWaiting: js.UndefOr[ReactEventHandler[T]] = js.undefined
  // Wheel Events
  var onWheel: js.UndefOr[WheelEventHandler[T]] = js.undefined
}

object DOMAttributes {
  @scala.inline
  def apply[T](
    children: VdomNode = null,
    dangerouslySetInnerHTML: Anon_Html = null,
    onAbort: ReactEventFrom[T with Element] => Callback = null,
    onAnimationEnd: ReactAnimationEventFrom[T with Element] => Callback = null,
    onAnimationIteration: ReactAnimationEventFrom[T with Element] => Callback = null,
    onAnimationStart: ReactAnimationEventFrom[T with Element] => Callback = null,
    onAuxClick: ReactMouseEventFrom[T with Element] => Callback = null,
    onBeforeInput: ReactEventFrom[T with Element] => Callback = null,
    onBlur: ReactFocusEventFrom[T with Element] => Callback = null,
    onCanPlay: ReactEventFrom[T with Element] => Callback = null,
    onCanPlayThrough: ReactEventFrom[T with Element] => Callback = null,
    onChange: ReactEventFrom[T with Element] => Callback = null,
    onClick: ReactMouseEventFrom[T with Element] => Callback = null,
    onCompositionEnd: ReactCompositionEventFrom[T with Element] => Callback = null,
    onCompositionStart: ReactCompositionEventFrom[T with Element] => Callback = null,
    onCompositionUpdate: ReactCompositionEventFrom[T with Element] => Callback = null,
    onContextMenu: ReactMouseEventFrom[T with Element] => Callback = null,
    onCopy: ReactClipboardEventFrom[T with Element] => Callback = null,
    onCut: ReactClipboardEventFrom[T with Element] => Callback = null,
    onDoubleClick: ReactMouseEventFrom[T with Element] => Callback = null,
    onDrag: ReactDragEventFrom[T with Element] => Callback = null,
    onDragEnd: ReactDragEventFrom[T with Element] => Callback = null,
    onDragEnter: ReactDragEventFrom[T with Element] => Callback = null,
    onDragExit: ReactDragEventFrom[T with Element] => Callback = null,
    onDragLeave: ReactDragEventFrom[T with Element] => Callback = null,
    onDragOver: ReactDragEventFrom[T with Element] => Callback = null,
    onDragStart: ReactDragEventFrom[T with Element] => Callback = null,
    onDrop: ReactDragEventFrom[T with Element] => Callback = null,
    onDurationChange: ReactEventFrom[T with Element] => Callback = null,
    onEmptied: ReactEventFrom[T with Element] => Callback = null,
    onEncrypted: ReactEventFrom[T with Element] => Callback = null,
    onEnded: ReactEventFrom[T with Element] => Callback = null,
    onError: ReactEventFrom[T with Element] => Callback = null,
    onFocus: ReactFocusEventFrom[T with Element] => Callback = null,
    onInput: ReactEventFrom[T with Element] => Callback = null,
    onInvalid: ReactEventFrom[T with Element] => Callback = null,
    onKeyDown: ReactKeyboardEventFrom[T with Element] => Callback = null,
    onKeyPress: ReactKeyboardEventFrom[T with Element] => Callback = null,
    onKeyUp: ReactKeyboardEventFrom[T with Element] => Callback = null,
    onLoad: ReactEventFrom[T with Element] => Callback = null,
    onLoadStart: ReactEventFrom[T with Element] => Callback = null,
    onLoadedData: ReactEventFrom[T with Element] => Callback = null,
    onLoadedMetadata: ReactEventFrom[T with Element] => Callback = null,
    onMouseDown: ReactMouseEventFrom[T with Element] => Callback = null,
    onMouseEnter: ReactMouseEventFrom[T with Element] => Callback = null,
    onMouseLeave: ReactMouseEventFrom[T with Element] => Callback = null,
    onMouseMove: ReactMouseEventFrom[T with Element] => Callback = null,
    onMouseOut: ReactMouseEventFrom[T with Element] => Callback = null,
    onMouseOver: ReactMouseEventFrom[T with Element] => Callback = null,
    onMouseUp: ReactMouseEventFrom[T with Element] => Callback = null,
    onPaste: ReactClipboardEventFrom[T with Element] => Callback = null,
    onPause: ReactEventFrom[T with Element] => Callback = null,
    onPlay: ReactEventFrom[T with Element] => Callback = null,
    onPlaying: ReactEventFrom[T with Element] => Callback = null,
    onPointerCancel: ReactPointerEventFrom[T with Element] => Callback = null,
    onPointerDown: ReactPointerEventFrom[T with Element] => Callback = null,
    onPointerEnter: ReactPointerEventFrom[T with Element] => Callback = null,
    onPointerLeave: ReactPointerEventFrom[T with Element] => Callback = null,
    onPointerMove: ReactPointerEventFrom[T with Element] => Callback = null,
    onPointerOut: ReactPointerEventFrom[T with Element] => Callback = null,
    onPointerOver: ReactPointerEventFrom[T with Element] => Callback = null,
    onPointerUp: ReactPointerEventFrom[T with Element] => Callback = null,
    onProgress: ReactEventFrom[T with Element] => Callback = null,
    onRateChange: ReactEventFrom[T with Element] => Callback = null,
    onReset: ReactEventFrom[T with Element] => Callback = null,
    onScroll: ReactUIEventFrom[T with Element] => Callback = null,
    onSeeked: ReactEventFrom[T with Element] => Callback = null,
    onSeeking: ReactEventFrom[T with Element] => Callback = null,
    onSelect: ReactEventFrom[T with Element] => Callback = null,
    onStalled: ReactEventFrom[T with Element] => Callback = null,
    onSubmit: ReactEventFrom[T with Element] => Callback = null,
    onSuspend: ReactEventFrom[T with Element] => Callback = null,
    onTimeUpdate: ReactEventFrom[T with Element] => Callback = null,
    onTouchCancel: ReactTouchEventFrom[T with Element] => Callback = null,
    onTouchEnd: ReactTouchEventFrom[T with Element] => Callback = null,
    onTouchMove: ReactTouchEventFrom[T with Element] => Callback = null,
    onTouchStart: ReactTouchEventFrom[T with Element] => Callback = null,
    onTransitionEnd: ReactTransitionEventFrom[T with Element] => Callback = null,
    onVolumeChange: ReactEventFrom[T with Element] => Callback = null,
    onWaiting: ReactEventFrom[T with Element] => Callback = null,
    onWheel: ReactWheelEventFrom[T with Element] => Callback = null
  ): DOMAttributes[T] = {
    val __obj = js.Dynamic.literal()
    if (children != null) __obj.updateDynamic("children")(children.rawNode.asInstanceOf[js.Any])
    if (dangerouslySetInnerHTML != null) __obj.updateDynamic("dangerouslySetInnerHTML")(dangerouslySetInnerHTML.asInstanceOf[js.Any])
    if (onAbort != null) __obj.updateDynamic("onAbort")(js.Any.fromFunction1((t0: japgolly.scalajs.react.ReactEventFrom[T with org.scalajs.dom.raw.Element]) => onAbort(t0).runNow()))
    if (onAnimationEnd != null) __obj.updateDynamic("onAnimationEnd")(js.Any.fromFunction1((t0: japgolly.scalajs.react.ReactAnimationEventFrom[T with org.scalajs.dom.raw.Element]) => onAnimationEnd(t0).runNow()))
    if (onAnimationIteration != null) __obj.updateDynamic("onAnimationIteration")(js.Any.fromFunction1((t0: japgolly.scalajs.react.ReactAnimationEventFrom[T with org.scalajs.dom.raw.Element]) => onAnimationIteration(t0).runNow()))
    if (onAnimationStart != null) __obj.updateDynamic("onAnimationStart")(js.Any.fromFunction1((t0: japgolly.scalajs.react.ReactAnimationEventFrom[T with org.scalajs.dom.raw.Element]) => onAnimationStart(t0).runNow()))
    if (onAuxClick != null) __obj.updateDynamic("onAuxClick")(js.Any.fromFunction1((t0: japgolly.scalajs.react.ReactMouseEventFrom[T with org.scalajs.dom.raw.Element]) => onAuxClick(t0).runNow()))
    if (onBeforeInput != null) __obj.updateDynamic("onBeforeInput")(js.Any.fromFunction1((t0: japgolly.scalajs.react.ReactEventFrom[T with org.scalajs.dom.raw.Element]) => onBeforeInput(t0).runNow()))
    if (onBlur != null) __obj.updateDynamic("onBlur")(js.Any.fromFunction1((t0: japgolly.scalajs.react.ReactFocusEventFrom[T with org.scalajs.dom.raw.Element]) => onBlur(t0).runNow()))
    if (onCanPlay != null) __obj.updateDynamic("onCanPlay")(js.Any.fromFunction1((t0: japgolly.scalajs.react.ReactEventFrom[T with org.scalajs.dom.raw.Element]) => onCanPlay(t0).runNow()))
    if (onCanPlayThrough != null) __obj.updateDynamic("onCanPlayThrough")(js.Any.fromFunction1((t0: japgolly.scalajs.react.ReactEventFrom[T with org.scalajs.dom.raw.Element]) => onCanPlayThrough(t0).runNow()))
    if (onChange != null) __obj.updateDynamic("onChange")(js.Any.fromFunction1((t0: japgolly.scalajs.react.ReactEventFrom[T with org.scalajs.dom.raw.Element]) => onChange(t0).runNow()))
    if (onClick != null) __obj.updateDynamic("onClick")(js.Any.fromFunction1((t0: japgolly.scalajs.react.ReactMouseEventFrom[T with org.scalajs.dom.raw.Element]) => onClick(t0).runNow()))
    if (onCompositionEnd != null) __obj.updateDynamic("onCompositionEnd")(js.Any.fromFunction1((t0: japgolly.scalajs.react.ReactCompositionEventFrom[T with org.scalajs.dom.raw.Element]) => onCompositionEnd(t0).runNow()))
    if (onCompositionStart != null) __obj.updateDynamic("onCompositionStart")(js.Any.fromFunction1((t0: japgolly.scalajs.react.ReactCompositionEventFrom[T with org.scalajs.dom.raw.Element]) => onCompositionStart(t0).runNow()))
    if (onCompositionUpdate != null) __obj.updateDynamic("onCompositionUpdate")(js.Any.fromFunction1((t0: japgolly.scalajs.react.ReactCompositionEventFrom[T with org.scalajs.dom.raw.Element]) => onCompositionUpdate(t0).runNow()))
    if (onContextMenu != null) __obj.updateDynamic("onContextMenu")(js.Any.fromFunction1((t0: japgolly.scalajs.react.ReactMouseEventFrom[T with org.scalajs.dom.raw.Element]) => onContextMenu(t0).runNow()))
    if (onCopy != null) __obj.updateDynamic("onCopy")(js.Any.fromFunction1((t0: japgolly.scalajs.react.ReactClipboardEventFrom[T with org.scalajs.dom.raw.Element]) => onCopy(t0).runNow()))
    if (onCut != null) __obj.updateDynamic("onCut")(js.Any.fromFunction1((t0: japgolly.scalajs.react.ReactClipboardEventFrom[T with org.scalajs.dom.raw.Element]) => onCut(t0).runNow()))
    if (onDoubleClick != null) __obj.updateDynamic("onDoubleClick")(js.Any.fromFunction1((t0: japgolly.scalajs.react.ReactMouseEventFrom[T with org.scalajs.dom.raw.Element]) => onDoubleClick(t0).runNow()))
    if (onDrag != null) __obj.updateDynamic("onDrag")(js.Any.fromFunction1((t0: japgolly.scalajs.react.ReactDragEventFrom[T with org.scalajs.dom.raw.Element]) => onDrag(t0).runNow()))
    if (onDragEnd != null) __obj.updateDynamic("onDragEnd")(js.Any.fromFunction1((t0: japgolly.scalajs.react.ReactDragEventFrom[T with org.scalajs.dom.raw.Element]) => onDragEnd(t0).runNow()))
    if (onDragEnter != null) __obj.updateDynamic("onDragEnter")(js.Any.fromFunction1((t0: japgolly.scalajs.react.ReactDragEventFrom[T with org.scalajs.dom.raw.Element]) => onDragEnter(t0).runNow()))
    if (onDragExit != null) __obj.updateDynamic("onDragExit")(js.Any.fromFunction1((t0: japgolly.scalajs.react.ReactDragEventFrom[T with org.scalajs.dom.raw.Element]) => onDragExit(t0).runNow()))
    if (onDragLeave != null) __obj.updateDynamic("onDragLeave")(js.Any.fromFunction1((t0: japgolly.scalajs.react.ReactDragEventFrom[T with org.scalajs.dom.raw.Element]) => onDragLeave(t0).runNow()))
    if (onDragOver != null) __obj.updateDynamic("onDragOver")(js.Any.fromFunction1((t0: japgolly.scalajs.react.ReactDragEventFrom[T with org.scalajs.dom.raw.Element]) => onDragOver(t0).runNow()))
    if (onDragStart != null) __obj.updateDynamic("onDragStart")(js.Any.fromFunction1((t0: japgolly.scalajs.react.ReactDragEventFrom[T with org.scalajs.dom.raw.Element]) => onDragStart(t0).runNow()))
    if (onDrop != null) __obj.updateDynamic("onDrop")(js.Any.fromFunction1((t0: japgolly.scalajs.react.ReactDragEventFrom[T with org.scalajs.dom.raw.Element]) => onDrop(t0).runNow()))
    if (onDurationChange != null) __obj.updateDynamic("onDurationChange")(js.Any.fromFunction1((t0: japgolly.scalajs.react.ReactEventFrom[T with org.scalajs.dom.raw.Element]) => onDurationChange(t0).runNow()))
    if (onEmptied != null) __obj.updateDynamic("onEmptied")(js.Any.fromFunction1((t0: japgolly.scalajs.react.ReactEventFrom[T with org.scalajs.dom.raw.Element]) => onEmptied(t0).runNow()))
    if (onEncrypted != null) __obj.updateDynamic("onEncrypted")(js.Any.fromFunction1((t0: japgolly.scalajs.react.ReactEventFrom[T with org.scalajs.dom.raw.Element]) => onEncrypted(t0).runNow()))
    if (onEnded != null) __obj.updateDynamic("onEnded")(js.Any.fromFunction1((t0: japgolly.scalajs.react.ReactEventFrom[T with org.scalajs.dom.raw.Element]) => onEnded(t0).runNow()))
    if (onError != null) __obj.updateDynamic("onError")(js.Any.fromFunction1((t0: japgolly.scalajs.react.ReactEventFrom[T with org.scalajs.dom.raw.Element]) => onError(t0).runNow()))
    if (onFocus != null) __obj.updateDynamic("onFocus")(js.Any.fromFunction1((t0: japgolly.scalajs.react.ReactFocusEventFrom[T with org.scalajs.dom.raw.Element]) => onFocus(t0).runNow()))
    if (onInput != null) __obj.updateDynamic("onInput")(js.Any.fromFunction1((t0: japgolly.scalajs.react.ReactEventFrom[T with org.scalajs.dom.raw.Element]) => onInput(t0).runNow()))
    if (onInvalid != null) __obj.updateDynamic("onInvalid")(js.Any.fromFunction1((t0: japgolly.scalajs.react.ReactEventFrom[T with org.scalajs.dom.raw.Element]) => onInvalid(t0).runNow()))
    if (onKeyDown != null) __obj.updateDynamic("onKeyDown")(js.Any.fromFunction1((t0: japgolly.scalajs.react.ReactKeyboardEventFrom[T with org.scalajs.dom.raw.Element]) => onKeyDown(t0).runNow()))
    if (onKeyPress != null) __obj.updateDynamic("onKeyPress")(js.Any.fromFunction1((t0: japgolly.scalajs.react.ReactKeyboardEventFrom[T with org.scalajs.dom.raw.Element]) => onKeyPress(t0).runNow()))
    if (onKeyUp != null) __obj.updateDynamic("onKeyUp")(js.Any.fromFunction1((t0: japgolly.scalajs.react.ReactKeyboardEventFrom[T with org.scalajs.dom.raw.Element]) => onKeyUp(t0).runNow()))
    if (onLoad != null) __obj.updateDynamic("onLoad")(js.Any.fromFunction1((t0: japgolly.scalajs.react.ReactEventFrom[T with org.scalajs.dom.raw.Element]) => onLoad(t0).runNow()))
    if (onLoadStart != null) __obj.updateDynamic("onLoadStart")(js.Any.fromFunction1((t0: japgolly.scalajs.react.ReactEventFrom[T with org.scalajs.dom.raw.Element]) => onLoadStart(t0).runNow()))
    if (onLoadedData != null) __obj.updateDynamic("onLoadedData")(js.Any.fromFunction1((t0: japgolly.scalajs.react.ReactEventFrom[T with org.scalajs.dom.raw.Element]) => onLoadedData(t0).runNow()))
    if (onLoadedMetadata != null) __obj.updateDynamic("onLoadedMetadata")(js.Any.fromFunction1((t0: japgolly.scalajs.react.ReactEventFrom[T with org.scalajs.dom.raw.Element]) => onLoadedMetadata(t0).runNow()))
    if (onMouseDown != null) __obj.updateDynamic("onMouseDown")(js.Any.fromFunction1((t0: japgolly.scalajs.react.ReactMouseEventFrom[T with org.scalajs.dom.raw.Element]) => onMouseDown(t0).runNow()))
    if (onMouseEnter != null) __obj.updateDynamic("onMouseEnter")(js.Any.fromFunction1((t0: japgolly.scalajs.react.ReactMouseEventFrom[T with org.scalajs.dom.raw.Element]) => onMouseEnter(t0).runNow()))
    if (onMouseLeave != null) __obj.updateDynamic("onMouseLeave")(js.Any.fromFunction1((t0: japgolly.scalajs.react.ReactMouseEventFrom[T with org.scalajs.dom.raw.Element]) => onMouseLeave(t0).runNow()))
    if (onMouseMove != null) __obj.updateDynamic("onMouseMove")(js.Any.fromFunction1((t0: japgolly.scalajs.react.ReactMouseEventFrom[T with org.scalajs.dom.raw.Element]) => onMouseMove(t0).runNow()))
    if (onMouseOut != null) __obj.updateDynamic("onMouseOut")(js.Any.fromFunction1((t0: japgolly.scalajs.react.ReactMouseEventFrom[T with org.scalajs.dom.raw.Element]) => onMouseOut(t0).runNow()))
    if (onMouseOver != null) __obj.updateDynamic("onMouseOver")(js.Any.fromFunction1((t0: japgolly.scalajs.react.ReactMouseEventFrom[T with org.scalajs.dom.raw.Element]) => onMouseOver(t0).runNow()))
    if (onMouseUp != null) __obj.updateDynamic("onMouseUp")(js.Any.fromFunction1((t0: japgolly.scalajs.react.ReactMouseEventFrom[T with org.scalajs.dom.raw.Element]) => onMouseUp(t0).runNow()))
    if (onPaste != null) __obj.updateDynamic("onPaste")(js.Any.fromFunction1((t0: japgolly.scalajs.react.ReactClipboardEventFrom[T with org.scalajs.dom.raw.Element]) => onPaste(t0).runNow()))
    if (onPause != null) __obj.updateDynamic("onPause")(js.Any.fromFunction1((t0: japgolly.scalajs.react.ReactEventFrom[T with org.scalajs.dom.raw.Element]) => onPause(t0).runNow()))
    if (onPlay != null) __obj.updateDynamic("onPlay")(js.Any.fromFunction1((t0: japgolly.scalajs.react.ReactEventFrom[T with org.scalajs.dom.raw.Element]) => onPlay(t0).runNow()))
    if (onPlaying != null) __obj.updateDynamic("onPlaying")(js.Any.fromFunction1((t0: japgolly.scalajs.react.ReactEventFrom[T with org.scalajs.dom.raw.Element]) => onPlaying(t0).runNow()))
    if (onPointerCancel != null) __obj.updateDynamic("onPointerCancel")(js.Any.fromFunction1((t0: japgolly.scalajs.react.ReactPointerEventFrom[T with org.scalajs.dom.raw.Element]) => onPointerCancel(t0).runNow()))
    if (onPointerDown != null) __obj.updateDynamic("onPointerDown")(js.Any.fromFunction1((t0: japgolly.scalajs.react.ReactPointerEventFrom[T with org.scalajs.dom.raw.Element]) => onPointerDown(t0).runNow()))
    if (onPointerEnter != null) __obj.updateDynamic("onPointerEnter")(js.Any.fromFunction1((t0: japgolly.scalajs.react.ReactPointerEventFrom[T with org.scalajs.dom.raw.Element]) => onPointerEnter(t0).runNow()))
    if (onPointerLeave != null) __obj.updateDynamic("onPointerLeave")(js.Any.fromFunction1((t0: japgolly.scalajs.react.ReactPointerEventFrom[T with org.scalajs.dom.raw.Element]) => onPointerLeave(t0).runNow()))
    if (onPointerMove != null) __obj.updateDynamic("onPointerMove")(js.Any.fromFunction1((t0: japgolly.scalajs.react.ReactPointerEventFrom[T with org.scalajs.dom.raw.Element]) => onPointerMove(t0).runNow()))
    if (onPointerOut != null) __obj.updateDynamic("onPointerOut")(js.Any.fromFunction1((t0: japgolly.scalajs.react.ReactPointerEventFrom[T with org.scalajs.dom.raw.Element]) => onPointerOut(t0).runNow()))
    if (onPointerOver != null) __obj.updateDynamic("onPointerOver")(js.Any.fromFunction1((t0: japgolly.scalajs.react.ReactPointerEventFrom[T with org.scalajs.dom.raw.Element]) => onPointerOver(t0).runNow()))
    if (onPointerUp != null) __obj.updateDynamic("onPointerUp")(js.Any.fromFunction1((t0: japgolly.scalajs.react.ReactPointerEventFrom[T with org.scalajs.dom.raw.Element]) => onPointerUp(t0).runNow()))
    if (onProgress != null) __obj.updateDynamic("onProgress")(js.Any.fromFunction1((t0: japgolly.scalajs.react.ReactEventFrom[T with org.scalajs.dom.raw.Element]) => onProgress(t0).runNow()))
    if (onRateChange != null) __obj.updateDynamic("onRateChange")(js.Any.fromFunction1((t0: japgolly.scalajs.react.ReactEventFrom[T with org.scalajs.dom.raw.Element]) => onRateChange(t0).runNow()))
    if (onReset != null) __obj.updateDynamic("onReset")(js.Any.fromFunction1((t0: japgolly.scalajs.react.ReactEventFrom[T with org.scalajs.dom.raw.Element]) => onReset(t0).runNow()))
    if (onScroll != null) __obj.updateDynamic("onScroll")(js.Any.fromFunction1((t0: japgolly.scalajs.react.ReactUIEventFrom[T with org.scalajs.dom.raw.Element]) => onScroll(t0).runNow()))
    if (onSeeked != null) __obj.updateDynamic("onSeeked")(js.Any.fromFunction1((t0: japgolly.scalajs.react.ReactEventFrom[T with org.scalajs.dom.raw.Element]) => onSeeked(t0).runNow()))
    if (onSeeking != null) __obj.updateDynamic("onSeeking")(js.Any.fromFunction1((t0: japgolly.scalajs.react.ReactEventFrom[T with org.scalajs.dom.raw.Element]) => onSeeking(t0).runNow()))
    if (onSelect != null) __obj.updateDynamic("onSelect")(js.Any.fromFunction1((t0: japgolly.scalajs.react.ReactEventFrom[T with org.scalajs.dom.raw.Element]) => onSelect(t0).runNow()))
    if (onStalled != null) __obj.updateDynamic("onStalled")(js.Any.fromFunction1((t0: japgolly.scalajs.react.ReactEventFrom[T with org.scalajs.dom.raw.Element]) => onStalled(t0).runNow()))
    if (onSubmit != null) __obj.updateDynamic("onSubmit")(js.Any.fromFunction1((t0: japgolly.scalajs.react.ReactEventFrom[T with org.scalajs.dom.raw.Element]) => onSubmit(t0).runNow()))
    if (onSuspend != null) __obj.updateDynamic("onSuspend")(js.Any.fromFunction1((t0: japgolly.scalajs.react.ReactEventFrom[T with org.scalajs.dom.raw.Element]) => onSuspend(t0).runNow()))
    if (onTimeUpdate != null) __obj.updateDynamic("onTimeUpdate")(js.Any.fromFunction1((t0: japgolly.scalajs.react.ReactEventFrom[T with org.scalajs.dom.raw.Element]) => onTimeUpdate(t0).runNow()))
    if (onTouchCancel != null) __obj.updateDynamic("onTouchCancel")(js.Any.fromFunction1((t0: japgolly.scalajs.react.ReactTouchEventFrom[T with org.scalajs.dom.raw.Element]) => onTouchCancel(t0).runNow()))
    if (onTouchEnd != null) __obj.updateDynamic("onTouchEnd")(js.Any.fromFunction1((t0: japgolly.scalajs.react.ReactTouchEventFrom[T with org.scalajs.dom.raw.Element]) => onTouchEnd(t0).runNow()))
    if (onTouchMove != null) __obj.updateDynamic("onTouchMove")(js.Any.fromFunction1((t0: japgolly.scalajs.react.ReactTouchEventFrom[T with org.scalajs.dom.raw.Element]) => onTouchMove(t0).runNow()))
    if (onTouchStart != null) __obj.updateDynamic("onTouchStart")(js.Any.fromFunction1((t0: japgolly.scalajs.react.ReactTouchEventFrom[T with org.scalajs.dom.raw.Element]) => onTouchStart(t0).runNow()))
    if (onTransitionEnd != null) __obj.updateDynamic("onTransitionEnd")(js.Any.fromFunction1((t0: japgolly.scalajs.react.ReactTransitionEventFrom[T with org.scalajs.dom.raw.Element]) => onTransitionEnd(t0).runNow()))
    if (onVolumeChange != null) __obj.updateDynamic("onVolumeChange")(js.Any.fromFunction1((t0: japgolly.scalajs.react.ReactEventFrom[T with org.scalajs.dom.raw.Element]) => onVolumeChange(t0).runNow()))
    if (onWaiting != null) __obj.updateDynamic("onWaiting")(js.Any.fromFunction1((t0: japgolly.scalajs.react.ReactEventFrom[T with org.scalajs.dom.raw.Element]) => onWaiting(t0).runNow()))
    if (onWheel != null) __obj.updateDynamic("onWheel")(js.Any.fromFunction1((t0: japgolly.scalajs.react.ReactWheelEventFrom[T with org.scalajs.dom.raw.Element]) => onWheel(t0).runNow()))
    __obj.asInstanceOf[DOMAttributes[T]]
  }
}

