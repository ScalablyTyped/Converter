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
import typingsJapgolly.semanticUiReact.accordionTitleMod.AccordionTitleProps
import typingsJapgolly.semanticUiReact.accordionTitleMod.default
import typingsJapgolly.semanticUiReact.genericMod.SemanticShorthandContent
import typingsJapgolly.semanticUiReact.genericMod.SemanticShorthandItem
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

object AccordionTitle {
  
  @JSImport("semantic-ui-react/dist/commonjs/modules/Accordion/AccordionTitle", JSImport.Default)
  @js.native
  object component extends js.Object
  
  @scala.inline
  class Builder (val args: js.Array[js.Any])
    extends AnyVal
       with StBuildingComponent[default] {
    
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
  
  def withProps(p: AccordionTitleProps): Builder = new Builder(js.Array(this.component, p.asInstanceOf[js.Any]))
  
  implicit def make(companion: AccordionTitle.type): Builder = new Builder(js.Array(this.component, js.Dictionary.empty))()
}
