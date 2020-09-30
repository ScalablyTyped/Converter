package typingsSlinky.reactSelect.mod

import typingsSlinky.react.mod.Props
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

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
  implicit class ReactSelectPropsOps[Self <: ReactSelectProps[_], TValue] (val x: Self with ReactSelectProps[TValue]) extends AnyVal {
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
    def setAddLabelText(value: String): Self = this.set("addLabelText", value.asInstanceOf[js.Any])
    @scala.inline
    def deleteAddLabelText: Self = this.set("addLabelText", js.undefined)
  }
  
}

