package typings.typeMappings

import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

trait TextMark extends StObject {
  
  var `type`: "text"
}
object TextMark {
  
  inline def apply(): TextMark = {
    val __obj = js.Dynamic.literal()
    __obj.updateDynamic("type")("text")
    __obj.asInstanceOf[TextMark]
  }
  
  @scala.inline
  implicit open class MutableBuilder[Self <: TextMark] (val x: Self) extends AnyVal {
    
    inline def setType(value: "text"): Self = StObject.set(x, "type", value.asInstanceOf[js.Any])
  }
}
