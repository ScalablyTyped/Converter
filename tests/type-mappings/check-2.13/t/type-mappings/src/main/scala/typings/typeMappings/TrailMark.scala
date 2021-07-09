package typings.typeMappings

import typings.typeMappings.typeMappingsStrings.trail
import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

@js.native
trait TrailMark
  extends StObject
     with Mark {
  
  var `type`: trail = js.native
}
object TrailMark {
  
  @scala.inline
  def apply(): TrailMark = {
    val __obj = js.Dynamic.literal()
    __obj.updateDynamic("type")("trail")
    __obj.asInstanceOf[TrailMark]
  }
  
  @scala.inline
  implicit class TrailMarkMutableBuilder[Self <: TrailMark] (val x: Self) extends AnyVal {
    
    @scala.inline
    def setType(value: trail): Self = StObject.set(x, "type", value.asInstanceOf[js.Any])
  }
}
