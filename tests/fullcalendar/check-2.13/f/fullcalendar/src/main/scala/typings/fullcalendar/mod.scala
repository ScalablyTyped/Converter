package typings.fullcalendar

import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

object mod {
  
  @JSImport("fullcalendar/EmitterMixin", JSImport.Default)
  @js.native
  class default () extends Default_
  
  @JSImport("fullcalendar/EmitterMixin", "Default")
  @js.native
  class Default_ ()
    extends typings.fullcalendar.mixinMod.default
       with EmitterInterface
  
  @js.native
  trait EmitterInterface extends StObject {
    
    def on(types: js.Any, handler: js.Any): js.Any = js.native
  }
  object EmitterInterface {
    
    @scala.inline
    def apply(on: (js.Any, js.Any) => js.Any): EmitterInterface = {
      val __obj = js.Dynamic.literal(on = js.Any.fromFunction2(on))
      __obj.asInstanceOf[EmitterInterface]
    }
    
    @scala.inline
    implicit class EmitterInterfaceMutableBuilder[Self <: EmitterInterface] (val x: Self) extends AnyVal {
      
      @scala.inline
      def setOn(value: (js.Any, js.Any) => js.Any): Self = StObject.set(x, "on", js.Any.fromFunction2(value))
    }
  }
}
