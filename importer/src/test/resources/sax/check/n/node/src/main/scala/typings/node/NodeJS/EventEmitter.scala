package typings.node.NodeJS

import scala.scalajs.js.annotation.JSGlobal
import scala.scalajs.js
import scala.scalajs.js.`|`

@JSGlobal("NodeJS.EventEmitter")
@js.native
class EventEmitter () extends js.Object {
  def on(event: String, listener: js.Function1[/* repeated */ js.Any, Unit]): this.type = js.native
  def on(event: js.Symbol, listener: js.Function1[/* repeated */ js.Any, Unit]): this.type = js.native
}

