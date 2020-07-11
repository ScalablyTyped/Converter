package typingsJapgolly.semanticUiReact.components

import typingsJapgolly.StBuildingComponent
import typingsJapgolly.semanticUiReact.buttonOrMod.ButtonOrProps
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

object ButtonOr {
  @JSImport("semantic-ui-react/dist/commonjs/elements/Button/ButtonOr", JSImport.Default)
  @js.native
  object component extends js.Object
  
  @scala.inline
  class Builder (val args: js.Array[js.Any])
    extends AnyVal
       with StBuildingComponent[js.Object] {
    @scala.inline
    def as(value: js.Any): this.type = set("as", value.asInstanceOf[js.Any])
    @scala.inline
    def className(value: String): this.type = set("className", value.asInstanceOf[js.Any])
    @scala.inline
    def text(value: Double | String): this.type = set("text", value.asInstanceOf[js.Any])
  }
  
  def withProps(p: ButtonOrProps): Builder = new Builder(js.Array(this.component, p.asInstanceOf[js.Any]))
  implicit def make(companion: ButtonOr.type): Builder = new Builder(js.Array(this.component, js.Dictionary.empty))()
}

