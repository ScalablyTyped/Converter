package typings.typeMappings

import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

/* Rewritten from type alias, can be one of: 
  - typings.typeMappings.TextMark
  - typings.typeMappings.TrailMark
*/
trait Mark extends StObject
object Mark {
  
  inline def TextMark(): typings.typeMappings.TextMark = {
    val __obj = js.Dynamic.literal()
    __obj.updateDynamic("type")("text")
    __obj.asInstanceOf[typings.typeMappings.TextMark]
  }
  
  inline def TrailMark(): typings.typeMappings.TrailMark = {
    val __obj = js.Dynamic.literal()
    __obj.updateDynamic("type")("trail")
    __obj.asInstanceOf[typings.typeMappings.TrailMark]
  }
}
