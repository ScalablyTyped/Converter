package typings.fpTs.hktMod

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@js.native
trait HKT[URI, A] extends js.Object {
  val _A: A = js.native
  val _URI: URI = js.native
}

object HKT {
  @scala.inline
  def apply[URI, A](_A: A, _URI: URI): HKT[URI, A] = {
    val __obj = js.Dynamic.literal(_A = _A.asInstanceOf[js.Any], _URI = _URI.asInstanceOf[js.Any])
    __obj.asInstanceOf[HKT[URI, A]]
  }
  @scala.inline
  implicit class HKTOps[Self[uri, a] <: HKT[uri, a], URI, A] (val x: Self[URI, A]) extends AnyVal {
    @scala.inline
    def duplicate: Self[URI, A] = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x)).asInstanceOf[Self[URI, A]]
    @scala.inline
    def combineWith[Other /* <: js.Any */](other: Other): (Self[URI, A]) with Other = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x, other.asInstanceOf[js.Any])).asInstanceOf[(Self[URI, A]) with Other]
    @scala.inline
    def with_A(value: A): Self[URI, A] = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("_A")(value.asInstanceOf[js.Any])
        ret
    }
    @scala.inline
    def with_URI(value: URI): Self[URI, A] = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("_URI")(value.asInstanceOf[js.Any])
        ret
    }
  }
  
}

