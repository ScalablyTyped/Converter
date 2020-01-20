package typings.withTheme.mod

import typings.react.mod.Ref
import typings.react.mod.RefObject
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@js.native
trait WithTheme extends js.Object {
  var innerRef: js.UndefOr[Ref[_] | RefObject[_]] = js.native
  var theme: String = js.native
}

object WithTheme {
  @scala.inline
  def apply(theme: String, innerRef: Ref[_] | RefObject[_] = null): WithTheme = {
    val __obj = js.Dynamic.literal(theme = theme.asInstanceOf[js.Any])
    if (innerRef != null) __obj.updateDynamic("innerRef")(innerRef.asInstanceOf[js.Any])
    __obj.asInstanceOf[WithTheme]
  }
}

