package typings.typeMappings

import typings.typeMappings.typeMappingsStrings.text
import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

@js.native
trait TextMark
  extends StObject
     with Mark {
  
  var `type`: text = js.native
}
object TextMark {
  
  @scala.inline
  def apply(): TextMark = {
    val __obj = js.Dynamic.literal()
    __obj.updateDynamic("type")("text")
    __obj.asInstanceOf[TextMark]
  }
  
  @scala.inline
  implicit class TextMarkMutableBuilder[Self <: TextMark] (val x: Self) extends AnyVal {
    
    @scala.inline
    def setType(value: text): Self = StObject.set(x, "type", value.asInstanceOf[js.Any])
  }
}
