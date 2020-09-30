package typingsSlinky.componentstest.components

import slinky.web.html.`*`.tag
import typingsSlinky.StBuildingComponent
import typingsSlinky.StBuildingComponent.Default
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

object Component {
  object A {
    @JSImport("componentstest", "Component")
    @js.native
    object component extends js.Object
    
    def withProps(p: typingsSlinky.componentstest.mod.A): Default[tag.type, js.Object] = new Default[tag.type, js.Object](js.Array(this.component, p.asInstanceOf[js.Any]))
    @scala.inline
    def apply(aCallback: () => Double, aMember: Double): Default[tag.type, js.Object] = {
        val __props = js.Dynamic.literal(aCallback = js.Any.fromFunction0(aCallback), aMember = aMember.asInstanceOf[js.Any])
        new Default[tag.type, js.Object](js.Array(this.component, __props.asInstanceOf[typingsSlinky.componentstest.mod.A]))
    }
  }
  
  object B {
    @JSImport("componentstest", "Component")
    @js.native
    object component extends js.Object
    
    @scala.inline
    class Builder (val args: js.Array[js.Any])
      extends AnyVal
         with StBuildingComponent[tag.type, js.Object] {
      @scala.inline
      def bCallback(value: () => String): this.type = set("bCallback", js.Any.fromFunction0(value))
    }
    
    def withProps(p: typingsSlinky.componentstest.mod.B): Builder = new Builder(js.Array(this.component, p.asInstanceOf[js.Any]))
    @scala.inline
    def apply(bMember: String): Builder = {
        val __props = js.Dynamic.literal(bMember = bMember.asInstanceOf[js.Any])
        new Builder(js.Array(this.component, __props.asInstanceOf[typingsSlinky.componentstest.mod.B]))
    }
  }
  
}

