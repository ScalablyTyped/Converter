package typings.typeMappings

import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

/* Inlined std.Required<std.Pick<type-mappings.CSSProperties, 'fontFamily' | 'fontSize' | 'fontWeight' | 'color'>> & std.Partial<std.Pick<type-mappings.CSSProperties, 'letterSpacing' | 'lineHeight' | 'textTransform'>> */
trait TypographyStyle extends StObject {
  
  var color: String
  
  var fontFamily: String
  
  var fontSize: String
  
  var fontWeight: String
  
  var letterSpacing: js.UndefOr[String] = js.undefined
  
  var lineHeight: js.UndefOr[String] = js.undefined
  
  var textTransform: js.UndefOr[String] = js.undefined
}
object TypographyStyle {
  
  inline def apply(color: String, fontFamily: String, fontSize: String, fontWeight: String): TypographyStyle = {
    val __obj = js.Dynamic.literal(color = color.asInstanceOf[js.Any], fontFamily = fontFamily.asInstanceOf[js.Any], fontSize = fontSize.asInstanceOf[js.Any], fontWeight = fontWeight.asInstanceOf[js.Any])
    __obj.asInstanceOf[TypographyStyle]
  }
  
  extension [Self <: TypographyStyle](x: Self) {
    
    inline def setColor(value: String): Self = StObject.set(x, "color", value.asInstanceOf[js.Any])
    
    inline def setFontFamily(value: String): Self = StObject.set(x, "fontFamily", value.asInstanceOf[js.Any])
    
    inline def setFontSize(value: String): Self = StObject.set(x, "fontSize", value.asInstanceOf[js.Any])
    
    inline def setFontWeight(value: String): Self = StObject.set(x, "fontWeight", value.asInstanceOf[js.Any])
    
    inline def setLetterSpacing(value: String): Self = StObject.set(x, "letterSpacing", value.asInstanceOf[js.Any])
    
    inline def setLetterSpacingUndefined: Self = StObject.set(x, "letterSpacing", js.undefined)
    
    inline def setLineHeight(value: String): Self = StObject.set(x, "lineHeight", value.asInstanceOf[js.Any])
    
    inline def setLineHeightUndefined: Self = StObject.set(x, "lineHeight", js.undefined)
    
    inline def setTextTransform(value: String): Self = StObject.set(x, "textTransform", value.asInstanceOf[js.Any])
    
    inline def setTextTransformUndefined: Self = StObject.set(x, "textTransform", js.undefined)
  }
}
