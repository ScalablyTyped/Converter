package typingsSlinky.react.components

import org.scalajs.dom.HTMLDivElement
import slinky.web.SyntheticMouseEvent
import slinky.web.html.`*`.tag
import typingsSlinky.StBuildingComponent
import typingsSlinky.react.semanticUiReactDistCommonjsGenericMod.SemanticShorthandItem
import typingsSlinky.react.semanticUiReactDistCommonjsModulesAccordionAccordionContentMod.AccordionContentProps
import typingsSlinky.react.semanticUiReactDistCommonjsModulesAccordionAccordionPanelMod.AccordionPanelProps
import typingsSlinky.react.semanticUiReactDistCommonjsModulesAccordionAccordionPanelMod.default
import typingsSlinky.react.semanticUiReactDistCommonjsModulesAccordionAccordionTitleMod.AccordionTitleProps
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
       with StBuildingComponent[tag.type, default] {
    
    inline def active(value: Boolean): this.type = set("active", value.asInstanceOf[js.Any])
    
    inline def content(value: SemanticShorthandItem[AccordionContentProps]): this.type = set("content", value.asInstanceOf[js.Any])
    
    inline def index(value: Double | String): this.type = set("index", value.asInstanceOf[js.Any])
    
    inline def onTitleClick(value: (/* event */ SyntheticMouseEvent[HTMLDivElement], /* data */ AccordionTitleProps) => Unit): this.type = set("onTitleClick", js.Any.fromFunction2(value))
    
    inline def title(value: SemanticShorthandItem[AccordionTitleProps]): this.type = set("title", value.asInstanceOf[js.Any])
  }
  
  type Props = AccordionPanelProps
  
  implicit def make(companion: AccordionPanel.type): Builder = new Builder(js.Array(this.component, js.Dictionary.empty))()
  
  def withProps(p: AccordionPanelProps): Builder = new Builder(js.Array(this.component, p.asInstanceOf[js.Any]))
}
