package typings.reactSelect.mod

import org.scalablytyped.runtime.StringDictionary
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@js.native
trait Option[TValue]
  extends /**
  * In the event that a custom menuRenderer is provided, Option should be able
  * to accept arbitrary key-value pairs. See react-virtualized-select.
  */
/* property */ StringDictionary[js.Any] {
  /** Value for searching */
  var value: js.UndefOr[TValue] = js.native
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
  @scala.inline
  implicit class OptionOps[Self[tvalue] <: Option[tvalue], TValue] (val x: Self[TValue]) extends AnyVal {
    @scala.inline
    def duplicate: Self[TValue] = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x)).asInstanceOf[Self[TValue]]
    @scala.inline
    def combineWith[Other /* <: js.Any */](other: Other): Self[TValue] with Other = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x, other.asInstanceOf[js.Any])).asInstanceOf[Self[TValue] with Other]
    @scala.inline
    def withValue(value: TValue): Self[TValue] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (value != null) ret.updateDynamic("value")(value.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[TValue]]
    }
    @scala.inline
    def withoutValue: Self[TValue] = {
        val ret = this.duplicate
        js.special.delete(ret, "value")
        ret.asInstanceOf[Self[TValue]]
    }
  }
  
}

