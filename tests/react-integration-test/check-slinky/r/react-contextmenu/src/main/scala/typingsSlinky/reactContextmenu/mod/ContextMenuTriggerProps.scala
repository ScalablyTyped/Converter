package typingsSlinky.reactContextmenu.mod

import slinky.core.ReactComponentClass
import typingsSlinky.react.mod.HTMLAttributes
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
  var renderTag: js.UndefOr[ReactComponentClass[_]] = js.native
}

object ContextMenuTriggerProps {
  @scala.inline
  def apply(id: String): ContextMenuTriggerProps = {
    val __obj = js.Dynamic.literal(id = id.asInstanceOf[js.Any])
    __obj.asInstanceOf[ContextMenuTriggerProps]
  }
  @scala.inline
  implicit class ContextMenuTriggerPropsOps[Self <: ContextMenuTriggerProps] (val x: Self) extends AnyVal {
    @scala.inline
    def duplicate: Self = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x)).asInstanceOf[Self]
    @scala.inline
    def combineWith[Other <: js.Any](other: Other): Self with Other = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x, other.asInstanceOf[js.Any])).asInstanceOf[Self with Other]
    @scala.inline
    def withId(value: String): Self = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("id")(value.asInstanceOf[js.Any])
        ret
    }
    @scala.inline
    def withAttributes(value: HTMLAttributes[_]): Self = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("attributes")(value.asInstanceOf[js.Any])
        ret
    }
    @scala.inline
    def withoutAttributes: Self = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("attributes")(js.undefined)
        ret
    }
    @scala.inline
    def withCollect(value: /* data */ js.Any => _): Self = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("collect")(js.Any.fromFunction1(value))
        ret
    }
    @scala.inline
    def withoutCollect: Self = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("collect")(js.undefined)
        ret
    }
    @scala.inline
    def withDisable(value: Boolean): Self = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("disable")(value.asInstanceOf[js.Any])
        ret
    }
    @scala.inline
    def withoutDisable: Self = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("disable")(js.undefined)
        ret
    }
    @scala.inline
    def withHoldToDisplay(value: Double): Self = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("holdToDisplay")(value.asInstanceOf[js.Any])
        ret
    }
    @scala.inline
    def withoutHoldToDisplay: Self = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("holdToDisplay")(js.undefined)
        ret
    }
    @scala.inline
    def withRenderTagFunctionComponent(value: ReactComponentClass[_]): Self = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("renderTag")(value.asInstanceOf[js.Any])
        ret
    }
    @scala.inline
    def withRenderTagComponentClass(value: ReactComponentClass[_]): Self = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("renderTag")(value.asInstanceOf[js.Any])
        ret
    }
    @scala.inline
    def withRenderTag(value: ReactComponentClass[_]): Self = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("renderTag")(value.asInstanceOf[js.Any])
        ret
    }
    @scala.inline
    def withoutRenderTag: Self = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("renderTag")(js.undefined)
        ret
    }
  }
  
}

