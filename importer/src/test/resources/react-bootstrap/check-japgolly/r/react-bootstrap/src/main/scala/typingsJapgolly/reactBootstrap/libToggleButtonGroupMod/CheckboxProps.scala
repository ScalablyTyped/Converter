package typingsJapgolly.reactBootstrap.libToggleButtonGroupMod

import japgolly.scalajs.react.Callback
import typingsJapgolly.reactBootstrap.reactBootstrapStrings.checkbox
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
  def apply(
    `type`: checkbox,
    name: String = null,
    onChange: js.UndefOr[/* values */ js.Array[js.Any] => Callback] = js.undefined
  ): CheckboxProps = {
    val __obj = js.Dynamic.literal()
    __obj.updateDynamic("type")(`type`.asInstanceOf[js.Any])
    if (name != null) __obj.updateDynamic("name")(name.asInstanceOf[js.Any])
    onChange.foreach(x => __obj.updateDynamic("onChange")(js.Any.fromFunction1((t0: /* values */ js.Array[js.Any]) => x(t0).runNow())))
    __obj.asInstanceOf[CheckboxProps]
  }
}

