package typings.electron

import typings.electron.Electron.App
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@JSImport("electron", JSImport.Namespace)
@js.native
object electronMod extends js.Object {
  @js.native
  class EventEmitter ()
    extends typings.electron.Electron.EventEmitter
  
  val app: App = js.native
}

