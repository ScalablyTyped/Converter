package typingsLaminar.std

import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

@js.native
trait StyleSheet extends StObject {
  
  var disabled: Boolean = js.native
  
  val href: String | Null = js.native
  
  val parentStyleSheet: org.scalajs.dom.raw.CSSStyleSheet | Null = js.native
  
  val title: String | Null = js.native
  
  val `type`: String = js.native
}
object StyleSheet {
  
  @scala.inline
  def apply(disabled: Boolean, `type`: String): org.scalajs.dom.raw.StyleSheet = {
    val __obj = js.Dynamic.literal(disabled = disabled.asInstanceOf[js.Any], href = null, parentStyleSheet = null, title = null)
    __obj.updateDynamic("type")(`type`.asInstanceOf[js.Any])
    __obj.asInstanceOf[org.scalajs.dom.raw.StyleSheet]
  }
  
  @scala.inline
  implicit class StyleSheetMutableBuilder[Self <: org.scalajs.dom.raw.StyleSheet] (val x: Self) extends AnyVal {
    
    @scala.inline
    def setDisabled(value: Boolean): Self = StObject.set(x, "disabled", value.asInstanceOf[js.Any])
    
    @scala.inline
    def setHref(value: String): Self = StObject.set(x, "href", value.asInstanceOf[js.Any])
    
    @scala.inline
    def setHrefNull: Self = StObject.set(x, "href", null)
    
    @scala.inline
    def setParentStyleSheet(value: org.scalajs.dom.raw.CSSStyleSheet): Self = StObject.set(x, "parentStyleSheet", value.asInstanceOf[js.Any])
    
    @scala.inline
    def setParentStyleSheetNull: Self = StObject.set(x, "parentStyleSheet", null)
    
    @scala.inline
    def setTitle(value: String): Self = StObject.set(x, "title", value.asInstanceOf[js.Any])
    
    @scala.inline
    def setTitleNull: Self = StObject.set(x, "title", null)
    
    @scala.inline
    def setType(value: String): Self = StObject.set(x, "type", value.asInstanceOf[js.Any])
  }
}
