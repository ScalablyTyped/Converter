package typingsJapgolly.semanticDashUiDashReact.distCommonjsGenericMod

import japgolly.scalajs.react.raw.React.Node
import japgolly.scalajs.react.vdom.VdomNode
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

trait StrictHtmlLabelProps extends js.Object {
  var children: js.UndefOr[Node] = js.undefined
}

object StrictHtmlLabelProps {
  @scala.inline
  def apply(children: VdomNode = null): StrictHtmlLabelProps = {
    val __obj = js.Dynamic.literal()
    if (children != null) __obj.updateDynamic("children")(children.rawNode.asInstanceOf[js.Any])
    __obj.asInstanceOf[StrictHtmlLabelProps]
  }
}

