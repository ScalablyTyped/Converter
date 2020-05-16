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
  @scala.inline
  implicit class WithThemeOps[Self <: WithTheme] (val x: Self) extends AnyVal {
    @scala.inline
    def duplicate: Self = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x)).asInstanceOf[Self]
    @scala.inline
    def combineWith[Other /* <: js.Any */](other: Other): Self with Other = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x, other.asInstanceOf[js.Any])).asInstanceOf[Self with Other]
    @scala.inline
    def withTheme(theme: String): Self = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        ret.updateDynamic("theme")(theme.asInstanceOf[js.Any])
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withInnerRef(innerRef: Ref[_] | RefObject[_]): Self = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (innerRef != null) ret.updateDynamic("innerRef")(innerRef.asInstanceOf[js.Any])
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withoutInnerRef: Self = {
        val ret = this.duplicate
        js.special.delete(ret, "innerRef")
        ret.asInstanceOf[Self]
    }
  }
  
}

