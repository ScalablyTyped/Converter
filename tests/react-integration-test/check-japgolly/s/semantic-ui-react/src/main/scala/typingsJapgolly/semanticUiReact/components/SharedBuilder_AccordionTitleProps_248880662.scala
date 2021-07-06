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
import typingsJapgolly.semanticUiReact.accordionTitleMod.AccordionTitleProps
import typingsJapgolly.semanticUiReact.genericMod.SemanticShorthandContent
import typingsJapgolly.semanticUiReact.genericMod.SemanticShorthandItem
import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

@scala.inline
class SharedBuilder_AccordionTitleProps_248880662[R <: js.Object] (val args: js.Array[js.Any])
  extends AnyVal
     with StBuildingComponent[R] {
  
  @scala.inline
  def active(value: Boolean): this.type = set("active", value.asInstanceOf[js.Any])
  
  @scala.inline
  def as(value: js.Any): this.type = set("as", value.asInstanceOf[js.Any])
  
  @scala.inline
  def className(value: String): this.type = set("className", value.asInstanceOf[js.Any])
  
  @scala.inline
  def content(value: SemanticShorthandContent): this.type = set("content", value.asInstanceOf[js.Any])
  
  @scala.inline
  def contentNull: this.type = set("content", null)
  
  @scala.inline
  def contentVarargs(value: (Empty | String | JsNumber | Element)*): this.type = set("content", js.Array(value :_*))
  
  @scala.inline
  def contentVdomElement(value: VdomElement): this.type = set("content", value.rawElement.asInstanceOf[js.Any])
  
  @scala.inline
  def icon(
    value: SemanticShorthandItem[
      /* import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify IconProps */ js.Any
    ]
  ): this.type = set("icon", value.asInstanceOf[js.Any])
  
  @scala.inline
  def iconFunction3(
    value: (/* component */ ReactType[
      /* import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify IconProps */ js.Any
    ], /* import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify IconProps */ js.Any, /* children */ js.UndefOr[Node | ReactNodeArray]) => Element | Null
  ): this.type = set("icon", js.Any.fromFunction3(value))
  
  @scala.inline
  def iconNull: this.type = set("icon", null)
  
  @scala.inline
  def iconVarargs(value: (Empty | String | JsNumber | Element)*): this.type = set("icon", js.Array(value :_*))
  
  @scala.inline
  def iconVdomElement(value: VdomElement): this.type = set("icon", value.rawElement.asInstanceOf[js.Any])
  
  @scala.inline
  def index(value: Double | String): this.type = set("index", value.asInstanceOf[js.Any])
  
  @scala.inline
  def onClick(
    value: (/* event */ ReactMouseEventFrom[HTMLDivElement], /* data */ AccordionTitleProps) => Callback
  ): this.type = set("onClick", js.Any.fromFunction2((t0: /* event */ ReactMouseEventFrom[HTMLDivElement], t1: /* data */ AccordionTitleProps) => (value(t0, t1)).runNow()))
}
