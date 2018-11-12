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

