package typingsJapgolly.reactSelect.mod

import japgolly.scalajs.react.vdom.VdomNode
import typingsJapgolly.react.mod.Key
import typingsJapgolly.react.mod.LegacyRef
import typingsJapgolly.react.mod.Props
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
  def apply[TValue](
    addLabelText: String = null,
    children: VdomNode = null,
    key: Key = null,
    ref: LegacyRef[ReactSelectClass[TValue]] = null
  ): ReactSelectProps[TValue] = {
    val __obj = js.Dynamic.literal()
    if (addLabelText != null) __obj.updateDynamic("addLabelText")(addLabelText.asInstanceOf[js.Any])
    if (children != null) __obj.updateDynamic("children")(children.rawNode.asInstanceOf[js.Any])
    if (key != null) __obj.updateDynamic("key")(key.asInstanceOf[js.Any])
    if (ref != null) __obj.updateDynamic("ref")(ref.asInstanceOf[js.Any])
    __obj.asInstanceOf[ReactSelectProps[TValue]]
  }
  @scala.inline
  implicit class ReactSelectPropsOps[Self[tvalue] <: ReactSelectProps[tvalue], TValue] (val x: Self[TValue]) extends AnyVal {
    @scala.inline
    def duplicate: Self[TValue] = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x)).asInstanceOf[Self[TValue]]
    @scala.inline
    def combineWith[Other /* <: js.Any */](other: Other): Self[TValue] with Other = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x, other.asInstanceOf[js.Any])).asInstanceOf[Self[TValue] with Other]
    @scala.inline
    def withAddLabelText(addLabelText: String): Self[TValue] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (addLabelText != null) ret.updateDynamic("addLabelText")(addLabelText.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[TValue]]
    }
    @scala.inline
    def withoutAddLabelText: Self[TValue] = {
        val ret = this.duplicate
        js.special.delete(ret, "addLabelText")
        ret.asInstanceOf[Self[TValue]]
    }
  }
  
}

