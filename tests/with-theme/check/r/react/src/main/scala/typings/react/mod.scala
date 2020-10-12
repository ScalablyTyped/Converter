package typings.react

import typings.react.anon.Html
import typings.react.reactStrings.foo
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
  trait ComponentClass[P] extends js.Object
  
  @js.native
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
  
  type ReactNode = js.Any
  
  type Ref[T] = String
  
  type RefObject[T] = js.Any
  
  type SVGAttributes[T] = DOMAttributes[T]
}
