package typings.fpTs.mod.lib.Const.mod.lib.HKT

import typings.fpTs.mod.lib.Const.Const
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

trait URI2HKT2[L, A] extends js.Object {
  var Const: typings.fpTs.mod.lib.Const.Const[L, A]
}

object URI2HKT2 {
  @scala.inline
  def apply[L, A](Const: Const[L, A]): URI2HKT2[L, A] = {
    val __obj = js.Dynamic.literal(Const = Const.asInstanceOf[js.Any])
  
    __obj.asInstanceOf[URI2HKT2[L, A]]
  }
}

