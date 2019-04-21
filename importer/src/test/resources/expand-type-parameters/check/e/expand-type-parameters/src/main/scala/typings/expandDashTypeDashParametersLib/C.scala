package typings
package expandDashTypeDashParametersLib

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

trait C extends js.Object {
  var c: js.UndefOr[scala.Double] = js.undefined
}

object C {
  @scala.inline
  def apply(c: scala.Int | scala.Double = null): C = {
    val __obj = js.Dynamic.literal()
    if (c != null) __obj.updateDynamic("c")(c.asInstanceOf[js.Any])
    __obj.asInstanceOf[C]
  }
}

