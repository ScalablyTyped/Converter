package typings.electron

import typings.electron.Electron.App
import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

object global {
  
  object Electron {
    
    @JSGlobal("Electron.EventEmitter")
    @js.native
    open class EventEmitter ()
      extends StObject
         with typings.electron.Electron.EventEmitter {
      
      /* CompleteClass */
      override def addListener(event: String, listener: js.Function): this.type = js.native
    }
    
    @JSGlobal("Electron.app")
    @js.native
    val app: App = js.native
  }
}
