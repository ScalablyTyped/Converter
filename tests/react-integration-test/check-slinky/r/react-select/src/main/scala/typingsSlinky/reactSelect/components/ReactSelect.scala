package typingsSlinky.reactSelect.components

import slinky.web.html.`*`.tag
import typingsSlinky.StBuildingComponent
import typingsSlinky.reactSelect.mod.ReactSelectProps
import typingsSlinky.reactSelect.mod.default
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

object ReactSelect {
  @JSImport("react-select", JSImport.Default)
  @js.native
  object component extends js.Object
  
  @scala.inline
  class Builder[TValue] (val args: js.Array[js.Any])
    extends AnyVal
       with StBuildingComponent[tag.type, default[js.Any]] {
    @scala.inline
    def addLabelText(value: String): this.type = set("addLabelText", value.asInstanceOf[js.Any])
  }
  
  def withProps[TValue](p: ReactSelectProps[TValue]): Builder[TValue] = new Builder[TValue](js.Array(this.component, p.asInstanceOf[js.Any]))
  @scala.inline
  def apply[TValue](): Builder[TValue] = {
    val __props = js.Dynamic.literal()
    new Builder[TValue](js.Array(this.component, __props.asInstanceOf[ReactSelectProps[TValue]]))
  }
  implicit def make[TValue](companion: ReactSelect.type): Builder[TValue] = new Builder[TValue](js.Array(this.component, js.Dictionary.empty))()
}

