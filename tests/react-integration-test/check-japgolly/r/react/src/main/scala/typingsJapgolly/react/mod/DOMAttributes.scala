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
import japgolly.scalajs.react.raw.Empty
import japgolly.scalajs.react.raw.JsNumber
import japgolly.scalajs.react.raw.React.Element
import japgolly.scalajs.react.raw.React.Node
import japgolly.scalajs.react.vdom.VdomElement
import japgolly.scalajs.react.vdom.VdomNode
import typingsJapgolly.react.anon.Html
import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

@js.native
trait DOMAttributes[T] extends StObject {
  
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
  implicit class DOMAttributesMutableBuilder[Self <: DOMAttributes[_], T] (val x: Self with DOMAttributes[T]) extends AnyVal {
    
    @scala.inline
    def setChildren(value: VdomNode): Self = StObject.set(x, "children", value.rawNode.asInstanceOf[js.Any])
    
    @scala.inline
    def setChildrenNull: Self = StObject.set(x, "children", null)
    
    @scala.inline
    def setChildrenUndefined: Self = StObject.set(x, "children", js.undefined)
    
    @scala.inline
    def setChildrenVarargs(value: (Empty | String | JsNumber | Element)*): Self = StObject.set(x, "children", js.Array(value :_*))
    
    @scala.inline
    def setChildrenVdomElement(value: VdomElement): Self = StObject.set(x, "children", value.rawElement.asInstanceOf[js.Any])
    
    @scala.inline
    def setDangerouslySetInnerHTML(value: Html): Self = StObject.set(x, "dangerouslySetInnerHTML", value.asInstanceOf[js.Any])
    
    @scala.inline
    def setDangerouslySetInnerHTMLUndefined: Self = StObject.set(x, "dangerouslySetInnerHTML", js.undefined)
    
    @scala.inline
    def setOnAbort(value: ReactEventFrom[T with org.scalajs.dom.raw.Element] => Callback): Self = StObject.set(x, "onAbort", js.Any.fromFunction1((t0: ReactEventFrom[T with org.scalajs.dom.raw.Element]) => value(t0).runNow()))
    
    @scala.inline
    def setOnAbortUndefined: Self = StObject.set(x, "onAbort", js.undefined)
    
    @scala.inline
    def setOnAnimationEnd(value: ReactAnimationEventFrom[T with org.scalajs.dom.raw.Element] => Callback): Self = StObject.set(x, "onAnimationEnd", js.Any.fromFunction1((t0: ReactAnimationEventFrom[T with org.scalajs.dom.raw.Element]) => value(t0).runNow()))
    
    @scala.inline
    def setOnAnimationEndUndefined: Self = StObject.set(x, "onAnimationEnd", js.undefined)
    
    @scala.inline
    def setOnAnimationIteration(value: ReactAnimationEventFrom[T with org.scalajs.dom.raw.Element] => Callback): Self = StObject.set(x, "onAnimationIteration", js.Any.fromFunction1((t0: ReactAnimationEventFrom[T with org.scalajs.dom.raw.Element]) => value(t0).runNow()))
    
    @scala.inline
    def setOnAnimationIterationUndefined: Self = StObject.set(x, "onAnimationIteration", js.undefined)
    
    @scala.inline
    def setOnAnimationStart(value: ReactAnimationEventFrom[T with org.scalajs.dom.raw.Element] => Callback): Self = StObject.set(x, "onAnimationStart", js.Any.fromFunction1((t0: ReactAnimationEventFrom[T with org.scalajs.dom.raw.Element]) => value(t0).runNow()))
    
    @scala.inline
    def setOnAnimationStartUndefined: Self = StObject.set(x, "onAnimationStart", js.undefined)
    
    @scala.inline
    def setOnAuxClick(value: ReactMouseEventFrom[T with org.scalajs.dom.raw.Element] => Callback): Self = StObject.set(x, "onAuxClick", js.Any.fromFunction1((t0: ReactMouseEventFrom[T with org.scalajs.dom.raw.Element]) => value(t0).runNow()))
    
    @scala.inline
    def setOnAuxClickUndefined: Self = StObject.set(x, "onAuxClick", js.undefined)
    
    @scala.inline
    def setOnBeforeInput(value: ReactEventFrom[T with org.scalajs.dom.raw.Element] => Callback): Self = StObject.set(x, "onBeforeInput", js.Any.fromFunction1((t0: ReactEventFrom[T with org.scalajs.dom.raw.Element]) => value(t0).runNow()))
    
    @scala.inline
    def setOnBeforeInputUndefined: Self = StObject.set(x, "onBeforeInput", js.undefined)
    
    @scala.inline
    def setOnBlur(value: ReactFocusEventFrom[T with org.scalajs.dom.raw.Element] => Callback): Self = StObject.set(x, "onBlur", js.Any.fromFunction1((t0: ReactFocusEventFrom[T with org.scalajs.dom.raw.Element]) => value(t0).runNow()))
    
    @scala.inline
    def setOnBlurUndefined: Self = StObject.set(x, "onBlur", js.undefined)
    
    @scala.inline
    def setOnCanPlay(value: ReactEventFrom[T with org.scalajs.dom.raw.Element] => Callback): Self = StObject.set(x, "onCanPlay", js.Any.fromFunction1((t0: ReactEventFrom[T with org.scalajs.dom.raw.Element]) => value(t0).runNow()))
    
    @scala.inline
    def setOnCanPlayThrough(value: ReactEventFrom[T with org.scalajs.dom.raw.Element] => Callback): Self = StObject.set(x, "onCanPlayThrough", js.Any.fromFunction1((t0: ReactEventFrom[T with org.scalajs.dom.raw.Element]) => value(t0).runNow()))
    
    @scala.inline
    def setOnCanPlayThroughUndefined: Self = StObject.set(x, "onCanPlayThrough", js.undefined)
    
    @scala.inline
    def setOnCanPlayUndefined: Self = StObject.set(x, "onCanPlay", js.undefined)
    
    @scala.inline
    def setOnChange(value: ReactEventFrom[T with org.scalajs.dom.raw.Element] => Callback): Self = StObject.set(x, "onChange", js.Any.fromFunction1((t0: ReactEventFrom[T with org.scalajs.dom.raw.Element]) => value(t0).runNow()))
    
    @scala.inline
    def setOnChangeUndefined: Self = StObject.set(x, "onChange", js.undefined)
    
    @scala.inline
    def setOnClick(value: ReactMouseEventFrom[T with org.scalajs.dom.raw.Element] => Callback): Self = StObject.set(x, "onClick", js.Any.fromFunction1((t0: ReactMouseEventFrom[T with org.scalajs.dom.raw.Element]) => value(t0).runNow()))
    
    @scala.inline
    def setOnClickUndefined: Self = StObject.set(x, "onClick", js.undefined)
    
    @scala.inline
    def setOnCompositionEnd(value: ReactCompositionEventFrom[T with org.scalajs.dom.raw.Element] => Callback): Self = StObject.set(x, "onCompositionEnd", js.Any.fromFunction1((t0: ReactCompositionEventFrom[T with org.scalajs.dom.raw.Element]) => value(t0).runNow()))
    
    @scala.inline
    def setOnCompositionEndUndefined: Self = StObject.set(x, "onCompositionEnd", js.undefined)
    
    @scala.inline
    def setOnCompositionStart(value: ReactCompositionEventFrom[T with org.scalajs.dom.raw.Element] => Callback): Self = StObject.set(x, "onCompositionStart", js.Any.fromFunction1((t0: ReactCompositionEventFrom[T with org.scalajs.dom.raw.Element]) => value(t0).runNow()))
    
    @scala.inline
    def setOnCompositionStartUndefined: Self = StObject.set(x, "onCompositionStart", js.undefined)
    
    @scala.inline
    def setOnCompositionUpdate(value: ReactCompositionEventFrom[T with org.scalajs.dom.raw.Element] => Callback): Self = StObject.set(x, "onCompositionUpdate", js.Any.fromFunction1((t0: ReactCompositionEventFrom[T with org.scalajs.dom.raw.Element]) => value(t0).runNow()))
    
    @scala.inline
    def setOnCompositionUpdateUndefined: Self = StObject.set(x, "onCompositionUpdate", js.undefined)
    
    @scala.inline
    def setOnContextMenu(value: ReactMouseEventFrom[T with org.scalajs.dom.raw.Element] => Callback): Self = StObject.set(x, "onContextMenu", js.Any.fromFunction1((t0: ReactMouseEventFrom[T with org.scalajs.dom.raw.Element]) => value(t0).runNow()))
    
    @scala.inline
    def setOnContextMenuUndefined: Self = StObject.set(x, "onContextMenu", js.undefined)
    
    @scala.inline
    def setOnCopy(value: ReactClipboardEventFrom[T with org.scalajs.dom.raw.Element] => Callback): Self = StObject.set(x, "onCopy", js.Any.fromFunction1((t0: ReactClipboardEventFrom[T with org.scalajs.dom.raw.Element]) => value(t0).runNow()))
    
    @scala.inline
    def setOnCopyUndefined: Self = StObject.set(x, "onCopy", js.undefined)
    
    @scala.inline
    def setOnCut(value: ReactClipboardEventFrom[T with org.scalajs.dom.raw.Element] => Callback): Self = StObject.set(x, "onCut", js.Any.fromFunction1((t0: ReactClipboardEventFrom[T with org.scalajs.dom.raw.Element]) => value(t0).runNow()))
    
    @scala.inline
    def setOnCutUndefined: Self = StObject.set(x, "onCut", js.undefined)
    
    @scala.inline
    def setOnDoubleClick(value: ReactMouseEventFrom[T with org.scalajs.dom.raw.Element] => Callback): Self = StObject.set(x, "onDoubleClick", js.Any.fromFunction1((t0: ReactMouseEventFrom[T with org.scalajs.dom.raw.Element]) => value(t0).runNow()))
    
    @scala.inline
    def setOnDoubleClickUndefined: Self = StObject.set(x, "onDoubleClick", js.undefined)
    
    @scala.inline
    def setOnDrag(value: ReactDragEventFrom[T with org.scalajs.dom.raw.Element] => Callback): Self = StObject.set(x, "onDrag", js.Any.fromFunction1((t0: ReactDragEventFrom[T with org.scalajs.dom.raw.Element]) => value(t0).runNow()))
    
    @scala.inline
    def setOnDragEnd(value: ReactDragEventFrom[T with org.scalajs.dom.raw.Element] => Callback): Self = StObject.set(x, "onDragEnd", js.Any.fromFunction1((t0: ReactDragEventFrom[T with org.scalajs.dom.raw.Element]) => value(t0).runNow()))
    
    @scala.inline
    def setOnDragEndUndefined: Self = StObject.set(x, "onDragEnd", js.undefined)
    
    @scala.inline
    def setOnDragEnter(value: ReactDragEventFrom[T with org.scalajs.dom.raw.Element] => Callback): Self = StObject.set(x, "onDragEnter", js.Any.fromFunction1((t0: ReactDragEventFrom[T with org.scalajs.dom.raw.Element]) => value(t0).runNow()))
    
    @scala.inline
    def setOnDragEnterUndefined: Self = StObject.set(x, "onDragEnter", js.undefined)
    
    @scala.inline
    def setOnDragExit(value: ReactDragEventFrom[T with org.scalajs.dom.raw.Element] => Callback): Self = StObject.set(x, "onDragExit", js.Any.fromFunction1((t0: ReactDragEventFrom[T with org.scalajs.dom.raw.Element]) => value(t0).runNow()))
    
    @scala.inline
    def setOnDragExitUndefined: Self = StObject.set(x, "onDragExit", js.undefined)
    
    @scala.inline
    def setOnDragLeave(value: ReactDragEventFrom[T with org.scalajs.dom.raw.Element] => Callback): Self = StObject.set(x, "onDragLeave", js.Any.fromFunction1((t0: ReactDragEventFrom[T with org.scalajs.dom.raw.Element]) => value(t0).runNow()))
    
    @scala.inline
    def setOnDragLeaveUndefined: Self = StObject.set(x, "onDragLeave", js.undefined)
    
    @scala.inline
    def setOnDragOver(value: ReactDragEventFrom[T with org.scalajs.dom.raw.Element] => Callback): Self = StObject.set(x, "onDragOver", js.Any.fromFunction1((t0: ReactDragEventFrom[T with org.scalajs.dom.raw.Element]) => value(t0).runNow()))
    
    @scala.inline
    def setOnDragOverUndefined: Self = StObject.set(x, "onDragOver", js.undefined)
    
    @scala.inline
    def setOnDragStart(value: ReactDragEventFrom[T with org.scalajs.dom.raw.Element] => Callback): Self = StObject.set(x, "onDragStart", js.Any.fromFunction1((t0: ReactDragEventFrom[T with org.scalajs.dom.raw.Element]) => value(t0).runNow()))
    
    @scala.inline
    def setOnDragStartUndefined: Self = StObject.set(x, "onDragStart", js.undefined)
    
    @scala.inline
    def setOnDragUndefined: Self = StObject.set(x, "onDrag", js.undefined)
    
    @scala.inline
    def setOnDrop(value: ReactDragEventFrom[T with org.scalajs.dom.raw.Element] => Callback): Self = StObject.set(x, "onDrop", js.Any.fromFunction1((t0: ReactDragEventFrom[T with org.scalajs.dom.raw.Element]) => value(t0).runNow()))
    
    @scala.inline
    def setOnDropUndefined: Self = StObject.set(x, "onDrop", js.undefined)
    
    @scala.inline
    def setOnDurationChange(value: ReactEventFrom[T with org.scalajs.dom.raw.Element] => Callback): Self = StObject.set(x, "onDurationChange", js.Any.fromFunction1((t0: ReactEventFrom[T with org.scalajs.dom.raw.Element]) => value(t0).runNow()))
    
    @scala.inline
    def setOnDurationChangeUndefined: Self = StObject.set(x, "onDurationChange", js.undefined)
    
    @scala.inline
    def setOnEmptied(value: ReactEventFrom[T with org.scalajs.dom.raw.Element] => Callback): Self = StObject.set(x, "onEmptied", js.Any.fromFunction1((t0: ReactEventFrom[T with org.scalajs.dom.raw.Element]) => value(t0).runNow()))
    
    @scala.inline
    def setOnEmptiedUndefined: Self = StObject.set(x, "onEmptied", js.undefined)
    
    @scala.inline
    def setOnEncrypted(value: ReactEventFrom[T with org.scalajs.dom.raw.Element] => Callback): Self = StObject.set(x, "onEncrypted", js.Any.fromFunction1((t0: ReactEventFrom[T with org.scalajs.dom.raw.Element]) => value(t0).runNow()))
    
    @scala.inline
    def setOnEncryptedUndefined: Self = StObject.set(x, "onEncrypted", js.undefined)
    
    @scala.inline
    def setOnEnded(value: ReactEventFrom[T with org.scalajs.dom.raw.Element] => Callback): Self = StObject.set(x, "onEnded", js.Any.fromFunction1((t0: ReactEventFrom[T with org.scalajs.dom.raw.Element]) => value(t0).runNow()))
    
    @scala.inline
    def setOnEndedUndefined: Self = StObject.set(x, "onEnded", js.undefined)
    
    @scala.inline
    def setOnError(value: ReactEventFrom[T with org.scalajs.dom.raw.Element] => Callback): Self = StObject.set(x, "onError", js.Any.fromFunction1((t0: ReactEventFrom[T with org.scalajs.dom.raw.Element]) => value(t0).runNow()))
    
    @scala.inline
    def setOnErrorUndefined: Self = StObject.set(x, "onError", js.undefined)
    
    @scala.inline
    def setOnFocus(value: ReactFocusEventFrom[T with org.scalajs.dom.raw.Element] => Callback): Self = StObject.set(x, "onFocus", js.Any.fromFunction1((t0: ReactFocusEventFrom[T with org.scalajs.dom.raw.Element]) => value(t0).runNow()))
    
    @scala.inline
    def setOnFocusUndefined: Self = StObject.set(x, "onFocus", js.undefined)
    
    @scala.inline
    def setOnInput(value: ReactEventFrom[T with org.scalajs.dom.raw.Element] => Callback): Self = StObject.set(x, "onInput", js.Any.fromFunction1((t0: ReactEventFrom[T with org.scalajs.dom.raw.Element]) => value(t0).runNow()))
    
    @scala.inline
    def setOnInputUndefined: Self = StObject.set(x, "onInput", js.undefined)
    
    @scala.inline
    def setOnInvalid(value: ReactEventFrom[T with org.scalajs.dom.raw.Element] => Callback): Self = StObject.set(x, "onInvalid", js.Any.fromFunction1((t0: ReactEventFrom[T with org.scalajs.dom.raw.Element]) => value(t0).runNow()))
    
    @scala.inline
    def setOnInvalidUndefined: Self = StObject.set(x, "onInvalid", js.undefined)
    
    @scala.inline
    def setOnKeyDown(value: ReactKeyboardEventFrom[T with org.scalajs.dom.raw.Element] => Callback): Self = StObject.set(x, "onKeyDown", js.Any.fromFunction1((t0: ReactKeyboardEventFrom[T with org.scalajs.dom.raw.Element]) => value(t0).runNow()))
    
    @scala.inline
    def setOnKeyDownUndefined: Self = StObject.set(x, "onKeyDown", js.undefined)
    
    @scala.inline
    def setOnKeyPress(value: ReactKeyboardEventFrom[T with org.scalajs.dom.raw.Element] => Callback): Self = StObject.set(x, "onKeyPress", js.Any.fromFunction1((t0: ReactKeyboardEventFrom[T with org.scalajs.dom.raw.Element]) => value(t0).runNow()))
    
    @scala.inline
    def setOnKeyPressUndefined: Self = StObject.set(x, "onKeyPress", js.undefined)
    
    @scala.inline
    def setOnKeyUp(value: ReactKeyboardEventFrom[T with org.scalajs.dom.raw.Element] => Callback): Self = StObject.set(x, "onKeyUp", js.Any.fromFunction1((t0: ReactKeyboardEventFrom[T with org.scalajs.dom.raw.Element]) => value(t0).runNow()))
    
    @scala.inline
    def setOnKeyUpUndefined: Self = StObject.set(x, "onKeyUp", js.undefined)
    
    @scala.inline
    def setOnLoad(value: ReactEventFrom[T with org.scalajs.dom.raw.Element] => Callback): Self = StObject.set(x, "onLoad", js.Any.fromFunction1((t0: ReactEventFrom[T with org.scalajs.dom.raw.Element]) => value(t0).runNow()))
    
    @scala.inline
    def setOnLoadStart(value: ReactEventFrom[T with org.scalajs.dom.raw.Element] => Callback): Self = StObject.set(x, "onLoadStart", js.Any.fromFunction1((t0: ReactEventFrom[T with org.scalajs.dom.raw.Element]) => value(t0).runNow()))
    
    @scala.inline
    def setOnLoadStartUndefined: Self = StObject.set(x, "onLoadStart", js.undefined)
    
    @scala.inline
    def setOnLoadUndefined: Self = StObject.set(x, "onLoad", js.undefined)
    
    @scala.inline
    def setOnLoadedData(value: ReactEventFrom[T with org.scalajs.dom.raw.Element] => Callback): Self = StObject.set(x, "onLoadedData", js.Any.fromFunction1((t0: ReactEventFrom[T with org.scalajs.dom.raw.Element]) => value(t0).runNow()))
    
    @scala.inline
    def setOnLoadedDataUndefined: Self = StObject.set(x, "onLoadedData", js.undefined)
    
    @scala.inline
    def setOnLoadedMetadata(value: ReactEventFrom[T with org.scalajs.dom.raw.Element] => Callback): Self = StObject.set(x, "onLoadedMetadata", js.Any.fromFunction1((t0: ReactEventFrom[T with org.scalajs.dom.raw.Element]) => value(t0).runNow()))
    
    @scala.inline
    def setOnLoadedMetadataUndefined: Self = StObject.set(x, "onLoadedMetadata", js.undefined)
    
    @scala.inline
    def setOnMouseDown(value: ReactMouseEventFrom[T with org.scalajs.dom.raw.Element] => Callback): Self = StObject.set(x, "onMouseDown", js.Any.fromFunction1((t0: ReactMouseEventFrom[T with org.scalajs.dom.raw.Element]) => value(t0).runNow()))
    
    @scala.inline
    def setOnMouseDownUndefined: Self = StObject.set(x, "onMouseDown", js.undefined)
    
    @scala.inline
    def setOnMouseEnter(value: ReactMouseEventFrom[T with org.scalajs.dom.raw.Element] => Callback): Self = StObject.set(x, "onMouseEnter", js.Any.fromFunction1((t0: ReactMouseEventFrom[T with org.scalajs.dom.raw.Element]) => value(t0).runNow()))
    
    @scala.inline
    def setOnMouseEnterUndefined: Self = StObject.set(x, "onMouseEnter", js.undefined)
    
    @scala.inline
    def setOnMouseLeave(value: ReactMouseEventFrom[T with org.scalajs.dom.raw.Element] => Callback): Self = StObject.set(x, "onMouseLeave", js.Any.fromFunction1((t0: ReactMouseEventFrom[T with org.scalajs.dom.raw.Element]) => value(t0).runNow()))
    
    @scala.inline
    def setOnMouseLeaveUndefined: Self = StObject.set(x, "onMouseLeave", js.undefined)
    
    @scala.inline
    def setOnMouseMove(value: ReactMouseEventFrom[T with org.scalajs.dom.raw.Element] => Callback): Self = StObject.set(x, "onMouseMove", js.Any.fromFunction1((t0: ReactMouseEventFrom[T with org.scalajs.dom.raw.Element]) => value(t0).runNow()))
    
    @scala.inline
    def setOnMouseMoveUndefined: Self = StObject.set(x, "onMouseMove", js.undefined)
    
    @scala.inline
    def setOnMouseOut(value: ReactMouseEventFrom[T with org.scalajs.dom.raw.Element] => Callback): Self = StObject.set(x, "onMouseOut", js.Any.fromFunction1((t0: ReactMouseEventFrom[T with org.scalajs.dom.raw.Element]) => value(t0).runNow()))
    
    @scala.inline
    def setOnMouseOutUndefined: Self = StObject.set(x, "onMouseOut", js.undefined)
    
    @scala.inline
    def setOnMouseOver(value: ReactMouseEventFrom[T with org.scalajs.dom.raw.Element] => Callback): Self = StObject.set(x, "onMouseOver", js.Any.fromFunction1((t0: ReactMouseEventFrom[T with org.scalajs.dom.raw.Element]) => value(t0).runNow()))
    
    @scala.inline
    def setOnMouseOverUndefined: Self = StObject.set(x, "onMouseOver", js.undefined)
    
    @scala.inline
    def setOnMouseUp(value: ReactMouseEventFrom[T with org.scalajs.dom.raw.Element] => Callback): Self = StObject.set(x, "onMouseUp", js.Any.fromFunction1((t0: ReactMouseEventFrom[T with org.scalajs.dom.raw.Element]) => value(t0).runNow()))
    
    @scala.inline
    def setOnMouseUpUndefined: Self = StObject.set(x, "onMouseUp", js.undefined)
    
    @scala.inline
    def setOnPaste(value: ReactClipboardEventFrom[T with org.scalajs.dom.raw.Element] => Callback): Self = StObject.set(x, "onPaste", js.Any.fromFunction1((t0: ReactClipboardEventFrom[T with org.scalajs.dom.raw.Element]) => value(t0).runNow()))
    
    @scala.inline
    def setOnPasteUndefined: Self = StObject.set(x, "onPaste", js.undefined)
    
    @scala.inline
    def setOnPause(value: ReactEventFrom[T with org.scalajs.dom.raw.Element] => Callback): Self = StObject.set(x, "onPause", js.Any.fromFunction1((t0: ReactEventFrom[T with org.scalajs.dom.raw.Element]) => value(t0).runNow()))
    
    @scala.inline
    def setOnPauseUndefined: Self = StObject.set(x, "onPause", js.undefined)
    
    @scala.inline
    def setOnPlay(value: ReactEventFrom[T with org.scalajs.dom.raw.Element] => Callback): Self = StObject.set(x, "onPlay", js.Any.fromFunction1((t0: ReactEventFrom[T with org.scalajs.dom.raw.Element]) => value(t0).runNow()))
    
    @scala.inline
    def setOnPlayUndefined: Self = StObject.set(x, "onPlay", js.undefined)
    
    @scala.inline
    def setOnPlaying(value: ReactEventFrom[T with org.scalajs.dom.raw.Element] => Callback): Self = StObject.set(x, "onPlaying", js.Any.fromFunction1((t0: ReactEventFrom[T with org.scalajs.dom.raw.Element]) => value(t0).runNow()))
    
    @scala.inline
    def setOnPlayingUndefined: Self = StObject.set(x, "onPlaying", js.undefined)
    
    @scala.inline
    def setOnPointerCancel(value: ReactPointerEventFrom[T with org.scalajs.dom.raw.Element] => Callback): Self = StObject.set(x, "onPointerCancel", js.Any.fromFunction1((t0: ReactPointerEventFrom[T with org.scalajs.dom.raw.Element]) => value(t0).runNow()))
    
    @scala.inline
    def setOnPointerCancelUndefined: Self = StObject.set(x, "onPointerCancel", js.undefined)
    
    @scala.inline
    def setOnPointerDown(value: ReactPointerEventFrom[T with org.scalajs.dom.raw.Element] => Callback): Self = StObject.set(x, "onPointerDown", js.Any.fromFunction1((t0: ReactPointerEventFrom[T with org.scalajs.dom.raw.Element]) => value(t0).runNow()))
    
    @scala.inline
    def setOnPointerDownUndefined: Self = StObject.set(x, "onPointerDown", js.undefined)
    
    @scala.inline
    def setOnPointerEnter(value: ReactPointerEventFrom[T with org.scalajs.dom.raw.Element] => Callback): Self = StObject.set(x, "onPointerEnter", js.Any.fromFunction1((t0: ReactPointerEventFrom[T with org.scalajs.dom.raw.Element]) => value(t0).runNow()))
    
    @scala.inline
    def setOnPointerEnterUndefined: Self = StObject.set(x, "onPointerEnter", js.undefined)
    
    @scala.inline
    def setOnPointerLeave(value: ReactPointerEventFrom[T with org.scalajs.dom.raw.Element] => Callback): Self = StObject.set(x, "onPointerLeave", js.Any.fromFunction1((t0: ReactPointerEventFrom[T with org.scalajs.dom.raw.Element]) => value(t0).runNow()))
    
    @scala.inline
    def setOnPointerLeaveUndefined: Self = StObject.set(x, "onPointerLeave", js.undefined)
    
    @scala.inline
    def setOnPointerMove(value: ReactPointerEventFrom[T with org.scalajs.dom.raw.Element] => Callback): Self = StObject.set(x, "onPointerMove", js.Any.fromFunction1((t0: ReactPointerEventFrom[T with org.scalajs.dom.raw.Element]) => value(t0).runNow()))
    
    @scala.inline
    def setOnPointerMoveUndefined: Self = StObject.set(x, "onPointerMove", js.undefined)
    
    @scala.inline
    def setOnPointerOut(value: ReactPointerEventFrom[T with org.scalajs.dom.raw.Element] => Callback): Self = StObject.set(x, "onPointerOut", js.Any.fromFunction1((t0: ReactPointerEventFrom[T with org.scalajs.dom.raw.Element]) => value(t0).runNow()))
    
    @scala.inline
    def setOnPointerOutUndefined: Self = StObject.set(x, "onPointerOut", js.undefined)
    
    @scala.inline
    def setOnPointerOver(value: ReactPointerEventFrom[T with org.scalajs.dom.raw.Element] => Callback): Self = StObject.set(x, "onPointerOver", js.Any.fromFunction1((t0: ReactPointerEventFrom[T with org.scalajs.dom.raw.Element]) => value(t0).runNow()))
    
    @scala.inline
    def setOnPointerOverUndefined: Self = StObject.set(x, "onPointerOver", js.undefined)
    
    @scala.inline
    def setOnPointerUp(value: ReactPointerEventFrom[T with org.scalajs.dom.raw.Element] => Callback): Self = StObject.set(x, "onPointerUp", js.Any.fromFunction1((t0: ReactPointerEventFrom[T with org.scalajs.dom.raw.Element]) => value(t0).runNow()))
    
    @scala.inline
    def setOnPointerUpUndefined: Self = StObject.set(x, "onPointerUp", js.undefined)
    
    @scala.inline
    def setOnProgress(value: ReactEventFrom[T with org.scalajs.dom.raw.Element] => Callback): Self = StObject.set(x, "onProgress", js.Any.fromFunction1((t0: ReactEventFrom[T with org.scalajs.dom.raw.Element]) => value(t0).runNow()))
    
    @scala.inline
    def setOnProgressUndefined: Self = StObject.set(x, "onProgress", js.undefined)
    
    @scala.inline
    def setOnRateChange(value: ReactEventFrom[T with org.scalajs.dom.raw.Element] => Callback): Self = StObject.set(x, "onRateChange", js.Any.fromFunction1((t0: ReactEventFrom[T with org.scalajs.dom.raw.Element]) => value(t0).runNow()))
    
    @scala.inline
    def setOnRateChangeUndefined: Self = StObject.set(x, "onRateChange", js.undefined)
    
    @scala.inline
    def setOnReset(value: ReactEventFrom[T with org.scalajs.dom.raw.Element] => Callback): Self = StObject.set(x, "onReset", js.Any.fromFunction1((t0: ReactEventFrom[T with org.scalajs.dom.raw.Element]) => value(t0).runNow()))
    
    @scala.inline
    def setOnResetUndefined: Self = StObject.set(x, "onReset", js.undefined)
    
    @scala.inline
    def setOnScroll(value: ReactUIEventFrom[T with org.scalajs.dom.raw.Element] => Callback): Self = StObject.set(x, "onScroll", js.Any.fromFunction1((t0: ReactUIEventFrom[T with org.scalajs.dom.raw.Element]) => value(t0).runNow()))
    
    @scala.inline
    def setOnScrollUndefined: Self = StObject.set(x, "onScroll", js.undefined)
    
    @scala.inline
    def setOnSeeked(value: ReactEventFrom[T with org.scalajs.dom.raw.Element] => Callback): Self = StObject.set(x, "onSeeked", js.Any.fromFunction1((t0: ReactEventFrom[T with org.scalajs.dom.raw.Element]) => value(t0).runNow()))
    
    @scala.inline
    def setOnSeekedUndefined: Self = StObject.set(x, "onSeeked", js.undefined)
    
    @scala.inline
    def setOnSeeking(value: ReactEventFrom[T with org.scalajs.dom.raw.Element] => Callback): Self = StObject.set(x, "onSeeking", js.Any.fromFunction1((t0: ReactEventFrom[T with org.scalajs.dom.raw.Element]) => value(t0).runNow()))
    
    @scala.inline
    def setOnSeekingUndefined: Self = StObject.set(x, "onSeeking", js.undefined)
    
    @scala.inline
    def setOnSelect(value: ReactEventFrom[T with org.scalajs.dom.raw.Element] => Callback): Self = StObject.set(x, "onSelect", js.Any.fromFunction1((t0: ReactEventFrom[T with org.scalajs.dom.raw.Element]) => value(t0).runNow()))
    
    @scala.inline
    def setOnSelectUndefined: Self = StObject.set(x, "onSelect", js.undefined)
    
    @scala.inline
    def setOnStalled(value: ReactEventFrom[T with org.scalajs.dom.raw.Element] => Callback): Self = StObject.set(x, "onStalled", js.Any.fromFunction1((t0: ReactEventFrom[T with org.scalajs.dom.raw.Element]) => value(t0).runNow()))
    
    @scala.inline
    def setOnStalledUndefined: Self = StObject.set(x, "onStalled", js.undefined)
    
    @scala.inline
    def setOnSubmit(value: ReactEventFrom[T with org.scalajs.dom.raw.Element] => Callback): Self = StObject.set(x, "onSubmit", js.Any.fromFunction1((t0: ReactEventFrom[T with org.scalajs.dom.raw.Element]) => value(t0).runNow()))
    
    @scala.inline
    def setOnSubmitUndefined: Self = StObject.set(x, "onSubmit", js.undefined)
    
    @scala.inline
    def setOnSuspend(value: ReactEventFrom[T with org.scalajs.dom.raw.Element] => Callback): Self = StObject.set(x, "onSuspend", js.Any.fromFunction1((t0: ReactEventFrom[T with org.scalajs.dom.raw.Element]) => value(t0).runNow()))
    
    @scala.inline
    def setOnSuspendUndefined: Self = StObject.set(x, "onSuspend", js.undefined)
    
    @scala.inline
    def setOnTimeUpdate(value: ReactEventFrom[T with org.scalajs.dom.raw.Element] => Callback): Self = StObject.set(x, "onTimeUpdate", js.Any.fromFunction1((t0: ReactEventFrom[T with org.scalajs.dom.raw.Element]) => value(t0).runNow()))
    
    @scala.inline
    def setOnTimeUpdateUndefined: Self = StObject.set(x, "onTimeUpdate", js.undefined)
    
    @scala.inline
    def setOnTouchCancel(value: ReactTouchEventFrom[T with org.scalajs.dom.raw.Element] => Callback): Self = StObject.set(x, "onTouchCancel", js.Any.fromFunction1((t0: ReactTouchEventFrom[T with org.scalajs.dom.raw.Element]) => value(t0).runNow()))
    
    @scala.inline
    def setOnTouchCancelUndefined: Self = StObject.set(x, "onTouchCancel", js.undefined)
    
    @scala.inline
    def setOnTouchEnd(value: ReactTouchEventFrom[T with org.scalajs.dom.raw.Element] => Callback): Self = StObject.set(x, "onTouchEnd", js.Any.fromFunction1((t0: ReactTouchEventFrom[T with org.scalajs.dom.raw.Element]) => value(t0).runNow()))
    
    @scala.inline
    def setOnTouchEndUndefined: Self = StObject.set(x, "onTouchEnd", js.undefined)
    
    @scala.inline
    def setOnTouchMove(value: ReactTouchEventFrom[T with org.scalajs.dom.raw.Element] => Callback): Self = StObject.set(x, "onTouchMove", js.Any.fromFunction1((t0: ReactTouchEventFrom[T with org.scalajs.dom.raw.Element]) => value(t0).runNow()))
    
    @scala.inline
    def setOnTouchMoveUndefined: Self = StObject.set(x, "onTouchMove", js.undefined)
    
    @scala.inline
    def setOnTouchStart(value: ReactTouchEventFrom[T with org.scalajs.dom.raw.Element] => Callback): Self = StObject.set(x, "onTouchStart", js.Any.fromFunction1((t0: ReactTouchEventFrom[T with org.scalajs.dom.raw.Element]) => value(t0).runNow()))
    
    @scala.inline
    def setOnTouchStartUndefined: Self = StObject.set(x, "onTouchStart", js.undefined)
    
    @scala.inline
    def setOnTransitionEnd(value: ReactTransitionEventFrom[T with org.scalajs.dom.raw.Element] => Callback): Self = StObject.set(x, "onTransitionEnd", js.Any.fromFunction1((t0: ReactTransitionEventFrom[T with org.scalajs.dom.raw.Element]) => value(t0).runNow()))
    
    @scala.inline
    def setOnTransitionEndUndefined: Self = StObject.set(x, "onTransitionEnd", js.undefined)
    
    @scala.inline
    def setOnVolumeChange(value: ReactEventFrom[T with org.scalajs.dom.raw.Element] => Callback): Self = StObject.set(x, "onVolumeChange", js.Any.fromFunction1((t0: ReactEventFrom[T with org.scalajs.dom.raw.Element]) => value(t0).runNow()))
    
    @scala.inline
    def setOnVolumeChangeUndefined: Self = StObject.set(x, "onVolumeChange", js.undefined)
    
    @scala.inline
    def setOnWaiting(value: ReactEventFrom[T with org.scalajs.dom.raw.Element] => Callback): Self = StObject.set(x, "onWaiting", js.Any.fromFunction1((t0: ReactEventFrom[T with org.scalajs.dom.raw.Element]) => value(t0).runNow()))
    
    @scala.inline
    def setOnWaitingUndefined: Self = StObject.set(x, "onWaiting", js.undefined)
    
    @scala.inline
    def setOnWheel(value: ReactWheelEventFrom[T with org.scalajs.dom.raw.Element] => Callback): Self = StObject.set(x, "onWheel", js.Any.fromFunction1((t0: ReactWheelEventFrom[T with org.scalajs.dom.raw.Element]) => value(t0).runNow()))
    
    @scala.inline
    def setOnWheelUndefined: Self = StObject.set(x, "onWheel", js.undefined)
  }
}
