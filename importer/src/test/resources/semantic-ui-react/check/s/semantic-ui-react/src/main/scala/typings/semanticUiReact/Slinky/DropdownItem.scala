package typings.semanticUiReact.Slinky

import org.scalablytyped.runtime.StringDictionary
import slinky.core.BuildingComponent
import slinky.core.ExternalComponentWithAttributesWithRefType
import slinky.web.html.`*`.tag
import typings.react.HTMLDivElement
import typings.react.NativeMouseEvent
import typings.react.reactMod.MouseEvent
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

/* The following DOM/SVG props were specified: children, className, disabled, selected, value */
object DropdownItem
  extends ExternalComponentWithAttributesWithRefType[tag.type, default] {
  override val component: String | js.Object = js.constructorOf[typings.semanticUiReact.modulesDropdownDropdownItemMod.default].asInstanceOf[String | js.Object]
  def apply(
    StringDictionary: /* key */ StringDictionary[js.Any] = null,
    active: js.UndefOr[Boolean] = js.undefined,
    as: js.Any = null,
    content: SemanticShorthandContent = null,
    description: SemanticShorthandItem[HtmlSpanProps] = null,
    flag: SemanticShorthandItem[FlagProps] = null,
    icon: SemanticShorthandItem[IconProps] = null,
    image: SemanticShorthandItem[ImageProps] = null,
    label: SemanticShorthandItem[LabelProps] = null,
    onClick: (/* event */ MouseEvent[HTMLDivElement, NativeMouseEvent], /* data */ DropdownItemProps) => Unit = null,
    text: SemanticShorthandContent = null
  ): BuildingComponent[tag.type, default] = {
    val __obj = js.Dynamic.literal()
    js.Dynamic.global.Object.assign(__obj, StringDictionary)
    if (!js.isUndefined(active)) __obj.updateDynamic("active")(active)
    if (as != null) __obj.updateDynamic("as")(as)
    if (content != null) __obj.updateDynamic("content")(content.asInstanceOf[js.Any])
    if (description != null) __obj.updateDynamic("description")(description.asInstanceOf[js.Any])
    if (flag != null) __obj.updateDynamic("flag")(flag.asInstanceOf[js.Any])
    if (icon != null) __obj.updateDynamic("icon")(icon.asInstanceOf[js.Any])
    if (image != null) __obj.updateDynamic("image")(image.asInstanceOf[js.Any])
    if (label != null) __obj.updateDynamic("label")(label.asInstanceOf[js.Any])
    if (onClick != null) __obj.updateDynamic("onClick")(js.Any.fromFunction2(onClick))
    if (text != null) __obj.updateDynamic("text")(text.asInstanceOf[js.Any])
    super.apply(__obj.asInstanceOf[Props])
  }
  type Props = DropdownItemProps
}

