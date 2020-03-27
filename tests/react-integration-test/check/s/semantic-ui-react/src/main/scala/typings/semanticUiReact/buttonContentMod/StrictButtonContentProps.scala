package typings.semanticUiReact.buttonContentMod

import typings.react.mod.ReactNode
import typings.semanticUiReact.genericMod.SemanticShorthandContent
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@js.native
trait StrictButtonContentProps extends js.Object {
  /** An element type to render as (string or function). */
  var as: js.UndefOr[js.Any] = js.native
  /** Primary content. */
  var children: js.UndefOr[ReactNode] = js.native
  /** Additional classes. */
  var className: js.UndefOr[String] = js.native
  /** Shorthand for primary content. */
  var content: js.UndefOr[SemanticShorthandContent] = js.native
  /** Initially hidden, visible on hover. */
  var hidden: js.UndefOr[Boolean] = js.native
  /** Initially visible, hidden on hover. */
  var visible: js.UndefOr[Boolean] = js.native
}

object StrictButtonContentProps {
  @scala.inline
  def apply(
    as: js.Any = null,
    children: ReactNode = null,
    className: String = null,
    content: SemanticShorthandContent = null,
    hidden: js.UndefOr[Boolean] = js.undefined,
    visible: js.UndefOr[Boolean] = js.undefined
  ): StrictButtonContentProps = {
    val __obj = js.Dynamic.literal()
    if (as != null) __obj.updateDynamic("as")(as.asInstanceOf[js.Any])
    if (children != null) __obj.updateDynamic("children")(children.asInstanceOf[js.Any])
    if (className != null) __obj.updateDynamic("className")(className.asInstanceOf[js.Any])
    if (content != null) __obj.updateDynamic("content")(content.asInstanceOf[js.Any])
    if (!js.isUndefined(hidden)) __obj.updateDynamic("hidden")(hidden.asInstanceOf[js.Any])
    if (!js.isUndefined(visible)) __obj.updateDynamic("visible")(visible.asInstanceOf[js.Any])
    __obj.asInstanceOf[StrictButtonContentProps]
  }
}

