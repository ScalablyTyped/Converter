package ScalablyTyped
package ElectronLib.ElectronNamespace

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

/* RemoveDifficultStuff */
trait Event extends StdLib.Event {
  val altKey: js.UndefOr[scala.Boolean] = js.undefined
  val ctrlKey: js.UndefOr[scala.Boolean] = js.undefined
  val metaKey: js.UndefOr[scala.Boolean] = js.undefined
  val returnValue: js.Any
  val shiftKey: js.UndefOr[scala.Boolean] = js.undefined
  def preventDefault(): scala.Unit
}

