package typings.react.reactMod

import japgolly.scalajs.react.Callback
import japgolly.scalajs.react.CallbackTo
import org.scalajs.dom.raw.Event
import typings.react.NativeFocusEvent
import typings.std.EventTarget
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

trait FocusEvent[T] extends BaseSyntheticEvent[NativeFocusEvent, EventTarget with T, EventTarget] {
  var relatedTarget: org.scalajs.dom.raw.EventTarget
  @JSName("target")
  var target_FocusEvent: org.scalajs.dom.raw.EventTarget with T
}

object FocusEvent {
  @scala.inline
  def apply[T](
    bubbles: Boolean,
    cancelable: Boolean,
    currentTarget: org.scalajs.dom.raw.EventTarget with T,
    defaultPrevented: Boolean,
    eventPhase: Double,
    isDefaultPrevented: CallbackTo[Boolean],
    isPropagationStopped: CallbackTo[Boolean],
    isTrusted: Boolean,
    nativeEvent: Event,
    persist: Callback,
    preventDefault: Callback,
    relatedTarget: org.scalajs.dom.raw.EventTarget,
    stopPropagation: Callback,
    target: org.scalajs.dom.raw.EventTarget with T,
    timeStamp: Double,
    `type`: String
  ): FocusEvent[T] = {
    val __obj = js.Dynamic.literal(bubbles = bubbles, cancelable = cancelable, currentTarget = currentTarget, defaultPrevented = defaultPrevented, eventPhase = eventPhase, isTrusted = isTrusted, nativeEvent = nativeEvent, relatedTarget = relatedTarget, target = target, timeStamp = timeStamp)
    __obj.updateDynamic("isDefaultPrevented")(js.Any.fromFunction0((() => isDefaultPrevented.runNow())))
    __obj.updateDynamic("isPropagationStopped")(js.Any.fromFunction0((() => isPropagationStopped.runNow())))
    __obj.updateDynamic("persist")(js.Any.fromFunction0((() => persist.runNow())))
    __obj.updateDynamic("preventDefault")(js.Any.fromFunction0((() => preventDefault.runNow())))
    __obj.updateDynamic("stopPropagation")(js.Any.fromFunction0((() => stopPropagation.runNow())))
    __obj.updateDynamic("type")(`type`)
    __obj.asInstanceOf[FocusEvent[T]]
  }
}

