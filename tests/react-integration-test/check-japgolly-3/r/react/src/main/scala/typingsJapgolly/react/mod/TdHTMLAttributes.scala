package typingsJapgolly.react.mod

import _root_.typingsJapgolly.react.reactStrings.baseline
import _root_.typingsJapgolly.react.reactStrings.bottom
import _root_.typingsJapgolly.react.reactStrings.center
import _root_.typingsJapgolly.react.reactStrings.char
import _root_.typingsJapgolly.react.reactStrings.justify
import _root_.typingsJapgolly.react.reactStrings.left
import _root_.typingsJapgolly.react.reactStrings.middle
import _root_.typingsJapgolly.react.reactStrings.right
import _root_.typingsJapgolly.react.reactStrings.top
import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

trait TdHTMLAttributes[T]
  extends StObject
     with HTMLAttributes[T] {
  
  var align: js.UndefOr[left | center | right | justify | char] = js.undefined
  
  var colSpan: js.UndefOr[Double] = js.undefined
  
  var headers: js.UndefOr[String] = js.undefined
  
  var rowSpan: js.UndefOr[Double] = js.undefined
  
  var scope: js.UndefOr[String] = js.undefined
  
  var valign: js.UndefOr[top | middle | bottom | baseline] = js.undefined
}
object TdHTMLAttributes {
  
  inline def apply[T](): TdHTMLAttributes[T] = {
    val __obj = js.Dynamic.literal()
    __obj.asInstanceOf[TdHTMLAttributes[T]]
  }
  
  @scala.inline
  implicit open class MutableBuilder[Self <: TdHTMLAttributes[?], T] (val x: Self & TdHTMLAttributes[T]) extends AnyVal {
    
    inline def setAlign(value: left | center | right | justify | char): Self = StObject.set(x, "align", value.asInstanceOf[js.Any])
    
    inline def setAlignUndefined: Self = StObject.set(x, "align", js.undefined)
    
    inline def setColSpan(value: Double): Self = StObject.set(x, "colSpan", value.asInstanceOf[js.Any])
    
    inline def setColSpanUndefined: Self = StObject.set(x, "colSpan", js.undefined)
    
    inline def setHeaders(value: String): Self = StObject.set(x, "headers", value.asInstanceOf[js.Any])
    
    inline def setHeadersUndefined: Self = StObject.set(x, "headers", js.undefined)
    
    inline def setRowSpan(value: Double): Self = StObject.set(x, "rowSpan", value.asInstanceOf[js.Any])
    
    inline def setRowSpanUndefined: Self = StObject.set(x, "rowSpan", js.undefined)
    
    inline def setScope(value: String): Self = StObject.set(x, "scope", value.asInstanceOf[js.Any])
    
    inline def setScopeUndefined: Self = StObject.set(x, "scope", js.undefined)
    
    inline def setValign(value: top | middle | bottom | baseline): Self = StObject.set(x, "valign", value.asInstanceOf[js.Any])
    
    inline def setValignUndefined: Self = StObject.set(x, "valign", js.undefined)
  }
}
