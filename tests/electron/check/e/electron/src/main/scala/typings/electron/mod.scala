package typings.electron

import typings.electron.Electron.App
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

object mod {
  
  @JSImport("electron", "app")
  @js.native
  val app: App = js.native
  
  @JSImport("electron", "EventEmitter")
  @js.native
  class EventEmitter ()
    extends typings.electron.Electron.EventEmitter
}
