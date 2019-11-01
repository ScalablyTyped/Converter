package typings.reactDashContextmenu.Slinky

import slinky.core.BuildingComponent
import slinky.core.ExternalComponentWithAttributesWithRefType
import slinky.core.facade.ReactElement
import slinky.web.html.`*`.tag
import typings.react.NativeMouseEvent
import typings.react.reactMod.MouseEvent
import typings.react.reactMod.ReactText
import typings.react.reactMod.TouchEvent
import typings.reactDashContextmenu.reactDashContextmenuMod.SubMenuProps
import typings.std.HTMLDivElement
import typings.std.HTMLElement
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

/* The following DOM/SVG props were specified: className, disabled */
object SubMenu
  extends ExternalComponentWithAttributesWithRefType[tag.type, typings.reactDashContextmenu.reactDashContextmenuMod.SubMenu] {
  override val component: String | js.Object = js.constructorOf[typings.reactDashContextmenu.reactDashContextmenuMod.SubMenu].asInstanceOf[String | js.Object]
  def apply(
    title: ReactElement | ReactText,
    hoverDelay: Int | Double = null,
    onClick: (js.Function3[
      /* event */ TouchEvent[HTMLDivElement] | (MouseEvent[HTMLDivElement, NativeMouseEvent]), 
      /* import warning: QualifyReferences.resolveTypeRef many Couldn't qualify Object */ /* data */ js.Any, 
      /* target */ HTMLElement, 
      Unit
    ]) | js.Function = null,
    preventCloseOnClick: js.UndefOr[Boolean] = js.undefined,
    rtl: js.UndefOr[Boolean] = js.undefined
  ): BuildingComponent[tag.type, typings.reactDashContextmenu.reactDashContextmenuMod.SubMenu] = {
    val __obj = js.Dynamic.literal(title = title.asInstanceOf[js.Any])
    if (hoverDelay != null) __obj.updateDynamic("hoverDelay")(hoverDelay.asInstanceOf[js.Any])
    if (onClick != null) __obj.updateDynamic("onClick")(onClick.asInstanceOf[js.Any])
    if (!js.isUndefined(preventCloseOnClick)) __obj.updateDynamic("preventCloseOnClick")(preventCloseOnClick)
    if (!js.isUndefined(rtl)) __obj.updateDynamic("rtl")(rtl)
    super.apply(__obj.asInstanceOf[Props])
  }
  type Props = SubMenuProps
}

