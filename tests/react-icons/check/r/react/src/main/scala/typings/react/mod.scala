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
    extends ComponentType[P]
       with Instantiable1[/* props */ P, Component[P, ComponentState]]
       with Instantiable2[/* props */ P, /* context */ js.Any, Component[P, ComponentState]] {
    
    var defaultProps: js.UndefOr[Partial[P]] = js.native
    
    var displayName: js.UndefOr[String] = js.native
  }
  
  /* Rewritten from type alias, can be one of: 
    - typings.react.mod.ComponentClass[P]
    - typings.react.mod.StatelessComponent[P]
  */
  trait ComponentType[P] extends js.Object
  
  @js.native
  trait DOMAttributes[T] extends js.Object {
    
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
      def setChildren(value: ReactNode): Self = this.set("children", value.asInstanceOf[js.Any])
      
      @scala.inline
      def deleteChildren: Self = this.set("children", js.undefined)
      
      @scala.inline
      def setDangerouslySetInnerHTML(value: Html): Self = this.set("dangerouslySetInnerHTML", value.asInstanceOf[js.Any])
      
      @scala.inline
      def deleteDangerouslySetInnerHTML: Self = this.set("dangerouslySetInnerHTML", js.undefined)
    }
  }
  
  // string fallback for custom web-components
  @js.native
  trait DOMElement[P /* <: HTMLAttributes[T] | SVGAttributes[T] */, T /* <: Element */] extends ReactElement {
    
    var ref: Ref[T] = js.native
    
    @JSName("type")
    var type_DOMElement: String = js.native
  }
  object DOMElement {
    
    @scala.inline
    def apply[P /* <: HTMLAttributes[T] | SVGAttributes[T] */, T /* <: Element */](props: js.Any, ref: Ref[T], `type`: String): DOMElement[P, T] = {
      val __obj = js.Dynamic.literal(props = props.asInstanceOf[js.Any], ref = ref.asInstanceOf[js.Any])
      __obj.updateDynamic("type")(`type`.asInstanceOf[js.Any])
      __obj.asInstanceOf[DOMElement[P, T]]
    }
    
    @scala.inline
    implicit class DOMElementOps[Self <: DOMElement[_, _], P /* <: HTMLAttributes[T] | SVGAttributes[T] */, T /* <: Element */] (val x: Self with (DOMElement[P, T])) extends AnyVal {
      
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
      def setType(value: String): Self = this.set("type", value.asInstanceOf[js.Any])
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
  trait ReactElement extends js.Object {
    
    var key: Key | Null = js.native
    
    var props: js.Any = js.native
    
    var `type`: String | ComponentClass[_] = js.native
  }
  object ReactElement {
    
    @scala.inline
    def apply(props: js.Any, `type`: String | ComponentClass[_]): ReactElement = {
      val __obj = js.Dynamic.literal(props = props.asInstanceOf[js.Any])
      __obj.updateDynamic("type")(`type`.asInstanceOf[js.Any])
      __obj.asInstanceOf[ReactElement]
    }
    
    @scala.inline
    implicit class ReactElementOps[Self <: ReactElement] (val x: Self) extends AnyVal {
      
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
      def setType(value: String | ComponentClass[_]): Self = this.set("type", value.asInstanceOf[js.Any])
      
      @scala.inline
      def setKey(value: Key): Self = this.set("key", value.asInstanceOf[js.Any])
      
      @scala.inline
      def setKeyNull: Self = this.set("key", null)
    }
  }
  
  @js.native
  trait ReactSVG extends js.Object {
    
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
    implicit class ReactSVGOps[Self <: ReactSVG] (val x: Self) extends AnyVal {
      
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
      def setAnimate(value: SVGFactory): Self = this.set("animate", value.asInstanceOf[js.Any])
      
      @scala.inline
      def setCircle(value: SVGFactory): Self = this.set("circle", value.asInstanceOf[js.Any])
      
      @scala.inline
      def setClipPath(value: SVGFactory): Self = this.set("clipPath", value.asInstanceOf[js.Any])
    }
  }
  
  // ReactSVG for ReactSVGElement
  @js.native
  trait ReactSVGElement extends DOMElement[SVGAttributes[SVGElement], SVGElement] {
    
    @JSName("type")
    var type_ReactSVGElement: animate | circle | clipPath = js.native
  }
  object ReactSVGElement {
    
    @scala.inline
    def apply(props: js.Any, ref: Ref[SVGElement], `type`: animate | circle | clipPath): ReactSVGElement = {
      val __obj = js.Dynamic.literal(props = props.asInstanceOf[js.Any], ref = ref.asInstanceOf[js.Any])
      __obj.updateDynamic("type")(`type`.asInstanceOf[js.Any])
      __obj.asInstanceOf[ReactSVGElement]
    }
    
    @scala.inline
    implicit class ReactSVGElementOps[Self <: ReactSVGElement] (val x: Self) extends AnyVal {
      
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
      def setType(value: animate | circle | clipPath): Self = this.set("type", value.asInstanceOf[js.Any])
    }
  }
  
  @js.native
  trait SVGAttributes[T] extends DOMAttributes[T] {
    
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
    implicit class SVGAttributesOps[Self <: SVGAttributes[_], T] (val x: Self with SVGAttributes[T]) extends AnyVal {
      
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
      def setClassName(value: String): Self = this.set("className", value.asInstanceOf[js.Any])
      
      @scala.inline
      def deleteClassName: Self = this.set("className", js.undefined)
      
      @scala.inline
      def setColor(value: String): Self = this.set("color", value.asInstanceOf[js.Any])
      
      @scala.inline
      def deleteColor: Self = this.set("color", js.undefined)
      
      @scala.inline
      def setHeight(value: Double | String): Self = this.set("height", value.asInstanceOf[js.Any])
      
      @scala.inline
      def deleteHeight: Self = this.set("height", js.undefined)
    }
  }
  
  @js.native
  trait SVGFactory extends DOMFactory[SVGAttributes[SVGElement], SVGElement] {
    
    def apply(props: ClassAttributes[SVGElement] with SVGAttributes[SVGElement], children: ReactNode*): ReactSVGElement = js.native
    def apply(props: js.UndefOr[scala.Nothing], children: ReactNode*): ReactSVGElement = js.native
    def apply(props: Null, children: ReactNode*): ReactSVGElement = js.native
  }
  
  @js.native
  trait StatelessComponent[P] extends ComponentType[P] {
    
    def apply(props: P with Children): ReactElement | Null = js.native
    def apply(props: P with Children, context: js.Any): ReactElement | Null = js.native
    
    var defaultProps: js.UndefOr[Partial[P]] = js.native
    
    var displayName: js.UndefOr[String] = js.native
  }
  
  type ComponentState = js.Object
  
  type DOMFactory[P /* <: DOMAttributes[T] */, T /* <: Element */] = js.Function2[
    /* props */ js.UndefOr[(ClassAttributes[T] with P) | Null], 
    /* repeated */ ReactNode, 
    DOMElement[P, T]
  ]
  
  type Key = String | Double
  
  type ReactNode = js.UndefOr[String | Double | Boolean]
  
  type Ref[T] = String | (js.Function1[/* instance */ T | Null, js.Any])
  
  type SFC[P] = StatelessComponent[P]
  
  type SVGProps[T] = ClassAttributes[T]
}
