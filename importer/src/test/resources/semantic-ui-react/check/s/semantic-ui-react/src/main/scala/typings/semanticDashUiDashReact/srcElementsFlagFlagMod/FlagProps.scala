package typings.semanticDashUiDashReact.srcElementsFlagFlagMod

import org.scalablytyped.runtime.StringDictionary
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

trait FlagProps
  extends StrictFlagProps
     with /* key */ StringDictionary[js.Any]

object FlagProps {
  @scala.inline
  def apply(
    name: FlagNameValues,
    StringDictionary: /* key */ StringDictionary[js.Any] = null,
    as: js.Any = null,
    className: String = null
  ): FlagProps = {
    val __obj = js.Dynamic.literal(name = name)
    js.Dynamic.global.Object.assign(__obj, StringDictionary)
    if (as != null) __obj.updateDynamic("as")(as)
    if (className != null) __obj.updateDynamic("className")(className)
    __obj.asInstanceOf[FlagProps]
  }
}

