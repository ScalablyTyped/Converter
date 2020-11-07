package typings.electron

import typings.electron.Electron.App
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

@JSImport("electron", JSImport.Namespace)
@js.native
object mod extends js.Object {
  val app: App = js.native
  @js.native
  class EventEmitter ()
    extends typings.electron.Electron.EventEmitter
  
}

