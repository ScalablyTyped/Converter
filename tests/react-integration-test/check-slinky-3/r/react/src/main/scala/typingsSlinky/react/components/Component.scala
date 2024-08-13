package typingsSlinky.react.components

import slinky.web.html.`*`.tag
import typingsSlinky.StBuildingComponent
import typingsSlinky.StBuildingComponent.Default
import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

object Component {
  
  object A {
    
    inline def apply(aCallback: () => Double, aMember: Double): Default[tag.type, js.Object] = {
      val __props = js.Dynamic.literal(aCallback = js.Any.fromFunction0(aCallback), aMember = aMember.asInstanceOf[js.Any])
      new Default[tag.type, js.Object](js.Array(this.component, __props.asInstanceOf[typingsSlinky.react.componentstestMod.A]))
    }
    
    @JSImport("react/componentstest", "Component")
    @js.native
    val component: js.Object = js.native
    
    type Props = typingsSlinky.react.componentstestMod.A
    
    def withProps(p: typingsSlinky.react.componentstestMod.A): Default[tag.type, js.Object] = new Default[tag.type, js.Object](js.Array(this.component, p.asInstanceOf[js.Any]))
  }
  
  object B {
    
    inline def apply(bMember: String): Builder = {
      val __props = js.Dynamic.literal(bMember = bMember.asInstanceOf[js.Any])
      new Builder(js.Array(this.component, __props.asInstanceOf[typingsSlinky.react.componentstestMod.B]))
    }
    
    @JSImport("react/componentstest", "Component")
    @js.native
    val component: js.Object = js.native
    
    @scala.inline
    open class Builder (val args: js.Array[Any])
      extends AnyVal
         with StBuildingComponent[tag.type, js.Object] {
      
      inline def bCallback(value: () => String): this.type = set("bCallback", js.Any.fromFunction0(value))
    }
    
    type Props = typingsSlinky.react.componentstestMod.B
    
    def withProps(p: typingsSlinky.react.componentstestMod.B): Builder = new Builder(js.Array(this.component, p.asInstanceOf[js.Any]))
  }
}
