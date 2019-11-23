package typings.react.reactMod

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
import typings.react.Anon_Html
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
    onAbort: js.UndefOr[ReactEventFrom[T with Element] => Callback] = js.undefined,
    onAnimationEnd: js.UndefOr[ReactAnimationEventFrom[T with Element] => Callback] = js.undefined,
    onAnimationIteration: js.UndefOr[ReactAnimationEventFrom[T with Element] => Callback] = js.undefined,
    onAnimationStart: js.UndefOr[ReactAnimationEventFrom[T with Element] => Callback] = js.undefined,
    onAuxClick: js.UndefOr[ReactMouseEventFrom[T with Element] => Callback] = js.undefined,
    onBeforeInput: js.UndefOr[ReactEventFrom[T with Element] => Callback] = js.undefined,
    onBlur: js.UndefOr[ReactFocusEventFrom[T with Element] => Callback] = js.undefined,
    onCanPlay: js.UndefOr[ReactEventFrom[T with Element] => Callback] = js.undefined,
    onCanPlayThrough: js.UndefOr[ReactEventFrom[T with Element] => Callback] = js.undefined,
    onChange: js.UndefOr[ReactEventFrom[T with Element] => Callback] = js.undefined,
    onClick: js.UndefOr[ReactMouseEventFrom[T with Element] => Callback] = js.undefined,
    onCompositionEnd: js.UndefOr[ReactCompositionEventFrom[T with Element] => Callback] = js.undefined,
    onCompositionStart: js.UndefOr[ReactCompositionEventFrom[T with Element] => Callback] = js.undefined,
    onCompositionUpdate: js.UndefOr[ReactCompositionEventFrom[T with Element] => Callback] = js.undefined,
    onContextMenu: js.UndefOr[ReactMouseEventFrom[T with Element] => Callback] = js.undefined,
    onCopy: js.UndefOr[ReactClipboardEventFrom[T with Element] => Callback] = js.undefined,
    onCut: js.UndefOr[ReactClipboardEventFrom[T with Element] => Callback] = js.undefined,
    onDoubleClick: js.UndefOr[ReactMouseEventFrom[T with Element] => Callback] = js.undefined,
    onDrag: js.UndefOr[ReactDragEventFrom[T with Element] => Callback] = js.undefined,
    onDragEnd: js.UndefOr[ReactDragEventFrom[T with Element] => Callback] = js.undefined,
    onDragEnter: js.UndefOr[ReactDragEventFrom[T with Element] => Callback] = js.undefined,
    onDragExit: js.UndefOr[ReactDragEventFrom[T with Element] => Callback] = js.undefined,
    onDragLeave: js.UndefOr[ReactDragEventFrom[T with Element] => Callback] = js.undefined,
    onDragOver: js.UndefOr[ReactDragEventFrom[T with Element] => Callback] = js.undefined,
    onDragStart: js.UndefOr[ReactDragEventFrom[T with Element] => Callback] = js.undefined,
    onDrop: js.UndefOr[ReactDragEventFrom[T with Element] => Callback] = js.undefined,
    onDurationChange: js.UndefOr[ReactEventFrom[T with Element] => Callback] = js.undefined,
    onEmptied: js.UndefOr[ReactEventFrom[T with Element] => Callback] = js.undefined,
    onEncrypted: js.UndefOr[ReactEventFrom[T with Element] => Callback] = js.undefined,
    onEnded: js.UndefOr[ReactEventFrom[T with Element] => Callback] = js.undefined,
    onError: js.UndefOr[ReactEventFrom[T with Element] => Callback] = js.undefined,
    onFocus: js.UndefOr[ReactFocusEventFrom[T with Element] => Callback] = js.undefined,
    onInput: js.UndefOr[ReactEventFrom[T with Element] => Callback] = js.undefined,
    onInvalid: js.UndefOr[ReactEventFrom[T with Element] => Callback] = js.undefined,
    onKeyDown: js.UndefOr[ReactKeyboardEventFrom[T with Element] => Callback] = js.undefined,
    onKeyPress: js.UndefOr[ReactKeyboardEventFrom[T with Element] => Callback] = js.undefined,
    onKeyUp: js.UndefOr[ReactKeyboardEventFrom[T with Element] => Callback] = js.undefined,
    onLoad: js.UndefOr[ReactEventFrom[T with Element] => Callback] = js.undefined,
    onLoadStart: js.UndefOr[ReactEventFrom[T with Element] => Callback] = js.undefined,
    onLoadedData: js.UndefOr[ReactEventFrom[T with Element] => Callback] = js.undefined,
    onLoadedMetadata: js.UndefOr[ReactEventFrom[T with Element] => Callback] = js.undefined,
    onMouseDown: js.UndefOr[ReactMouseEventFrom[T with Element] => Callback] = js.undefined,
    onMouseEnter: js.UndefOr[ReactMouseEventFrom[T with Element] => Callback] = js.undefined,
    onMouseLeave: js.UndefOr[ReactMouseEventFrom[T with Element] => Callback] = js.undefined,
    onMouseMove: js.UndefOr[ReactMouseEventFrom[T with Element] => Callback] = js.undefined,
    onMouseOut: js.UndefOr[ReactMouseEventFrom[T with Element] => Callback] = js.undefined,
    onMouseOver: js.UndefOr[ReactMouseEventFrom[T with Element] => Callback] = js.undefined,
    onMouseUp: js.UndefOr[ReactMouseEventFrom[T with Element] => Callback] = js.undefined,
    onPaste: js.UndefOr[ReactClipboardEventFrom[T with Element] => Callback] = js.undefined,
    onPause: js.UndefOr[ReactEventFrom[T with Element] => Callback] = js.undefined,
    onPlay: js.UndefOr[ReactEventFrom[T with Element] => Callback] = js.undefined,
    onPlaying: js.UndefOr[ReactEventFrom[T with Element] => Callback] = js.undefined,
    onPointerCancel: js.UndefOr[ReactPointerEventFrom[T with Element] => Callback] = js.undefined,
    onPointerDown: js.UndefOr[ReactPointerEventFrom[T with Element] => Callback] = js.undefined,
    onPointerEnter: js.UndefOr[ReactPointerEventFrom[T with Element] => Callback] = js.undefined,
    onPointerLeave: js.UndefOr[ReactPointerEventFrom[T with Element] => Callback] = js.undefined,
    onPointerMove: js.UndefOr[ReactPointerEventFrom[T with Element] => Callback] = js.undefined,
    onPointerOut: js.UndefOr[ReactPointerEventFrom[T with Element] => Callback] = js.undefined,
    onPointerOver: js.UndefOr[ReactPointerEventFrom[T with Element] => Callback] = js.undefined,
    onPointerUp: js.UndefOr[ReactPointerEventFrom[T with Element] => Callback] = js.undefined,
    onProgress: js.UndefOr[ReactEventFrom[T with Element] => Callback] = js.undefined,
    onRateChange: js.UndefOr[ReactEventFrom[T with Element] => Callback] = js.undefined,
    onReset: js.UndefOr[ReactEventFrom[T with Element] => Callback] = js.undefined,
    onScroll: js.UndefOr[ReactUIEventFrom[T with Element] => Callback] = js.undefined,
    onSeeked: js.UndefOr[ReactEventFrom[T with Element] => Callback] = js.undefined,
    onSeeking: js.UndefOr[ReactEventFrom[T with Element] => Callback] = js.undefined,
    onSelect: js.UndefOr[ReactEventFrom[T with Element] => Callback] = js.undefined,
    onStalled: js.UndefOr[ReactEventFrom[T with Element] => Callback] = js.undefined,
    onSubmit: js.UndefOr[ReactEventFrom[T with Element] => Callback] = js.undefined,
    onSuspend: js.UndefOr[ReactEventFrom[T with Element] => Callback] = js.undefined,
    onTimeUpdate: js.UndefOr[ReactEventFrom[T with Element] => Callback] = js.undefined,
    onTouchCancel: js.UndefOr[ReactTouchEventFrom[T with Element] => Callback] = js.undefined,
    onTouchEnd: js.UndefOr[ReactTouchEventFrom[T with Element] => Callback] = js.undefined,
    onTouchMove: js.UndefOr[ReactTouchEventFrom[T with Element] => Callback] = js.undefined,
    onTouchStart: js.UndefOr[ReactTouchEventFrom[T with Element] => Callback] = js.undefined,
    onTransitionEnd: js.UndefOr[ReactTransitionEventFrom[T with Element] => Callback] = js.undefined,
    onVolumeChange: js.UndefOr[ReactEventFrom[T with Element] => Callback] = js.undefined,
    onWaiting: js.UndefOr[ReactEventFrom[T with Element] => Callback] = js.undefined,
    onWheel: js.UndefOr[ReactWheelEventFrom[T with Element] => Callback] = js.undefined
  ): DOMAttributes[T] = {
    val __obj = js.Dynamic.literal()
    if (children != null) __obj.updateDynamic("children")(children.rawNode.asInstanceOf[js.Any])
    if (dangerouslySetInnerHTML != null) __obj.updateDynamic("dangerouslySetInnerHTML")(dangerouslySetInnerHTML)
    onAbort.foreach(p => __obj.updateDynamic("onAbort")(js.Any.fromFunction1(((t0: japgolly.scalajs.react.ReactEventFrom[T with org.scalajs.dom.raw.Element]) => p(t0).runNow()))))
    onAnimationEnd.foreach(p => __obj.updateDynamic("onAnimationEnd")(js.Any.fromFunction1(((t0: japgolly.scalajs.react.ReactAnimationEventFrom[T with org.scalajs.dom.raw.Element]) => p(t0).runNow()))))
    onAnimationIteration.foreach(p => __obj.updateDynamic("onAnimationIteration")(js.Any.fromFunction1(((t0: japgolly.scalajs.react.ReactAnimationEventFrom[T with org.scalajs.dom.raw.Element]) => p(t0).runNow()))))
    onAnimationStart.foreach(p => __obj.updateDynamic("onAnimationStart")(js.Any.fromFunction1(((t0: japgolly.scalajs.react.ReactAnimationEventFrom[T with org.scalajs.dom.raw.Element]) => p(t0).runNow()))))
    onAuxClick.foreach(p => __obj.updateDynamic("onAuxClick")(js.Any.fromFunction1(((t0: japgolly.scalajs.react.ReactMouseEventFrom[T with org.scalajs.dom.raw.Element]) => p(t0).runNow()))))
    onBeforeInput.foreach(p => __obj.updateDynamic("onBeforeInput")(js.Any.fromFunction1(((t0: japgolly.scalajs.react.ReactEventFrom[T with org.scalajs.dom.raw.Element]) => p(t0).runNow()))))
    onBlur.foreach(p => __obj.updateDynamic("onBlur")(js.Any.fromFunction1(((t0: japgolly.scalajs.react.ReactFocusEventFrom[T with org.scalajs.dom.raw.Element]) => p(t0).runNow()))))
    onCanPlay.foreach(p => __obj.updateDynamic("onCanPlay")(js.Any.fromFunction1(((t0: japgolly.scalajs.react.ReactEventFrom[T with org.scalajs.dom.raw.Element]) => p(t0).runNow()))))
    onCanPlayThrough.foreach(p => __obj.updateDynamic("onCanPlayThrough")(js.Any.fromFunction1(((t0: japgolly.scalajs.react.ReactEventFrom[T with org.scalajs.dom.raw.Element]) => p(t0).runNow()))))
    onChange.foreach(p => __obj.updateDynamic("onChange")(js.Any.fromFunction1(((t0: japgolly.scalajs.react.ReactEventFrom[T with org.scalajs.dom.raw.Element]) => p(t0).runNow()))))
    onClick.foreach(p => __obj.updateDynamic("onClick")(js.Any.fromFunction1(((t0: japgolly.scalajs.react.ReactMouseEventFrom[T with org.scalajs.dom.raw.Element]) => p(t0).runNow()))))
    onCompositionEnd.foreach(p => __obj.updateDynamic("onCompositionEnd")(js.Any.fromFunction1(((t0: japgolly.scalajs.react.ReactCompositionEventFrom[T with org.scalajs.dom.raw.Element]) => p(t0).runNow()))))
    onCompositionStart.foreach(p => __obj.updateDynamic("onCompositionStart")(js.Any.fromFunction1(((t0: japgolly.scalajs.react.ReactCompositionEventFrom[T with org.scalajs.dom.raw.Element]) => p(t0).runNow()))))
    onCompositionUpdate.foreach(p => __obj.updateDynamic("onCompositionUpdate")(js.Any.fromFunction1(((t0: japgolly.scalajs.react.ReactCompositionEventFrom[T with org.scalajs.dom.raw.Element]) => p(t0).runNow()))))
    onContextMenu.foreach(p => __obj.updateDynamic("onContextMenu")(js.Any.fromFunction1(((t0: japgolly.scalajs.react.ReactMouseEventFrom[T with org.scalajs.dom.raw.Element]) => p(t0).runNow()))))
    onCopy.foreach(p => __obj.updateDynamic("onCopy")(js.Any.fromFunction1(((t0: japgolly.scalajs.react.ReactClipboardEventFrom[T with org.scalajs.dom.raw.Element]) => p(t0).runNow()))))
    onCut.foreach(p => __obj.updateDynamic("onCut")(js.Any.fromFunction1(((t0: japgolly.scalajs.react.ReactClipboardEventFrom[T with org.scalajs.dom.raw.Element]) => p(t0).runNow()))))
    onDoubleClick.foreach(p => __obj.updateDynamic("onDoubleClick")(js.Any.fromFunction1(((t0: japgolly.scalajs.react.ReactMouseEventFrom[T with org.scalajs.dom.raw.Element]) => p(t0).runNow()))))
    onDrag.foreach(p => __obj.updateDynamic("onDrag")(js.Any.fromFunction1(((t0: japgolly.scalajs.react.ReactDragEventFrom[T with org.scalajs.dom.raw.Element]) => p(t0).runNow()))))
    onDragEnd.foreach(p => __obj.updateDynamic("onDragEnd")(js.Any.fromFunction1(((t0: japgolly.scalajs.react.ReactDragEventFrom[T with org.scalajs.dom.raw.Element]) => p(t0).runNow()))))
    onDragEnter.foreach(p => __obj.updateDynamic("onDragEnter")(js.Any.fromFunction1(((t0: japgolly.scalajs.react.ReactDragEventFrom[T with org.scalajs.dom.raw.Element]) => p(t0).runNow()))))
    onDragExit.foreach(p => __obj.updateDynamic("onDragExit")(js.Any.fromFunction1(((t0: japgolly.scalajs.react.ReactDragEventFrom[T with org.scalajs.dom.raw.Element]) => p(t0).runNow()))))
    onDragLeave.foreach(p => __obj.updateDynamic("onDragLeave")(js.Any.fromFunction1(((t0: japgolly.scalajs.react.ReactDragEventFrom[T with org.scalajs.dom.raw.Element]) => p(t0).runNow()))))
    onDragOver.foreach(p => __obj.updateDynamic("onDragOver")(js.Any.fromFunction1(((t0: japgolly.scalajs.react.ReactDragEventFrom[T with org.scalajs.dom.raw.Element]) => p(t0).runNow()))))
    onDragStart.foreach(p => __obj.updateDynamic("onDragStart")(js.Any.fromFunction1(((t0: japgolly.scalajs.react.ReactDragEventFrom[T with org.scalajs.dom.raw.Element]) => p(t0).runNow()))))
    onDrop.foreach(p => __obj.updateDynamic("onDrop")(js.Any.fromFunction1(((t0: japgolly.scalajs.react.ReactDragEventFrom[T with org.scalajs.dom.raw.Element]) => p(t0).runNow()))))
    onDurationChange.foreach(p => __obj.updateDynamic("onDurationChange")(js.Any.fromFunction1(((t0: japgolly.scalajs.react.ReactEventFrom[T with org.scalajs.dom.raw.Element]) => p(t0).runNow()))))
    onEmptied.foreach(p => __obj.updateDynamic("onEmptied")(js.Any.fromFunction1(((t0: japgolly.scalajs.react.ReactEventFrom[T with org.scalajs.dom.raw.Element]) => p(t0).runNow()))))
    onEncrypted.foreach(p => __obj.updateDynamic("onEncrypted")(js.Any.fromFunction1(((t0: japgolly.scalajs.react.ReactEventFrom[T with org.scalajs.dom.raw.Element]) => p(t0).runNow()))))
    onEnded.foreach(p => __obj.updateDynamic("onEnded")(js.Any.fromFunction1(((t0: japgolly.scalajs.react.ReactEventFrom[T with org.scalajs.dom.raw.Element]) => p(t0).runNow()))))
    onError.foreach(p => __obj.updateDynamic("onError")(js.Any.fromFunction1(((t0: japgolly.scalajs.react.ReactEventFrom[T with org.scalajs.dom.raw.Element]) => p(t0).runNow()))))
    onFocus.foreach(p => __obj.updateDynamic("onFocus")(js.Any.fromFunction1(((t0: japgolly.scalajs.react.ReactFocusEventFrom[T with org.scalajs.dom.raw.Element]) => p(t0).runNow()))))
    onInput.foreach(p => __obj.updateDynamic("onInput")(js.Any.fromFunction1(((t0: japgolly.scalajs.react.ReactEventFrom[T with org.scalajs.dom.raw.Element]) => p(t0).runNow()))))
    onInvalid.foreach(p => __obj.updateDynamic("onInvalid")(js.Any.fromFunction1(((t0: japgolly.scalajs.react.ReactEventFrom[T with org.scalajs.dom.raw.Element]) => p(t0).runNow()))))
    onKeyDown.foreach(p => __obj.updateDynamic("onKeyDown")(js.Any.fromFunction1(((t0: japgolly.scalajs.react.ReactKeyboardEventFrom[T with org.scalajs.dom.raw.Element]) => p(t0).runNow()))))
    onKeyPress.foreach(p => __obj.updateDynamic("onKeyPress")(js.Any.fromFunction1(((t0: japgolly.scalajs.react.ReactKeyboardEventFrom[T with org.scalajs.dom.raw.Element]) => p(t0).runNow()))))
    onKeyUp.foreach(p => __obj.updateDynamic("onKeyUp")(js.Any.fromFunction1(((t0: japgolly.scalajs.react.ReactKeyboardEventFrom[T with org.scalajs.dom.raw.Element]) => p(t0).runNow()))))
    onLoad.foreach(p => __obj.updateDynamic("onLoad")(js.Any.fromFunction1(((t0: japgolly.scalajs.react.ReactEventFrom[T with org.scalajs.dom.raw.Element]) => p(t0).runNow()))))
    onLoadStart.foreach(p => __obj.updateDynamic("onLoadStart")(js.Any.fromFunction1(((t0: japgolly.scalajs.react.ReactEventFrom[T with org.scalajs.dom.raw.Element]) => p(t0).runNow()))))
    onLoadedData.foreach(p => __obj.updateDynamic("onLoadedData")(js.Any.fromFunction1(((t0: japgolly.scalajs.react.ReactEventFrom[T with org.scalajs.dom.raw.Element]) => p(t0).runNow()))))
    onLoadedMetadata.foreach(p => __obj.updateDynamic("onLoadedMetadata")(js.Any.fromFunction1(((t0: japgolly.scalajs.react.ReactEventFrom[T with org.scalajs.dom.raw.Element]) => p(t0).runNow()))))
    onMouseDown.foreach(p => __obj.updateDynamic("onMouseDown")(js.Any.fromFunction1(((t0: japgolly.scalajs.react.ReactMouseEventFrom[T with org.scalajs.dom.raw.Element]) => p(t0).runNow()))))
    onMouseEnter.foreach(p => __obj.updateDynamic("onMouseEnter")(js.Any.fromFunction1(((t0: japgolly.scalajs.react.ReactMouseEventFrom[T with org.scalajs.dom.raw.Element]) => p(t0).runNow()))))
    onMouseLeave.foreach(p => __obj.updateDynamic("onMouseLeave")(js.Any.fromFunction1(((t0: japgolly.scalajs.react.ReactMouseEventFrom[T with org.scalajs.dom.raw.Element]) => p(t0).runNow()))))
    onMouseMove.foreach(p => __obj.updateDynamic("onMouseMove")(js.Any.fromFunction1(((t0: japgolly.scalajs.react.ReactMouseEventFrom[T with org.scalajs.dom.raw.Element]) => p(t0).runNow()))))
    onMouseOut.foreach(p => __obj.updateDynamic("onMouseOut")(js.Any.fromFunction1(((t0: japgolly.scalajs.react.ReactMouseEventFrom[T with org.scalajs.dom.raw.Element]) => p(t0).runNow()))))
    onMouseOver.foreach(p => __obj.updateDynamic("onMouseOver")(js.Any.fromFunction1(((t0: japgolly.scalajs.react.ReactMouseEventFrom[T with org.scalajs.dom.raw.Element]) => p(t0).runNow()))))
    onMouseUp.foreach(p => __obj.updateDynamic("onMouseUp")(js.Any.fromFunction1(((t0: japgolly.scalajs.react.ReactMouseEventFrom[T with org.scalajs.dom.raw.Element]) => p(t0).runNow()))))
    onPaste.foreach(p => __obj.updateDynamic("onPaste")(js.Any.fromFunction1(((t0: japgolly.scalajs.react.ReactClipboardEventFrom[T with org.scalajs.dom.raw.Element]) => p(t0).runNow()))))
    onPause.foreach(p => __obj.updateDynamic("onPause")(js.Any.fromFunction1(((t0: japgolly.scalajs.react.ReactEventFrom[T with org.scalajs.dom.raw.Element]) => p(t0).runNow()))))
    onPlay.foreach(p => __obj.updateDynamic("onPlay")(js.Any.fromFunction1(((t0: japgolly.scalajs.react.ReactEventFrom[T with org.scalajs.dom.raw.Element]) => p(t0).runNow()))))
    onPlaying.foreach(p => __obj.updateDynamic("onPlaying")(js.Any.fromFunction1(((t0: japgolly.scalajs.react.ReactEventFrom[T with org.scalajs.dom.raw.Element]) => p(t0).runNow()))))
    onPointerCancel.foreach(p => __obj.updateDynamic("onPointerCancel")(js.Any.fromFunction1(((t0: japgolly.scalajs.react.ReactPointerEventFrom[T with org.scalajs.dom.raw.Element]) => p(t0).runNow()))))
    onPointerDown.foreach(p => __obj.updateDynamic("onPointerDown")(js.Any.fromFunction1(((t0: japgolly.scalajs.react.ReactPointerEventFrom[T with org.scalajs.dom.raw.Element]) => p(t0).runNow()))))
    onPointerEnter.foreach(p => __obj.updateDynamic("onPointerEnter")(js.Any.fromFunction1(((t0: japgolly.scalajs.react.ReactPointerEventFrom[T with org.scalajs.dom.raw.Element]) => p(t0).runNow()))))
    onPointerLeave.foreach(p => __obj.updateDynamic("onPointerLeave")(js.Any.fromFunction1(((t0: japgolly.scalajs.react.ReactPointerEventFrom[T with org.scalajs.dom.raw.Element]) => p(t0).runNow()))))
    onPointerMove.foreach(p => __obj.updateDynamic("onPointerMove")(js.Any.fromFunction1(((t0: japgolly.scalajs.react.ReactPointerEventFrom[T with org.scalajs.dom.raw.Element]) => p(t0).runNow()))))
    onPointerOut.foreach(p => __obj.updateDynamic("onPointerOut")(js.Any.fromFunction1(((t0: japgolly.scalajs.react.ReactPointerEventFrom[T with org.scalajs.dom.raw.Element]) => p(t0).runNow()))))
    onPointerOver.foreach(p => __obj.updateDynamic("onPointerOver")(js.Any.fromFunction1(((t0: japgolly.scalajs.react.ReactPointerEventFrom[T with org.scalajs.dom.raw.Element]) => p(t0).runNow()))))
    onPointerUp.foreach(p => __obj.updateDynamic("onPointerUp")(js.Any.fromFunction1(((t0: japgolly.scalajs.react.ReactPointerEventFrom[T with org.scalajs.dom.raw.Element]) => p(t0).runNow()))))
    onProgress.foreach(p => __obj.updateDynamic("onProgress")(js.Any.fromFunction1(((t0: japgolly.scalajs.react.ReactEventFrom[T with org.scalajs.dom.raw.Element]) => p(t0).runNow()))))
    onRateChange.foreach(p => __obj.updateDynamic("onRateChange")(js.Any.fromFunction1(((t0: japgolly.scalajs.react.ReactEventFrom[T with org.scalajs.dom.raw.Element]) => p(t0).runNow()))))
    onReset.foreach(p => __obj.updateDynamic("onReset")(js.Any.fromFunction1(((t0: japgolly.scalajs.react.ReactEventFrom[T with org.scalajs.dom.raw.Element]) => p(t0).runNow()))))
    onScroll.foreach(p => __obj.updateDynamic("onScroll")(js.Any.fromFunction1(((t0: japgolly.scalajs.react.ReactUIEventFrom[T with org.scalajs.dom.raw.Element]) => p(t0).runNow()))))
    onSeeked.foreach(p => __obj.updateDynamic("onSeeked")(js.Any.fromFunction1(((t0: japgolly.scalajs.react.ReactEventFrom[T with org.scalajs.dom.raw.Element]) => p(t0).runNow()))))
    onSeeking.foreach(p => __obj.updateDynamic("onSeeking")(js.Any.fromFunction1(((t0: japgolly.scalajs.react.ReactEventFrom[T with org.scalajs.dom.raw.Element]) => p(t0).runNow()))))
    onSelect.foreach(p => __obj.updateDynamic("onSelect")(js.Any.fromFunction1(((t0: japgolly.scalajs.react.ReactEventFrom[T with org.scalajs.dom.raw.Element]) => p(t0).runNow()))))
    onStalled.foreach(p => __obj.updateDynamic("onStalled")(js.Any.fromFunction1(((t0: japgolly.scalajs.react.ReactEventFrom[T with org.scalajs.dom.raw.Element]) => p(t0).runNow()))))
    onSubmit.foreach(p => __obj.updateDynamic("onSubmit")(js.Any.fromFunction1(((t0: japgolly.scalajs.react.ReactEventFrom[T with org.scalajs.dom.raw.Element]) => p(t0).runNow()))))
    onSuspend.foreach(p => __obj.updateDynamic("onSuspend")(js.Any.fromFunction1(((t0: japgolly.scalajs.react.ReactEventFrom[T with org.scalajs.dom.raw.Element]) => p(t0).runNow()))))
    onTimeUpdate.foreach(p => __obj.updateDynamic("onTimeUpdate")(js.Any.fromFunction1(((t0: japgolly.scalajs.react.ReactEventFrom[T with org.scalajs.dom.raw.Element]) => p(t0).runNow()))))
    onTouchCancel.foreach(p => __obj.updateDynamic("onTouchCancel")(js.Any.fromFunction1(((t0: japgolly.scalajs.react.ReactTouchEventFrom[T with org.scalajs.dom.raw.Element]) => p(t0).runNow()))))
    onTouchEnd.foreach(p => __obj.updateDynamic("onTouchEnd")(js.Any.fromFunction1(((t0: japgolly.scalajs.react.ReactTouchEventFrom[T with org.scalajs.dom.raw.Element]) => p(t0).runNow()))))
    onTouchMove.foreach(p => __obj.updateDynamic("onTouchMove")(js.Any.fromFunction1(((t0: japgolly.scalajs.react.ReactTouchEventFrom[T with org.scalajs.dom.raw.Element]) => p(t0).runNow()))))
    onTouchStart.foreach(p => __obj.updateDynamic("onTouchStart")(js.Any.fromFunction1(((t0: japgolly.scalajs.react.ReactTouchEventFrom[T with org.scalajs.dom.raw.Element]) => p(t0).runNow()))))
    onTransitionEnd.foreach(p => __obj.updateDynamic("onTransitionEnd")(js.Any.fromFunction1(((t0: japgolly.scalajs.react.ReactTransitionEventFrom[T with org.scalajs.dom.raw.Element]) => p(t0).runNow()))))
    onVolumeChange.foreach(p => __obj.updateDynamic("onVolumeChange")(js.Any.fromFunction1(((t0: japgolly.scalajs.react.ReactEventFrom[T with org.scalajs.dom.raw.Element]) => p(t0).runNow()))))
    onWaiting.foreach(p => __obj.updateDynamic("onWaiting")(js.Any.fromFunction1(((t0: japgolly.scalajs.react.ReactEventFrom[T with org.scalajs.dom.raw.Element]) => p(t0).runNow()))))
    onWheel.foreach(p => __obj.updateDynamic("onWheel")(js.Any.fromFunction1(((t0: japgolly.scalajs.react.ReactWheelEventFrom[T with org.scalajs.dom.raw.Element]) => p(t0).runNow()))))
    __obj.asInstanceOf[DOMAttributes[T]]
  }
}

