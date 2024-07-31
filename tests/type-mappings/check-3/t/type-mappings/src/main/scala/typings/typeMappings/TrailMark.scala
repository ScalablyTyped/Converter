package typings.typeMappings

import _root_.typings.typeMappings.typeMappingsStrings.trail
import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

trait TrailMark extends StObject {
  
  var `type`: trail
}
object TrailMark {
  
  inline def apply(): TrailMark = {
    val __obj = js.Dynamic.literal()
    __obj.updateDynamic("type")("trail")
    __obj.asInstanceOf[TrailMark]
  }
  
  @scala.inline
  implicit open class MutableBuilder[Self <: TrailMark] (val x: Self) extends AnyVal {
    
    inline def setType(value: trail): Self = StObject.set(x, "type", value.asInstanceOf[js.Any])
  }
}
