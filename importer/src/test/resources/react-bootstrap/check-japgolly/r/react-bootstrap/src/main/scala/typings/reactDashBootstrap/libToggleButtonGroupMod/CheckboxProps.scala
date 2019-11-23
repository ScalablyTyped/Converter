package typings.reactDashBootstrap.libToggleButtonGroupMod

import japgolly.scalajs.react.Callback
import typings.reactDashBootstrap.reactDashBootstrapStrings.checkbox
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

trait CheckboxProps extends js.Object {
  var name: js.UndefOr[String] = js.undefined
  var onChange: js.UndefOr[js.Function1[/* values */ js.Array[_], Unit]] = js.undefined
  var `type`: checkbox
}

object CheckboxProps {
  @scala.inline
  def apply(`type`: checkbox, name: String = null, onChange: /* values */ js.Array[_] => Callback = null): CheckboxProps = {
    val __obj = js.Dynamic.literal()
    __obj.updateDynamic("type")(`type`)
    if (name != null) __obj.updateDynamic("name")(name)
    if (onChange != null) __obj.updateDynamic("onChange")(js.Any.fromFunction1((t0: /* values */ js.Array[_]) => onChange(t0).runNow()))
    __obj.asInstanceOf[CheckboxProps]
  }
}

