package typingsSlinky.react.mod

import org.scalajs.dom.raw.Event
import org.scalajs.dom.raw.EventTarget
import slinky.web.SyntheticAnimationEvent
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@js.native
trait AnimationEvent[T] extends BaseSyntheticEvent[Event, EventTarget with T, EventTarget] {
  var animationName: String = js.native
  var elapsedTime: Double = js.native
  var pseudoElement: String = js.native
}

object AnimationEvent {
  @scala.inline
  def apply[T](
    animationName: String,
    bubbles: Boolean,
    cancelable: Boolean,
    currentTarget: EventTarget with T,
    defaultPrevented: Boolean,
    elapsedTime: Double,
    eventPhase: Double,
    isDefaultPrevented: () => Boolean,
    isPropagationStopped: () => Boolean,
    isTrusted: Boolean,
    nativeEvent: Event,
    persist: () => Unit,
    preventDefault: () => Unit,
    pseudoElement: String,
    stopPropagation: () => Unit,
    target: EventTarget,
    timeStamp: Double,
    `type`: String
  ): AnimationEvent[T] = {
    val __obj = js.Dynamic.literal(animationName = animationName.asInstanceOf[js.Any], bubbles = bubbles.asInstanceOf[js.Any], cancelable = cancelable.asInstanceOf[js.Any], currentTarget = currentTarget.asInstanceOf[js.Any], defaultPrevented = defaultPrevented.asInstanceOf[js.Any], elapsedTime = elapsedTime.asInstanceOf[js.Any], eventPhase = eventPhase.asInstanceOf[js.Any], isDefaultPrevented = js.Any.fromFunction0(isDefaultPrevented), isPropagationStopped = js.Any.fromFunction0(isPropagationStopped), isTrusted = isTrusted.asInstanceOf[js.Any], nativeEvent = nativeEvent.asInstanceOf[js.Any], persist = js.Any.fromFunction0(persist), preventDefault = js.Any.fromFunction0(preventDefault), pseudoElement = pseudoElement.asInstanceOf[js.Any], stopPropagation = js.Any.fromFunction0(stopPropagation), target = target.asInstanceOf[js.Any], timeStamp = timeStamp.asInstanceOf[js.Any])
    __obj.updateDynamic("type")(`type`.asInstanceOf[js.Any])
    __obj.asInstanceOf[AnimationEvent[T]]
  }
  @scala.inline
  implicit class AnimationEventOps[Self <: SyntheticAnimationEvent[_], T] (val x: Self with SyntheticAnimationEvent[T]) extends AnyVal {
    @scala.inline
    def duplicate: Self = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x)).asInstanceOf[Self]
    @scala.inline
    def combineWith[Other <: js.Any](other: Other): Self with Other = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x, other.asInstanceOf[js.Any])).asInstanceOf[Self with Other]
    @scala.inline
    def withAnimationName(value: String): Self = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("animationName")(value.asInstanceOf[js.Any])
        ret
    }
    @scala.inline
    def withElapsedTime(value: Double): Self = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("elapsedTime")(value.asInstanceOf[js.Any])
        ret
    }
    @scala.inline
    def withPseudoElement(value: String): Self = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("pseudoElement")(value.asInstanceOf[js.Any])
        ret
    }
  }
  
}

