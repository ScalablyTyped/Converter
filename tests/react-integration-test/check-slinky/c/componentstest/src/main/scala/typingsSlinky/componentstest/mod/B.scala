package typingsSlinky.componentstest.mod

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@js.native
trait B extends Props {
  var bCallback: js.UndefOr[js.Function0[String]] = js.native
  var bMember: String = js.native
}

object B {
  @scala.inline
  def apply(bMember: String, bCallback: () => String = null): B = {
    val __obj = js.Dynamic.literal(bMember = bMember.asInstanceOf[js.Any])
    if (bCallback != null) __obj.updateDynamic("bCallback")(js.Any.fromFunction0(bCallback))
    __obj.asInstanceOf[B]
  }
  @scala.inline
  implicit class BOps[Self <: B] (val x: Self) extends AnyVal {
    @scala.inline
    def duplicate: Self = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x)).asInstanceOf[Self]
    @scala.inline
    def combineWith[Other /* <: js.Any */](other: Other): Self with Other = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x, other.asInstanceOf[js.Any])).asInstanceOf[Self with Other]
    @scala.inline
    def withBMember(bMember: String): Self = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        ret.updateDynamic("bMember")(bMember.asInstanceOf[js.Any])
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withBCallback(bCallback: () => String): Self = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (bCallback != null) ret.updateDynamic("bCallback")(js.Any.fromFunction0(bCallback))
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withoutBCallback: Self = {
        val ret = this.duplicate
        js.special.delete(ret, "bCallback")
        ret.asInstanceOf[Self]
    }
  }
  
}

