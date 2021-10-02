package typings.fullcalendar

import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

object mod {
  
  @JSImport("fullcalendar/EmitterMixin", JSImport.Default)
  @js.native
  open class default () extends Default_
  
  @JSImport("fullcalendar/EmitterMixin", "Default")
  @js.native
  open class Default_ ()
    extends typings.fullcalendar.mixinMod.default
       with EmitterInterface {
    
    /* CompleteClass */
    override def on(types: js.Any, handler: js.Any): js.Any = js.native
  }
  
  trait EmitterInterface extends StObject {
    
    def on(types: js.Any, handler: js.Any): js.Any
  }
  object EmitterInterface {
    
    inline def apply(on: (js.Any, js.Any) => js.Any): EmitterInterface = {
      val __obj = js.Dynamic.literal(on = js.Any.fromFunction2(on))
      __obj.asInstanceOf[EmitterInterface]
    }
    
    extension [Self <: EmitterInterface](x: Self) {
      
      inline def setOn(value: (js.Any, js.Any) => js.Any): Self = StObject.set(x, "on", js.Any.fromFunction2(value))
    }
  }
}
