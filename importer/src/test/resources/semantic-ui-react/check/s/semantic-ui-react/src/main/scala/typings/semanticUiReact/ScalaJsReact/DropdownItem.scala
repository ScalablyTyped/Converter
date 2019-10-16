package typings.semanticUiReact.ScalaJsReact

import japgolly.scalajs.react.Callback
import japgolly.scalajs.react.CtorType.ChildArg
import japgolly.scalajs.react.ReactMouseEventFrom
import japgolly.scalajs.react.component.JsForwardRef.UnmountedWithRoot
import org.scalablytyped.runtime.StringDictionary
import org.scalajs.dom.raw.HTMLDivElement
import typings.semanticUiReact.elementsFlagFlagMod.FlagProps
import typings.semanticUiReact.elementsIconIconMod.IconProps
import typings.semanticUiReact.elementsImageImageMod.ImageProps
import typings.semanticUiReact.elementsLabelLabelMod.LabelProps
import typings.semanticUiReact.genericMod.HtmlSpanProps
import typings.semanticUiReact.genericMod.SemanticShorthandContent
import typings.semanticUiReact.genericMod.SemanticShorthandItem
import typings.semanticUiReact.modulesDropdownDropdownItemMod.DropdownItemProps
import typings.semanticUiReact.modulesDropdownDropdownItemMod.default
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

object DropdownItem {
  def apply(
    StringDictionary: /* key */ StringDictionary[js.Any] = null,
    active: js.UndefOr[Boolean] = js.undefined,
    as: js.Any = null,
    className: String = null,
    content: SemanticShorthandContent = null,
    description: SemanticShorthandItem[HtmlSpanProps] = null,
    disabled: js.UndefOr[Boolean] = js.undefined,
    flag: SemanticShorthandItem[FlagProps] = null,
    icon: SemanticShorthandItem[IconProps] = null,
    image: SemanticShorthandItem[ImageProps] = null,
    label: SemanticShorthandItem[LabelProps] = null,
    onClick: (/* event */ ReactMouseEventFrom[HTMLDivElement], /* data */ DropdownItemProps) => Callback = null,
    selected: js.UndefOr[Boolean] = js.undefined,
    text: SemanticShorthandContent = null,
    value: Boolean | Double | String = null
  )(
    children: ChildArg*
  ): UnmountedWithRoot[DropdownItemProps, default, Unit, DropdownItemProps] = {
    val __obj = js.Dynamic.literal()
  
      js.Dynamic.global.Object.assign(__obj, StringDictionary)
    if (!js.isUndefined(active)) __obj.updateDynamic("active")(active)
    if (as != null) __obj.updateDynamic("as")(as)
    if (className != null) __obj.updateDynamic("className")(className)
    if (content != null) __obj.updateDynamic("content")(content.asInstanceOf[js.Any])
    if (description != null) __obj.updateDynamic("description")(description.asInstanceOf[js.Any])
    if (!js.isUndefined(disabled)) __obj.updateDynamic("disabled")(disabled)
    if (flag != null) __obj.updateDynamic("flag")(flag.asInstanceOf[js.Any])
    if (icon != null) __obj.updateDynamic("icon")(icon.asInstanceOf[js.Any])
    if (image != null) __obj.updateDynamic("image")(image.asInstanceOf[js.Any])
    if (label != null) __obj.updateDynamic("label")(label.asInstanceOf[js.Any])
    if (onClick != null) __obj.updateDynamic("onClick")(js.Any.fromFunction2(((t0: /* event */ japgolly.scalajs.react.ReactMouseEventFrom[org.scalajs.dom.raw.HTMLDivElement], t1: /* data */ typings.semanticUiReact.modulesDropdownDropdownItemMod.DropdownItemProps) => onClick(t0, t1).runNow())))
    if (!js.isUndefined(selected)) __obj.updateDynamic("selected")(selected)
    if (text != null) __obj.updateDynamic("text")(text.asInstanceOf[js.Any])
    if (value != null) __obj.updateDynamic("value")(value.asInstanceOf[js.Any])
  
    val f = japgolly.scalajs.react.JsForwardRefComponent.force[
  typings.semanticUiReact.modulesDropdownDropdownItemMod.DropdownItemProps, 
  japgolly.scalajs.react.Children.Varargs, 
  typings.semanticUiReact.modulesDropdownDropdownItemMod.default](js.constructorOf[typings.semanticUiReact.modulesDropdownDropdownItemMod.default])
    f(__obj.asInstanceOf[typings.semanticUiReact.modulesDropdownDropdownItemMod.DropdownItemProps])(children: _*)
  }
}

