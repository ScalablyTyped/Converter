package typings.sax.mod

import org.scalablytyped.runtime.StringDictionary
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@js.native
trait Tag extends BaseTag {
  var attributes: StringDictionary[String] = js.native
}

object Tag {
  @scala.inline
  def apply(attributes: StringDictionary[String], isSelfClosing: Boolean, name: String): Tag = {
    val __obj = js.Dynamic.literal(attributes = attributes.asInstanceOf[js.Any], isSelfClosing = isSelfClosing.asInstanceOf[js.Any], name = name.asInstanceOf[js.Any])
    __obj.asInstanceOf[Tag]
  }
}

