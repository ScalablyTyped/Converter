package typings.semanticUiReact.Slinky

import org.scalablytyped.runtime.StringDictionary
import slinky.core.BuildingComponent
import slinky.core.ExternalComponentWithAttributesWithRefType
import slinky.web.html.`*`.tag
import typings.react.HTMLDivElement
import typings.react.NativeMouseEvent
import typings.react.reactMod.MouseEvent
import typings.semanticUiReact.Anon_MenuItem
import typings.semanticUiReact.modulesTabMod.default
import typings.semanticUiReact.modulesTabTabMod.TabProps
import typings.semanticUiReact.semanticUiReactStrings.left
import typings.semanticUiReact.semanticUiReactStrings.right
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

object Tab
  extends ExternalComponentWithAttributesWithRefType[tag.type, default] {
  override val component: String | js.Object = js.constructorOf[typings.semanticUiReact.modulesTabMod.default].asInstanceOf[String | js.Object]
  def apply(
    StringDictionary: /* key */ StringDictionary[js.Any] = null,
    activeIndex: Double | String = null,
    as: js.Any = null,
    defaultActiveIndex: Double | String = null,
    grid: js.Any = null,
    menu: js.Any = null,
    menuPosition: left | right = null,
    onTabChange: (/* event */ MouseEvent[HTMLDivElement, NativeMouseEvent], /* data */ TabProps) => Unit = null,
    panes: js.Array[Anon_MenuItem] = null,
    renderActiveOnly: js.UndefOr[Boolean] = js.undefined
  ): BuildingComponent[tag.type, default] = {
    val __obj = js.Dynamic.literal()
    js.Dynamic.global.Object.assign(__obj, StringDictionary)
    if (activeIndex != null) __obj.updateDynamic("activeIndex")(activeIndex.asInstanceOf[js.Any])
    if (as != null) __obj.updateDynamic("as")(as)
    if (defaultActiveIndex != null) __obj.updateDynamic("defaultActiveIndex")(defaultActiveIndex.asInstanceOf[js.Any])
    if (grid != null) __obj.updateDynamic("grid")(grid)
    if (menu != null) __obj.updateDynamic("menu")(menu)
    if (menuPosition != null) __obj.updateDynamic("menuPosition")(menuPosition.asInstanceOf[js.Any])
    if (onTabChange != null) __obj.updateDynamic("onTabChange")(js.Any.fromFunction2(onTabChange))
    if (panes != null) __obj.updateDynamic("panes")(panes)
    if (!js.isUndefined(renderActiveOnly)) __obj.updateDynamic("renderActiveOnly")(renderActiveOnly)
    super.apply(__obj.asInstanceOf[Props])
  }
  type Props = TabProps
}

