package typingsJapgolly.react.mod

import japgolly.scalajs.react.Callback
import japgolly.scalajs.react.CallbackTo
import org.scalajs.dom.raw.EventTarget
import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

@js.native
trait AnimationEvent[T]
  extends StObject
     with BaseSyntheticEvent[NativeAnimationEvent, EventTarget & T, EventTarget] {
  
  var animationName: String = js.native
  
  var elapsedTime: Double = js.native
  
  var pseudoElement: String = js.native
}
object AnimationEvent {
  
  @scala.inline
  def apply[T](
    animationName: String,
    bubbles: Boolean,
    cancelable: Boolean,
    currentTarget: EventTarget & T,
    defaultPrevented: Boolean,
    elapsedTime: Double,
    eventPhase: Double,
    isDefaultPrevented: CallbackTo[Boolean],
    isPropagationStopped: CallbackTo[Boolean],
    isTrusted: Boolean,
    nativeEvent: NativeAnimationEvent,
    persist: Callback,
    preventDefault: Callback,
    pseudoElement: String,
    stopPropagation: Callback,
    target: EventTarget,
    timeStamp: Double,
    `type`: String
  ): AnimationEvent[T] = {
    val __obj = js.Dynamic.literal(animationName = animationName.asInstanceOf[js.Any], bubbles = bubbles.asInstanceOf[js.Any], cancelable = cancelable.asInstanceOf[js.Any], currentTarget = currentTarget.asInstanceOf[js.Any], defaultPrevented = defaultPrevented.asInstanceOf[js.Any], elapsedTime = elapsedTime.asInstanceOf[js.Any], eventPhase = eventPhase.asInstanceOf[js.Any], isDefaultPrevented = isDefaultPrevented.toJsFn, isPropagationStopped = isPropagationStopped.toJsFn, isTrusted = isTrusted.asInstanceOf[js.Any], nativeEvent = nativeEvent.asInstanceOf[js.Any], persist = persist.toJsFn, preventDefault = preventDefault.toJsFn, pseudoElement = pseudoElement.asInstanceOf[js.Any], stopPropagation = stopPropagation.toJsFn, target = target.asInstanceOf[js.Any], timeStamp = timeStamp.asInstanceOf[js.Any])
    __obj.updateDynamic("type")(`type`.asInstanceOf[js.Any])
    __obj.asInstanceOf[AnimationEvent[T]]
  }
  
  @scala.inline
  implicit class AnimationEventMutableBuilder[Self <: AnimationEvent[?], T] (val x: Self & AnimationEvent[T]) extends AnyVal {
    
    @scala.inline
    def setAnimationName(value: String): Self = StObject.set(x, "animationName", value.asInstanceOf[js.Any])
    
    @scala.inline
    def setElapsedTime(value: Double): Self = StObject.set(x, "elapsedTime", value.asInstanceOf[js.Any])
    
    @scala.inline
    def setPseudoElement(value: String): Self = StObject.set(x, "pseudoElement", value.asInstanceOf[js.Any])
  }
}
