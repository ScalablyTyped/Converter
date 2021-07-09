package typingsJapgolly.react.mod

import japgolly.scalajs.react.Callback
import japgolly.scalajs.react.CallbackTo
import org.scalajs.dom.raw.EventTarget
import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

@js.native
trait FocusEvent[T]
  extends StObject
     with BaseSyntheticEvent[NativeFocusEvent, EventTarget with T, EventTarget] {
  
  var relatedTarget: EventTarget = js.native
  
  @JSName("target")
  var target_FocusEvent: EventTarget with T = js.native
}
object FocusEvent {
  
  @scala.inline
  def apply[T](
    bubbles: Boolean,
    cancelable: Boolean,
    currentTarget: EventTarget with T,
    defaultPrevented: Boolean,
    eventPhase: Double,
    isDefaultPrevented: CallbackTo[Boolean],
    isPropagationStopped: CallbackTo[Boolean],
    isTrusted: Boolean,
    nativeEvent: NativeFocusEvent,
    persist: Callback,
    preventDefault: Callback,
    relatedTarget: EventTarget,
    stopPropagation: Callback,
    target: EventTarget with T,
    timeStamp: Double,
    `type`: String
  ): FocusEvent[T] = {
    val __obj = js.Dynamic.literal(bubbles = bubbles.asInstanceOf[js.Any], cancelable = cancelable.asInstanceOf[js.Any], currentTarget = currentTarget.asInstanceOf[js.Any], defaultPrevented = defaultPrevented.asInstanceOf[js.Any], eventPhase = eventPhase.asInstanceOf[js.Any], isDefaultPrevented = isDefaultPrevented.toJsFn, isPropagationStopped = isPropagationStopped.toJsFn, isTrusted = isTrusted.asInstanceOf[js.Any], nativeEvent = nativeEvent.asInstanceOf[js.Any], persist = persist.toJsFn, preventDefault = preventDefault.toJsFn, relatedTarget = relatedTarget.asInstanceOf[js.Any], stopPropagation = stopPropagation.toJsFn, target = target.asInstanceOf[js.Any], timeStamp = timeStamp.asInstanceOf[js.Any])
    __obj.updateDynamic("type")(`type`.asInstanceOf[js.Any])
    __obj.asInstanceOf[FocusEvent[T]]
  }
  
  @scala.inline
  implicit class FocusEventMutableBuilder[Self <: FocusEvent[_], T] (val x: Self with FocusEvent[T]) extends AnyVal {
    
    @scala.inline
    def setRelatedTarget(value: EventTarget): Self = StObject.set(x, "relatedTarget", value.asInstanceOf[js.Any])
    
    @scala.inline
    def setTarget(value: EventTarget with T): Self = StObject.set(x, "target", value.asInstanceOf[js.Any])
  }
}
