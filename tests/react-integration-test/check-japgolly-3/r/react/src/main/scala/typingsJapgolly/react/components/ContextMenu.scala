package typingsJapgolly.react.components

import japgolly.scalajs.react.Callback
import org.scalajs.dom.HTMLElement
import org.scalajs.dom.MouseEvent
import typingsJapgolly.StBuildingComponent
import typingsJapgolly.react.reactContextmenuMod.ContextMenuProps
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
       with StBuildingComponent[typingsJapgolly.react.reactContextmenuMod.ContextMenu] {
    
    inline def className(value: String): this.type = set("className", value.asInstanceOf[js.Any])
    
    inline def data(value: Any): this.type = set("data", value.asInstanceOf[js.Any])
    
    inline def hideOnLeave(value: Boolean): this.type = set("hideOnLeave", value.asInstanceOf[js.Any])
    
    inline def onHide(value: /* event */ Any => Callback): this.type = set("onHide", js.Any.fromFunction1((t0: /* event */ Any) => value(t0).runNow()))
    
    inline def onMouseLeave(
      value: (js.Function3[
          /* event */ MouseEvent, 
          /* import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify Object */ /* data */ Any, 
          /* target */ HTMLElement, 
          Unit
        ]) | js.Function
    ): this.type = set("onMouseLeave", value.asInstanceOf[js.Any])
    
    inline def onMouseLeaveFunction3(
      value: (/* event */ MouseEvent, /* import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify Object */ /* data */ Any, /* target */ HTMLElement) => Callback
    ): this.type = set("onMouseLeave", js.Any.fromFunction3((t0: /* event */ MouseEvent, t1: /* import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify Object */ /* data */ Any, t2: /* target */ HTMLElement) => (value(t0, t1, t2)).runNow()))
    
    inline def onShow(value: /* event */ Any => Callback): this.type = set("onShow", js.Any.fromFunction1((t0: /* event */ Any) => value(t0).runNow()))
    
    inline def rtl(value: Boolean): this.type = set("rtl", value.asInstanceOf[js.Any])
  }
  
  type Props = ContextMenuProps
  
  def withProps(p: ContextMenuProps): Builder = new Builder(js.Array(this.component, p.asInstanceOf[js.Any]))
}
