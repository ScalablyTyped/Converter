package typingsJapgolly.semanticUiReact.genericMod

import japgolly.scalajs.react.raw.React.Node
import japgolly.scalajs.react.vdom.VdomElement
import japgolly.scalajs.react.vdom.VdomNode
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@js.native
trait StrictHtmlSpanProps extends js.Object {
  var children: js.UndefOr[Node] = js.native
}

object StrictHtmlSpanProps {
  @scala.inline
  def apply(children: VdomNode = null): StrictHtmlSpanProps = {
    val __obj = js.Dynamic.literal()
    if (children != null) __obj.updateDynamic("children")(children.rawNode.asInstanceOf[js.Any])
    __obj.asInstanceOf[StrictHtmlSpanProps]
  }
  @scala.inline
  implicit class StrictHtmlSpanPropsOps[Self <: StrictHtmlSpanProps] (val x: Self) extends AnyVal {
    @scala.inline
    def duplicate: Self = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x)).asInstanceOf[Self]
    @scala.inline
    def combineWith[Other /* <: js.Any */](other: Other): Self with Other = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x, other.asInstanceOf[js.Any])).asInstanceOf[Self with Other]
    @scala.inline
    def withChildrenVdomElement(children: VdomElement): Self = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (children != null) ret.updateDynamic("children")(children.rawElement.asInstanceOf[js.Any])
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withChildren(children: VdomNode): Self = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (children != null) ret.updateDynamic("children")(children.rawNode.asInstanceOf[js.Any])
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withoutChildren: Self = {
        val ret = this.duplicate
        js.special.delete(ret, "children")
        ret.asInstanceOf[Self]
    }
  }
  
}

