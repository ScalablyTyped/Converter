package typingsJapgolly.react.components

import japgolly.scalajs.react.Callback
import japgolly.scalajs.react.ReactMouseEventFrom
import org.scalajs.dom.HTMLButtonElement
import typingsJapgolly.StBuildingComponent
import typingsJapgolly.react.reactStrings.`google plus`
import typingsJapgolly.react.reactStrings.bottom
import typingsJapgolly.react.reactStrings.facebook
import typingsJapgolly.react.reactStrings.fade
import typingsJapgolly.react.reactStrings.instagram
import typingsJapgolly.react.reactStrings.left
import typingsJapgolly.react.reactStrings.linkedin
import typingsJapgolly.react.reactStrings.right
import typingsJapgolly.react.reactStrings.top
import typingsJapgolly.react.reactStrings.twitter
import typingsJapgolly.react.reactStrings.vertical
import typingsJapgolly.react.reactStrings.vk
import typingsJapgolly.react.reactStrings.youtube
import typingsJapgolly.react.semanticUiReactDistCommonjsElementsButtonButtonContentMod.ButtonContentProps
import typingsJapgolly.react.semanticUiReactDistCommonjsElementsButtonButtonGroupMod.ButtonGroupProps
import typingsJapgolly.react.semanticUiReactDistCommonjsElementsButtonButtonMod.ButtonProps
import typingsJapgolly.react.semanticUiReactDistCommonjsElementsButtonButtonMod.default
import typingsJapgolly.react.semanticUiReactDistCommonjsElementsButtonButtonOrMod.ButtonOrProps
import typingsJapgolly.react.semanticUiReactDistCommonjsGenericMod.SemanticCOLORS
import typingsJapgolly.react.semanticUiReactDistCommonjsGenericMod.SemanticFLOATS
import typingsJapgolly.react.semanticUiReactDistCommonjsGenericMod.SemanticSIZES
import typingsJapgolly.react.semanticUiReactDistCommonjsGenericMod.SemanticShorthandCollection
import typingsJapgolly.react.semanticUiReactDistCommonjsGenericMod.SemanticShorthandContent
import typingsJapgolly.react.semanticUiReactDistCommonjsGenericMod.SemanticShorthandItem
import typingsJapgolly.react.semanticUiReactDistCommonjsGenericMod.SemanticWIDTHS
import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

object Button {
  
  object Content {
    
    @JSImport("react/semantic-ui-react/dist/commonjs/elements/Button/Button", "default.Content")
    @js.native
    val component: js.Object = js.native
    
    type Props = ButtonContentProps
    
    implicit def make(companion: Content.type): SharedBuilder_ButtonContentProps_459071374 = new SharedBuilder_ButtonContentProps_459071374(js.Array(this.component, js.Dictionary.empty))()
    
    def withProps(p: ButtonContentProps): SharedBuilder_ButtonContentProps_459071374 = new SharedBuilder_ButtonContentProps_459071374(js.Array(this.component, p.asInstanceOf[js.Any]))
  }
  
  object Group {
    
    @JSImport("react/semantic-ui-react/dist/commonjs/elements/Button/Button", "default.Group")
    @js.native
    val component: js.Object = js.native
    
    @scala.inline
    open class Builder (val args: js.Array[Any])
      extends AnyVal
         with StBuildingComponent[js.Object] {
      
      inline def as(value: Any): this.type = set("as", value.asInstanceOf[js.Any])
      
      inline def attached(value: Boolean | left | right | top | bottom): this.type = set("attached", value.asInstanceOf[js.Any])
      
      inline def basic(value: Boolean): this.type = set("basic", value.asInstanceOf[js.Any])
      
      inline def buttons(value: SemanticShorthandCollection[ButtonProps]): this.type = set("buttons", value.asInstanceOf[js.Any])
      
      inline def buttonsVarargs(value: SemanticShorthandItem[ButtonProps]*): this.type = set("buttons", js.Array(value*))
      
      inline def className(value: String): this.type = set("className", value.asInstanceOf[js.Any])
      
      inline def color(value: SemanticCOLORS): this.type = set("color", value.asInstanceOf[js.Any])
      
      inline def compact(value: Boolean): this.type = set("compact", value.asInstanceOf[js.Any])
      
      inline def content(value: SemanticShorthandContent): this.type = set("content", value.asInstanceOf[js.Any])
      
      inline def floated(value: SemanticFLOATS): this.type = set("floated", value.asInstanceOf[js.Any])
      
      inline def fluid(value: Boolean): this.type = set("fluid", value.asInstanceOf[js.Any])
      
      inline def icon(value: Boolean): this.type = set("icon", value.asInstanceOf[js.Any])
      
      inline def inverted(value: Boolean): this.type = set("inverted", value.asInstanceOf[js.Any])
      
      inline def labeled(value: Boolean): this.type = set("labeled", value.asInstanceOf[js.Any])
      
      inline def negative(value: Boolean): this.type = set("negative", value.asInstanceOf[js.Any])
      
      inline def positive(value: Boolean): this.type = set("positive", value.asInstanceOf[js.Any])
      
      inline def primary(value: Boolean): this.type = set("primary", value.asInstanceOf[js.Any])
      
      inline def secondary(value: Boolean): this.type = set("secondary", value.asInstanceOf[js.Any])
      
      inline def size(value: SemanticSIZES): this.type = set("size", value.asInstanceOf[js.Any])
      
      inline def toggle(value: Boolean): this.type = set("toggle", value.asInstanceOf[js.Any])
      
      inline def vertical(value: Boolean): this.type = set("vertical", value.asInstanceOf[js.Any])
      
      inline def widths(value: SemanticWIDTHS): this.type = set("widths", value.asInstanceOf[js.Any])
    }
    
    type Props = ButtonGroupProps
    
    implicit def make(companion: Group.type): typingsJapgolly.react.components.Button.Group.Builder = new typingsJapgolly.react.components.Button.Group.Builder(js.Array(this.component, js.Dictionary.empty))()
    
    def withProps(p: ButtonGroupProps): typingsJapgolly.react.components.Button.Group.Builder = new typingsJapgolly.react.components.Button.Group.Builder(js.Array(this.component, p.asInstanceOf[js.Any]))
  }
  
  object Or {
    
    @JSImport("react/semantic-ui-react/dist/commonjs/elements/Button/Button", "default.Or")
    @js.native
    val component: js.Object = js.native
    
    type Props = ButtonOrProps
    
    implicit def make(companion: Or.type): SharedBuilder_ButtonOrProps2121472179 = new SharedBuilder_ButtonOrProps2121472179(js.Array(this.component, js.Dictionary.empty))()
    
    def withProps(p: ButtonOrProps): SharedBuilder_ButtonOrProps2121472179 = new SharedBuilder_ButtonOrProps2121472179(js.Array(this.component, p.asInstanceOf[js.Any]))
  }
  
  @JSImport("react/semantic-ui-react/dist/commonjs/elements/Button/Button", JSImport.Default)
  @js.native
  val component: js.Object = js.native
  
  @scala.inline
  open class Builder (val args: js.Array[Any])
    extends AnyVal
       with StBuildingComponent[default] {
    
    inline def active(value: Boolean): this.type = set("active", value.asInstanceOf[js.Any])
    
    inline def animated(value: Boolean | fade | vertical): this.type = set("animated", value.asInstanceOf[js.Any])
    
    inline def as(value: Any): this.type = set("as", value.asInstanceOf[js.Any])
    
    inline def attached(value: Boolean | left | right | top | bottom): this.type = set("attached", value.asInstanceOf[js.Any])
    
    inline def basic(value: Boolean): this.type = set("basic", value.asInstanceOf[js.Any])
    
    inline def circular(value: Boolean): this.type = set("circular", value.asInstanceOf[js.Any])
    
    inline def className(value: String): this.type = set("className", value.asInstanceOf[js.Any])
    
    inline def color(value: SemanticCOLORS | facebook | (`google plus`) | vk | twitter | linkedin | instagram | youtube): this.type = set("color", value.asInstanceOf[js.Any])
    
    inline def compact(value: Boolean): this.type = set("compact", value.asInstanceOf[js.Any])
    
    inline def content(value: SemanticShorthandContent): this.type = set("content", value.asInstanceOf[js.Any])
    
    inline def disabled(value: Boolean): this.type = set("disabled", value.asInstanceOf[js.Any])
    
    inline def floated(value: SemanticFLOATS): this.type = set("floated", value.asInstanceOf[js.Any])
    
    inline def fluid(value: Boolean): this.type = set("fluid", value.asInstanceOf[js.Any])
    
    inline def icon(
      value: Boolean | (SemanticShorthandItem[
          /* import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify IconProps */ Any
        ])
    ): this.type = set("icon", value.asInstanceOf[js.Any])
    
    inline def inverted(value: Boolean): this.type = set("inverted", value.asInstanceOf[js.Any])
    
    inline def label(
      value: SemanticShorthandItem[
          /* import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify LabelProps */ Any
        ]
    ): this.type = set("label", value.asInstanceOf[js.Any])
    
    inline def labelPosition(value: right | left): this.type = set("labelPosition", value.asInstanceOf[js.Any])
    
    inline def loading(value: Boolean): this.type = set("loading", value.asInstanceOf[js.Any])
    
    inline def negative(value: Boolean): this.type = set("negative", value.asInstanceOf[js.Any])
    
    inline def onClick(value: (/* event */ ReactMouseEventFrom[HTMLButtonElement], /* data */ ButtonProps) => Callback): this.type = set("onClick", js.Any.fromFunction2((t0: /* event */ ReactMouseEventFrom[HTMLButtonElement], t1: /* data */ ButtonProps) => (value(t0, t1)).runNow()))
    
    inline def positive(value: Boolean): this.type = set("positive", value.asInstanceOf[js.Any])
    
    inline def primary(value: Boolean): this.type = set("primary", value.asInstanceOf[js.Any])
    
    inline def role(value: String): this.type = set("role", value.asInstanceOf[js.Any])
    
    inline def secondary(value: Boolean): this.type = set("secondary", value.asInstanceOf[js.Any])
    
    inline def size(value: SemanticSIZES): this.type = set("size", value.asInstanceOf[js.Any])
    
    inline def tabIndex(value: Double | String): this.type = set("tabIndex", value.asInstanceOf[js.Any])
    
    inline def toggle(value: Boolean): this.type = set("toggle", value.asInstanceOf[js.Any])
  }
  
  type Props = ButtonProps
  
  implicit def make(companion: Button.type): Builder = new Builder(js.Array(this.component, js.Dictionary.empty))()
  
  def withProps(p: ButtonProps): Builder = new Builder(js.Array(this.component, p.asInstanceOf[js.Any]))
}
