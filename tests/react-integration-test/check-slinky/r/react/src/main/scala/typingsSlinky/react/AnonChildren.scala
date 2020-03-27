package typingsSlinky.react

import slinky.core.TagMod
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@js.native
trait AnonChildren extends js.Object {
  var children: js.UndefOr[TagMod[Any]] = js.native
}

object AnonChildren {
  @scala.inline
  def apply(children: TagMod[Any] = null): AnonChildren = {
    val __obj = js.Dynamic.literal()
    if (children != null) __obj.updateDynamic("children")(children.asInstanceOf[js.Any])
    __obj.asInstanceOf[AnonChildren]
  }
}

