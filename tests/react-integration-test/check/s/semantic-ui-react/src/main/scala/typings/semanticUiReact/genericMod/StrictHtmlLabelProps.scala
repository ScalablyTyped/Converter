package typings.semanticUiReact.genericMod

import typings.react.mod.ReactNode
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@js.native
trait StrictHtmlLabelProps extends js.Object {
  var children: js.UndefOr[ReactNode] = js.native
}

object StrictHtmlLabelProps {
  @scala.inline
  def apply(children: ReactNode = null): StrictHtmlLabelProps = {
    val __obj = js.Dynamic.literal()
    if (children != null) __obj.updateDynamic("children")(children.asInstanceOf[js.Any])
    __obj.asInstanceOf[StrictHtmlLabelProps]
  }
  @scala.inline
  implicit class StrictHtmlLabelPropsOps[Self <: StrictHtmlLabelProps] (val x: Self) extends AnyVal {
    @scala.inline
    def duplicate: Self = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x)).asInstanceOf[Self]
    @scala.inline
    def combineWith[Other /* <: js.Any */](other: Other): Self with Other = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x, other.asInstanceOf[js.Any])).asInstanceOf[Self with Other]
    @scala.inline
    def withChildren(children: ReactNode): Self = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (children != null) ret.updateDynamic("children")(children.asInstanceOf[js.Any])
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

