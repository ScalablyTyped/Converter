package typingsSlinky.reactBootstrap.toggleButtonGroupMod

import typingsSlinky.reactBootstrap.reactBootstrapStrings.checkbox
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@js.native
trait CheckboxProps extends js.Object {
  var name: js.UndefOr[String] = js.native
  var onChange: js.UndefOr[js.Function1[/* values */ js.Array[_], Unit]] = js.native
  var `type`: checkbox = js.native
}

object CheckboxProps {
  @scala.inline
  def apply(`type`: checkbox, name: String = null, onChange: /* values */ js.Array[_] => Unit = null): CheckboxProps = {
    val __obj = js.Dynamic.literal()
    __obj.updateDynamic("type")(`type`.asInstanceOf[js.Any])
    if (name != null) __obj.updateDynamic("name")(name.asInstanceOf[js.Any])
    if (onChange != null) __obj.updateDynamic("onChange")(js.Any.fromFunction1(onChange))
    __obj.asInstanceOf[CheckboxProps]
  }
  @scala.inline
  implicit class CheckboxPropsOps[Self <: CheckboxProps] (val x: Self) extends AnyVal {
    @scala.inline
    def duplicate: Self = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x)).asInstanceOf[Self]
    @scala.inline
    def combineWith[Other /* <: js.Any */](other: Other): Self with Other = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x, other.asInstanceOf[js.Any])).asInstanceOf[Self with Other]
    @scala.inline
    def withType(`type`: checkbox): Self = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        ret.updateDynamic("type")(`type`.asInstanceOf[js.Any])
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withName(name: String): Self = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (name != null) ret.updateDynamic("name")(name.asInstanceOf[js.Any])
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withoutName: Self = {
        val ret = this.duplicate
        js.special.delete(ret, "name")
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withOnChange(onChange: /* values */ js.Array[_] => Unit): Self = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (onChange != null) ret.updateDynamic("onChange")(js.Any.fromFunction1(onChange))
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withoutOnChange: Self = {
        val ret = this.duplicate
        js.special.delete(ret, "onChange")
        ret.asInstanceOf[Self]
    }
  }
  
}

