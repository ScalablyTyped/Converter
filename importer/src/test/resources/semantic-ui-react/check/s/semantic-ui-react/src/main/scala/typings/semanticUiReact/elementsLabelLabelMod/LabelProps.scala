package typings.semanticUiReact.elementsLabelLabelMod

import org.scalablytyped.runtime.StringDictionary
import typings.react.HTMLElement
import typings.react.NativeMouseEvent
import typings.react.reactMod.MouseEvent
import typings.react.reactMod.ReactNode
import typings.semanticUiReact.elementsIconIconMod.IconProps
import typings.semanticUiReact.elementsLabelLabelDetailMod.LabelDetailProps
import typings.semanticUiReact.genericMod.SemanticCOLORS
import typings.semanticUiReact.genericMod.SemanticSIZES
import typings.semanticUiReact.genericMod.SemanticShorthandContent
import typings.semanticUiReact.genericMod.SemanticShorthandItem
import typings.semanticUiReact.semanticUiReactStrings.`bottom left`
import typings.semanticUiReact.semanticUiReactStrings.`bottom right`
import typings.semanticUiReact.semanticUiReactStrings.`top left`
import typings.semanticUiReact.semanticUiReactStrings.`top right`
import typings.semanticUiReact.semanticUiReactStrings.above
import typings.semanticUiReact.semanticUiReactStrings.below
import typings.semanticUiReact.semanticUiReactStrings.bottom
import typings.semanticUiReact.semanticUiReactStrings.left
import typings.semanticUiReact.semanticUiReactStrings.right
import typings.semanticUiReact.semanticUiReactStrings.top
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

trait LabelProps
  extends StrictLabelProps
     with /* key */ StringDictionary[js.Any]

object LabelProps {
  @scala.inline
  def apply(
    StringDictionary: /* key */ StringDictionary[js.Any] = null,
    active: js.UndefOr[Boolean] = js.undefined,
    as: js.Any = null,
    attached: top | bottom | (`top right`) | (`top left`) | (`bottom left`) | (`bottom right`) = null,
    basic: js.UndefOr[Boolean] = js.undefined,
    children: ReactNode = null,
    circular: js.UndefOr[Boolean] = js.undefined,
    className: String = null,
    color: SemanticCOLORS = null,
    content: SemanticShorthandContent = null,
    corner: Boolean | left | right = null,
    detail: SemanticShorthandItem[LabelDetailProps] = null,
    empty: js.Any = null,
    floating: js.UndefOr[Boolean] = js.undefined,
    horizontal: js.UndefOr[Boolean] = js.undefined,
    icon: SemanticShorthandItem[IconProps] = null,
    image: js.Any = null,
    onClick: (/* event */ MouseEvent[HTMLElement, NativeMouseEvent], /* data */ LabelProps) => Unit = null,
    onRemove: (/* event */ MouseEvent[HTMLElement, NativeMouseEvent], /* data */ LabelProps) => Unit = null,
    pointing: Boolean | above | below | left | right = null,
    prompt: js.UndefOr[Boolean] = js.undefined,
    removeIcon: SemanticShorthandItem[IconProps] = null,
    ribbon: Boolean | right = null,
    size: SemanticSIZES = null,
    tag: js.UndefOr[Boolean] = js.undefined
  ): LabelProps = {
    val __obj = js.Dynamic.literal()
    js.Dynamic.global.Object.assign(__obj, StringDictionary)
    if (!js.isUndefined(active)) __obj.updateDynamic("active")(active)
    if (as != null) __obj.updateDynamic("as")(as)
    if (attached != null) __obj.updateDynamic("attached")(attached.asInstanceOf[js.Any])
    if (!js.isUndefined(basic)) __obj.updateDynamic("basic")(basic)
    if (children != null) __obj.updateDynamic("children")(children.asInstanceOf[js.Any])
    if (!js.isUndefined(circular)) __obj.updateDynamic("circular")(circular)
    if (className != null) __obj.updateDynamic("className")(className)
    if (color != null) __obj.updateDynamic("color")(color)
    if (content != null) __obj.updateDynamic("content")(content.asInstanceOf[js.Any])
    if (corner != null) __obj.updateDynamic("corner")(corner.asInstanceOf[js.Any])
    if (detail != null) __obj.updateDynamic("detail")(detail.asInstanceOf[js.Any])
    if (empty != null) __obj.updateDynamic("empty")(empty)
    if (!js.isUndefined(floating)) __obj.updateDynamic("floating")(floating)
    if (!js.isUndefined(horizontal)) __obj.updateDynamic("horizontal")(horizontal)
    if (icon != null) __obj.updateDynamic("icon")(icon.asInstanceOf[js.Any])
    if (image != null) __obj.updateDynamic("image")(image)
    if (onClick != null) __obj.updateDynamic("onClick")(js.Any.fromFunction2(onClick))
    if (onRemove != null) __obj.updateDynamic("onRemove")(js.Any.fromFunction2(onRemove))
    if (pointing != null) __obj.updateDynamic("pointing")(pointing.asInstanceOf[js.Any])
    if (!js.isUndefined(prompt)) __obj.updateDynamic("prompt")(prompt)
    if (removeIcon != null) __obj.updateDynamic("removeIcon")(removeIcon.asInstanceOf[js.Any])
    if (ribbon != null) __obj.updateDynamic("ribbon")(ribbon.asInstanceOf[js.Any])
    if (size != null) __obj.updateDynamic("size")(size)
    if (!js.isUndefined(tag)) __obj.updateDynamic("tag")(tag)
    __obj.asInstanceOf[LabelProps]
  }
}

