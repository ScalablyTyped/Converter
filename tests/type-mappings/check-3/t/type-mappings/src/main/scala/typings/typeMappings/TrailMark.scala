package typings.typeMappings

import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

trait TrailMark extends StObject {
  
  var `type`: /* scala3 limitation: Should be type 'trail' */ java.lang.String
}
object TrailMark {
  
  inline def apply(): TrailMark = {
    val __obj = js.Dynamic.literal()
    __obj.updateDynamic("type")("trail")
    __obj.asInstanceOf[TrailMark]
  }
  
  extension [Self <: TrailMark](x: Self) {
    
    inline def setType(value: "trail"): Self = StObject.set(x, "type", value.asInstanceOf[js.Any])
  }
}
