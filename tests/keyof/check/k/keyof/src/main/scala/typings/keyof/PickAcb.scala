package typings.keyof

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

/* Inlined std.Pick<keyof.A, 'c' | 'b'> */
@js.native
trait PickAcb extends js.Object {
  var b: Double = js.native
  var c: Double = js.native
}

object PickAcb {
  @scala.inline
  def apply(b: Double, c: Double): PickAcb = {
    val __obj = js.Dynamic.literal(b = b.asInstanceOf[js.Any], c = c.asInstanceOf[js.Any])
    __obj.asInstanceOf[PickAcb]
  }
}

