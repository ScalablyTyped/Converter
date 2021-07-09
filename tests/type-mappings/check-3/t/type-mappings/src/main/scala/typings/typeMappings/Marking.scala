package typings.typeMappings

import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

/* Inlined std.Record<type-mappings.Mark['type'], string> */
@js.native
trait Marking extends StObject {
  
  var text: String = js.native
  
  var trail: String = js.native
}
object Marking {
  
  @scala.inline
  def apply(text: String, trail: String): Marking = {
    val __obj = js.Dynamic.literal(text = text.asInstanceOf[js.Any], trail = trail.asInstanceOf[js.Any])
    __obj.asInstanceOf[Marking]
  }
  
  @scala.inline
  implicit class MarkingMutableBuilder[Self <: Marking] (val x: Self) extends AnyVal {
    
    @scala.inline
    def setText(value: String): Self = StObject.set(x, "text", value.asInstanceOf[js.Any])
    
    @scala.inline
    def setTrail(value: String): Self = StObject.set(x, "trail", value.asInstanceOf[js.Any])
  }
}
