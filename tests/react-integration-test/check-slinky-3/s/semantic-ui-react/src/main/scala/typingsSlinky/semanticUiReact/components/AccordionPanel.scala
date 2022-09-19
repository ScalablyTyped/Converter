package typingsSlinky.semanticUiReact.components

import org.scalajs.dom.HTMLDivElement
import slinky.core.facade.ReactElement
import slinky.web.SyntheticMouseEvent
import slinky.web.html.`*`.tag
import typingsSlinky.StBuildingComponent
import typingsSlinky.react.mod.ReactNodeArray
import typingsSlinky.react.mod.ReactType
import typingsSlinky.semanticUiReact.distCommonjsGenericMod.SemanticShorthandItem
import typingsSlinky.semanticUiReact.distCommonjsModulesAccordionAccordionContentMod.AccordionContentProps
import typingsSlinky.semanticUiReact.distCommonjsModulesAccordionAccordionPanelMod.AccordionPanelProps
import typingsSlinky.semanticUiReact.distCommonjsModulesAccordionAccordionPanelMod.default
import typingsSlinky.semanticUiReact.distCommonjsModulesAccordionAccordionTitleMod.AccordionTitleProps
import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

object AccordionPanel {
  
  @JSImport("semantic-ui-react/dist/commonjs/modules/Accordion/AccordionPanel", JSImport.Default)
  @js.native
  val component: js.Object = js.native
  
  @scala.inline
  open class Builder (val args: js.Array[Any])
    extends AnyVal
       with StBuildingComponent[tag.type, default] {
    
    inline def active(value: Boolean): this.type = set("active", value.asInstanceOf[js.Any])
    
    inline def content(value: SemanticShorthandItem[AccordionContentProps]): this.type = set("content", value.asInstanceOf[js.Any])
    
    inline def contentFunction3(
      value: (/* component */ ReactType[AccordionContentProps], AccordionContentProps, /* children */ js.UndefOr[ReactElement | ReactNodeArray]) => ReactElement | Null
    ): this.type = set("content", js.Any.fromFunction3(value))
    
    inline def contentReactElement(value: ReactElement): this.type = set("content", value.asInstanceOf[js.Any])
    
    inline def index(value: Double | String): this.type = set("index", value.asInstanceOf[js.Any])
    
    inline def onTitleClick(value: (/* event */ SyntheticMouseEvent[HTMLDivElement], /* data */ AccordionTitleProps) => Unit): this.type = set("onTitleClick", js.Any.fromFunction2(value))
    
    inline def title(value: SemanticShorthandItem[AccordionTitleProps]): this.type = set("title", value.asInstanceOf[js.Any])
    
    inline def titleFunction3(
      value: (/* component */ ReactType[AccordionTitleProps], AccordionTitleProps, /* children */ js.UndefOr[ReactElement | ReactNodeArray]) => ReactElement | Null
    ): this.type = set("title", js.Any.fromFunction3(value))
    
    inline def titleReactElement(value: ReactElement): this.type = set("title", value.asInstanceOf[js.Any])
  }
  
  implicit def make(companion: AccordionPanel.type): Builder = new Builder(js.Array(this.component, js.Dictionary.empty))()
  
  def withProps(p: AccordionPanelProps): Builder = new Builder(js.Array(this.component, p.asInstanceOf[js.Any]))
}
