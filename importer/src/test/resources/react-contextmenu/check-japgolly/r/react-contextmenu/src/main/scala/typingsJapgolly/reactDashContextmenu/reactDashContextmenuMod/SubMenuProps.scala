package typingsJapgolly.reactDashContextmenu.reactDashContextmenuMod

import japgolly.scalajs.react.ReactMouseEventFrom
import japgolly.scalajs.react.ReactTouchEventFrom
import japgolly.scalajs.react.raw.React.Element
import org.scalajs.dom.raw.HTMLDivElement
import org.scalajs.dom.raw.HTMLElement
import typingsJapgolly.react.reactMod.ReactText
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

trait SubMenuProps extends js.Object {
  var className: js.UndefOr[String] = js.undefined
  var disabled: js.UndefOr[Boolean] = js.undefined
  var hoverDelay: js.UndefOr[Double] = js.undefined
  var onClick: js.UndefOr[
    (js.Function3[
      /* event */ ReactTouchEventFrom[HTMLDivElement] | ReactMouseEventFrom[HTMLDivElement], 
      /* import warning: QualifyReferences.resolveTypeRef many Couldn't qualify Object */ /* data */ js.Any, 
      /* target */ HTMLElement, 
      Unit
    ]) | js.Function
  ] = js.undefined
  var preventCloseOnClick: js.UndefOr[Boolean] = js.undefined
  var rtl: js.UndefOr[Boolean] = js.undefined
  var title: Element | ReactText
}

object SubMenuProps {
  @scala.inline
  def apply(
    title: Element | ReactText,
    className: String = null,
    disabled: js.UndefOr[Boolean] = js.undefined,
    hoverDelay: Int | Double = null,
    onClick: (js.Function3[
      /* event */ ReactTouchEventFrom[HTMLDivElement] | ReactMouseEventFrom[HTMLDivElement], 
      /* import warning: QualifyReferences.resolveTypeRef many Couldn't qualify Object */ /* data */ js.Any, 
      /* target */ HTMLElement, 
      Unit
    ]) | js.Function = null,
    preventCloseOnClick: js.UndefOr[Boolean] = js.undefined,
    rtl: js.UndefOr[Boolean] = js.undefined
  ): SubMenuProps = {
    val __obj = js.Dynamic.literal(title = title.asInstanceOf[js.Any])
    if (className != null) __obj.updateDynamic("className")(className.asInstanceOf[js.Any])
    if (!js.isUndefined(disabled)) __obj.updateDynamic("disabled")(disabled.asInstanceOf[js.Any])
    if (hoverDelay != null) __obj.updateDynamic("hoverDelay")(hoverDelay.asInstanceOf[js.Any])
    if (onClick != null) __obj.updateDynamic("onClick")(onClick.asInstanceOf[js.Any])
    if (!js.isUndefined(preventCloseOnClick)) __obj.updateDynamic("preventCloseOnClick")(preventCloseOnClick.asInstanceOf[js.Any])
    if (!js.isUndefined(rtl)) __obj.updateDynamic("rtl")(rtl.asInstanceOf[js.Any])
    __obj.asInstanceOf[SubMenuProps]
  }
}

