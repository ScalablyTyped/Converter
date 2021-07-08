package typingsJapgolly.react.mod

import japgolly.scalajs.react.Callback
import japgolly.scalajs.react.CallbackTo
import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

//
// Event System
// ----------------------------------------------------------------------
// TODO: change any to unknown when moving to TS v3
trait BaseSyntheticEvent[E, C, T] extends StObject {
  
  var bubbles: Boolean
  
  var cancelable: Boolean
  
  var currentTarget: C
  
  var defaultPrevented: Boolean
  
  var eventPhase: Double
  
  def isDefaultPrevented(): Boolean
  
  def isPropagationStopped(): Boolean
  
  var isTrusted: Boolean
  
  var nativeEvent: E
  
  def persist(): Unit
  
  def preventDefault(): Unit
  
  def stopPropagation(): Unit
  
  var target: T
  
  var timeStamp: Double
  
  var `type`: String
}
object BaseSyntheticEvent {
  
  inline def apply[E, C, T](
    bubbles: Boolean,
    cancelable: Boolean,
    currentTarget: C,
    defaultPrevented: Boolean,
    eventPhase: Double,
    isDefaultPrevented: CallbackTo[Boolean],
    isPropagationStopped: CallbackTo[Boolean],
    isTrusted: Boolean,
    nativeEvent: E,
    persist: Callback,
    preventDefault: Callback,
    stopPropagation: Callback,
    target: T,
    timeStamp: Double,
    `type`: String
  ): BaseSyntheticEvent[E, C, T] = {
    val __obj = js.Dynamic.literal(bubbles = bubbles.asInstanceOf[js.Any], cancelable = cancelable.asInstanceOf[js.Any], currentTarget = currentTarget.asInstanceOf[js.Any], defaultPrevented = defaultPrevented.asInstanceOf[js.Any], eventPhase = eventPhase.asInstanceOf[js.Any], isDefaultPrevented = isDefaultPrevented.toJsFn, isPropagationStopped = isPropagationStopped.toJsFn, isTrusted = isTrusted.asInstanceOf[js.Any], nativeEvent = nativeEvent.asInstanceOf[js.Any], persist = persist.toJsFn, preventDefault = preventDefault.toJsFn, stopPropagation = stopPropagation.toJsFn, target = target.asInstanceOf[js.Any], timeStamp = timeStamp.asInstanceOf[js.Any])
    __obj.updateDynamic("type")(`type`.asInstanceOf[js.Any])
    __obj.asInstanceOf[BaseSyntheticEvent[E, C, T]]
  }
  
  extension [Self <: BaseSyntheticEvent[?, ?, ?], E, C, T](x: Self & (BaseSyntheticEvent[E, C, T])) {
    
    inline def setBubbles(value: Boolean): Self = StObject.set(x, "bubbles", value.asInstanceOf[js.Any])
    
    inline def setCancelable(value: Boolean): Self = StObject.set(x, "cancelable", value.asInstanceOf[js.Any])
    
    inline def setCurrentTarget(value: C): Self = StObject.set(x, "currentTarget", value.asInstanceOf[js.Any])
    
    inline def setDefaultPrevented(value: Boolean): Self = StObject.set(x, "defaultPrevented", value.asInstanceOf[js.Any])
    
    inline def setEventPhase(value: Double): Self = StObject.set(x, "eventPhase", value.asInstanceOf[js.Any])
    
    inline def setIsDefaultPrevented(value: CallbackTo[Boolean]): Self = StObject.set(x, "isDefaultPrevented", value.toJsFn)
    
    inline def setIsPropagationStopped(value: CallbackTo[Boolean]): Self = StObject.set(x, "isPropagationStopped", value.toJsFn)
    
    inline def setIsTrusted(value: Boolean): Self = StObject.set(x, "isTrusted", value.asInstanceOf[js.Any])
    
    inline def setNativeEvent(value: E): Self = StObject.set(x, "nativeEvent", value.asInstanceOf[js.Any])
    
    inline def setPersist(value: Callback): Self = StObject.set(x, "persist", value.toJsFn)
    
    inline def setPreventDefault(value: Callback): Self = StObject.set(x, "preventDefault", value.toJsFn)
    
    inline def setStopPropagation(value: Callback): Self = StObject.set(x, "stopPropagation", value.toJsFn)
    
    inline def setTarget(value: T): Self = StObject.set(x, "target", value.asInstanceOf[js.Any])
    
    inline def setTimeStamp(value: Double): Self = StObject.set(x, "timeStamp", value.asInstanceOf[js.Any])
    
    inline def setType(value: String): Self = StObject.set(x, "type", value.asInstanceOf[js.Any])
  }
}
