package typings.pixiJs

import org.scalablytyped.runtime.Shortcut
import typings.eventemitter3.mod.EventEmitterStatic
import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

object mod {
  
  object utils {
    
    @JSImport("pixi.js", "utils.EventEmitter")
    @js.native
    open class EventEmitter[EventTypes] ()
      extends typings.pixiUtils.mod.EventEmitter[EventTypes]
    object EventEmitter extends Shortcut {
      
      @JSImport("pixi.js", "utils.EventEmitter")
      @js.native
      val ^ : js.Object & EventEmitterStatic = js.native
      @JSImport("pixi.js", "utils.EventEmitter.EventEmitter")
      @js.native
      val EventEmitter: EventEmitterStatic = js.native
      
      type _To = js.Object & EventEmitterStatic
      
      /* This means you don't have to write `^`, but can instead just say `EventEmitter.foo` */
      override def _to: js.Object & EventEmitterStatic = ^
    }
  }
}
