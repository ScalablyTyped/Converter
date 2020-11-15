package typingsJapgolly.react.mod

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
import japgolly.scalajs.react.vdom.VdomElement
import japgolly.scalajs.react.vdom.VdomNode
import org.scalajs.dom.raw.Element
import typingsJapgolly.react.anon.Html
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

@js.native
trait DOMAttributes[T] extends js.Object {
  
  var children: js.UndefOr[Node] = js.native
  
  var dangerouslySetInnerHTML: js.UndefOr[Html] = js.native
  
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
  def apply[T](): DOMAttributes[T] = {
    val __obj = js.Dynamic.literal()
    __obj.asInstanceOf[DOMAttributes[T]]
  }
  
  @scala.inline
  implicit class DOMAttributesOps[Self <: DOMAttributes[_], T] (val x: Self with DOMAttributes[T]) extends AnyVal {
    
    @scala.inline
    def duplicate: Self = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x)).asInstanceOf[Self]
    
    @scala.inline
    def combineWith[Other <: js.Any](other: Other): Self with Other = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x, other.asInstanceOf[js.Any])).asInstanceOf[Self with Other]
    
    @scala.inline
    def set(key: String, value: js.Any): Self = {
      x.asInstanceOf[js.Dynamic].updateDynamic(key)(value)
      x
    }
    
    @scala.inline
    def setChildrenVdomElement(value: VdomElement): Self = this.set("children", value.rawElement.asInstanceOf[js.Any])
    
    @scala.inline
    def setChildren(value: VdomNode): Self = this.set("children", value.rawNode.asInstanceOf[js.Any])
    
    @scala.inline
    def deleteChildren: Self = this.set("children", js.undefined)
    
    @scala.inline
    def setDangerouslySetInnerHTML(value: Html): Self = this.set("dangerouslySetInnerHTML", value.asInstanceOf[js.Any])
    
    @scala.inline
    def deleteDangerouslySetInnerHTML: Self = this.set("dangerouslySetInnerHTML", js.undefined)
    
    @scala.inline
    def setOnAbort(value: ReactEventFrom[T with Element] => Callback): Self = this.set("onAbort", js.Any.fromFunction1((t0: ReactEventFrom[T with Element]) => value(t0).runNow()))
    
    @scala.inline
    def deleteOnAbort: Self = this.set("onAbort", js.undefined)
    
    @scala.inline
    def setOnAnimationEnd(value: ReactAnimationEventFrom[T with Element] => Callback): Self = this.set("onAnimationEnd", js.Any.fromFunction1((t0: ReactAnimationEventFrom[T with Element]) => value(t0).runNow()))
    
    @scala.inline
    def deleteOnAnimationEnd: Self = this.set("onAnimationEnd", js.undefined)
    
    @scala.inline
    def setOnAnimationIteration(value: ReactAnimationEventFrom[T with Element] => Callback): Self = this.set("onAnimationIteration", js.Any.fromFunction1((t0: ReactAnimationEventFrom[T with Element]) => value(t0).runNow()))
    
    @scala.inline
    def deleteOnAnimationIteration: Self = this.set("onAnimationIteration", js.undefined)
    
    @scala.inline
    def setOnAnimationStart(value: ReactAnimationEventFrom[T with Element] => Callback): Self = this.set("onAnimationStart", js.Any.fromFunction1((t0: ReactAnimationEventFrom[T with Element]) => value(t0).runNow()))
    
    @scala.inline
    def deleteOnAnimationStart: Self = this.set("onAnimationStart", js.undefined)
    
    @scala.inline
    def setOnAuxClick(value: ReactMouseEventFrom[T with Element] => Callback): Self = this.set("onAuxClick", js.Any.fromFunction1((t0: ReactMouseEventFrom[T with Element]) => value(t0).runNow()))
    
    @scala.inline
    def deleteOnAuxClick: Self = this.set("onAuxClick", js.undefined)
    
    @scala.inline
    def setOnBeforeInput(value: ReactEventFrom[T with Element] => Callback): Self = this.set("onBeforeInput", js.Any.fromFunction1((t0: ReactEventFrom[T with Element]) => value(t0).runNow()))
    
    @scala.inline
    def deleteOnBeforeInput: Self = this.set("onBeforeInput", js.undefined)
    
    @scala.inline
    def setOnBlur(value: ReactFocusEventFrom[T with Element] => Callback): Self = this.set("onBlur", js.Any.fromFunction1((t0: ReactFocusEventFrom[T with Element]) => value(t0).runNow()))
    
    @scala.inline
    def deleteOnBlur: Self = this.set("onBlur", js.undefined)
    
    @scala.inline
    def setOnCanPlay(value: ReactEventFrom[T with Element] => Callback): Self = this.set("onCanPlay", js.Any.fromFunction1((t0: ReactEventFrom[T with Element]) => value(t0).runNow()))
    
    @scala.inline
    def deleteOnCanPlay: Self = this.set("onCanPlay", js.undefined)
    
    @scala.inline
    def setOnCanPlayThrough(value: ReactEventFrom[T with Element] => Callback): Self = this.set("onCanPlayThrough", js.Any.fromFunction1((t0: ReactEventFrom[T with Element]) => value(t0).runNow()))
    
    @scala.inline
    def deleteOnCanPlayThrough: Self = this.set("onCanPlayThrough", js.undefined)
    
    @scala.inline
    def setOnChange(value: ReactEventFrom[T with Element] => Callback): Self = this.set("onChange", js.Any.fromFunction1((t0: ReactEventFrom[T with Element]) => value(t0).runNow()))
    
    @scala.inline
    def deleteOnChange: Self = this.set("onChange", js.undefined)
    
    @scala.inline
    def setOnClick(value: ReactMouseEventFrom[T with Element] => Callback): Self = this.set("onClick", js.Any.fromFunction1((t0: ReactMouseEventFrom[T with Element]) => value(t0).runNow()))
    
    @scala.inline
    def deleteOnClick: Self = this.set("onClick", js.undefined)
    
    @scala.inline
    def setOnCompositionEnd(value: ReactCompositionEventFrom[T with Element] => Callback): Self = this.set("onCompositionEnd", js.Any.fromFunction1((t0: ReactCompositionEventFrom[T with Element]) => value(t0).runNow()))
    
    @scala.inline
    def deleteOnCompositionEnd: Self = this.set("onCompositionEnd", js.undefined)
    
    @scala.inline
    def setOnCompositionStart(value: ReactCompositionEventFrom[T with Element] => Callback): Self = this.set("onCompositionStart", js.Any.fromFunction1((t0: ReactCompositionEventFrom[T with Element]) => value(t0).runNow()))
    
    @scala.inline
    def deleteOnCompositionStart: Self = this.set("onCompositionStart", js.undefined)
    
    @scala.inline
    def setOnCompositionUpdate(value: ReactCompositionEventFrom[T with Element] => Callback): Self = this.set("onCompositionUpdate", js.Any.fromFunction1((t0: ReactCompositionEventFrom[T with Element]) => value(t0).runNow()))
    
    @scala.inline
    def deleteOnCompositionUpdate: Self = this.set("onCompositionUpdate", js.undefined)
    
    @scala.inline
    def setOnContextMenu(value: ReactMouseEventFrom[T with Element] => Callback): Self = this.set("onContextMenu", js.Any.fromFunction1((t0: ReactMouseEventFrom[T with Element]) => value(t0).runNow()))
    
    @scala.inline
    def deleteOnContextMenu: Self = this.set("onContextMenu", js.undefined)
    
    @scala.inline
    def setOnCopy(value: ReactClipboardEventFrom[T with Element] => Callback): Self = this.set("onCopy", js.Any.fromFunction1((t0: ReactClipboardEventFrom[T with Element]) => value(t0).runNow()))
    
    @scala.inline
    def deleteOnCopy: Self = this.set("onCopy", js.undefined)
    
    @scala.inline
    def setOnCut(value: ReactClipboardEventFrom[T with Element] => Callback): Self = this.set("onCut", js.Any.fromFunction1((t0: ReactClipboardEventFrom[T with Element]) => value(t0).runNow()))
    
    @scala.inline
    def deleteOnCut: Self = this.set("onCut", js.undefined)
    
    @scala.inline
    def setOnDoubleClick(value: ReactMouseEventFrom[T with Element] => Callback): Self = this.set("onDoubleClick", js.Any.fromFunction1((t0: ReactMouseEventFrom[T with Element]) => value(t0).runNow()))
    
    @scala.inline
    def deleteOnDoubleClick: Self = this.set("onDoubleClick", js.undefined)
    
    @scala.inline
    def setOnDrag(value: ReactDragEventFrom[T with Element] => Callback): Self = this.set("onDrag", js.Any.fromFunction1((t0: ReactDragEventFrom[T with Element]) => value(t0).runNow()))
    
    @scala.inline
    def deleteOnDrag: Self = this.set("onDrag", js.undefined)
    
    @scala.inline
    def setOnDragEnd(value: ReactDragEventFrom[T with Element] => Callback): Self = this.set("onDragEnd", js.Any.fromFunction1((t0: ReactDragEventFrom[T with Element]) => value(t0).runNow()))
    
    @scala.inline
    def deleteOnDragEnd: Self = this.set("onDragEnd", js.undefined)
    
    @scala.inline
    def setOnDragEnter(value: ReactDragEventFrom[T with Element] => Callback): Self = this.set("onDragEnter", js.Any.fromFunction1((t0: ReactDragEventFrom[T with Element]) => value(t0).runNow()))
    
    @scala.inline
    def deleteOnDragEnter: Self = this.set("onDragEnter", js.undefined)
    
    @scala.inline
    def setOnDragExit(value: ReactDragEventFrom[T with Element] => Callback): Self = this.set("onDragExit", js.Any.fromFunction1((t0: ReactDragEventFrom[T with Element]) => value(t0).runNow()))
    
    @scala.inline
    def deleteOnDragExit: Self = this.set("onDragExit", js.undefined)
    
    @scala.inline
    def setOnDragLeave(value: ReactDragEventFrom[T with Element] => Callback): Self = this.set("onDragLeave", js.Any.fromFunction1((t0: ReactDragEventFrom[T with Element]) => value(t0).runNow()))
    
    @scala.inline
    def deleteOnDragLeave: Self = this.set("onDragLeave", js.undefined)
    
    @scala.inline
    def setOnDragOver(value: ReactDragEventFrom[T with Element] => Callback): Self = this.set("onDragOver", js.Any.fromFunction1((t0: ReactDragEventFrom[T with Element]) => value(t0).runNow()))
    
    @scala.inline
    def deleteOnDragOver: Self = this.set("onDragOver", js.undefined)
    
    @scala.inline
    def setOnDragStart(value: ReactDragEventFrom[T with Element] => Callback): Self = this.set("onDragStart", js.Any.fromFunction1((t0: ReactDragEventFrom[T with Element]) => value(t0).runNow()))
    
    @scala.inline
    def deleteOnDragStart: Self = this.set("onDragStart", js.undefined)
    
    @scala.inline
    def setOnDrop(value: ReactDragEventFrom[T with Element] => Callback): Self = this.set("onDrop", js.Any.fromFunction1((t0: ReactDragEventFrom[T with Element]) => value(t0).runNow()))
    
    @scala.inline
    def deleteOnDrop: Self = this.set("onDrop", js.undefined)
    
    @scala.inline
    def setOnDurationChange(value: ReactEventFrom[T with Element] => Callback): Self = this.set("onDurationChange", js.Any.fromFunction1((t0: ReactEventFrom[T with Element]) => value(t0).runNow()))
    
    @scala.inline
    def deleteOnDurationChange: Self = this.set("onDurationChange", js.undefined)
    
    @scala.inline
    def setOnEmptied(value: ReactEventFrom[T with Element] => Callback): Self = this.set("onEmptied", js.Any.fromFunction1((t0: ReactEventFrom[T with Element]) => value(t0).runNow()))
    
    @scala.inline
    def deleteOnEmptied: Self = this.set("onEmptied", js.undefined)
    
    @scala.inline
    def setOnEncrypted(value: ReactEventFrom[T with Element] => Callback): Self = this.set("onEncrypted", js.Any.fromFunction1((t0: ReactEventFrom[T with Element]) => value(t0).runNow()))
    
    @scala.inline
    def deleteOnEncrypted: Self = this.set("onEncrypted", js.undefined)
    
    @scala.inline
    def setOnEnded(value: ReactEventFrom[T with Element] => Callback): Self = this.set("onEnded", js.Any.fromFunction1((t0: ReactEventFrom[T with Element]) => value(t0).runNow()))
    
    @scala.inline
    def deleteOnEnded: Self = this.set("onEnded", js.undefined)
    
    @scala.inline
    def setOnError(value: ReactEventFrom[T with Element] => Callback): Self = this.set("onError", js.Any.fromFunction1((t0: ReactEventFrom[T with Element]) => value(t0).runNow()))
    
    @scala.inline
    def deleteOnError: Self = this.set("onError", js.undefined)
    
    @scala.inline
    def setOnFocus(value: ReactFocusEventFrom[T with Element] => Callback): Self = this.set("onFocus", js.Any.fromFunction1((t0: ReactFocusEventFrom[T with Element]) => value(t0).runNow()))
    
    @scala.inline
    def deleteOnFocus: Self = this.set("onFocus", js.undefined)
    
    @scala.inline
    def setOnInput(value: ReactEventFrom[T with Element] => Callback): Self = this.set("onInput", js.Any.fromFunction1((t0: ReactEventFrom[T with Element]) => value(t0).runNow()))
    
    @scala.inline
    def deleteOnInput: Self = this.set("onInput", js.undefined)
    
    @scala.inline
    def setOnInvalid(value: ReactEventFrom[T with Element] => Callback): Self = this.set("onInvalid", js.Any.fromFunction1((t0: ReactEventFrom[T with Element]) => value(t0).runNow()))
    
    @scala.inline
    def deleteOnInvalid: Self = this.set("onInvalid", js.undefined)
    
    @scala.inline
    def setOnKeyDown(value: ReactKeyboardEventFrom[T with Element] => Callback): Self = this.set("onKeyDown", js.Any.fromFunction1((t0: ReactKeyboardEventFrom[T with Element]) => value(t0).runNow()))
    
    @scala.inline
    def deleteOnKeyDown: Self = this.set("onKeyDown", js.undefined)
    
    @scala.inline
    def setOnKeyPress(value: ReactKeyboardEventFrom[T with Element] => Callback): Self = this.set("onKeyPress", js.Any.fromFunction1((t0: ReactKeyboardEventFrom[T with Element]) => value(t0).runNow()))
    
    @scala.inline
    def deleteOnKeyPress: Self = this.set("onKeyPress", js.undefined)
    
    @scala.inline
    def setOnKeyUp(value: ReactKeyboardEventFrom[T with Element] => Callback): Self = this.set("onKeyUp", js.Any.fromFunction1((t0: ReactKeyboardEventFrom[T with Element]) => value(t0).runNow()))
    
    @scala.inline
    def deleteOnKeyUp: Self = this.set("onKeyUp", js.undefined)
    
    @scala.inline
    def setOnLoad(value: ReactEventFrom[T with Element] => Callback): Self = this.set("onLoad", js.Any.fromFunction1((t0: ReactEventFrom[T with Element]) => value(t0).runNow()))
    
    @scala.inline
    def deleteOnLoad: Self = this.set("onLoad", js.undefined)
    
    @scala.inline
    def setOnLoadStart(value: ReactEventFrom[T with Element] => Callback): Self = this.set("onLoadStart", js.Any.fromFunction1((t0: ReactEventFrom[T with Element]) => value(t0).runNow()))
    
    @scala.inline
    def deleteOnLoadStart: Self = this.set("onLoadStart", js.undefined)
    
    @scala.inline
    def setOnLoadedData(value: ReactEventFrom[T with Element] => Callback): Self = this.set("onLoadedData", js.Any.fromFunction1((t0: ReactEventFrom[T with Element]) => value(t0).runNow()))
    
    @scala.inline
    def deleteOnLoadedData: Self = this.set("onLoadedData", js.undefined)
    
    @scala.inline
    def setOnLoadedMetadata(value: ReactEventFrom[T with Element] => Callback): Self = this.set("onLoadedMetadata", js.Any.fromFunction1((t0: ReactEventFrom[T with Element]) => value(t0).runNow()))
    
    @scala.inline
    def deleteOnLoadedMetadata: Self = this.set("onLoadedMetadata", js.undefined)
    
    @scala.inline
    def setOnMouseDown(value: ReactMouseEventFrom[T with Element] => Callback): Self = this.set("onMouseDown", js.Any.fromFunction1((t0: ReactMouseEventFrom[T with Element]) => value(t0).runNow()))
    
    @scala.inline
    def deleteOnMouseDown: Self = this.set("onMouseDown", js.undefined)
    
    @scala.inline
    def setOnMouseEnter(value: ReactMouseEventFrom[T with Element] => Callback): Self = this.set("onMouseEnter", js.Any.fromFunction1((t0: ReactMouseEventFrom[T with Element]) => value(t0).runNow()))
    
    @scala.inline
    def deleteOnMouseEnter: Self = this.set("onMouseEnter", js.undefined)
    
    @scala.inline
    def setOnMouseLeave(value: ReactMouseEventFrom[T with Element] => Callback): Self = this.set("onMouseLeave", js.Any.fromFunction1((t0: ReactMouseEventFrom[T with Element]) => value(t0).runNow()))
    
    @scala.inline
    def deleteOnMouseLeave: Self = this.set("onMouseLeave", js.undefined)
    
    @scala.inline
    def setOnMouseMove(value: ReactMouseEventFrom[T with Element] => Callback): Self = this.set("onMouseMove", js.Any.fromFunction1((t0: ReactMouseEventFrom[T with Element]) => value(t0).runNow()))
    
    @scala.inline
    def deleteOnMouseMove: Self = this.set("onMouseMove", js.undefined)
    
    @scala.inline
    def setOnMouseOut(value: ReactMouseEventFrom[T with Element] => Callback): Self = this.set("onMouseOut", js.Any.fromFunction1((t0: ReactMouseEventFrom[T with Element]) => value(t0).runNow()))
    
    @scala.inline
    def deleteOnMouseOut: Self = this.set("onMouseOut", js.undefined)
    
    @scala.inline
    def setOnMouseOver(value: ReactMouseEventFrom[T with Element] => Callback): Self = this.set("onMouseOver", js.Any.fromFunction1((t0: ReactMouseEventFrom[T with Element]) => value(t0).runNow()))
    
    @scala.inline
    def deleteOnMouseOver: Self = this.set("onMouseOver", js.undefined)
    
    @scala.inline
    def setOnMouseUp(value: ReactMouseEventFrom[T with Element] => Callback): Self = this.set("onMouseUp", js.Any.fromFunction1((t0: ReactMouseEventFrom[T with Element]) => value(t0).runNow()))
    
    @scala.inline
    def deleteOnMouseUp: Self = this.set("onMouseUp", js.undefined)
    
    @scala.inline
    def setOnPaste(value: ReactClipboardEventFrom[T with Element] => Callback): Self = this.set("onPaste", js.Any.fromFunction1((t0: ReactClipboardEventFrom[T with Element]) => value(t0).runNow()))
    
    @scala.inline
    def deleteOnPaste: Self = this.set("onPaste", js.undefined)
    
    @scala.inline
    def setOnPause(value: ReactEventFrom[T with Element] => Callback): Self = this.set("onPause", js.Any.fromFunction1((t0: ReactEventFrom[T with Element]) => value(t0).runNow()))
    
    @scala.inline
    def deleteOnPause: Self = this.set("onPause", js.undefined)
    
    @scala.inline
    def setOnPlay(value: ReactEventFrom[T with Element] => Callback): Self = this.set("onPlay", js.Any.fromFunction1((t0: ReactEventFrom[T with Element]) => value(t0).runNow()))
    
    @scala.inline
    def deleteOnPlay: Self = this.set("onPlay", js.undefined)
    
    @scala.inline
    def setOnPlaying(value: ReactEventFrom[T with Element] => Callback): Self = this.set("onPlaying", js.Any.fromFunction1((t0: ReactEventFrom[T with Element]) => value(t0).runNow()))
    
    @scala.inline
    def deleteOnPlaying: Self = this.set("onPlaying", js.undefined)
    
    @scala.inline
    def setOnPointerCancel(value: ReactPointerEventFrom[T with Element] => Callback): Self = this.set("onPointerCancel", js.Any.fromFunction1((t0: ReactPointerEventFrom[T with Element]) => value(t0).runNow()))
    
    @scala.inline
    def deleteOnPointerCancel: Self = this.set("onPointerCancel", js.undefined)
    
    @scala.inline
    def setOnPointerDown(value: ReactPointerEventFrom[T with Element] => Callback): Self = this.set("onPointerDown", js.Any.fromFunction1((t0: ReactPointerEventFrom[T with Element]) => value(t0).runNow()))
    
    @scala.inline
    def deleteOnPointerDown: Self = this.set("onPointerDown", js.undefined)
    
    @scala.inline
    def setOnPointerEnter(value: ReactPointerEventFrom[T with Element] => Callback): Self = this.set("onPointerEnter", js.Any.fromFunction1((t0: ReactPointerEventFrom[T with Element]) => value(t0).runNow()))
    
    @scala.inline
    def deleteOnPointerEnter: Self = this.set("onPointerEnter", js.undefined)
    
    @scala.inline
    def setOnPointerLeave(value: ReactPointerEventFrom[T with Element] => Callback): Self = this.set("onPointerLeave", js.Any.fromFunction1((t0: ReactPointerEventFrom[T with Element]) => value(t0).runNow()))
    
    @scala.inline
    def deleteOnPointerLeave: Self = this.set("onPointerLeave", js.undefined)
    
    @scala.inline
    def setOnPointerMove(value: ReactPointerEventFrom[T with Element] => Callback): Self = this.set("onPointerMove", js.Any.fromFunction1((t0: ReactPointerEventFrom[T with Element]) => value(t0).runNow()))
    
    @scala.inline
    def deleteOnPointerMove: Self = this.set("onPointerMove", js.undefined)
    
    @scala.inline
    def setOnPointerOut(value: ReactPointerEventFrom[T with Element] => Callback): Self = this.set("onPointerOut", js.Any.fromFunction1((t0: ReactPointerEventFrom[T with Element]) => value(t0).runNow()))
    
    @scala.inline
    def deleteOnPointerOut: Self = this.set("onPointerOut", js.undefined)
    
    @scala.inline
    def setOnPointerOver(value: ReactPointerEventFrom[T with Element] => Callback): Self = this.set("onPointerOver", js.Any.fromFunction1((t0: ReactPointerEventFrom[T with Element]) => value(t0).runNow()))
    
    @scala.inline
    def deleteOnPointerOver: Self = this.set("onPointerOver", js.undefined)
    
    @scala.inline
    def setOnPointerUp(value: ReactPointerEventFrom[T with Element] => Callback): Self = this.set("onPointerUp", js.Any.fromFunction1((t0: ReactPointerEventFrom[T with Element]) => value(t0).runNow()))
    
    @scala.inline
    def deleteOnPointerUp: Self = this.set("onPointerUp", js.undefined)
    
    @scala.inline
    def setOnProgress(value: ReactEventFrom[T with Element] => Callback): Self = this.set("onProgress", js.Any.fromFunction1((t0: ReactEventFrom[T with Element]) => value(t0).runNow()))
    
    @scala.inline
    def deleteOnProgress: Self = this.set("onProgress", js.undefined)
    
    @scala.inline
    def setOnRateChange(value: ReactEventFrom[T with Element] => Callback): Self = this.set("onRateChange", js.Any.fromFunction1((t0: ReactEventFrom[T with Element]) => value(t0).runNow()))
    
    @scala.inline
    def deleteOnRateChange: Self = this.set("onRateChange", js.undefined)
    
    @scala.inline
    def setOnReset(value: ReactEventFrom[T with Element] => Callback): Self = this.set("onReset", js.Any.fromFunction1((t0: ReactEventFrom[T with Element]) => value(t0).runNow()))
    
    @scala.inline
    def deleteOnReset: Self = this.set("onReset", js.undefined)
    
    @scala.inline
    def setOnScroll(value: ReactUIEventFrom[T with Element] => Callback): Self = this.set("onScroll", js.Any.fromFunction1((t0: ReactUIEventFrom[T with Element]) => value(t0).runNow()))
    
    @scala.inline
    def deleteOnScroll: Self = this.set("onScroll", js.undefined)
    
    @scala.inline
    def setOnSeeked(value: ReactEventFrom[T with Element] => Callback): Self = this.set("onSeeked", js.Any.fromFunction1((t0: ReactEventFrom[T with Element]) => value(t0).runNow()))
    
    @scala.inline
    def deleteOnSeeked: Self = this.set("onSeeked", js.undefined)
    
    @scala.inline
    def setOnSeeking(value: ReactEventFrom[T with Element] => Callback): Self = this.set("onSeeking", js.Any.fromFunction1((t0: ReactEventFrom[T with Element]) => value(t0).runNow()))
    
    @scala.inline
    def deleteOnSeeking: Self = this.set("onSeeking", js.undefined)
    
    @scala.inline
    def setOnSelect(value: ReactEventFrom[T with Element] => Callback): Self = this.set("onSelect", js.Any.fromFunction1((t0: ReactEventFrom[T with Element]) => value(t0).runNow()))
    
    @scala.inline
    def deleteOnSelect: Self = this.set("onSelect", js.undefined)
    
    @scala.inline
    def setOnStalled(value: ReactEventFrom[T with Element] => Callback): Self = this.set("onStalled", js.Any.fromFunction1((t0: ReactEventFrom[T with Element]) => value(t0).runNow()))
    
    @scala.inline
    def deleteOnStalled: Self = this.set("onStalled", js.undefined)
    
    @scala.inline
    def setOnSubmit(value: ReactEventFrom[T with Element] => Callback): Self = this.set("onSubmit", js.Any.fromFunction1((t0: ReactEventFrom[T with Element]) => value(t0).runNow()))
    
    @scala.inline
    def deleteOnSubmit: Self = this.set("onSubmit", js.undefined)
    
    @scala.inline
    def setOnSuspend(value: ReactEventFrom[T with Element] => Callback): Self = this.set("onSuspend", js.Any.fromFunction1((t0: ReactEventFrom[T with Element]) => value(t0).runNow()))
    
    @scala.inline
    def deleteOnSuspend: Self = this.set("onSuspend", js.undefined)
    
    @scala.inline
    def setOnTimeUpdate(value: ReactEventFrom[T with Element] => Callback): Self = this.set("onTimeUpdate", js.Any.fromFunction1((t0: ReactEventFrom[T with Element]) => value(t0).runNow()))
    
    @scala.inline
    def deleteOnTimeUpdate: Self = this.set("onTimeUpdate", js.undefined)
    
    @scala.inline
    def setOnTouchCancel(value: ReactTouchEventFrom[T with Element] => Callback): Self = this.set("onTouchCancel", js.Any.fromFunction1((t0: ReactTouchEventFrom[T with Element]) => value(t0).runNow()))
    
    @scala.inline
    def deleteOnTouchCancel: Self = this.set("onTouchCancel", js.undefined)
    
    @scala.inline
    def setOnTouchEnd(value: ReactTouchEventFrom[T with Element] => Callback): Self = this.set("onTouchEnd", js.Any.fromFunction1((t0: ReactTouchEventFrom[T with Element]) => value(t0).runNow()))
    
    @scala.inline
    def deleteOnTouchEnd: Self = this.set("onTouchEnd", js.undefined)
    
    @scala.inline
    def setOnTouchMove(value: ReactTouchEventFrom[T with Element] => Callback): Self = this.set("onTouchMove", js.Any.fromFunction1((t0: ReactTouchEventFrom[T with Element]) => value(t0).runNow()))
    
    @scala.inline
    def deleteOnTouchMove: Self = this.set("onTouchMove", js.undefined)
    
    @scala.inline
    def setOnTouchStart(value: ReactTouchEventFrom[T with Element] => Callback): Self = this.set("onTouchStart", js.Any.fromFunction1((t0: ReactTouchEventFrom[T with Element]) => value(t0).runNow()))
    
    @scala.inline
    def deleteOnTouchStart: Self = this.set("onTouchStart", js.undefined)
    
    @scala.inline
    def setOnTransitionEnd(value: ReactTransitionEventFrom[T with Element] => Callback): Self = this.set("onTransitionEnd", js.Any.fromFunction1((t0: ReactTransitionEventFrom[T with Element]) => value(t0).runNow()))
    
    @scala.inline
    def deleteOnTransitionEnd: Self = this.set("onTransitionEnd", js.undefined)
    
    @scala.inline
    def setOnVolumeChange(value: ReactEventFrom[T with Element] => Callback): Self = this.set("onVolumeChange", js.Any.fromFunction1((t0: ReactEventFrom[T with Element]) => value(t0).runNow()))
    
    @scala.inline
    def deleteOnVolumeChange: Self = this.set("onVolumeChange", js.undefined)
    
    @scala.inline
    def setOnWaiting(value: ReactEventFrom[T with Element] => Callback): Self = this.set("onWaiting", js.Any.fromFunction1((t0: ReactEventFrom[T with Element]) => value(t0).runNow()))
    
    @scala.inline
    def deleteOnWaiting: Self = this.set("onWaiting", js.undefined)
    
    @scala.inline
    def setOnWheel(value: ReactWheelEventFrom[T with Element] => Callback): Self = this.set("onWheel", js.Any.fromFunction1((t0: ReactWheelEventFrom[T with Element]) => value(t0).runNow()))
    
    @scala.inline
    def deleteOnWheel: Self = this.set("onWheel", js.undefined)
  }
}
