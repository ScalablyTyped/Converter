package typings.fpDashTs.libHKTMod

import scala.scalajs.js.annotation.ScalaJSDefined
import scala.scalajs.js
import scala.scalajs.js.`|`

trait HKT[URI, A] extends js.Object {
  val _A: A
  val _URI: URI
}

object HKT {
  @inline
  def apply[URI, A](_A: A, _URI: URI): HKT[URI, A] = {
    val __obj = js.Dynamic.literal(_A = _A.asInstanceOf[js.Any], _URI = _URI.asInstanceOf[js.Any])
  
    __obj.asInstanceOf[HKT[URI, A]]
  }
}

