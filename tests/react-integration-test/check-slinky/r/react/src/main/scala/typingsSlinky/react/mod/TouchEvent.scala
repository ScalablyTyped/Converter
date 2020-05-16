package typingsSlinky.react.mod

import org.scalajs.dom.raw.Event
import org.scalajs.dom.raw.EventTarget
import slinky.web.SyntheticTouchEvent
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@js.native
trait TouchEvent[T] extends BaseSyntheticEvent[Event, EventTarget with T, EventTarget] {
  var altKey: Boolean = js.native
  var changedTouches: TouchList = js.native
  var ctrlKey: Boolean = js.native
  var metaKey: Boolean = js.native
  var shiftKey: Boolean = js.native
  var targetTouches: TouchList = js.native
  var touches: TouchList = js.native
  /**
    * See [DOM Level 3 Events spec](https://www.w3.org/TR/uievents-key/#keys-modifier). for a list of valid (case-sensitive) arguments to this method.
    */
  def getModifierState(key: String): Boolean = js.native
}

object TouchEvent {
  @scala.inline
  def apply[T](
    altKey: Boolean,
    bubbles: Boolean,
    cancelable: Boolean,
    changedTouches: TouchList,
    ctrlKey: Boolean,
    currentTarget: EventTarget with T,
    defaultPrevented: Boolean,
    eventPhase: Double,
    getModifierState: String => Boolean,
    isDefaultPrevented: () => Boolean,
    isPropagationStopped: () => Boolean,
    isTrusted: Boolean,
    metaKey: Boolean,
    nativeEvent: Event,
    persist: () => Unit,
    preventDefault: () => Unit,
    shiftKey: Boolean,
    stopPropagation: () => Unit,
    target: EventTarget,
    targetTouches: TouchList,
    timeStamp: Double,
    touches: TouchList,
    `type`: String
  ): TouchEvent[T] = {
    val __obj = js.Dynamic.literal(altKey = altKey.asInstanceOf[js.Any], bubbles = bubbles.asInstanceOf[js.Any], cancelable = cancelable.asInstanceOf[js.Any], changedTouches = changedTouches.asInstanceOf[js.Any], ctrlKey = ctrlKey.asInstanceOf[js.Any], currentTarget = currentTarget.asInstanceOf[js.Any], defaultPrevented = defaultPrevented.asInstanceOf[js.Any], eventPhase = eventPhase.asInstanceOf[js.Any], getModifierState = js.Any.fromFunction1(getModifierState), isDefaultPrevented = js.Any.fromFunction0(isDefaultPrevented), isPropagationStopped = js.Any.fromFunction0(isPropagationStopped), isTrusted = isTrusted.asInstanceOf[js.Any], metaKey = metaKey.asInstanceOf[js.Any], nativeEvent = nativeEvent.asInstanceOf[js.Any], persist = js.Any.fromFunction0(persist), preventDefault = js.Any.fromFunction0(preventDefault), shiftKey = shiftKey.asInstanceOf[js.Any], stopPropagation = js.Any.fromFunction0(stopPropagation), target = target.asInstanceOf[js.Any], targetTouches = targetTouches.asInstanceOf[js.Any], timeStamp = timeStamp.asInstanceOf[js.Any], touches = touches.asInstanceOf[js.Any])
    __obj.updateDynamic("type")(`type`.asInstanceOf[js.Any])
    __obj.asInstanceOf[TouchEvent[T]]
  }
  @scala.inline
  implicit class TouchEventOps[Self[t] <: SyntheticTouchEvent[t], T] (val x: Self[T]) extends AnyVal {
    @scala.inline
    def duplicate: Self[T] = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x)).asInstanceOf[Self[T]]
    @scala.inline
    def combineWith[Other /* <: js.Any */](other: Other): Self[T] with Other = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x, other.asInstanceOf[js.Any])).asInstanceOf[Self[T] with Other]
    @scala.inline
    def withAltKey(altKey: Boolean): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        ret.updateDynamic("altKey")(altKey.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withChangedTouches(changedTouches: TouchList): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        ret.updateDynamic("changedTouches")(changedTouches.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withCtrlKey(ctrlKey: Boolean): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        ret.updateDynamic("ctrlKey")(ctrlKey.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withGetModifierState(getModifierState: String => Boolean): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        ret.updateDynamic("getModifierState")(js.Any.fromFunction1(getModifierState))
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withMetaKey(metaKey: Boolean): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        ret.updateDynamic("metaKey")(metaKey.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withShiftKey(shiftKey: Boolean): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        ret.updateDynamic("shiftKey")(shiftKey.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withTargetTouches(targetTouches: TouchList): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        ret.updateDynamic("targetTouches")(targetTouches.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withTouches(touches: TouchList): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        ret.updateDynamic("touches")(touches.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[T]]
    }
  }
  
}

