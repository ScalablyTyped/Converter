package typings.electron

import typings.electron.Electron.App
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@JSImport("electron", JSImport.Namespace)
@js.native
object mod extends js.Object {
  @js.native
  class EventEmitter ()
    extends typings.electron.Electron.EventEmitter
  
  @JSName("app")
  val app_ : App = js.native
}

