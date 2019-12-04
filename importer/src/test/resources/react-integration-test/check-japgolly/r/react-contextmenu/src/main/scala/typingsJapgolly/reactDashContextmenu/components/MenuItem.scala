package typingsJapgolly.reactDashContextmenu.components

import japgolly.scalajs.react.CtorType.ChildArg
import japgolly.scalajs.react.Key
import japgolly.scalajs.react.ReactMouseEventFrom
import japgolly.scalajs.react.ReactTouchEventFrom
import japgolly.scalajs.react.component.JsForwardRef.UnmountedWithRoot
import org.scalablytyped.runtime.StringDictionary
import org.scalajs.dom.raw.HTMLDivElement
import org.scalajs.dom.raw.HTMLElement
import typingsJapgolly.react.reactMod.HTMLAttributes
import typingsJapgolly.reactDashContextmenu.reactDashContextmenuMod.MenuItemProps
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

object MenuItem {
  def apply(
    attributes: HTMLAttributes[HTMLDivElement] = null,
    className: String = null,
    data: /* import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify Object */ js.Any = null,
    disabled: js.UndefOr[Boolean] = js.undefined,
    divider: js.UndefOr[Boolean] = js.undefined,
    onClick: (js.Function3[
      /* event */ ReactTouchEventFrom[HTMLDivElement] | ReactMouseEventFrom[HTMLDivElement], 
      /* import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify Object */ /* data */ js.Any, 
      /* target */ HTMLElement, 
      Unit
    ]) | js.Function = null,
    preventClose: js.UndefOr[Boolean] = js.undefined,
    key: js.UndefOr[Key] = js.undefined,
    overrides: StringDictionary[js.Any] = null
  )(
    children: ChildArg*
  ): UnmountedWithRoot[
    MenuItemProps, 
    typingsJapgolly.reactDashContextmenu.reactDashContextmenuMod.MenuItem, 
    Unit, 
    MenuItemProps
  ] = {
    val __obj = js.Dynamic.literal()
  
      if (attributes != null) __obj.updateDynamic("attributes")(attributes.asInstanceOf[js.Any])
    if (className != null) __obj.updateDynamic("className")(className.asInstanceOf[js.Any])
    if (data != null) __obj.updateDynamic("data")(data.asInstanceOf[js.Any])
    if (!js.isUndefined(disabled)) __obj.updateDynamic("disabled")(disabled.asInstanceOf[js.Any])
    if (!js.isUndefined(divider)) __obj.updateDynamic("divider")(divider.asInstanceOf[js.Any])
    if (onClick != null) __obj.updateDynamic("onClick")(onClick.asInstanceOf[js.Any])
    if (!js.isUndefined(preventClose)) __obj.updateDynamic("preventClose")(preventClose.asInstanceOf[js.Any])
    key.foreach(k => __obj.updateDynamic("key")(k.asInstanceOf[js.Any]))
    if (overrides != null) js.Dynamic.global.Object.assign(__obj, overrides)
  
    val f = japgolly.scalajs.react.JsForwardRefComponent.force[
  typingsJapgolly.reactDashContextmenu.reactDashContextmenuMod.MenuItemProps, 
  japgolly.scalajs.react.Children.Varargs, 
  typingsJapgolly.reactDashContextmenu.reactDashContextmenuMod.MenuItem](this.componentImport)
    f(__obj.asInstanceOf[typingsJapgolly.reactDashContextmenu.reactDashContextmenuMod.MenuItemProps])(children: _*)
  }
  @JSImport("react-contextmenu", "MenuItem")
  @js.native
  object componentImport extends js.Object
  
}

