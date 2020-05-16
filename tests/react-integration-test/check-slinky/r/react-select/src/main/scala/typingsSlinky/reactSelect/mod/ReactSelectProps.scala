package typingsSlinky.reactSelect.mod

import typingsSlinky.react.mod.Props
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@js.native
trait ReactSelectProps[TValue] extends Props[ReactSelectClass[TValue]] {
  /**
    * text to display when `allowCreate` is true.
    * @default 'Add "{label}"?'
    */
  var addLabelText: js.UndefOr[String] = js.native
}

object ReactSelectProps {
  @scala.inline
  def apply[TValue](): ReactSelectProps[TValue] = {
    val __obj = js.Dynamic.literal()
    __obj.asInstanceOf[ReactSelectProps[TValue]]
  }
  @scala.inline
  implicit class ReactSelectPropsOps[Self[tvalue] <: ReactSelectProps[tvalue], TValue] (val x: Self[TValue]) extends AnyVal {
    @scala.inline
    def duplicate: Self[TValue] = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x)).asInstanceOf[Self[TValue]]
    @scala.inline
    def combineWith[Other /* <: js.Any */](other: Other): Self[TValue] with Other = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x, other.asInstanceOf[js.Any])).asInstanceOf[Self[TValue] with Other]
    @scala.inline
    def withAddLabelText(value: String): Self[TValue] = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("addLabelText")(value.asInstanceOf[js.Any])
        ret
    }
    @scala.inline
    def withoutAddLabelText: Self[TValue] = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("addLabelText")(js.undefined)
        ret
    }
  }
  
}

