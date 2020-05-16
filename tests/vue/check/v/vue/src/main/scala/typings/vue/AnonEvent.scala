package typings.vue

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@js.native
trait AnonEvent extends js.Object {
  var event: js.UndefOr[String] = js.native
  var prop: js.UndefOr[String] = js.native
}

object AnonEvent {
  @scala.inline
  def apply(event: String = null, prop: String = null): AnonEvent = {
    val __obj = js.Dynamic.literal()
    if (event != null) __obj.updateDynamic("event")(event.asInstanceOf[js.Any])
    if (prop != null) __obj.updateDynamic("prop")(prop.asInstanceOf[js.Any])
    __obj.asInstanceOf[AnonEvent]
  }
  @scala.inline
  implicit class AnonEventOps[Self <: AnonEvent] (val x: Self) extends AnyVal {
    @scala.inline
    def duplicate: Self = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x)).asInstanceOf[Self]
    @scala.inline
    def combineWith[Other /* <: js.Any */](other: Other): Self with Other = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x, other.asInstanceOf[js.Any])).asInstanceOf[Self with Other]
    @scala.inline
    def withEvent(event: String): Self = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (event != null) ret.updateDynamic("event")(event.asInstanceOf[js.Any])
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withoutEvent: Self = {
        val ret = this.duplicate
        js.special.delete(ret, "event")
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withProp(prop: String): Self = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (prop != null) ret.updateDynamic("prop")(prop.asInstanceOf[js.Any])
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withoutProp: Self = {
        val ret = this.duplicate
        js.special.delete(ret, "prop")
        ret.asInstanceOf[Self]
    }
  }
  
}

