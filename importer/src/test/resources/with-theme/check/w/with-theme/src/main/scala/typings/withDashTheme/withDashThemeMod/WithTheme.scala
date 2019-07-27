package typings.withDashTheme.withDashThemeMod

import typings.react.ReactNs.Ref
import typings.react.ReactNs.RefObject
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

trait WithTheme extends js.Object {
  var innerRef: js.UndefOr[Ref[_] | RefObject[_]] = js.undefined
  var theme: String
}

object WithTheme {
  @scala.inline
  def apply(theme: String, innerRef: Ref[_] | RefObject[_] = null): WithTheme = {
    val __obj = js.Dynamic.literal(theme = theme)
    if (innerRef != null) __obj.updateDynamic("innerRef")(innerRef.asInstanceOf[js.Any])
    __obj.asInstanceOf[WithTheme]
  }
}

