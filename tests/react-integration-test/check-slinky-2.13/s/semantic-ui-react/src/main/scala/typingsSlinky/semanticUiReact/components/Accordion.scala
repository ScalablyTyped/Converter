package typingsSlinky.semanticUiReact.components

import org.scalajs.dom.raw.HTMLDivElement
import slinky.web.SyntheticMouseEvent
import slinky.web.html.`*`.tag
import typingsSlinky.StBuildingComponent
import typingsSlinky.semanticUiReact.accordionAccordionAccordionMod.AccordionAccordionProps
import typingsSlinky.semanticUiReact.accordionAccordionMod.AccordionProps
import typingsSlinky.semanticUiReact.accordionContentMod.AccordionContentProps
import typingsSlinky.semanticUiReact.accordionMod.default
import typingsSlinky.semanticUiReact.accordionPanelMod.AccordionPanelProps
import typingsSlinky.semanticUiReact.accordionTitleMod.AccordionTitleProps
import typingsSlinky.semanticUiReact.genericMod.SemanticShorthandCollection
import typingsSlinky.semanticUiReact.genericMod.SemanticShorthandItem
import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

object Accordion {
  
  object Accordion {
    
    @JSImport("semantic-ui-react/dist/commonjs/modules/Accordion", "default.Accordion")
    @js.native
    val component: js.Object = js.native
    
    implicit def make(companion: Accordion.type): SharedBuilder_AccordionAccordionProps_1044969128[typingsSlinky.semanticUiReact.accordionMod.default.Accordion] = new SharedBuilder_AccordionAccordionProps_1044969128[typingsSlinky.semanticUiReact.accordionMod.default.Accordion](js.Array(this.component, js.Dictionary.empty))()
    
    def withProps(p: AccordionAccordionProps): SharedBuilder_AccordionAccordionProps_1044969128[typingsSlinky.semanticUiReact.accordionMod.default.Accordion] = new SharedBuilder_AccordionAccordionProps_1044969128[typingsSlinky.semanticUiReact.accordionMod.default.Accordion](js.Array(this.component, p.asInstanceOf[js.Any]))
  }
  
  object Content {
    
    @JSImport("semantic-ui-react/dist/commonjs/modules/Accordion", "default.Content")
    @js.native
    val component: js.Object = js.native
    
    implicit def make(companion: Content.type): SharedBuilder_AccordionContentProps_1656243680 = new SharedBuilder_AccordionContentProps_1656243680(js.Array(this.component, js.Dictionary.empty))()
    
    def withProps(p: AccordionContentProps): SharedBuilder_AccordionContentProps_1656243680 = new SharedBuilder_AccordionContentProps_1656243680(js.Array(this.component, p.asInstanceOf[js.Any]))
  }
  
  object Title {
    
    @JSImport("semantic-ui-react/dist/commonjs/modules/Accordion", "default.Title")
    @js.native
    val component: js.Object = js.native
    
    implicit def make(companion: Title.type): SharedBuilder_AccordionTitleProps1986434512[typingsSlinky.semanticUiReact.accordionMod.default.Title] = new SharedBuilder_AccordionTitleProps1986434512[typingsSlinky.semanticUiReact.accordionMod.default.Title](js.Array(this.component, js.Dictionary.empty))()
    
    def withProps(p: AccordionTitleProps): SharedBuilder_AccordionTitleProps1986434512[typingsSlinky.semanticUiReact.accordionMod.default.Title] = new SharedBuilder_AccordionTitleProps1986434512[typingsSlinky.semanticUiReact.accordionMod.default.Title](js.Array(this.component, p.asInstanceOf[js.Any]))
  }
  
  @JSImport("semantic-ui-react/dist/commonjs/modules/Accordion", JSImport.Default)
  @js.native
  val component: js.Object = js.native
  
  @scala.inline
  class Builder (val args: js.Array[js.Any])
    extends AnyVal
       with StBuildingComponent[tag.type, default] {
    
    @scala.inline
    def activeIndex(value: Double | js.Array[Double]): this.type = set("activeIndex", value.asInstanceOf[js.Any])
    
    @scala.inline
    def activeIndexVarargs(value: Double*): this.type = set("activeIndex", js.Array(value :_*))
    
    @scala.inline
    def as(value: js.Any): this.type = set("as", value.asInstanceOf[js.Any])
    
    @scala.inline
    def className(value: String): this.type = set("className", value.asInstanceOf[js.Any])
    
    @scala.inline
    def defaultActiveIndex(value: Double | js.Array[Double]): this.type = set("defaultActiveIndex", value.asInstanceOf[js.Any])
    
    @scala.inline
    def defaultActiveIndexVarargs(value: Double*): this.type = set("defaultActiveIndex", js.Array(value :_*))
    
    @scala.inline
    def exclusive(value: Boolean): this.type = set("exclusive", value.asInstanceOf[js.Any])
    
    @scala.inline
    def fluid(value: Boolean): this.type = set("fluid", value.asInstanceOf[js.Any])
    
    @scala.inline
    def inverted(value: Boolean): this.type = set("inverted", value.asInstanceOf[js.Any])
    
    @scala.inline
    def onTitleClick(value: (/* event */ SyntheticMouseEvent[HTMLDivElement], /* data */ AccordionTitleProps) => Unit): this.type = set("onTitleClick", js.Any.fromFunction2(value))
    
    @scala.inline
    def panels(value: SemanticShorthandCollection[AccordionPanelProps]): this.type = set("panels", value.asInstanceOf[js.Any])
    
    @scala.inline
    def panelsVarargs(value: SemanticShorthandItem[AccordionPanelProps]*): this.type = set("panels", js.Array(value :_*))
    
    @scala.inline
    def styled(value: Boolean): this.type = set("styled", value.asInstanceOf[js.Any])
  }
  
  implicit def make(companion: Accordion.type): Builder = new Builder(js.Array(this.component, js.Dictionary.empty))()
  
  def withProps(p: AccordionProps): Builder = new Builder(js.Array(this.component, p.asInstanceOf[js.Any]))
}
