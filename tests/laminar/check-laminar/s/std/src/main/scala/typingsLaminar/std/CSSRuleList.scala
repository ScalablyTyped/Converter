package typingsLaminar.std

import org.scalablytyped.runtime.NumberDictionary
import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

@js.native
trait CSSRuleList
  extends /* index */ NumberDictionary[org.scalajs.dom.raw.CSSRule] {
  
  def item(index: Double): org.scalajs.dom.raw.CSSRule | Null = js.native
  
  val length: Double = js.native
}
object CSSRuleList {
  
  @scala.inline
  def apply(item: Double => org.scalajs.dom.raw.CSSRule | Null, length: Double): org.scalajs.dom.raw.CSSRuleList = {
    val __obj = js.Dynamic.literal(item = js.Any.fromFunction1(item), length = length.asInstanceOf[js.Any])
    __obj.asInstanceOf[org.scalajs.dom.raw.CSSRuleList]
  }
  
  @scala.inline
  implicit class CSSRuleListMutableBuilder[Self <: org.scalajs.dom.raw.CSSRuleList] (val x: Self) extends AnyVal {
    
    @scala.inline
    def setItem(value: Double => org.scalajs.dom.raw.CSSRule | Null): Self = StObject.set(x, "item", js.Any.fromFunction1(value))
    
    @scala.inline
    def setLength(value: Double): Self = StObject.set(x, "length", value.asInstanceOf[js.Any])
  }
}
