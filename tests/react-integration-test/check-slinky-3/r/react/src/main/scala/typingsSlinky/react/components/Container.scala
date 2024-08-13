package typingsSlinky.react.components

import slinky.web.html.`*`.tag
import typingsSlinky.StBuildingComponent
import typingsSlinky.react.semanticUiReactDistCommonjsElementsContainerContainerMod.ContainerProps
import typingsSlinky.react.semanticUiReactDistCommonjsGenericMod.SemanticShorthandContent
import typingsSlinky.react.semanticUiReactDistCommonjsGenericMod.SemanticTEXTALIGNMENTS
import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

object Container {
  
  @JSImport("react/semantic-ui-react/dist/commonjs/elements/Container", JSImport.Default)
  @js.native
  val component: js.Object = js.native
  
  @scala.inline
  open class Builder (val args: js.Array[Any])
    extends AnyVal
       with StBuildingComponent[tag.type, js.Object] {
    
    inline def as(value: Any): this.type = set("as", value.asInstanceOf[js.Any])
    
    inline def className(value: String): this.type = set("className", value.asInstanceOf[js.Any])
    
    inline def content(value: SemanticShorthandContent): this.type = set("content", value.asInstanceOf[js.Any])
    
    inline def fluid(value: Boolean): this.type = set("fluid", value.asInstanceOf[js.Any])
    
    inline def text(value: Boolean): this.type = set("text", value.asInstanceOf[js.Any])
    
    inline def textAlign(value: SemanticTEXTALIGNMENTS): this.type = set("textAlign", value.asInstanceOf[js.Any])
  }
  
  type Props = ContainerProps
  
  implicit def make(companion: Container.type): Builder = new Builder(js.Array(this.component, js.Dictionary.empty))()
  
  def withProps(p: ContainerProps): Builder = new Builder(js.Array(this.component, p.asInstanceOf[js.Any]))
}
