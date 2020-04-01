package typings.typeMappings

import typings.typeMappings.typeMappingsStrings.text
import typings.typeMappings.typeMappingsStrings.trail
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

/* Rewritten from type alias, can be one of: 
  - typings.typeMappings.TextMark
  - typings.typeMappings.TrailMark
*/
trait Mark extends js.Object

object Mark {
  @scala.inline
  def TextMark(`type`: text): Mark = {
    val __obj = js.Dynamic.literal()
    __obj.updateDynamic("type")(`type`.asInstanceOf[js.Any])
    __obj.asInstanceOf[Mark]
  }
  @scala.inline
  def TrailMark(`type`: trail): Mark = {
    val __obj = js.Dynamic.literal()
    __obj.updateDynamic("type")(`type`.asInstanceOf[js.Any])
    __obj.asInstanceOf[Mark]
  }
}

