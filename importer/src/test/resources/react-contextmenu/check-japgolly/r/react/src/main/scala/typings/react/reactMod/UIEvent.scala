package typings.react.reactMod

import japgolly.scalajs.react.Callback
import japgolly.scalajs.react.CallbackTo
import org.scalajs.dom.raw.Event
import typings.react.NativeUIEvent
import typings.std.EventTarget
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

trait UIEvent[T] extends BaseSyntheticEvent[NativeUIEvent, EventTarget with T, EventTarget] {
  var detail: Double
  var view: AbstractView
}

object UIEvent {
  @scala.inline
  def apply[T](
    bubbles: Boolean,
    cancelable: Boolean,
    currentTarget: org.scalajs.dom.raw.EventTarget with T,
    defaultPrevented: Boolean,
    detail: Double,
    eventPhase: Double,
    isDefaultPrevented: CallbackTo[Boolean],
    isPropagationStopped: CallbackTo[Boolean],
    isTrusted: Boolean,
    nativeEvent: Event,
    persist: Callback,
    preventDefault: Callback,
    stopPropagation: Callback,
    target: org.scalajs.dom.raw.EventTarget,
    timeStamp: Double,
    `type`: String,
    view: AbstractView
  ): UIEvent[T] = {
    val __obj = js.Dynamic.literal(bubbles = bubbles, cancelable = cancelable, currentTarget = currentTarget, defaultPrevented = defaultPrevented, detail = detail, eventPhase = eventPhase, isTrusted = isTrusted, nativeEvent = nativeEvent, target = target, timeStamp = timeStamp, view = view)
    __obj.updateDynamic("isDefaultPrevented")(js.Any.fromFunction0((() => isDefaultPrevented.runNow())))
    __obj.updateDynamic("isPropagationStopped")(js.Any.fromFunction0((() => isPropagationStopped.runNow())))
    __obj.updateDynamic("persist")(js.Any.fromFunction0((() => persist.runNow())))
    __obj.updateDynamic("preventDefault")(js.Any.fromFunction0((() => preventDefault.runNow())))
    __obj.updateDynamic("stopPropagation")(js.Any.fromFunction0((() => stopPropagation.runNow())))
    __obj.updateDynamic("type")(`type`)
    __obj.asInstanceOf[UIEvent[T]]
  }
}

