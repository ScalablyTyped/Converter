package typingsJapgolly.semanticUiReact.components

import japgolly.scalajs.react.raw.Empty
import japgolly.scalajs.react.raw.JsNumber
import japgolly.scalajs.react.raw.React.Element
import japgolly.scalajs.react.vdom.VdomElement
import typingsJapgolly.StBuildingComponent
import typingsJapgolly.semanticUiReact.genericMod.SemanticShorthandContent
import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

@scala.inline
class SharedBuilder_AccordionContentProps_1883056278 (val args: js.Array[js.Any])
  extends AnyVal
     with StBuildingComponent[scala.Nothing] {
  
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
}
