package typings.expandTypeParameters

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@js.native
trait C extends js.Object {
  var c: js.UndefOr[Double] = js.native
}

object C {
  @scala.inline
  def apply(c: Int | Double = null): C = {
    val __obj = js.Dynamic.literal()
    if (c != null) __obj.updateDynamic("c")(c.asInstanceOf[js.Any])
    __obj.asInstanceOf[C]
  }
  @scala.inline
  implicit class COps[Self <: C] (val x: Self) extends AnyVal {
    @scala.inline
    def duplicate: Self = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x)).asInstanceOf[Self]
    @scala.inline
    def combineWith[Other /* <: js.Any */](other: Other): Self with Other = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x, other.asInstanceOf[js.Any])).asInstanceOf[Self with Other]
    @scala.inline
    def withC(c: Int | Double): Self = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (c != null) ret.updateDynamic("c")(c.asInstanceOf[js.Any])
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withoutC: Self = {
        val ret = this.duplicate
        js.special.delete(ret, "c")
        ret.asInstanceOf[Self]
    }
  }
  
}

