package typings.node

import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

object eventsMod {
  
  @JSImport("events", JSImport.Namespace)
  @js.native
  class ^ ()
    extends typings.node.NodeJS.EventEmitter
  
  @JSImport("events", "EventEmitter")
  @js.native
  class EventEmitter ()
    extends typings.node.NodeJS.EventEmitter
  /* static members */
  object EventEmitter {
    
    @JSImport("events", "EventEmitter.listenerCount")
    @js.native
    def listenerCount(emitter: EventEmitter, event: String): Double = js.native
    @JSImport("events", "EventEmitter.listenerCount")
    @js.native
    def listenerCount(emitter: EventEmitter, event: js.Symbol): Double = js.native
  }
  
  type internal = typings.node.NodeJS.EventEmitter
}
