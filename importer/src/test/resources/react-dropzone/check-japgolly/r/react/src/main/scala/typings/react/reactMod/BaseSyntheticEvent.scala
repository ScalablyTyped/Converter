package typings.react.reactMod

import japgolly.scalajs.react.Callback
import japgolly.scalajs.react.CallbackTo
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

//
// Event System
// ----------------------------------------------------------------------
// TODO: change any to unknown when moving to TS v3
trait BaseSyntheticEvent[E, C, T] extends js.Object {
  var bubbles: Boolean
  var cancelable: Boolean
  var currentTarget: C
  var defaultPrevented: Boolean
  var eventPhase: Double
  var isTrusted: Boolean
  var nativeEvent: E
  var target: T
  var timeStamp: Double
  var `type`: String
  def isDefaultPrevented(): Boolean
  def isPropagationStopped(): Boolean
  def persist(): Unit
  def preventDefault(): Unit
  def stopPropagation(): Unit
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
    val __obj = js.Dynamic.literal(bubbles = bubbles, cancelable = cancelable, currentTarget = currentTarget.asInstanceOf[js.Any], defaultPrevented = defaultPrevented, eventPhase = eventPhase, isTrusted = isTrusted, nativeEvent = nativeEvent.asInstanceOf[js.Any], target = target.asInstanceOf[js.Any], timeStamp = timeStamp)
    __obj.updateDynamic("isDefaultPrevented")(js.Any.fromFunction0((() => isDefaultPrevented.runNow())))
    __obj.updateDynamic("isPropagationStopped")(js.Any.fromFunction0((() => isPropagationStopped.runNow())))
    __obj.updateDynamic("persist")(js.Any.fromFunction0((() => persist.runNow())))
    __obj.updateDynamic("preventDefault")(js.Any.fromFunction0((() => preventDefault.runNow())))
    __obj.updateDynamic("stopPropagation")(js.Any.fromFunction0((() => stopPropagation.runNow())))
    __obj.updateDynamic("type")(`type`)
    __obj.asInstanceOf[BaseSyntheticEvent[E, C, T]]
  }
}

