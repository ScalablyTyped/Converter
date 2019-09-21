package typings.semanticDashUiDashReact.buttonButtonContentMod

import typings.react.reactMod.ReactNode
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

trait StrictButtonContentProps extends js.Object {
  /** An element type to render as (string or function). */
  var as: js.UndefOr[js.Any] = js.undefined
  /** Primary content. */
  var children: js.UndefOr[ReactNode] = js.undefined
  /** Additional classes. */
  var className: js.UndefOr[String] = js.undefined
  /** Shorthand for primary content. */
  var content: js.UndefOr[
    /* import warning: QualifyReferences.resolveTypeRef many Couldn't qualify SemanticShorthandContent */ js.Any
  ] = js.undefined
  /** Initially hidden, visible on hover. */
  var hidden: js.UndefOr[Boolean] = js.undefined
  /** Initially visible, hidden on hover. */
  var visible: js.UndefOr[Boolean] = js.undefined
}

object StrictButtonContentProps {
  @scala.inline
  def apply(
    as: js.Any = null,
    children: ReactNode = null,
    className: String = null,
    content: /* import warning: QualifyReferences.resolveTypeRef many Couldn't qualify SemanticShorthandContent */ js.Any = null,
    hidden: js.UndefOr[Boolean] = js.undefined,
    visible: js.UndefOr[Boolean] = js.undefined
  ): StrictButtonContentProps = {
    val __obj = js.Dynamic.literal()
    if (as != null) __obj.updateDynamic("as")(as)
    if (children != null) __obj.updateDynamic("children")(children.asInstanceOf[js.Any])
    if (className != null) __obj.updateDynamic("className")(className)
    if (content != null) __obj.updateDynamic("content")(content)
    if (!js.isUndefined(hidden)) __obj.updateDynamic("hidden")(hidden)
    if (!js.isUndefined(visible)) __obj.updateDynamic("visible")(visible)
    __obj.asInstanceOf[StrictButtonContentProps]
  }
}

