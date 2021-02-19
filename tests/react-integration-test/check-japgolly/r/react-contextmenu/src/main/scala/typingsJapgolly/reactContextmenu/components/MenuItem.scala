package typingsJapgolly.reactContextmenu.components

import japgolly.scalajs.react.Callback
import japgolly.scalajs.react.ReactMouseEventFrom
import japgolly.scalajs.react.ReactTouchEventFrom
import org.scalajs.dom.raw.HTMLDivElement
import org.scalajs.dom.raw.HTMLElement
import typingsJapgolly.StBuildingComponent
import typingsJapgolly.react.mod.HTMLAttributes
import typingsJapgolly.reactContextmenu.mod.MenuItemProps
import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

object MenuItem {
  
  @JSImport("react-contextmenu", "MenuItem")
  @js.native
  val component: js.Object = js.native
  
  @scala.inline
  class Builder (val args: js.Array[js.Any])
    extends AnyVal
       with StBuildingComponent[typingsJapgolly.reactContextmenu.mod.MenuItem] {
    
    @scala.inline
    def attributes(value: HTMLAttributes[HTMLDivElement]): this.type = set("attributes", value.asInstanceOf[js.Any])
    
    @scala.inline
    def className(value: String): this.type = set("className", value.asInstanceOf[js.Any])
    
    @scala.inline
    def data(
      value: /* import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify Object */ js.Any
    ): this.type = set("data", value.asInstanceOf[js.Any])
    
    @scala.inline
    def disabled(value: Boolean): this.type = set("disabled", value.asInstanceOf[js.Any])
    
    @scala.inline
    def divider(value: Boolean): this.type = set("divider", value.asInstanceOf[js.Any])
    
    @scala.inline
    def onClick(
      value: (js.Function3[
          /* event */ ReactTouchEventFrom[HTMLDivElement] | ReactMouseEventFrom[HTMLDivElement], 
          /* import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify Object */ /* data */ js.Any, 
          /* target */ HTMLElement, 
          Unit
        ]) | js.Function
    ): this.type = set("onClick", value.asInstanceOf[js.Any])
    
    @scala.inline
    def onClickFunction3(
      value: (/* event */ ReactTouchEventFrom[HTMLDivElement] | ReactMouseEventFrom[HTMLDivElement], /* import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify Object */ /* data */ js.Any, /* target */ HTMLElement) => Callback
    ): this.type = set("onClick", js.Any.fromFunction3((t0: /* event */ ReactTouchEventFrom[HTMLDivElement] | ReactMouseEventFrom[HTMLDivElement], t1: /* import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify Object */ /* data */ js.Any, t2: /* target */ HTMLElement) => (value(t0, t1, t2)).runNow()))
    
    @scala.inline
    def preventClose(value: Boolean): this.type = set("preventClose", value.asInstanceOf[js.Any])
  }
  
  implicit def make(companion: MenuItem.type): Builder = new Builder(js.Array(this.component, js.Dictionary.empty))()
  
  def withProps(p: MenuItemProps): Builder = new Builder(js.Array(this.component, p.asInstanceOf[js.Any]))
}
