package typings.semanticUiReact.mod.dist.commonjs.generic

import typings.react.mod.ReactNode
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

trait StrictHtmlSpanProps extends js.Object {
  var children: js.UndefOr[ReactNode] = js.undefined
}

object StrictHtmlSpanProps {
  @scala.inline
  def apply(children: ReactNode = null): StrictHtmlSpanProps = {
    val __obj = js.Dynamic.literal()
    if (children != null) __obj.updateDynamic("children")(children.asInstanceOf[js.Any])
    __obj.asInstanceOf[StrictHtmlSpanProps]
  }
}

