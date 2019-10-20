package typings.semanticDashUiDashReact.srcElementsSegmentSegmentGroupMod

import typings.react.reactMod.ReactNode
import typings.semanticDashUiDashReact.srcElementsSegmentSegmentMod.SegmentSizeProp
import typings.semanticDashUiDashReact.srcGenericMod.SemanticShorthandContent
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

trait StrictSegmentGroupProps extends js.Object {
  /** An element type to render as (string or function). */
  var as: js.UndefOr[js.Any] = js.undefined
  /** Primary content. */
  var children: js.UndefOr[ReactNode] = js.undefined
  /** Additional classes. */
  var className: js.UndefOr[String] = js.undefined
  /** A segment may take up only as much space as is necessary. */
  var compact: js.UndefOr[Boolean] = js.undefined
  /** Shorthand for primary content. */
  var content: js.UndefOr[SemanticShorthandContent] = js.undefined
  /** Formats content to be aligned horizontally. */
  var horizontal: js.UndefOr[Boolean] = js.undefined
  /** Formatted to look like a pile of pages. */
  var piled: js.UndefOr[Boolean] = js.undefined
  /** A segment group may be formatted to raise above the page. */
  var raised: js.UndefOr[Boolean] = js.undefined
  /** A segment group can have different sizes. */
  var size: js.UndefOr[SegmentSizeProp] = js.undefined
  /** Formatted to show it contains multiple pages. */
  var stacked: js.UndefOr[Boolean] = js.undefined
}

object StrictSegmentGroupProps {
  @scala.inline
  def apply(
    as: js.Any = null,
    children: ReactNode = null,
    className: String = null,
    compact: js.UndefOr[Boolean] = js.undefined,
    content: SemanticShorthandContent = null,
    horizontal: js.UndefOr[Boolean] = js.undefined,
    piled: js.UndefOr[Boolean] = js.undefined,
    raised: js.UndefOr[Boolean] = js.undefined,
    size: SegmentSizeProp = null,
    stacked: js.UndefOr[Boolean] = js.undefined
  ): StrictSegmentGroupProps = {
    val __obj = js.Dynamic.literal()
    if (as != null) __obj.updateDynamic("as")(as)
    if (children != null) __obj.updateDynamic("children")(children.asInstanceOf[js.Any])
    if (className != null) __obj.updateDynamic("className")(className)
    if (!js.isUndefined(compact)) __obj.updateDynamic("compact")(compact)
    if (content != null) __obj.updateDynamic("content")(content.asInstanceOf[js.Any])
    if (!js.isUndefined(horizontal)) __obj.updateDynamic("horizontal")(horizontal)
    if (!js.isUndefined(piled)) __obj.updateDynamic("piled")(piled)
    if (!js.isUndefined(raised)) __obj.updateDynamic("raised")(raised)
    if (size != null) __obj.updateDynamic("size")(size)
    if (!js.isUndefined(stacked)) __obj.updateDynamic("stacked")(stacked)
    __obj.asInstanceOf[StrictSegmentGroupProps]
  }
}

