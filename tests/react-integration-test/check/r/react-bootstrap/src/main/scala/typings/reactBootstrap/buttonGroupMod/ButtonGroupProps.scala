package typings.reactBootstrap.buttonGroupMod

import typings.react.mod.AllHTMLAttributes
import typings.react.mod.ClassAttributes
import typings.reactBootstrap.mod.Sizes
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@js.native
trait ButtonGroupProps
  extends AllHTMLAttributes[ButtonGroup]
     with ClassAttributes[ButtonGroup] {
  var block: js.UndefOr[Boolean] = js.native
  var bsSize: js.UndefOr[Sizes] = js.native
  var bsStyle: js.UndefOr[String] = js.native
  var justified: js.UndefOr[Boolean] = js.native
  var vertical: js.UndefOr[Boolean] = js.native
}

object ButtonGroupProps {
  @scala.inline
  def apply(
    AllHTMLAttributes: AllHTMLAttributes[ButtonGroup] = null,
    ClassAttributes: ClassAttributes[ButtonGroup] = null,
    block: js.UndefOr[Boolean] = js.undefined,
    bsSize: Sizes = null,
    bsStyle: String = null,
    justified: js.UndefOr[Boolean] = js.undefined,
    vertical: js.UndefOr[Boolean] = js.undefined
  ): ButtonGroupProps = {
    val __obj = js.Dynamic.literal()
    if (AllHTMLAttributes != null) js.Dynamic.global.Object.assign(__obj, AllHTMLAttributes)
    if (ClassAttributes != null) js.Dynamic.global.Object.assign(__obj, ClassAttributes)
    if (!js.isUndefined(block)) __obj.updateDynamic("block")(block.asInstanceOf[js.Any])
    if (bsSize != null) __obj.updateDynamic("bsSize")(bsSize.asInstanceOf[js.Any])
    if (bsStyle != null) __obj.updateDynamic("bsStyle")(bsStyle.asInstanceOf[js.Any])
    if (!js.isUndefined(justified)) __obj.updateDynamic("justified")(justified.asInstanceOf[js.Any])
    if (!js.isUndefined(vertical)) __obj.updateDynamic("vertical")(vertical.asInstanceOf[js.Any])
    __obj.asInstanceOf[ButtonGroupProps]
  }
  @scala.inline
  implicit class ButtonGroupPropsOps[Self <: ButtonGroupProps] (val x: Self) extends AnyVal {
    @scala.inline
    def duplicate: Self = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x)).asInstanceOf[Self]
    @scala.inline
    def combineWith[Other /* <: js.Any */](other: Other): Self with Other = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x, other.asInstanceOf[js.Any])).asInstanceOf[Self with Other]
    @scala.inline
    def withBlock(block: js.UndefOr[Boolean]): Self = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (!js.isUndefined(block)) ret.updateDynamic("block")(block.asInstanceOf[js.Any])
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withoutBlock: Self = {
        val ret = this.duplicate
        js.special.delete(ret, "block")
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withBsSize(bsSize: Sizes): Self = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (bsSize != null) ret.updateDynamic("bsSize")(bsSize.asInstanceOf[js.Any])
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withoutBsSize: Self = {
        val ret = this.duplicate
        js.special.delete(ret, "bsSize")
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withBsStyle(bsStyle: String): Self = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (bsStyle != null) ret.updateDynamic("bsStyle")(bsStyle.asInstanceOf[js.Any])
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withoutBsStyle: Self = {
        val ret = this.duplicate
        js.special.delete(ret, "bsStyle")
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withJustified(justified: js.UndefOr[Boolean]): Self = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (!js.isUndefined(justified)) ret.updateDynamic("justified")(justified.asInstanceOf[js.Any])
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withoutJustified: Self = {
        val ret = this.duplicate
        js.special.delete(ret, "justified")
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withVertical(vertical: js.UndefOr[Boolean]): Self = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (!js.isUndefined(vertical)) ret.updateDynamic("vertical")(vertical.asInstanceOf[js.Any])
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withoutVertical: Self = {
        val ret = this.duplicate
        js.special.delete(ret, "vertical")
        ret.asInstanceOf[Self]
    }
  }
  
}

