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
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

object mod {
  
  @js.native
  trait AllHTMLAttributes[T] extends HTMLAttributes[T] {
    
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
    implicit class AllHTMLAttributesOps[Self <: AllHTMLAttributes[_], T] (val x: Self with AllHTMLAttributes[T]) extends AnyVal {
      
      @scala.inline
      def duplicate: Self = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x)).asInstanceOf[Self]
      
      @scala.inline
      def combineWith[Other <: js.Any](other: Other): Self with Other = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x, other.asInstanceOf[js.Any])).asInstanceOf[Self with Other]
      
      @scala.inline
      def set(key: String, value: js.Any): Self = {
        x.asInstanceOf[js.Dynamic].updateDynamic(key)(value)
        x
      }
      
      @scala.inline
      def setAccept(value: String): Self = this.set("accept", value.asInstanceOf[js.Any])
      
      @scala.inline
      def deleteAccept: Self = this.set("accept", js.undefined)
      
      @scala.inline
      def setAcceptCharset(value: String): Self = this.set("acceptCharset", value.asInstanceOf[js.Any])
      
      @scala.inline
      def deleteAcceptCharset: Self = this.set("acceptCharset", js.undefined)
    }
  }
  
  // interface SyntheticEvent<T> {
  //     currentTarget: EventTarget & T;
  // }
  // interface AnimationEvent<T> extends SyntheticEvent<T> {
  //     nativeEvent: NativeAnimationEvent;
  // }
  @js.native
  trait Attributes extends js.Object {
    
    var key: js.UndefOr[Key] = js.native
  }
  object Attributes {
    
    @scala.inline
    def apply(): Attributes = {
      val __obj = js.Dynamic.literal()
      __obj.asInstanceOf[Attributes]
    }
    
    @scala.inline
    implicit class AttributesOps[Self <: Attributes] (val x: Self) extends AnyVal {
      
      @scala.inline
      def duplicate: Self = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x)).asInstanceOf[Self]
      
      @scala.inline
      def combineWith[Other <: js.Any](other: Other): Self with Other = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x, other.asInstanceOf[js.Any])).asInstanceOf[Self with Other]
      
      @scala.inline
      def set(key: String, value: js.Any): Self = {
        x.asInstanceOf[js.Dynamic].updateDynamic(key)(value)
        x
      }
      
      @scala.inline
      def setKey(value: Key): Self = this.set("key", value.asInstanceOf[js.Any])
      
      @scala.inline
      def deleteKey: Self = this.set("key", js.undefined)
    }
  }
  
  @js.native
  trait ClassAttributes[T] extends Attributes {
    
    var ref: js.UndefOr[Ref[T]] = js.native
  }
  object ClassAttributes {
    
    @scala.inline
    def apply[T](): ClassAttributes[T] = {
      val __obj = js.Dynamic.literal()
      __obj.asInstanceOf[ClassAttributes[T]]
    }
    
    @scala.inline
    implicit class ClassAttributesOps[Self <: ClassAttributes[_], T] (val x: Self with ClassAttributes[T]) extends AnyVal {
      
      @scala.inline
      def duplicate: Self = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x)).asInstanceOf[Self]
      
      @scala.inline
      def combineWith[Other <: js.Any](other: Other): Self with Other = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x, other.asInstanceOf[js.Any])).asInstanceOf[Self with Other]
      
      @scala.inline
      def set(key: String, value: js.Any): Self = {
        x.asInstanceOf[js.Dynamic].updateDynamic(key)(value)
        x
      }
      
      @scala.inline
      def setRefFunction1(value: /* instance */ T | Null => js.Any): Self = this.set("ref", js.Any.fromFunction1(value))
      
      @scala.inline
      def setRef(value: Ref[T]): Self = this.set("ref", value.asInstanceOf[js.Any])
      
      @scala.inline
      def deleteRef: Self = this.set("ref", js.undefined)
    }
  }
  
  @js.native
  trait Component[P, S] extends js.Object
  
  @js.native
  trait ComponentClass[P]
    extends Instantiable1[/* props */ P, ReactComponentClass[P]]
       with Instantiable2[/* props */ P, /* context */ js.Any, ReactComponentClass[P]] {
    
    var defaultProps: js.UndefOr[Partial[P]] = js.native
    
    var displayName: js.UndefOr[String] = js.native
  }
  
  @js.native
  trait DOMAttributes[T] extends js.Object {
    
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
    implicit class DOMAttributesOps[Self <: DOMAttributes[_], T] (val x: Self with DOMAttributes[T]) extends AnyVal {
      
      @scala.inline
      def duplicate: Self = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x)).asInstanceOf[Self]
      
      @scala.inline
      def combineWith[Other <: js.Any](other: Other): Self with Other = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x, other.asInstanceOf[js.Any])).asInstanceOf[Self with Other]
      
      @scala.inline
      def set(key: String, value: js.Any): Self = {
        x.asInstanceOf[js.Dynamic].updateDynamic(key)(value)
        x
      }
      
      @scala.inline
      def setChildren(value: slinky.core.facade.ReactElement): Self = this.set("children", value.asInstanceOf[js.Any])
      
      @scala.inline
      def deleteChildren: Self = this.set("children", js.undefined)
      
      @scala.inline
      def setDangerouslySetInnerHTML(value: Html): Self = this.set("dangerouslySetInnerHTML", value.asInstanceOf[js.Any])
      
      @scala.inline
      def deleteDangerouslySetInnerHTML: Self = this.set("dangerouslySetInnerHTML", js.undefined)
    }
  }
  
  @js.native
  trait HTMLAttributes[T] extends DOMAttributes[T] {
    
    var defaultChecked: js.UndefOr[Boolean] = js.native
  }
  object HTMLAttributes {
    
    @scala.inline
    def apply[T](): HTMLAttributes[T] = {
      val __obj = js.Dynamic.literal()
      __obj.asInstanceOf[HTMLAttributes[T]]
    }
    
    @scala.inline
    implicit class HTMLAttributesOps[Self <: HTMLAttributes[_], T] (val x: Self with HTMLAttributes[T]) extends AnyVal {
      
      @scala.inline
      def duplicate: Self = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x)).asInstanceOf[Self]
      
      @scala.inline
      def combineWith[Other <: js.Any](other: Other): Self with Other = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x, other.asInstanceOf[js.Any])).asInstanceOf[Self with Other]
      
      @scala.inline
      def set(key: String, value: js.Any): Self = {
        x.asInstanceOf[js.Dynamic].updateDynamic(key)(value)
        x
      }
      
      @scala.inline
      def setDefaultChecked(value: Boolean): Self = this.set("defaultChecked", value.asInstanceOf[js.Any])
      
      @scala.inline
      def deleteDefaultChecked: Self = this.set("defaultChecked", js.undefined)
    }
  }
  
  @js.native
  trait HTMLProps[T]
    extends AllHTMLAttributes[T]
       with ClassAttributes[T]
  object HTMLProps {
    
    @scala.inline
    def apply[T](): HTMLProps[T] = {
      val __obj = js.Dynamic.literal()
      __obj.asInstanceOf[HTMLProps[T]]
    }
  }
  
  @js.native
  trait ReactElement extends js.Object {
    
    var key: Key | Null = js.native
    
    var props: js.Any = js.native
    
    var `type`: String | ReactComponentClass[_] = js.native
  }
  object ReactElement {
    
    @scala.inline
    def apply(props: js.Any, `type`: String | ReactComponentClass[_]): ReactElement = {
      val __obj = js.Dynamic.literal(props = props.asInstanceOf[js.Any])
      __obj.updateDynamic("type")(`type`.asInstanceOf[js.Any])
      __obj.asInstanceOf[ReactElement]
    }
    
    @scala.inline
    implicit class ReactElementOps[Self <: slinky.core.facade.ReactElement] (val x: Self) extends AnyVal {
      
      @scala.inline
      def duplicate: Self = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x)).asInstanceOf[Self]
      
      @scala.inline
      def combineWith[Other <: js.Any](other: Other): Self with Other = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x, other.asInstanceOf[js.Any])).asInstanceOf[Self with Other]
      
      @scala.inline
      def set(key: String, value: js.Any): Self = {
        x.asInstanceOf[js.Dynamic].updateDynamic(key)(value)
        x
      }
      
      @scala.inline
      def setProps(value: js.Any): Self = this.set("props", value.asInstanceOf[js.Any])
      
      @scala.inline
      def setTypeStatelessComponent(value: ReactComponentClass[_]): Self = this.set("type", value.asInstanceOf[js.Any])
      
      @scala.inline
      def setTypeComponentClass(value: ReactComponentClass[_]): Self = this.set("type", value.asInstanceOf[js.Any])
      
      @scala.inline
      def setType(value: String | ReactComponentClass[_]): Self = this.set("type", value.asInstanceOf[js.Any])
      
      @scala.inline
      def setKey(value: Key): Self = this.set("key", value.asInstanceOf[js.Any])
      
      @scala.inline
      def setKeyNull: Self = this.set("key", null)
    }
  }
  
  @js.native
  trait StatelessComponent[P] extends js.Object {
    
    def apply(props: P with Children): slinky.core.facade.ReactElement | Null = js.native
    def apply(props: P with Children, context: js.Any): slinky.core.facade.ReactElement | Null = js.native
    
    var defaultProps: js.UndefOr[Partial[P]] = js.native
    
    var displayName: js.UndefOr[String] = js.native
  }
  
  object global {
    
    object JSX {
      
      @js.native
      trait ElementAttributesProperty extends js.Object
      
      @js.native
      trait ElementChildrenAttribute extends js.Object
      
      @js.native
      trait ElementClass
        extends Component[js.Any, js.Object] {
        
        def render(): slinky.core.facade.ReactElement = js.native
      }
      object ElementClass {
        
        @scala.inline
        def apply(render: () => slinky.core.facade.ReactElement): ElementClass = {
          val __obj = js.Dynamic.literal(render = js.Any.fromFunction0(render))
          __obj.asInstanceOf[ElementClass]
        }
        
        @scala.inline
        implicit class ElementClassOps[Self <: ElementClass] (val x: Self) extends AnyVal {
          
          @scala.inline
          def duplicate: Self = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x)).asInstanceOf[Self]
          
          @scala.inline
          def combineWith[Other <: js.Any](other: Other): Self with Other = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x, other.asInstanceOf[js.Any])).asInstanceOf[Self with Other]
          
          @scala.inline
          def set(key: String, value: js.Any): Self = {
            x.asInstanceOf[js.Dynamic].updateDynamic(key)(value)
            x
          }
          
          @scala.inline
          def setRender(value: () => slinky.core.facade.ReactElement): Self = this.set("render", js.Any.fromFunction0(value))
        }
      }
      
      @js.native
      trait IntrinsicElements extends js.Object {
        
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
        implicit class IntrinsicElementsOps[Self <: IntrinsicElements] (val x: Self) extends AnyVal {
          
          @scala.inline
          def duplicate: Self = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x)).asInstanceOf[Self]
          
          @scala.inline
          def combineWith[Other <: js.Any](other: Other): Self with Other = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x, other.asInstanceOf[js.Any])).asInstanceOf[Self with Other]
          
          @scala.inline
          def set(key: String, value: js.Any): Self = {
            x.asInstanceOf[js.Dynamic].updateDynamic(key)(value)
            x
          }
          
          @scala.inline
          def setAbbr(value: DetailedHTMLProps[HTMLAttributes[HTMLElement], HTMLElement]): Self = this.set("abbr", value.asInstanceOf[js.Any])
          
          @scala.inline
          def setAnimate(value: SVGProps[SVGElement]): Self = this.set("animate", value.asInstanceOf[js.Any])
        }
      }
      
      // tslint:disable-next-line:no-empty-interface
      type Element = slinky.core.facade.ReactElement
      
      // tslint:disable-next-line:no-empty-interface
      type IntrinsicAttributes = Attributes
      
      // tslint:disable-next-line:no-empty-interface
      type IntrinsicClassAttributes[T] = ClassAttributes[T]
    }
  }
  
  type ComponentState = js.Object
  
  type ComponentType[P] = ReactComponentClass[P]
  
  type DetailedHTMLProps[E /* <: HTMLAttributes[T] */, T] = ClassAttributes[T] with E
  
  type Key = String | Double
  
  type NativeAnimationEvent = AnimationEvent
  
  type ReactNode = js.UndefOr[String | Double | Boolean]
  
  type ReactType[P] = String | ReactComponentClass[P]
  
  type Ref[T] = String | (js.Function1[/* instance */ T | Null, js.Any])
  
  type SFC[P] = ReactComponentClass[P]
  
  type SVGAttributes[T] = DOMAttributes[T]
  
  type SVGProps[T] = ClassAttributes[T]
}
