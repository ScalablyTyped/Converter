package typings.reactContextmenu.mod

import typings.react.mod.HTMLAttributes
import typings.react.mod.ReactType
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@js.native
trait ContextMenuTriggerProps extends js.Object {
  var attributes: js.UndefOr[HTMLAttributes[_]] = js.native
  var collect: js.UndefOr[js.Function1[/* data */ js.Any, _]] = js.native
  var disable: js.UndefOr[Boolean] = js.native
  var holdToDisplay: js.UndefOr[Double] = js.native
  var id: String = js.native
  var renderTag: js.UndefOr[ReactType[_]] = js.native
}

object ContextMenuTriggerProps {
  @scala.inline
  def apply(
    id: String,
    attributes: HTMLAttributes[_] = null,
    collect: /* data */ js.Any => _ = null,
    disable: js.UndefOr[Boolean] = js.undefined,
    holdToDisplay: Int | Double = null,
    renderTag: ReactType[_] = null
  ): ContextMenuTriggerProps = {
    val __obj = js.Dynamic.literal(id = id.asInstanceOf[js.Any])
    if (attributes != null) __obj.updateDynamic("attributes")(attributes.asInstanceOf[js.Any])
    if (collect != null) __obj.updateDynamic("collect")(js.Any.fromFunction1(collect))
    if (!js.isUndefined(disable)) __obj.updateDynamic("disable")(disable.asInstanceOf[js.Any])
    if (holdToDisplay != null) __obj.updateDynamic("holdToDisplay")(holdToDisplay.asInstanceOf[js.Any])
    if (renderTag != null) __obj.updateDynamic("renderTag")(renderTag.asInstanceOf[js.Any])
    __obj.asInstanceOf[ContextMenuTriggerProps]
  }
  @scala.inline
  implicit class ContextMenuTriggerPropsOps[Self <: ContextMenuTriggerProps] (val x: Self) extends AnyVal {
    @scala.inline
    def duplicate: Self = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x)).asInstanceOf[Self]
    @scala.inline
    def combineWith[Other /* <: js.Any */](other: Other): Self with Other = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x, other.asInstanceOf[js.Any])).asInstanceOf[Self with Other]
    @scala.inline
    def withId(id: String): Self = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        ret.updateDynamic("id")(id.asInstanceOf[js.Any])
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withAttributes(attributes: HTMLAttributes[_]): Self = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (attributes != null) ret.updateDynamic("attributes")(attributes.asInstanceOf[js.Any])
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withoutAttributes: Self = {
        val ret = this.duplicate
        js.special.delete(ret, "attributes")
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withCollect(collect: /* data */ js.Any => _): Self = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (collect != null) ret.updateDynamic("collect")(js.Any.fromFunction1(collect))
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withoutCollect: Self = {
        val ret = this.duplicate
        js.special.delete(ret, "collect")
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withDisable(disable: js.UndefOr[Boolean]): Self = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (!js.isUndefined(disable)) ret.updateDynamic("disable")(disable.asInstanceOf[js.Any])
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withoutDisable: Self = {
        val ret = this.duplicate
        js.special.delete(ret, "disable")
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withHoldToDisplay(holdToDisplay: Int | Double): Self = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (holdToDisplay != null) ret.updateDynamic("holdToDisplay")(holdToDisplay.asInstanceOf[js.Any])
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withoutHoldToDisplay: Self = {
        val ret = this.duplicate
        js.special.delete(ret, "holdToDisplay")
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withRenderTag(renderTag: ReactType[_]): Self = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (renderTag != null) ret.updateDynamic("renderTag")(renderTag.asInstanceOf[js.Any])
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withoutRenderTag: Self = {
        val ret = this.duplicate
        js.special.delete(ret, "renderTag")
        ret.asInstanceOf[Self]
    }
  }
  
}

