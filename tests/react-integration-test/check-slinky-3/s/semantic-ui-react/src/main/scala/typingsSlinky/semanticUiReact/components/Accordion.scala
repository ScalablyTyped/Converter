package typingsSlinky.semanticUiReact.components

import _root_.typingsSlinky.StBuildingComponent
import _root_.typingsSlinky.semanticUiReact.distCommonjsGenericMod.SemanticShorthandCollection
import _root_.typingsSlinky.semanticUiReact.distCommonjsGenericMod.SemanticShorthandItem
import _root_.typingsSlinky.semanticUiReact.distCommonjsModulesAccordionAccordionAccordionMod.AccordionAccordionProps
import _root_.typingsSlinky.semanticUiReact.distCommonjsModulesAccordionAccordionContentMod.AccordionContentProps
import _root_.typingsSlinky.semanticUiReact.distCommonjsModulesAccordionAccordionMod.AccordionProps
import _root_.typingsSlinky.semanticUiReact.distCommonjsModulesAccordionAccordionPanelMod.AccordionPanelProps
import _root_.typingsSlinky.semanticUiReact.distCommonjsModulesAccordionAccordionTitleMod.AccordionTitleProps
import _root_.typingsSlinky.semanticUiReact.distCommonjsModulesAccordionMod.default
import org.scalajs.dom.HTMLDivElement
import slinky.web.SyntheticMouseEvent
import slinky.web.html.`*`.tag
import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

object Accordion {
  
  object Accordion {
    
    @JSImport("semantic-ui-react/dist/commonjs/modules/Accordion", "default.Accordion")
    @js.native
    val component: js.Object = js.native
    
    type Props = AccordionAccordionProps
    
    implicit def make(companion: Accordion.type): SharedBuilder_AccordionAccordionProps_2090513651[
        _root_.typingsSlinky.semanticUiReact.distCommonjsModulesAccordionMod.default.Accordion
      ] = new SharedBuilder_AccordionAccordionProps_2090513651[
        _root_.typingsSlinky.semanticUiReact.distCommonjsModulesAccordionMod.default.Accordion
      ](js.Array(this.component, js.Dictionary.empty))()
    
    def withProps(p: AccordionAccordionProps): SharedBuilder_AccordionAccordionProps_2090513651[
        _root_.typingsSlinky.semanticUiReact.distCommonjsModulesAccordionMod.default.Accordion
      ] = new SharedBuilder_AccordionAccordionProps_2090513651[
        _root_.typingsSlinky.semanticUiReact.distCommonjsModulesAccordionMod.default.Accordion
      ](js.Array(this.component, p.asInstanceOf[js.Any]))
  }
  
  object Content {
    
    @JSImport("semantic-ui-react/dist/commonjs/modules/Accordion", "default.Content")
    @js.native
    val component: js.Object = js.native
    
    type Props = AccordionContentProps
    
    implicit def make(companion: Content.type): SharedBuilder_AccordionContentProps_1030703804 = new SharedBuilder_AccordionContentProps_1030703804(js.Array(this.component, js.Dictionary.empty))()
    
    def withProps(p: AccordionContentProps): SharedBuilder_AccordionContentProps_1030703804 = new SharedBuilder_AccordionContentProps_1030703804(js.Array(this.component, p.asInstanceOf[js.Any]))
  }
  
  object Title {
    
    @JSImport("semantic-ui-react/dist/commonjs/modules/Accordion", "default.Title")
    @js.native
    val component: js.Object = js.native
    
    type Props = AccordionTitleProps
    
    implicit def make(companion: Title.type): SharedBuilder_AccordionTitleProps_420803499[
        _root_.typingsSlinky.semanticUiReact.distCommonjsModulesAccordionMod.default.Title
      ] = new SharedBuilder_AccordionTitleProps_420803499[
        _root_.typingsSlinky.semanticUiReact.distCommonjsModulesAccordionMod.default.Title
      ](js.Array(this.component, js.Dictionary.empty))()
    
    def withProps(p: AccordionTitleProps): SharedBuilder_AccordionTitleProps_420803499[
        _root_.typingsSlinky.semanticUiReact.distCommonjsModulesAccordionMod.default.Title
      ] = new SharedBuilder_AccordionTitleProps_420803499[
        _root_.typingsSlinky.semanticUiReact.distCommonjsModulesAccordionMod.default.Title
      ](js.Array(this.component, p.asInstanceOf[js.Any]))
  }
  
  @JSImport("semantic-ui-react/dist/commonjs/modules/Accordion", JSImport.Default)
  @js.native
  val component: js.Object = js.native
  
  @scala.inline
  open class Builder (val args: js.Array[Any])
    extends AnyVal
       with StBuildingComponent[tag.type, default] {
    
    inline def activeIndex(value: Double | js.Array[Double]): this.type = set("activeIndex", value.asInstanceOf[js.Any])
    
    inline def activeIndexVarargs(value: Double*): this.type = set("activeIndex", js.Array(value*))
    
    inline def as(value: Any): this.type = set("as", value.asInstanceOf[js.Any])
    
    inline def className(value: String): this.type = set("className", value.asInstanceOf[js.Any])
    
    inline def defaultActiveIndex(value: Double | js.Array[Double]): this.type = set("defaultActiveIndex", value.asInstanceOf[js.Any])
    
    inline def defaultActiveIndexVarargs(value: Double*): this.type = set("defaultActiveIndex", js.Array(value*))
    
    inline def exclusive(value: Boolean): this.type = set("exclusive", value.asInstanceOf[js.Any])
    
    inline def fluid(value: Boolean): this.type = set("fluid", value.asInstanceOf[js.Any])
    
    inline def inverted(value: Boolean): this.type = set("inverted", value.asInstanceOf[js.Any])
    
    inline def onTitleClick(value: (/* event */ SyntheticMouseEvent[HTMLDivElement], /* data */ AccordionTitleProps) => Unit): this.type = set("onTitleClick", js.Any.fromFunction2(value))
    
    inline def panels(value: SemanticShorthandCollection[AccordionPanelProps]): this.type = set("panels", value.asInstanceOf[js.Any])
    
    inline def panelsVarargs(value: SemanticShorthandItem[AccordionPanelProps]*): this.type = set("panels", js.Array(value*))
    
    inline def styled(value: Boolean): this.type = set("styled", value.asInstanceOf[js.Any])
  }
  
  type Props = AccordionProps
  
  implicit def make(companion: Accordion.type): Builder = new Builder(js.Array(this.component, js.Dictionary.empty))()
  
  def withProps(p: AccordionProps): Builder = new Builder(js.Array(this.component, p.asInstanceOf[js.Any]))
}
