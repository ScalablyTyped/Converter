package typingsJapgolly.semanticUiReact.components

import japgolly.scalajs.react.raw.Empty
import japgolly.scalajs.react.raw.JsNumber
import japgolly.scalajs.react.raw.React.Element
import japgolly.scalajs.react.vdom.VdomElement
import typingsJapgolly.StBuildingComponent
import typingsJapgolly.semanticUiReact.buttonMod.ButtonProps
import typingsJapgolly.semanticUiReact.genericMod.SemanticCOLORS
import typingsJapgolly.semanticUiReact.genericMod.SemanticFLOATS
import typingsJapgolly.semanticUiReact.genericMod.SemanticSIZES
import typingsJapgolly.semanticUiReact.genericMod.SemanticShorthandCollection
import typingsJapgolly.semanticUiReact.genericMod.SemanticShorthandContent
import typingsJapgolly.semanticUiReact.genericMod.SemanticShorthandItem
import typingsJapgolly.semanticUiReact.genericMod.SemanticWIDTHS
import typingsJapgolly.semanticUiReact.semanticUiReactStrings.bottom
import typingsJapgolly.semanticUiReact.semanticUiReactStrings.left
import typingsJapgolly.semanticUiReact.semanticUiReactStrings.right
import typingsJapgolly.semanticUiReact.semanticUiReactStrings.top
import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

@scala.inline
class SharedBuilder_ButtonGroupProps_158814638 (val args: js.Array[js.Any])
  extends AnyVal
     with StBuildingComponent[scala.Nothing] {
  
  @scala.inline
  def as(value: js.Any): this.type = set("as", value.asInstanceOf[js.Any])
  
  @scala.inline
  def attached(value: Boolean | left | right | top | bottom): this.type = set("attached", value.asInstanceOf[js.Any])
  
  @scala.inline
  def basic(value: Boolean): this.type = set("basic", value.asInstanceOf[js.Any])
  
  @scala.inline
  def buttons(value: SemanticShorthandCollection[ButtonProps]): this.type = set("buttons", value.asInstanceOf[js.Any])
  
  @scala.inline
  def buttonsVarargs(value: SemanticShorthandItem[ButtonProps]*): this.type = set("buttons", js.Array(value :_*))
  
  @scala.inline
  def className(value: String): this.type = set("className", value.asInstanceOf[js.Any])
  
  @scala.inline
  def color(value: SemanticCOLORS): this.type = set("color", value.asInstanceOf[js.Any])
  
  @scala.inline
  def compact(value: Boolean): this.type = set("compact", value.asInstanceOf[js.Any])
  
  @scala.inline
  def content(value: SemanticShorthandContent): this.type = set("content", value.asInstanceOf[js.Any])
  
  @scala.inline
  def contentNull: this.type = set("content", null)
  
  @scala.inline
  def contentVarargs(value: (Empty | String | JsNumber | Element)*): this.type = set("content", js.Array(value :_*))
  
  @scala.inline
  def contentVdomElement(value: VdomElement): this.type = set("content", value.rawElement.asInstanceOf[js.Any])
  
  @scala.inline
  def floated(value: SemanticFLOATS): this.type = set("floated", value.asInstanceOf[js.Any])
  
  @scala.inline
  def fluid(value: Boolean): this.type = set("fluid", value.asInstanceOf[js.Any])
  
  @scala.inline
  def icon(value: Boolean): this.type = set("icon", value.asInstanceOf[js.Any])
  
  @scala.inline
  def inverted(value: Boolean): this.type = set("inverted", value.asInstanceOf[js.Any])
  
  @scala.inline
  def labeled(value: Boolean): this.type = set("labeled", value.asInstanceOf[js.Any])
  
  @scala.inline
  def negative(value: Boolean): this.type = set("negative", value.asInstanceOf[js.Any])
  
  @scala.inline
  def positive(value: Boolean): this.type = set("positive", value.asInstanceOf[js.Any])
  
  @scala.inline
  def primary(value: Boolean): this.type = set("primary", value.asInstanceOf[js.Any])
  
  @scala.inline
  def secondary(value: Boolean): this.type = set("secondary", value.asInstanceOf[js.Any])
  
  @scala.inline
  def size(value: SemanticSIZES): this.type = set("size", value.asInstanceOf[js.Any])
  
  @scala.inline
  def toggle(value: Boolean): this.type = set("toggle", value.asInstanceOf[js.Any])
  
  @scala.inline
  def vertical(value: Boolean): this.type = set("vertical", value.asInstanceOf[js.Any])
  
  @scala.inline
  def widths(value: SemanticWIDTHS): this.type = set("widths", value.asInstanceOf[js.Any])
}
