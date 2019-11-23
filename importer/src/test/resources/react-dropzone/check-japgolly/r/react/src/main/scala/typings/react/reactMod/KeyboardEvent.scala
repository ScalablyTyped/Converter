package typings.react.reactMod

import japgolly.scalajs.react.Callback
import japgolly.scalajs.react.CallbackTo
import org.scalajs.dom.raw.Event
import typings.react.NativeKeyboardEvent
import typings.std.EventTarget
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

trait KeyboardEvent[T] extends BaseSyntheticEvent[NativeKeyboardEvent, EventTarget with T, EventTarget] {
  var altKey: Boolean
  var charCode: Double
  var ctrlKey: Boolean
  /**
    * See the [DOM Level 3 Events spec](https://www.w3.org/TR/uievents-key/#named-key-attribute-values). for possible values
    */
  var key: String
  var keyCode: Double
  var locale: String
  var location: Double
  var metaKey: Boolean
  var repeat: Boolean
  var shiftKey: Boolean
  var which: Double
  /**
    * See [DOM Level 3 Events spec](https://www.w3.org/TR/uievents-key/#keys-modifier). for a list of valid (case-sensitive) arguments to this method.
    */
  def getModifierState(key: String): Boolean
}

object KeyboardEvent {
  @scala.inline
  def apply[T](
    altKey: Boolean,
    bubbles: Boolean,
    cancelable: Boolean,
    charCode: Double,
    ctrlKey: Boolean,
    currentTarget: org.scalajs.dom.raw.EventTarget with T,
    defaultPrevented: Boolean,
    eventPhase: Double,
    getModifierState: String => CallbackTo[Boolean],
    isDefaultPrevented: CallbackTo[Boolean],
    isPropagationStopped: CallbackTo[Boolean],
    isTrusted: Boolean,
    key: String,
    keyCode: Double,
    locale: String,
    location: Double,
    metaKey: Boolean,
    nativeEvent: Event,
    persist: Callback,
    preventDefault: Callback,
    repeat: Boolean,
    shiftKey: Boolean,
    stopPropagation: Callback,
    target: org.scalajs.dom.raw.EventTarget,
    timeStamp: Double,
    `type`: String,
    which: Double
  ): KeyboardEvent[T] = {
    val __obj = js.Dynamic.literal(altKey = altKey, bubbles = bubbles, cancelable = cancelable, charCode = charCode, ctrlKey = ctrlKey, currentTarget = currentTarget, defaultPrevented = defaultPrevented, eventPhase = eventPhase, isTrusted = isTrusted, key = key, keyCode = keyCode, locale = locale, location = location, metaKey = metaKey, nativeEvent = nativeEvent, repeat = repeat, shiftKey = shiftKey, target = target, timeStamp = timeStamp, which = which)
    __obj.updateDynamic("getModifierState")(js.Any.fromFunction1(((t0: java.lang.String) => getModifierState(t0).runNow())))
    __obj.updateDynamic("isDefaultPrevented")(js.Any.fromFunction0((() => isDefaultPrevented.runNow())))
    __obj.updateDynamic("isPropagationStopped")(js.Any.fromFunction0((() => isPropagationStopped.runNow())))
    __obj.updateDynamic("persist")(js.Any.fromFunction0((() => persist.runNow())))
    __obj.updateDynamic("preventDefault")(js.Any.fromFunction0((() => preventDefault.runNow())))
    __obj.updateDynamic("stopPropagation")(js.Any.fromFunction0((() => stopPropagation.runNow())))
    __obj.updateDynamic("type")(`type`)
    __obj.asInstanceOf[KeyboardEvent[T]]
  }
}

