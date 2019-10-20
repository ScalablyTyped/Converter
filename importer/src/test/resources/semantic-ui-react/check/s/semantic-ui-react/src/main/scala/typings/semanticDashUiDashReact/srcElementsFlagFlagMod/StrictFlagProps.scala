package typings.semanticDashUiDashReact.srcElementsFlagFlagMod

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

trait StrictFlagProps extends js.Object {
  /** An element type to render as (string or function). */
  var as: js.UndefOr[js.Any] = js.undefined
  /** Additional classes. */
  var className: js.UndefOr[String] = js.undefined
  /** Flag name, can use the two digit country code, the full name, or a common alias. */
  var name: FlagNameValues
}

object StrictFlagProps {
  @scala.inline
  def apply(name: FlagNameValues, as: js.Any = null, className: String = null): StrictFlagProps = {
    val __obj = js.Dynamic.literal(name = name)
    if (as != null) __obj.updateDynamic("as")(as)
    if (className != null) __obj.updateDynamic("className")(className)
    __obj.asInstanceOf[StrictFlagProps]
  }
}

