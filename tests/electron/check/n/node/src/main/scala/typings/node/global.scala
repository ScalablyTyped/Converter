package typings.node

import typings.node.NodeJS.Process
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@JSGlobalScope
@js.native
object global extends js.Object {
  var process: Process = js.native
  @js.native
  object NodeJS extends js.Object {
    @js.native
    class EventEmitter ()
      extends typings.node.NodeJS.EventEmitter
    
  }
  
  @js.native
  object Symbol extends SymbolConstructor
  
}

