package typings
package nodeLib.NodeJSNs

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@JSGlobal("NodeJS.EventEmitter")
@js.native
class EventEmitter () extends js.Object {
  def emit(event: java.lang.String, args: js.Any*): scala.Boolean = js.native
  def emit(event: js.Symbol, args: js.Any*): scala.Boolean = js.native
}

