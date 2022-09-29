package typings.pixiUtils

import org.scalablytyped.runtime.Shortcut
import typings.eventemitter3.mod.EventEmitterStatic
import typings.eventemitter3.mod.^
import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

object mod {
  
  @JSImport("@pixi/utils", "EventEmitter")
  @js.native
  open class EventEmitter[EventTypes] () extends ^[EventTypes]
  object EventEmitter extends Shortcut {
    
    /* This class was inferred from a value with a constructor. In rare cases (like HTMLElement in the DOM) it might not work as you expect. */
    @JSImport("@pixi/utils", "EventEmitter")
    @js.native
    open class ^[EventTypes] ()
      extends StObject
         with typings.eventemitter3.mod.EventEmitter[EventTypes]
    
    @JSImport("@pixi/utils", "EventEmitter")
    @js.native
    val ^ : js.Object & EventEmitterStatic = js.native
    @JSImport("@pixi/utils", "EventEmitter.EventEmitter")
    @js.native
    val EventEmitter: EventEmitterStatic = js.native
    
    /* This class was inferred from a value with a constructor, it was renamed because a distinct type already exists with the same name. */
    @JSImport("@pixi/utils", "EventEmitter.EventEmitter")
    @js.native
    open class EventEmitterCls[EventTypes] ()
      extends StObject
         with typings.eventemitter3.mod.EventEmitter[EventTypes]
    
    type _To = js.Object & EventEmitterStatic
    
    /* This means you don't have to write `^`, but can instead just say `EventEmitter.foo` */
    override def _to: js.Object & EventEmitterStatic = ^
  }
}
