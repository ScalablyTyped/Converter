package typings.semanticDashUiDashReact.ScalaJsReact

import japgolly.scalajs.react.Callback
import japgolly.scalajs.react.ReactMouseEventFrom
import japgolly.scalajs.react.component.JsForwardRef.UnmountedWithRoot
import org.scalablytyped.runtime.StringDictionary
import org.scalajs.dom.raw.HTMLDivElement
import typings.semanticDashUiDashReact.Anon_MenuItem
import typings.semanticDashUiDashReact.semanticDashUiDashReactStrings.left
import typings.semanticDashUiDashReact.semanticDashUiDashReactStrings.right
import typings.semanticDashUiDashReact.srcModulesTabMod.default
import typings.semanticDashUiDashReact.srcModulesTabTabMod.TabProps
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

object Tab {
  def apply(
    StringDictionary: /* key */ StringDictionary[js.Any] = null,
    activeIndex: Double | String = null,
    as: js.Any = null,
    defaultActiveIndex: Double | String = null,
    grid: js.Any = null,
    menu: js.Any = null,
    menuPosition: left | right = null,
    onTabChange: (/* event */ ReactMouseEventFrom[HTMLDivElement], /* data */ TabProps) => Callback = null,
    panes: js.Array[Anon_MenuItem] = null,
    renderActiveOnly: js.UndefOr[Boolean] = js.undefined
  )(
    
  ): UnmountedWithRoot[TabProps, default, Unit, TabProps] = {
    import japgolly.scalajs.react.Children
    import japgolly.scalajs.react.JsForwardRefComponent
  
    val __obj = js.Dynamic.literal()
  
    type TabType = typings.semanticDashUiDashReact.srcModulesTabMod.default
  
      js.Dynamic.global.Object.assign(__obj, StringDictionary)
    if (activeIndex != null) __obj.updateDynamic("activeIndex")(activeIndex.asInstanceOf[js.Any])
    if (as != null) __obj.updateDynamic("as")(as)
    if (defaultActiveIndex != null) __obj.updateDynamic("defaultActiveIndex")(defaultActiveIndex.asInstanceOf[js.Any])
    if (grid != null) __obj.updateDynamic("grid")(grid)
    if (menu != null) __obj.updateDynamic("menu")(menu)
    if (menuPosition != null) __obj.updateDynamic("menuPosition")(menuPosition.asInstanceOf[js.Any])
        if (onTabChange != null) __obj.updateDynamic("onTabChange")(js.Any.fromFunction2(((t0: /* event */ japgolly.scalajs.react.ReactMouseEventFrom[org.scalajs.dom.raw.HTMLDivElement], t1: /* data */ typings.semanticDashUiDashReact.srcModulesTabTabMod.TabProps) => onTabChange(t0, t1).runNow())))
    if (panes != null) __obj.updateDynamic("panes")(panes)
    if (!js.isUndefined(renderActiveOnly)) __obj.updateDynamic("renderActiveOnly")(renderActiveOnly)
  
    val props = __obj.asInstanceOf[Props]
    val f = JsForwardRefComponent.force[Props, Children.None, TabType](js.constructorOf[TabType])
  
    f(props)
  }
  type Props = TabProps
}

