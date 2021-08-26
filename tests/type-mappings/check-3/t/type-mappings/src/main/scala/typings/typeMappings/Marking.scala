package typings.typeMappings

import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

/* Inlined std.Record<type-mappings.Mark['type'], string> */
trait Marking extends StObject {
  
  var text: String
  
  var trail: String
}
object Marking {
  
  inline def apply(text: String, trail: String): Marking = {
    val __obj = js.Dynamic.literal(text = text.asInstanceOf[js.Any], trail = trail.asInstanceOf[js.Any])
    __obj.asInstanceOf[Marking]
  }
  
  extension [Self <: Marking](x: Self) {
    
    inline def setText(value: String): Self = StObject.set(x, "text", value.asInstanceOf[js.Any])
    
    inline def setTrail(value: String): Self = StObject.set(x, "trail", value.asInstanceOf[js.Any])
  }
}
