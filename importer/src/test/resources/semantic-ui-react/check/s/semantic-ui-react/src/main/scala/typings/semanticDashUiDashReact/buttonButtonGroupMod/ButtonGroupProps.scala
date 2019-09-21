package typings.semanticDashUiDashReact.buttonButtonGroupMod

import org.scalablytyped.runtime.StringDictionary
import typings.react.reactMod.ReactNode
import typings.semanticDashUiDashReact.semanticDashUiDashReactStrings.bottom
import typings.semanticDashUiDashReact.semanticDashUiDashReactStrings.left
import typings.semanticDashUiDashReact.semanticDashUiDashReactStrings.right
import typings.semanticDashUiDashReact.semanticDashUiDashReactStrings.top
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

trait ButtonGroupProps
  extends StrictButtonGroupProps
     with /* key */ StringDictionary[js.Any]

object ButtonGroupProps {
  @scala.inline
  def apply(
    StringDictionary: /* key */ StringDictionary[js.Any] = null,
    as: js.Any = null,
    attached: Boolean | left | right | top | bottom = null,
    basic: js.UndefOr[Boolean] = js.undefined,
    buttons: /* import warning: QualifyReferences.resolveTypeRef many Couldn't qualify SemanticShorthandCollection<ButtonProps> */ js.Any = null,
    children: ReactNode = null,
    className: String = null,
    color: /* import warning: QualifyReferences.resolveTypeRef many Couldn't qualify SemanticCOLORS */ js.Any = null,
    compact: js.UndefOr[Boolean] = js.undefined,
    content: /* import warning: QualifyReferences.resolveTypeRef many Couldn't qualify SemanticShorthandContent */ js.Any = null,
    floated: /* import warning: QualifyReferences.resolveTypeRef many Couldn't qualify SemanticFLOATS */ js.Any = null,
    fluid: js.UndefOr[Boolean] = js.undefined,
    icon: js.UndefOr[Boolean] = js.undefined,
    inverted: js.UndefOr[Boolean] = js.undefined,
    labeled: js.UndefOr[Boolean] = js.undefined,
    negative: js.UndefOr[Boolean] = js.undefined,
    positive: js.UndefOr[Boolean] = js.undefined,
    primary: js.UndefOr[Boolean] = js.undefined,
    secondary: js.UndefOr[Boolean] = js.undefined,
    size: /* import warning: QualifyReferences.resolveTypeRef many Couldn't qualify SemanticSIZES */ js.Any = null,
    toggle: js.UndefOr[Boolean] = js.undefined,
    vertical: js.UndefOr[Boolean] = js.undefined,
    widths: /* import warning: QualifyReferences.resolveTypeRef many Couldn't qualify SemanticWIDTHS */ js.Any = null
  ): ButtonGroupProps = {
    val __obj = js.Dynamic.literal()
    js.Dynamic.global.Object.assign(__obj, StringDictionary)
    if (as != null) __obj.updateDynamic("as")(as)
    if (attached != null) __obj.updateDynamic("attached")(attached.asInstanceOf[js.Any])
    if (!js.isUndefined(basic)) __obj.updateDynamic("basic")(basic)
    if (buttons != null) __obj.updateDynamic("buttons")(buttons)
    if (children != null) __obj.updateDynamic("children")(children.asInstanceOf[js.Any])
    if (className != null) __obj.updateDynamic("className")(className)
    if (color != null) __obj.updateDynamic("color")(color)
    if (!js.isUndefined(compact)) __obj.updateDynamic("compact")(compact)
    if (content != null) __obj.updateDynamic("content")(content)
    if (floated != null) __obj.updateDynamic("floated")(floated)
    if (!js.isUndefined(fluid)) __obj.updateDynamic("fluid")(fluid)
    if (!js.isUndefined(icon)) __obj.updateDynamic("icon")(icon)
    if (!js.isUndefined(inverted)) __obj.updateDynamic("inverted")(inverted)
    if (!js.isUndefined(labeled)) __obj.updateDynamic("labeled")(labeled)
    if (!js.isUndefined(negative)) __obj.updateDynamic("negative")(negative)
    if (!js.isUndefined(positive)) __obj.updateDynamic("positive")(positive)
    if (!js.isUndefined(primary)) __obj.updateDynamic("primary")(primary)
    if (!js.isUndefined(secondary)) __obj.updateDynamic("secondary")(secondary)
    if (size != null) __obj.updateDynamic("size")(size)
    if (!js.isUndefined(toggle)) __obj.updateDynamic("toggle")(toggle)
    if (!js.isUndefined(vertical)) __obj.updateDynamic("vertical")(vertical)
    if (widths != null) __obj.updateDynamic("widths")(widths)
    __obj.asInstanceOf[ButtonGroupProps]
  }
}

