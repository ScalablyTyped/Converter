package typingsJapgolly.react.mod

import japgolly.scalajs.react.Callback
import japgolly.scalajs.react.CallbackTo
import japgolly.scalajs.react.ReactPointerEventFrom
import org.scalajs.dom.raw.Element
import org.scalajs.dom.raw.Event
import org.scalajs.dom.raw.EventTarget
import typingsJapgolly.react.reactStrings.mouse
import typingsJapgolly.react.reactStrings.pen
import typingsJapgolly.react.reactStrings.touch
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@js.native
trait PointerEvent[T] extends MouseEvent[T, Event] {
  var height: Double = js.native
  var isPrimary: Boolean = js.native
  var pointerId: Double = js.native
  var pointerType: mouse | pen | touch = js.native
  var pressure: Double = js.native
  var tiltX: Double = js.native
  var tiltY: Double = js.native
  var width: Double = js.native
}

object PointerEvent {
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
    eventPhase: Double,
    getModifierState: String => CallbackTo[Boolean],
    height: Double,
    isDefaultPrevented: CallbackTo[Boolean],
    isPrimary: Boolean,
    isPropagationStopped: CallbackTo[Boolean],
    isTrusted: Boolean,
    metaKey: Boolean,
    movementX: Double,
    movementY: Double,
    nativeEvent: Event,
    pageX: Double,
    pageY: Double,
    persist: Callback,
    pointerId: Double,
    pointerType: mouse | pen | touch,
    pressure: Double,
    preventDefault: Callback,
    relatedTarget: EventTarget,
    screenX: Double,
    screenY: Double,
    shiftKey: Boolean,
    stopPropagation: Callback,
    target: EventTarget,
    tiltX: Double,
    tiltY: Double,
    timeStamp: Double,
    `type`: String,
    width: Double
  ): PointerEvent[T] = {
    val __obj = js.Dynamic.literal(altKey = altKey.asInstanceOf[js.Any], bubbles = bubbles.asInstanceOf[js.Any], button = button.asInstanceOf[js.Any], buttons = buttons.asInstanceOf[js.Any], cancelable = cancelable.asInstanceOf[js.Any], clientX = clientX.asInstanceOf[js.Any], clientY = clientY.asInstanceOf[js.Any], ctrlKey = ctrlKey.asInstanceOf[js.Any], currentTarget = currentTarget.asInstanceOf[js.Any], defaultPrevented = defaultPrevented.asInstanceOf[js.Any], eventPhase = eventPhase.asInstanceOf[js.Any], height = height.asInstanceOf[js.Any], isPrimary = isPrimary.asInstanceOf[js.Any], isTrusted = isTrusted.asInstanceOf[js.Any], metaKey = metaKey.asInstanceOf[js.Any], movementX = movementX.asInstanceOf[js.Any], movementY = movementY.asInstanceOf[js.Any], nativeEvent = nativeEvent.asInstanceOf[js.Any], pageX = pageX.asInstanceOf[js.Any], pageY = pageY.asInstanceOf[js.Any], pointerId = pointerId.asInstanceOf[js.Any], pointerType = pointerType.asInstanceOf[js.Any], pressure = pressure.asInstanceOf[js.Any], relatedTarget = relatedTarget.asInstanceOf[js.Any], screenX = screenX.asInstanceOf[js.Any], screenY = screenY.asInstanceOf[js.Any], shiftKey = shiftKey.asInstanceOf[js.Any], target = target.asInstanceOf[js.Any], tiltX = tiltX.asInstanceOf[js.Any], tiltY = tiltY.asInstanceOf[js.Any], timeStamp = timeStamp.asInstanceOf[js.Any], width = width.asInstanceOf[js.Any])
    __obj.updateDynamic("getModifierState")(js.Any.fromFunction1((t0: String) => getModifierState(t0).runNow()))
    __obj.updateDynamic("isDefaultPrevented")(isDefaultPrevented.toJsFn)
    __obj.updateDynamic("isPropagationStopped")(isPropagationStopped.toJsFn)
    __obj.updateDynamic("persist")(persist.toJsFn)
    __obj.updateDynamic("preventDefault")(preventDefault.toJsFn)
    __obj.updateDynamic("stopPropagation")(stopPropagation.toJsFn)
    __obj.updateDynamic("type")(`type`.asInstanceOf[js.Any])
    __obj.asInstanceOf[PointerEvent[T]]
  }
  @scala.inline
  implicit class PointerEventOps[Self[t] <: ReactPointerEventFrom[t with Element], T] (val x: Self[T]) extends AnyVal {
    @scala.inline
    def duplicate: Self[T] = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x)).asInstanceOf[Self[T]]
    @scala.inline
    def combineWith[Other /* <: js.Any */](other: Other): Self[T] with Other = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x, other.asInstanceOf[js.Any])).asInstanceOf[Self[T] with Other]
    @scala.inline
    def withHeight(height: Double): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        ret.updateDynamic("height")(height.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withIsPrimary(isPrimary: Boolean): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        ret.updateDynamic("isPrimary")(isPrimary.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withPointerId(pointerId: Double): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        ret.updateDynamic("pointerId")(pointerId.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withPointerType(pointerType: mouse | pen | touch): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        ret.updateDynamic("pointerType")(pointerType.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withPressure(pressure: Double): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        ret.updateDynamic("pressure")(pressure.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withTiltX(tiltX: Double): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        ret.updateDynamic("tiltX")(tiltX.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withTiltY(tiltY: Double): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        ret.updateDynamic("tiltY")(tiltY.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withWidth(width: Double): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        ret.updateDynamic("width")(width.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[T]]
    }
  }
  
}

