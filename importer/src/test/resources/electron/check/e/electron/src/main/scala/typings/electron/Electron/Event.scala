package typings.electron.Electron

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@js.native
trait Event
  extends typings.std.Event {
  var altKey: js.UndefOr[Boolean] = js.native
  var ctrlKey: js.UndefOr[Boolean] = js.native
  var metaKey: js.UndefOr[Boolean] = js.native
  var returnValue: js.Any = js.native
  var shiftKey: js.UndefOr[Boolean] = js.native
  def preventDefault(): Unit = js.native
}

object Event {
  @scala.inline
  def apply(
    preventDefault: () => Unit,
    returnValue: js.Any,
    altKey: js.UndefOr[Boolean] = js.undefined,
    ctrlKey: js.UndefOr[Boolean] = js.undefined,
    metaKey: js.UndefOr[Boolean] = js.undefined,
    shiftKey: js.UndefOr[Boolean] = js.undefined
  ): Event = {
    val __obj = js.Dynamic.literal(preventDefault = js.Any.fromFunction0(preventDefault), returnValue = returnValue.asInstanceOf[js.Any])
    if (!js.isUndefined(altKey)) __obj.updateDynamic("altKey")(altKey.asInstanceOf[js.Any])
    if (!js.isUndefined(ctrlKey)) __obj.updateDynamic("ctrlKey")(ctrlKey.asInstanceOf[js.Any])
    if (!js.isUndefined(metaKey)) __obj.updateDynamic("metaKey")(metaKey.asInstanceOf[js.Any])
    if (!js.isUndefined(shiftKey)) __obj.updateDynamic("shiftKey")(shiftKey.asInstanceOf[js.Any])
    __obj.asInstanceOf[Event]
  }
}

