package typingsSlinky.semanticUiReact.components

import org.scalajs.dom.raw.HTMLDivElement
import slinky.web.SyntheticMouseEvent
import slinky.web.html.`*`.tag
import typingsSlinky.StBuildingComponent
import typingsSlinky.semanticUiReact.accordionPanelMod.AccordionPanelProps
import typingsSlinky.semanticUiReact.accordionTitleMod.AccordionTitleProps
import typingsSlinky.semanticUiReact.genericMod.SemanticShorthandCollection
import typingsSlinky.semanticUiReact.genericMod.SemanticShorthandItem
import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

@scala.inline
class SharedBuilder_AccordionAccordionProps_1044969128[R <: js.Object] (val args: js.Array[js.Any])
  extends AnyVal
     with StBuildingComponent[tag.type, R] {
  
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
  def onTitleClick(value: (/* event */ SyntheticMouseEvent[HTMLDivElement], /* data */ AccordionTitleProps) => Unit): this.type = set("onTitleClick", js.Any.fromFunction2(value))
  
  @scala.inline
  def panels(value: SemanticShorthandCollection[AccordionPanelProps]): this.type = set("panels", value.asInstanceOf[js.Any])
  
  @scala.inline
  def panelsVarargs(value: SemanticShorthandItem[AccordionPanelProps]*): this.type = set("panels", js.Array(value :_*))
}
