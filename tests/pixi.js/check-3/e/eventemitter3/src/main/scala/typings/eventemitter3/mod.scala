package typings.eventemitter3

import org.scalablytyped.runtime.Instantiable0
import org.scalablytyped.runtime.Shortcut
import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

object mod extends Shortcut {
  
  @JSImport("eventemitter3", JSImport.Namespace)
  @js.native
  open class ^[EventTypes] ()
    extends StObject
       with typings.eventemitter3.mod.EventEmitter[EventTypes]
  @JSImport("eventemitter3", JSImport.Namespace)
  @js.native
  val ^ : EventEmitterStatic = js.native
  
  trait EventEmitter[EventTypes] extends StObject
  @JSImport("eventemitter3", "EventEmitter")
  @js.native
  val EventEmitter: EventEmitterStatic = js.native
  
  /* This class was inferred from a value with a constructor, it was renamed because a distinct type already exists with the same name. */
  @JSImport("eventemitter3", "EventEmitter")
  @js.native
  open class EventEmitterCls[EventTypes] ()
    extends StObject
       with typings.eventemitter3.mod.EventEmitter[EventTypes]
  
  @js.native
  trait EventEmitterStatic
    extends StObject
       with Instantiable0[typings.eventemitter3.mod.EventEmitter[js.Object]]
  
  type _To = EventEmitterStatic
  
  /* This means you don't have to write `^`, but can instead just say `mod.foo` */
  override def _to: EventEmitterStatic = ^
}
