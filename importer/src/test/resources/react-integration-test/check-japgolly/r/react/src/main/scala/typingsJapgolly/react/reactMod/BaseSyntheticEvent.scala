package typingsJapgolly.react.reactMod

import japgolly.scalajs.react.Callback
import japgolly.scalajs.react.CallbackTo
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
}

