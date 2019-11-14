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
    __obj.updateDynamic("isDefaultPrevented")(isDefaultPrevented.toJsFn)
    __obj.updateDynamic("isPropagationStopped")(isPropagationStopped.toJsFn)
    __obj.updateDynamic("persist")(persist.toJsFn)
    __obj.updateDynamic("preventDefault")(preventDefault.toJsFn)
    __obj.updateDynamic("stopPropagation")(stopPropagation.toJsFn)
    __obj.updateDynamic("type")(`type`)
    __obj.asInstanceOf[UIEvent[T]]
  }
}

