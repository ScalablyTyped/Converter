package typingsSlinky.react

import org.scalablytyped.runtime.Instantiable1
import org.scalablytyped.runtime.Instantiable2
import org.scalajs.dom.raw.AnimationEvent
import org.scalajs.dom.raw.HTMLElement
import org.scalajs.dom.raw.SVGElement
import slinky.core.ReactComponentClass
import typingsSlinky.react.anon.Children
import typingsSlinky.react.anon.Html
import typingsSlinky.std.Partial
import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

object mod {
  
  @js.native
  trait AllHTMLAttributes[T]
    extends StObject
       with HTMLAttributes[T] {
    
    var accept: js.UndefOr[String] = js.native
    
    var acceptCharset: js.UndefOr[String] = js.native
  }
  object AllHTMLAttributes {
    
    @scala.inline
    def apply[T](): AllHTMLAttributes[T] = {
      val __obj = js.Dynamic.literal()
      __obj.asInstanceOf[AllHTMLAttributes[T]]
    }
    
    @scala.inline
    implicit class AllHTMLAttributesMutableBuilder[Self <: AllHTMLAttributes[_], T] (val x: Self with AllHTMLAttributes[T]) extends AnyVal {
      
      @scala.inline
      def setAccept(value: String): Self = StObject.set(x, "accept", value.asInstanceOf[js.Any])
      
      @scala.inline
      def setAcceptCharset(value: String): Self = StObject.set(x, "acceptCharset", value.asInstanceOf[js.Any])
      
      @scala.inline
      def setAcceptCharsetUndefined: Self = StObject.set(x, "acceptCharset", js.undefined)
      
      @scala.inline
      def setAcceptUndefined: Self = StObject.set(x, "accept", js.undefined)
    }
  }
  
  // interface SyntheticEvent<T> {
  //     currentTarget: EventTarget & T;
  // }
  // interface AnimationEvent<T> extends SyntheticEvent<T> {
  //     nativeEvent: NativeAnimationEvent;
  // }
  @js.native
  trait Attributes extends StObject {
    
    var key: js.UndefOr[Key] = js.native
  }
  object Attributes {
    
    @scala.inline
    def apply(): Attributes = {
      val __obj = js.Dynamic.literal()
      __obj.asInstanceOf[Attributes]
    }
    
    @scala.inline
    implicit class AttributesMutableBuilder[Self <: Attributes] (val x: Self) extends AnyVal {
      
      @scala.inline
      def setKey(value: Key): Self = StObject.set(x, "key", value.asInstanceOf[js.Any])
      
      @scala.inline
      def setKeyUndefined: Self = StObject.set(x, "key", js.undefined)
    }
  }
  
  @js.native
  trait ClassAttributes[T]
    extends StObject
       with Attributes {
    
    var ref: js.UndefOr[Ref[T]] = js.native
  }
  object ClassAttributes {
    
    @scala.inline
    def apply[T](): ClassAttributes[T] = {
      val __obj = js.Dynamic.literal()
      __obj.asInstanceOf[ClassAttributes[T]]
    }
    
    @scala.inline
    implicit class ClassAttributesMutableBuilder[Self <: ClassAttributes[_], T] (val x: Self with ClassAttributes[T]) extends AnyVal {
      
      @scala.inline
      def setRef(value: Ref[T]): Self = StObject.set(x, "ref", value.asInstanceOf[js.Any])
      
      @scala.inline
      def setRefFunction1(value: /* instance */ T | Null => js.Any): Self = StObject.set(x, "ref", js.Any.fromFunction1(value))
      
      @scala.inline
      def setRefUndefined: Self = StObject.set(x, "ref", js.undefined)
    }
  }
  
  @js.native
  trait Component[P, S] extends StObject
  
  @js.native
  trait ComponentClass[P]
    extends StObject
       with Instantiable1[/* props */ P, ReactComponentClass[P]]
       with Instantiable2[/* props */ P, /* context */ js.Any, ReactComponentClass[P]] {
    
    var defaultProps: js.UndefOr[Partial[P]] = js.native
    
    var displayName: js.UndefOr[String] = js.native
  }
  
  type ComponentState = js.Object
  
  type ComponentType[P] = ReactComponentClass[P]
  
  @js.native
  trait DOMAttributes[T] extends StObject {
    
    var children: js.UndefOr[slinky.core.facade.ReactElement] = js.native
    
    var dangerouslySetInnerHTML: js.UndefOr[Html] = js.native
  }
  object DOMAttributes {
    
    @scala.inline
    def apply[T](): DOMAttributes[T] = {
      val __obj = js.Dynamic.literal()
      __obj.asInstanceOf[DOMAttributes[T]]
    }
    
    @scala.inline
    implicit class DOMAttributesMutableBuilder[Self <: DOMAttributes[_], T] (val x: Self with DOMAttributes[T]) extends AnyVal {
      
      @scala.inline
      def setChildren(value: slinky.core.facade.ReactElement): Self = StObject.set(x, "children", value.asInstanceOf[js.Any])
      
      @scala.inline
      def setChildrenUndefined: Self = StObject.set(x, "children", js.undefined)
      
      @scala.inline
      def setDangerouslySetInnerHTML(value: Html): Self = StObject.set(x, "dangerouslySetInnerHTML", value.asInstanceOf[js.Any])
      
      @scala.inline
      def setDangerouslySetInnerHTMLUndefined: Self = StObject.set(x, "dangerouslySetInnerHTML", js.undefined)
    }
  }
  
  type DetailedHTMLProps[E /* <: HTMLAttributes[T] */, T] = ClassAttributes[T] with E
  
  @js.native
  trait HTMLAttributes[T]
    extends StObject
       with DOMAttributes[T] {
    
    var defaultChecked: js.UndefOr[Boolean] = js.native
  }
  object HTMLAttributes {
    
    @scala.inline
    def apply[T](): HTMLAttributes[T] = {
      val __obj = js.Dynamic.literal()
      __obj.asInstanceOf[HTMLAttributes[T]]
    }
    
    @scala.inline
    implicit class HTMLAttributesMutableBuilder[Self <: HTMLAttributes[_], T] (val x: Self with HTMLAttributes[T]) extends AnyVal {
      
      @scala.inline
      def setDefaultChecked(value: Boolean): Self = StObject.set(x, "defaultChecked", value.asInstanceOf[js.Any])
      
      @scala.inline
      def setDefaultCheckedUndefined: Self = StObject.set(x, "defaultChecked", js.undefined)
    }
  }
  
  @js.native
  trait HTMLProps[T]
    extends StObject
       with AllHTMLAttributes[T]
       with ClassAttributes[T]
  object HTMLProps {
    
    @scala.inline
    def apply[T](): HTMLProps[T] = {
      val __obj = js.Dynamic.literal()
      __obj.asInstanceOf[HTMLProps[T]]
    }
  }
  
  type Key = String | Double
  
  type NativeAnimationEvent = AnimationEvent
  
  @js.native
  trait ReactElement extends StObject {
    
    var key: Key | Null = js.native
    
    var props: js.Any = js.native
    
    var `type`: String | ReactComponentClass[js.Any] = js.native
  }
  object ReactElement {
    
    @scala.inline
    def apply(props: js.Any, `type`: String | ReactComponentClass[js.Any]): ReactElement = {
      val __obj = js.Dynamic.literal(props = props.asInstanceOf[js.Any], key = null)
      __obj.updateDynamic("type")(`type`.asInstanceOf[js.Any])
      __obj.asInstanceOf[ReactElement]
    }
    
    @scala.inline
    implicit class ReactElementMutableBuilder[Self <: ReactElement] (val x: Self) extends AnyVal {
      
      @scala.inline
      def setKey(value: Key): Self = StObject.set(x, "key", value.asInstanceOf[js.Any])
      
      @scala.inline
      def setKeyNull: Self = StObject.set(x, "key", null)
      
      @scala.inline
      def setProps(value: js.Any): Self = StObject.set(x, "props", value.asInstanceOf[js.Any])
      
      @scala.inline
      def setType(value: String | ReactComponentClass[js.Any]): Self = StObject.set(x, "type", value.asInstanceOf[js.Any])
      
      @scala.inline
      def setTypeReactComponentClass(value: ReactComponentClass[js.Any]): Self = StObject.set(x, "type", value.asInstanceOf[js.Any])
    }
  }
  
  type ReactNode = js.UndefOr[String | Double | Boolean]
  
  type ReactType[P] = String | ReactComponentClass[P]
  
  type Ref[T] = String | (js.Function1[/* instance */ T | Null, js.Any])
  
  type SFC[P] = ReactComponentClass[P]
  
  type SVGAttributes[T] = DOMAttributes[T]
  
  type SVGProps[T] = ClassAttributes[T]
  
  @js.native
  trait StatelessComponent[P] extends StObject {
    
    def apply(props: P with Children): slinky.core.facade.ReactElement | Null = js.native
    def apply(props: P with Children, context: js.Any): slinky.core.facade.ReactElement | Null = js.native
    
    var defaultProps: js.UndefOr[Partial[P]] = js.native
    
    var displayName: js.UndefOr[String] = js.native
  }
  
  object global {
    
    object JSX {
      
      // tslint:disable-next-line:no-empty-interface
      type Element = slinky.core.facade.ReactElement
      
      @js.native
      trait ElementAttributesProperty extends StObject
      
      @js.native
      trait ElementChildrenAttribute extends StObject
      
      @js.native
      trait ElementClass
        extends StObject
           with Component[js.Any, js.Object] {
        
        def render(): slinky.core.facade.ReactElement = js.native
      }
      object ElementClass {
        
        @scala.inline
        def apply(render: () => slinky.core.facade.ReactElement): ElementClass = {
          val __obj = js.Dynamic.literal(render = js.Any.fromFunction0(render))
          __obj.asInstanceOf[ElementClass]
        }
        
        @scala.inline
        implicit class ElementClassMutableBuilder[Self <: ElementClass] (val x: Self) extends AnyVal {
          
          @scala.inline
          def setRender(value: () => slinky.core.facade.ReactElement): Self = StObject.set(x, "render", js.Any.fromFunction0(value))
        }
      }
      
      // tslint:disable-next-line:no-empty-interface
      type IntrinsicAttributes = Attributes
      
      // tslint:disable-next-line:no-empty-interface
      type IntrinsicClassAttributes[T] = ClassAttributes[T]
      
      @js.native
      trait IntrinsicElements extends StObject {
        
        // HTML
        var abbr: DetailedHTMLProps[HTMLAttributes[HTMLElement], HTMLElement] = js.native
        
        var animate: SVGProps[SVGElement] = js.native
      }
      object IntrinsicElements {
        
        @scala.inline
        def apply(abbr: DetailedHTMLProps[HTMLAttributes[HTMLElement], HTMLElement], animate: SVGProps[SVGElement]): IntrinsicElements = {
          val __obj = js.Dynamic.literal(abbr = abbr.asInstanceOf[js.Any], animate = animate.asInstanceOf[js.Any])
          __obj.asInstanceOf[IntrinsicElements]
        }
        
        @scala.inline
        implicit class IntrinsicElementsMutableBuilder[Self <: IntrinsicElements] (val x: Self) extends AnyVal {
          
          @scala.inline
          def setAbbr(value: DetailedHTMLProps[HTMLAttributes[HTMLElement], HTMLElement]): Self = StObject.set(x, "abbr", value.asInstanceOf[js.Any])
          
          @scala.inline
          def setAnimate(value: SVGProps[SVGElement]): Self = StObject.set(x, "animate", value.asInstanceOf[js.Any])
        }
      }
    }
  }
}
