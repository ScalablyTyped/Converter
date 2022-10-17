package typingsJapgolly.semanticUiReact.components

import japgolly.scalajs.react.Callback
import japgolly.scalajs.react.ReactMouseEventFrom
import org.scalajs.dom.HTMLDivElement
import typingsJapgolly.StBuildingComponent
import typingsJapgolly.semanticUiReact.distCommonjsGenericMod.SemanticShorthandCollection
import typingsJapgolly.semanticUiReact.distCommonjsGenericMod.SemanticShorthandItem
import typingsJapgolly.semanticUiReact.distCommonjsModulesAccordionAccordionPanelMod.AccordionPanelProps
import typingsJapgolly.semanticUiReact.distCommonjsModulesAccordionAccordionTitleMod.AccordionTitleProps
import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

@scala.inline
open class SharedBuilder_AccordionAccordionProps600409291[R <: js.Object] (val args: js.Array[Any])
  extends AnyVal
     with StBuildingComponent[R] {
  
  inline def activeIndex(value: Double | js.Array[Double]): this.type = set("activeIndex", value.asInstanceOf[js.Any])
  
  inline def activeIndexVarargs(value: Double*): this.type = set("activeIndex", js.Array(value*))
  
  inline def as(value: Any): this.type = set("as", value.asInstanceOf[js.Any])
  
  inline def className(value: String): this.type = set("className", value.asInstanceOf[js.Any])
  
  inline def defaultActiveIndex(value: Double | js.Array[Double]): this.type = set("defaultActiveIndex", value.asInstanceOf[js.Any])
  
  inline def defaultActiveIndexVarargs(value: Double*): this.type = set("defaultActiveIndex", js.Array(value*))
  
  inline def exclusive(value: Boolean): this.type = set("exclusive", value.asInstanceOf[js.Any])
  
  inline def onTitleClick(
    value: (/* event */ ReactMouseEventFrom[HTMLDivElement], /* data */ AccordionTitleProps) => Callback
  ): this.type = set("onTitleClick", js.Any.fromFunction2((t0: /* event */ ReactMouseEventFrom[HTMLDivElement], t1: /* data */ AccordionTitleProps) => (value(t0, t1)).runNow()))
  
  inline def panels(value: SemanticShorthandCollection[AccordionPanelProps]): this.type = set("panels", value.asInstanceOf[js.Any])
  
  inline def panelsVarargs(value: SemanticShorthandItem[AccordionPanelProps]*): this.type = set("panels", js.Array(value*))
}
