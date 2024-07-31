package typingsJapgolly.componentstest.components

import _root_.typingsJapgolly.StBuildingComponent
import _root_.typingsJapgolly.StBuildingComponent.Default
import japgolly.scalajs.react.CallbackTo
import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

object Component {
  
  object A {
    
    inline def apply(aCallback: CallbackTo[Double], aMember: Double): Default[js.Object] = {
      val __props = js.Dynamic.literal(aCallback = aCallback.toJsFn, aMember = aMember.asInstanceOf[js.Any])
      new Default[js.Object](js.Array(this.component, __props.asInstanceOf[_root_.typingsJapgolly.componentstest.mod.A]))
    }
    
    @JSImport("componentstest", "Component")
    @js.native
    val component: js.Object = js.native
    
    type Props = _root_.typingsJapgolly.componentstest.mod.A
    
    def withProps(p: _root_.typingsJapgolly.componentstest.mod.A): Default[js.Object] = new Default[js.Object](js.Array(this.component, p.asInstanceOf[js.Any]))
  }
  
  object B {
    
    inline def apply(bMember: String): Builder = {
      val __props = js.Dynamic.literal(bMember = bMember.asInstanceOf[js.Any])
      new Builder(js.Array(this.component, __props.asInstanceOf[_root_.typingsJapgolly.componentstest.mod.B]))
    }
    
    @JSImport("componentstest", "Component")
    @js.native
    val component: js.Object = js.native
    
    @scala.inline
    open class Builder (val args: js.Array[Any])
      extends AnyVal
         with StBuildingComponent[js.Object] {
      
      inline def bCallback(value: CallbackTo[String]): this.type = set("bCallback", value.toJsFn)
    }
    
    type Props = _root_.typingsJapgolly.componentstest.mod.B
    
    def withProps(p: _root_.typingsJapgolly.componentstest.mod.B): Builder = new Builder(js.Array(this.component, p.asInstanceOf[js.Any]))
  }
}
