package typingsSlinky.reactContextmenu.components

import org.scalablytyped.runtime.StringDictionary
import org.scalajs.dom.raw.HTMLDivElement
import org.scalajs.dom.raw.HTMLElement
import slinky.core.BuildingComponent
import slinky.core.ExternalComponentWithAttributesWithRefType
import slinky.core.facade.ReactElement
import slinky.web.SyntheticMouseEvent
import slinky.web.SyntheticTouchEvent
import slinky.web.html.div.tag
import typingsSlinky.react.mod.ReactText
import typingsSlinky.reactContextmenu.mod.SubMenuProps
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

object SubMenu
  extends ExternalComponentWithAttributesWithRefType[tag.type, typingsSlinky.reactContextmenu.mod.SubMenu] {
  @JSImport("react-contextmenu", "SubMenu")
  @js.native
  object componentImport extends js.Object
  
  override val component: String | js.Object = this.componentImport
  /* The following DOM/SVG props were specified: className */
  def apply(
    title: ReactElement | ReactText,
    disabled: js.UndefOr[Boolean] = js.undefined,
    hoverDelay: js.UndefOr[Double] = js.undefined,
    onClick: (js.Function3[
      /* event */ SyntheticTouchEvent[HTMLDivElement] | SyntheticMouseEvent[HTMLDivElement], 
      /* import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify Object */ /* data */ js.Any, 
      /* target */ HTMLElement, 
      Unit
    ]) | js.Function = null,
    preventCloseOnClick: js.UndefOr[Boolean] = js.undefined,
    rtl: js.UndefOr[Boolean] = js.undefined,
    _overrides: StringDictionary[js.Any] = null
  ): BuildingComponent[tag.type, typingsSlinky.reactContextmenu.mod.SubMenu] = {
    val __obj = js.Dynamic.literal(title = title.asInstanceOf[js.Any])
    if (!js.isUndefined(disabled)) __obj.updateDynamic("disabled")(disabled.get.asInstanceOf[js.Any])
    if (!js.isUndefined(hoverDelay)) __obj.updateDynamic("hoverDelay")(hoverDelay.get.asInstanceOf[js.Any])
    if (onClick != null) __obj.updateDynamic("onClick")(onClick.asInstanceOf[js.Any])
    if (!js.isUndefined(preventCloseOnClick)) __obj.updateDynamic("preventCloseOnClick")(preventCloseOnClick.get.asInstanceOf[js.Any])
    if (!js.isUndefined(rtl)) __obj.updateDynamic("rtl")(rtl.get.asInstanceOf[js.Any])
    if (_overrides != null) js.Dynamic.global.Object.assign(__obj, _overrides)
    super.apply(__obj.asInstanceOf[Props])
  }
  type Props = SubMenuProps
}

