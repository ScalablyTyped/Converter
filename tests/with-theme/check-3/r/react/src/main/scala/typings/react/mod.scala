package typings.react

import typings.react.anon.Html
import typings.react.reactStrings.foo
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
  trait ComponentClass[P] extends StObject
  
  @js.native
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
  
  @js.native
  trait HTMLProps[T]
    extends StObject
       with AllHTMLAttributes[T] {
    
    var defaultValue: foo = js.native
    
    var onChange: foo = js.native
    
    var `type`: foo = js.native
    
    var value: foo = js.native
  }
  object HTMLProps {
    
    @scala.inline
    def apply[T](): HTMLProps[T] = {
      val __obj = js.Dynamic.literal(defaultValue = "foo", onChange = "foo", value = "foo")
      __obj.updateDynamic("type")("foo")
      __obj.asInstanceOf[HTMLProps[T]]
    }
    
    @scala.inline
    implicit class HTMLPropsMutableBuilder[Self <: HTMLProps[?], T] (val x: Self & HTMLProps[T]) extends AnyVal {
      
      @scala.inline
      def setDefaultValue(value: foo): Self = StObject.set(x, "defaultValue", value.asInstanceOf[js.Any])
      
      @scala.inline
      def setOnChange(value: foo): Self = StObject.set(x, "onChange", value.asInstanceOf[js.Any])
      
      @scala.inline
      def setType(value: foo): Self = StObject.set(x, "type", value.asInstanceOf[js.Any])
      
      @scala.inline
      def setValue(value: foo): Self = StObject.set(x, "value", value.asInstanceOf[js.Any])
    }
  }
  
  type ReactNode = js.Any
  
  type Ref[T] = String
  
  type RefObject[T] = js.Any
  
  type SVGAttributes[T] = DOMAttributes[T]
}
