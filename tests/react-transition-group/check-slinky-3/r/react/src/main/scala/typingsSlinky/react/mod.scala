package typingsSlinky.react

import org.scalablytyped.runtime.Instantiable1
import org.scalablytyped.runtime.Instantiable2
import org.scalajs.dom.AnimationEvent
import org.scalajs.dom.HTMLElement
import org.scalajs.dom.SVGElement
import slinky.core.ReactComponentClass
import typingsSlinky.react.anon.Children
import typingsSlinky.react.anon.Html
import typingsSlinky.std.Partial
import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

object mod {
  
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
    
    @scala.inline
    implicit open class MutableBuilder[Self <: AllHTMLAttributes[?], T] (val x: Self & AllHTMLAttributes[T]) extends AnyVal {
      
      inline def setAccept(value: String): Self = StObject.set(x, "accept", value.asInstanceOf[js.Any])
      
      inline def setAcceptCharset(value: String): Self = StObject.set(x, "acceptCharset", value.asInstanceOf[js.Any])
      
      inline def setAcceptCharsetUndefined: Self = StObject.set(x, "acceptCharset", js.undefined)
      
      inline def setAcceptUndefined: Self = StObject.set(x, "accept", js.undefined)
    }
  }
  
  // interface SyntheticEvent<T> {
  //     currentTarget: EventTarget & T;
  // }
  // interface AnimationEvent<T> extends SyntheticEvent<T> {
  //     nativeEvent: NativeAnimationEvent;
  // }
  trait Attributes extends StObject {
    
    var key: js.UndefOr[Key] = js.undefined
  }
  object Attributes {
    
    inline def apply(): Attributes = {
      val __obj = js.Dynamic.literal()
      __obj.asInstanceOf[Attributes]
    }
    
    @scala.inline
    implicit open class MutableBuilder[Self <: Attributes] (val x: Self) extends AnyVal {
      
      inline def setKey(value: Key): Self = StObject.set(x, "key", value.asInstanceOf[js.Any])
      
      inline def setKeyUndefined: Self = StObject.set(x, "key", js.undefined)
    }
  }
  
  trait ClassAttributes[T]
    extends StObject
       with Attributes {
    
    var ref: js.UndefOr[Ref[T]] = js.undefined
  }
  object ClassAttributes {
    
    inline def apply[T](): ClassAttributes[T] = {
      val __obj = js.Dynamic.literal()
      __obj.asInstanceOf[ClassAttributes[T]]
    }
    
    @scala.inline
    implicit open class MutableBuilder[Self <: ClassAttributes[?], T] (val x: Self & ClassAttributes[T]) extends AnyVal {
      
      inline def setRef(value: Ref[T]): Self = StObject.set(x, "ref", value.asInstanceOf[js.Any])
      
      inline def setRefFunction1(value: /* instance */ T | Null => Any): Self = StObject.set(x, "ref", js.Any.fromFunction1(value))
      
      inline def setRefUndefined: Self = StObject.set(x, "ref", js.undefined)
    }
  }
  
  trait Component[P, S] extends StObject
  
  @js.native
  trait ComponentClass[P]
    extends StObject
       with Instantiable1[/* props */ P, ReactComponentClass[P]]
       with Instantiable2[/* props */ P, /* context */ Any, ReactComponentClass[P]] {
    
    var defaultProps: js.UndefOr[Partial[P]] = js.native
    
    var displayName: js.UndefOr[String] = js.native
  }
  
  type ComponentState = js.Object
  
  type ComponentType[P] = ReactComponentClass[P]
  
  trait DOMAttributes[T] extends StObject {
    
    var children: js.UndefOr[slinky.core.facade.ReactElement] = js.undefined
    
    var dangerouslySetInnerHTML: js.UndefOr[Html] = js.undefined
  }
  object DOMAttributes {
    
    inline def apply[T](): DOMAttributes[T] = {
      val __obj = js.Dynamic.literal()
      __obj.asInstanceOf[DOMAttributes[T]]
    }
    
    @scala.inline
    implicit open class MutableBuilder[Self <: DOMAttributes[?], T] (val x: Self & DOMAttributes[T]) extends AnyVal {
      
      inline def setChildren(value: slinky.core.facade.ReactElement): Self = StObject.set(x, "children", value.asInstanceOf[js.Any])
      
      inline def setChildrenUndefined: Self = StObject.set(x, "children", js.undefined)
      
      inline def setDangerouslySetInnerHTML(value: Html): Self = StObject.set(x, "dangerouslySetInnerHTML", value.asInstanceOf[js.Any])
      
      inline def setDangerouslySetInnerHTMLUndefined: Self = StObject.set(x, "dangerouslySetInnerHTML", js.undefined)
    }
  }
  
  type DetailedHTMLProps[E /* <: HTMLAttributes[T] */, T] = ClassAttributes[T] & E
  
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
    
    @scala.inline
    implicit open class MutableBuilder[Self <: HTMLAttributes[?], T] (val x: Self & HTMLAttributes[T]) extends AnyVal {
      
      inline def setDefaultChecked(value: Boolean): Self = StObject.set(x, "defaultChecked", value.asInstanceOf[js.Any])
      
      inline def setDefaultCheckedUndefined: Self = StObject.set(x, "defaultChecked", js.undefined)
    }
  }
  
  trait HTMLProps[T]
    extends StObject
       with AllHTMLAttributes[T]
       with ClassAttributes[T]
  object HTMLProps {
    
    inline def apply[T](): HTMLProps[T] = {
      val __obj = js.Dynamic.literal()
      __obj.asInstanceOf[HTMLProps[T]]
    }
  }
  
  type Key = String | Double
  
  type NativeAnimationEvent = AnimationEvent
  
  trait ReactElement extends StObject {
    
    var key: Key | Null
    
    var props: Any
    
    var `type`: String | ReactComponentClass[Any]
  }
  object ReactElement {
    
    inline def apply(props: Any, `type`: String | ReactComponentClass[Any]): ReactElement = {
      val __obj = js.Dynamic.literal(props = props.asInstanceOf[js.Any], key = null)
      __obj.updateDynamic("type")(`type`.asInstanceOf[js.Any])
      __obj.asInstanceOf[ReactElement]
    }
    
    @scala.inline
    implicit open class MutableBuilder[Self <: ReactElement] (val x: Self) extends AnyVal {
      
      inline def setKey(value: Key): Self = StObject.set(x, "key", value.asInstanceOf[js.Any])
      
      inline def setKeyNull: Self = StObject.set(x, "key", null)
      
      inline def setProps(value: Any): Self = StObject.set(x, "props", value.asInstanceOf[js.Any])
      
      inline def setType(value: String | ReactComponentClass[Any]): Self = StObject.set(x, "type", value.asInstanceOf[js.Any])
      
      inline def setTypeReactComponentClass(value: ReactComponentClass[Any]): Self = StObject.set(x, "type", value.asInstanceOf[js.Any])
    }
  }
  
  type ReactNode = js.UndefOr[String | Double | Boolean]
  
  type ReactType[P] = String | ReactComponentClass[P]
  
  type Ref[T] = String | (js.Function1[/* instance */ T | Null, Any])
  
  type SFC[P] = ReactComponentClass[P]
  
  type SVGAttributes[T] = DOMAttributes[T]
  
  type SVGProps[T] = ClassAttributes[T]
  
  @js.native
  trait StatelessComponent[P] extends StObject {
    
    def apply(props: P & Children): slinky.core.facade.ReactElement | Null = js.native
    def apply(props: P & Children, context: Any): slinky.core.facade.ReactElement | Null = js.native
    
    var defaultProps: js.UndefOr[Partial[P]] = js.native
    
    var displayName: js.UndefOr[String] = js.native
  }
  
  object global {
    
    object JSX {
      
      // tslint:disable-next-line:no-empty-interface
      type Element = slinky.core.facade.ReactElement
      
      trait ElementAttributesProperty extends StObject
      
      trait ElementChildrenAttribute extends StObject
      
      trait ElementClass
        extends StObject
           with Component[Any, js.Object] {
        
        def render(): slinky.core.facade.ReactElement
      }
      object ElementClass {
        
        inline def apply(render: () => slinky.core.facade.ReactElement): ElementClass = {
          val __obj = js.Dynamic.literal(render = js.Any.fromFunction0(render))
          __obj.asInstanceOf[ElementClass]
        }
        
        @scala.inline
        implicit open class MutableBuilder[Self <: ElementClass] (val x: Self) extends AnyVal {
          
          inline def setRender(value: () => slinky.core.facade.ReactElement): Self = StObject.set(x, "render", js.Any.fromFunction0(value))
        }
      }
      
      // tslint:disable-next-line:no-empty-interface
      type IntrinsicAttributes = Attributes
      
      // tslint:disable-next-line:no-empty-interface
      type IntrinsicClassAttributes[T] = ClassAttributes[T]
      
      trait IntrinsicElements extends StObject {
        
        // HTML
        var abbr: DetailedHTMLProps[HTMLAttributes[HTMLElement], HTMLElement]
        
        var animate: SVGProps[SVGElement]
      }
      object IntrinsicElements {
        
        inline def apply(abbr: DetailedHTMLProps[HTMLAttributes[HTMLElement], HTMLElement], animate: SVGProps[SVGElement]): IntrinsicElements = {
          val __obj = js.Dynamic.literal(abbr = abbr.asInstanceOf[js.Any], animate = animate.asInstanceOf[js.Any])
          __obj.asInstanceOf[IntrinsicElements]
        }
        
        @scala.inline
        implicit open class MutableBuilder[Self <: IntrinsicElements] (val x: Self) extends AnyVal {
          
          inline def setAbbr(value: DetailedHTMLProps[HTMLAttributes[HTMLElement], HTMLElement]): Self = StObject.set(x, "abbr", value.asInstanceOf[js.Any])
          
          inline def setAnimate(value: SVGProps[SVGElement]): Self = StObject.set(x, "animate", value.asInstanceOf[js.Any])
        }
      }
    }
  }
}
