package typings.react.mod

import typings.react.AnonHtml
import typings.std.Event
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@js.native
trait DOMAttributes[T] extends js.Object {
  var children: js.UndefOr[ReactNode] = js.native
  var dangerouslySetInnerHTML: js.UndefOr[AnonHtml] = js.native
  // Media Events
  var onAbort: js.UndefOr[ReactEventHandler[T]] = js.native
  var onAnimationEnd: js.UndefOr[AnimationEventHandler[T]] = js.native
  var onAnimationIteration: js.UndefOr[AnimationEventHandler[T]] = js.native
  // Animation Events
  var onAnimationStart: js.UndefOr[AnimationEventHandler[T]] = js.native
  // MouseEvents
  var onAuxClick: js.UndefOr[MouseEventHandler[T]] = js.native
  var onBeforeInput: js.UndefOr[FormEventHandler[T]] = js.native
  var onBlur: js.UndefOr[FocusEventHandler[T]] = js.native
  var onCanPlay: js.UndefOr[ReactEventHandler[T]] = js.native
  var onCanPlayThrough: js.UndefOr[ReactEventHandler[T]] = js.native
  // Form Events
  var onChange: js.UndefOr[FormEventHandler[T]] = js.native
  var onClick: js.UndefOr[MouseEventHandler[T]] = js.native
  // Composition Events
  var onCompositionEnd: js.UndefOr[CompositionEventHandler[T]] = js.native
  var onCompositionStart: js.UndefOr[CompositionEventHandler[T]] = js.native
  var onCompositionUpdate: js.UndefOr[CompositionEventHandler[T]] = js.native
  var onContextMenu: js.UndefOr[MouseEventHandler[T]] = js.native
  // Clipboard Events
  var onCopy: js.UndefOr[ClipboardEventHandler[T]] = js.native
  var onCut: js.UndefOr[ClipboardEventHandler[T]] = js.native
  var onDoubleClick: js.UndefOr[MouseEventHandler[T]] = js.native
  var onDrag: js.UndefOr[DragEventHandler[T]] = js.native
  var onDragEnd: js.UndefOr[DragEventHandler[T]] = js.native
  var onDragEnter: js.UndefOr[DragEventHandler[T]] = js.native
  var onDragExit: js.UndefOr[DragEventHandler[T]] = js.native
  var onDragLeave: js.UndefOr[DragEventHandler[T]] = js.native
  var onDragOver: js.UndefOr[DragEventHandler[T]] = js.native
  var onDragStart: js.UndefOr[DragEventHandler[T]] = js.native
  var onDrop: js.UndefOr[DragEventHandler[T]] = js.native
  var onDurationChange: js.UndefOr[ReactEventHandler[T]] = js.native
  var onEmptied: js.UndefOr[ReactEventHandler[T]] = js.native
  var onEncrypted: js.UndefOr[ReactEventHandler[T]] = js.native
  var onEnded: js.UndefOr[ReactEventHandler[T]] = js.native
  var onError: js.UndefOr[ReactEventHandler[T]] = js.native
  // Focus Events
  var onFocus: js.UndefOr[FocusEventHandler[T]] = js.native
  var onInput: js.UndefOr[FormEventHandler[T]] = js.native
  var onInvalid: js.UndefOr[FormEventHandler[T]] = js.native
   // also a Media Event
  // Keyboard Events
  var onKeyDown: js.UndefOr[KeyboardEventHandler[T]] = js.native
  var onKeyPress: js.UndefOr[KeyboardEventHandler[T]] = js.native
  var onKeyUp: js.UndefOr[KeyboardEventHandler[T]] = js.native
  // Image Events
  var onLoad: js.UndefOr[ReactEventHandler[T]] = js.native
  var onLoadStart: js.UndefOr[ReactEventHandler[T]] = js.native
  var onLoadedData: js.UndefOr[ReactEventHandler[T]] = js.native
  var onLoadedMetadata: js.UndefOr[ReactEventHandler[T]] = js.native
  var onMouseDown: js.UndefOr[MouseEventHandler[T]] = js.native
  var onMouseEnter: js.UndefOr[MouseEventHandler[T]] = js.native
  var onMouseLeave: js.UndefOr[MouseEventHandler[T]] = js.native
  var onMouseMove: js.UndefOr[MouseEventHandler[T]] = js.native
  var onMouseOut: js.UndefOr[MouseEventHandler[T]] = js.native
  var onMouseOver: js.UndefOr[MouseEventHandler[T]] = js.native
  var onMouseUp: js.UndefOr[MouseEventHandler[T]] = js.native
  var onPaste: js.UndefOr[ClipboardEventHandler[T]] = js.native
  var onPause: js.UndefOr[ReactEventHandler[T]] = js.native
  var onPlay: js.UndefOr[ReactEventHandler[T]] = js.native
  var onPlaying: js.UndefOr[ReactEventHandler[T]] = js.native
  var onPointerCancel: js.UndefOr[PointerEventHandler[T]] = js.native
  // Pointer Events
  var onPointerDown: js.UndefOr[PointerEventHandler[T]] = js.native
  var onPointerEnter: js.UndefOr[PointerEventHandler[T]] = js.native
  var onPointerLeave: js.UndefOr[PointerEventHandler[T]] = js.native
  var onPointerMove: js.UndefOr[PointerEventHandler[T]] = js.native
  var onPointerOut: js.UndefOr[PointerEventHandler[T]] = js.native
  var onPointerOver: js.UndefOr[PointerEventHandler[T]] = js.native
  var onPointerUp: js.UndefOr[PointerEventHandler[T]] = js.native
  var onProgress: js.UndefOr[ReactEventHandler[T]] = js.native
  var onRateChange: js.UndefOr[ReactEventHandler[T]] = js.native
  var onReset: js.UndefOr[FormEventHandler[T]] = js.native
  // UI Events
  var onScroll: js.UndefOr[UIEventHandler[T]] = js.native
  var onSeeked: js.UndefOr[ReactEventHandler[T]] = js.native
  var onSeeking: js.UndefOr[ReactEventHandler[T]] = js.native
  // Selection Events
  var onSelect: js.UndefOr[ReactEventHandler[T]] = js.native
  var onStalled: js.UndefOr[ReactEventHandler[T]] = js.native
  var onSubmit: js.UndefOr[FormEventHandler[T]] = js.native
  var onSuspend: js.UndefOr[ReactEventHandler[T]] = js.native
  var onTimeUpdate: js.UndefOr[ReactEventHandler[T]] = js.native
  // Touch Events
  var onTouchCancel: js.UndefOr[TouchEventHandler[T]] = js.native
  var onTouchEnd: js.UndefOr[TouchEventHandler[T]] = js.native
  var onTouchMove: js.UndefOr[TouchEventHandler[T]] = js.native
  var onTouchStart: js.UndefOr[TouchEventHandler[T]] = js.native
  // Transition Events
  var onTransitionEnd: js.UndefOr[TransitionEventHandler[T]] = js.native
  var onVolumeChange: js.UndefOr[ReactEventHandler[T]] = js.native
  var onWaiting: js.UndefOr[ReactEventHandler[T]] = js.native
  // Wheel Events
  var onWheel: js.UndefOr[WheelEventHandler[T]] = js.native
}

object DOMAttributes {
  @scala.inline
  def apply[T](
    children: ReactNode = null,
    dangerouslySetInnerHTML: AnonHtml = null,
    onAbort: SyntheticEvent[T, Event] => Unit = null,
    onAnimationEnd: AnimationEvent[T] => Unit = null,
    onAnimationIteration: AnimationEvent[T] => Unit = null,
    onAnimationStart: AnimationEvent[T] => Unit = null,
    onAuxClick: MouseEvent[T, NativeMouseEvent] => Unit = null,
    onBeforeInput: FormEvent[T] => Unit = null,
    onBlur: FocusEvent[T] => Unit = null,
    onCanPlay: SyntheticEvent[T, Event] => Unit = null,
    onCanPlayThrough: SyntheticEvent[T, Event] => Unit = null,
    onChange: FormEvent[T] => Unit = null,
    onClick: MouseEvent[T, NativeMouseEvent] => Unit = null,
    onCompositionEnd: CompositionEvent[T] => Unit = null,
    onCompositionStart: CompositionEvent[T] => Unit = null,
    onCompositionUpdate: CompositionEvent[T] => Unit = null,
    onContextMenu: MouseEvent[T, NativeMouseEvent] => Unit = null,
    onCopy: ClipboardEvent[T] => Unit = null,
    onCut: ClipboardEvent[T] => Unit = null,
    onDoubleClick: MouseEvent[T, NativeMouseEvent] => Unit = null,
    onDrag: DragEvent[T] => Unit = null,
    onDragEnd: DragEvent[T] => Unit = null,
    onDragEnter: DragEvent[T] => Unit = null,
    onDragExit: DragEvent[T] => Unit = null,
    onDragLeave: DragEvent[T] => Unit = null,
    onDragOver: DragEvent[T] => Unit = null,
    onDragStart: DragEvent[T] => Unit = null,
    onDrop: DragEvent[T] => Unit = null,
    onDurationChange: SyntheticEvent[T, Event] => Unit = null,
    onEmptied: SyntheticEvent[T, Event] => Unit = null,
    onEncrypted: SyntheticEvent[T, Event] => Unit = null,
    onEnded: SyntheticEvent[T, Event] => Unit = null,
    onError: SyntheticEvent[T, Event] => Unit = null,
    onFocus: FocusEvent[T] => Unit = null,
    onInput: FormEvent[T] => Unit = null,
    onInvalid: FormEvent[T] => Unit = null,
    onKeyDown: KeyboardEvent[T] => Unit = null,
    onKeyPress: KeyboardEvent[T] => Unit = null,
    onKeyUp: KeyboardEvent[T] => Unit = null,
    onLoad: SyntheticEvent[T, Event] => Unit = null,
    onLoadStart: SyntheticEvent[T, Event] => Unit = null,
    onLoadedData: SyntheticEvent[T, Event] => Unit = null,
    onLoadedMetadata: SyntheticEvent[T, Event] => Unit = null,
    onMouseDown: MouseEvent[T, NativeMouseEvent] => Unit = null,
    onMouseEnter: MouseEvent[T, NativeMouseEvent] => Unit = null,
    onMouseLeave: MouseEvent[T, NativeMouseEvent] => Unit = null,
    onMouseMove: MouseEvent[T, NativeMouseEvent] => Unit = null,
    onMouseOut: MouseEvent[T, NativeMouseEvent] => Unit = null,
    onMouseOver: MouseEvent[T, NativeMouseEvent] => Unit = null,
    onMouseUp: MouseEvent[T, NativeMouseEvent] => Unit = null,
    onPaste: ClipboardEvent[T] => Unit = null,
    onPause: SyntheticEvent[T, Event] => Unit = null,
    onPlay: SyntheticEvent[T, Event] => Unit = null,
    onPlaying: SyntheticEvent[T, Event] => Unit = null,
    onPointerCancel: PointerEvent[T] => Unit = null,
    onPointerDown: PointerEvent[T] => Unit = null,
    onPointerEnter: PointerEvent[T] => Unit = null,
    onPointerLeave: PointerEvent[T] => Unit = null,
    onPointerMove: PointerEvent[T] => Unit = null,
    onPointerOut: PointerEvent[T] => Unit = null,
    onPointerOver: PointerEvent[T] => Unit = null,
    onPointerUp: PointerEvent[T] => Unit = null,
    onProgress: SyntheticEvent[T, Event] => Unit = null,
    onRateChange: SyntheticEvent[T, Event] => Unit = null,
    onReset: FormEvent[T] => Unit = null,
    onScroll: UIEvent[T] => Unit = null,
    onSeeked: SyntheticEvent[T, Event] => Unit = null,
    onSeeking: SyntheticEvent[T, Event] => Unit = null,
    onSelect: SyntheticEvent[T, Event] => Unit = null,
    onStalled: SyntheticEvent[T, Event] => Unit = null,
    onSubmit: FormEvent[T] => Unit = null,
    onSuspend: SyntheticEvent[T, Event] => Unit = null,
    onTimeUpdate: SyntheticEvent[T, Event] => Unit = null,
    onTouchCancel: TouchEvent[T] => Unit = null,
    onTouchEnd: TouchEvent[T] => Unit = null,
    onTouchMove: TouchEvent[T] => Unit = null,
    onTouchStart: TouchEvent[T] => Unit = null,
    onTransitionEnd: TransitionEvent[T] => Unit = null,
    onVolumeChange: SyntheticEvent[T, Event] => Unit = null,
    onWaiting: SyntheticEvent[T, Event] => Unit = null,
    onWheel: WheelEvent[T] => Unit = null
  ): DOMAttributes[T] = {
    val __obj = js.Dynamic.literal()
    if (children != null) __obj.updateDynamic("children")(children.asInstanceOf[js.Any])
    if (dangerouslySetInnerHTML != null) __obj.updateDynamic("dangerouslySetInnerHTML")(dangerouslySetInnerHTML.asInstanceOf[js.Any])
    if (onAbort != null) __obj.updateDynamic("onAbort")(js.Any.fromFunction1(onAbort))
    if (onAnimationEnd != null) __obj.updateDynamic("onAnimationEnd")(js.Any.fromFunction1(onAnimationEnd))
    if (onAnimationIteration != null) __obj.updateDynamic("onAnimationIteration")(js.Any.fromFunction1(onAnimationIteration))
    if (onAnimationStart != null) __obj.updateDynamic("onAnimationStart")(js.Any.fromFunction1(onAnimationStart))
    if (onAuxClick != null) __obj.updateDynamic("onAuxClick")(js.Any.fromFunction1(onAuxClick))
    if (onBeforeInput != null) __obj.updateDynamic("onBeforeInput")(js.Any.fromFunction1(onBeforeInput))
    if (onBlur != null) __obj.updateDynamic("onBlur")(js.Any.fromFunction1(onBlur))
    if (onCanPlay != null) __obj.updateDynamic("onCanPlay")(js.Any.fromFunction1(onCanPlay))
    if (onCanPlayThrough != null) __obj.updateDynamic("onCanPlayThrough")(js.Any.fromFunction1(onCanPlayThrough))
    if (onChange != null) __obj.updateDynamic("onChange")(js.Any.fromFunction1(onChange))
    if (onClick != null) __obj.updateDynamic("onClick")(js.Any.fromFunction1(onClick))
    if (onCompositionEnd != null) __obj.updateDynamic("onCompositionEnd")(js.Any.fromFunction1(onCompositionEnd))
    if (onCompositionStart != null) __obj.updateDynamic("onCompositionStart")(js.Any.fromFunction1(onCompositionStart))
    if (onCompositionUpdate != null) __obj.updateDynamic("onCompositionUpdate")(js.Any.fromFunction1(onCompositionUpdate))
    if (onContextMenu != null) __obj.updateDynamic("onContextMenu")(js.Any.fromFunction1(onContextMenu))
    if (onCopy != null) __obj.updateDynamic("onCopy")(js.Any.fromFunction1(onCopy))
    if (onCut != null) __obj.updateDynamic("onCut")(js.Any.fromFunction1(onCut))
    if (onDoubleClick != null) __obj.updateDynamic("onDoubleClick")(js.Any.fromFunction1(onDoubleClick))
    if (onDrag != null) __obj.updateDynamic("onDrag")(js.Any.fromFunction1(onDrag))
    if (onDragEnd != null) __obj.updateDynamic("onDragEnd")(js.Any.fromFunction1(onDragEnd))
    if (onDragEnter != null) __obj.updateDynamic("onDragEnter")(js.Any.fromFunction1(onDragEnter))
    if (onDragExit != null) __obj.updateDynamic("onDragExit")(js.Any.fromFunction1(onDragExit))
    if (onDragLeave != null) __obj.updateDynamic("onDragLeave")(js.Any.fromFunction1(onDragLeave))
    if (onDragOver != null) __obj.updateDynamic("onDragOver")(js.Any.fromFunction1(onDragOver))
    if (onDragStart != null) __obj.updateDynamic("onDragStart")(js.Any.fromFunction1(onDragStart))
    if (onDrop != null) __obj.updateDynamic("onDrop")(js.Any.fromFunction1(onDrop))
    if (onDurationChange != null) __obj.updateDynamic("onDurationChange")(js.Any.fromFunction1(onDurationChange))
    if (onEmptied != null) __obj.updateDynamic("onEmptied")(js.Any.fromFunction1(onEmptied))
    if (onEncrypted != null) __obj.updateDynamic("onEncrypted")(js.Any.fromFunction1(onEncrypted))
    if (onEnded != null) __obj.updateDynamic("onEnded")(js.Any.fromFunction1(onEnded))
    if (onError != null) __obj.updateDynamic("onError")(js.Any.fromFunction1(onError))
    if (onFocus != null) __obj.updateDynamic("onFocus")(js.Any.fromFunction1(onFocus))
    if (onInput != null) __obj.updateDynamic("onInput")(js.Any.fromFunction1(onInput))
    if (onInvalid != null) __obj.updateDynamic("onInvalid")(js.Any.fromFunction1(onInvalid))
    if (onKeyDown != null) __obj.updateDynamic("onKeyDown")(js.Any.fromFunction1(onKeyDown))
    if (onKeyPress != null) __obj.updateDynamic("onKeyPress")(js.Any.fromFunction1(onKeyPress))
    if (onKeyUp != null) __obj.updateDynamic("onKeyUp")(js.Any.fromFunction1(onKeyUp))
    if (onLoad != null) __obj.updateDynamic("onLoad")(js.Any.fromFunction1(onLoad))
    if (onLoadStart != null) __obj.updateDynamic("onLoadStart")(js.Any.fromFunction1(onLoadStart))
    if (onLoadedData != null) __obj.updateDynamic("onLoadedData")(js.Any.fromFunction1(onLoadedData))
    if (onLoadedMetadata != null) __obj.updateDynamic("onLoadedMetadata")(js.Any.fromFunction1(onLoadedMetadata))
    if (onMouseDown != null) __obj.updateDynamic("onMouseDown")(js.Any.fromFunction1(onMouseDown))
    if (onMouseEnter != null) __obj.updateDynamic("onMouseEnter")(js.Any.fromFunction1(onMouseEnter))
    if (onMouseLeave != null) __obj.updateDynamic("onMouseLeave")(js.Any.fromFunction1(onMouseLeave))
    if (onMouseMove != null) __obj.updateDynamic("onMouseMove")(js.Any.fromFunction1(onMouseMove))
    if (onMouseOut != null) __obj.updateDynamic("onMouseOut")(js.Any.fromFunction1(onMouseOut))
    if (onMouseOver != null) __obj.updateDynamic("onMouseOver")(js.Any.fromFunction1(onMouseOver))
    if (onMouseUp != null) __obj.updateDynamic("onMouseUp")(js.Any.fromFunction1(onMouseUp))
    if (onPaste != null) __obj.updateDynamic("onPaste")(js.Any.fromFunction1(onPaste))
    if (onPause != null) __obj.updateDynamic("onPause")(js.Any.fromFunction1(onPause))
    if (onPlay != null) __obj.updateDynamic("onPlay")(js.Any.fromFunction1(onPlay))
    if (onPlaying != null) __obj.updateDynamic("onPlaying")(js.Any.fromFunction1(onPlaying))
    if (onPointerCancel != null) __obj.updateDynamic("onPointerCancel")(js.Any.fromFunction1(onPointerCancel))
    if (onPointerDown != null) __obj.updateDynamic("onPointerDown")(js.Any.fromFunction1(onPointerDown))
    if (onPointerEnter != null) __obj.updateDynamic("onPointerEnter")(js.Any.fromFunction1(onPointerEnter))
    if (onPointerLeave != null) __obj.updateDynamic("onPointerLeave")(js.Any.fromFunction1(onPointerLeave))
    if (onPointerMove != null) __obj.updateDynamic("onPointerMove")(js.Any.fromFunction1(onPointerMove))
    if (onPointerOut != null) __obj.updateDynamic("onPointerOut")(js.Any.fromFunction1(onPointerOut))
    if (onPointerOver != null) __obj.updateDynamic("onPointerOver")(js.Any.fromFunction1(onPointerOver))
    if (onPointerUp != null) __obj.updateDynamic("onPointerUp")(js.Any.fromFunction1(onPointerUp))
    if (onProgress != null) __obj.updateDynamic("onProgress")(js.Any.fromFunction1(onProgress))
    if (onRateChange != null) __obj.updateDynamic("onRateChange")(js.Any.fromFunction1(onRateChange))
    if (onReset != null) __obj.updateDynamic("onReset")(js.Any.fromFunction1(onReset))
    if (onScroll != null) __obj.updateDynamic("onScroll")(js.Any.fromFunction1(onScroll))
    if (onSeeked != null) __obj.updateDynamic("onSeeked")(js.Any.fromFunction1(onSeeked))
    if (onSeeking != null) __obj.updateDynamic("onSeeking")(js.Any.fromFunction1(onSeeking))
    if (onSelect != null) __obj.updateDynamic("onSelect")(js.Any.fromFunction1(onSelect))
    if (onStalled != null) __obj.updateDynamic("onStalled")(js.Any.fromFunction1(onStalled))
    if (onSubmit != null) __obj.updateDynamic("onSubmit")(js.Any.fromFunction1(onSubmit))
    if (onSuspend != null) __obj.updateDynamic("onSuspend")(js.Any.fromFunction1(onSuspend))
    if (onTimeUpdate != null) __obj.updateDynamic("onTimeUpdate")(js.Any.fromFunction1(onTimeUpdate))
    if (onTouchCancel != null) __obj.updateDynamic("onTouchCancel")(js.Any.fromFunction1(onTouchCancel))
    if (onTouchEnd != null) __obj.updateDynamic("onTouchEnd")(js.Any.fromFunction1(onTouchEnd))
    if (onTouchMove != null) __obj.updateDynamic("onTouchMove")(js.Any.fromFunction1(onTouchMove))
    if (onTouchStart != null) __obj.updateDynamic("onTouchStart")(js.Any.fromFunction1(onTouchStart))
    if (onTransitionEnd != null) __obj.updateDynamic("onTransitionEnd")(js.Any.fromFunction1(onTransitionEnd))
    if (onVolumeChange != null) __obj.updateDynamic("onVolumeChange")(js.Any.fromFunction1(onVolumeChange))
    if (onWaiting != null) __obj.updateDynamic("onWaiting")(js.Any.fromFunction1(onWaiting))
    if (onWheel != null) __obj.updateDynamic("onWheel")(js.Any.fromFunction1(onWheel))
    __obj.asInstanceOf[DOMAttributes[T]]
  }
  @scala.inline
  implicit class DOMAttributesOps[Self[t] <: DOMAttributes[t], T] (val x: Self[T]) extends AnyVal {
    @scala.inline
    def duplicate: Self[T] = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x)).asInstanceOf[Self[T]]
    @scala.inline
    def combineWith[Other /* <: js.Any */](other: Other): Self[T] with Other = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x, other.asInstanceOf[js.Any])).asInstanceOf[Self[T] with Other]
    @scala.inline
    def withChildren(children: ReactNode): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (children != null) ret.updateDynamic("children")(children.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withoutChildren: Self[T] = {
        val ret = this.duplicate
        js.special.delete(ret, "children")
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withDangerouslySetInnerHTML(dangerouslySetInnerHTML: AnonHtml): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (dangerouslySetInnerHTML != null) ret.updateDynamic("dangerouslySetInnerHTML")(dangerouslySetInnerHTML.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withoutDangerouslySetInnerHTML: Self[T] = {
        val ret = this.duplicate
        js.special.delete(ret, "dangerouslySetInnerHTML")
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withOnAbort(onAbort: SyntheticEvent[T, Event] => Unit): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (onAbort != null) ret.updateDynamic("onAbort")(js.Any.fromFunction1(onAbort))
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withoutOnAbort: Self[T] = {
        val ret = this.duplicate
        js.special.delete(ret, "onAbort")
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withOnAnimationEnd(onAnimationEnd: AnimationEvent[T] => Unit): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (onAnimationEnd != null) ret.updateDynamic("onAnimationEnd")(js.Any.fromFunction1(onAnimationEnd))
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withoutOnAnimationEnd: Self[T] = {
        val ret = this.duplicate
        js.special.delete(ret, "onAnimationEnd")
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withOnAnimationIteration(onAnimationIteration: AnimationEvent[T] => Unit): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (onAnimationIteration != null) ret.updateDynamic("onAnimationIteration")(js.Any.fromFunction1(onAnimationIteration))
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withoutOnAnimationIteration: Self[T] = {
        val ret = this.duplicate
        js.special.delete(ret, "onAnimationIteration")
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withOnAnimationStart(onAnimationStart: AnimationEvent[T] => Unit): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (onAnimationStart != null) ret.updateDynamic("onAnimationStart")(js.Any.fromFunction1(onAnimationStart))
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withoutOnAnimationStart: Self[T] = {
        val ret = this.duplicate
        js.special.delete(ret, "onAnimationStart")
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withOnAuxClick(onAuxClick: MouseEvent[T, NativeMouseEvent] => Unit): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (onAuxClick != null) ret.updateDynamic("onAuxClick")(js.Any.fromFunction1(onAuxClick))
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withoutOnAuxClick: Self[T] = {
        val ret = this.duplicate
        js.special.delete(ret, "onAuxClick")
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withOnBeforeInput(onBeforeInput: FormEvent[T] => Unit): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (onBeforeInput != null) ret.updateDynamic("onBeforeInput")(js.Any.fromFunction1(onBeforeInput))
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withoutOnBeforeInput: Self[T] = {
        val ret = this.duplicate
        js.special.delete(ret, "onBeforeInput")
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withOnBlur(onBlur: FocusEvent[T] => Unit): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (onBlur != null) ret.updateDynamic("onBlur")(js.Any.fromFunction1(onBlur))
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withoutOnBlur: Self[T] = {
        val ret = this.duplicate
        js.special.delete(ret, "onBlur")
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withOnCanPlay(onCanPlay: SyntheticEvent[T, Event] => Unit): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (onCanPlay != null) ret.updateDynamic("onCanPlay")(js.Any.fromFunction1(onCanPlay))
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withoutOnCanPlay: Self[T] = {
        val ret = this.duplicate
        js.special.delete(ret, "onCanPlay")
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withOnCanPlayThrough(onCanPlayThrough: SyntheticEvent[T, Event] => Unit): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (onCanPlayThrough != null) ret.updateDynamic("onCanPlayThrough")(js.Any.fromFunction1(onCanPlayThrough))
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withoutOnCanPlayThrough: Self[T] = {
        val ret = this.duplicate
        js.special.delete(ret, "onCanPlayThrough")
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withOnChange(onChange: FormEvent[T] => Unit): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (onChange != null) ret.updateDynamic("onChange")(js.Any.fromFunction1(onChange))
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withoutOnChange: Self[T] = {
        val ret = this.duplicate
        js.special.delete(ret, "onChange")
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withOnClick(onClick: MouseEvent[T, NativeMouseEvent] => Unit): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (onClick != null) ret.updateDynamic("onClick")(js.Any.fromFunction1(onClick))
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withoutOnClick: Self[T] = {
        val ret = this.duplicate
        js.special.delete(ret, "onClick")
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withOnCompositionEnd(onCompositionEnd: CompositionEvent[T] => Unit): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (onCompositionEnd != null) ret.updateDynamic("onCompositionEnd")(js.Any.fromFunction1(onCompositionEnd))
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withoutOnCompositionEnd: Self[T] = {
        val ret = this.duplicate
        js.special.delete(ret, "onCompositionEnd")
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withOnCompositionStart(onCompositionStart: CompositionEvent[T] => Unit): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (onCompositionStart != null) ret.updateDynamic("onCompositionStart")(js.Any.fromFunction1(onCompositionStart))
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withoutOnCompositionStart: Self[T] = {
        val ret = this.duplicate
        js.special.delete(ret, "onCompositionStart")
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withOnCompositionUpdate(onCompositionUpdate: CompositionEvent[T] => Unit): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (onCompositionUpdate != null) ret.updateDynamic("onCompositionUpdate")(js.Any.fromFunction1(onCompositionUpdate))
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withoutOnCompositionUpdate: Self[T] = {
        val ret = this.duplicate
        js.special.delete(ret, "onCompositionUpdate")
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withOnContextMenu(onContextMenu: MouseEvent[T, NativeMouseEvent] => Unit): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (onContextMenu != null) ret.updateDynamic("onContextMenu")(js.Any.fromFunction1(onContextMenu))
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withoutOnContextMenu: Self[T] = {
        val ret = this.duplicate
        js.special.delete(ret, "onContextMenu")
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withOnCopy(onCopy: ClipboardEvent[T] => Unit): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (onCopy != null) ret.updateDynamic("onCopy")(js.Any.fromFunction1(onCopy))
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withoutOnCopy: Self[T] = {
        val ret = this.duplicate
        js.special.delete(ret, "onCopy")
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withOnCut(onCut: ClipboardEvent[T] => Unit): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (onCut != null) ret.updateDynamic("onCut")(js.Any.fromFunction1(onCut))
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withoutOnCut: Self[T] = {
        val ret = this.duplicate
        js.special.delete(ret, "onCut")
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withOnDoubleClick(onDoubleClick: MouseEvent[T, NativeMouseEvent] => Unit): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (onDoubleClick != null) ret.updateDynamic("onDoubleClick")(js.Any.fromFunction1(onDoubleClick))
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withoutOnDoubleClick: Self[T] = {
        val ret = this.duplicate
        js.special.delete(ret, "onDoubleClick")
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withOnDrag(onDrag: DragEvent[T] => Unit): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (onDrag != null) ret.updateDynamic("onDrag")(js.Any.fromFunction1(onDrag))
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withoutOnDrag: Self[T] = {
        val ret = this.duplicate
        js.special.delete(ret, "onDrag")
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withOnDragEnd(onDragEnd: DragEvent[T] => Unit): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (onDragEnd != null) ret.updateDynamic("onDragEnd")(js.Any.fromFunction1(onDragEnd))
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withoutOnDragEnd: Self[T] = {
        val ret = this.duplicate
        js.special.delete(ret, "onDragEnd")
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withOnDragEnter(onDragEnter: DragEvent[T] => Unit): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (onDragEnter != null) ret.updateDynamic("onDragEnter")(js.Any.fromFunction1(onDragEnter))
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withoutOnDragEnter: Self[T] = {
        val ret = this.duplicate
        js.special.delete(ret, "onDragEnter")
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withOnDragExit(onDragExit: DragEvent[T] => Unit): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (onDragExit != null) ret.updateDynamic("onDragExit")(js.Any.fromFunction1(onDragExit))
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withoutOnDragExit: Self[T] = {
        val ret = this.duplicate
        js.special.delete(ret, "onDragExit")
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withOnDragLeave(onDragLeave: DragEvent[T] => Unit): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (onDragLeave != null) ret.updateDynamic("onDragLeave")(js.Any.fromFunction1(onDragLeave))
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withoutOnDragLeave: Self[T] = {
        val ret = this.duplicate
        js.special.delete(ret, "onDragLeave")
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withOnDragOver(onDragOver: DragEvent[T] => Unit): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (onDragOver != null) ret.updateDynamic("onDragOver")(js.Any.fromFunction1(onDragOver))
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withoutOnDragOver: Self[T] = {
        val ret = this.duplicate
        js.special.delete(ret, "onDragOver")
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withOnDragStart(onDragStart: DragEvent[T] => Unit): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (onDragStart != null) ret.updateDynamic("onDragStart")(js.Any.fromFunction1(onDragStart))
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withoutOnDragStart: Self[T] = {
        val ret = this.duplicate
        js.special.delete(ret, "onDragStart")
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withOnDrop(onDrop: DragEvent[T] => Unit): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (onDrop != null) ret.updateDynamic("onDrop")(js.Any.fromFunction1(onDrop))
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withoutOnDrop: Self[T] = {
        val ret = this.duplicate
        js.special.delete(ret, "onDrop")
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withOnDurationChange(onDurationChange: SyntheticEvent[T, Event] => Unit): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (onDurationChange != null) ret.updateDynamic("onDurationChange")(js.Any.fromFunction1(onDurationChange))
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withoutOnDurationChange: Self[T] = {
        val ret = this.duplicate
        js.special.delete(ret, "onDurationChange")
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withOnEmptied(onEmptied: SyntheticEvent[T, Event] => Unit): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (onEmptied != null) ret.updateDynamic("onEmptied")(js.Any.fromFunction1(onEmptied))
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withoutOnEmptied: Self[T] = {
        val ret = this.duplicate
        js.special.delete(ret, "onEmptied")
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withOnEncrypted(onEncrypted: SyntheticEvent[T, Event] => Unit): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (onEncrypted != null) ret.updateDynamic("onEncrypted")(js.Any.fromFunction1(onEncrypted))
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withoutOnEncrypted: Self[T] = {
        val ret = this.duplicate
        js.special.delete(ret, "onEncrypted")
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withOnEnded(onEnded: SyntheticEvent[T, Event] => Unit): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (onEnded != null) ret.updateDynamic("onEnded")(js.Any.fromFunction1(onEnded))
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withoutOnEnded: Self[T] = {
        val ret = this.duplicate
        js.special.delete(ret, "onEnded")
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withOnError(onError: SyntheticEvent[T, Event] => Unit): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (onError != null) ret.updateDynamic("onError")(js.Any.fromFunction1(onError))
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withoutOnError: Self[T] = {
        val ret = this.duplicate
        js.special.delete(ret, "onError")
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withOnFocus(onFocus: FocusEvent[T] => Unit): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (onFocus != null) ret.updateDynamic("onFocus")(js.Any.fromFunction1(onFocus))
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withoutOnFocus: Self[T] = {
        val ret = this.duplicate
        js.special.delete(ret, "onFocus")
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withOnInput(onInput: FormEvent[T] => Unit): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (onInput != null) ret.updateDynamic("onInput")(js.Any.fromFunction1(onInput))
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withoutOnInput: Self[T] = {
        val ret = this.duplicate
        js.special.delete(ret, "onInput")
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withOnInvalid(onInvalid: FormEvent[T] => Unit): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (onInvalid != null) ret.updateDynamic("onInvalid")(js.Any.fromFunction1(onInvalid))
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withoutOnInvalid: Self[T] = {
        val ret = this.duplicate
        js.special.delete(ret, "onInvalid")
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withOnKeyDown(onKeyDown: KeyboardEvent[T] => Unit): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (onKeyDown != null) ret.updateDynamic("onKeyDown")(js.Any.fromFunction1(onKeyDown))
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withoutOnKeyDown: Self[T] = {
        val ret = this.duplicate
        js.special.delete(ret, "onKeyDown")
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withOnKeyPress(onKeyPress: KeyboardEvent[T] => Unit): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (onKeyPress != null) ret.updateDynamic("onKeyPress")(js.Any.fromFunction1(onKeyPress))
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withoutOnKeyPress: Self[T] = {
        val ret = this.duplicate
        js.special.delete(ret, "onKeyPress")
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withOnKeyUp(onKeyUp: KeyboardEvent[T] => Unit): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (onKeyUp != null) ret.updateDynamic("onKeyUp")(js.Any.fromFunction1(onKeyUp))
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withoutOnKeyUp: Self[T] = {
        val ret = this.duplicate
        js.special.delete(ret, "onKeyUp")
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withOnLoad(onLoad: SyntheticEvent[T, Event] => Unit): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (onLoad != null) ret.updateDynamic("onLoad")(js.Any.fromFunction1(onLoad))
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withoutOnLoad: Self[T] = {
        val ret = this.duplicate
        js.special.delete(ret, "onLoad")
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withOnLoadStart(onLoadStart: SyntheticEvent[T, Event] => Unit): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (onLoadStart != null) ret.updateDynamic("onLoadStart")(js.Any.fromFunction1(onLoadStart))
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withoutOnLoadStart: Self[T] = {
        val ret = this.duplicate
        js.special.delete(ret, "onLoadStart")
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withOnLoadedData(onLoadedData: SyntheticEvent[T, Event] => Unit): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (onLoadedData != null) ret.updateDynamic("onLoadedData")(js.Any.fromFunction1(onLoadedData))
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withoutOnLoadedData: Self[T] = {
        val ret = this.duplicate
        js.special.delete(ret, "onLoadedData")
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withOnLoadedMetadata(onLoadedMetadata: SyntheticEvent[T, Event] => Unit): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (onLoadedMetadata != null) ret.updateDynamic("onLoadedMetadata")(js.Any.fromFunction1(onLoadedMetadata))
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withoutOnLoadedMetadata: Self[T] = {
        val ret = this.duplicate
        js.special.delete(ret, "onLoadedMetadata")
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withOnMouseDown(onMouseDown: MouseEvent[T, NativeMouseEvent] => Unit): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (onMouseDown != null) ret.updateDynamic("onMouseDown")(js.Any.fromFunction1(onMouseDown))
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withoutOnMouseDown: Self[T] = {
        val ret = this.duplicate
        js.special.delete(ret, "onMouseDown")
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withOnMouseEnter(onMouseEnter: MouseEvent[T, NativeMouseEvent] => Unit): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (onMouseEnter != null) ret.updateDynamic("onMouseEnter")(js.Any.fromFunction1(onMouseEnter))
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withoutOnMouseEnter: Self[T] = {
        val ret = this.duplicate
        js.special.delete(ret, "onMouseEnter")
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withOnMouseLeave(onMouseLeave: MouseEvent[T, NativeMouseEvent] => Unit): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (onMouseLeave != null) ret.updateDynamic("onMouseLeave")(js.Any.fromFunction1(onMouseLeave))
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withoutOnMouseLeave: Self[T] = {
        val ret = this.duplicate
        js.special.delete(ret, "onMouseLeave")
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withOnMouseMove(onMouseMove: MouseEvent[T, NativeMouseEvent] => Unit): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (onMouseMove != null) ret.updateDynamic("onMouseMove")(js.Any.fromFunction1(onMouseMove))
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withoutOnMouseMove: Self[T] = {
        val ret = this.duplicate
        js.special.delete(ret, "onMouseMove")
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withOnMouseOut(onMouseOut: MouseEvent[T, NativeMouseEvent] => Unit): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (onMouseOut != null) ret.updateDynamic("onMouseOut")(js.Any.fromFunction1(onMouseOut))
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withoutOnMouseOut: Self[T] = {
        val ret = this.duplicate
        js.special.delete(ret, "onMouseOut")
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withOnMouseOver(onMouseOver: MouseEvent[T, NativeMouseEvent] => Unit): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (onMouseOver != null) ret.updateDynamic("onMouseOver")(js.Any.fromFunction1(onMouseOver))
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withoutOnMouseOver: Self[T] = {
        val ret = this.duplicate
        js.special.delete(ret, "onMouseOver")
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withOnMouseUp(onMouseUp: MouseEvent[T, NativeMouseEvent] => Unit): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (onMouseUp != null) ret.updateDynamic("onMouseUp")(js.Any.fromFunction1(onMouseUp))
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withoutOnMouseUp: Self[T] = {
        val ret = this.duplicate
        js.special.delete(ret, "onMouseUp")
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withOnPaste(onPaste: ClipboardEvent[T] => Unit): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (onPaste != null) ret.updateDynamic("onPaste")(js.Any.fromFunction1(onPaste))
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withoutOnPaste: Self[T] = {
        val ret = this.duplicate
        js.special.delete(ret, "onPaste")
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withOnPause(onPause: SyntheticEvent[T, Event] => Unit): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (onPause != null) ret.updateDynamic("onPause")(js.Any.fromFunction1(onPause))
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withoutOnPause: Self[T] = {
        val ret = this.duplicate
        js.special.delete(ret, "onPause")
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withOnPlay(onPlay: SyntheticEvent[T, Event] => Unit): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (onPlay != null) ret.updateDynamic("onPlay")(js.Any.fromFunction1(onPlay))
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withoutOnPlay: Self[T] = {
        val ret = this.duplicate
        js.special.delete(ret, "onPlay")
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withOnPlaying(onPlaying: SyntheticEvent[T, Event] => Unit): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (onPlaying != null) ret.updateDynamic("onPlaying")(js.Any.fromFunction1(onPlaying))
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withoutOnPlaying: Self[T] = {
        val ret = this.duplicate
        js.special.delete(ret, "onPlaying")
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withOnPointerCancel(onPointerCancel: PointerEvent[T] => Unit): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (onPointerCancel != null) ret.updateDynamic("onPointerCancel")(js.Any.fromFunction1(onPointerCancel))
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withoutOnPointerCancel: Self[T] = {
        val ret = this.duplicate
        js.special.delete(ret, "onPointerCancel")
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withOnPointerDown(onPointerDown: PointerEvent[T] => Unit): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (onPointerDown != null) ret.updateDynamic("onPointerDown")(js.Any.fromFunction1(onPointerDown))
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withoutOnPointerDown: Self[T] = {
        val ret = this.duplicate
        js.special.delete(ret, "onPointerDown")
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withOnPointerEnter(onPointerEnter: PointerEvent[T] => Unit): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (onPointerEnter != null) ret.updateDynamic("onPointerEnter")(js.Any.fromFunction1(onPointerEnter))
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withoutOnPointerEnter: Self[T] = {
        val ret = this.duplicate
        js.special.delete(ret, "onPointerEnter")
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withOnPointerLeave(onPointerLeave: PointerEvent[T] => Unit): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (onPointerLeave != null) ret.updateDynamic("onPointerLeave")(js.Any.fromFunction1(onPointerLeave))
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withoutOnPointerLeave: Self[T] = {
        val ret = this.duplicate
        js.special.delete(ret, "onPointerLeave")
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withOnPointerMove(onPointerMove: PointerEvent[T] => Unit): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (onPointerMove != null) ret.updateDynamic("onPointerMove")(js.Any.fromFunction1(onPointerMove))
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withoutOnPointerMove: Self[T] = {
        val ret = this.duplicate
        js.special.delete(ret, "onPointerMove")
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withOnPointerOut(onPointerOut: PointerEvent[T] => Unit): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (onPointerOut != null) ret.updateDynamic("onPointerOut")(js.Any.fromFunction1(onPointerOut))
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withoutOnPointerOut: Self[T] = {
        val ret = this.duplicate
        js.special.delete(ret, "onPointerOut")
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withOnPointerOver(onPointerOver: PointerEvent[T] => Unit): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (onPointerOver != null) ret.updateDynamic("onPointerOver")(js.Any.fromFunction1(onPointerOver))
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withoutOnPointerOver: Self[T] = {
        val ret = this.duplicate
        js.special.delete(ret, "onPointerOver")
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withOnPointerUp(onPointerUp: PointerEvent[T] => Unit): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (onPointerUp != null) ret.updateDynamic("onPointerUp")(js.Any.fromFunction1(onPointerUp))
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withoutOnPointerUp: Self[T] = {
        val ret = this.duplicate
        js.special.delete(ret, "onPointerUp")
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withOnProgress(onProgress: SyntheticEvent[T, Event] => Unit): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (onProgress != null) ret.updateDynamic("onProgress")(js.Any.fromFunction1(onProgress))
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withoutOnProgress: Self[T] = {
        val ret = this.duplicate
        js.special.delete(ret, "onProgress")
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withOnRateChange(onRateChange: SyntheticEvent[T, Event] => Unit): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (onRateChange != null) ret.updateDynamic("onRateChange")(js.Any.fromFunction1(onRateChange))
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withoutOnRateChange: Self[T] = {
        val ret = this.duplicate
        js.special.delete(ret, "onRateChange")
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withOnReset(onReset: FormEvent[T] => Unit): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (onReset != null) ret.updateDynamic("onReset")(js.Any.fromFunction1(onReset))
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withoutOnReset: Self[T] = {
        val ret = this.duplicate
        js.special.delete(ret, "onReset")
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withOnScroll(onScroll: UIEvent[T] => Unit): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (onScroll != null) ret.updateDynamic("onScroll")(js.Any.fromFunction1(onScroll))
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withoutOnScroll: Self[T] = {
        val ret = this.duplicate
        js.special.delete(ret, "onScroll")
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withOnSeeked(onSeeked: SyntheticEvent[T, Event] => Unit): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (onSeeked != null) ret.updateDynamic("onSeeked")(js.Any.fromFunction1(onSeeked))
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withoutOnSeeked: Self[T] = {
        val ret = this.duplicate
        js.special.delete(ret, "onSeeked")
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withOnSeeking(onSeeking: SyntheticEvent[T, Event] => Unit): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (onSeeking != null) ret.updateDynamic("onSeeking")(js.Any.fromFunction1(onSeeking))
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withoutOnSeeking: Self[T] = {
        val ret = this.duplicate
        js.special.delete(ret, "onSeeking")
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withOnSelect(onSelect: SyntheticEvent[T, Event] => Unit): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (onSelect != null) ret.updateDynamic("onSelect")(js.Any.fromFunction1(onSelect))
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withoutOnSelect: Self[T] = {
        val ret = this.duplicate
        js.special.delete(ret, "onSelect")
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withOnStalled(onStalled: SyntheticEvent[T, Event] => Unit): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (onStalled != null) ret.updateDynamic("onStalled")(js.Any.fromFunction1(onStalled))
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withoutOnStalled: Self[T] = {
        val ret = this.duplicate
        js.special.delete(ret, "onStalled")
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withOnSubmit(onSubmit: FormEvent[T] => Unit): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (onSubmit != null) ret.updateDynamic("onSubmit")(js.Any.fromFunction1(onSubmit))
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withoutOnSubmit: Self[T] = {
        val ret = this.duplicate
        js.special.delete(ret, "onSubmit")
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withOnSuspend(onSuspend: SyntheticEvent[T, Event] => Unit): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (onSuspend != null) ret.updateDynamic("onSuspend")(js.Any.fromFunction1(onSuspend))
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withoutOnSuspend: Self[T] = {
        val ret = this.duplicate
        js.special.delete(ret, "onSuspend")
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withOnTimeUpdate(onTimeUpdate: SyntheticEvent[T, Event] => Unit): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (onTimeUpdate != null) ret.updateDynamic("onTimeUpdate")(js.Any.fromFunction1(onTimeUpdate))
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withoutOnTimeUpdate: Self[T] = {
        val ret = this.duplicate
        js.special.delete(ret, "onTimeUpdate")
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withOnTouchCancel(onTouchCancel: TouchEvent[T] => Unit): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (onTouchCancel != null) ret.updateDynamic("onTouchCancel")(js.Any.fromFunction1(onTouchCancel))
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withoutOnTouchCancel: Self[T] = {
        val ret = this.duplicate
        js.special.delete(ret, "onTouchCancel")
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withOnTouchEnd(onTouchEnd: TouchEvent[T] => Unit): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (onTouchEnd != null) ret.updateDynamic("onTouchEnd")(js.Any.fromFunction1(onTouchEnd))
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withoutOnTouchEnd: Self[T] = {
        val ret = this.duplicate
        js.special.delete(ret, "onTouchEnd")
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withOnTouchMove(onTouchMove: TouchEvent[T] => Unit): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (onTouchMove != null) ret.updateDynamic("onTouchMove")(js.Any.fromFunction1(onTouchMove))
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withoutOnTouchMove: Self[T] = {
        val ret = this.duplicate
        js.special.delete(ret, "onTouchMove")
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withOnTouchStart(onTouchStart: TouchEvent[T] => Unit): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (onTouchStart != null) ret.updateDynamic("onTouchStart")(js.Any.fromFunction1(onTouchStart))
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withoutOnTouchStart: Self[T] = {
        val ret = this.duplicate
        js.special.delete(ret, "onTouchStart")
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withOnTransitionEnd(onTransitionEnd: TransitionEvent[T] => Unit): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (onTransitionEnd != null) ret.updateDynamic("onTransitionEnd")(js.Any.fromFunction1(onTransitionEnd))
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withoutOnTransitionEnd: Self[T] = {
        val ret = this.duplicate
        js.special.delete(ret, "onTransitionEnd")
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withOnVolumeChange(onVolumeChange: SyntheticEvent[T, Event] => Unit): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (onVolumeChange != null) ret.updateDynamic("onVolumeChange")(js.Any.fromFunction1(onVolumeChange))
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withoutOnVolumeChange: Self[T] = {
        val ret = this.duplicate
        js.special.delete(ret, "onVolumeChange")
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withOnWaiting(onWaiting: SyntheticEvent[T, Event] => Unit): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (onWaiting != null) ret.updateDynamic("onWaiting")(js.Any.fromFunction1(onWaiting))
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withoutOnWaiting: Self[T] = {
        val ret = this.duplicate
        js.special.delete(ret, "onWaiting")
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withOnWheel(onWheel: WheelEvent[T] => Unit): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (onWheel != null) ret.updateDynamic("onWheel")(js.Any.fromFunction1(onWheel))
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withoutOnWheel: Self[T] = {
        val ret = this.duplicate
        js.special.delete(ret, "onWheel")
        ret.asInstanceOf[Self[T]]
    }
  }
  
}

