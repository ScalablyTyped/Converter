package typings.typeMappings

import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

@js.native
trait CSSProperties extends StObject {
  
  var color: String = js.native
  
  var fontFamily: String = js.native
  
  var fontSize: String = js.native
  
  var fontWeight: String = js.native
  
  var letterSpacing: String = js.native
  
  var lineHeight: String = js.native
  
  var textTransform: String = js.native
}
object CSSProperties {
  
  @scala.inline
  def apply(
    color: String,
    fontFamily: String,
    fontSize: String,
    fontWeight: String,
    letterSpacing: String,
    lineHeight: String,
    textTransform: String
  ): CSSProperties = {
    val __obj = js.Dynamic.literal(color = color.asInstanceOf[js.Any], fontFamily = fontFamily.asInstanceOf[js.Any], fontSize = fontSize.asInstanceOf[js.Any], fontWeight = fontWeight.asInstanceOf[js.Any], letterSpacing = letterSpacing.asInstanceOf[js.Any], lineHeight = lineHeight.asInstanceOf[js.Any], textTransform = textTransform.asInstanceOf[js.Any])
    __obj.asInstanceOf[CSSProperties]
  }
  
  @scala.inline
  implicit class CSSPropertiesMutableBuilder[Self <: CSSProperties] (val x: Self) extends AnyVal {
    
    @scala.inline
    def setColor(value: String): Self = StObject.set(x, "color", value.asInstanceOf[js.Any])
    
    @scala.inline
    def setFontFamily(value: String): Self = StObject.set(x, "fontFamily", value.asInstanceOf[js.Any])
    
    @scala.inline
    def setFontSize(value: String): Self = StObject.set(x, "fontSize", value.asInstanceOf[js.Any])
    
    @scala.inline
    def setFontWeight(value: String): Self = StObject.set(x, "fontWeight", value.asInstanceOf[js.Any])
    
    @scala.inline
    def setLetterSpacing(value: String): Self = StObject.set(x, "letterSpacing", value.asInstanceOf[js.Any])
    
    @scala.inline
    def setLineHeight(value: String): Self = StObject.set(x, "lineHeight", value.asInstanceOf[js.Any])
    
    @scala.inline
    def setTextTransform(value: String): Self = StObject.set(x, "textTransform", value.asInstanceOf[js.Any])
  }
}
