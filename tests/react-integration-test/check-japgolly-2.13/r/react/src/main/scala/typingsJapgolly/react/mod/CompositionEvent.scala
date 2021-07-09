package typingsJapgolly.react.mod

import japgolly.scalajs.react.Callback
import japgolly.scalajs.react.CallbackTo
import org.scalajs.dom.raw.EventTarget
import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

@js.native
trait CompositionEvent[T]
  extends StObject
     with BaseSyntheticEvent[NativeCompositionEvent, EventTarget with T, EventTarget] {
  
  var data: String = js.native
}
object CompositionEvent {
  
  @scala.inline
  def apply[T](
    bubbles: Boolean,
    cancelable: Boolean,
    currentTarget: EventTarget with T,
    data: String,
    defaultPrevented: Boolean,
    eventPhase: Double,
    isDefaultPrevented: CallbackTo[Boolean],
    isPropagationStopped: CallbackTo[Boolean],
    isTrusted: Boolean,
    nativeEvent: NativeCompositionEvent,
    persist: Callback,
    preventDefault: Callback,
    stopPropagation: Callback,
    target: EventTarget,
    timeStamp: Double,
    `type`: String
  ): CompositionEvent[T] = {
    val __obj = js.Dynamic.literal(bubbles = bubbles.asInstanceOf[js.Any], cancelable = cancelable.asInstanceOf[js.Any], currentTarget = currentTarget.asInstanceOf[js.Any], data = data.asInstanceOf[js.Any], defaultPrevented = defaultPrevented.asInstanceOf[js.Any], eventPhase = eventPhase.asInstanceOf[js.Any], isDefaultPrevented = isDefaultPrevented.toJsFn, isPropagationStopped = isPropagationStopped.toJsFn, isTrusted = isTrusted.asInstanceOf[js.Any], nativeEvent = nativeEvent.asInstanceOf[js.Any], persist = persist.toJsFn, preventDefault = preventDefault.toJsFn, stopPropagation = stopPropagation.toJsFn, target = target.asInstanceOf[js.Any], timeStamp = timeStamp.asInstanceOf[js.Any])
    __obj.updateDynamic("type")(`type`.asInstanceOf[js.Any])
    __obj.asInstanceOf[CompositionEvent[T]]
  }
  
  @scala.inline
  implicit class CompositionEventMutableBuilder[Self <: CompositionEvent[_], T] (val x: Self with CompositionEvent[T]) extends AnyVal {
    
    @scala.inline
    def setData(value: String): Self = StObject.set(x, "data", value.asInstanceOf[js.Any])
  }
}
