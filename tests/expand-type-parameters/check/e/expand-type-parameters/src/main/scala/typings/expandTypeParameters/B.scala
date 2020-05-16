package typings.expandTypeParameters

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@js.native
trait B extends TA {
  var b: String = js.native
}

object B {
  @scala.inline
  def apply(b: String): B = {
    val __obj = js.Dynamic.literal(b = b.asInstanceOf[js.Any])
    __obj.asInstanceOf[B]
  }
  @scala.inline
  implicit class BOps[Self <: B] (val x: Self) extends AnyVal {
    @scala.inline
    def duplicate: Self = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x)).asInstanceOf[Self]
    @scala.inline
    def combineWith[Other /* <: js.Any */](other: Other): Self with Other = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x, other.asInstanceOf[js.Any])).asInstanceOf[Self with Other]
    @scala.inline
    def withB(b: String): Self = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        ret.updateDynamic("b")(b.asInstanceOf[js.Any])
        ret.asInstanceOf[Self]
    }
  }
  
}

