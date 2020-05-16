package typingsJapgolly.stardustUiReactComponentRef

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@js.native
trait AnonInnerRef extends js.Object {
  var children: js.UndefOr[scala.Nothing] = js.native
  var innerRef: js.UndefOr[scala.Nothing] = js.native
}

object AnonInnerRef {
  @scala.inline
  def apply(
    children: js.UndefOr[scala.Nothing] = js.undefined,
    innerRef: js.UndefOr[scala.Nothing] = js.undefined
  ): AnonInnerRef = {
    val __obj = js.Dynamic.literal()
    if (!js.isUndefined(children)) __obj.updateDynamic("children")(children.asInstanceOf[js.Any])
    if (!js.isUndefined(innerRef)) __obj.updateDynamic("innerRef")(innerRef.asInstanceOf[js.Any])
    __obj.asInstanceOf[AnonInnerRef]
  }
  @scala.inline
  implicit class AnonInnerRefOps[Self <: AnonInnerRef] (val x: Self) extends AnyVal {
    @scala.inline
    def duplicate: Self = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x)).asInstanceOf[Self]
    @scala.inline
    def combineWith[Other /* <: js.Any */](other: Other): Self with Other = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x, other.asInstanceOf[js.Any])).asInstanceOf[Self with Other]
    @scala.inline
    def withChildren(children: js.UndefOr[scala.Nothing]): Self = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (!js.isUndefined(children)) ret.updateDynamic("children")(children.asInstanceOf[js.Any])
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withoutChildren: Self = {
        val ret = this.duplicate
        js.special.delete(ret, "children")
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withInnerRef(innerRef: js.UndefOr[scala.Nothing]): Self = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (!js.isUndefined(innerRef)) ret.updateDynamic("innerRef")(innerRef.asInstanceOf[js.Any])
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withoutInnerRef: Self = {
        val ret = this.duplicate
        js.special.delete(ret, "innerRef")
        ret.asInstanceOf[Self]
    }
  }
  
}

