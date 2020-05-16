package typings.reactBootstrap.toggleButtonGroupMod

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@js.native
trait BaseProps extends js.Object {
  /**
    * You'll usually want to use string|number|string[]|number[] here,
    * but you can technically use any|any[].
    */
  var defaultValue: js.UndefOr[js.Any] = js.native
  /**
    * You'll usually want to use string|number|string[]|number[] here,
    * but you can technically use any|any[].
    */
  var value: js.UndefOr[js.Any] = js.native
}

object BaseProps {
  @scala.inline
  def apply(defaultValue: js.Any = null, value: js.Any = null): BaseProps = {
    val __obj = js.Dynamic.literal()
    if (defaultValue != null) __obj.updateDynamic("defaultValue")(defaultValue.asInstanceOf[js.Any])
    if (value != null) __obj.updateDynamic("value")(value.asInstanceOf[js.Any])
    __obj.asInstanceOf[BaseProps]
  }
  @scala.inline
  implicit class BasePropsOps[Self <: BaseProps] (val x: Self) extends AnyVal {
    @scala.inline
    def duplicate: Self = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x)).asInstanceOf[Self]
    @scala.inline
    def combineWith[Other /* <: js.Any */](other: Other): Self with Other = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x, other.asInstanceOf[js.Any])).asInstanceOf[Self with Other]
    @scala.inline
    def withDefaultValue(defaultValue: js.Any): Self = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (defaultValue != null) ret.updateDynamic("defaultValue")(defaultValue.asInstanceOf[js.Any])
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withoutDefaultValue: Self = {
        val ret = this.duplicate
        js.special.delete(ret, "defaultValue")
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withValue(value: js.Any): Self = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (value != null) ret.updateDynamic("value")(value.asInstanceOf[js.Any])
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withoutValue: Self = {
        val ret = this.duplicate
        js.special.delete(ret, "value")
        ret.asInstanceOf[Self]
    }
  }
  
}

