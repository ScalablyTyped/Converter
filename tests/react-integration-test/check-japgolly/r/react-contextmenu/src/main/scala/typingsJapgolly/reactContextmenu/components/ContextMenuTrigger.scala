package typingsJapgolly.reactContextmenu.components

import typingsJapgolly.StBuildingComponent
import typingsJapgolly.react.mod.HTMLAttributes
import typingsJapgolly.react.mod.ReactType
import typingsJapgolly.reactContextmenu.mod.ContextMenuTriggerProps
import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

object ContextMenuTrigger {
  
  @scala.inline
  def apply(id: String): Builder = {
    val __props = js.Dynamic.literal(id = id.asInstanceOf[js.Any])
    new Builder(js.Array(this.component, __props.asInstanceOf[ContextMenuTriggerProps]))
  }
  
  @JSImport("react-contextmenu", "ContextMenuTrigger")
  @js.native
  val component: js.Object = js.native
  
  @scala.inline
  class Builder (val args: js.Array[js.Any])
    extends AnyVal
       with StBuildingComponent[typingsJapgolly.reactContextmenu.mod.ContextMenuTrigger] {
    
    @scala.inline
    def attributes(value: HTMLAttributes[js.Any]): this.type = set("attributes", value.asInstanceOf[js.Any])
    
    @scala.inline
    def collect(value: /* data */ js.Any => js.Any): this.type = set("collect", js.Any.fromFunction1(value))
    
    @scala.inline
    def disable(value: Boolean): this.type = set("disable", value.asInstanceOf[js.Any])
    
    @scala.inline
    def holdToDisplay(value: Double): this.type = set("holdToDisplay", value.asInstanceOf[js.Any])
    
    @scala.inline
    def renderTag(value: ReactType[js.Any]): this.type = set("renderTag", value.asInstanceOf[js.Any])
  }
  
  def withProps(p: ContextMenuTriggerProps): Builder = new Builder(js.Array(this.component, p.asInstanceOf[js.Any]))
}
