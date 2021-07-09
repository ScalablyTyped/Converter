package typingsJapgolly.componentstest

import japgolly.scalajs.react.Callback
import japgolly.scalajs.react.CallbackTo
import japgolly.scalajs.react.ReactMouseEventFrom
import org.scalajs.dom.raw.Element
import org.scalajs.dom.raw.HTMLDivElement
import typingsJapgolly.componentstest.anon.Equals
import typingsJapgolly.react.mod.CSSProperties
import typingsJapgolly.react.mod.ComponentType
import typingsJapgolly.react.mod.FC
import typingsJapgolly.react.mod.FunctionComponent
import typingsJapgolly.react.mod.MouseEventHandler
import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

object mod {
  
  @JSImport("componentstest", "Card")
  @js.native
  val Card: CardInterface = js.native
  
  @JSImport("componentstest", "Component")
  @js.native
  val Component: ComponentType[Props] = js.native
  
  @JSImport("componentstest", "Grid")
  @js.native
  val Grid: FC[CardGridProps] = js.native
  
  @JSImport("componentstest", "ObjectNames")
  @js.native
  val ObjectNames: FC[Equals] = js.native
  
  @js.native
  trait A
    extends StObject
       with Props {
    
    def aCallback(): Double = js.native
    
    var aMember: Double = js.native
  }
  object A {
    
    @scala.inline
    def apply(aCallback: CallbackTo[Double], aMember: Double): A = {
      val __obj = js.Dynamic.literal(aCallback = aCallback.toJsFn, aMember = aMember.asInstanceOf[js.Any])
      __obj.asInstanceOf[A]
    }
    
    @scala.inline
    implicit class AMutableBuilder[Self <: A] (val x: Self) extends AnyVal {
      
      @scala.inline
      def setACallback(value: CallbackTo[Double]): Self = StObject.set(x, "aCallback", value.toJsFn)
      
      @scala.inline
      def setAMember(value: Double): Self = StObject.set(x, "aMember", value.asInstanceOf[js.Any])
    }
  }
  
  @js.native
  trait B
    extends StObject
       with Props {
    
    var bCallback: js.UndefOr[js.Function0[String]] = js.native
    
    var bMember: String = js.native
  }
  object B {
    
    @scala.inline
    def apply(bMember: String): B = {
      val __obj = js.Dynamic.literal(bMember = bMember.asInstanceOf[js.Any])
      __obj.asInstanceOf[B]
    }
    
    @scala.inline
    implicit class BMutableBuilder[Self <: B] (val x: Self) extends AnyVal {
      
      @scala.inline
      def setBCallback(value: CallbackTo[String]): Self = StObject.set(x, "bCallback", value.toJsFn)
      
      @scala.inline
      def setBCallbackUndefined: Self = StObject.set(x, "bCallback", js.undefined)
      
      @scala.inline
      def setBMember(value: String): Self = StObject.set(x, "bMember", value.asInstanceOf[js.Any])
    }
  }
  
  @js.native
  trait CardGridProps extends StObject {
    
    var className: js.UndefOr[String] = js.native
    
    var hoverable: js.UndefOr[Boolean] = js.native
    
    var prefixCls: js.UndefOr[String] = js.native
    
    var style: js.UndefOr[CSSProperties] = js.native
  }
  object CardGridProps {
    
    @scala.inline
    def apply(): CardGridProps = {
      val __obj = js.Dynamic.literal()
      __obj.asInstanceOf[CardGridProps]
    }
    
    @scala.inline
    implicit class CardGridPropsMutableBuilder[Self <: CardGridProps] (val x: Self) extends AnyVal {
      
      @scala.inline
      def setClassName(value: String): Self = StObject.set(x, "className", value.asInstanceOf[js.Any])
      
      @scala.inline
      def setClassNameUndefined: Self = StObject.set(x, "className", js.undefined)
      
      @scala.inline
      def setHoverable(value: Boolean): Self = StObject.set(x, "hoverable", value.asInstanceOf[js.Any])
      
      @scala.inline
      def setHoverableUndefined: Self = StObject.set(x, "hoverable", js.undefined)
      
      @scala.inline
      def setPrefixCls(value: String): Self = StObject.set(x, "prefixCls", value.asInstanceOf[js.Any])
      
      @scala.inline
      def setPrefixClsUndefined: Self = StObject.set(x, "prefixCls", js.undefined)
      
      @scala.inline
      def setStyle(value: CSSProperties): Self = StObject.set(x, "style", value.asInstanceOf[js.Any])
      
      @scala.inline
      def setStyleUndefined: Self = StObject.set(x, "style", js.undefined)
    }
  }
  
  @js.native
  trait CardInterface
    extends StObject
       with FunctionComponent[CardProps] {
    
    var Grid2: FC[CardGridProps] = js.native
  }
  
  /* Inlined parent std.Omit<std.Pick<react.react.HTMLAttributes<std.HTMLDivElement>, 'title' | 'onClick'>, 'title'> */
  @js.native
  trait CardProps extends StObject {
    
    var onClick: js.UndefOr[MouseEventHandler[HTMLDivElement]] = js.native
    
    var prefixCls: js.UndefOr[String] = js.native
  }
  object CardProps {
    
    @scala.inline
    def apply(): CardProps = {
      val __obj = js.Dynamic.literal()
      __obj.asInstanceOf[CardProps]
    }
    
    @scala.inline
    implicit class CardPropsMutableBuilder[Self <: CardProps] (val x: Self) extends AnyVal {
      
      @scala.inline
      def setOnClick(value: ReactMouseEventFrom[HTMLDivElement & Element] => Callback): Self = StObject.set(x, "onClick", js.Any.fromFunction1((t0: ReactMouseEventFrom[HTMLDivElement & Element]) => value(t0).runNow()))
      
      @scala.inline
      def setOnClickUndefined: Self = StObject.set(x, "onClick", js.undefined)
      
      @scala.inline
      def setPrefixCls(value: String): Self = StObject.set(x, "prefixCls", value.asInstanceOf[js.Any])
      
      @scala.inline
      def setPrefixClsUndefined: Self = StObject.set(x, "prefixCls", js.undefined)
    }
  }
  
  /* Rewritten from type alias, can be one of: 
    - typingsJapgolly.componentstest.mod.A
    - typingsJapgolly.componentstest.mod.B
  */
  trait Props extends StObject
  object Props {
    
    @scala.inline
    def A(aCallback: CallbackTo[Double], aMember: Double): typingsJapgolly.componentstest.mod.A = {
      val __obj = js.Dynamic.literal(aCallback = aCallback.toJsFn, aMember = aMember.asInstanceOf[js.Any])
      __obj.asInstanceOf[typingsJapgolly.componentstest.mod.A]
    }
    
    @scala.inline
    def B(bMember: String): typingsJapgolly.componentstest.mod.B = {
      val __obj = js.Dynamic.literal(bMember = bMember.asInstanceOf[js.Any])
      __obj.asInstanceOf[typingsJapgolly.componentstest.mod.B]
    }
  }
}
