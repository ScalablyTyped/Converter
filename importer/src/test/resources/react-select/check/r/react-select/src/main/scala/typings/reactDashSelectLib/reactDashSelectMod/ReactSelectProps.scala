package typings
package reactDashSelectLib.reactDashSelectMod

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

trait ReactSelectProps[TValue]
  extends reactLib.reactMod.ReactNs.Props[ReactSelectClass[TValue]] {
  /**
    * text to display when `allowCreate` is true.
    * @default 'Add "{label}"?'
    */
  var addLabelText: js.UndefOr[java.lang.String] = js.undefined
}

object ReactSelectProps {
  @scala.inline
  def apply[TValue](addLabelText: java.lang.String = null, key: java.lang.String = null): ReactSelectProps[TValue] = {
    val __obj = js.Dynamic.literal()
    if (addLabelText != null) __obj.updateDynamic("addLabelText")(addLabelText)
    if (key != null) __obj.updateDynamic("key")(key)
    __obj.asInstanceOf[ReactSelectProps[TValue]]
  }
}

