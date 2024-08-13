package typingsSlinky.react.components

import org.scalajs.dom.HTMLDivElement
import org.scalajs.dom.HTMLElement
import org.scalajs.dom.MouseEvent
import org.scalajs.dom.TouchEvent
import slinky.web.html.`*`.tag
import typingsSlinky.StBuildingComponent
import typingsSlinky.react.mod.HTMLAttributes
import typingsSlinky.react.reactContextmenuMod.MenuItemProps
import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

object MenuItem {
  
  @JSImport("react-contextmenu", "MenuItem")
  @js.native
  val component: js.Object = js.native
  
  @scala.inline
  open class Builder (val args: js.Array[Any])
    extends AnyVal
       with StBuildingComponent[tag.type, typingsSlinky.react.reactContextmenuMod.MenuItem] {
    
    inline def attributes(value: HTMLAttributes[HTMLDivElement]): this.type = set("attributes", value.asInstanceOf[js.Any])
    
    inline def className(value: String): this.type = set("className", value.asInstanceOf[js.Any])
    
    inline def data(
      value: /* import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify Object */ Any
    ): this.type = set("data", value.asInstanceOf[js.Any])
    
    inline def disabled(value: Boolean): this.type = set("disabled", value.asInstanceOf[js.Any])
    
    inline def divider(value: Boolean): this.type = set("divider", value.asInstanceOf[js.Any])
    
    inline def onClick(
      value: (js.Function3[
          /* event */ TouchEvent | MouseEvent, 
          /* import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify Object */ /* data */ Any, 
          /* target */ HTMLElement, 
          Unit
        ]) | js.Function
    ): this.type = set("onClick", value.asInstanceOf[js.Any])
    
    inline def onClickFunction3(
      value: (/* event */ TouchEvent | MouseEvent, /* import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify Object */ /* data */ Any, /* target */ HTMLElement) => Unit
    ): this.type = set("onClick", js.Any.fromFunction3(value))
    
    inline def preventClose(value: Boolean): this.type = set("preventClose", value.asInstanceOf[js.Any])
  }
  
  type Props = MenuItemProps
  
  implicit def make(companion: MenuItem.type): Builder = new Builder(js.Array(this.component, js.Dictionary.empty))()
  
  def withProps(p: MenuItemProps): Builder = new Builder(js.Array(this.component, p.asInstanceOf[js.Any]))
}
