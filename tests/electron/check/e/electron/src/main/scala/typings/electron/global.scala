package typings.electron

import typings.electron.Electron.App
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

object global {
  
  object Electron {
    
    @JSGlobal("Electron.app")
    @js.native
    val app: App = js.native
    
    @JSGlobal("Electron.EventEmitter")
    @js.native
    class EventEmitter ()
      extends typings.electron.Electron.EventEmitter
  }
}
