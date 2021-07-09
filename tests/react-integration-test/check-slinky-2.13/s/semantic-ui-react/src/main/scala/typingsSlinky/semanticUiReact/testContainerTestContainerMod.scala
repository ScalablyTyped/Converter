package typingsSlinky.semanticUiReact

import org.scalablytyped.runtime.Shortcut
import org.scalablytyped.runtime.StringDictionary
import slinky.core.ReactComponentClass
import slinky.core.facade.ReactElement
import typingsSlinky.semanticUiReact.genericMod.SemanticShorthandContent
import typingsSlinky.semanticUiReact.genericMod.SemanticTEXTALIGNMENTS
import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

object testContainerTestContainerMod extends Shortcut {
  
  @JSImport("semantic-ui-react/dist/commonjs/elements/TestContainer/TestContainer", JSImport.Default)
  @js.native
  val default: ReactComponentClass[TestContainerProps] = js.native
  
  @js.native
  trait StrictTestContainerProps extends StObject {
    
    /** An element type to render as (string or function). */
    var as: js.UndefOr[js.Any] = js.native
    
    /** Primary content. */
    var children: js.UndefOr[ReactElement] = js.native
    
    /** Additional classes. */
    var className: js.UndefOr[String] = js.native
    
    /** Shorthand for primary content. */
    var content: js.UndefOr[SemanticShorthandContent] = js.native
    
    /** TestContainer has no maximum width. */
    var fluid: js.UndefOr[Boolean] = js.native
    
    /**Should be CallbackTo[Number]*/
    var optFn0Number: js.UndefOr[js.Function0[Double]] = js.native
    
    /**Should be Callback*/
    var optFn0Void: js.UndefOr[js.Function0[Unit]] = js.native
    
    /**Should be (x:Number) => CallbackTo[Number]*/
    var optFn1Number: js.UndefOr[js.Function1[/* x */ Double, Double]] = js.native
    
    /**Should be (x:Number) => Callback*/
    var optFn1Void: js.UndefOr[js.Function1[/* x */ Double, Unit]] = js.native
    
    /**Should be CallbackTo[Number]*/
    def requiredFn0Number(): Double = js.native
    
    /**Should be Callback*/
    def requiredFn0Void(): Unit = js.native
    
    /**Should be (x:Number) => CallbackTo[Number]*/
    def requiredFn1Number(x: Double): Double = js.native
    
    /**Should be (x:Number) => Callback*/
    def requiredFn1Void(x: Double): Unit = js.native
    
    /** Reduce maximum width to more naturally accommodate text. */
    var text: js.UndefOr[Boolean] = js.native
    
    /** Describes how the text inside this component should be aligned. */
    var textAlign: js.UndefOr[SemanticTEXTALIGNMENTS] = js.native
  }
  object StrictTestContainerProps {
    
    @scala.inline
    def apply(
      requiredFn0Number: () => Double,
      requiredFn0Void: () => Unit,
      requiredFn1Number: Double => Double,
      requiredFn1Void: Double => Unit
    ): StrictTestContainerProps = {
      val __obj = js.Dynamic.literal(requiredFn0Number = js.Any.fromFunction0(requiredFn0Number), requiredFn0Void = js.Any.fromFunction0(requiredFn0Void), requiredFn1Number = js.Any.fromFunction1(requiredFn1Number), requiredFn1Void = js.Any.fromFunction1(requiredFn1Void))
      __obj.asInstanceOf[StrictTestContainerProps]
    }
    
    @scala.inline
    implicit class StrictTestContainerPropsMutableBuilder[Self <: StrictTestContainerProps] (val x: Self) extends AnyVal {
      
      @scala.inline
      def setAs(value: js.Any): Self = StObject.set(x, "as", value.asInstanceOf[js.Any])
      
      @scala.inline
      def setAsUndefined: Self = StObject.set(x, "as", js.undefined)
      
      @scala.inline
      def setChildren(value: ReactElement): Self = StObject.set(x, "children", value.asInstanceOf[js.Any])
      
      @scala.inline
      def setChildrenUndefined: Self = StObject.set(x, "children", js.undefined)
      
      @scala.inline
      def setClassName(value: String): Self = StObject.set(x, "className", value.asInstanceOf[js.Any])
      
      @scala.inline
      def setClassNameUndefined: Self = StObject.set(x, "className", js.undefined)
      
      @scala.inline
      def setContent(value: SemanticShorthandContent): Self = StObject.set(x, "content", value.asInstanceOf[js.Any])
      
      @scala.inline
      def setContentUndefined: Self = StObject.set(x, "content", js.undefined)
      
      @scala.inline
      def setFluid(value: Boolean): Self = StObject.set(x, "fluid", value.asInstanceOf[js.Any])
      
      @scala.inline
      def setFluidUndefined: Self = StObject.set(x, "fluid", js.undefined)
      
      @scala.inline
      def setOptFn0Number(value: () => Double): Self = StObject.set(x, "optFn0Number", js.Any.fromFunction0(value))
      
      @scala.inline
      def setOptFn0NumberUndefined: Self = StObject.set(x, "optFn0Number", js.undefined)
      
      @scala.inline
      def setOptFn0Void(value: () => Unit): Self = StObject.set(x, "optFn0Void", js.Any.fromFunction0(value))
      
      @scala.inline
      def setOptFn0VoidUndefined: Self = StObject.set(x, "optFn0Void", js.undefined)
      
      @scala.inline
      def setOptFn1Number(value: /* x */ Double => Double): Self = StObject.set(x, "optFn1Number", js.Any.fromFunction1(value))
      
      @scala.inline
      def setOptFn1NumberUndefined: Self = StObject.set(x, "optFn1Number", js.undefined)
      
      @scala.inline
      def setOptFn1Void(value: /* x */ Double => Unit): Self = StObject.set(x, "optFn1Void", js.Any.fromFunction1(value))
      
      @scala.inline
      def setOptFn1VoidUndefined: Self = StObject.set(x, "optFn1Void", js.undefined)
      
      @scala.inline
      def setRequiredFn0Number(value: () => Double): Self = StObject.set(x, "requiredFn0Number", js.Any.fromFunction0(value))
      
      @scala.inline
      def setRequiredFn0Void(value: () => Unit): Self = StObject.set(x, "requiredFn0Void", js.Any.fromFunction0(value))
      
      @scala.inline
      def setRequiredFn1Number(value: Double => Double): Self = StObject.set(x, "requiredFn1Number", js.Any.fromFunction1(value))
      
      @scala.inline
      def setRequiredFn1Void(value: Double => Unit): Self = StObject.set(x, "requiredFn1Void", js.Any.fromFunction1(value))
      
      @scala.inline
      def setText(value: Boolean): Self = StObject.set(x, "text", value.asInstanceOf[js.Any])
      
      @scala.inline
      def setTextAlign(value: SemanticTEXTALIGNMENTS): Self = StObject.set(x, "textAlign", value.asInstanceOf[js.Any])
      
      @scala.inline
      def setTextAlignUndefined: Self = StObject.set(x, "textAlign", js.undefined)
      
      @scala.inline
      def setTextUndefined: Self = StObject.set(x, "text", js.undefined)
    }
  }
  
  @js.native
  trait TestContainerProps
    extends StObject
       with StrictTestContainerProps
       with /* key */ StringDictionary[js.Any]
  object TestContainerProps {
    
    @scala.inline
    def apply(
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
  
  /* This means you don't have to write `default`, but can instead just say `testContainerTestContainerMod.foo` */
  override def _to: ReactComponentClass[TestContainerProps] = default
}
