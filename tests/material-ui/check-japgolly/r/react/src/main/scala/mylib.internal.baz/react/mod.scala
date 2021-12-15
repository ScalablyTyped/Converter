package mylib.internal.baz.react

import mylib.internal.baz.react.anon.Children
import mylib.internal.baz.react.anon.Html
import mylib.internal.baz.react.reactStrings.foo
import mylib.internal.baz.std.Partial
import japgolly.scalajs.react.Callback
import japgolly.scalajs.react.facade.Empty
import japgolly.scalajs.react.facade.JsNumber
import japgolly.scalajs.react.facade.React.ComponentClassP
import japgolly.scalajs.react.facade.React.Element
import japgolly.scalajs.react.facade.React.Node
import japgolly.scalajs.react.vdom.VdomElement
import japgolly.scalajs.react.vdom.VdomNode
import org.scalablytyped.runtime.Instantiable1
import org.scalablytyped.runtime.Instantiable2
import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

private[internal] object mod {
  
  trait AllHTMLAttributes[T]
    extends StObject
       with HTMLAttributes[T] {
    
    var accept: js.UndefOr[String] = js.undefined
    
    var acceptCharset: js.UndefOr[String] = js.undefined
  }
  object AllHTMLAttributes {
    
    inline def apply[T](): AllHTMLAttributes[T] = {
      val __obj = js.Dynamic.literal()
      __obj.asInstanceOf[AllHTMLAttributes[T]]
    }
    
    extension [Self <: AllHTMLAttributes[?], T](x: Self & AllHTMLAttributes[T]) {
      
      inline def setAccept(value: String): Self = StObject.set(x, "accept", value.asInstanceOf[js.Any])
      
      inline def setAcceptCharset(value: String): Self = StObject.set(x, "acceptCharset", value.asInstanceOf[js.Any])
      
      inline def setAcceptCharsetUndefined: Self = StObject.set(x, "acceptCharset", js.undefined)
      
      inline def setAcceptUndefined: Self = StObject.set(x, "accept", js.undefined)
    }
  }
  
  trait Component[P, S] extends StObject
  
  @js.native
  trait ComponentClass[P]
    extends StObject
       with Instantiable1[
          /* props */ P, 
          japgolly.scalajs.react.facade.React.Component[P & js.Object, js.Object]
        ]
       with Instantiable2[
          /* props */ P, 
          /* context */ js.Any, 
          japgolly.scalajs.react.facade.React.Component[P & js.Object, js.Object]
        ] {
    
    var defaultProps: js.UndefOr[Partial[P]] = js.native
    
    var displayName: js.UndefOr[String] = js.native
  }
  
  type ComponentState = js.Object
  
  type ComponentType[P] = (ComponentClassP[P & js.Object]) | StatelessComponent[P]
  
  trait DOMAttributes[T] extends StObject {
    
    var children: js.UndefOr[Node] = js.undefined
    
    var dangerouslySetInnerHTML: js.UndefOr[Html] = js.undefined
    
    var onClick: js.UndefOr[Double | (js.Function1[/* x */ String, Unit])] = js.undefined
  }
  object DOMAttributes {
    
    inline def apply[T](): DOMAttributes[T] = {
      val __obj = js.Dynamic.literal()
      __obj.asInstanceOf[DOMAttributes[T]]
    }
    
    extension [Self <: DOMAttributes[?], T](x: Self & DOMAttributes[T]) {
      
      inline def setChildren(value: VdomNode): Self = StObject.set(x, "children", value.rawNode.asInstanceOf[js.Any])
      
      inline def setChildrenNull: Self = StObject.set(x, "children", null)
      
      inline def setChildrenUndefined: Self = StObject.set(x, "children", js.undefined)
      
      inline def setChildrenVarargs(value: (Empty | String | JsNumber | Element)*): Self = StObject.set(x, "children", js.Array(value :_*))
      
      inline def setChildrenVdomElement(value: VdomElement): Self = StObject.set(x, "children", value.rawElement.asInstanceOf[js.Any])
      
      inline def setDangerouslySetInnerHTML(value: Html): Self = StObject.set(x, "dangerouslySetInnerHTML", value.asInstanceOf[js.Any])
      
      inline def setDangerouslySetInnerHTMLUndefined: Self = StObject.set(x, "dangerouslySetInnerHTML", js.undefined)
      
      inline def setOnClick(value: Double | (js.Function1[/* x */ String, Unit])): Self = StObject.set(x, "onClick", value.asInstanceOf[js.Any])
      
      inline def setOnClickFunction1(value: /* x */ String => Callback): Self = StObject.set(x, "onClick", js.Any.fromFunction1((t0: /* x */ String) => value(t0).runNow()))
      
      inline def setOnClickUndefined: Self = StObject.set(x, "onClick", js.undefined)
    }
  }
  
  trait HTMLAttributes[T]
    extends StObject
       with DOMAttributes[T] {
    
    var defaultChecked: js.UndefOr[Boolean] = js.undefined
  }
  object HTMLAttributes {
    
    inline def apply[T](): HTMLAttributes[T] = {
      val __obj = js.Dynamic.literal()
      __obj.asInstanceOf[HTMLAttributes[T]]
    }
    
    extension [Self <: HTMLAttributes[?], T](x: Self & HTMLAttributes[T]) {
      
      inline def setDefaultChecked(value: Boolean): Self = StObject.set(x, "defaultChecked", value.asInstanceOf[js.Any])
      
      inline def setDefaultCheckedUndefined: Self = StObject.set(x, "defaultChecked", js.undefined)
    }
  }
  
  trait HTMLProps[T]
    extends StObject
       with AllHTMLAttributes[T] {
    
    var defaultValue: foo
    
    var onChange: foo
    
    var `type`: foo
    
    var value: foo
  }
  object HTMLProps {
    
    inline def apply[T](): HTMLProps[T] = {
      val __obj = js.Dynamic.literal(defaultValue = "foo", onChange = "foo", value = "foo")
      __obj.updateDynamic("type")("foo")
      __obj.asInstanceOf[HTMLProps[T]]
    }
    
    extension [Self <: HTMLProps[?], T](x: Self & HTMLProps[T]) {
      
      inline def setDefaultValue(value: foo): Self = StObject.set(x, "defaultValue", value.asInstanceOf[js.Any])
      
      inline def setOnChange(value: foo): Self = StObject.set(x, "onChange", value.asInstanceOf[js.Any])
      
      inline def setType(value: foo): Self = StObject.set(x, "type", value.asInstanceOf[js.Any])
      
      inline def setValue(value: foo): Self = StObject.set(x, "value", value.asInstanceOf[js.Any])
    }
  }
  
  type Key = String | Double
  
  trait ReactElement extends StObject {
    
    var key: Key | Null
    
    var props: js.Any
    
    var `type`: String | (ComponentClassP[js.Any & js.Object]) | SFC[js.Any]
  }
  object ReactElement {
    
    inline def apply(props: js.Any, `type`: String | (ComponentClassP[js.Any & js.Object]) | SFC[js.Any]): ReactElement = {
      val __obj = js.Dynamic.literal(props = props.asInstanceOf[js.Any], key = null)
      __obj.updateDynamic("type")(`type`.asInstanceOf[js.Any])
      __obj.asInstanceOf[ReactElement]
    }
    
    extension [Self <: ReactElement](x: Self) {
      
      inline def setKey(value: Key): Self = StObject.set(x, "key", value.asInstanceOf[js.Any])
      
      inline def setKeyNull: Self = StObject.set(x, "key", null)
      
      inline def setProps(value: js.Any): Self = StObject.set(x, "props", value.asInstanceOf[js.Any])
      
      inline def setType(value: String | (ComponentClassP[js.Any & js.Object]) | SFC[js.Any]): Self = StObject.set(x, "type", value.asInstanceOf[js.Any])
    }
  }
  
  type ReactNode = js.UndefOr[String | Double | Boolean]
  
  type SFC[P] = StatelessComponent[P]
  
  type SVGAttributes[T] = DOMAttributes[T]
  
  @js.native
  trait StatelessComponent[P] extends StObject {
    
    def apply(props: P & Children): Element | Null = js.native
    def apply(props: P & Children, context: js.Any): Element | Null = js.native
    
    var defaultProps: js.UndefOr[Partial[P]] = js.native
    
    var displayName: js.UndefOr[String] = js.native
  }
}
