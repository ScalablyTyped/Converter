package typings.electron

import scala.scalajs.js.annotation.JSImport
import scala.scalajs.js.annotation.JSImport.Namespace
import typings.electron.Electron.App
import scala.scalajs.js
import scala.scalajs.js.`|`

@JSImport("electron", Namespace)
@js.native
object electronMod extends js.Object {
  @js.native
  class EventEmitter () extends typings.electron.Electron.EventEmitter
  
  val app: App = js.native
}

