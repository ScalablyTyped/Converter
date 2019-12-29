package typingsSlinky.reactDashContextmenu.reactDashContextmenuMod

import org.scalajs.dom.raw.HTMLElement
import slinky.web.SyntheticMouseEvent
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
      /* event */ SyntheticMouseEvent[HTMLElement], 
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
      /* event */ SyntheticMouseEvent[HTMLElement], 
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
}

