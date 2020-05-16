package typings.vue

import typings.vue.optionsMod.InjectKey
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@js.native
trait AnonDefault extends js.Object {
  var default: js.UndefOr[js.Any] = js.native
  var from: js.UndefOr[InjectKey] = js.native
}

object AnonDefault {
  @scala.inline
  def apply(default: js.Any = null, from: InjectKey = null): AnonDefault = {
    val __obj = js.Dynamic.literal()
    if (default != null) __obj.updateDynamic("default")(default.asInstanceOf[js.Any])
    if (from != null) __obj.updateDynamic("from")(from.asInstanceOf[js.Any])
    __obj.asInstanceOf[AnonDefault]
  }
  @scala.inline
  implicit class AnonDefaultOps[Self <: AnonDefault] (val x: Self) extends AnyVal {
    @scala.inline
    def duplicate: Self = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x)).asInstanceOf[Self]
    @scala.inline
    def combineWith[Other /* <: js.Any */](other: Other): Self with Other = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x, other.asInstanceOf[js.Any])).asInstanceOf[Self with Other]
    @scala.inline
    def withDefault(default: js.Any): Self = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (default != null) ret.updateDynamic("default")(default.asInstanceOf[js.Any])
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withoutDefault: Self = {
        val ret = this.duplicate
        js.special.delete(ret, "default")
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withFrom(from: InjectKey): Self = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (from != null) ret.updateDynamic("from")(from.asInstanceOf[js.Any])
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withoutFrom: Self = {
        val ret = this.duplicate
        js.special.delete(ret, "from")
        ret.asInstanceOf[Self]
    }
  }
  
}

