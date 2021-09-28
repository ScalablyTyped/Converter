package typings.node

import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

object eventsMod {
  
  @JSImport("events", JSImport.Namespace)
  @js.native
  open class ^ ()
    extends StObject
       with typings.node.NodeJS.EventEmitter
  
  @JSImport("events", "EventEmitter")
  @js.native
  open class EventEmitter ()
    extends StObject
       with typings.node.NodeJS.EventEmitter
  /* static members */
  object EventEmitter {
    
    @JSImport("events", "EventEmitter")
    @js.native
    val ^ : js.Any = js.native
    
    inline def listenerCount(emitter: EventEmitter, event: String): Double = (^.asInstanceOf[js.Dynamic].applyDynamic("listenerCount")(emitter.asInstanceOf[js.Any], event.asInstanceOf[js.Any])).asInstanceOf[Double]
    inline def listenerCount(emitter: EventEmitter, event: js.Symbol): Double = (^.asInstanceOf[js.Dynamic].applyDynamic("listenerCount")(emitter.asInstanceOf[js.Any], event.asInstanceOf[js.Any])).asInstanceOf[Double]
  }
  
  type internal = typings.node.NodeJS.EventEmitter
}
