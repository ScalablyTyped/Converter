package typings.expandTypeParameters

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@js.native
trait C extends js.Object {
  var c: js.UndefOr[Double] = js.native
}

object C {
  @scala.inline
  def apply(c: Int | Double = null): C = {
    val __obj = js.Dynamic.literal()
    if (c != null) __obj.updateDynamic("c")(c.asInstanceOf[js.Any])
    __obj.asInstanceOf[C]
  }
}

