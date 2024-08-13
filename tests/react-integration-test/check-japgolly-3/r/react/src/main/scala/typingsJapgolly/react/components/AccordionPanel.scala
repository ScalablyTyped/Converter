package typingsJapgolly.react.components

import japgolly.scalajs.react.Callback
import japgolly.scalajs.react.ReactMouseEventFrom
import org.scalajs.dom.HTMLDivElement
import typingsJapgolly.StBuildingComponent
import typingsJapgolly.react.semanticUiReactDistCommonjsGenericMod.SemanticShorthandItem
import typingsJapgolly.react.semanticUiReactDistCommonjsModulesAccordionAccordionContentMod.AccordionContentProps
import typingsJapgolly.react.semanticUiReactDistCommonjsModulesAccordionAccordionPanelMod.AccordionPanelProps
import typingsJapgolly.react.semanticUiReactDistCommonjsModulesAccordionAccordionPanelMod.default
import typingsJapgolly.react.semanticUiReactDistCommonjsModulesAccordionAccordionTitleMod.AccordionTitleProps
import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

object AccordionPanel {
  
  @JSImport("react/semantic-ui-react/dist/commonjs/modules/Accordion/AccordionPanel", JSImport.Default)
  @js.native
  val component: js.Object = js.native
  
  @scala.inline
  open class Builder (val args: js.Array[Any])
    extends AnyVal
       with StBuildingComponent[default] {
    
    inline def active(value: Boolean): this.type = set("active", value.asInstanceOf[js.Any])
    
    inline def content(value: SemanticShorthandItem[AccordionContentProps]): this.type = set("content", value.asInstanceOf[js.Any])
    
    inline def index(value: Double | String): this.type = set("index", value.asInstanceOf[js.Any])
    
    inline def onTitleClick(
      value: (/* event */ ReactMouseEventFrom[HTMLDivElement], /* data */ AccordionTitleProps) => Callback
    ): this.type = set("onTitleClick", js.Any.fromFunction2((t0: /* event */ ReactMouseEventFrom[HTMLDivElement], t1: /* data */ AccordionTitleProps) => (value(t0, t1)).runNow()))
    
    inline def title(value: SemanticShorthandItem[AccordionTitleProps]): this.type = set("title", value.asInstanceOf[js.Any])
  }
  
  type Props = AccordionPanelProps
  
  implicit def make(companion: AccordionPanel.type): Builder = new Builder(js.Array(this.component, js.Dictionary.empty))()
  
  def withProps(p: AccordionPanelProps): Builder = new Builder(js.Array(this.component, p.asInstanceOf[js.Any]))
}
