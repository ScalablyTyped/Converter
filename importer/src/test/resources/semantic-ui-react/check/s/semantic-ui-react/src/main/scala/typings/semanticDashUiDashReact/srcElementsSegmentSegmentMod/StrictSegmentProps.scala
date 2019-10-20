package typings.semanticDashUiDashReact.srcElementsSegmentSegmentMod

import typings.react.reactMod.ReactNode
import typings.semanticDashUiDashReact.semanticDashUiDashReactStrings.bottom
import typings.semanticDashUiDashReact.semanticDashUiDashReactStrings.top
import typings.semanticDashUiDashReact.semanticDashUiDashReactStrings.very
import typings.semanticDashUiDashReact.srcGenericMod.SemanticCOLORS
import typings.semanticDashUiDashReact.srcGenericMod.SemanticFLOATS
import typings.semanticDashUiDashReact.srcGenericMod.SemanticShorthandContent
import typings.semanticDashUiDashReact.srcGenericMod.SemanticTEXTALIGNMENTS
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

trait StrictSegmentProps extends js.Object {
  /** An element type to render as (string or function). */
  var as: js.UndefOr[js.Any] = js.undefined
  /** Attach segment to other content, like a header. */
  var attached: js.UndefOr[Boolean | top | bottom] = js.undefined
  /** A basic segment has no special formatting. */
  var basic: js.UndefOr[Boolean] = js.undefined
  /** Primary content. */
  var children: js.UndefOr[ReactNode] = js.undefined
  /** A segment can be circular. */
  var circular: js.UndefOr[Boolean] = js.undefined
  /** Additional classes. */
  var className: js.UndefOr[String] = js.undefined
  /** A segment can clear floated content. */
  var clearing: js.UndefOr[Boolean] = js.undefined
  /** Segment can be colored. */
  var color: js.UndefOr[SemanticCOLORS] = js.undefined
  /** A segment may take up only as much space as is necessary. */
  var compact: js.UndefOr[Boolean] = js.undefined
  /** Shorthand for primary content. */
  var content: js.UndefOr[SemanticShorthandContent] = js.undefined
  /** A segment may show its content is disabled. */
  var disabled: js.UndefOr[Boolean] = js.undefined
  /** Segment content can be floated to the left or right. */
  var floated: js.UndefOr[SemanticFLOATS] = js.undefined
  /** A segment can have its colors inverted for contrast. */
  var inverted: js.UndefOr[Boolean] = js.undefined
  /** A segment may show its content is being loaded. */
  var loading: js.UndefOr[Boolean] = js.undefined
  /** A segment can increase its padding. */
  var padded: js.UndefOr[Boolean | very] = js.undefined
  /** Formatted to look like a pile of pages. */
  var piled: js.UndefOr[Boolean] = js.undefined
  /** A segment can be used to reserve space for conditionally displayed content. */
  var placeholder: js.UndefOr[Boolean] = js.undefined
  /** A segment may be formatted to raise above the page. */
  var raised: js.UndefOr[Boolean] = js.undefined
  /** A segment can be formatted to appear less noticeable. */
  var secondary: js.UndefOr[Boolean] = js.undefined
  /** A segment can have different sizes. */
  var size: js.UndefOr[SegmentSizeProp] = js.undefined
  /** Formatted to show it contains multiple pages. */
  var stacked: js.UndefOr[Boolean] = js.undefined
  /** A segment can be formatted to appear even less noticeable. */
  var tertiary: js.UndefOr[Boolean] = js.undefined
  /** Formats content to be aligned as part of a vertical group. */
  var textAlign: js.UndefOr[SemanticTEXTALIGNMENTS] = js.undefined
  /** Formats content to be aligned vertically. */
  var vertical: js.UndefOr[Boolean] = js.undefined
}

object StrictSegmentProps {
  @scala.inline
  def apply(
    as: js.Any = null,
    attached: Boolean | top | bottom = null,
    basic: js.UndefOr[Boolean] = js.undefined,
    children: ReactNode = null,
    circular: js.UndefOr[Boolean] = js.undefined,
    className: String = null,
    clearing: js.UndefOr[Boolean] = js.undefined,
    color: SemanticCOLORS = null,
    compact: js.UndefOr[Boolean] = js.undefined,
    content: SemanticShorthandContent = null,
    disabled: js.UndefOr[Boolean] = js.undefined,
    floated: SemanticFLOATS = null,
    inverted: js.UndefOr[Boolean] = js.undefined,
    loading: js.UndefOr[Boolean] = js.undefined,
    padded: Boolean | very = null,
    piled: js.UndefOr[Boolean] = js.undefined,
    placeholder: js.UndefOr[Boolean] = js.undefined,
    raised: js.UndefOr[Boolean] = js.undefined,
    secondary: js.UndefOr[Boolean] = js.undefined,
    size: SegmentSizeProp = null,
    stacked: js.UndefOr[Boolean] = js.undefined,
    tertiary: js.UndefOr[Boolean] = js.undefined,
    textAlign: SemanticTEXTALIGNMENTS = null,
    vertical: js.UndefOr[Boolean] = js.undefined
  ): StrictSegmentProps = {
    val __obj = js.Dynamic.literal()
    if (as != null) __obj.updateDynamic("as")(as)
    if (attached != null) __obj.updateDynamic("attached")(attached.asInstanceOf[js.Any])
    if (!js.isUndefined(basic)) __obj.updateDynamic("basic")(basic)
    if (children != null) __obj.updateDynamic("children")(children.asInstanceOf[js.Any])
    if (!js.isUndefined(circular)) __obj.updateDynamic("circular")(circular)
    if (className != null) __obj.updateDynamic("className")(className)
    if (!js.isUndefined(clearing)) __obj.updateDynamic("clearing")(clearing)
    if (color != null) __obj.updateDynamic("color")(color)
    if (!js.isUndefined(compact)) __obj.updateDynamic("compact")(compact)
    if (content != null) __obj.updateDynamic("content")(content.asInstanceOf[js.Any])
    if (!js.isUndefined(disabled)) __obj.updateDynamic("disabled")(disabled)
    if (floated != null) __obj.updateDynamic("floated")(floated)
    if (!js.isUndefined(inverted)) __obj.updateDynamic("inverted")(inverted)
    if (!js.isUndefined(loading)) __obj.updateDynamic("loading")(loading)
    if (padded != null) __obj.updateDynamic("padded")(padded.asInstanceOf[js.Any])
    if (!js.isUndefined(piled)) __obj.updateDynamic("piled")(piled)
    if (!js.isUndefined(placeholder)) __obj.updateDynamic("placeholder")(placeholder)
    if (!js.isUndefined(raised)) __obj.updateDynamic("raised")(raised)
    if (!js.isUndefined(secondary)) __obj.updateDynamic("secondary")(secondary)
    if (size != null) __obj.updateDynamic("size")(size)
    if (!js.isUndefined(stacked)) __obj.updateDynamic("stacked")(stacked)
    if (!js.isUndefined(tertiary)) __obj.updateDynamic("tertiary")(tertiary)
    if (textAlign != null) __obj.updateDynamic("textAlign")(textAlign)
    if (!js.isUndefined(vertical)) __obj.updateDynamic("vertical")(vertical)
    __obj.asInstanceOf[StrictSegmentProps]
  }
}

