package typings.reactDashContextmenu.slinky

import org.scalablytyped.runtime.StringDictionary
import org.scalajs.dom.raw.Event
import org.scalajs.dom.raw.HTMLDivElement
import org.scalajs.dom.raw.HTMLElement
import slinky.core.BuildingComponent
import slinky.core.ExternalComponentWithAttributesWithRefType
import slinky.web.html.`*`.tag
import typings.react.reactMod.HTMLAttributes
import typings.react.reactMod.MouseEvent
import typings.react.reactMod.TouchEvent
import typings.reactDashContextmenu.reactDashContextmenuMod.MenuItemProps
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

/* The following DOM/SVG props were specified: className, disabled */
object MenuItem
  extends ExternalComponentWithAttributesWithRefType[tag.type, typings.reactDashContextmenu.reactDashContextmenuMod.MenuItem] {
  override val component: String | js.Object = js.constructorOf[typings.reactDashContextmenu.reactDashContextmenuMod.MenuItem].asInstanceOf[String | js.Object]
  def apply(
    attributes: HTMLAttributes[HTMLDivElement] = null,
    data: /* import warning: QualifyReferences.resolveTypeRef many Couldn't qualify Object */ js.Any = null,
    divider: js.UndefOr[Boolean] = js.undefined,
    onClick: (js.Function3[
      /* event */ TouchEvent[HTMLDivElement] | (MouseEvent[HTMLDivElement, Event]), 
      /* import warning: QualifyReferences.resolveTypeRef many Couldn't qualify Object */ /* data */ js.Any, 
      /* target */ HTMLElement, 
      Unit
    ]) | js.Function = null,
    preventClose: js.UndefOr[Boolean] = js.undefined,
    overrides: StringDictionary[js.Any] = null
  ): BuildingComponent[tag.type, typings.reactDashContextmenu.reactDashContextmenuMod.MenuItem] = {
    val __obj = js.Dynamic.literal()
    if (attributes != null) __obj.updateDynamic("attributes")(attributes)
    if (data != null) __obj.updateDynamic("data")(data)
    if (!js.isUndefined(divider)) __obj.updateDynamic("divider")(divider)
    if (onClick != null) __obj.updateDynamic("onClick")(onClick.asInstanceOf[js.Any])
    if (!js.isUndefined(preventClose)) __obj.updateDynamic("preventClose")(preventClose)
    if (overrides != null) js.Dynamic.global.Object.assign(__obj, overrides)
    super.apply(__obj.asInstanceOf[Props])
  }
  type Props = MenuItemProps
}

