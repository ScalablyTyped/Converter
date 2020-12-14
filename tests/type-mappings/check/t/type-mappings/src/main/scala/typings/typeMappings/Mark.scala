package typings.typeMappings

import typings.typeMappings.typeMappingsStrings.text
import typings.typeMappings.typeMappingsStrings.trail
import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

/* Rewritten from type alias, can be one of: 
  - typings.typeMappings.TextMark
  - typings.typeMappings.TrailMark
*/
trait Mark extends StObject
object Mark {
  
  @scala.inline
  def TextMark(`type`: text): typings.typeMappings.TextMark = {
    val __obj = js.Dynamic.literal()
    __obj.updateDynamic("type")(`type`.asInstanceOf[js.Any])
    __obj.asInstanceOf[typings.typeMappings.TextMark]
  }
  
  @scala.inline
  def TrailMark(`type`: trail): typings.typeMappings.TrailMark = {
    val __obj = js.Dynamic.literal()
    __obj.updateDynamic("type")(`type`.asInstanceOf[js.Any])
    __obj.asInstanceOf[typings.typeMappings.TrailMark]
  }
}
