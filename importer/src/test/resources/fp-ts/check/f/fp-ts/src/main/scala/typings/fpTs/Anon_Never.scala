package typings.fpTs

import typings.fpTs.libHKTMod.HKT
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

trait Anon_Never extends js.Object {
  var never: HKT[scala.Nothing, scala.Nothing]
}

object Anon_Never {
  @scala.inline
  def apply(never: HKT[scala.Nothing, scala.Nothing]): Anon_Never = {
    val __obj = js.Dynamic.literal(never = never.asInstanceOf[js.Any])
  
    __obj.asInstanceOf[Anon_Never]
  }
}
