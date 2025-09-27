package typingsJapgolly.semanticUiReact.components

import japgolly.scalajs.react.Callback
import japgolly.scalajs.react.ReactMouseEventFrom
import org.scalajs.dom.HTMLDivElement
import typingsJapgolly.StBuildingComponent
import typingsJapgolly.semanticUiReact.distCommonjsGenericMod.SemanticShorthandCollection
import typingsJapgolly.semanticUiReact.distCommonjsGenericMod.SemanticShorthandItem
import typingsJapgolly.semanticUiReact.distCommonjsModulesAccordionAccordionAccordionMod.AccordionAccordionProps
import typingsJapgolly.semanticUiReact.distCommonjsModulesAccordionAccordionContentMod.AccordionContentProps
import typingsJapgolly.semanticUiReact.distCommonjsModulesAccordionAccordionMod.AccordionProps
import typingsJapgolly.semanticUiReact.distCommonjsModulesAccordionAccordionMod.default
import typingsJapgolly.semanticUiReact.distCommonjsModulesAccordionAccordionPanelMod.AccordionPanelProps
import typingsJapgolly.semanticUiReact.distCommonjsModulesAccordionAccordionTitleMod.AccordionTitleProps
import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

object Accordion {
  
  object Accordion {
    
    @JSImport("semantic-ui-react/dist/commonjs/modules/Accordion/Accordion", "default.Accordion")
    @js.native
    val component: js.Object = js.native
    
    type Props = AccordionAccordionProps
    
    implicit def make(companion: Accordion.type): SharedBuilder_AccordionAccordionProps128479885[
        typingsJapgolly.semanticUiReact.distCommonjsModulesAccordionAccordionMod.default.Accordion
      ] = new SharedBuilder_AccordionAccordionProps128479885[
        typingsJapgolly.semanticUiReact.distCommonjsModulesAccordionAccordionMod.default.Accordion
      ](js.Array(this.component, js.Dictionary.empty))()
    
    def withProps(p: AccordionAccordionProps): SharedBuilder_AccordionAccordionProps128479885[
        typingsJapgolly.semanticUiReact.distCommonjsModulesAccordionAccordionMod.default.Accordion
      ] = new SharedBuilder_AccordionAccordionProps128479885[
        typingsJapgolly.semanticUiReact.distCommonjsModulesAccordionAccordionMod.default.Accordion
      ](js.Array(this.component, p.asInstanceOf[js.Any]))
  }
  
  object Content {
    
    @JSImport("semantic-ui-react/dist/commonjs/modules/Accordion/Accordion", "default.Content")
    @js.native
    val component: js.Object = js.native
    
    type Props = AccordionContentProps
    
    implicit def make(companion: Content.type): SharedBuilder_AccordionContentProps964070972 = new SharedBuilder_AccordionContentProps964070972(js.Array(this.component, js.Dictionary.empty))()
    
    def withProps(p: AccordionContentProps): SharedBuilder_AccordionContentProps964070972 = new SharedBuilder_AccordionContentProps964070972(js.Array(this.component, p.asInstanceOf[js.Any]))
  }
  
  object Title {
    
    @JSImport("semantic-ui-react/dist/commonjs/modules/Accordion/Accordion", "default.Title")
    @js.native
    val component: js.Object = js.native
    
    type Props = AccordionTitleProps
    
    implicit def make(companion: Title.type): SharedBuilder_AccordionTitleProps_627211106[
        typingsJapgolly.semanticUiReact.distCommonjsModulesAccordionAccordionMod.default.Title
      ] = new SharedBuilder_AccordionTitleProps_627211106[
        typingsJapgolly.semanticUiReact.distCommonjsModulesAccordionAccordionMod.default.Title
      ](js.Array(this.component, js.Dictionary.empty))()
    
    def withProps(p: AccordionTitleProps): SharedBuilder_AccordionTitleProps_627211106[
        typingsJapgolly.semanticUiReact.distCommonjsModulesAccordionAccordionMod.default.Title
      ] = new SharedBuilder_AccordionTitleProps_627211106[
        typingsJapgolly.semanticUiReact.distCommonjsModulesAccordionAccordionMod.default.Title
      ](js.Array(this.component, p.asInstanceOf[js.Any]))
  }
  
  @JSImport("semantic-ui-react/dist/commonjs/modules/Accordion/Accordion", JSImport.Default)
  @js.native
  val component: js.Object = js.native
  
  @scala.inline
  open class Builder (val args: js.Array[Any])
    extends AnyVal
       with StBuildingComponent[default] {
    
    inline def activeIndex(value: Double | js.Array[Double]): this.type = set("activeIndex", value.asInstanceOf[js.Any])
    
    inline def activeIndexVarargs(value: Double*): this.type = set("activeIndex", js.Array(value*))
    
    inline def as(value: Any): this.type = set("as", value.asInstanceOf[js.Any])
    
    inline def className(value: String): this.type = set("className", value.asInstanceOf[js.Any])
    
    inline def defaultActiveIndex(value: Double | js.Array[Double]): this.type = set("defaultActiveIndex", value.asInstanceOf[js.Any])
    
    inline def defaultActiveIndexVarargs(value: Double*): this.type = set("defaultActiveIndex", js.Array(value*))
    
    inline def exclusive(value: Boolean): this.type = set("exclusive", value.asInstanceOf[js.Any])
    
    inline def fluid(value: Boolean): this.type = set("fluid", value.asInstanceOf[js.Any])
    
    inline def inverted(value: Boolean): this.type = set("inverted", value.asInstanceOf[js.Any])
    
    inline def onTitleClick(
      value: (/* event */ ReactMouseEventFrom[HTMLDivElement], /* data */ AccordionTitleProps) => Callback
    ): this.type = set("onTitleClick", js.Any.fromFunction2((t0: /* event */ ReactMouseEventFrom[HTMLDivElement], t1: /* data */ AccordionTitleProps) => (value(t0, t1)).runNow()))
    
    inline def panels(value: SemanticShorthandCollection[AccordionPanelProps]): this.type = set("panels", value.asInstanceOf[js.Any])
    
    inline def panelsVarargs(value: SemanticShorthandItem[AccordionPanelProps]*): this.type = set("panels", js.Array(value*))
    
    inline def styled(value: Boolean): this.type = set("styled", value.asInstanceOf[js.Any])
  }
  
  type Props = AccordionProps
  
  implicit def make(companion: Accordion.type): Builder = new Builder(js.Array(this.component, js.Dictionary.empty))()
  
  def withProps(p: AccordionProps): Builder = new Builder(js.Array(this.component, p.asInstanceOf[js.Any]))
}
