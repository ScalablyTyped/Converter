package typingsSlinky.react

import org.scalablytyped.runtime.Shortcut
import org.scalablytyped.runtime.StringDictionary
import slinky.core.ReactComponentClass
import slinky.core.facade.ReactElement
import typingsSlinky.react.semanticUiReactDistCommonjsGenericMod.SemanticShorthandContent
import typingsSlinky.react.semanticUiReactDistCommonjsGenericMod.SemanticTEXTALIGNMENTS
import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

object semanticUiReactDistCommonjsElementsTestContainerTestContainerMod extends Shortcut {
  
  @JSImport("react/semantic-ui-react/dist/commonjs/elements/TestContainer/TestContainer", JSImport.Default)
  @js.native
  val default: ReactComponentClass[TestContainerProps] = js.native
  
  trait StrictTestContainerProps extends StObject {
    
    /** An element type to render as (string or function). */
    var as: js.UndefOr[Any] = js.undefined
    
    /** Primary content. */
    var children: js.UndefOr[ReactElement] = js.undefined
    
    /** Additional classes. */
    var className: js.UndefOr[String] = js.undefined
    
    /** Shorthand for primary content. */
    var content: js.UndefOr[SemanticShorthandContent] = js.undefined
    
    /** TestContainer has no maximum width. */
    var fluid: js.UndefOr[Boolean] = js.undefined
    
    /**Should be CallbackTo[Number]*/
    var optFn0Number: js.UndefOr[js.Function0[Double]] = js.undefined
    
    /**Should be Callback*/
    var optFn0Void: js.UndefOr[js.Function0[Unit]] = js.undefined
    
    /**Should be (x:Number) => CallbackTo[Number]*/
    var optFn1Number: js.UndefOr[js.Function1[/* x */ Double, Double]] = js.undefined
    
    /**Should be (x:Number) => Callback*/
    var optFn1Void: js.UndefOr[js.Function1[/* x */ Double, Unit]] = js.undefined
    
    /**Should be CallbackTo[Number]*/
    def requiredFn0Number(): Double
    
    /**Should be Callback*/
    def requiredFn0Void(): Unit
    
    /**Should be (x:Number) => CallbackTo[Number]*/
    def requiredFn1Number(x: Double): Double
    
    /**Should be (x:Number) => Callback*/
    def requiredFn1Void(x: Double): Unit
    
    /** Reduce maximum width to more naturally accommodate text. */
    var text: js.UndefOr[Boolean] = js.undefined
    
    /** Describes how the text inside this component should be aligned. */
    var textAlign: js.UndefOr[SemanticTEXTALIGNMENTS] = js.undefined
  }
  object StrictTestContainerProps {
    
    inline def apply(
      requiredFn0Number: () => Double,
      requiredFn0Void: () => Unit,
      requiredFn1Number: Double => Double,
      requiredFn1Void: Double => Unit
    ): StrictTestContainerProps = {
      val __obj = js.Dynamic.literal(requiredFn0Number = js.Any.fromFunction0(requiredFn0Number), requiredFn0Void = js.Any.fromFunction0(requiredFn0Void), requiredFn1Number = js.Any.fromFunction1(requiredFn1Number), requiredFn1Void = js.Any.fromFunction1(requiredFn1Void))
      __obj.asInstanceOf[StrictTestContainerProps]
    }
    
    @scala.inline
    implicit open class MutableBuilder[Self <: StrictTestContainerProps] (val x: Self) extends AnyVal {
      
      inline def setAs(value: Any): Self = StObject.set(x, "as", value.asInstanceOf[js.Any])
      
      inline def setAsUndefined: Self = StObject.set(x, "as", js.undefined)
      
      inline def setChildren(value: ReactElement): Self = StObject.set(x, "children", value.asInstanceOf[js.Any])
      
      inline def setChildrenUndefined: Self = StObject.set(x, "children", js.undefined)
      
      inline def setClassName(value: String): Self = StObject.set(x, "className", value.asInstanceOf[js.Any])
      
      inline def setClassNameUndefined: Self = StObject.set(x, "className", js.undefined)
      
      inline def setContent(value: SemanticShorthandContent): Self = StObject.set(x, "content", value.asInstanceOf[js.Any])
      
      inline def setContentUndefined: Self = StObject.set(x, "content", js.undefined)
      
      inline def setFluid(value: Boolean): Self = StObject.set(x, "fluid", value.asInstanceOf[js.Any])
      
      inline def setFluidUndefined: Self = StObject.set(x, "fluid", js.undefined)
      
      inline def setOptFn0Number(value: () => Double): Self = StObject.set(x, "optFn0Number", js.Any.fromFunction0(value))
      
      inline def setOptFn0NumberUndefined: Self = StObject.set(x, "optFn0Number", js.undefined)
      
      inline def setOptFn0Void(value: () => Unit): Self = StObject.set(x, "optFn0Void", js.Any.fromFunction0(value))
      
      inline def setOptFn0VoidUndefined: Self = StObject.set(x, "optFn0Void", js.undefined)
      
      inline def setOptFn1Number(value: /* x */ Double => Double): Self = StObject.set(x, "optFn1Number", js.Any.fromFunction1(value))
      
      inline def setOptFn1NumberUndefined: Self = StObject.set(x, "optFn1Number", js.undefined)
      
      inline def setOptFn1Void(value: /* x */ Double => Unit): Self = StObject.set(x, "optFn1Void", js.Any.fromFunction1(value))
      
      inline def setOptFn1VoidUndefined: Self = StObject.set(x, "optFn1Void", js.undefined)
      
      inline def setRequiredFn0Number(value: () => Double): Self = StObject.set(x, "requiredFn0Number", js.Any.fromFunction0(value))
      
      inline def setRequiredFn0Void(value: () => Unit): Self = StObject.set(x, "requiredFn0Void", js.Any.fromFunction0(value))
      
      inline def setRequiredFn1Number(value: Double => Double): Self = StObject.set(x, "requiredFn1Number", js.Any.fromFunction1(value))
      
      inline def setRequiredFn1Void(value: Double => Unit): Self = StObject.set(x, "requiredFn1Void", js.Any.fromFunction1(value))
      
      inline def setText(value: Boolean): Self = StObject.set(x, "text", value.asInstanceOf[js.Any])
      
      inline def setTextAlign(value: SemanticTEXTALIGNMENTS): Self = StObject.set(x, "textAlign", value.asInstanceOf[js.Any])
      
      inline def setTextAlignUndefined: Self = StObject.set(x, "textAlign", js.undefined)
      
      inline def setTextUndefined: Self = StObject.set(x, "text", js.undefined)
    }
  }
  
  trait TestContainerProps
    extends StObject
       with StrictTestContainerProps
       with /* key */ StringDictionary[Any]
  object TestContainerProps {
    
    inline def apply(
      requiredFn0Number: () => Double,
      requiredFn0Void: () => Unit,
      requiredFn1Number: Double => Double,
      requiredFn1Void: Double => Unit
    ): TestContainerProps = {
      val __obj = js.Dynamic.literal(requiredFn0Number = js.Any.fromFunction0(requiredFn0Number), requiredFn0Void = js.Any.fromFunction0(requiredFn0Void), requiredFn1Number = js.Any.fromFunction1(requiredFn1Number), requiredFn1Void = js.Any.fromFunction1(requiredFn1Void))
      __obj.asInstanceOf[TestContainerProps]
    }
  }
  
  type _To = ReactComponentClass[TestContainerProps]
  
  /* This means you don't have to write `default`, but can instead just say `semanticUiReactDistCommonjsElementsTestContainerTestContainerMod.foo` */
  override def _to: ReactComponentClass[TestContainerProps] = default
}
