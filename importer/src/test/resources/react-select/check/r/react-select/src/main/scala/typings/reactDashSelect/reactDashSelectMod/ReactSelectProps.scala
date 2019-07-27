package typings.reactDashSelect.reactDashSelectMod

import typings.react.reactMod.Props
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

trait ReactSelectProps[TValue] extends Props[ReactSelectClass[TValue]] {
  /**
    * text to display when `allowCreate` is true.
    * @default 'Add "{label}"?'
    */
  var addLabelText: js.UndefOr[String] = js.undefined
}

object ReactSelectProps {
  @scala.inline
  def apply[TValue](addLabelText: String = null, key: String = null): ReactSelectProps[TValue] = {
    val __obj = js.Dynamic.literal()
    if (addLabelText != null) __obj.updateDynamic("addLabelText")(addLabelText)
    if (key != null) __obj.updateDynamic("key")(key)
    __obj.asInstanceOf[ReactSelectProps[TValue]]
  }
}

