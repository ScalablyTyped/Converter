package typings.sax.mod

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@js.native
trait BaseTag extends js.Object {
  var isSelfClosing: Boolean = js.native
  var name: String = js.native
}

object BaseTag {
  @scala.inline
  def apply(isSelfClosing: Boolean, name: String): BaseTag = {
    val __obj = js.Dynamic.literal(isSelfClosing = isSelfClosing.asInstanceOf[js.Any], name = name.asInstanceOf[js.Any])
    __obj.asInstanceOf[BaseTag]
  }
}

