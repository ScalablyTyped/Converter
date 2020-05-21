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
    val __obj = js.Dynamic.literal(altKey = altKey.asInstanceOf[js.Any], bubbles = bubbles.asInstanceOf[js.Any], button = button.asInstanceOf[js.Any], buttons = buttons.asInstanceOf[js.Any], cancelable = cancelable.asInstanceOf[js.Any], clientX = clientX.asInstanceOf[js.Any], clientY = clientY.asInstanceOf[js.Any], ctrlKey = ctrlKey.asInstanceOf[js.Any], currentTarget = currentTarget.asInstanceOf[js.Any], defaultPrevented = defaultPrevented.asInstanceOf[js.Any], eventPhase = eventPhase.asInstanceOf[js.Any], isTrusted = isTrusted.asInstanceOf[js.Any], metaKey = metaKey.asInstanceOf[js.Any], movementX = movementX.asInstanceOf[js.Any], movementY = movementY.asInstanceOf[js.Any], nativeEvent = nativeEvent.asInstanceOf[js.Any], pageX = pageX.asInstanceOf[js.Any], pageY = pageY.asInstanceOf[js.Any], relatedTarget = relatedTarget.asInstanceOf[js.Any], screenX = screenX.asInstanceOf[js.Any], screenY = screenY.asInstanceOf[js.Any], shiftKey = shiftKey.asInstanceOf[js.Any], target = target.asInstanceOf[js.Any], timeStamp = timeStamp.asInstanceOf[js.Any])
    __obj.updateDynamic("getModifierState")(js.Any.fromFunction1((t0: String) => getModifierState(t0).runNow()))
    __obj.updateDynamic("isDefaultPrevented")(isDefaultPrevented.toJsFn)
    __obj.updateDynamic("isPropagationStopped")(isPropagationStopped.toJsFn)
    __obj.updateDynamic("persist")(persist.toJsFn)
    __obj.updateDynamic("preventDefault")(preventDefault.toJsFn)
    __obj.updateDynamic("stopPropagation")(stopPropagation.toJsFn)
    __obj.updateDynamic("type")(`type`.asInstanceOf[js.Any])
    __obj.asInstanceOf[MouseEvent[T, E]]
  }
  @scala.inline
  implicit class MouseEventOps[Self[t, e] <: ReactMouseEventFrom[t with Element], T, E] (val x: Self[T, E]) extends AnyVal {
    @scala.inline
    def duplicate: Self[T, E] = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x)).asInstanceOf[Self[T, E]]
    @scala.inline
    def combineWith[Other /* <: js.Any */](other: Other): (Self[T, E]) with Other = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x, other.asInstanceOf[js.Any])).asInstanceOf[(Self[T, E]) with Other]
    @scala.inline
    def withAltKey(altKey: Boolean): Self[T, E] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        ret.updateDynamic("altKey")(altKey.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[T, E]]
    }
    @scala.inline
    def withButton(button: Double): Self[T, E] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        ret.updateDynamic("button")(button.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[T, E]]
    }
    @scala.inline
    def withButtons(buttons: Double): Self[T, E] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        ret.updateDynamic("buttons")(buttons.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[T, E]]
    }
    @scala.inline
    def withClientX(clientX: Double): Self[T, E] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        ret.updateDynamic("clientX")(clientX.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[T, E]]
    }
    @scala.inline
    def withClientY(clientY: Double): Self[T, E] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        ret.updateDynamic("clientY")(clientY.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[T, E]]
    }
    @scala.inline
    def withCtrlKey(ctrlKey: Boolean): Self[T, E] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        ret.updateDynamic("ctrlKey")(ctrlKey.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[T, E]]
    }
    @scala.inline
    def withGetModifierState(getModifierState: String => CallbackTo[Boolean]): Self[T, E] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        ret.updateDynamic("getModifierState")(js.Any.fromFunction1((t0: String) => getModifierState(t0).runNow()))
        ret.asInstanceOf[Self[T, E]]
    }
    @scala.inline
    def withMetaKey(metaKey: Boolean): Self[T, E] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        ret.updateDynamic("metaKey")(metaKey.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[T, E]]
    }
    @scala.inline
    def withMovementX(movementX: Double): Self[T, E] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        ret.updateDynamic("movementX")(movementX.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[T, E]]
    }
    @scala.inline
    def withMovementY(movementY: Double): Self[T, E] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        ret.updateDynamic("movementY")(movementY.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[T, E]]
    }
    @scala.inline
    def withPageX(pageX: Double): Self[T, E] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        ret.updateDynamic("pageX")(pageX.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[T, E]]
    }
    @scala.inline
    def withPageY(pageY: Double): Self[T, E] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        ret.updateDynamic("pageY")(pageY.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[T, E]]
    }
    @scala.inline
    def withRelatedTarget(relatedTarget: EventTarget): Self[T, E] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        ret.updateDynamic("relatedTarget")(relatedTarget.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[T, E]]
    }
    @scala.inline
    def withScreenX(screenX: Double): Self[T, E] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        ret.updateDynamic("screenX")(screenX.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[T, E]]
    }
    @scala.inline
    def withScreenY(screenY: Double): Self[T, E] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        ret.updateDynamic("screenY")(screenY.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[T, E]]
    }
    @scala.inline
    def withShiftKey(shiftKey: Boolean): Self[T, E] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        ret.updateDynamic("shiftKey")(shiftKey.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[T, E]]
    }
  }
  
}

