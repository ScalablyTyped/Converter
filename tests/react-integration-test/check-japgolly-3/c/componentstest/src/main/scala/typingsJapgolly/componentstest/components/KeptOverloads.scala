package typingsJapgolly.componentstest.components

import japgolly.scalajs.react.facade.React.ElementType
import typingsJapgolly.StBuildingComponent
import typingsJapgolly.componentstest.keptOverloadsMod.KeptOverloadsProps
import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

object KeptOverloads {
  
  @JSImport("componentstest/KeptOverloads", "KeptOverloads")
  @js.native
  val component: js.Object = js.native
  
  @scala.inline
  open class Builder (val args: js.Array[Any])
    extends AnyVal
       with StBuildingComponent[js.Object] {
    
    inline def component(value: ElementType): this.type = set("component", value.asInstanceOf[js.Any])
    
    inline def disabled(value: Boolean): this.type = set("disabled", value.asInstanceOf[js.Any])
    
    inline def kept(value: Boolean): this.type = set("kept", value.asInstanceOf[js.Any])
    
    inline def label(value: String): this.type = set("label", value.asInstanceOf[js.Any])
  }
  
  type Props = KeptOverloadsProps
  
  implicit def make(companion: KeptOverloads.type): Builder = new Builder(js.Array(this.component, js.Dictionary.empty))()
  
  def withProps(p: KeptOverloadsProps): Builder = new Builder(js.Array(this.component, p.asInstanceOf[js.Any]))
}
