package typings.typeMappings

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@js.native
trait AnonSet extends js.Object {
  def get(): String = js.native
  def set(v: String): Unit = js.native
}

object AnonSet {
  @scala.inline
  def apply(get: () => String, set: String => Unit): AnonSet = {
    val __obj = js.Dynamic.literal(get = js.Any.fromFunction0(get), set = js.Any.fromFunction1(set))
    __obj.asInstanceOf[AnonSet]
  }
  @scala.inline
  implicit class AnonSetOps[Self <: AnonSet] (val x: Self) extends AnyVal {
    @scala.inline
    def duplicate: Self = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x)).asInstanceOf[Self]
    @scala.inline
    def combineWith[Other /* <: js.Any */](other: Other): Self with Other = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x, other.asInstanceOf[js.Any])).asInstanceOf[Self with Other]
    @scala.inline
    def withGet(get: () => String): Self = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        ret.updateDynamic("get")(js.Any.fromFunction0(get))
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withSet(set: String => Unit): Self = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        ret.updateDynamic("set")(js.Any.fromFunction1(set))
        ret.asInstanceOf[Self]
    }
  }
  
}

