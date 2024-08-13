package typingsJapgolly.react.components

import japgolly.scalajs.react.Callback
import japgolly.scalajs.react.ReactEventFrom
import org.scalajs.dom.HTMLInputElement
import typingsJapgolly.StBuildingComponent
import typingsJapgolly.react.reactStrings.`left corner`
import typingsJapgolly.react.reactStrings.`right corner`
import typingsJapgolly.react.reactStrings.huge
import typingsJapgolly.react.reactStrings.large
import typingsJapgolly.react.reactStrings.left
import typingsJapgolly.react.reactStrings.massive
import typingsJapgolly.react.reactStrings.mini
import typingsJapgolly.react.reactStrings.right
import typingsJapgolly.react.reactStrings.small
import typingsJapgolly.react.semanticUiReactDistCommonjsElementsInputInputMod.InputOnChangeData
import typingsJapgolly.react.semanticUiReactDistCommonjsElementsInputInputMod.InputProps
import typingsJapgolly.react.semanticUiReactDistCommonjsElementsInputInputMod.default
import typingsJapgolly.react.semanticUiReactDistCommonjsGenericMod.HtmlInputrops
import typingsJapgolly.react.semanticUiReactDistCommonjsGenericMod.SemanticShorthandItem
import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

object Input {
  
  @JSImport("react/semantic-ui-react/dist/commonjs/elements/Input/Input", JSImport.Default)
  @js.native
  val component: js.Object = js.native
  
  @scala.inline
  open class Builder (val args: js.Array[Any])
    extends AnyVal
       with StBuildingComponent[default] {
    
    inline def action(value: Any | Boolean): this.type = set("action", value.asInstanceOf[js.Any])
    
    inline def actionPosition(value: left): this.type = set("actionPosition", value.asInstanceOf[js.Any])
    
    inline def as(value: Any): this.type = set("as", value.asInstanceOf[js.Any])
    
    inline def className(value: String): this.type = set("className", value.asInstanceOf[js.Any])
    
    inline def disabled(value: Boolean): this.type = set("disabled", value.asInstanceOf[js.Any])
    
    inline def error(value: Boolean): this.type = set("error", value.asInstanceOf[js.Any])
    
    inline def fluid(value: Boolean): this.type = set("fluid", value.asInstanceOf[js.Any])
    
    inline def focus(value: Boolean): this.type = set("focus", value.asInstanceOf[js.Any])
    
    inline def icon(value: Any | SemanticShorthandItem[InputProps]): this.type = set("icon", value.asInstanceOf[js.Any])
    
    inline def iconPosition(value: left): this.type = set("iconPosition", value.asInstanceOf[js.Any])
    
    inline def input(value: SemanticShorthandItem[HtmlInputrops]): this.type = set("input", value.asInstanceOf[js.Any])
    
    inline def inverted(value: Boolean): this.type = set("inverted", value.asInstanceOf[js.Any])
    
    inline def label(
      value: SemanticShorthandItem[
          /* import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify LabelProps */ Any
        ]
    ): this.type = set("label", value.asInstanceOf[js.Any])
    
    inline def labelPosition(value: left | right | (`left corner`) | (`right corner`)): this.type = set("labelPosition", value.asInstanceOf[js.Any])
    
    inline def loading(value: Boolean): this.type = set("loading", value.asInstanceOf[js.Any])
    
    inline def onChange(value: (/* event */ ReactEventFrom[HTMLInputElement], /* data */ InputOnChangeData) => Callback): this.type = set("onChange", js.Any.fromFunction2((t0: /* event */ ReactEventFrom[HTMLInputElement], t1: /* data */ InputOnChangeData) => (value(t0, t1)).runNow()))
    
    inline def size(value: mini | small | large | typingsJapgolly.react.reactStrings.big | huge | massive): this.type = set("size", value.asInstanceOf[js.Any])
    
    inline def tabIndex(value: Double | String): this.type = set("tabIndex", value.asInstanceOf[js.Any])
    
    inline def transparent(value: Boolean): this.type = set("transparent", value.asInstanceOf[js.Any])
    
    inline def `type`(value: String): this.type = set("type", value.asInstanceOf[js.Any])
  }
  
  type Props = InputProps
  
  implicit def make(companion: Input.type): Builder = new Builder(js.Array(this.component, js.Dictionary.empty))()
  
  def withProps(p: InputProps): Builder = new Builder(js.Array(this.component, p.asInstanceOf[js.Any]))
}
