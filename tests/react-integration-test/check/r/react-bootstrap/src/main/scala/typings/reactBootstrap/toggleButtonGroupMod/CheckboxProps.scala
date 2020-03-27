package typings.reactBootstrap.toggleButtonGroupMod

import typings.reactBootstrap.reactBootstrapStrings.checkbox
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
}

