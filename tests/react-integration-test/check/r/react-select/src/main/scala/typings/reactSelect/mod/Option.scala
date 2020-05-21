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
  def apply[TValue](): Option[TValue] = {
    val __obj = js.Dynamic.literal()
    __obj.asInstanceOf[Option[TValue]]
  }
  @scala.inline
  implicit class OptionOps[Self <: Option[_], TValue] (val x: Self with Option[TValue]) extends AnyVal {
    @scala.inline
    def duplicate: Self = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x)).asInstanceOf[Self]
    @scala.inline
    def combineWith[Other <: js.Any](other: Other): Self with Other = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x, other.asInstanceOf[js.Any])).asInstanceOf[Self with Other]
    @scala.inline
    def withValue(value: TValue): Self = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("value")(value.asInstanceOf[js.Any])
        ret
    }
    @scala.inline
    def withoutValue: Self = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("value")(js.undefined)
        ret
    }
  }
  
}

