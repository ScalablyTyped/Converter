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
  def apply(bMember: String): B = {
    val __obj = js.Dynamic.literal(bMember = bMember.asInstanceOf[js.Any])
    __obj.asInstanceOf[B]
  }
  @scala.inline
  implicit class BOps[Self <: B] (val x: Self) extends AnyVal {
    @scala.inline
    def duplicate: Self = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x)).asInstanceOf[Self]
    @scala.inline
    def combineWith[Other /* <: js.Any */](other: Other): Self with Other = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x, other.asInstanceOf[js.Any])).asInstanceOf[Self with Other]
    @scala.inline
    def withBMember(value: String): Self = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("bMember")(value.asInstanceOf[js.Any])
        ret
    }
    @scala.inline
    def withBCallback(value: CallbackTo[String]): Self = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("bCallback")(value.toJsFn)
        ret
    }
    @scala.inline
    def withoutBCallback: Self = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("bCallback")(js.undefined)
        ret
    }
  }
  
}

