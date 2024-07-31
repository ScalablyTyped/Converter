package typingsSlinky.semanticUiReact.components

import _root_.typingsSlinky.StBuildingComponent
import _root_.typingsSlinky.react.mod.ReactNodeArray
import _root_.typingsSlinky.react.mod.ReactType
import _root_.typingsSlinky.semanticUiReact.distCommonjsGenericMod.SemanticShorthandContent
import _root_.typingsSlinky.semanticUiReact.distCommonjsGenericMod.SemanticShorthandItem
import _root_.typingsSlinky.semanticUiReact.distCommonjsModulesAccordionAccordionTitleMod.AccordionTitleProps
import org.scalajs.dom.HTMLDivElement
import slinky.core.facade.ReactElement
import slinky.web.SyntheticMouseEvent
import slinky.web.html.`*`.tag
import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

@scala.inline
open class SharedBuilder_AccordionTitleProps_420803499[R <: js.Object] (val args: js.Array[Any])
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
  
  inline def iconFunction3(
    value: (/* component */ ReactType[
      /* import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify IconProps */ Any
    ], /* import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify IconProps */ Any, /* children */ js.UndefOr[ReactElement | ReactNodeArray]) => ReactElement | Null
  ): this.type = set("icon", js.Any.fromFunction3(value))
  
  inline def iconReactElement(value: ReactElement): this.type = set("icon", value.asInstanceOf[js.Any])
  
  inline def index(value: Double | String): this.type = set("index", value.asInstanceOf[js.Any])
  
  inline def onClick(value: (/* event */ SyntheticMouseEvent[HTMLDivElement], /* data */ AccordionTitleProps) => Unit): this.type = set("onClick", js.Any.fromFunction2(value))
}
