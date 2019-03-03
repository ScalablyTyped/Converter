package typings
package electronLib.ElectronNs

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

trait Event
  extends stdLib.Event {
  var altKey: js.UndefOr[scala.Boolean] = js.undefined
  var ctrlKey: js.UndefOr[scala.Boolean] = js.undefined
  var metaKey: js.UndefOr[scala.Boolean] = js.undefined
  var returnValue: js.Any
  var shiftKey: js.UndefOr[scala.Boolean] = js.undefined
  def preventDefault(): scala.Unit
}

object Event {
  @scala.inline
  def apply(
    preventDefault: () => scala.Unit,
    returnValue: js.Any,
    altKey: js.UndefOr[scala.Boolean] = js.undefined,
    ctrlKey: js.UndefOr[scala.Boolean] = js.undefined,
    metaKey: js.UndefOr[scala.Boolean] = js.undefined,
    shiftKey: js.UndefOr[scala.Boolean] = js.undefined
  ): Event = {
    val __obj = js.Dynamic.literal(preventDefault = js.Any.fromFunction0(preventDefault), returnValue = returnValue)
    if (!js.isUndefined(altKey)) __obj.updateDynamic("altKey")(altKey)
    if (!js.isUndefined(ctrlKey)) __obj.updateDynamic("ctrlKey")(ctrlKey)
    if (!js.isUndefined(metaKey)) __obj.updateDynamic("metaKey")(metaKey)
    if (!js.isUndefined(shiftKey)) __obj.updateDynamic("shiftKey")(shiftKey)
    __obj.asInstanceOf[Event]
  }
}

