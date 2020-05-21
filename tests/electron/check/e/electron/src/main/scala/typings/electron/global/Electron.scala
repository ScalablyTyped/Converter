package typings.electron.global

import typings.electron.Electron.App
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@JSGlobal("Electron")
@js.native
object Electron extends js.Object {
  @js.native
  class EventEmitter ()
    extends typings.electron.Electron.EventEmitter
  
  val app: App = js.native
}

