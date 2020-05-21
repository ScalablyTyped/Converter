package typingsSlinky.reactContextmenu.components

import slinky.core.ReactComponentClass
import slinky.web.html.`*`.tag
import typingsSlinky.StBuildingComponent
import typingsSlinky.react.mod.HTMLAttributes
import typingsSlinky.reactContextmenu.mod.ContextMenuTriggerProps
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

object ContextMenuTrigger {
  @JSImport("react-contextmenu", "ContextMenuTrigger")
  @js.native
  object component extends js.Object
  
  @scala.inline
  class Builder (val args: js.Array[js.Any])
    extends AnyVal
       with StBuildingComponent[tag.type, typingsSlinky.reactContextmenu.mod.ContextMenuTrigger] {
    @scala.inline
    def attributes(value: HTMLAttributes[_]): this.type = set("attributes", value.asInstanceOf[js.Any])
    @scala.inline
    def collect(value: /* data */ js.Any => _): this.type = set("collect", js.Any.fromFunction1(value))
    @scala.inline
    def disable(value: Boolean): this.type = set("disable", value.asInstanceOf[js.Any])
    @scala.inline
    def holdToDisplay(value: Double): this.type = set("holdToDisplay", value.asInstanceOf[js.Any])
    @scala.inline
    def renderTagFunctionComponent(value: ReactComponentClass[_]): this.type = set("renderTag", value.asInstanceOf[js.Any])
    @scala.inline
    def renderTagComponentClass(value: ReactComponentClass[_]): this.type = set("renderTag", value.asInstanceOf[js.Any])
    @scala.inline
    def renderTag(value: ReactComponentClass[_]): this.type = set("renderTag", value.asInstanceOf[js.Any])
  }
  
  def withProps(p: ContextMenuTriggerProps): Builder = new Builder(js.Array(this.component, p.asInstanceOf[js.Any]))
  @scala.inline
  def apply(id: String): Builder = {
    val __props = js.Dynamic.literal(id = id.asInstanceOf[js.Any])
    new Builder(js.Array(this.component, __props.asInstanceOf[ContextMenuTriggerProps]))
  }
}

