package typings.typeMappings

import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

/* Inlined std.Partial<type-mappings.TypographyStyle> */
@js.native
trait TypographyStyleOptions extends StObject {
  
  var color: js.UndefOr[String] = js.native
  
  var fontFamily: js.UndefOr[String] = js.native
  
  var fontSize: js.UndefOr[String] = js.native
  
  var fontWeight: js.UndefOr[String] = js.native
  
  var letterSpacing: js.UndefOr[String] = js.native
  
  var lineHeight: js.UndefOr[String] = js.native
  
  var textTransform: js.UndefOr[String] = js.native
}
object TypographyStyleOptions {
  
  @scala.inline
  def apply(): TypographyStyleOptions = {
    val __obj = js.Dynamic.literal()
    __obj.asInstanceOf[TypographyStyleOptions]
  }
  
  @scala.inline
  implicit class TypographyStyleOptionsMutableBuilder[Self <: TypographyStyleOptions] (val x: Self) extends AnyVal {
    
    @scala.inline
    def setColor(value: String): Self = StObject.set(x, "color", value.asInstanceOf[js.Any])
    
    @scala.inline
    def setColorUndefined: Self = StObject.set(x, "color", js.undefined)
    
    @scala.inline
    def setFontFamily(value: String): Self = StObject.set(x, "fontFamily", value.asInstanceOf[js.Any])
    
    @scala.inline
    def setFontFamilyUndefined: Self = StObject.set(x, "fontFamily", js.undefined)
    
    @scala.inline
    def setFontSize(value: String): Self = StObject.set(x, "fontSize", value.asInstanceOf[js.Any])
    
    @scala.inline
    def setFontSizeUndefined: Self = StObject.set(x, "fontSize", js.undefined)
    
    @scala.inline
    def setFontWeight(value: String): Self = StObject.set(x, "fontWeight", value.asInstanceOf[js.Any])
    
    @scala.inline
    def setFontWeightUndefined: Self = StObject.set(x, "fontWeight", js.undefined)
    
    @scala.inline
    def setLetterSpacing(value: String): Self = StObject.set(x, "letterSpacing", value.asInstanceOf[js.Any])
    
    @scala.inline
    def setLetterSpacingUndefined: Self = StObject.set(x, "letterSpacing", js.undefined)
    
    @scala.inline
    def setLineHeight(value: String): Self = StObject.set(x, "lineHeight", value.asInstanceOf[js.Any])
    
    @scala.inline
    def setLineHeightUndefined: Self = StObject.set(x, "lineHeight", js.undefined)
    
    @scala.inline
    def setTextTransform(value: String): Self = StObject.set(x, "textTransform", value.asInstanceOf[js.Any])
    
    @scala.inline
    def setTextTransformUndefined: Self = StObject.set(x, "textTransform", js.undefined)
  }
}
