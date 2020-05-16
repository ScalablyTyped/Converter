package typingsJapgolly.react.mod

import japgolly.scalajs.react.Callback
import japgolly.scalajs.react.CallbackTo
import japgolly.scalajs.react.ReactEventFrom
import org.scalajs.dom.raw.Element
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

//
// Event System
// ----------------------------------------------------------------------
// TODO: change any to unknown when moving to TS v3
@js.native
trait BaseSyntheticEvent[E, C, T] extends js.Object {
  var bubbles: Boolean = js.native
  var cancelable: Boolean = js.native
  var currentTarget: C = js.native
  var defaultPrevented: Boolean = js.native
  var eventPhase: Double = js.native
  var isTrusted: Boolean = js.native
  var nativeEvent: E = js.native
  var target: T = js.native
  var timeStamp: Double = js.native
  var `type`: String = js.native
  def isDefaultPrevented(): Boolean = js.native
  def isPropagationStopped(): Boolean = js.native
  def persist(): Unit = js.native
  def preventDefault(): Unit = js.native
  def stopPropagation(): Unit = js.native
}

object BaseSyntheticEvent {
  @scala.inline
  def apply[E, C, T](
    bubbles: Boolean,
    cancelable: Boolean,
    currentTarget: C,
    defaultPrevented: Boolean,
    eventPhase: Double,
    isDefaultPrevented: CallbackTo[Boolean],
    isPropagationStopped: CallbackTo[Boolean],
    isTrusted: Boolean,
    nativeEvent: E,
    persist: Callback,
    preventDefault: Callback,
    stopPropagation: Callback,
    target: T,
    timeStamp: Double,
    `type`: String
  ): BaseSyntheticEvent[E, C, T] = {
    val __obj = js.Dynamic.literal(bubbles = bubbles.asInstanceOf[js.Any], cancelable = cancelable.asInstanceOf[js.Any], currentTarget = currentTarget.asInstanceOf[js.Any], defaultPrevented = defaultPrevented.asInstanceOf[js.Any], eventPhase = eventPhase.asInstanceOf[js.Any], isTrusted = isTrusted.asInstanceOf[js.Any], nativeEvent = nativeEvent.asInstanceOf[js.Any], target = target.asInstanceOf[js.Any], timeStamp = timeStamp.asInstanceOf[js.Any])
    __obj.updateDynamic("isDefaultPrevented")(isDefaultPrevented.toJsFn)
    __obj.updateDynamic("isPropagationStopped")(isPropagationStopped.toJsFn)
    __obj.updateDynamic("persist")(persist.toJsFn)
    __obj.updateDynamic("preventDefault")(preventDefault.toJsFn)
    __obj.updateDynamic("stopPropagation")(stopPropagation.toJsFn)
    __obj.updateDynamic("type")(`type`.asInstanceOf[js.Any])
    __obj.asInstanceOf[BaseSyntheticEvent[E, C, T]]
  }
  @scala.inline
  implicit class BaseSyntheticEventOps[Self[e, c, t] <: ReactEventFrom[c with Element], E, C, T] (val x: Self[E, C, T]) extends AnyVal {
    @scala.inline
    def duplicate: Self[E, C, T] = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x)).asInstanceOf[Self[E, C, T]]
    @scala.inline
    def combineWith[Other /* <: js.Any */](other: Other): (Self[E, C, T]) with Other = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x, other.asInstanceOf[js.Any])).asInstanceOf[(Self[E, C, T]) with Other]
    @scala.inline
    def withBubbles(bubbles: Boolean): Self[E, C, T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        ret.updateDynamic("bubbles")(bubbles.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[E, C, T]]
    }
    @scala.inline
    def withCancelable(cancelable: Boolean): Self[E, C, T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        ret.updateDynamic("cancelable")(cancelable.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[E, C, T]]
    }
    @scala.inline
    def withCurrentTarget(currentTarget: C): Self[E, C, T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        ret.updateDynamic("currentTarget")(currentTarget.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[E, C, T]]
    }
    @scala.inline
    def withDefaultPrevented(defaultPrevented: Boolean): Self[E, C, T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        ret.updateDynamic("defaultPrevented")(defaultPrevented.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[E, C, T]]
    }
    @scala.inline
    def withEventPhase(eventPhase: Double): Self[E, C, T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        ret.updateDynamic("eventPhase")(eventPhase.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[E, C, T]]
    }
    @scala.inline
    def withIsDefaultPrevented(isDefaultPrevented: CallbackTo[Boolean]): Self[E, C, T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        ret.updateDynamic("isDefaultPrevented")(isDefaultPrevented.toJsFn)
        ret.asInstanceOf[Self[E, C, T]]
    }
    @scala.inline
    def withIsPropagationStopped(isPropagationStopped: CallbackTo[Boolean]): Self[E, C, T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        ret.updateDynamic("isPropagationStopped")(isPropagationStopped.toJsFn)
        ret.asInstanceOf[Self[E, C, T]]
    }
    @scala.inline
    def withIsTrusted(isTrusted: Boolean): Self[E, C, T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        ret.updateDynamic("isTrusted")(isTrusted.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[E, C, T]]
    }
    @scala.inline
    def withNativeEvent(nativeEvent: E): Self[E, C, T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        ret.updateDynamic("nativeEvent")(nativeEvent.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[E, C, T]]
    }
    @scala.inline
    def withPersist(persist: Callback): Self[E, C, T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        ret.updateDynamic("persist")(persist.toJsFn)
        ret.asInstanceOf[Self[E, C, T]]
    }
    @scala.inline
    def withPreventDefault(preventDefault: Callback): Self[E, C, T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        ret.updateDynamic("preventDefault")(preventDefault.toJsFn)
        ret.asInstanceOf[Self[E, C, T]]
    }
    @scala.inline
    def withStopPropagation(stopPropagation: Callback): Self[E, C, T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        ret.updateDynamic("stopPropagation")(stopPropagation.toJsFn)
        ret.asInstanceOf[Self[E, C, T]]
    }
    @scala.inline
    def withTarget(target: T): Self[E, C, T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        ret.updateDynamic("target")(target.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[E, C, T]]
    }
    @scala.inline
    def withTimeStamp(timeStamp: Double): Self[E, C, T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        ret.updateDynamic("timeStamp")(timeStamp.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[E, C, T]]
    }
    @scala.inline
    def withType(`type`: String): Self[E, C, T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        ret.updateDynamic("type")(`type`.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[E, C, T]]
    }
  }
  
}

