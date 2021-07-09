package typingsJapgolly.reactContextmenu.components

import japgolly.scalajs.react.Callback
import japgolly.scalajs.react.ReactMouseEventFrom
import org.scalajs.dom.raw.HTMLElement
import typingsJapgolly.StBuildingComponent
import typingsJapgolly.reactContextmenu.mod.ContextMenuProps
import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

object ContextMenu {
  
  @scala.inline
  def apply(id: String): Builder = {
    val __props = js.Dynamic.literal(id = id.asInstanceOf[js.Any])
    new Builder(js.Array(this.component, __props.asInstanceOf[ContextMenuProps]))
  }
  
  @JSImport("react-contextmenu", "ContextMenu")
  @js.native
  val component: js.Object = js.native
  
  @scala.inline
  class Builder (val args: js.Array[js.Any])
    extends AnyVal
       with StBuildingComponent[typingsJapgolly.reactContextmenu.mod.ContextMenu] {
    
    @scala.inline
    def className(value: String): this.type = set("className", value.asInstanceOf[js.Any])
    
    @scala.inline
    def data(value: js.Any): this.type = set("data", value.asInstanceOf[js.Any])
    
    @scala.inline
    def hideOnLeave(value: Boolean): this.type = set("hideOnLeave", value.asInstanceOf[js.Any])
    
    @scala.inline
    def onHide(value: /* event */ js.Any => Callback): this.type = set("onHide", js.Any.fromFunction1((t0: /* event */ js.Any) => value(t0).runNow()))
    
    @scala.inline
    def onMouseLeave(
      value: (js.Function3[
          /* event */ ReactMouseEventFrom[HTMLElement], 
          /* import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify Object */ /* data */ js.Any, 
          /* target */ HTMLElement, 
          Unit
        ]) | js.Function
    ): this.type = set("onMouseLeave", value.asInstanceOf[js.Any])
    
    @scala.inline
    def onMouseLeaveFunction3(
      value: (/* event */ ReactMouseEventFrom[HTMLElement], /* import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify Object */ /* data */ js.Any, /* target */ HTMLElement) => Callback
    ): this.type = set("onMouseLeave", js.Any.fromFunction3((t0: /* event */ ReactMouseEventFrom[HTMLElement], t1: /* import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify Object */ /* data */ js.Any, t2: /* target */ HTMLElement) => (value(t0, t1, t2)).runNow()))
    
    @scala.inline
    def onShow(value: /* event */ js.Any => Callback): this.type = set("onShow", js.Any.fromFunction1((t0: /* event */ js.Any) => value(t0).runNow()))
    
    @scala.inline
    def rtl(value: Boolean): this.type = set("rtl", value.asInstanceOf[js.Any])
  }
  
  def withProps(p: ContextMenuProps): Builder = new Builder(js.Array(this.component, p.asInstanceOf[js.Any]))
}
