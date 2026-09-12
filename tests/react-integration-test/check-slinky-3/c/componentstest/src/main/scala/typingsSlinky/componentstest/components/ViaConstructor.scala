package typingsSlinky.componentstest.components

import slinky.web.html.`*`.tag
import typingsSlinky.StBuildingComponent
import typingsSlinky.componentstest.mod.FooProps
import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

object ViaConstructor {
  
  @JSImport("componentstest", "ViaConstructor")
  @js.native
  val component: js.Object = js.native
  
  @scala.inline
  open class Builder (val args: js.Array[Any])
    extends AnyVal
       with StBuildingComponent[tag.type, js.Object] {
    
    inline def disabled(value: Boolean): this.type = set("disabled", value.asInstanceOf[js.Any])
    
    inline def label(value: String): this.type = set("label", value.asInstanceOf[js.Any])
  }
  
  type Props = FooProps
  
  implicit def make(companion: ViaConstructor.type): Builder = new Builder(js.Array(this.component, js.Dictionary.empty))()
  
  def withProps(p: FooProps): Builder = new Builder(js.Array(this.component, p.asInstanceOf[js.Any]))
}
