package typings.fpTs.hktMod

import typings.fpTs.constMod.Const
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@js.native
trait URI2HKT2[L, A] extends js.Object {
  var Const: typings.fpTs.constMod.Const[L, A] = js.native
}

object URI2HKT2 {
  @scala.inline
  def apply[L, A](Const: Const[L, A]): URI2HKT2[L, A] = {
    val __obj = js.Dynamic.literal(Const = Const.asInstanceOf[js.Any])
    __obj.asInstanceOf[URI2HKT2[L, A]]
  }
  @scala.inline
  implicit class URI2HKT2Ops[Self[l, a] <: URI2HKT2[l, a], L, A] (val x: Self[L, A]) extends AnyVal {
    @scala.inline
    def duplicate: Self[L, A] = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x)).asInstanceOf[Self[L, A]]
    @scala.inline
    def combineWith[Other /* <: js.Any */](other: Other): (Self[L, A]) with Other = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x, other.asInstanceOf[js.Any])).asInstanceOf[(Self[L, A]) with Other]
    @scala.inline
    def withConst(value: Const[L, A]): Self[L, A] = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("Const")(value.asInstanceOf[js.Any])
        ret
    }
  }
  
}

