package typingsJapgolly.semanticUiReact.components

import japgolly.scalajs.react.Callback
import japgolly.scalajs.react.ReactMouseEventFrom
import japgolly.scalajs.react.raw.React.Element
import japgolly.scalajs.react.raw.React.Node
import japgolly.scalajs.react.vdom.VdomElement
import org.scalajs.dom.raw.HTMLDivElement
import typingsJapgolly.StBuildingComponent
import typingsJapgolly.react.mod.ReactNodeArray
import typingsJapgolly.react.mod.ReactType
import typingsJapgolly.semanticUiReact.accordionAccordionAccordionMod.AccordionAccordionProps
import typingsJapgolly.semanticUiReact.accordionAccordionMod.AccordionProps
import typingsJapgolly.semanticUiReact.accordionContentMod.AccordionContentProps
import typingsJapgolly.semanticUiReact.accordionMod.default
import typingsJapgolly.semanticUiReact.accordionPanelMod.AccordionPanelProps
import typingsJapgolly.semanticUiReact.accordionTitleMod.AccordionTitleProps
import typingsJapgolly.semanticUiReact.genericMod.SemanticShorthandCollection
import typingsJapgolly.semanticUiReact.genericMod.SemanticShorthandContent
import typingsJapgolly.semanticUiReact.genericMod.SemanticShorthandItem
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

object Accordion {
  @JSImport("semantic-ui-react/dist/commonjs/modules/Accordion", JSImport.Default)
  @js.native
  object component extends js.Object
  
  @scala.inline
  class Builder (val args: js.Array[js.Any])
    extends AnyVal
       with StBuildingComponent[default] {
    @scala.inline
    def activeIndexVarargs(value: Double*): this.type = set("activeIndex", js.Array(value :_*))
    @scala.inline
    def activeIndex(value: Double | js.Array[Double]): this.type = set("activeIndex", value.asInstanceOf[js.Any])
    @scala.inline
    def as(value: js.Any): this.type = set("as", value.asInstanceOf[js.Any])
    @scala.inline
    def className(value: String): this.type = set("className", value.asInstanceOf[js.Any])
    @scala.inline
    def defaultActiveIndexVarargs(value: Double*): this.type = set("defaultActiveIndex", js.Array(value :_*))
    @scala.inline
    def defaultActiveIndex(value: Double | js.Array[Double]): this.type = set("defaultActiveIndex", value.asInstanceOf[js.Any])
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
    def panelsVarargs(value: SemanticShorthandItem[AccordionPanelProps]*): this.type = set("panels", js.Array(value :_*))
    @scala.inline
    def panels(value: SemanticShorthandCollection[AccordionPanelProps]): this.type = set("panels", value.asInstanceOf[js.Any])
    @scala.inline
    def styled(value: Boolean): this.type = set("styled", value.asInstanceOf[js.Any])
  }
  
  def withProps(p: AccordionProps): Builder = new Builder(js.Array(this.component, p.asInstanceOf[js.Any]))
  implicit def make(companion: Accordion.type): Builder = new Builder(js.Array(this.component, js.Dictionary.empty))()
  object Accordion {
    @JSImport("semantic-ui-react/dist/commonjs/modules/Accordion", "Accordion")
    @js.native
    object component extends js.Object
    
    @scala.inline
    class Builder (val args: js.Array[js.Any])
      extends AnyVal
         with StBuildingComponent[js.Object] {
      @scala.inline
      def activeIndexVarargs(value: Double*): this.type = set("activeIndex", js.Array(value :_*))
      @scala.inline
      def activeIndex(value: Double | js.Array[Double]): this.type = set("activeIndex", value.asInstanceOf[js.Any])
      @scala.inline
      def as(value: js.Any): this.type = set("as", value.asInstanceOf[js.Any])
      @scala.inline
      def className(value: String): this.type = set("className", value.asInstanceOf[js.Any])
      @scala.inline
      def defaultActiveIndexVarargs(value: Double*): this.type = set("defaultActiveIndex", js.Array(value :_*))
      @scala.inline
      def defaultActiveIndex(value: Double | js.Array[Double]): this.type = set("defaultActiveIndex", value.asInstanceOf[js.Any])
      @scala.inline
      def exclusive(value: Boolean): this.type = set("exclusive", value.asInstanceOf[js.Any])
      @scala.inline
      def onTitleClick(
        value: (/* event */ ReactMouseEventFrom[HTMLDivElement], /* data */ AccordionTitleProps) => Callback
      ): this.type = set("onTitleClick", js.Any.fromFunction2((t0: /* event */ ReactMouseEventFrom[HTMLDivElement], t1: /* data */ AccordionTitleProps) => (value(t0, t1)).runNow()))
      @scala.inline
      def panelsVarargs(value: SemanticShorthandItem[AccordionPanelProps]*): this.type = set("panels", js.Array(value :_*))
      @scala.inline
      def panels(value: SemanticShorthandCollection[AccordionPanelProps]): this.type = set("panels", value.asInstanceOf[js.Any])
    }
    
    def withProps(p: AccordionAccordionProps): typingsJapgolly.semanticUiReact.components.Accordion.Accordion.Builder = new typingsJapgolly.semanticUiReact.components.Accordion.Accordion.Builder(js.Array(this.component, p.asInstanceOf[js.Any]))
    implicit def make(companion: Accordion.type): typingsJapgolly.semanticUiReact.components.Accordion.Accordion.Builder = new typingsJapgolly.semanticUiReact.components.Accordion.Accordion.Builder(js.Array(this.component, js.Dictionary.empty))()
  }
  
  object Content {
    @JSImport("semantic-ui-react/dist/commonjs/modules/Accordion", "Content")
    @js.native
    object component extends js.Object
    
    def withProps(p: AccordionContentProps): SharedBuilder_AccordionContentProps_1883056278 = new SharedBuilder_AccordionContentProps_1883056278(js.Array(this.component, p.asInstanceOf[js.Any]))
    implicit def make(companion: Content.type): SharedBuilder_AccordionContentProps_1883056278 = new SharedBuilder_AccordionContentProps_1883056278(js.Array(this.component, js.Dictionary.empty))()
  }
  
  object Title {
    @JSImport("semantic-ui-react/dist/commonjs/modules/Accordion", "Title")
    @js.native
    object component extends js.Object
    
    @scala.inline
    class Builder (val args: js.Array[js.Any])
      extends AnyVal
         with StBuildingComponent[js.Object] {
      @scala.inline
      def active(value: Boolean): this.type = set("active", value.asInstanceOf[js.Any])
      @scala.inline
      def as(value: js.Any): this.type = set("as", value.asInstanceOf[js.Any])
      @scala.inline
      def className(value: String): this.type = set("className", value.asInstanceOf[js.Any])
      @scala.inline
      def contentVdomElement(value: VdomElement): this.type = set("content", value.rawElement.asInstanceOf[js.Any])
      @scala.inline
      def content(value: SemanticShorthandContent): this.type = set("content", value.asInstanceOf[js.Any])
      @scala.inline
      def iconVdomElement(value: VdomElement): this.type = set("icon", value.rawElement.asInstanceOf[js.Any])
      @scala.inline
      def iconFunction3(
        value: (/* component */ ReactType[
              /* import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify IconProps */ _
            ], /* import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify IconProps */ _, /* children */ js.UndefOr[Node | ReactNodeArray]) => Element | Null
      ): this.type = set("icon", js.Any.fromFunction3(value))
      @scala.inline
      def icon(
        value: SemanticShorthandItem[
              /* import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify IconProps */ _
            ]
      ): this.type = set("icon", value.asInstanceOf[js.Any])
      @scala.inline
      def index(value: Double | String): this.type = set("index", value.asInstanceOf[js.Any])
      @scala.inline
      def onClick(
        value: (/* event */ ReactMouseEventFrom[HTMLDivElement], /* data */ AccordionTitleProps) => Callback
      ): this.type = set("onClick", js.Any.fromFunction2((t0: /* event */ ReactMouseEventFrom[HTMLDivElement], t1: /* data */ AccordionTitleProps) => (value(t0, t1)).runNow()))
    }
    
    def withProps(p: AccordionTitleProps): typingsJapgolly.semanticUiReact.components.Accordion.Title.Builder = new typingsJapgolly.semanticUiReact.components.Accordion.Title.Builder(js.Array(this.component, p.asInstanceOf[js.Any]))
    implicit def make(companion: Title.type): typingsJapgolly.semanticUiReact.components.Accordion.Title.Builder = new typingsJapgolly.semanticUiReact.components.Accordion.Title.Builder(js.Array(this.component, js.Dictionary.empty))()
  }
  
}

