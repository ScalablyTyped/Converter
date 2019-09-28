package typings.electron.Electron

import scala.scalajs.js.annotation.JSGlobal
import scala.scalajs.js
import scala.scalajs.js.`|`

@JSGlobal("Electron.EventEmitter")
@js.native
class EventEmitter () extends js.Object {
  def addListener(event: String, listener: js.Function): this.type = js.native
}

