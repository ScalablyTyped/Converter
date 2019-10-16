package typings.semanticUiReact.ScalaJsReact

import japgolly.scalajs.react.Callback
import japgolly.scalajs.react.CtorType.ChildArg
import japgolly.scalajs.react.ReactMouseEventFrom
import japgolly.scalajs.react.component.Js.MountedWithRawType
import japgolly.scalajs.react.component.Js.RawMounted
import japgolly.scalajs.react.component.Js.UnmountedSimple
import org.scalablytyped.runtime.StringDictionary
import org.scalajs.dom.raw.HTMLAnchorElement
import typings.semanticUiReact.elementsImageImageMod.ImageProps
import typings.semanticUiReact.elementsListListContentMod.ListContentProps
import typings.semanticUiReact.elementsListListDescriptionMod.ListDescriptionProps
import typings.semanticUiReact.elementsListListHeaderMod.ListHeaderProps
import typings.semanticUiReact.elementsListListIconMod.ListIconProps
import typings.semanticUiReact.elementsListListItemMod.ListItemProps
import typings.semanticUiReact.genericMod.SemanticShorthandItem
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

object ListItem {
  def apply(
    StringDictionary: /* key */ StringDictionary[js.Any] = null,
    active: js.UndefOr[Boolean] = js.undefined,
    as: js.Any = null,
    className: String = null,
    content: SemanticShorthandItem[ListContentProps] = null,
    description: SemanticShorthandItem[ListDescriptionProps] = null,
    disabled: js.UndefOr[Boolean] = js.undefined,
    header: SemanticShorthandItem[ListHeaderProps] = null,
    icon: SemanticShorthandItem[ListIconProps] = null,
    image: SemanticShorthandItem[ImageProps] = null,
    onClick: (/* event */ ReactMouseEventFrom[HTMLAnchorElement], /* data */ ListItemProps) => Callback = null,
    value: String = null
  )(
    children: ChildArg*
  ): UnmountedSimple[
    ListItemProps, 
    MountedWithRawType[ListItemProps, js.Object, RawMounted[ListItemProps, js.Object]]
  ] = {
    val __obj = js.Dynamic.literal()
  
      js.Dynamic.global.Object.assign(__obj, StringDictionary)
    if (!js.isUndefined(active)) __obj.updateDynamic("active")(active)
    if (as != null) __obj.updateDynamic("as")(as)
    if (className != null) __obj.updateDynamic("className")(className)
    if (content != null) __obj.updateDynamic("content")(content.asInstanceOf[js.Any])
    if (description != null) __obj.updateDynamic("description")(description.asInstanceOf[js.Any])
    if (!js.isUndefined(disabled)) __obj.updateDynamic("disabled")(disabled)
    if (header != null) __obj.updateDynamic("header")(header.asInstanceOf[js.Any])
    if (icon != null) __obj.updateDynamic("icon")(icon.asInstanceOf[js.Any])
    if (image != null) __obj.updateDynamic("image")(image.asInstanceOf[js.Any])
    if (onClick != null) __obj.updateDynamic("onClick")(js.Any.fromFunction2(((t0: /* event */ japgolly.scalajs.react.ReactMouseEventFrom[org.scalajs.dom.raw.HTMLAnchorElement], t1: /* data */ typings.semanticUiReact.elementsListListItemMod.ListItemProps) => onClick(t0, t1).runNow())))
    if (value != null) __obj.updateDynamic("value")(value)
  
    val f = japgolly.scalajs.react.JsComponent[
  typings.semanticUiReact.elementsListListItemMod.ListItemProps, 
  japgolly.scalajs.react.Children.Varargs, 
  js.Object](typings.semanticUiReact.elementsListListItemMod.default)
    f(__obj.asInstanceOf[typings.semanticUiReact.elementsListListItemMod.ListItemProps])(children: _*)
  }
}

