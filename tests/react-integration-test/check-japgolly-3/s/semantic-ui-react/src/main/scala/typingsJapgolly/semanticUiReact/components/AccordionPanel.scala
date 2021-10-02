package typingsJapgolly.semanticUiReact.components

import japgolly.scalajs.react.Callback
import japgolly.scalajs.react.ReactMouseEventFrom
import japgolly.scalajs.react.raw.Empty
import japgolly.scalajs.react.raw.JsNumber
import japgolly.scalajs.react.raw.React.Element
import japgolly.scalajs.react.raw.React.Node
import japgolly.scalajs.react.vdom.VdomElement
import org.scalajs.dom.raw.HTMLDivElement
import typingsJapgolly.StBuildingComponent
import typingsJapgolly.react.mod.ReactNodeArray
import typingsJapgolly.react.mod.ReactType
import typingsJapgolly.semanticUiReact.accordionContentMod.AccordionContentProps
import typingsJapgolly.semanticUiReact.accordionPanelMod.AccordionPanelProps
import typingsJapgolly.semanticUiReact.accordionPanelMod.default
import typingsJapgolly.semanticUiReact.accordionTitleMod.AccordionTitleProps
import typingsJapgolly.semanticUiReact.genericMod.SemanticShorthandItem
import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

object AccordionPanel {
  
  @JSImport("semantic-ui-react/dist/commonjs/modules/Accordion/AccordionPanel", JSImport.Default)
  @js.native
  val component: js.Object = js.native
  
  @scala.inline
  open class Builder (val args: js.Array[js.Any])
    extends AnyVal
       with StBuildingComponent[default] {
    
    inline def active(value: Boolean): this.type = set("active", value.asInstanceOf[js.Any])
    
    inline def content(value: SemanticShorthandItem[AccordionContentProps]): this.type = set("content", value.asInstanceOf[js.Any])
    
    inline def contentFunction3(
      value: (/* component */ ReactType[AccordionContentProps], AccordionContentProps, /* children */ js.UndefOr[Node | ReactNodeArray]) => Element | Null
    ): this.type = set("content", js.Any.fromFunction3(value))
    
    inline def contentNull: this.type = set("content", null)
    
    inline def contentVarargs(value: (Empty | String | JsNumber | Element)*): this.type = set("content", js.Array(value*))
    
    inline def contentVdomElement(value: VdomElement): this.type = set("content", value.rawElement.asInstanceOf[js.Any])
    
    inline def index(value: Double | String): this.type = set("index", value.asInstanceOf[js.Any])
    
    inline def onTitleClick(
      value: (/* event */ ReactMouseEventFrom[HTMLDivElement], /* data */ AccordionTitleProps) => Callback
    ): this.type = set("onTitleClick", js.Any.fromFunction2((t0: /* event */ ReactMouseEventFrom[HTMLDivElement], t1: /* data */ AccordionTitleProps) => (value(t0, t1)).runNow()))
    
    inline def title(value: SemanticShorthandItem[AccordionTitleProps]): this.type = set("title", value.asInstanceOf[js.Any])
    
    inline def titleFunction3(
      value: (/* component */ ReactType[AccordionTitleProps], AccordionTitleProps, /* children */ js.UndefOr[Node | ReactNodeArray]) => Element | Null
    ): this.type = set("title", js.Any.fromFunction3(value))
    
    inline def titleNull: this.type = set("title", null)
    
    inline def titleVarargs(value: (Empty | String | JsNumber | Element)*): this.type = set("title", js.Array(value*))
    
    inline def titleVdomElement(value: VdomElement): this.type = set("title", value.rawElement.asInstanceOf[js.Any])
  }
  
  implicit def make(companion: AccordionPanel.type): Builder = new Builder(js.Array(this.component, js.Dictionary.empty))()
  
  def withProps(p: AccordionPanelProps): Builder = new Builder(js.Array(this.component, p.asInstanceOf[js.Any]))
}
