package typings.react

import org.scalablytyped.runtime.Instantiable1
import org.scalablytyped.runtime.Instantiable2
import typings.react.anon.Children
import typings.react.anon.Html
import typings.react.reactStrings.animate
import typings.react.reactStrings.circle
import typings.react.reactStrings.clipPath
import typings.std.Element
import typings.std.Partial
import typings.std.SVGElement
import org.scalablytyped.runtime.StObject
import scala.scalajs.js
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
    implicit class AllHTMLAttributesMutableBuilder[Self <: AllHTMLAttributes[?], T] (val x: Self & AllHTMLAttributes[T]) extends AnyVal {
      
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
    implicit class ClassAttributesMutableBuilder[Self <: ClassAttributes[?], T] (val x: Self & ClassAttributes[T]) extends AnyVal {
      
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
       with Instantiable1[/* props */ P, Component[P, ComponentState]]
       with Instantiable2[/* props */ P, /* context */ js.Any, Component[P, ComponentState]]
       with ComponentType[P] {
    
    var defaultProps: js.UndefOr[Partial[P]] = js.native
    
    var displayName: js.UndefOr[String] = js.native
  }
  
  type ComponentState = js.Object
  
  /* Rewritten from type alias, can be one of: 
    - typings.react.mod.ComponentClass[P]
    - typings.react.mod.StatelessComponent[P]
  */
  trait ComponentType[P] extends StObject
  
  @js.native
  trait DOMAttributes[T] extends StObject {
    
    var children: js.UndefOr[ReactNode] = js.native
    
    var dangerouslySetInnerHTML: js.UndefOr[Html] = js.native
  }
  object DOMAttributes {
    
    @scala.inline
    def apply[T](): DOMAttributes[T] = {
      val __obj = js.Dynamic.literal()
      __obj.asInstanceOf[DOMAttributes[T]]
    }
    
    @scala.inline
    implicit class DOMAttributesMutableBuilder[Self <: DOMAttributes[?], T] (val x: Self & DOMAttributes[T]) extends AnyVal {
      
      @scala.inline
      def setChildren(value: ReactNode): Self = StObject.set(x, "children", value.asInstanceOf[js.Any])
      
      @scala.inline
      def setChildrenUndefined: Self = StObject.set(x, "children", js.undefined)
      
      @scala.inline
      def setDangerouslySetInnerHTML(value: Html): Self = StObject.set(x, "dangerouslySetInnerHTML", value.asInstanceOf[js.Any])
      
      @scala.inline
      def setDangerouslySetInnerHTMLUndefined: Self = StObject.set(x, "dangerouslySetInnerHTML", js.undefined)
    }
  }
  
  // string fallback for custom web-components
  @js.native
  trait DOMElement[P /* <: HTMLAttributes[T] | SVGAttributes[T] */, T /* <: Element */]
    extends StObject
       with ReactElement {
    
    var ref: Ref[T] = js.native
    
    @JSName("type")
    var type_DOMElement: String = js.native
  }
  object DOMElement {
    
    @scala.inline
    def apply[P /* <: HTMLAttributes[T] | SVGAttributes[T] */, T /* <: Element */](props: js.Any, ref: Ref[T], `type`: String): DOMElement[P, T] = {
      val __obj = js.Dynamic.literal(props = props.asInstanceOf[js.Any], ref = ref.asInstanceOf[js.Any], key = null)
      __obj.updateDynamic("type")(`type`.asInstanceOf[js.Any])
      __obj.asInstanceOf[DOMElement[P, T]]
    }
    
    @scala.inline
    implicit class DOMElementMutableBuilder[Self <: DOMElement[?, ?], P /* <: HTMLAttributes[T] | SVGAttributes[T] */, T /* <: Element */] (val x: Self & (DOMElement[P, T])) extends AnyVal {
      
      @scala.inline
      def setRef(value: Ref[T]): Self = StObject.set(x, "ref", value.asInstanceOf[js.Any])
      
      @scala.inline
      def setRefFunction1(value: /* instance */ T | Null => js.Any): Self = StObject.set(x, "ref", js.Any.fromFunction1(value))
      
      @scala.inline
      def setType(value: String): Self = StObject.set(x, "type", value.asInstanceOf[js.Any])
    }
  }
  
  @js.native
  trait DOMFactory[P /* <: DOMAttributes[T] */, T /* <: Element */] extends StObject {
    
    def apply(props: ClassAttributes[T] & P, children: ReactNode*): DOMElement[P, T] = js.native
    def apply(props: Null, children: ReactNode*): DOMElement[P, T] = js.native
    def apply(props: Unit, children: ReactNode*): DOMElement[P, T] = js.native
  }
  
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
    implicit class HTMLAttributesMutableBuilder[Self <: HTMLAttributes[?], T] (val x: Self & HTMLAttributes[T]) extends AnyVal {
      
      @scala.inline
      def setDefaultChecked(value: Boolean): Self = StObject.set(x, "defaultChecked", value.asInstanceOf[js.Any])
      
      @scala.inline
      def setDefaultCheckedUndefined: Self = StObject.set(x, "defaultChecked", js.undefined)
    }
  }
  
  type Key = String | Double
  
  @js.native
  trait ReactElement extends StObject {
    
    var key: Key | Null = js.native
    
    var props: js.Any = js.native
    
    var `type`: String | ComponentClass[js.Any] = js.native
  }
  object ReactElement {
    
    @scala.inline
    def apply(props: js.Any, `type`: String | ComponentClass[js.Any]): ReactElement = {
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
      def setType(value: String | ComponentClass[js.Any]): Self = StObject.set(x, "type", value.asInstanceOf[js.Any])
    }
  }
  
  type ReactNode = js.UndefOr[String | Double | Boolean]
  
  @js.native
  trait ReactSVG extends StObject {
    
    var animate: SVGFactory = js.native
    
    var circle: SVGFactory = js.native
    
    var clipPath: SVGFactory = js.native
  }
  object ReactSVG {
    
    @scala.inline
    def apply(animate: SVGFactory, circle: SVGFactory, clipPath: SVGFactory): ReactSVG = {
      val __obj = js.Dynamic.literal(animate = animate.asInstanceOf[js.Any], circle = circle.asInstanceOf[js.Any], clipPath = clipPath.asInstanceOf[js.Any])
      __obj.asInstanceOf[ReactSVG]
    }
    
    @scala.inline
    implicit class ReactSVGMutableBuilder[Self <: ReactSVG] (val x: Self) extends AnyVal {
      
      @scala.inline
      def setAnimate(value: SVGFactory): Self = StObject.set(x, "animate", value.asInstanceOf[js.Any])
      
      @scala.inline
      def setCircle(value: SVGFactory): Self = StObject.set(x, "circle", value.asInstanceOf[js.Any])
      
      @scala.inline
      def setClipPath(value: SVGFactory): Self = StObject.set(x, "clipPath", value.asInstanceOf[js.Any])
    }
  }
  
  // ReactSVG for ReactSVGElement
  @js.native
  trait ReactSVGElement
    extends StObject
       with DOMElement[SVGAttributes[SVGElement], SVGElement] {
    
    @JSName("type")
    var type_ReactSVGElement: animate | circle | clipPath = js.native
  }
  object ReactSVGElement {
    
    @scala.inline
    def apply(props: js.Any, ref: Ref[SVGElement], `type`: animate | circle | clipPath): ReactSVGElement = {
      val __obj = js.Dynamic.literal(props = props.asInstanceOf[js.Any], ref = ref.asInstanceOf[js.Any], key = null)
      __obj.updateDynamic("type")(`type`.asInstanceOf[js.Any])
      __obj.asInstanceOf[ReactSVGElement]
    }
    
    @scala.inline
    implicit class ReactSVGElementMutableBuilder[Self <: ReactSVGElement] (val x: Self) extends AnyVal {
      
      @scala.inline
      def setType(value: animate | circle | clipPath): Self = StObject.set(x, "type", value.asInstanceOf[js.Any])
    }
  }
  
  type Ref[T] = String | (js.Function1[/* instance */ T | Null, js.Any])
  
  type SFC[P] = StatelessComponent[P]
  
  @js.native
  trait SVGAttributes[T]
    extends StObject
       with DOMAttributes[T] {
    
    // Attributes which also defined in HTMLAttributes
    // See comment in SVGDOMPropertyConfig.js
    var className: js.UndefOr[String] = js.native
    
    var color: js.UndefOr[String] = js.native
    
    var height: js.UndefOr[Double | String] = js.native
  }
  object SVGAttributes {
    
    @scala.inline
    def apply[T](): SVGAttributes[T] = {
      val __obj = js.Dynamic.literal()
      __obj.asInstanceOf[SVGAttributes[T]]
    }
    
    @scala.inline
    implicit class SVGAttributesMutableBuilder[Self <: SVGAttributes[?], T] (val x: Self & SVGAttributes[T]) extends AnyVal {
      
      @scala.inline
      def setClassName(value: String): Self = StObject.set(x, "className", value.asInstanceOf[js.Any])
      
      @scala.inline
      def setClassNameUndefined: Self = StObject.set(x, "className", js.undefined)
      
      @scala.inline
      def setColor(value: String): Self = StObject.set(x, "color", value.asInstanceOf[js.Any])
      
      @scala.inline
      def setColorUndefined: Self = StObject.set(x, "color", js.undefined)
      
      @scala.inline
      def setHeight(value: Double | String): Self = StObject.set(x, "height", value.asInstanceOf[js.Any])
      
      @scala.inline
      def setHeightUndefined: Self = StObject.set(x, "height", js.undefined)
    }
  }
  
  @js.native
  trait SVGFactory
    extends StObject
       with DOMFactory[SVGAttributes[SVGElement], SVGElement]
  
  type SVGProps[T] = ClassAttributes[T]
  
  @js.native
  trait StatelessComponent[P]
    extends StObject
       with ComponentType[P] {
    
    def apply(props: P & Children): ReactElement | Null = js.native
    def apply(props: P & Children, context: js.Any): ReactElement | Null = js.native
    
    var defaultProps: js.UndefOr[Partial[P]] = js.native
    
    var displayName: js.UndefOr[String] = js.native
  }
}
