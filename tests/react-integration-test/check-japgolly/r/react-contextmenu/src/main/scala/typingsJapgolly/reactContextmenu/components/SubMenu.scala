package typingsJapgolly.reactContextmenu.components

import japgolly.scalajs.react.Children.Varargs
import japgolly.scalajs.react.CtorType.ChildArg
import japgolly.scalajs.react.JsForwardRefComponent.force
import japgolly.scalajs.react.Key
import japgolly.scalajs.react.ReactMouseEventFrom
import japgolly.scalajs.react.ReactTouchEventFrom
import japgolly.scalajs.react.component.JsForwardRef.UnmountedWithRoot
import japgolly.scalajs.react.raw.React.Element
import org.scalablytyped.runtime.StringDictionary
import org.scalajs.dom.raw.HTMLDivElement
import org.scalajs.dom.raw.HTMLElement
import typingsJapgolly.react.mod.ReactText
import typingsJapgolly.reactContextmenu.mod.SubMenuProps
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

object SubMenu {
  def apply(
    title: Element | ReactText,
    className: String = null,
    disabled: js.UndefOr[Boolean] = js.undefined,
    hoverDelay: js.UndefOr[Double] = js.undefined,
    onClick: (js.Function3[
      /* event */ ReactTouchEventFrom[HTMLDivElement] | ReactMouseEventFrom[HTMLDivElement], 
      /* import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify Object */ /* data */ js.Any, 
      /* target */ HTMLElement, 
      Unit
    ]) | js.Function = null,
    preventCloseOnClick: js.UndefOr[Boolean] = js.undefined,
    rtl: js.UndefOr[Boolean] = js.undefined,
    key: Key = null,
    _overrides: StringDictionary[js.Any] = null
  )(
    children: ChildArg*
  ): UnmountedWithRoot[SubMenuProps, typingsJapgolly.reactContextmenu.mod.SubMenu, Unit, SubMenuProps] = {
    val __obj = js.Dynamic.literal(title = title.asInstanceOf[js.Any])
    if (className != null) __obj.updateDynamic("className")(className.asInstanceOf[js.Any])
    if (!js.isUndefined(disabled)) __obj.updateDynamic("disabled")(disabled.get.asInstanceOf[js.Any])
    if (!js.isUndefined(hoverDelay)) __obj.updateDynamic("hoverDelay")(hoverDelay.get.asInstanceOf[js.Any])
    if (onClick != null) __obj.updateDynamic("onClick")(onClick.asInstanceOf[js.Any])
    if (!js.isUndefined(preventCloseOnClick)) __obj.updateDynamic("preventCloseOnClick")(preventCloseOnClick.get.asInstanceOf[js.Any])
    if (!js.isUndefined(rtl)) __obj.updateDynamic("rtl")(rtl.get.asInstanceOf[js.Any])
    if (key != null) __obj.updateDynamic("key")(key.asInstanceOf[js.Any])
    if (_overrides != null) js.Dynamic.global.Object.assign(__obj, _overrides)
    val f = force[SubMenuProps, Varargs, typingsJapgolly.reactContextmenu.mod.SubMenu](this.componentImport)
    f(__obj.asInstanceOf[SubMenuProps])(children :_*)
  }
  @JSImport("react-contextmenu", "SubMenu")
  @js.native
  object componentImport extends js.Object
  
}

