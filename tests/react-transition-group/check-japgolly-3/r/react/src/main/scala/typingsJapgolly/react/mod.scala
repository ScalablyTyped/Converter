package typingsJapgolly.react

import japgolly.scalajs.react.CallbackTo
import japgolly.scalajs.react.facade.React.ComponentClassP
import japgolly.scalajs.react.facade.React.Element
import japgolly.scalajs.react.facade.React.Node
import japgolly.scalajs.react.vdom.VdomNode
import org.scalablytyped.runtime.Instantiable1
import org.scalablytyped.runtime.Instantiable2
import org.scalajs.dom.AnimationEvent
import org.scalajs.dom.HTMLElement
import org.scalajs.dom.SVGElement
import typingsJapgolly.react.anon.Children
import typingsJapgolly.react.anon.Html
import typingsJapgolly.std.Partial
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
    
    inline def apply[T](
      accept: String = null,
      acceptCharset: String = null,
      children: js.UndefOr[Null | VdomNode] = js.undefined,
      dangerouslySetInnerHTML: Html = null,
      defaultChecked: js.UndefOr[Boolean] = js.undefined
    ): AllHTMLAttributes[T] = {
      val __obj = js.Dynamic.literal()
      if (accept != null) __obj.updateDynamic("accept")(accept.asInstanceOf[js.Any])
      if (acceptCharset != null) __obj.updateDynamic("acceptCharset")(acceptCharset.asInstanceOf[js.Any])
      if (!js.isUndefined(children)) __obj.updateDynamic("children")(if (children != null) children.asInstanceOf[VdomNode].rawNode.asInstanceOf[js.Any] else null)
      if (dangerouslySetInnerHTML != null) __obj.updateDynamic("dangerouslySetInnerHTML")(dangerouslySetInnerHTML.asInstanceOf[js.Any])
      if (!js.isUndefined(defaultChecked)) __obj.updateDynamic("defaultChecked")(defaultChecked.asInstanceOf[js.Any])
      __obj.asInstanceOf[AllHTMLAttributes[T]]
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
    
    inline def apply(key: Key = null): Attributes = {
      val __obj = js.Dynamic.literal()
      if (key != null) __obj.updateDynamic("key")(key.asInstanceOf[js.Any])
      __obj.asInstanceOf[Attributes]
    }
  }
  
  trait ClassAttributes[T]
    extends StObject
       with Attributes {
    
    var ref: js.UndefOr[Ref[T]] = js.undefined
  }
  object ClassAttributes {
    
    inline def apply[T](key: Key = null, ref: Ref[T] = null): ClassAttributes[T] = {
      val __obj = js.Dynamic.literal()
      if (key != null) __obj.updateDynamic("key")(key.asInstanceOf[js.Any])
      if (ref != null) __obj.updateDynamic("ref")(ref.asInstanceOf[js.Any])
      __obj.asInstanceOf[ClassAttributes[T]]
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
  }
  object DOMAttributes {
    
    inline def apply[T](children: js.UndefOr[Null | VdomNode] = js.undefined, dangerouslySetInnerHTML: Html = null): DOMAttributes[T] = {
      val __obj = js.Dynamic.literal()
      if (!js.isUndefined(children)) __obj.updateDynamic("children")(if (children != null) children.asInstanceOf[VdomNode].rawNode.asInstanceOf[js.Any] else null)
      if (dangerouslySetInnerHTML != null) __obj.updateDynamic("dangerouslySetInnerHTML")(dangerouslySetInnerHTML.asInstanceOf[js.Any])
      __obj.asInstanceOf[DOMAttributes[T]]
    }
  }
  
  type DetailedHTMLProps[E /* <: HTMLAttributes[T] */, T] = ClassAttributes[T] & E
  
  trait HTMLAttributes[T]
    extends StObject
       with DOMAttributes[T] {
    
    var defaultChecked: js.UndefOr[Boolean] = js.undefined
  }
  object HTMLAttributes {
    
    inline def apply[T](
      children: js.UndefOr[Null | VdomNode] = js.undefined,
      dangerouslySetInnerHTML: Html = null,
      defaultChecked: js.UndefOr[Boolean] = js.undefined
    ): HTMLAttributes[T] = {
      val __obj = js.Dynamic.literal()
      if (!js.isUndefined(children)) __obj.updateDynamic("children")(if (children != null) children.asInstanceOf[VdomNode].rawNode.asInstanceOf[js.Any] else null)
      if (dangerouslySetInnerHTML != null) __obj.updateDynamic("dangerouslySetInnerHTML")(dangerouslySetInnerHTML.asInstanceOf[js.Any])
      if (!js.isUndefined(defaultChecked)) __obj.updateDynamic("defaultChecked")(defaultChecked.asInstanceOf[js.Any])
      __obj.asInstanceOf[HTMLAttributes[T]]
    }
  }
  
  trait HTMLProps[T]
    extends StObject
       with AllHTMLAttributes[T]
       with ClassAttributes[T]
  object HTMLProps {
    
    inline def apply[T](
      accept: String = null,
      acceptCharset: String = null,
      children: js.UndefOr[Null | VdomNode] = js.undefined,
      dangerouslySetInnerHTML: Html = null,
      defaultChecked: js.UndefOr[Boolean] = js.undefined,
      key: Key = null,
      ref: Ref[T] = null
    ): HTMLProps[T] = {
      val __obj = js.Dynamic.literal()
      if (accept != null) __obj.updateDynamic("accept")(accept.asInstanceOf[js.Any])
      if (acceptCharset != null) __obj.updateDynamic("acceptCharset")(acceptCharset.asInstanceOf[js.Any])
      if (!js.isUndefined(children)) __obj.updateDynamic("children")(if (children != null) children.asInstanceOf[VdomNode].rawNode.asInstanceOf[js.Any] else null)
      if (dangerouslySetInnerHTML != null) __obj.updateDynamic("dangerouslySetInnerHTML")(dangerouslySetInnerHTML.asInstanceOf[js.Any])
      if (!js.isUndefined(defaultChecked)) __obj.updateDynamic("defaultChecked")(defaultChecked.asInstanceOf[js.Any])
      if (key != null) __obj.updateDynamic("key")(key.asInstanceOf[js.Any])
      if (ref != null) __obj.updateDynamic("ref")(ref.asInstanceOf[js.Any])
      __obj.asInstanceOf[HTMLProps[T]]
    }
  }
  
  type Key = String | Double
  
  type NativeAnimationEvent = AnimationEvent
  
  trait ReactElement extends StObject {
    
    var key: Key | Null
    
    var props: js.Any
    
    var `type`: String | (ComponentClassP[js.Any & js.Object]) | SFC[js.Any]
  }
  object ReactElement {
    
    inline def apply(
      props: js.Any,
      `type`: String | (ComponentClassP[js.Any & js.Object]) | SFC[js.Any],
      key: Key = null
    ): ReactElement = {
      val __obj = js.Dynamic.literal(props = props.asInstanceOf[js.Any])
      __obj.updateDynamic("type")(`type`.asInstanceOf[js.Any])
      __obj.updateDynamic("key")(if (key != null) key.asInstanceOf[Key].asInstanceOf[js.Any] else null)
      __obj.asInstanceOf[ReactElement]
    }
  }
  
  type ReactNode = js.UndefOr[String | Double | Boolean]
  
  type ReactType[P] = String | ComponentType[P]
  
  type Ref[T] = String | (js.Function1[/* instance */ T | Null, js.Any])
  
  type SFC[P] = StatelessComponent[P]
  
  type SVGAttributes[T] = DOMAttributes[T]
  
  type SVGProps[T] = ClassAttributes[T]
  
  @js.native
  trait StatelessComponent[P] extends StObject {
    
    def apply(props: P & Children): Element | Null = js.native
    def apply(props: P & Children, context: js.Any): Element | Null = js.native
    
    var defaultProps: js.UndefOr[Partial[P]] = js.native
    
    var displayName: js.UndefOr[String] = js.native
  }
  
  object global {
    
    object JSX {
      
      // tslint:disable-next-line:no-empty-interface
      type Element = japgolly.scalajs.react.facade.React.Element
      
      trait ElementAttributesProperty extends StObject
      
      trait ElementChildrenAttribute extends StObject
      
      trait ElementClass
        extends StObject
           with Component[js.Any, js.Object] {
        
        def render(): Node
      }
      object ElementClass {
        
        inline def apply(render: CallbackTo[Node]): ElementClass = {
          val __obj = js.Dynamic.literal(render = render.toJsFn)
          __obj.asInstanceOf[ElementClass]
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
      }
    }
  }
}
