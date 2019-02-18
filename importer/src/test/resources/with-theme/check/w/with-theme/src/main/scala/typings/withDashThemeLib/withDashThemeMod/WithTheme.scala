package typings
package withDashThemeLib.withDashThemeMod

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

trait WithTheme extends js.Object {
  var innerRef: js.UndefOr[reactLib.ReactNs.Ref[_] | reactLib.ReactNs.RefObject[_]] = js.undefined
  var theme: java.lang.String
}

object WithTheme {
  @scala.inline
  def apply(theme: java.lang.String, innerRef: reactLib.ReactNs.Ref[_] | reactLib.ReactNs.RefObject[_] = null): WithTheme = {
    val __obj = js.Dynamic.literal(theme = theme)
    if (innerRef != null) __obj.updateDynamic("innerRef")(innerRef.asInstanceOf[js.Any])
    __obj.asInstanceOf[WithTheme]
  }
}

