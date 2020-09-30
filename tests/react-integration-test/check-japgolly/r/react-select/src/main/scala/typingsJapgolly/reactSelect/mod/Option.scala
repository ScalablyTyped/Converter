package typingsJapgolly.reactSelect.mod

import org.scalablytyped.runtime.StringDictionary
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

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
    def set(key: String, value: js.Any): Self = {
        x.asInstanceOf[js.Dynamic].updateDynamic(key)(value)
        x
    }
    @scala.inline
    def setValue(value: TValue): Self = this.set("value", value.asInstanceOf[js.Any])
    @scala.inline
    def deleteValue: Self = this.set("value", js.undefined)
  }
  
}

