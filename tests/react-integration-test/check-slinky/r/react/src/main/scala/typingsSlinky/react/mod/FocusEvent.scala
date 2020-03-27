package typingsSlinky.react.mod

import org.scalajs.dom.raw.Event
import typingsSlinky.std.EventTarget
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@js.native
trait FocusEvent[T] extends BaseSyntheticEvent[NativeFocusEvent, EventTarget with T, EventTarget] {
  var relatedTarget: org.scalajs.dom.raw.EventTarget = js.native
  @JSName("target")
  var target_FocusEvent: org.scalajs.dom.raw.EventTarget with T = js.native
}

object FocusEvent {
  @scala.inline
  def apply[T](
    bubbles: Boolean,
    cancelable: Boolean,
    currentTarget: org.scalajs.dom.raw.EventTarget with T,
    defaultPrevented: Boolean,
    eventPhase: Double,
    isDefaultPrevented: () => Boolean,
    isPropagationStopped: () => Boolean,
    isTrusted: Boolean,
    nativeEvent: Event,
    persist: () => Unit,
    preventDefault: () => Unit,
    relatedTarget: org.scalajs.dom.raw.EventTarget,
    stopPropagation: () => Unit,
    target: org.scalajs.dom.raw.EventTarget with T,
    timeStamp: Double,
    `type`: String
  ): FocusEvent[T] = {
    val __obj = js.Dynamic.literal(bubbles = bubbles.asInstanceOf[js.Any], cancelable = cancelable.asInstanceOf[js.Any], currentTarget = currentTarget.asInstanceOf[js.Any], defaultPrevented = defaultPrevented.asInstanceOf[js.Any], eventPhase = eventPhase.asInstanceOf[js.Any], isDefaultPrevented = js.Any.fromFunction0(isDefaultPrevented), isPropagationStopped = js.Any.fromFunction0(isPropagationStopped), isTrusted = isTrusted.asInstanceOf[js.Any], nativeEvent = nativeEvent.asInstanceOf[js.Any], persist = js.Any.fromFunction0(persist), preventDefault = js.Any.fromFunction0(preventDefault), relatedTarget = relatedTarget.asInstanceOf[js.Any], stopPropagation = js.Any.fromFunction0(stopPropagation), target = target.asInstanceOf[js.Any], timeStamp = timeStamp.asInstanceOf[js.Any])
    __obj.updateDynamic("type")(`type`.asInstanceOf[js.Any])
    __obj.asInstanceOf[FocusEvent[T]]
  }
}

