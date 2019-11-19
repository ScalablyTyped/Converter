package typingsJapgolly.semanticUiReact.genericMod

import japgolly.scalajs.react.raw.React.Node
import japgolly.scalajs.react.vdom.VdomNode
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

trait StrictHtmlSpanProps extends js.Object {
  var children: js.UndefOr[Node] = js.undefined
}

object StrictHtmlSpanProps {
  @scala.inline
  def apply(children: VdomNode = null): StrictHtmlSpanProps = {
    val __obj = js.Dynamic.literal()
    if (children != null) __obj.updateDynamic("children")(children.rawNode.asInstanceOf[js.Any])
    __obj.asInstanceOf[StrictHtmlSpanProps]
  }
}

