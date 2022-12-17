package typingsSlinky.reactContextmenu.components

import org.scalajs.dom.HTMLDivElement
import org.scalajs.dom.HTMLElement
import slinky.core.facade.ReactElement
import slinky.web.SyntheticMouseEvent
import slinky.web.SyntheticTouchEvent
import slinky.web.html.`*`.tag
import typingsSlinky.StBuildingComponent
import typingsSlinky.react.mod.ReactText
import typingsSlinky.reactContextmenu.mod.SubMenuProps
import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

object SubMenu {
  
  inline def apply(title: ReactElement | ReactText): Builder = {
    val __props = js.Dynamic.literal(title = title.asInstanceOf[js.Any])
    new Builder(js.Array(this.component, __props.asInstanceOf[SubMenuProps]))
  }
  
  @JSImport("react-contextmenu", "SubMenu")
  @js.native
  val component: js.Object = js.native
  
  @scala.inline
  open class Builder (val args: js.Array[Any])
    extends AnyVal
       with StBuildingComponent[tag.type, typingsSlinky.reactContextmenu.mod.SubMenu] {
    
    inline def className(value: String): this.type = set("className", value.asInstanceOf[js.Any])
    
    inline def disabled(value: Boolean): this.type = set("disabled", value.asInstanceOf[js.Any])
    
    inline def hoverDelay(value: Double): this.type = set("hoverDelay", value.asInstanceOf[js.Any])
    
    inline def onClick(
      value: (js.Function3[
          /* event */ SyntheticTouchEvent[HTMLDivElement] | SyntheticMouseEvent[HTMLDivElement], 
          /* import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify Object */ /* data */ Any, 
          /* target */ HTMLElement, 
          Unit
        ]) | js.Function
    ): this.type = set("onClick", value.asInstanceOf[js.Any])
    
    inline def onClickFunction3(
      value: (/* event */ SyntheticTouchEvent[HTMLDivElement] | SyntheticMouseEvent[HTMLDivElement], /* import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify Object */ /* data */ Any, /* target */ HTMLElement) => Unit
    ): this.type = set("onClick", js.Any.fromFunction3(value))
    
    inline def preventCloseOnClick(value: Boolean): this.type = set("preventCloseOnClick", value.asInstanceOf[js.Any])
    
    inline def rtl(value: Boolean): this.type = set("rtl", value.asInstanceOf[js.Any])
  }
  
  type Props = SubMenuProps
  
  def withProps(p: SubMenuProps): Builder = new Builder(js.Array(this.component, p.asInstanceOf[js.Any]))
}
