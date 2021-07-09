package typingsJapgolly.semanticUiReact.components

import japgolly.scalajs.react.Callback
import japgolly.scalajs.react.ReactMouseEventFrom
import org.scalajs.dom.raw.HTMLDivElement
import typingsJapgolly.StBuildingComponent
import typingsJapgolly.semanticUiReact.accordionPanelMod.AccordionPanelProps
import typingsJapgolly.semanticUiReact.accordionTitleMod.AccordionTitleProps
import typingsJapgolly.semanticUiReact.genericMod.SemanticShorthandCollection
import typingsJapgolly.semanticUiReact.genericMod.SemanticShorthandItem
import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

@scala.inline
class SharedBuilder_AccordionAccordionProps1188692388[R <: js.Object] (val args: js.Array[js.Any])
  extends AnyVal
     with StBuildingComponent[R] {
  
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
  def onTitleClick(
    value: (/* event */ ReactMouseEventFrom[HTMLDivElement], /* data */ AccordionTitleProps) => Callback
  ): this.type = set("onTitleClick", js.Any.fromFunction2((t0: /* event */ ReactMouseEventFrom[HTMLDivElement], t1: /* data */ AccordionTitleProps) => (value(t0, t1)).runNow()))
  
  @scala.inline
  def panels(value: SemanticShorthandCollection[AccordionPanelProps]): this.type = set("panels", value.asInstanceOf[js.Any])
  
  @scala.inline
  def panelsVarargs(value: SemanticShorthandItem[AccordionPanelProps]*): this.type = set("panels", js.Array(value :_*))
}
