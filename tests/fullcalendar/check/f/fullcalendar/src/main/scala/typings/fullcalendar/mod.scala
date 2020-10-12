package typings.fullcalendar

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

object mod {
  
  @JSImport("fullcalendar/EmitterMixin", "Default")
  @js.native
  class Default_ ()
    extends typings.fullcalendar.mixinMod.default
       with EmitterInterface
  
  @js.native
  trait EmitterInterface extends js.Object {
    
    def on(types: js.Any, handler: js.Any): js.Any = js.native
  }
  object EmitterInterface {
    
    @scala.inline
    def apply(on: (js.Any, js.Any) => js.Any): EmitterInterface = {
      val __obj = js.Dynamic.literal(on = js.Any.fromFunction2(on))
      __obj.asInstanceOf[EmitterInterface]
    }
    
    @scala.inline
    implicit class EmitterInterfaceOps[Self <: EmitterInterface] (val x: Self) extends AnyVal {
      
      @scala.inline
      def duplicate: Self = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x)).asInstanceOf[Self]
      
      @scala.inline
      def combineWith[Other <: js.Any](other: Other): Self with Other = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x, other.asInstanceOf[js.Any])).asInstanceOf[Self with Other]
      
      @scala.inline
      def set(key: String, value: js.Any): Self = {
        x.asInstanceOf[js.Dynamic].updateDynamic(key)(value)
        x
      }
      
      @scala.inline
      def setOn(value: (js.Any, js.Any) => js.Any): Self = this.set("on", js.Any.fromFunction2(value))
    }
  }
  
  @JSImport("fullcalendar/EmitterMixin", JSImport.Default)
  @js.native
  class default () extends Default_
}
