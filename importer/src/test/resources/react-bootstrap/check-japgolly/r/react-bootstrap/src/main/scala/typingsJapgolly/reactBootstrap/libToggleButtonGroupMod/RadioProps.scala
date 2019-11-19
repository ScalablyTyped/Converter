package typingsJapgolly.reactBootstrap.libToggleButtonGroupMod

import japgolly.scalajs.react.Callback
import typingsJapgolly.reactBootstrap.reactBootstrapStrings.radio
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
  def apply(name: String, `type`: radio, onChange: js.UndefOr[/* value */ js.Any => Callback] = js.undefined): RadioProps = {
    val __obj = js.Dynamic.literal(name = name.asInstanceOf[js.Any])
    __obj.updateDynamic("type")(`type`.asInstanceOf[js.Any])
    onChange.foreach(x => __obj.updateDynamic("onChange")(js.Any.fromFunction1((t0: /* value */ js.Any) => x(t0).runNow())))
    __obj.asInstanceOf[RadioProps]
  }
}

