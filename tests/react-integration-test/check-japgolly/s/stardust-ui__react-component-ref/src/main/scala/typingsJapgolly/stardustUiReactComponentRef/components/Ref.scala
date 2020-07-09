package typingsJapgolly.stardustUiReactComponentRef.components

import typingsJapgolly.StBuildingComponent
import typingsJapgolly.stardustUiReactComponentRef.typesMod.RefProps
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

object Ref {
  @JSImport("@stardust-ui/react-component-ref/dist/es/Ref", JSImport.Default)
  @js.native
  object component extends js.Object
  
  @scala.inline
  class Builder (val args: js.Array[js.Any])
    extends AnyVal
       with StBuildingComponent[js.Object] {
    @scala.inline
    def innerRef(value: japgolly.scalajs.react.raw.React.Ref): this.type = set("innerRef", value.asInstanceOf[js.Any])
    @scala.inline
    def innerRefNull: this.type = set("innerRef", null)
  }
  
  def withProps(p: RefProps): Builder = new Builder(js.Array(this.component, p.asInstanceOf[js.Any]))
  implicit def make(companion: Ref.type): Builder = new Builder(js.Array(this.component, js.Dictionary.empty))()
}

