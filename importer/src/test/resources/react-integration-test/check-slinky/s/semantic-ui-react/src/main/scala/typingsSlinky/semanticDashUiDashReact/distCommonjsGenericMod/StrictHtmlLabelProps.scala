package typingsSlinky.semanticDashUiDashReact.distCommonjsGenericMod

import slinky.core.TagMod
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@js.native
trait StrictHtmlLabelProps extends js.Object {
  var children: js.UndefOr[TagMod[Any]] = js.native
}

object StrictHtmlLabelProps {
  @scala.inline
  def apply(children: TagMod[Any] = null): StrictHtmlLabelProps = {
    val __obj = js.Dynamic.literal()
    if (children != null) __obj.updateDynamic("children")(children.asInstanceOf[js.Any])
    __obj.asInstanceOf[StrictHtmlLabelProps]
  }
}

