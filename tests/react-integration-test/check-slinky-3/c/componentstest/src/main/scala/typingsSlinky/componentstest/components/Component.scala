package typingsSlinky.componentstest.components

import _root_.typingsSlinky.StBuildingComponent
import _root_.typingsSlinky.StBuildingComponent.Default
import slinky.web.html.`*`.tag
import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

object Component {
  
  object A {
    
    inline def apply(aCallback: () => Double, aMember: Double): Default[tag.type, js.Object] = {
      val __props = js.Dynamic.literal(aCallback = js.Any.fromFunction0(aCallback), aMember = aMember.asInstanceOf[js.Any])
      new Default[tag.type, js.Object](js.Array(this.component, __props.asInstanceOf[_root_.typingsSlinky.componentstest.mod.A]))
    }
    
    @JSImport("componentstest", "Component")
    @js.native
    val component: js.Object = js.native
    
    type Props = _root_.typingsSlinky.componentstest.mod.A
    
    def withProps(p: _root_.typingsSlinky.componentstest.mod.A): Default[tag.type, js.Object] = new Default[tag.type, js.Object](js.Array(this.component, p.asInstanceOf[js.Any]))
  }
  
  object B {
    
    inline def apply(bMember: String): Builder = {
      val __props = js.Dynamic.literal(bMember = bMember.asInstanceOf[js.Any])
      new Builder(js.Array(this.component, __props.asInstanceOf[_root_.typingsSlinky.componentstest.mod.B]))
    }
    
    @JSImport("componentstest", "Component")
    @js.native
    val component: js.Object = js.native
    
    @scala.inline
    open class Builder (val args: js.Array[Any])
      extends AnyVal
         with StBuildingComponent[tag.type, js.Object] {
      
      inline def bCallback(value: () => String): this.type = set("bCallback", js.Any.fromFunction0(value))
    }
    
    type Props = _root_.typingsSlinky.componentstest.mod.B
    
    def withProps(p: _root_.typingsSlinky.componentstest.mod.B): Builder = new Builder(js.Array(this.component, p.asInstanceOf[js.Any]))
  }
}
