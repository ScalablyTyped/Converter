package typingsJapgolly.componentstest

import japgolly.scalajs.react.Callback
import japgolly.scalajs.react.CallbackTo
import japgolly.scalajs.react.ReactEventFrom
import japgolly.scalajs.react.ReactMouseEventFrom
import japgolly.scalajs.react.facade.React.ElementType
import org.scalajs.dom.HTMLDivElement
import typingsJapgolly.componentstest.anon.Equals
import typingsJapgolly.componentstest.anon.Href
import typingsJapgolly.componentstest.anon.hrefstringFooProps
import typingsJapgolly.componentstest.componentstestStrings.button
import typingsJapgolly.react.mod.CSSProperties
import typingsJapgolly.react.mod.ComponentType
import typingsJapgolly.react.mod.FC
import typingsJapgolly.react.mod.ForwardRefExoticComponent
import typingsJapgolly.react.mod.FunctionComponent
import typingsJapgolly.react.mod.JSXElementConstructor
import typingsJapgolly.react.mod.MemoExoticComponent
import typingsJapgolly.react.mod.MouseEventHandler
import typingsJapgolly.react.mod.RefAttributes
import typingsJapgolly.react.mod.global.JSX.Element
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
  
  @JSImport("componentstest", "Inline")
  @js.native
  val Inline: (js.Function1[/* props */ hrefstringFooProps, Element]) & OverridableComponent[FooTypeMap] = js.native
  
  @JSImport("componentstest", "ObjectNames")
  @js.native
  val ObjectNames: FC[Equals] = js.native
  
  @JSImport("componentstest", "Plain")
  @js.native
  val Plain: OverridableComponent[FooTypeMap] = js.native
  
  @JSImport("componentstest", "VeryExotic")
  @js.native
  val VeryExotic: MemoExoticComponent[ForwardRefExoticComponent[RefAttributes[HTMLDivElement]]] = js.native
  
  @JSImport("componentstest", "ViaAlias")
  @js.native
  val ViaAlias: ExtendButtonBase[FooTypeMap] = js.native
  
  @JSImport("componentstest", "ViaConstructor")
  @js.native
  val ViaConstructor: JSXElementConstructor[FooProps] = js.native
  
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
  
  /* Inlined parent std.Omit<std.Pick<react.react.HTMLAttributes<std.HTMLDivElement>, 'title' | 'onClick'>, 'title'> */
  trait CardProps extends StObject {
    
    var onClick: js.UndefOr[MouseEventHandler[HTMLDivElement]] = js.undefined
    
    var prefixCls: js.UndefOr[String] = js.undefined
  }
  object CardProps {
    
    inline def apply(): CardProps = {
      val __obj = js.Dynamic.literal()
      __obj.asInstanceOf[CardProps]
    }
    
    @scala.inline
    implicit open class MutableBuilder[Self <: CardProps] (val x: Self) extends AnyVal {
      
      inline def setOnClick(value: ReactMouseEventFrom[HTMLDivElement & org.scalajs.dom.Element] => Callback): Self = StObject.set(x, "onClick", js.Any.fromFunction1((t0: ReactMouseEventFrom[HTMLDivElement & org.scalajs.dom.Element]) => value(t0).runNow()))
      
      inline def setOnClickUndefined: Self = StObject.set(x, "onClick", js.undefined)
      
      inline def setPrefixCls(value: String): Self = StObject.set(x, "prefixCls", value.asInstanceOf[js.Any])
      
      inline def setPrefixClsUndefined: Self = StObject.set(x, "prefixCls", js.undefined)
    }
  }
  
  trait Events extends StObject {
    
    def onClick(event: ReactEventFrom[Any & org.scalajs.dom.Element]): Unit
  }
  object Events {
    
    inline def apply(onClick: ReactEventFrom[Any & org.scalajs.dom.Element] => Callback): Events = {
      val __obj = js.Dynamic.literal(onClick = js.Any.fromFunction1((t0: ReactEventFrom[Any & org.scalajs.dom.Element]) => onClick(t0).runNow()))
      __obj.asInstanceOf[Events]
    }
    
    @scala.inline
    implicit open class MutableBuilder[Self <: Events] (val x: Self) extends AnyVal {
      
      inline def setOnClick(value: ReactEventFrom[Any & org.scalajs.dom.Element] => Callback): Self = StObject.set(x, "onClick", js.Any.fromFunction1((t0: ReactEventFrom[Any & org.scalajs.dom.Element]) => value(t0).runNow()))
    }
  }
  
  type ExtendButtonBase[M /* <: OverridableTypeMap */] = (js.Function1[
    /* props */ Href & (/* import warning: importer.ImportType#apply Failed type conversion: M['props'] */ js.Any), 
    Element
  ]) & OverridableComponent[M]
  
  trait FooProps extends StObject {
    
    var disabled: js.UndefOr[Boolean] = js.undefined
    
    var label: js.UndefOr[String] = js.undefined
  }
  object FooProps {
    
    inline def apply(): FooProps = {
      val __obj = js.Dynamic.literal()
      __obj.asInstanceOf[FooProps]
    }
    
    @scala.inline
    implicit open class MutableBuilder[Self <: FooProps] (val x: Self) extends AnyVal {
      
      inline def setDisabled(value: Boolean): Self = StObject.set(x, "disabled", value.asInstanceOf[js.Any])
      
      inline def setDisabledUndefined: Self = StObject.set(x, "disabled", js.undefined)
      
      inline def setLabel(value: String): Self = StObject.set(x, "label", value.asInstanceOf[js.Any])
      
      inline def setLabelUndefined: Self = StObject.set(x, "label", js.undefined)
    }
  }
  
  trait FooTypeMap extends StObject {
    
    var defaultComponent: button
    
    var props: FooProps
  }
  object FooTypeMap {
    
    inline def apply(props: FooProps): FooTypeMap = {
      val __obj = js.Dynamic.literal(defaultComponent = "button", props = props.asInstanceOf[js.Any])
      __obj.asInstanceOf[FooTypeMap]
    }
    
    @scala.inline
    implicit open class MutableBuilder[Self <: FooTypeMap] (val x: Self) extends AnyVal {
      
      inline def setDefaultComponent(value: button): Self = StObject.set(x, "defaultComponent", value.asInstanceOf[js.Any])
      
      inline def setProps(value: FooProps): Self = StObject.set(x, "props", value.asInstanceOf[js.Any])
    }
  }
  
  @js.native
  trait OverridableComponent[M /* <: OverridableTypeMap */] extends StObject {
    
    def apply(props: /* import warning: importer.ImportType#apply Failed type conversion: M['props'] */ js.Any): Element | Null = js.native
  }
  
  trait OverridableTypeMap extends StObject {
    
    var defaultComponent: ElementType
  }
  object OverridableTypeMap {
    
    inline def apply(defaultComponent: ElementType): OverridableTypeMap = {
      val __obj = js.Dynamic.literal(defaultComponent = defaultComponent.asInstanceOf[js.Any])
      __obj.asInstanceOf[OverridableTypeMap]
    }
    
    @scala.inline
    implicit open class MutableBuilder[Self <: OverridableTypeMap] (val x: Self) extends AnyVal {
      
      inline def setDefaultComponent(value: ElementType): Self = StObject.set(x, "defaultComponent", value.asInstanceOf[js.Any])
    }
  }
  
  /* Rewritten from type alias, can be one of: 
    - typingsJapgolly.componentstest.mod.A
    - typingsJapgolly.componentstest.mod.B
  */
  trait Props extends StObject
  object Props {
    
    inline def A(aCallback: CallbackTo[Double], aMember: Double): typingsJapgolly.componentstest.mod.A = {
      val __obj = js.Dynamic.literal(aCallback = aCallback.toJsFn, aMember = aMember.asInstanceOf[js.Any])
      __obj.asInstanceOf[typingsJapgolly.componentstest.mod.A]
    }
    
    inline def B(bMember: String): typingsJapgolly.componentstest.mod.B = {
      val __obj = js.Dynamic.literal(bMember = bMember.asInstanceOf[js.Any])
      __obj.asInstanceOf[typingsJapgolly.componentstest.mod.B]
    }
  }
}
