package typings.cldrjs.mod

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@js.native
trait TimeDataStatic extends js.Object {
  def allowed(): String = js.native
  def preferred(): String = js.native
}

object TimeDataStatic {
  @scala.inline
  def apply(allowed: () => String, preferred: () => String): TimeDataStatic = {
    val __obj = js.Dynamic.literal(allowed = js.Any.fromFunction0(allowed), preferred = js.Any.fromFunction0(preferred))
    __obj.asInstanceOf[TimeDataStatic]
  }
  @scala.inline
  implicit class TimeDataStaticOps[Self <: TimeDataStatic] (val x: Self) extends AnyVal {
    @scala.inline
    def duplicate: Self = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x)).asInstanceOf[Self]
    @scala.inline
    def combineWith[Other /* <: js.Any */](other: Other): Self with Other = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x, other.asInstanceOf[js.Any])).asInstanceOf[Self with Other]
    @scala.inline
    def withAllowed(allowed: () => String): Self = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        ret.updateDynamic("allowed")(js.Any.fromFunction0(allowed))
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withPreferred(preferred: () => String): Self = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        ret.updateDynamic("preferred")(js.Any.fromFunction0(preferred))
        ret.asInstanceOf[Self]
    }
  }
  
}

