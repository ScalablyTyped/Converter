package typings.typeMappings

import typings.typeMappings.typeMappingsStrings.text
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@js.native
trait TextMark extends Mark {
  var `type`: text = js.native
}

object TextMark {
  @scala.inline
  def apply(`type`: text): TextMark = {
    val __obj = js.Dynamic.literal()
    __obj.updateDynamic("type")(`type`.asInstanceOf[js.Any])
    __obj.asInstanceOf[TextMark]
  }
}

