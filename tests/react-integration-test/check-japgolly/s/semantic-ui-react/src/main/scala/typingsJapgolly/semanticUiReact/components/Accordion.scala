package typingsJapgolly.semanticUiReact.components

import japgolly.scalajs.react.Callback
import japgolly.scalajs.react.ReactMouseEventFrom
import org.scalajs.dom.raw.HTMLDivElement
import typingsJapgolly.StBuildingComponent
import typingsJapgolly.semanticUiReact.accordionAccordionAccordionMod.AccordionAccordionProps
import typingsJapgolly.semanticUiReact.accordionAccordionMod.AccordionProps
import typingsJapgolly.semanticUiReact.accordionAccordionMod.default
import typingsJapgolly.semanticUiReact.accordionContentMod.AccordionContentProps
import typingsJapgolly.semanticUiReact.accordionPanelMod.AccordionPanelProps
import typingsJapgolly.semanticUiReact.accordionTitleMod.AccordionTitleProps
import typingsJapgolly.semanticUiReact.genericMod.SemanticShorthandCollection
import typingsJapgolly.semanticUiReact.genericMod.SemanticShorthandItem
import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

object Accordion {
  
  object Accordion {
    
    @JSImport("semantic-ui-react/dist/commonjs/modules/Accordion/Accordion", "default.Accordion")
    @js.native
    val component: js.Object = js.native
    
    implicit def make(companion: Accordion.type): SharedBuilder_AccordionAccordionProps1188692388[typingsJapgolly.semanticUiReact.accordionAccordionMod.default.Accordion] = new SharedBuilder_AccordionAccordionProps1188692388[typingsJapgolly.semanticUiReact.accordionAccordionMod.default.Accordion](js.Array(this.component, js.Dictionary.empty))()
    
    def withProps(p: AccordionAccordionProps): SharedBuilder_AccordionAccordionProps1188692388[typingsJapgolly.semanticUiReact.accordionAccordionMod.default.Accordion] = new SharedBuilder_AccordionAccordionProps1188692388[typingsJapgolly.semanticUiReact.accordionAccordionMod.default.Accordion](js.Array(this.component, p.asInstanceOf[js.Any]))
  }
  
  object Content {
    
    @JSImport("semantic-ui-react/dist/commonjs/modules/Accordion/Accordion", "default.Content")
    @js.native
    val component: js.Object = js.native
    
    implicit def make(companion: Content.type): SharedBuilder_AccordionContentProps_1883056278 = new SharedBuilder_AccordionContentProps_1883056278(js.Array(this.component, js.Dictionary.empty))()
    
    def withProps(p: AccordionContentProps): SharedBuilder_AccordionContentProps_1883056278 = new SharedBuilder_AccordionContentProps_1883056278(js.Array(this.component, p.asInstanceOf[js.Any]))
  }
  
  object Title {
    
    @JSImport("semantic-ui-react/dist/commonjs/modules/Accordion/Accordion", "default.Title")
    @js.native
    val component: js.Object = js.native
    
    implicit def make(companion: Title.type): SharedBuilder_AccordionTitleProps_248880662[typingsJapgolly.semanticUiReact.accordionAccordionMod.default.Title] = new SharedBuilder_AccordionTitleProps_248880662[typingsJapgolly.semanticUiReact.accordionAccordionMod.default.Title](js.Array(this.component, js.Dictionary.empty))()
    
    def withProps(p: AccordionTitleProps): SharedBuilder_AccordionTitleProps_248880662[typingsJapgolly.semanticUiReact.accordionAccordionMod.default.Title] = new SharedBuilder_AccordionTitleProps_248880662[typingsJapgolly.semanticUiReact.accordionAccordionMod.default.Title](js.Array(this.component, p.asInstanceOf[js.Any]))
  }
  
  @JSImport("semantic-ui-react/dist/commonjs/modules/Accordion/Accordion", JSImport.Default)
  @js.native
  val component: js.Object = js.native
  
  @scala.inline
  class Builder (val args: js.Array[js.Any])
    extends AnyVal
       with StBuildingComponent[default] {
    
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
    def onTitleClick(
      value: (/* event */ ReactMouseEventFrom[HTMLDivElement], /* data */ AccordionTitleProps) => Callback
    ): this.type = set("onTitleClick", js.Any.fromFunction2((t0: /* event */ ReactMouseEventFrom[HTMLDivElement], t1: /* data */ AccordionTitleProps) => (value(t0, t1)).runNow()))
    
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
