package typings.reactContextmenu.japgolly

import japgolly.scalajs.react.CtorType.ChildArg
import japgolly.scalajs.react.Key
import japgolly.scalajs.react.ReactMouseEventFrom
import japgolly.scalajs.react.ReactTouchEventFrom
import japgolly.scalajs.react.component.JsForwardRef.UnmountedWithRoot
import org.scalajs.dom.raw.HTMLDivElement
import org.scalajs.dom.raw.HTMLElement
import typings.react.reactMod.HTMLAttributes
import typings.reactContextmenu.reactContextmenuMod.MenuItemProps
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

object MenuItem {
  def apply(
    attributes: HTMLAttributes[HTMLDivElement] = null,
    className: String = null,
    data: /* import warning: QualifyReferences.resolveTypeRef many Couldn't qualify Object */ js.Any = null,
    disabled: js.UndefOr[Boolean] = js.undefined,
    divider: js.UndefOr[Boolean] = js.undefined,
    onClick: (js.Function3[
      /* event */ ReactTouchEventFrom[HTMLDivElement] | ReactMouseEventFrom[HTMLDivElement], 
      /* import warning: QualifyReferences.resolveTypeRef many Couldn't qualify Object */ /* data */ js.Any, 
      /* target */ HTMLElement, 
      Unit
    ]) | js.Function = null,
    preventClose: js.UndefOr[Boolean] = js.undefined,
    key: js.UndefOr[Key] = js.undefined
  )(
    children: ChildArg*
  ): UnmountedWithRoot[
    MenuItemProps, 
    typings.reactContextmenu.reactContextmenuMod.MenuItem, 
    Unit, 
    MenuItemProps
  ] = {
    val __obj = js.Dynamic.literal()
  
      if (attributes != null) __obj.updateDynamic("attributes")(attributes)
    if (className != null) __obj.updateDynamic("className")(className)
    if (data != null) __obj.updateDynamic("data")(data)
    if (!js.isUndefined(disabled)) __obj.updateDynamic("disabled")(disabled)
    if (!js.isUndefined(divider)) __obj.updateDynamic("divider")(divider)
    if (onClick != null) __obj.updateDynamic("onClick")(onClick.asInstanceOf[js.Any])
    if (!js.isUndefined(preventClose)) __obj.updateDynamic("preventClose")(preventClose)
    key.foreach(k => __obj.updateDynamic("key")(k.asInstanceOf[js.Any]))
  
    val f = japgolly.scalajs.react.JsForwardRefComponent.force[
  typings.reactContextmenu.reactContextmenuMod.MenuItemProps, 
  japgolly.scalajs.react.Children.Varargs, 
  typings.reactContextmenu.reactContextmenuMod.MenuItem](js.constructorOf[typings.reactContextmenu.reactContextmenuMod.MenuItem])
    f(__obj.asInstanceOf[typings.reactContextmenu.reactContextmenuMod.MenuItemProps])(children: _*)
  }
}

