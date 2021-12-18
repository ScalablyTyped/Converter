package typingsSlinky.reactContextmenu.components

import org.scalajs.dom.HTMLElement
import slinky.web.SyntheticMouseEvent
import slinky.web.html.`*`.tag
import typingsSlinky.StBuildingComponent
import typingsSlinky.reactContextmenu.mod.ContextMenuProps
import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

object ContextMenu {
  
  inline def apply(id: String): Builder = {
    val __props = js.Dynamic.literal(id = id.asInstanceOf[js.Any])
    new Builder(js.Array(this.component, __props.asInstanceOf[ContextMenuProps]))
  }
  
  @JSImport("react-contextmenu", "ContextMenu")
  @js.native
  val component: js.Object = js.native
  
  @scala.inline
  open class Builder (val args: js.Array[Any])
    extends AnyVal
       with StBuildingComponent[tag.type, typingsSlinky.reactContextmenu.mod.ContextMenu] {
    
    inline def className(value: String): this.type = set("className", value.asInstanceOf[js.Any])
    
    inline def data(value: Any): this.type = set("data", value.asInstanceOf[js.Any])
    
    inline def hideOnLeave(value: Boolean): this.type = set("hideOnLeave", value.asInstanceOf[js.Any])
    
    inline def onHide(value: /* event */ Any => Unit): this.type = set("onHide", js.Any.fromFunction1(value))
    
    inline def onMouseLeave(
      value: (js.Function3[
          /* event */ SyntheticMouseEvent[HTMLElement], 
          /* import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify Object */ /* data */ Any, 
          /* target */ HTMLElement, 
          Unit
        ]) | js.Function
    ): this.type = set("onMouseLeave", value.asInstanceOf[js.Any])
    
    inline def onMouseLeaveFunction3(
      value: (/* event */ SyntheticMouseEvent[HTMLElement], /* import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify Object */ /* data */ Any, /* target */ HTMLElement) => Unit
    ): this.type = set("onMouseLeave", js.Any.fromFunction3(value))
    
    inline def onShow(value: /* event */ Any => Unit): this.type = set("onShow", js.Any.fromFunction1(value))
    
    inline def rtl(value: Boolean): this.type = set("rtl", value.asInstanceOf[js.Any])
  }
  
  def withProps(p: ContextMenuProps): Builder = new Builder(js.Array(this.component, p.asInstanceOf[js.Any]))
}
