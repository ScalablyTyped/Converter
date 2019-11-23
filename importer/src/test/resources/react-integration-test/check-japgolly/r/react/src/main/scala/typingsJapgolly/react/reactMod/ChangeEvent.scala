package typingsJapgolly.react.reactMod

import japgolly.scalajs.react.Callback
import japgolly.scalajs.react.CallbackTo
import typingsJapgolly.std.Event
import typingsJapgolly.std.EventTarget
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

trait ChangeEvent[T] extends BaseSyntheticEvent[Event, EventTarget with T, EventTarget] {
  @JSName("target")
  var target_ChangeEvent: org.scalajs.dom.raw.EventTarget with T
}

object ChangeEvent {
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
    nativeEvent: org.scalajs.dom.raw.Event,
    persist: Callback,
    preventDefault: Callback,
    stopPropagation: Callback,
    target: org.scalajs.dom.raw.EventTarget with T,
    timeStamp: Double,
    `type`: String
  ): ChangeEvent[T] = {
    val __obj = js.Dynamic.literal(bubbles = bubbles.asInstanceOf[js.Any], cancelable = cancelable.asInstanceOf[js.Any], currentTarget = currentTarget.asInstanceOf[js.Any], defaultPrevented = defaultPrevented.asInstanceOf[js.Any], eventPhase = eventPhase.asInstanceOf[js.Any], isTrusted = isTrusted.asInstanceOf[js.Any], nativeEvent = nativeEvent.asInstanceOf[js.Any], target = target.asInstanceOf[js.Any], timeStamp = timeStamp.asInstanceOf[js.Any])
    __obj.updateDynamic("isDefaultPrevented")(isDefaultPrevented.toJsFn)
    __obj.updateDynamic("isPropagationStopped")(isPropagationStopped.toJsFn)
    __obj.updateDynamic("persist")(persist.toJsFn)
    __obj.updateDynamic("preventDefault")(preventDefault.toJsFn)
    __obj.updateDynamic("stopPropagation")(stopPropagation.toJsFn)
    __obj.updateDynamic("type")(`type`.asInstanceOf[js.Any])
    __obj.asInstanceOf[ChangeEvent[T]]
  }
}

