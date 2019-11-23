package typingsSlinky.reactDashSelect.reactDashSelectMod

import org.scalablytyped.runtime.StringDictionary
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

trait Option[TValue]
  extends /**
  * In the event that a custom menuRenderer is provided, Option should be able
  * to accept arbitrary key-value pairs. See react-virtualized-select.
  */
/* property */ StringDictionary[js.Any] {
  /** Value for searching */
  var value: js.UndefOr[TValue] = js.undefined
}

object Option {
  @scala.inline
  def apply[TValue](
    StringDictionary: /**
    * In the event that a custom menuRenderer is provided, Option should be able
    * to accept arbitrary key-value pairs. See react-virtualized-select.
    */
  /* property */ StringDictionary[js.Any] = null,
    value: TValue = null
  ): Option[TValue] = {
    val __obj = js.Dynamic.literal()
    if (StringDictionary != null) js.Dynamic.global.Object.assign(__obj, StringDictionary)
    if (value != null) __obj.updateDynamic("value")(value.asInstanceOf[js.Any])
    __obj.asInstanceOf[Option[TValue]]
  }
}

