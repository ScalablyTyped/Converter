package typingsSlinky.semanticUiReact.components

import org.scalajs.dom.raw.HTMLDivElement
import slinky.core.facade.ReactElement
import slinky.web.SyntheticMouseEvent
import slinky.web.html.`*`.tag
import typingsSlinky.StBuildingComponent
import typingsSlinky.react.mod.ReactNodeArray
import typingsSlinky.react.mod.ReactType
import typingsSlinky.semanticUiReact.accordionAccordionAccordionMod.AccordionAccordionProps
import typingsSlinky.semanticUiReact.accordionAccordionMod.AccordionProps
import typingsSlinky.semanticUiReact.accordionContentMod.AccordionContentProps
import typingsSlinky.semanticUiReact.accordionMod.default
import typingsSlinky.semanticUiReact.accordionPanelMod.AccordionPanelProps
import typingsSlinky.semanticUiReact.accordionTitleMod.AccordionTitleProps
import typingsSlinky.semanticUiReact.genericMod.SemanticShorthandCollection
import typingsSlinky.semanticUiReact.genericMod.SemanticShorthandContent
import typingsSlinky.semanticUiReact.genericMod.SemanticShorthandItem
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

object Accordion {
  @JSImport("semantic-ui-react/dist/commonjs/modules/Accordion", JSImport.Default)
  @js.native
  object component extends js.Object
  
  @scala.inline
  class Builder (val args: js.Array[js.Any])
    extends AnyVal
       with StBuildingComponent[tag.type, default] {
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
    def onTitleClick(value: (/* event */ SyntheticMouseEvent[HTMLDivElement], /* data */ AccordionTitleProps) => Unit): this.type = set("onTitleClick", js.Any.fromFunction2(value))
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
    @JSImport("semantic-ui-react/dist/commonjs/modules/Accordion", "default.Accordion")
    @js.native
    object component extends js.Object
    
    @scala.inline
    class Builder (val args: js.Array[js.Any])
      extends AnyVal
         with StBuildingComponent[tag.type, js.Object] {
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
      def onTitleClick(value: (/* event */ SyntheticMouseEvent[HTMLDivElement], /* data */ AccordionTitleProps) => Unit): this.type = set("onTitleClick", js.Any.fromFunction2(value))
      @scala.inline
      def panelsVarargs(value: SemanticShorthandItem[AccordionPanelProps]*): this.type = set("panels", js.Array(value :_*))
      @scala.inline
      def panels(value: SemanticShorthandCollection[AccordionPanelProps]): this.type = set("panels", value.asInstanceOf[js.Any])
    }
    
    def withProps(p: AccordionAccordionProps): typingsSlinky.semanticUiReact.components.Accordion.Accordion.Builder = new typingsSlinky.semanticUiReact.components.Accordion.Accordion.Builder(js.Array(this.component, p.asInstanceOf[js.Any]))
    implicit def make(companion: Accordion.type): typingsSlinky.semanticUiReact.components.Accordion.Accordion.Builder = new typingsSlinky.semanticUiReact.components.Accordion.Accordion.Builder(js.Array(this.component, js.Dictionary.empty))()
  }
  
  object Content {
    @JSImport("semantic-ui-react/dist/commonjs/modules/Accordion", "default.Content")
    @js.native
    object component extends js.Object
    
    def withProps(p: AccordionContentProps): SharedBuilder_AccordionContentProps_1656243680 = new SharedBuilder_AccordionContentProps_1656243680(js.Array(this.component, p.asInstanceOf[js.Any]))
    implicit def make(companion: Content.type): SharedBuilder_AccordionContentProps_1656243680 = new SharedBuilder_AccordionContentProps_1656243680(js.Array(this.component, js.Dictionary.empty))()
  }
  
  object Title {
    @JSImport("semantic-ui-react/dist/commonjs/modules/Accordion", "default.Title")
    @js.native
    object component extends js.Object
    
    @scala.inline
    class Builder (val args: js.Array[js.Any])
      extends AnyVal
         with StBuildingComponent[tag.type, js.Object] {
      @scala.inline
      def active(value: Boolean): this.type = set("active", value.asInstanceOf[js.Any])
      @scala.inline
      def as(value: js.Any): this.type = set("as", value.asInstanceOf[js.Any])
      @scala.inline
      def className(value: String): this.type = set("className", value.asInstanceOf[js.Any])
      @scala.inline
      def contentReactElement(value: ReactElement): this.type = set("content", value.asInstanceOf[js.Any])
      @scala.inline
      def content(value: SemanticShorthandContent): this.type = set("content", value.asInstanceOf[js.Any])
      @scala.inline
      def iconReactElement(value: ReactElement): this.type = set("icon", value.asInstanceOf[js.Any])
      @scala.inline
      def iconFunction3(
        value: (/* component */ ReactType[
              /* import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify IconProps */ _
            ], /* import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify IconProps */ _, /* children */ js.UndefOr[ReactElement | ReactNodeArray]) => ReactElement | Null
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
      def onClick(value: (/* event */ SyntheticMouseEvent[HTMLDivElement], /* data */ AccordionTitleProps) => Unit): this.type = set("onClick", js.Any.fromFunction2(value))
    }
    
    def withProps(p: AccordionTitleProps): typingsSlinky.semanticUiReact.components.Accordion.Title.Builder = new typingsSlinky.semanticUiReact.components.Accordion.Title.Builder(js.Array(this.component, p.asInstanceOf[js.Any]))
    implicit def make(companion: Title.type): typingsSlinky.semanticUiReact.components.Accordion.Title.Builder = new typingsSlinky.semanticUiReact.components.Accordion.Title.Builder(js.Array(this.component, js.Dictionary.empty))()
  }
  
}

