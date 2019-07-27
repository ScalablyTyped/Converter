package typings.electron.ElectronNs

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

trait Event
  extends typings.std.Event {
  var altKey: js.UndefOr[Boolean] = js.undefined
  var ctrlKey: js.UndefOr[Boolean] = js.undefined
  var metaKey: js.UndefOr[Boolean] = js.undefined
  var returnValue: js.Any
  var shiftKey: js.UndefOr[Boolean] = js.undefined
  def preventDefault(): Unit
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
    val __obj = js.Dynamic.literal(preventDefault = js.Any.fromFunction0(preventDefault), returnValue = returnValue)
    if (!js.isUndefined(altKey)) __obj.updateDynamic("altKey")(altKey)
    if (!js.isUndefined(ctrlKey)) __obj.updateDynamic("ctrlKey")(ctrlKey)
    if (!js.isUndefined(metaKey)) __obj.updateDynamic("metaKey")(metaKey)
    if (!js.isUndefined(shiftKey)) __obj.updateDynamic("shiftKey")(shiftKey)
    __obj.asInstanceOf[Event]
  }
}

