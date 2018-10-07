package ScalablyTyped
package ElectronLib.ElectronNamespace

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._


trait Event extends StdLib.Event {
  var altKey: js.UndefOr[scala.Boolean] = js.undefined
  var ctrlKey: js.UndefOr[scala.Boolean] = js.undefined
  var metaKey: js.UndefOr[scala.Boolean] = js.undefined
  var returnValue: js.Any
  var shiftKey: js.UndefOr[scala.Boolean] = js.undefined
  def preventDefault(): scala.Unit
}

