package typings.react.mod

import typings.std.EventTarget
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@js.native
trait FocusEvent[T] extends BaseSyntheticEvent[NativeFocusEvent, EventTarget with T, EventTarget] {
  var relatedTarget: EventTarget = js.native
  @JSName("target")
  var target_FocusEvent: EventTarget with T = js.native
}

object FocusEvent {
  @scala.inline
  def apply[T](
    bubbles: Boolean,
    cancelable: Boolean,
    currentTarget: EventTarget with T,
    defaultPrevented: Boolean,
    eventPhase: Double,
    isDefaultPrevented: () => Boolean,
    isPropagationStopped: () => Boolean,
    isTrusted: Boolean,
    nativeEvent: NativeFocusEvent,
    persist: () => Unit,
    preventDefault: () => Unit,
    relatedTarget: EventTarget,
    stopPropagation: () => Unit,
    target: EventTarget with T,
    timeStamp: Double,
    `type`: String
  ): FocusEvent[T] = {
    val __obj = js.Dynamic.literal(bubbles = bubbles.asInstanceOf[js.Any], cancelable = cancelable.asInstanceOf[js.Any], currentTarget = currentTarget.asInstanceOf[js.Any], defaultPrevented = defaultPrevented.asInstanceOf[js.Any], eventPhase = eventPhase.asInstanceOf[js.Any], isDefaultPrevented = js.Any.fromFunction0(isDefaultPrevented), isPropagationStopped = js.Any.fromFunction0(isPropagationStopped), isTrusted = isTrusted.asInstanceOf[js.Any], nativeEvent = nativeEvent.asInstanceOf[js.Any], persist = js.Any.fromFunction0(persist), preventDefault = js.Any.fromFunction0(preventDefault), relatedTarget = relatedTarget.asInstanceOf[js.Any], stopPropagation = js.Any.fromFunction0(stopPropagation), target = target.asInstanceOf[js.Any], timeStamp = timeStamp.asInstanceOf[js.Any])
    __obj.updateDynamic("type")(`type`.asInstanceOf[js.Any])
    __obj.asInstanceOf[FocusEvent[T]]
  }
  @scala.inline
  implicit class FocusEventOps[Self[t] <: FocusEvent[t], T] (val x: Self[T]) extends AnyVal {
    @scala.inline
    def duplicate: Self[T] = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x)).asInstanceOf[Self[T]]
    @scala.inline
    def combineWith[Other /* <: js.Any */](other: Other): Self[T] with Other = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x, other.asInstanceOf[js.Any])).asInstanceOf[Self[T] with Other]
    @scala.inline
    def withRelatedTarget(relatedTarget: EventTarget): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        ret.updateDynamic("relatedTarget")(relatedTarget.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withTarget(target: EventTarget with T): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        ret.updateDynamic("target")(target.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[T]]
    }
  }
  
}

