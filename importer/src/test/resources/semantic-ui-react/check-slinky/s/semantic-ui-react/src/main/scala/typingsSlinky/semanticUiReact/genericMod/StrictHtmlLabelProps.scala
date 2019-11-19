package typingsSlinky.semanticUiReact.genericMod

import slinky.core.TagMod
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

trait StrictHtmlLabelProps extends js.Object {
  var children: js.UndefOr[TagMod[Any]] = js.undefined
}

object StrictHtmlLabelProps {
  @scala.inline
  def apply(children: TagMod[Any] = null): StrictHtmlLabelProps = {
    val __obj = js.Dynamic.literal()
    if (children != null) __obj.updateDynamic("children")(children.asInstanceOf[js.Any])
    __obj.asInstanceOf[StrictHtmlLabelProps]
  }
}

