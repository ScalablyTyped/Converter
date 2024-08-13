package typingsJapgolly.react.components

import japgolly.scalajs.react.Callback
import japgolly.scalajs.react.CallbackTo
import typingsJapgolly.StBuildingComponent
import typingsJapgolly.react.semanticUiReactDistCommonjsElementsTestContainerTestContainerMod.TestContainerProps
import typingsJapgolly.react.semanticUiReactDistCommonjsGenericMod.SemanticShorthandContent
import typingsJapgolly.react.semanticUiReactDistCommonjsGenericMod.SemanticTEXTALIGNMENTS
import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

object TestContainer {
  
  inline def apply(
    requiredFn0Number: CallbackTo[Double],
    requiredFn0Void: Callback,
    requiredFn1Number: Double => Double,
    requiredFn1Void: Double => Callback
  ): Builder = {
    val __props = js.Dynamic.literal(requiredFn0Number = requiredFn0Number.toJsFn, requiredFn0Void = requiredFn0Void.toJsFn, requiredFn1Number = js.Any.fromFunction1(requiredFn1Number), requiredFn1Void = js.Any.fromFunction1((t0: Double) => requiredFn1Void(t0).runNow()))
    new Builder(js.Array(this.component, __props.asInstanceOf[TestContainerProps]))
  }
  
  @JSImport("react/semantic-ui-react/dist/commonjs/elements/TestContainer/TestContainer", JSImport.Default)
  @js.native
  val component: js.Object = js.native
  
  @scala.inline
  open class Builder (val args: js.Array[Any])
    extends AnyVal
       with StBuildingComponent[js.Object] {
    
    inline def as(value: Any): this.type = set("as", value.asInstanceOf[js.Any])
    
    inline def className(value: String): this.type = set("className", value.asInstanceOf[js.Any])
    
    inline def content(value: SemanticShorthandContent): this.type = set("content", value.asInstanceOf[js.Any])
    
    inline def fluid(value: Boolean): this.type = set("fluid", value.asInstanceOf[js.Any])
    
    inline def optFn0Number(value: CallbackTo[Double]): this.type = set("optFn0Number", value.toJsFn)
    
    inline def optFn0Void(value: Callback): this.type = set("optFn0Void", value.toJsFn)
    
    inline def optFn1Number(value: /* x */ Double => Double): this.type = set("optFn1Number", js.Any.fromFunction1(value))
    
    inline def optFn1Void(value: /* x */ Double => Callback): this.type = set("optFn1Void", js.Any.fromFunction1((t0: /* x */ Double) => value(t0).runNow()))
    
    inline def text(value: Boolean): this.type = set("text", value.asInstanceOf[js.Any])
    
    inline def textAlign(value: SemanticTEXTALIGNMENTS): this.type = set("textAlign", value.asInstanceOf[js.Any])
  }
  
  type Props = TestContainerProps
  
  def withProps(p: TestContainerProps): Builder = new Builder(js.Array(this.component, p.asInstanceOf[js.Any]))
}
