package typings.fpDashTs.libHKTMod

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
}

