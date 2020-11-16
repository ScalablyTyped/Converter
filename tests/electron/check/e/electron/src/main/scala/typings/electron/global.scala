package typings.electron

import typings.electron.Electron.App
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

@JSGlobalScope
@js.native
object global extends js.Object {
  
  @js.native
  object Electron extends js.Object {
    
    val app: App = js.native
    
    @js.native
    class EventEmitter ()
      extends typings.electron.Electron.EventEmitter
  }
}
