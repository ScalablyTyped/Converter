package typingsSlinky.semanticDashUiDashReact.srcElementsButtonButtonGroupMod

import slinky.core.TagMod
import typingsSlinky.semanticDashUiDashReact.semanticDashUiDashReactStrings.bottom
import typingsSlinky.semanticDashUiDashReact.semanticDashUiDashReactStrings.left
import typingsSlinky.semanticDashUiDashReact.semanticDashUiDashReactStrings.right
import typingsSlinky.semanticDashUiDashReact.semanticDashUiDashReactStrings.top
import typingsSlinky.semanticDashUiDashReact.srcElementsButtonButtonMod.ButtonProps
import typingsSlinky.semanticDashUiDashReact.srcGenericMod.SemanticCOLORS
import typingsSlinky.semanticDashUiDashReact.srcGenericMod.SemanticFLOATS
import typingsSlinky.semanticDashUiDashReact.srcGenericMod.SemanticSIZES
import typingsSlinky.semanticDashUiDashReact.srcGenericMod.SemanticShorthandCollection
import typingsSlinky.semanticDashUiDashReact.srcGenericMod.SemanticShorthandContent
import typingsSlinky.semanticDashUiDashReact.srcGenericMod.SemanticWIDTHS
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

trait StrictButtonGroupProps extends js.Object {
  /** An element type to render as (string or function). */
  var as: js.UndefOr[js.Any] = js.undefined
  /** Groups can be attached to other content. */
  var attached: js.UndefOr[Boolean | left | right | top | bottom] = js.undefined
  /** Groups can be less pronounced. */
  var basic: js.UndefOr[Boolean] = js.undefined
  /** Array of shorthand Button values. */
  var buttons: js.UndefOr[SemanticShorthandCollection[ButtonProps]] = js.undefined
  /** Primary content. */
  var children: js.UndefOr[TagMod[Any]] = js.undefined
  /** Additional classes. */
  var className: js.UndefOr[String] = js.undefined
  /** Groups can have a shared color. */
  var color: js.UndefOr[SemanticCOLORS] = js.undefined
  /** Groups can reduce their padding to fit into tighter spaces. */
  var compact: js.UndefOr[Boolean] = js.undefined
  /** Shorthand for primary content. */
  var content: js.UndefOr[SemanticShorthandContent] = js.undefined
  /** Groups can be aligned to the left or right of its container. */
  var floated: js.UndefOr[SemanticFLOATS] = js.undefined
  /** Groups can take the width of their container. */
  var fluid: js.UndefOr[Boolean] = js.undefined
  /** Groups can be formatted as icons. */
  var icon: js.UndefOr[Boolean] = js.undefined
  /** Groups can be formatted to appear on dark backgrounds. */
  var inverted: js.UndefOr[Boolean] = js.undefined
  /** Groups can be formatted as labeled icon buttons. */
  var labeled: js.UndefOr[Boolean] = js.undefined
  /** Groups can hint towards a negative consequence. */
  var negative: js.UndefOr[Boolean] = js.undefined
  /** Groups can hint towards a positive consequence. */
  var positive: js.UndefOr[Boolean] = js.undefined
  /** Groups can be formatted to show different levels of emphasis. */
  var primary: js.UndefOr[Boolean] = js.undefined
  /** Groups can be formatted to show different levels of emphasis. */
  var secondary: js.UndefOr[Boolean] = js.undefined
  /** Groups can have different sizes. */
  var size: js.UndefOr[SemanticSIZES] = js.undefined
  /** Groups can be formatted to toggle on and off. */
  var toggle: js.UndefOr[Boolean] = js.undefined
  /** Groups can be formatted to appear vertically. */
  var vertical: js.UndefOr[Boolean] = js.undefined
  /** Groups can have their widths divided evenly. */
  var widths: js.UndefOr[SemanticWIDTHS] = js.undefined
}

object StrictButtonGroupProps {
  @scala.inline
  def apply(
    as: js.Any = null,
    attached: Boolean | left | right | top | bottom = null,
    basic: js.UndefOr[Boolean] = js.undefined,
    buttons: SemanticShorthandCollection[ButtonProps] = null,
    children: TagMod[Any] = null,
    className: String = null,
    color: SemanticCOLORS = null,
    compact: js.UndefOr[Boolean] = js.undefined,
    content: SemanticShorthandContent = null,
    floated: SemanticFLOATS = null,
    fluid: js.UndefOr[Boolean] = js.undefined,
    icon: js.UndefOr[Boolean] = js.undefined,
    inverted: js.UndefOr[Boolean] = js.undefined,
    labeled: js.UndefOr[Boolean] = js.undefined,
    negative: js.UndefOr[Boolean] = js.undefined,
    positive: js.UndefOr[Boolean] = js.undefined,
    primary: js.UndefOr[Boolean] = js.undefined,
    secondary: js.UndefOr[Boolean] = js.undefined,
    size: SemanticSIZES = null,
    toggle: js.UndefOr[Boolean] = js.undefined,
    vertical: js.UndefOr[Boolean] = js.undefined,
    widths: SemanticWIDTHS = null
  ): StrictButtonGroupProps = {
    val __obj = js.Dynamic.literal()
    if (as != null) __obj.updateDynamic("as")(as.asInstanceOf[js.Any])
    if (attached != null) __obj.updateDynamic("attached")(attached.asInstanceOf[js.Any])
    if (!js.isUndefined(basic)) __obj.updateDynamic("basic")(basic.asInstanceOf[js.Any])
    if (buttons != null) __obj.updateDynamic("buttons")(buttons.asInstanceOf[js.Any])
    if (children != null) __obj.updateDynamic("children")(children.asInstanceOf[js.Any])
    if (className != null) __obj.updateDynamic("className")(className.asInstanceOf[js.Any])
    if (color != null) __obj.updateDynamic("color")(color.asInstanceOf[js.Any])
    if (!js.isUndefined(compact)) __obj.updateDynamic("compact")(compact.asInstanceOf[js.Any])
    if (content != null) __obj.updateDynamic("content")(content.asInstanceOf[js.Any])
    if (floated != null) __obj.updateDynamic("floated")(floated.asInstanceOf[js.Any])
    if (!js.isUndefined(fluid)) __obj.updateDynamic("fluid")(fluid.asInstanceOf[js.Any])
    if (!js.isUndefined(icon)) __obj.updateDynamic("icon")(icon.asInstanceOf[js.Any])
    if (!js.isUndefined(inverted)) __obj.updateDynamic("inverted")(inverted.asInstanceOf[js.Any])
    if (!js.isUndefined(labeled)) __obj.updateDynamic("labeled")(labeled.asInstanceOf[js.Any])
    if (!js.isUndefined(negative)) __obj.updateDynamic("negative")(negative.asInstanceOf[js.Any])
    if (!js.isUndefined(positive)) __obj.updateDynamic("positive")(positive.asInstanceOf[js.Any])
    if (!js.isUndefined(primary)) __obj.updateDynamic("primary")(primary.asInstanceOf[js.Any])
    if (!js.isUndefined(secondary)) __obj.updateDynamic("secondary")(secondary.asInstanceOf[js.Any])
    if (size != null) __obj.updateDynamic("size")(size.asInstanceOf[js.Any])
    if (!js.isUndefined(toggle)) __obj.updateDynamic("toggle")(toggle.asInstanceOf[js.Any])
    if (!js.isUndefined(vertical)) __obj.updateDynamic("vertical")(vertical.asInstanceOf[js.Any])
    if (widths != null) __obj.updateDynamic("widths")(widths.asInstanceOf[js.Any])
    __obj.asInstanceOf[StrictButtonGroupProps]
  }
}

