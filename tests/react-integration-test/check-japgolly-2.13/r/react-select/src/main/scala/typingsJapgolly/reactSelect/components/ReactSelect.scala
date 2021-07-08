package typingsJapgolly.reactSelect.components

import typingsJapgolly.StBuildingComponent
import typingsJapgolly.reactSelect.mod.ReactSelectProps
import typingsJapgolly.reactSelect.mod.default
import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

object ReactSelect {
  
  @scala.inline
  def apply[TValue](): Builder[TValue] = {
    val __props = js.Dynamic.literal()
    new Builder[TValue](js.Array(this.component, __props.asInstanceOf[ReactSelectProps[TValue]]))
  }
  
  @JSImport("react-select", JSImport.Default)
  @js.native
  val component: js.Object = js.native
  
  @scala.inline
  class Builder[TValue] (val args: js.Array[js.Any])
    extends AnyVal
       with StBuildingComponent[default[TValue]] {
    
    @scala.inline
    def addLabelText(value: String): this.type = set("addLabelText", value.asInstanceOf[js.Any])
  }
  
  implicit def make[TValue](companion: ReactSelect.type): Builder[TValue] = new Builder[TValue](js.Array(this.component, js.Dictionary.empty))()
  
  def withProps[TValue](p: ReactSelectProps[TValue]): Builder[TValue] = new Builder[TValue](js.Array(this.component, p.asInstanceOf[js.Any]))
}
