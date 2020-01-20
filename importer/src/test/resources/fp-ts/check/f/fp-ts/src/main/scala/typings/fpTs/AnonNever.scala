package typings.fpTs

import typings.fpTs.hktMod.HKT
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@js.native
trait AnonNever extends js.Object {
  var never: HKT[scala.Nothing, scala.Nothing] = js.native
}

object AnonNever {
  @scala.inline
  def apply(never: HKT[scala.Nothing, scala.Nothing]): AnonNever = {
    val __obj = js.Dynamic.literal(never = never.asInstanceOf[js.Any])
  
    __obj.asInstanceOf[AnonNever]
  }
}

