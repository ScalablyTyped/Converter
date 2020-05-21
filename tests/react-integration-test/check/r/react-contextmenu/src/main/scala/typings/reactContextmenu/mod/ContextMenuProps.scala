package typings.reactContextmenu.mod

import typings.react.mod.MouseEvent
import typings.react.mod.NativeMouseEvent
import typings.std.HTMLElement
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@js.native
trait ContextMenuProps extends js.Object {
  var className: js.UndefOr[String] = js.native
  var data: js.UndefOr[js.Any] = js.native
  var hideOnLeave: js.UndefOr[Boolean] = js.native
  var id: String = js.native
  var onHide: js.UndefOr[js.Function1[/* event */ js.Any, Unit]] = js.native
  var onMouseLeave: js.UndefOr[
    (js.Function3[
      /* event */ MouseEvent[HTMLElement, NativeMouseEvent], 
      /* import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify Object */ /* data */ js.Any, 
      /* target */ HTMLElement, 
      Unit
    ]) | js.Function
  ] = js.native
  var onShow: js.UndefOr[js.Function1[/* event */ js.Any, Unit]] = js.native
  var rtl: js.UndefOr[Boolean] = js.native
}

object ContextMenuProps {
  @scala.inline
  def apply(
    id: String,
    className: String = null,
    data: js.Any = null,
    hideOnLeave: js.UndefOr[Boolean] = js.undefined,
    onHide: /* event */ js.Any => Unit = null,
    onMouseLeave: (js.Function3[
      /* event */ MouseEvent[HTMLElement, NativeMouseEvent], 
      /* import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify Object */ /* data */ js.Any, 
      /* target */ HTMLElement, 
      Unit
    ]) | js.Function = null,
    onShow: /* event */ js.Any => Unit = null,
    rtl: js.UndefOr[Boolean] = js.undefined
  ): ContextMenuProps = {
    val __obj = js.Dynamic.literal(id = id.asInstanceOf[js.Any])
    if (className != null) __obj.updateDynamic("className")(className.asInstanceOf[js.Any])
    if (data != null) __obj.updateDynamic("data")(data.asInstanceOf[js.Any])
    if (!js.isUndefined(hideOnLeave)) __obj.updateDynamic("hideOnLeave")(hideOnLeave.asInstanceOf[js.Any])
    if (onHide != null) __obj.updateDynamic("onHide")(js.Any.fromFunction1(onHide))
    if (onMouseLeave != null) __obj.updateDynamic("onMouseLeave")(onMouseLeave.asInstanceOf[js.Any])
    if (onShow != null) __obj.updateDynamic("onShow")(js.Any.fromFunction1(onShow))
    if (!js.isUndefined(rtl)) __obj.updateDynamic("rtl")(rtl.asInstanceOf[js.Any])
    __obj.asInstanceOf[ContextMenuProps]
  }
  @scala.inline
  implicit class ContextMenuPropsOps[Self <: ContextMenuProps] (val x: Self) extends AnyVal {
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
    def withClassName(className: String): Self = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (className != null) ret.updateDynamic("className")(className.asInstanceOf[js.Any])
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withoutClassName: Self = {
        val ret = this.duplicate
        js.special.delete(ret, "className")
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withData(data: js.Any): Self = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (data != null) ret.updateDynamic("data")(data.asInstanceOf[js.Any])
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withoutData: Self = {
        val ret = this.duplicate
        js.special.delete(ret, "data")
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withHideOnLeave(hideOnLeave: js.UndefOr[Boolean]): Self = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (!js.isUndefined(hideOnLeave)) ret.updateDynamic("hideOnLeave")(hideOnLeave.asInstanceOf[js.Any])
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withoutHideOnLeave: Self = {
        val ret = this.duplicate
        js.special.delete(ret, "hideOnLeave")
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withOnHide(onHide: /* event */ js.Any => Unit): Self = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (onHide != null) ret.updateDynamic("onHide")(js.Any.fromFunction1(onHide))
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withoutOnHide: Self = {
        val ret = this.duplicate
        js.special.delete(ret, "onHide")
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withOnMouseLeaveFunction3(
      onMouseLeave: (/* event */ MouseEvent[HTMLElement, NativeMouseEvent], /* import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify Object */ /* data */ js.Any, /* target */ HTMLElement) => Unit
    ): Self = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        ret.updateDynamic("onMouseLeave")(js.Any.fromFunction3(onMouseLeave))
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withOnMouseLeave(
      onMouseLeave: (js.Function3[
          /* event */ MouseEvent[HTMLElement, NativeMouseEvent], 
          /* import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify Object */ /* data */ js.Any, 
          /* target */ HTMLElement, 
          Unit
        ]) | js.Function
    ): Self = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (onMouseLeave != null) ret.updateDynamic("onMouseLeave")(onMouseLeave.asInstanceOf[js.Any])
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withoutOnMouseLeave: Self = {
        val ret = this.duplicate
        js.special.delete(ret, "onMouseLeave")
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withOnShow(onShow: /* event */ js.Any => Unit): Self = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (onShow != null) ret.updateDynamic("onShow")(js.Any.fromFunction1(onShow))
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withoutOnShow: Self = {
        val ret = this.duplicate
        js.special.delete(ret, "onShow")
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withRtl(rtl: js.UndefOr[Boolean]): Self = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (!js.isUndefined(rtl)) ret.updateDynamic("rtl")(rtl.asInstanceOf[js.Any])
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withoutRtl: Self = {
        val ret = this.duplicate
        js.special.delete(ret, "rtl")
        ret.asInstanceOf[Self]
    }
  }
  
}

