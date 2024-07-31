package typingsSlinky.reactContextmenu.components

import _root_.typingsSlinky.StBuildingComponent
import _root_.typingsSlinky.react.mod.HTMLAttributes
import _root_.typingsSlinky.react.mod.ReactType
import _root_.typingsSlinky.reactContextmenu.mod.ContextMenuTriggerProps
import slinky.web.html.`*`.tag
import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

object ContextMenuTrigger {
  
  inline def apply(id: String): Builder = {
    val __props = js.Dynamic.literal(id = id.asInstanceOf[js.Any])
    new Builder(js.Array(this.component, __props.asInstanceOf[ContextMenuTriggerProps]))
  }
  
  @JSImport("react-contextmenu", "ContextMenuTrigger")
  @js.native
  val component: js.Object = js.native
  
  @scala.inline
  open class Builder (val args: js.Array[Any])
    extends AnyVal
       with StBuildingComponent[tag.type, _root_.typingsSlinky.reactContextmenu.mod.ContextMenuTrigger] {
    
    inline def attributes(value: HTMLAttributes[Any]): this.type = set("attributes", value.asInstanceOf[js.Any])
    
    inline def collect(value: /* data */ Any => Any): this.type = set("collect", js.Any.fromFunction1(value))
    
    inline def disable(value: Boolean): this.type = set("disable", value.asInstanceOf[js.Any])
    
    inline def holdToDisplay(value: Double): this.type = set("holdToDisplay", value.asInstanceOf[js.Any])
    
    inline def renderTag(value: ReactType[Any]): this.type = set("renderTag", value.asInstanceOf[js.Any])
  }
  
  type Props = ContextMenuTriggerProps
  
  def withProps(p: ContextMenuTriggerProps): Builder = new Builder(js.Array(this.component, p.asInstanceOf[js.Any]))
}
