package typingsJapgolly.react.components

import japgolly.scalajs.react.Callback
import japgolly.scalajs.react.facade.React.Element
import org.scalajs.dom.HTMLElement
import org.scalajs.dom.MouseEvent
import org.scalajs.dom.TouchEvent
import typingsJapgolly.StBuildingComponent
import typingsJapgolly.react.mod.ReactText
import typingsJapgolly.react.reactContextmenuMod.SubMenuProps
import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

object SubMenu {
  
  inline def apply(title: Element | ReactText): Builder = {
    val __props = js.Dynamic.literal(title = title.asInstanceOf[js.Any])
    new Builder(js.Array(this.component, __props.asInstanceOf[SubMenuProps]))
  }
  
  @JSImport("react-contextmenu", "SubMenu")
  @js.native
  val component: js.Object = js.native
  
  @scala.inline
  open class Builder (val args: js.Array[Any])
    extends AnyVal
       with StBuildingComponent[typingsJapgolly.react.reactContextmenuMod.SubMenu] {
    
    inline def className(value: String): this.type = set("className", value.asInstanceOf[js.Any])
    
    inline def disabled(value: Boolean): this.type = set("disabled", value.asInstanceOf[js.Any])
    
    inline def hoverDelay(value: Double): this.type = set("hoverDelay", value.asInstanceOf[js.Any])
    
    inline def onClick(
      value: (js.Function3[
          /* event */ TouchEvent | MouseEvent, 
          /* import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify Object */ /* data */ Any, 
          /* target */ HTMLElement, 
          Unit
        ]) | js.Function
    ): this.type = set("onClick", value.asInstanceOf[js.Any])
    
    inline def onClickFunction3(
      value: (/* event */ TouchEvent | MouseEvent, /* import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify Object */ /* data */ Any, /* target */ HTMLElement) => Callback
    ): this.type = set("onClick", js.Any.fromFunction3((t0: /* event */ TouchEvent | MouseEvent, t1: /* import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify Object */ /* data */ Any, t2: /* target */ HTMLElement) => (value(t0, t1, t2)).runNow()))
    
    inline def preventCloseOnClick(value: Boolean): this.type = set("preventCloseOnClick", value.asInstanceOf[js.Any])
    
    inline def rtl(value: Boolean): this.type = set("rtl", value.asInstanceOf[js.Any])
  }
  
  type Props = SubMenuProps
  
  def withProps(p: SubMenuProps): Builder = new Builder(js.Array(this.component, p.asInstanceOf[js.Any]))
}
