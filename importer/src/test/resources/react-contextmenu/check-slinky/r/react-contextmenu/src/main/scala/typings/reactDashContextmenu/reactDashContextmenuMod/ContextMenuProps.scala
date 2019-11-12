package typings.reactDashContextmenu.reactDashContextmenuMod

import org.scalajs.dom.raw.HTMLElement
import slinky.web.SyntheticMouseEvent
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

trait ContextMenuProps extends js.Object {
  var className: js.UndefOr[String] = js.undefined
  var data: js.UndefOr[js.Any] = js.undefined
  var hideOnLeave: js.UndefOr[Boolean] = js.undefined
  var id: String
  var onHide: js.UndefOr[js.Function1[/* event */ js.Any, Unit]] = js.undefined
  var onMouseLeave: js.UndefOr[
    (js.Function3[
      /* event */ SyntheticMouseEvent[HTMLElement], 
      /* import warning: QualifyReferences.resolveTypeRef many Couldn't qualify Object */ /* data */ js.Any, 
      /* target */ HTMLElement, 
      Unit
    ]) | js.Function
  ] = js.undefined
  var onShow: js.UndefOr[js.Function1[/* event */ js.Any, Unit]] = js.undefined
  var rtl: js.UndefOr[Boolean] = js.undefined
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
      /* import warning: QualifyReferences.resolveTypeRef many Couldn't qualify Object */ /* data */ js.Any, 
      /* target */ HTMLElement, 
      Unit
    ]) | js.Function = null,
    onShow: /* event */ js.Any => Unit = null,
    rtl: js.UndefOr[Boolean] = js.undefined
  ): ContextMenuProps = {
    val __obj = js.Dynamic.literal(id = id)
    if (className != null) __obj.updateDynamic("className")(className)
    if (data != null) __obj.updateDynamic("data")(data)
    if (!js.isUndefined(hideOnLeave)) __obj.updateDynamic("hideOnLeave")(hideOnLeave)
    if (onHide != null) __obj.updateDynamic("onHide")(js.Any.fromFunction1(onHide))
    if (onMouseLeave != null) __obj.updateDynamic("onMouseLeave")(onMouseLeave.asInstanceOf[js.Any])
    if (onShow != null) __obj.updateDynamic("onShow")(js.Any.fromFunction1(onShow))
    if (!js.isUndefined(rtl)) __obj.updateDynamic("rtl")(rtl)
    __obj.asInstanceOf[ContextMenuProps]
  }
}

