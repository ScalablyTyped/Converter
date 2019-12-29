package typingsSlinky.semanticDashUiDashReact.distCommonjsGenericMod

import slinky.core.TagMod
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@js.native
trait StrictHtmlSpanProps extends js.Object {
  var children: js.UndefOr[TagMod[Any]] = js.native
}

object StrictHtmlSpanProps {
  @scala.inline
  def apply(children: TagMod[Any] = null): StrictHtmlSpanProps = {
    val __obj = js.Dynamic.literal()
    if (children != null) __obj.updateDynamic("children")(children.asInstanceOf[js.Any])
    __obj.asInstanceOf[StrictHtmlSpanProps]
  }
}

