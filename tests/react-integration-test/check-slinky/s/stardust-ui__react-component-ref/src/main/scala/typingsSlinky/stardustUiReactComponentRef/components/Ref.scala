package typingsSlinky.stardustUiReactComponentRef.components

import slinky.core.facade.ReactRef
import slinky.web.html.`*`.tag
import typingsSlinky.StBuildingComponent
import typingsSlinky.stardustUiReactComponentRef.typesMod.RefProps
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
       with StBuildingComponent[tag.type, js.Object] {
    @scala.inline
    def innerRefRefObject(value: ReactRef[_]): this.type = set("innerRef", value.asInstanceOf[js.Any])
    @scala.inline
    def innerRefFunction1(value: /* instance */ _ | Null => Unit): this.type = set("innerRef", js.Any.fromFunction1(value))
    @scala.inline
    def innerRef(value: typingsSlinky.react.mod.Ref[_]): this.type = set("innerRef", value.asInstanceOf[js.Any])
    @scala.inline
    def innerRefNull: this.type = set("innerRef", null)
  }
  
  def withProps(p: RefProps): Builder = new Builder(js.Array(this.component, p.asInstanceOf[js.Any]))
  implicit def make(companion: Ref.type): Builder = new Builder(js.Array(this.component, js.Dictionary.empty))()
}

