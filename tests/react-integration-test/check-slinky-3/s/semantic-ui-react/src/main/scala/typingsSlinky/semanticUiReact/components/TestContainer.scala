package typingsSlinky.semanticUiReact.components

import slinky.web.html.`*`.tag
import typingsSlinky.StBuildingComponent
import typingsSlinky.semanticUiReact.genericMod.SemanticShorthandContent
import typingsSlinky.semanticUiReact.genericMod.SemanticTEXTALIGNMENTS
import typingsSlinky.semanticUiReact.testContainerTestContainerMod.TestContainerProps
import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

object TestContainer {
  
  @scala.inline
  def apply(
    requiredFn0Number: () => Double,
    requiredFn0Void: () => Unit,
    requiredFn1Number: Double => Double,
    requiredFn1Void: Double => Unit
  ): Builder = {
    val __props = js.Dynamic.literal(requiredFn0Number = js.Any.fromFunction0(requiredFn0Number), requiredFn0Void = js.Any.fromFunction0(requiredFn0Void), requiredFn1Number = js.Any.fromFunction1(requiredFn1Number), requiredFn1Void = js.Any.fromFunction1(requiredFn1Void))
    new Builder(js.Array(this.component, __props.asInstanceOf[TestContainerProps]))
  }
  
  @JSImport("semantic-ui-react/dist/commonjs/elements/TestContainer", JSImport.Default)
  @js.native
  val component: js.Object = js.native
  
  @scala.inline
  class Builder (val args: js.Array[js.Any])
    extends AnyVal
       with StBuildingComponent[tag.type, js.Object] {
    
    @scala.inline
    def as(value: js.Any): this.type = set("as", value.asInstanceOf[js.Any])
    
    @scala.inline
    def className(value: String): this.type = set("className", value.asInstanceOf[js.Any])
    
    @scala.inline
    def content(value: SemanticShorthandContent): this.type = set("content", value.asInstanceOf[js.Any])
    
    @scala.inline
    def fluid(value: Boolean): this.type = set("fluid", value.asInstanceOf[js.Any])
    
    @scala.inline
    def optFn0Number(value: () => Double): this.type = set("optFn0Number", js.Any.fromFunction0(value))
    
    @scala.inline
    def optFn0Void(value: () => Unit): this.type = set("optFn0Void", js.Any.fromFunction0(value))
    
    @scala.inline
    def optFn1Number(value: /* x */ Double => Double): this.type = set("optFn1Number", js.Any.fromFunction1(value))
    
    @scala.inline
    def optFn1Void(value: /* x */ Double => Unit): this.type = set("optFn1Void", js.Any.fromFunction1(value))
    
    @scala.inline
    def text(value: Boolean): this.type = set("text", value.asInstanceOf[js.Any])
    
    @scala.inline
    def textAlign(value: SemanticTEXTALIGNMENTS): this.type = set("textAlign", value.asInstanceOf[js.Any])
  }
  
  def withProps(p: TestContainerProps): Builder = new Builder(js.Array(this.component, p.asInstanceOf[js.Any]))
}
