package typingsSlinky.reactDashContextmenu.components

import org.scalablytyped.runtime.StringDictionary
import org.scalajs.dom.raw.HTMLElement
import slinky.core.BuildingComponent
import slinky.core.ExternalComponentWithAttributesWithRefType
import slinky.web.SyntheticMouseEvent
import slinky.web.html.`*`.tag
import typingsSlinky.reactDashContextmenu.reactDashContextmenuMod.ContextMenuProps
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

object ContextMenu
  extends ExternalComponentWithAttributesWithRefType[tag.type, typingsSlinky.reactDashContextmenu.reactDashContextmenuMod.ContextMenu] {
  override val component: String | js.Object = js.constructorOf[typingsSlinky.reactDashContextmenu.reactDashContextmenuMod.ContextMenu].asInstanceOf[String | js.Object]
  /* The following DOM/SVG props were specified: className, id */
  def apply(
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
    rtl: js.UndefOr[Boolean] = js.undefined,
    overrides: StringDictionary[js.Any] = null
  ): BuildingComponent[tag.type, typingsSlinky.reactDashContextmenu.reactDashContextmenuMod.ContextMenu] = {
    val __obj = js.Dynamic.literal()
    if (data != null) __obj.updateDynamic("data")(data.asInstanceOf[js.Any])
    if (!js.isUndefined(hideOnLeave)) __obj.updateDynamic("hideOnLeave")(hideOnLeave.asInstanceOf[js.Any])
    if (onHide != null) __obj.updateDynamic("onHide")(js.Any.fromFunction1(onHide))
    if (onMouseLeave != null) __obj.updateDynamic("onMouseLeave")(onMouseLeave.asInstanceOf[js.Any])
    if (onShow != null) __obj.updateDynamic("onShow")(js.Any.fromFunction1(onShow))
    if (!js.isUndefined(rtl)) __obj.updateDynamic("rtl")(rtl.asInstanceOf[js.Any])
    if (overrides != null) js.Dynamic.global.Object.assign(__obj, overrides)
    super.apply(__obj.asInstanceOf[Props])
  }
  type Props = ContextMenuProps
}

