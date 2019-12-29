package typings.fpDashTs.libHKTMod

import typings.fpDashTs.libConstMod.Const
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@js.native
trait URI2HKT2[L, A] extends js.Object {
  var Const: typings.fpDashTs.libConstMod.Const[L, A] = js.native
}

object URI2HKT2 {
  @scala.inline
  def apply[L, A](Const: Const[L, A]): URI2HKT2[L, A] = {
    val __obj = js.Dynamic.literal(Const = Const.asInstanceOf[js.Any])
  
    __obj.asInstanceOf[URI2HKT2[L, A]]
  }
}

