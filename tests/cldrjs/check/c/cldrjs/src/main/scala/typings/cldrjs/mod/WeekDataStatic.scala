package typings.cldrjs.mod

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@js.native
trait WeekDataStatic extends js.Object {
  def firstDay(): String = js.native
  def minDays(): Double = js.native
}

object WeekDataStatic {
  @scala.inline
  def apply(firstDay: () => String, minDays: () => Double): WeekDataStatic = {
    val __obj = js.Dynamic.literal(firstDay = js.Any.fromFunction0(firstDay), minDays = js.Any.fromFunction0(minDays))
    __obj.asInstanceOf[WeekDataStatic]
  }
  @scala.inline
  implicit class WeekDataStaticOps[Self <: WeekDataStatic] (val x: Self) extends AnyVal {
    @scala.inline
    def duplicate: Self = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x)).asInstanceOf[Self]
    @scala.inline
    def combineWith[Other /* <: js.Any */](other: Other): Self with Other = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x, other.asInstanceOf[js.Any])).asInstanceOf[Self with Other]
    @scala.inline
    def withFirstDay(value: () => String): Self = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("firstDay")(js.Any.fromFunction0(value))
        ret
    }
    @scala.inline
    def withMinDays(value: () => Double): Self = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("minDays")(js.Any.fromFunction0(value))
        ret
    }
  }
  
}

