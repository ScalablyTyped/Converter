package typingsJapgolly.react.reactMod

import japgolly.scalajs.react.Callback
import japgolly.scalajs.react.CallbackTo
import org.scalajs.dom.raw.Event
import org.scalajs.dom.raw.EventTarget
import typingsJapgolly.react.NativeWheelEvent
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

trait WheelEvent[T] extends MouseEvent[T, NativeWheelEvent] {
  var deltaMode: Double
  var deltaX: Double
  var deltaY: Double
  var deltaZ: Double
}

object WheelEvent {
  @scala.inline
  def apply[T](
    altKey: Boolean,
    bubbles: Boolean,
    button: Double,
    buttons: Double,
    cancelable: Boolean,
    clientX: Double,
    clientY: Double,
    ctrlKey: Boolean,
    currentTarget: EventTarget with T,
    defaultPrevented: Boolean,
    deltaMode: Double,
    deltaX: Double,
    deltaY: Double,
    deltaZ: Double,
    eventPhase: Double,
    getModifierState: String => CallbackTo[Boolean],
    isDefaultPrevented: CallbackTo[Boolean],
    isPropagationStopped: CallbackTo[Boolean],
    isTrusted: Boolean,
    metaKey: Boolean,
    movementX: Double,
    movementY: Double,
    nativeEvent: Event,
    pageX: Double,
    pageY: Double,
    persist: Callback,
    preventDefault: Callback,
    relatedTarget: EventTarget,
    screenX: Double,
    screenY: Double,
    shiftKey: Boolean,
    stopPropagation: Callback,
    target: EventTarget,
    timeStamp: Double,
    `type`: String
  ): WheelEvent[T] = {
    val __obj = js.Dynamic.literal(altKey = altKey.asInstanceOf[js.Any], bubbles = bubbles.asInstanceOf[js.Any], button = button.asInstanceOf[js.Any], buttons = buttons.asInstanceOf[js.Any], cancelable = cancelable.asInstanceOf[js.Any], clientX = clientX.asInstanceOf[js.Any], clientY = clientY.asInstanceOf[js.Any], ctrlKey = ctrlKey.asInstanceOf[js.Any], currentTarget = currentTarget.asInstanceOf[js.Any], defaultPrevented = defaultPrevented.asInstanceOf[js.Any], deltaMode = deltaMode.asInstanceOf[js.Any], deltaX = deltaX.asInstanceOf[js.Any], deltaY = deltaY.asInstanceOf[js.Any], deltaZ = deltaZ.asInstanceOf[js.Any], eventPhase = eventPhase.asInstanceOf[js.Any], isTrusted = isTrusted.asInstanceOf[js.Any], metaKey = metaKey.asInstanceOf[js.Any], movementX = movementX.asInstanceOf[js.Any], movementY = movementY.asInstanceOf[js.Any], nativeEvent = nativeEvent.asInstanceOf[js.Any], pageX = pageX.asInstanceOf[js.Any], pageY = pageY.asInstanceOf[js.Any], relatedTarget = relatedTarget.asInstanceOf[js.Any], screenX = screenX.asInstanceOf[js.Any], screenY = screenY.asInstanceOf[js.Any], shiftKey = shiftKey.asInstanceOf[js.Any], target = target.asInstanceOf[js.Any], timeStamp = timeStamp.asInstanceOf[js.Any])
    __obj.updateDynamic("getModifierState")(js.Any.fromFunction1((t0: java.lang.String) => getModifierState(t0).runNow()))
    __obj.updateDynamic("isDefaultPrevented")(isDefaultPrevented.toJsFn)
    __obj.updateDynamic("isPropagationStopped")(isPropagationStopped.toJsFn)
    __obj.updateDynamic("persist")(persist.toJsFn)
    __obj.updateDynamic("preventDefault")(preventDefault.toJsFn)
    __obj.updateDynamic("stopPropagation")(stopPropagation.toJsFn)
    __obj.updateDynamic("type")(`type`.asInstanceOf[js.Any])
    __obj.asInstanceOf[WheelEvent[T]]
  }
}

