package typings.electron

import typings.electron.Electron.App
import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

object mod {
  
  @JSImport("electron", "EventEmitter")
  @js.native
  class EventEmitter ()
    extends StObject
       with typings.electron.Electron.EventEmitter
  
  @JSImport("electron", "app")
  @js.native
  val app: App = js.native
}
