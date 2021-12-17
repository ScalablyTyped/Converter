package typingsSlinky.reactSelect.components

import slinky.web.html.`*`.tag
import typingsSlinky.StBuildingComponent
import typingsSlinky.reactSelect.mod.ReactSelectProps
import typingsSlinky.reactSelect.mod.default
import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

object ReactSelect {
  
  inline def apply[TValue](): Builder[TValue] = {
    val __props = js.Dynamic.literal()
    new Builder[TValue](js.Array(this.component, __props.asInstanceOf[ReactSelectProps[TValue]]))
  }
  
  @JSImport("react-select", JSImport.Default)
  @js.native
  val component: js.Object = js.native
  
  @scala.inline
  open class Builder[TValue] (val args: js.Array[Any])
    extends AnyVal
       with StBuildingComponent[tag.type, default[TValue]] {
    
    inline def addLabelText(value: String): this.type = set("addLabelText", value.asInstanceOf[js.Any])
  }
  
  implicit def make[TValue](companion: ReactSelect.type): Builder[TValue] = new Builder[TValue](js.Array(this.component, js.Dictionary.empty))()
  
  def withProps[TValue](p: ReactSelectProps[TValue]): Builder[TValue] = new Builder[TValue](js.Array(this.component, p.asInstanceOf[js.Any]))
}
