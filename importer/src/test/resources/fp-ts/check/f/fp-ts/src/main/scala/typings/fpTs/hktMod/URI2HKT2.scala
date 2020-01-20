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
}

