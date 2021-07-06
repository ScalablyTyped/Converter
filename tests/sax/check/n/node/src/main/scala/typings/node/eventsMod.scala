package typings.node

import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

object eventsMod {
  
  @JSImport("events", JSImport.Namespace)
  @js.native
  class ^ ()
    extends StObject
       with typings.node.NodeJS.EventEmitter
  
  @JSImport("events", "EventEmitter")
  @js.native
  class EventEmitter ()
    extends StObject
       with typings.node.NodeJS.EventEmitter
  /* static members */
  object EventEmitter {
    
    @JSImport("events", "EventEmitter")
    @js.native
    val ^ : js.Any = js.native
    
    @scala.inline
    def listenerCount(emitter: EventEmitter, event: String): Double = (^.asInstanceOf[js.Dynamic].applyDynamic("listenerCount")(emitter.asInstanceOf[js.Any], event.asInstanceOf[js.Any])).asInstanceOf[Double]
    @scala.inline
    def listenerCount(emitter: EventEmitter, event: js.Symbol): Double = (^.asInstanceOf[js.Dynamic].applyDynamic("listenerCount")(emitter.asInstanceOf[js.Any], event.asInstanceOf[js.Any])).asInstanceOf[Double]
  }
  
  type internal = typings.node.NodeJS.EventEmitter
}
