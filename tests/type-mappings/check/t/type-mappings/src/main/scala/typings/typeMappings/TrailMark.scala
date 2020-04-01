package typings.typeMappings

import typings.typeMappings.typeMappingsStrings.trail
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@js.native
trait TrailMark extends Mark {
  var `type`: trail = js.native
}

object TrailMark {
  @scala.inline
  def apply(`type`: trail): TrailMark = {
    val __obj = js.Dynamic.literal()
    __obj.updateDynamic("type")(`type`.asInstanceOf[js.Any])
    __obj.asInstanceOf[TrailMark]
  }
}

