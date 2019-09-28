package typings.node.NodeJS

import scala.scalajs.js.annotation.JSGlobal
import scala.scalajs.js
import scala.scalajs.js.`|`

@JSGlobal("NodeJS.EventEmitter")
@js.native
class EventEmitter () extends js.Object {
  def emit(event: String, args: js.Any*): Boolean = js.native
  def emit(event: js.Symbol, args: js.Any*): Boolean = js.native
}

