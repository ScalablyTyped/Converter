package typings.reactDashContextmenu.Slinky

import org.scalajs.dom.raw.Event
import org.scalajs.dom.raw.HTMLElement
import slinky.core.BuildingComponent
import slinky.core.ExternalComponentWithAttributesWithRefType
import slinky.web.html.`*`.tag
import typings.react.reactMod.MouseEvent
import typings.reactDashContextmenu.reactDashContextmenuMod.ContextMenuProps
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

/* The following DOM/SVG props were specified: className, id */
object ContextMenu
  extends ExternalComponentWithAttributesWithRefType[tag.type, typings.reactDashContextmenu.reactDashContextmenuMod.ContextMenu] {
  override val component: String | js.Object = js.constructorOf[typings.reactDashContextmenu.reactDashContextmenuMod.ContextMenu].asInstanceOf[String | js.Object]
  def apply(
    data: js.Any = null,
    hideOnLeave: js.UndefOr[Boolean] = js.undefined,
    onHide: /* event */ js.Any => Unit = null,
    onMouseLeave: (js.Function3[
      /* event */ MouseEvent[HTMLElement, Event], 
      /* import warning: QualifyReferences.resolveTypeRef many Couldn't qualify Object */ /* data */ js.Any, 
      /* target */ HTMLElement, 
      Unit
    ]) | js.Function = null,
    onShow: /* event */ js.Any => Unit = null,
    rtl: js.UndefOr[Boolean] = js.undefined
  ): BuildingComponent[tag.type, typings.reactDashContextmenu.reactDashContextmenuMod.ContextMenu] = {
    val __obj = js.Dynamic.literal()
    if (data != null) __obj.updateDynamic("data")(data)
    if (!js.isUndefined(hideOnLeave)) __obj.updateDynamic("hideOnLeave")(hideOnLeave)
    if (onHide != null) __obj.updateDynamic("onHide")(js.Any.fromFunction1(onHide))
    if (onMouseLeave != null) __obj.updateDynamic("onMouseLeave")(onMouseLeave.asInstanceOf[js.Any])
    if (onShow != null) __obj.updateDynamic("onShow")(js.Any.fromFunction1(onShow))
    if (!js.isUndefined(rtl)) __obj.updateDynamic("rtl")(rtl)
    super.apply(__obj.asInstanceOf[Props])
  }
  type Props = ContextMenuProps
}

