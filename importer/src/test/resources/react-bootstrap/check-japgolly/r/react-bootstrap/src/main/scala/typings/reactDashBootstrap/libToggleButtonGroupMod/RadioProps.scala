package typings.reactDashBootstrap.libToggleButtonGroupMod

import japgolly.scalajs.react.Callback
import typings.reactDashBootstrap.reactDashBootstrapStrings.radio
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

trait RadioProps extends js.Object {
  /** Required if `type` is set to "radio" */
  var name: String
  var onChange: js.UndefOr[js.Function1[/* value */ js.Any, Unit]] = js.undefined
  var `type`: radio
}

object RadioProps {
  @scala.inline
  def apply(name: String, `type`: radio, onChange: /* value */ js.Any => Callback = null): RadioProps = {
    val __obj = js.Dynamic.literal(name = name)
    __obj.updateDynamic("type")(`type`)
    if (onChange != null) __obj.updateDynamic("onChange")(js.Any.fromFunction1((t0: /* value */ js.Any) => onChange(t0).runNow()))
    __obj.asInstanceOf[RadioProps]
  }
}

