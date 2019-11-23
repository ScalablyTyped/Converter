package typings.react.reactMod

import org.scalajs.dom.raw.Event
import typings.react.NativeCompositionEvent
import typings.std.EventTarget
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

trait CompositionEvent[T] extends BaseSyntheticEvent[NativeCompositionEvent, EventTarget with T, EventTarget] {
  var data: String
}

object CompositionEvent {
  @scala.inline
  def apply[T](
    bubbles: Boolean,
    cancelable: Boolean,
    currentTarget: org.scalajs.dom.raw.EventTarget with T,
    data: String,
    defaultPrevented: Boolean,
    eventPhase: Double,
    isDefaultPrevented: () => Boolean,
    isPropagationStopped: () => Boolean,
    isTrusted: Boolean,
    nativeEvent: Event,
    persist: () => Unit,
    preventDefault: () => Unit,
    stopPropagation: () => Unit,
    target: org.scalajs.dom.raw.EventTarget,
    timeStamp: Double,
    `type`: String
  ): CompositionEvent[T] = {
    val __obj = js.Dynamic.literal(bubbles = bubbles, cancelable = cancelable, currentTarget = currentTarget, data = data, defaultPrevented = defaultPrevented, eventPhase = eventPhase, isDefaultPrevented = js.Any.fromFunction0(isDefaultPrevented), isPropagationStopped = js.Any.fromFunction0(isPropagationStopped), isTrusted = isTrusted, nativeEvent = nativeEvent, persist = js.Any.fromFunction0(persist), preventDefault = js.Any.fromFunction0(preventDefault), stopPropagation = js.Any.fromFunction0(stopPropagation), target = target, timeStamp = timeStamp)
    __obj.updateDynamic("type")(`type`)
    __obj.asInstanceOf[CompositionEvent[T]]
  }
}

