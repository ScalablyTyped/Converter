package typings.react.mod

import typings.std.DataTransfer
import typings.std.EventTarget
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@js.native
trait ClipboardEvent[T] extends BaseSyntheticEvent[NativeClipboardEvent, EventTarget with T, EventTarget] {
  var clipboardData: DataTransfer = js.native
}

object ClipboardEvent {
  @scala.inline
  def apply[T](
    bubbles: Boolean,
    cancelable: Boolean,
    clipboardData: DataTransfer,
    currentTarget: EventTarget with T,
    defaultPrevented: Boolean,
    eventPhase: Double,
    isDefaultPrevented: () => Boolean,
    isPropagationStopped: () => Boolean,
    isTrusted: Boolean,
    nativeEvent: NativeClipboardEvent,
    persist: () => Unit,
    preventDefault: () => Unit,
    stopPropagation: () => Unit,
    target: EventTarget,
    timeStamp: Double,
    `type`: String
  ): ClipboardEvent[T] = {
    val __obj = js.Dynamic.literal(bubbles = bubbles.asInstanceOf[js.Any], cancelable = cancelable.asInstanceOf[js.Any], clipboardData = clipboardData.asInstanceOf[js.Any], currentTarget = currentTarget.asInstanceOf[js.Any], defaultPrevented = defaultPrevented.asInstanceOf[js.Any], eventPhase = eventPhase.asInstanceOf[js.Any], isDefaultPrevented = js.Any.fromFunction0(isDefaultPrevented), isPropagationStopped = js.Any.fromFunction0(isPropagationStopped), isTrusted = isTrusted.asInstanceOf[js.Any], nativeEvent = nativeEvent.asInstanceOf[js.Any], persist = js.Any.fromFunction0(persist), preventDefault = js.Any.fromFunction0(preventDefault), stopPropagation = js.Any.fromFunction0(stopPropagation), target = target.asInstanceOf[js.Any], timeStamp = timeStamp.asInstanceOf[js.Any])
    __obj.updateDynamic("type")(`type`.asInstanceOf[js.Any])
    __obj.asInstanceOf[ClipboardEvent[T]]
  }
  @scala.inline
  implicit class ClipboardEventOps[Self[t] <: ClipboardEvent[t], T] (val x: Self[T]) extends AnyVal {
    @scala.inline
    def duplicate: Self[T] = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x)).asInstanceOf[Self[T]]
    @scala.inline
    def combineWith[Other <: js.Any](other: Other): Self[T] with Other = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x, other.asInstanceOf[js.Any])).asInstanceOf[Self[T] with Other]
    @scala.inline
    def withClipboardData(value: DataTransfer): Self[T] = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("clipboardData")(value.asInstanceOf[js.Any])
        ret
    }
  }
  
}

