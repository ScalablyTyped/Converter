package typingsJapgolly.react.mod

import japgolly.scalajs.react.Callback
import japgolly.scalajs.react.CallbackTo
import japgolly.scalajs.react.ReactMouseEventFrom
import org.scalajs.dom.raw.Element
import org.scalajs.dom.raw.EventTarget
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@js.native
trait MouseEvent[T, E] extends BaseSyntheticEvent[E, EventTarget with T, EventTarget] {
  var altKey: Boolean = js.native
  var button: Double = js.native
  var buttons: Double = js.native
  var clientX: Double = js.native
  var clientY: Double = js.native
  var ctrlKey: Boolean = js.native
  var metaKey: Boolean = js.native
  var movementX: Double = js.native
  var movementY: Double = js.native
  var pageX: Double = js.native
  var pageY: Double = js.native
  var relatedTarget: EventTarget = js.native
  var screenX: Double = js.native
  var screenY: Double = js.native
  var shiftKey: Boolean = js.native
  /**
    * See [DOM Level 3 Events spec](https://www.w3.org/TR/uievents-key/#keys-modifier). for a list of valid (case-sensitive) arguments to this method.
    */
  def getModifierState(key: String): Boolean = js.native
}

object MouseEvent {
  @scala.inline
  def apply[T, E](
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
    isDefaultPrevented: CallbackTo[Boolean],
    isPropagationStopped: CallbackTo[Boolean],
    isTrusted: Boolean,
    metaKey: Boolean,
    movementX: Double,
    movementY: Double,
    nativeEvent: E,
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
  ): MouseEvent[T, E] = {
    val __obj = js.Dynamic.literal(altKey = altKey.asInstanceOf[js.Any], bubbles = bubbles.asInstanceOf[js.Any], button = button.asInstanceOf[js.Any], buttons = buttons.asInstanceOf[js.Any], cancelable = cancelable.asInstanceOf[js.Any], clientX = clientX.asInstanceOf[js.Any], clientY = clientY.asInstanceOf[js.Any], ctrlKey = ctrlKey.asInstanceOf[js.Any], currentTarget = currentTarget.asInstanceOf[js.Any], defaultPrevented = defaultPrevented.asInstanceOf[js.Any], eventPhase = eventPhase.asInstanceOf[js.Any], getModifierState = js.Any.fromFunction1((t0: String) => getModifierState(t0).runNow()), isDefaultPrevented = isDefaultPrevented.toJsFn, isPropagationStopped = isPropagationStopped.toJsFn, isTrusted = isTrusted.asInstanceOf[js.Any], metaKey = metaKey.asInstanceOf[js.Any], movementX = movementX.asInstanceOf[js.Any], movementY = movementY.asInstanceOf[js.Any], nativeEvent = nativeEvent.asInstanceOf[js.Any], pageX = pageX.asInstanceOf[js.Any], pageY = pageY.asInstanceOf[js.Any], persist = persist.toJsFn, preventDefault = preventDefault.toJsFn, relatedTarget = relatedTarget.asInstanceOf[js.Any], screenX = screenX.asInstanceOf[js.Any], screenY = screenY.asInstanceOf[js.Any], shiftKey = shiftKey.asInstanceOf[js.Any], stopPropagation = stopPropagation.toJsFn, target = target.asInstanceOf[js.Any], timeStamp = timeStamp.asInstanceOf[js.Any])
    __obj.updateDynamic("type")(`type`.asInstanceOf[js.Any])
    __obj.asInstanceOf[MouseEvent[T, E]]
  }
  @scala.inline
  implicit class MouseEventOps[Self <: ReactMouseEventFrom[Element], T, E] (val x: Self with (ReactMouseEventFrom[T with Element])) extends AnyVal {
    @scala.inline
    def duplicate: Self = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x)).asInstanceOf[Self]
    @scala.inline
    def combineWith[Other <: js.Any](other: Other): Self with Other = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x, other.asInstanceOf[js.Any])).asInstanceOf[Self with Other]
    @scala.inline
    def set(key: String, value: js.Any): Self = {
        x.asInstanceOf[js.Dynamic].updateDynamic(key)(value)
        x
    }
    @scala.inline
    def setAltKey(value: Boolean): Self = this.set("altKey", value.asInstanceOf[js.Any])
    @scala.inline
    def setButton(value: Double): Self = this.set("button", value.asInstanceOf[js.Any])
    @scala.inline
    def setButtons(value: Double): Self = this.set("buttons", value.asInstanceOf[js.Any])
    @scala.inline
    def setClientX(value: Double): Self = this.set("clientX", value.asInstanceOf[js.Any])
    @scala.inline
    def setClientY(value: Double): Self = this.set("clientY", value.asInstanceOf[js.Any])
    @scala.inline
    def setCtrlKey(value: Boolean): Self = this.set("ctrlKey", value.asInstanceOf[js.Any])
    @scala.inline
    def setGetModifierState(value: String => CallbackTo[Boolean]): Self = this.set("getModifierState", js.Any.fromFunction1((t0: String) => value(t0).runNow()))
    @scala.inline
    def setMetaKey(value: Boolean): Self = this.set("metaKey", value.asInstanceOf[js.Any])
    @scala.inline
    def setMovementX(value: Double): Self = this.set("movementX", value.asInstanceOf[js.Any])
    @scala.inline
    def setMovementY(value: Double): Self = this.set("movementY", value.asInstanceOf[js.Any])
    @scala.inline
    def setPageX(value: Double): Self = this.set("pageX", value.asInstanceOf[js.Any])
    @scala.inline
    def setPageY(value: Double): Self = this.set("pageY", value.asInstanceOf[js.Any])
    @scala.inline
    def setRelatedTarget(value: EventTarget): Self = this.set("relatedTarget", value.asInstanceOf[js.Any])
    @scala.inline
    def setScreenX(value: Double): Self = this.set("screenX", value.asInstanceOf[js.Any])
    @scala.inline
    def setScreenY(value: Double): Self = this.set("screenY", value.asInstanceOf[js.Any])
    @scala.inline
    def setShiftKey(value: Boolean): Self = this.set("shiftKey", value.asInstanceOf[js.Any])
  }
  
}

