package typings.react.mod

import typings.std.EventTarget
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@js.native
trait KeyboardEvent[T] extends BaseSyntheticEvent[NativeKeyboardEvent, EventTarget with T, EventTarget] {
  var altKey: Boolean = js.native
  var charCode: Double = js.native
  var ctrlKey: Boolean = js.native
  /**
    * See the [DOM Level 3 Events spec](https://www.w3.org/TR/uievents-key/#named-key-attribute-values). for possible values
    */
  var key: String = js.native
  var keyCode: Double = js.native
  var locale: String = js.native
  var location: Double = js.native
  var metaKey: Boolean = js.native
  var repeat: Boolean = js.native
  var shiftKey: Boolean = js.native
  var which: Double = js.native
  /**
    * See [DOM Level 3 Events spec](https://www.w3.org/TR/uievents-key/#keys-modifier). for a list of valid (case-sensitive) arguments to this method.
    */
  def getModifierState(key: String): Boolean = js.native
}

object KeyboardEvent {
  @scala.inline
  def apply[T](
    altKey: Boolean,
    bubbles: Boolean,
    cancelable: Boolean,
    charCode: Double,
    ctrlKey: Boolean,
    currentTarget: EventTarget with T,
    defaultPrevented: Boolean,
    eventPhase: Double,
    getModifierState: String => Boolean,
    isDefaultPrevented: () => Boolean,
    isPropagationStopped: () => Boolean,
    isTrusted: Boolean,
    key: String,
    keyCode: Double,
    locale: String,
    location: Double,
    metaKey: Boolean,
    nativeEvent: NativeKeyboardEvent,
    persist: () => Unit,
    preventDefault: () => Unit,
    repeat: Boolean,
    shiftKey: Boolean,
    stopPropagation: () => Unit,
    target: EventTarget,
    timeStamp: Double,
    `type`: String,
    which: Double
  ): KeyboardEvent[T] = {
    val __obj = js.Dynamic.literal(altKey = altKey.asInstanceOf[js.Any], bubbles = bubbles.asInstanceOf[js.Any], cancelable = cancelable.asInstanceOf[js.Any], charCode = charCode.asInstanceOf[js.Any], ctrlKey = ctrlKey.asInstanceOf[js.Any], currentTarget = currentTarget.asInstanceOf[js.Any], defaultPrevented = defaultPrevented.asInstanceOf[js.Any], eventPhase = eventPhase.asInstanceOf[js.Any], getModifierState = js.Any.fromFunction1(getModifierState), isDefaultPrevented = js.Any.fromFunction0(isDefaultPrevented), isPropagationStopped = js.Any.fromFunction0(isPropagationStopped), isTrusted = isTrusted.asInstanceOf[js.Any], key = key.asInstanceOf[js.Any], keyCode = keyCode.asInstanceOf[js.Any], locale = locale.asInstanceOf[js.Any], location = location.asInstanceOf[js.Any], metaKey = metaKey.asInstanceOf[js.Any], nativeEvent = nativeEvent.asInstanceOf[js.Any], persist = js.Any.fromFunction0(persist), preventDefault = js.Any.fromFunction0(preventDefault), repeat = repeat.asInstanceOf[js.Any], shiftKey = shiftKey.asInstanceOf[js.Any], stopPropagation = js.Any.fromFunction0(stopPropagation), target = target.asInstanceOf[js.Any], timeStamp = timeStamp.asInstanceOf[js.Any], which = which.asInstanceOf[js.Any])
    __obj.updateDynamic("type")(`type`.asInstanceOf[js.Any])
    __obj.asInstanceOf[KeyboardEvent[T]]
  }
  @scala.inline
  implicit class KeyboardEventOps[Self[t] <: KeyboardEvent[t], T] (val x: Self[T]) extends AnyVal {
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
    def withCharCode(charCode: Double): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        ret.updateDynamic("charCode")(charCode.asInstanceOf[js.Any])
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
    def withKey(key: String): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        ret.updateDynamic("key")(key.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withKeyCode(keyCode: Double): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        ret.updateDynamic("keyCode")(keyCode.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withLocale(locale: String): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        ret.updateDynamic("locale")(locale.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withLocation(location: Double): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        ret.updateDynamic("location")(location.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withMetaKey(metaKey: Boolean): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        ret.updateDynamic("metaKey")(metaKey.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withRepeat(repeat: Boolean): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        ret.updateDynamic("repeat")(repeat.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withShiftKey(shiftKey: Boolean): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        ret.updateDynamic("shiftKey")(shiftKey.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withWhich(which: Double): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        ret.updateDynamic("which")(which.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[T]]
    }
  }
  
}

