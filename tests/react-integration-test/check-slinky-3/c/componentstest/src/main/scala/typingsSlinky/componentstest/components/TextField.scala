package typingsSlinky.componentstest.components

import slinky.web.html.`*`.tag
import typingsSlinky.StBuildingComponent
import typingsSlinky.componentstest.anon.`0`
import typingsSlinky.componentstest.componentstestStrings.variant
import typingsSlinky.componentstest.textFieldMod.TextFieldProps
import typingsSlinky.componentstest.textFieldMod.TextFieldVariants
import typingsSlinky.std.Omit
import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

object TextField {
  
  inline def apply[Variant /* <: TextFieldVariants */](): Builder[Variant] = {
    val __props = js.Dynamic.literal(variant = "filled")
    new Builder[Variant](js.Array(this.component, __props.asInstanceOf[`0`[Variant] & (Omit[TextFieldProps[TextFieldVariants], variant])]))
  }
  
  @JSImport("componentstest/TextField", JSImport.Default)
  @js.native
  val component: js.Object = js.native
  
  @scala.inline
  open class Builder[Variant /* <: TextFieldVariants */] (val args: js.Array[Any])
    extends AnyVal
       with StBuildingComponent[tag.type, js.Object] {
    
    inline def disabled(value: Boolean): this.type = set("disabled", value.asInstanceOf[js.Any])
    
    inline def label(value: String): this.type = set("label", value.asInstanceOf[js.Any])
  }
  
  type Props[Variant /* <: TextFieldVariants */] = `0`[Variant] & (Omit[TextFieldProps[TextFieldVariants], variant])
  
  def withProps[Variant /* <: TextFieldVariants */](p: `0`[Variant] & (Omit[TextFieldProps[TextFieldVariants], variant])): Builder[Variant] = new Builder[Variant](js.Array(this.component, p.asInstanceOf[js.Any]))
}
