package typings.withDashTheme.withDashThemeMod

import scala.scalajs.js.annotation.ScalaJSDefined
import typings.react.React.Ref
import typings.react.React.RefObject
import scala.scalajs.js
import scala.scalajs.js.`|`

trait WithTheme extends js.Object {
  var innerRef: js.UndefOr[Ref[_] | RefObject[_]] = js.undefined
  var theme: String
}

object WithTheme {
  @inline
  def apply(theme: String, innerRef: Ref[_] | RefObject[_] = null): WithTheme = {
    val __obj = js.Dynamic.literal(theme = theme)
    if (innerRef != null) __obj.updateDynamic("innerRef")(innerRef.asInstanceOf[js.Any])
    __obj.asInstanceOf[WithTheme]
  }
}

