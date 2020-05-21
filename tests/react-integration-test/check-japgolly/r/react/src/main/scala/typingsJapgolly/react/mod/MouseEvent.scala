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
    def withAltKey(value: Boolean): Self = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("altKey")(value.asInstanceOf[js.Any])
        ret
    }
    @scala.inline
    def withButton(value: Double): Self = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("button")(value.asInstanceOf[js.Any])
        ret
    }
    @scala.inline
    def withButtons(value: Double): Self = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("buttons")(value.asInstanceOf[js.Any])
        ret
    }
    @scala.inline
    def withClientX(value: Double): Self = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("clientX")(value.asInstanceOf[js.Any])
        ret
    }
    @scala.inline
    def withClientY(value: Double): Self = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("clientY")(value.asInstanceOf[js.Any])
        ret
    }
    @scala.inline
    def withCtrlKey(value: Boolean): Self = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("ctrlKey")(value.asInstanceOf[js.Any])
        ret
    }
    @scala.inline
    def withGetModifierState(value: String => CallbackTo[Boolean]): Self = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("getModifierState")(js.Any.fromFunction1((t0: String) => value(t0).runNow()))
        ret
    }
    @scala.inline
    def withMetaKey(value: Boolean): Self = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("metaKey")(value.asInstanceOf[js.Any])
        ret
    }
    @scala.inline
    def withMovementX(value: Double): Self = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("movementX")(value.asInstanceOf[js.Any])
        ret
    }
    @scala.inline
    def withMovementY(value: Double): Self = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("movementY")(value.asInstanceOf[js.Any])
        ret
    }
    @scala.inline
    def withPageX(value: Double): Self = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("pageX")(value.asInstanceOf[js.Any])
        ret
    }
    @scala.inline
    def withPageY(value: Double): Self = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("pageY")(value.asInstanceOf[js.Any])
        ret
    }
    @scala.inline
    def withRelatedTarget(value: EventTarget): Self = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("relatedTarget")(value.asInstanceOf[js.Any])
        ret
    }
    @scala.inline
    def withScreenX(value: Double): Self = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("screenX")(value.asInstanceOf[js.Any])
        ret
    }
    @scala.inline
    def withScreenY(value: Double): Self = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("screenY")(value.asInstanceOf[js.Any])
        ret
    }
    @scala.inline
    def withShiftKey(value: Boolean): Self = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("shiftKey")(value.asInstanceOf[js.Any])
        ret
    }
  }
  
}

