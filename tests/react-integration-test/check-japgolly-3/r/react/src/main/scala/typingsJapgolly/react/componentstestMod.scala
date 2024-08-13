package typingsJapgolly.react

import japgolly.scalajs.react.Callback
import japgolly.scalajs.react.CallbackTo
import japgolly.scalajs.react.ReactEventFrom
import org.scalajs.dom.Element
import org.scalajs.dom.HTMLDivElement
import typingsJapgolly.react.anon.Equals
import typingsJapgolly.react.mod.CSSProperties
import typingsJapgolly.react.mod.ComponentType
import typingsJapgolly.react.mod.FC
import typingsJapgolly.react.mod.ForwardRefExoticComponent
import typingsJapgolly.react.mod.FunctionComponent
import typingsJapgolly.react.mod.MemoExoticComponent
import typingsJapgolly.react.mod.RefAttributes
import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

object componentstestMod {
  
  @JSImport("react/componentstest", "Card")
  @js.native
  val Card: CardInterface = js.native
  
  @JSImport("react/componentstest", "Component")
  @js.native
  val Component: ComponentType[Props] = js.native
  
  @JSImport("react/componentstest", "Grid")
  @js.native
  val Grid: FC[CardGridProps] = js.native
  
  @JSImport("react/componentstest", "ObjectNames")
  @js.native
  val ObjectNames: FC[Equals] = js.native
  
  @JSImport("react/componentstest", "VeryExotic")
  @js.native
  val VeryExotic: MemoExoticComponent[ForwardRefExoticComponent[RefAttributes[HTMLDivElement]]] = js.native
  
  trait A
    extends StObject
       with Props {
    
    def aCallback(): Double
    
    var aMember: Double
  }
  object A {
    
    inline def apply(aCallback: CallbackTo[Double], aMember: Double): A = {
      val __obj = js.Dynamic.literal(aCallback = aCallback.toJsFn, aMember = aMember.asInstanceOf[js.Any])
      __obj.asInstanceOf[A]
    }
    
    @scala.inline
    implicit open class MutableBuilder[Self <: A] (val x: Self) extends AnyVal {
      
      inline def setACallback(value: CallbackTo[Double]): Self = StObject.set(x, "aCallback", value.toJsFn)
      
      inline def setAMember(value: Double): Self = StObject.set(x, "aMember", value.asInstanceOf[js.Any])
    }
  }
  
  trait B
    extends StObject
       with Props {
    
    var bCallback: js.UndefOr[js.Function0[String]] = js.undefined
    
    var bMember: String
  }
  object B {
    
    inline def apply(bMember: String): B = {
      val __obj = js.Dynamic.literal(bMember = bMember.asInstanceOf[js.Any])
      __obj.asInstanceOf[B]
    }
    
    @scala.inline
    implicit open class MutableBuilder[Self <: B] (val x: Self) extends AnyVal {
      
      inline def setBCallback(value: CallbackTo[String]): Self = StObject.set(x, "bCallback", value.toJsFn)
      
      inline def setBCallbackUndefined: Self = StObject.set(x, "bCallback", js.undefined)
      
      inline def setBMember(value: String): Self = StObject.set(x, "bMember", value.asInstanceOf[js.Any])
    }
  }
  
  trait CardGridProps extends StObject {
    
    var className: js.UndefOr[String] = js.undefined
    
    var hoverable: js.UndefOr[Boolean] = js.undefined
    
    var prefixCls: js.UndefOr[String] = js.undefined
    
    var style: js.UndefOr[CSSProperties] = js.undefined
  }
  object CardGridProps {
    
    inline def apply(): CardGridProps = {
      val __obj = js.Dynamic.literal()
      __obj.asInstanceOf[CardGridProps]
    }
    
    @scala.inline
    implicit open class MutableBuilder[Self <: CardGridProps] (val x: Self) extends AnyVal {
      
      inline def setClassName(value: String): Self = StObject.set(x, "className", value.asInstanceOf[js.Any])
      
      inline def setClassNameUndefined: Self = StObject.set(x, "className", js.undefined)
      
      inline def setHoverable(value: Boolean): Self = StObject.set(x, "hoverable", value.asInstanceOf[js.Any])
      
      inline def setHoverableUndefined: Self = StObject.set(x, "hoverable", js.undefined)
      
      inline def setPrefixCls(value: String): Self = StObject.set(x, "prefixCls", value.asInstanceOf[js.Any])
      
      inline def setPrefixClsUndefined: Self = StObject.set(x, "prefixCls", js.undefined)
      
      inline def setStyle(value: CSSProperties): Self = StObject.set(x, "style", value.asInstanceOf[js.Any])
      
      inline def setStyleUndefined: Self = StObject.set(x, "style", js.undefined)
    }
  }
  
  @js.native
  trait CardInterface
    extends StObject
       with FunctionComponent[CardProps] {
    
    var Grid2: FC[CardGridProps] = js.native
  }
  
  /* import warning: RemoveDifficultInheritance.summarizeChanges 
  - Dropped {[ P in react.Exclude<keyof react.Pick<react.react.HTMLAttributes<std.HTMLDivElement>, 'title' | 'onClick'>, 'title'> ]: react.Pick<react.react.HTMLAttributes<std.HTMLDivElement>, 'title' | 'onClick'>[P]} */ trait CardProps extends StObject {
    
    var prefixCls: js.UndefOr[String] = js.undefined
  }
  object CardProps {
    
    inline def apply(): CardProps = {
      val __obj = js.Dynamic.literal()
      __obj.asInstanceOf[CardProps]
    }
    
    @scala.inline
    implicit open class MutableBuilder[Self <: CardProps] (val x: Self) extends AnyVal {
      
      inline def setPrefixCls(value: String): Self = StObject.set(x, "prefixCls", value.asInstanceOf[js.Any])
      
      inline def setPrefixClsUndefined: Self = StObject.set(x, "prefixCls", js.undefined)
    }
  }
  
  trait Events extends StObject {
    
    def onClick(event: ReactEventFrom[Any & Element]): Unit
  }
  object Events {
    
    inline def apply(onClick: ReactEventFrom[Any & Element] => Callback): Events = {
      val __obj = js.Dynamic.literal(onClick = js.Any.fromFunction1((t0: ReactEventFrom[Any & Element]) => onClick(t0).runNow()))
      __obj.asInstanceOf[Events]
    }
    
    @scala.inline
    implicit open class MutableBuilder[Self <: Events] (val x: Self) extends AnyVal {
      
      inline def setOnClick(value: ReactEventFrom[Any & Element] => Callback): Self = StObject.set(x, "onClick", js.Any.fromFunction1((t0: ReactEventFrom[Any & Element]) => value(t0).runNow()))
    }
  }
  
  /* Rewritten from type alias, can be one of: 
    - typingsJapgolly.react.componentstestMod.A
    - typingsJapgolly.react.componentstestMod.B
  */
  trait Props extends StObject
  object Props {
    
    inline def A(aCallback: CallbackTo[Double], aMember: Double): typingsJapgolly.react.componentstestMod.A = {
      val __obj = js.Dynamic.literal(aCallback = aCallback.toJsFn, aMember = aMember.asInstanceOf[js.Any])
      __obj.asInstanceOf[typingsJapgolly.react.componentstestMod.A]
    }
    
    inline def B(bMember: String): typingsJapgolly.react.componentstestMod.B = {
      val __obj = js.Dynamic.literal(bMember = bMember.asInstanceOf[js.Any])
      __obj.asInstanceOf[typingsJapgolly.react.componentstestMod.B]
    }
  }
}
