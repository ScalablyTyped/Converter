package typingsJapgolly.componentstest.mod

import japgolly.scalajs.react.CallbackTo
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
  def apply(bMember: String, bCallback: js.UndefOr[CallbackTo[String]] = js.undefined): B = {
    val __obj = js.Dynamic.literal(bMember = bMember.asInstanceOf[js.Any])
    bCallback.foreach(p => __obj.updateDynamic("bCallback")(p.toJsFn))
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
    def withBCallback(bCallback: js.UndefOr[CallbackTo[String]]): Self = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        bCallback.foreach(p => ret.updateDynamic("bCallback")(p.toJsFn))
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

