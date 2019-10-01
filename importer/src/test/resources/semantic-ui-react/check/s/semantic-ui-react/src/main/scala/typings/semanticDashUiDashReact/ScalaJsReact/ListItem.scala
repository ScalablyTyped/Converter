package typings.semanticDashUiDashReact.ScalaJsReact

import japgolly.scalajs.react.Callback
import japgolly.scalajs.react.CtorType.ChildArg
import japgolly.scalajs.react.ReactMouseEventFrom
import japgolly.scalajs.react.component.JsForwardRef.UnmountedWithRoot
import org.scalablytyped.runtime.StringDictionary
import org.scalajs.dom.raw.HTMLAnchorElement
import typings.semanticDashUiDashReact.srcElementsImageImageMod.ImageProps
import typings.semanticDashUiDashReact.srcElementsListListContentMod.ListContentProps
import typings.semanticDashUiDashReact.srcElementsListListDescriptionMod.ListDescriptionProps
import typings.semanticDashUiDashReact.srcElementsListListHeaderMod.ListHeaderProps
import typings.semanticDashUiDashReact.srcElementsListListIconMod.ListIconProps
import typings.semanticDashUiDashReact.srcElementsListListItemMod.ListItemProps
import typings.semanticDashUiDashReact.srcGenericMod.SemanticShorthandItem
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

/* The following DOM/SVG props were specified: children, className, disabled */
object ListItem {
  def apply(
    StringDictionary: /* key */ StringDictionary[js.Any] = null,
    active: js.UndefOr[Boolean] = js.undefined,
    as: js.Any = null,
    content: SemanticShorthandItem[ListContentProps] = null,
    description: SemanticShorthandItem[ListDescriptionProps] = null,
    header: SemanticShorthandItem[ListHeaderProps] = null,
    icon: SemanticShorthandItem[ListIconProps] = null,
    image: SemanticShorthandItem[ImageProps] = null,
    onClick: (/* event */ ReactMouseEventFrom[HTMLAnchorElement], /* data */ ListItemProps) => Callback = null,
    value: String = null
  )(
    children: /** Primary content. */
  ChildArg*
  ): UnmountedWithRoot[ListItemProps, js.Object, Unit, ListItemProps] = {
    import japgolly.scalajs.react.Children
    import japgolly.scalajs.react.JsForwardRefComponent
  
    val __obj = js.Dynamic.literal()
  
    type ListItemType = scala.scalajs.js.Object
  
      js.Dynamic.global.Object.assign(__obj, StringDictionary)
    if (!js.isUndefined(active)) __obj.updateDynamic("active")(active)
    if (as != null) __obj.updateDynamic("as")(as)
    if (content != null) __obj.updateDynamic("content")(content.asInstanceOf[js.Any])
    if (description != null) __obj.updateDynamic("description")(description.asInstanceOf[js.Any])
    if (header != null) __obj.updateDynamic("header")(header.asInstanceOf[js.Any])
    if (icon != null) __obj.updateDynamic("icon")(icon.asInstanceOf[js.Any])
    if (image != null) __obj.updateDynamic("image")(image.asInstanceOf[js.Any])
    if (onClick != null) __obj.updateDynamic("onClick")(js.Any.fromFunction2(onClick))
    if (value != null) __obj.updateDynamic("value")(value)
  
    val props = __obj.asInstanceOf[Props]
    val f = JsForwardRefComponent.force[Props, Children.Varargs, ListItemType](js.constructorOf[ListItemType])
  
    f(props)(children: _*)
  }
  type Props = ListItemProps
}

