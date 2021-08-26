package typings.typeMappings

import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

trait TextMark extends StObject {
  
  var `type`: /* scala3 limitation: Should be type 'text' */ java.lang.String
}
object TextMark {
  
  inline def apply(): TextMark = {
    val __obj = js.Dynamic.literal()
    __obj.updateDynamic("type")("text")
    __obj.asInstanceOf[TextMark]
  }
  
  extension [Self <: TextMark](x: Self) {
    
    inline def setType(value: "text"): Self = StObject.set(x, "type", value.asInstanceOf[js.Any])
  }
}
