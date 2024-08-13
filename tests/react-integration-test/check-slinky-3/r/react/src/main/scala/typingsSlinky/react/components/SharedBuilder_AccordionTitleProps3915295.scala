package typingsSlinky.react.components

import org.scalajs.dom.HTMLDivElement
import slinky.web.SyntheticMouseEvent
import slinky.web.html.`*`.tag
import typingsSlinky.StBuildingComponent
import typingsSlinky.react.semanticUiReactDistCommonjsGenericMod.SemanticShorthandContent
import typingsSlinky.react.semanticUiReactDistCommonjsGenericMod.SemanticShorthandItem
import typingsSlinky.react.semanticUiReactDistCommonjsModulesAccordionAccordionTitleMod.AccordionTitleProps
import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

@scala.inline
open class SharedBuilder_AccordionTitleProps3915295[R <: js.Object] (val args: js.Array[Any])
  extends AnyVal
     with StBuildingComponent[tag.type, R] {
  
  inline def active(value: Boolean): this.type = set("active", value.asInstanceOf[js.Any])
  
  inline def as(value: Any): this.type = set("as", value.asInstanceOf[js.Any])
  
  inline def className(value: String): this.type = set("className", value.asInstanceOf[js.Any])
  
  inline def content(value: SemanticShorthandContent): this.type = set("content", value.asInstanceOf[js.Any])
  
  inline def icon(
    value: SemanticShorthandItem[
      /* import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify IconProps */ Any
    ]
  ): this.type = set("icon", value.asInstanceOf[js.Any])
  
  inline def index(value: Double | String): this.type = set("index", value.asInstanceOf[js.Any])
  
  inline def onClick(value: (/* event */ SyntheticMouseEvent[HTMLDivElement], /* data */ AccordionTitleProps) => Unit): this.type = set("onClick", js.Any.fromFunction2(value))
}
