package typingsJapgolly.react

import japgolly.scalajs.react.CallbackTo
import japgolly.scalajs.react.raw.React.ComponentClassP
import japgolly.scalajs.react.raw.React.Element
import japgolly.scalajs.react.raw.React.Node
import japgolly.scalajs.react.vdom.VdomNode
import org.scalablytyped.runtime.Instantiable1
import org.scalablytyped.runtime.Instantiable2
import org.scalajs.dom.raw.AnimationEvent
import org.scalajs.dom.raw.HTMLElement
import org.scalajs.dom.raw.SVGElement
import typingsJapgolly.react.anon.Children
import typingsJapgolly.react.anon.Html
import typingsJapgolly.std.Partial
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
    def apply[T](
      accept: String = null,
      acceptCharset: String = null,
      children: VdomNode = null,
      dangerouslySetInnerHTML: Html = null,
      defaultChecked: js.UndefOr[Boolean] = js.undefined
    ): AllHTMLAttributes[T] = {
      val __obj = js.Dynamic.literal()
      if (accept != null) __obj.updateDynamic("accept")(accept.asInstanceOf[js.Any])
      if (acceptCharset != null) __obj.updateDynamic("acceptCharset")(acceptCharset.asInstanceOf[js.Any])
      if (children != null) __obj.updateDynamic("children")(children.rawNode.asInstanceOf[js.Any])
      if (dangerouslySetInnerHTML != null) __obj.updateDynamic("dangerouslySetInnerHTML")(dangerouslySetInnerHTML.asInstanceOf[js.Any])
      if (!js.isUndefined(defaultChecked)) __obj.updateDynamic("defaultChecked")(defaultChecked.get.asInstanceOf[js.Any])
      __obj.asInstanceOf[AllHTMLAttributes[T]]
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
    def apply(key: Key = null): Attributes = {
      val __obj = js.Dynamic.literal()
      if (key != null) __obj.updateDynamic("key")(key.asInstanceOf[js.Any])
      __obj.asInstanceOf[Attributes]
    }
  }
  
  @js.native
  trait ClassAttributes[T] extends Attributes {
    
    var ref: js.UndefOr[japgolly.scalajs.react.raw.React.Ref] = js.native
  }
  object ClassAttributes {
    
    @scala.inline
    def apply[T](key: Key = null, ref: japgolly.scalajs.react.raw.React.Ref = null): ClassAttributes[T] = {
      val __obj = js.Dynamic.literal()
      if (key != null) __obj.updateDynamic("key")(key.asInstanceOf[js.Any])
      if (ref != null) __obj.updateDynamic("ref")(ref.asInstanceOf[js.Any])
      __obj.asInstanceOf[ClassAttributes[T]]
    }
  }
  
  @js.native
  trait Component[P, S] extends js.Object
  
  @js.native
  trait ComponentClass[P]
    extends Instantiable1[
          /* props */ P, 
          japgolly.scalajs.react.raw.React.Component[P with js.Object, js.Object]
        ]
       with Instantiable2[
          /* props */ P, 
          /* context */ js.Any, 
          japgolly.scalajs.react.raw.React.Component[P with js.Object, js.Object]
        ] {
    
    var defaultProps: js.UndefOr[Partial[P]] = js.native
    
    var displayName: js.UndefOr[String] = js.native
  }
  
  @js.native
  trait DOMAttributes[T] extends js.Object {
    
    var children: js.UndefOr[Node] = js.native
    
    var dangerouslySetInnerHTML: js.UndefOr[Html] = js.native
  }
  object DOMAttributes {
    
    @scala.inline
    def apply[T](children: VdomNode = null, dangerouslySetInnerHTML: Html = null): DOMAttributes[T] = {
      val __obj = js.Dynamic.literal()
      if (children != null) __obj.updateDynamic("children")(children.rawNode.asInstanceOf[js.Any])
      if (dangerouslySetInnerHTML != null) __obj.updateDynamic("dangerouslySetInnerHTML")(dangerouslySetInnerHTML.asInstanceOf[js.Any])
      __obj.asInstanceOf[DOMAttributes[T]]
    }
  }
  
  @js.native
  trait HTMLAttributes[T] extends DOMAttributes[T] {
    
    var defaultChecked: js.UndefOr[Boolean] = js.native
  }
  object HTMLAttributes {
    
    @scala.inline
    def apply[T](
      children: VdomNode = null,
      dangerouslySetInnerHTML: Html = null,
      defaultChecked: js.UndefOr[Boolean] = js.undefined
    ): HTMLAttributes[T] = {
      val __obj = js.Dynamic.literal()
      if (children != null) __obj.updateDynamic("children")(children.rawNode.asInstanceOf[js.Any])
      if (dangerouslySetInnerHTML != null) __obj.updateDynamic("dangerouslySetInnerHTML")(dangerouslySetInnerHTML.asInstanceOf[js.Any])
      if (!js.isUndefined(defaultChecked)) __obj.updateDynamic("defaultChecked")(defaultChecked.get.asInstanceOf[js.Any])
      __obj.asInstanceOf[HTMLAttributes[T]]
    }
  }
  
  @js.native
  trait HTMLProps[T]
    extends AllHTMLAttributes[T]
       with ClassAttributes[T]
  object HTMLProps {
    
    @scala.inline
    def apply[T](
      accept: String = null,
      acceptCharset: String = null,
      children: VdomNode = null,
      dangerouslySetInnerHTML: Html = null,
      defaultChecked: js.UndefOr[Boolean] = js.undefined,
      key: Key = null,
      ref: japgolly.scalajs.react.raw.React.Ref = null
    ): HTMLProps[T] = {
      val __obj = js.Dynamic.literal()
      if (accept != null) __obj.updateDynamic("accept")(accept.asInstanceOf[js.Any])
      if (acceptCharset != null) __obj.updateDynamic("acceptCharset")(acceptCharset.asInstanceOf[js.Any])
      if (children != null) __obj.updateDynamic("children")(children.rawNode.asInstanceOf[js.Any])
      if (dangerouslySetInnerHTML != null) __obj.updateDynamic("dangerouslySetInnerHTML")(dangerouslySetInnerHTML.asInstanceOf[js.Any])
      if (!js.isUndefined(defaultChecked)) __obj.updateDynamic("defaultChecked")(defaultChecked.get.asInstanceOf[js.Any])
      if (key != null) __obj.updateDynamic("key")(key.asInstanceOf[js.Any])
      if (ref != null) __obj.updateDynamic("ref")(ref.asInstanceOf[js.Any])
      __obj.asInstanceOf[HTMLProps[T]]
    }
  }
  
  @js.native
  trait ReactElement extends js.Object {
    
    var key: Key | Null = js.native
    
    var props: js.Any = js.native
    
    var `type`: String | ComponentClassP[js.Object] | SFC[_] = js.native
  }
  object ReactElement {
    
    @scala.inline
    def apply(props: js.Any, `type`: String | ComponentClassP[js.Object] | SFC[_], key: Key = null): ReactElement = {
      val __obj = js.Dynamic.literal(props = props.asInstanceOf[js.Any], key = key.asInstanceOf[js.Any])
      __obj.updateDynamic("type")(`type`.asInstanceOf[js.Any])
      __obj.asInstanceOf[ReactElement]
    }
  }
  
  @js.native
  trait StatelessComponent[P] extends js.Object {
    
    def apply(props: P with Children): Element | Null = js.native
    def apply(props: P with Children, context: js.Any): Element | Null = js.native
    
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
        
        def render(): Node = js.native
      }
      object ElementClass {
        
        @scala.inline
        def apply(render: CallbackTo[Node]): ElementClass = {
          val __obj = js.Dynamic.literal(render = render.toJsFn)
          __obj.asInstanceOf[ElementClass]
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
      }
      
      // tslint:disable-next-line:no-empty-interface
      type Element = japgolly.scalajs.react.raw.React.Element
      
      // tslint:disable-next-line:no-empty-interface
      type IntrinsicAttributes = Attributes
      
      // tslint:disable-next-line:no-empty-interface
      type IntrinsicClassAttributes[T] = ClassAttributes[T]
    }
  }
  
  type ComponentState = js.Object
  
  type ComponentType[P] = (ComponentClassP[P with js.Object]) | StatelessComponent[P]
  
  type DetailedHTMLProps[E /* <: HTMLAttributes[T] */, T] = ClassAttributes[T] with E
  
  type Key = String | Double
  
  type NativeAnimationEvent = AnimationEvent
  
  type ReactNode = js.UndefOr[String | Double | Boolean]
  
  type ReactType[P] = String | ComponentType[P]
  
  type Ref[T] = String | (js.Function1[/* instance */ T | Null, js.Any])
  
  type SFC[P] = StatelessComponent[P]
  
  type SVGAttributes[T] = DOMAttributes[T]
  
  type SVGProps[T] = ClassAttributes[T]
}
