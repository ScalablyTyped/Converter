package typingsSlinky.react

import org.scalablytyped.runtime.Instantiable1
import org.scalablytyped.runtime.Instantiable2
import slinky.core.ReactComponentClass
import typingsSlinky.react.anon.Children
import typingsSlinky.react.anon.Html
import typingsSlinky.react.reactStrings.foo
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
    
    var onClick: js.UndefOr[Double | (js.Function1[/* x */ String, Unit])] = js.native
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
      
      @scala.inline
      def setOnClickFunction1(value: /* x */ String => Unit): Self = this.set("onClick", js.Any.fromFunction1(value))
      
      @scala.inline
      def setOnClick(value: Double | (js.Function1[/* x */ String, Unit])): Self = this.set("onClick", value.asInstanceOf[js.Any])
      
      @scala.inline
      def deleteOnClick: Self = this.set("onClick", js.undefined)
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
  trait HTMLProps[T] extends AllHTMLAttributes[T] {
    
    var defaultValue: foo = js.native
    
    var onChange: foo = js.native
    
    var `type`: foo = js.native
    
    var value: foo = js.native
  }
  object HTMLProps {
    
    @scala.inline
    def apply[T](defaultValue: foo, onChange: foo, `type`: foo, value: foo): HTMLProps[T] = {
      val __obj = js.Dynamic.literal(defaultValue = defaultValue.asInstanceOf[js.Any], onChange = onChange.asInstanceOf[js.Any], value = value.asInstanceOf[js.Any])
      __obj.updateDynamic("type")(`type`.asInstanceOf[js.Any])
      __obj.asInstanceOf[HTMLProps[T]]
    }
    
    @scala.inline
    implicit class HTMLPropsOps[Self <: HTMLProps[_], T] (val x: Self with HTMLProps[T]) extends AnyVal {
      
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
      def setDefaultValue(value: foo): Self = this.set("defaultValue", value.asInstanceOf[js.Any])
      
      @scala.inline
      def setOnChange(value: foo): Self = this.set("onChange", value.asInstanceOf[js.Any])
      
      @scala.inline
      def setType(value: foo): Self = this.set("type", value.asInstanceOf[js.Any])
      
      @scala.inline
      def setValue(value: foo): Self = this.set("value", value.asInstanceOf[js.Any])
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
  
  type ComponentState = js.Object
  
  type ComponentType[P] = ReactComponentClass[P]
  
  type Key = String | Double
  
  type ReactNode = js.UndefOr[String | Double | Boolean]
  
  type SFC[P] = ReactComponentClass[P]
  
  type SVGAttributes[T] = DOMAttributes[T]
}
