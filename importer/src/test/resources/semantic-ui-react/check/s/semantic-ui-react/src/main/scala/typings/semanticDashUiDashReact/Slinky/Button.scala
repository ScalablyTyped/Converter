package typings.semanticDashUiDashReact.Slinky

import org.scalablytyped.runtime.StringDictionary
import slinky.core.BuildingComponent
import slinky.core.ExternalComponentWithAttributesWithRefType
import slinky.web.html.`*`.tag
import typings.react.HTMLButtonElement
import typings.react.NativeMouseEvent
import typings.react.reactMod.MouseEvent
import typings.semanticDashUiDashReact.semanticDashUiDashReactStrings.`google plus`
import typings.semanticDashUiDashReact.semanticDashUiDashReactStrings.bottom
import typings.semanticDashUiDashReact.semanticDashUiDashReactStrings.facebook
import typings.semanticDashUiDashReact.semanticDashUiDashReactStrings.fade
import typings.semanticDashUiDashReact.semanticDashUiDashReactStrings.instagram
import typings.semanticDashUiDashReact.semanticDashUiDashReactStrings.left
import typings.semanticDashUiDashReact.semanticDashUiDashReactStrings.linkedin
import typings.semanticDashUiDashReact.semanticDashUiDashReactStrings.right
import typings.semanticDashUiDashReact.semanticDashUiDashReactStrings.top
import typings.semanticDashUiDashReact.semanticDashUiDashReactStrings.twitter
import typings.semanticDashUiDashReact.semanticDashUiDashReactStrings.vertical
import typings.semanticDashUiDashReact.semanticDashUiDashReactStrings.vk
import typings.semanticDashUiDashReact.semanticDashUiDashReactStrings.youtube
import typings.semanticDashUiDashReact.srcElementsButtonButtonMod.ButtonProps
import typings.semanticDashUiDashReact.srcElementsButtonMod.default
import typings.semanticDashUiDashReact.srcElementsIconIconMod.IconProps
import typings.semanticDashUiDashReact.srcElementsLabelLabelMod.LabelProps
import typings.semanticDashUiDashReact.srcGenericMod.SemanticCOLORS
import typings.semanticDashUiDashReact.srcGenericMod.SemanticFLOATS
import typings.semanticDashUiDashReact.srcGenericMod.SemanticSIZES
import typings.semanticDashUiDashReact.srcGenericMod.SemanticShorthandContent
import typings.semanticDashUiDashReact.srcGenericMod.SemanticShorthandItem
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

/* The following DOM/SVG props were specified: children, className, disabled, role */
object Button
  extends ExternalComponentWithAttributesWithRefType[tag.type, default] {
  override val component: String | js.Object = js.constructorOf[typings.semanticDashUiDashReact.srcElementsButtonMod.default].asInstanceOf[String | js.Object]
  type dummy = default
  def apply(
    StringDictionary: /* key */ StringDictionary[js.Any] = null,
    active: js.UndefOr[Boolean] = js.undefined,
    animated: Boolean | fade | vertical = null,
    as: js.Any = null,
    attached: Boolean | left | right | top | bottom = null,
    basic: js.UndefOr[Boolean] = js.undefined,
    circular: js.UndefOr[Boolean] = js.undefined,
    color: SemanticCOLORS | facebook | (`google plus`) | vk | twitter | linkedin | instagram | youtube = null,
    compact: js.UndefOr[Boolean] = js.undefined,
    content: SemanticShorthandContent = null,
    floated: SemanticFLOATS = null,
    fluid: js.UndefOr[Boolean] = js.undefined,
    icon: Boolean | SemanticShorthandItem[IconProps] = null,
    inverted: js.UndefOr[Boolean] = js.undefined,
    label: SemanticShorthandItem[LabelProps] = null,
    labelPosition: right | left = null,
    loading: js.UndefOr[Boolean] = js.undefined,
    negative: js.UndefOr[Boolean] = js.undefined,
    onClick: (/* event */ MouseEvent[HTMLButtonElement, NativeMouseEvent], /* data */ ButtonProps) => Unit = null,
    positive: js.UndefOr[Boolean] = js.undefined,
    primary: js.UndefOr[Boolean] = js.undefined,
    secondary: js.UndefOr[Boolean] = js.undefined,
    size: SemanticSIZES = null,
    tabIndex: Double | String = null,
    toggle: js.UndefOr[Boolean] = js.undefined
  ): BuildingComponent[tag.type, default] = {
    val __obj = js.Dynamic.literal()
    js.Dynamic.global.Object.assign(__obj, StringDictionary)
    if (!js.isUndefined(active)) __obj.updateDynamic("active")(active)
    if (animated != null) __obj.updateDynamic("animated")(animated.asInstanceOf[js.Any])
    if (as != null) __obj.updateDynamic("as")(as)
    if (attached != null) __obj.updateDynamic("attached")(attached.asInstanceOf[js.Any])
    if (!js.isUndefined(basic)) __obj.updateDynamic("basic")(basic)
    if (!js.isUndefined(circular)) __obj.updateDynamic("circular")(circular)
    if (color != null) __obj.updateDynamic("color")(color.asInstanceOf[js.Any])
    if (!js.isUndefined(compact)) __obj.updateDynamic("compact")(compact)
    if (content != null) __obj.updateDynamic("content")(content.asInstanceOf[js.Any])
    if (floated != null) __obj.updateDynamic("floated")(floated)
    if (!js.isUndefined(fluid)) __obj.updateDynamic("fluid")(fluid)
    if (icon != null) __obj.updateDynamic("icon")(icon.asInstanceOf[js.Any])
    if (!js.isUndefined(inverted)) __obj.updateDynamic("inverted")(inverted)
    if (label != null) __obj.updateDynamic("label")(label.asInstanceOf[js.Any])
    if (labelPosition != null) __obj.updateDynamic("labelPosition")(labelPosition.asInstanceOf[js.Any])
    if (!js.isUndefined(loading)) __obj.updateDynamic("loading")(loading)
    if (!js.isUndefined(negative)) __obj.updateDynamic("negative")(negative)
    if (onClick != null) __obj.updateDynamic("onClick")(js.Any.fromFunction2(onClick))
    if (!js.isUndefined(positive)) __obj.updateDynamic("positive")(positive)
    if (!js.isUndefined(primary)) __obj.updateDynamic("primary")(primary)
    if (!js.isUndefined(secondary)) __obj.updateDynamic("secondary")(secondary)
    if (size != null) __obj.updateDynamic("size")(size)
    if (tabIndex != null) __obj.updateDynamic("tabIndex")(tabIndex.asInstanceOf[js.Any])
    if (!js.isUndefined(toggle)) __obj.updateDynamic("toggle")(toggle)
    super.apply(__obj.asInstanceOf[Props])
  }
  type Props = ButtonProps
}

