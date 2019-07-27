package typings.expandDashTypeDashParametersLib

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

trait C extends js.Object {
  var c: js.UndefOr[Double] = js.undefined
}

object C {
  @scala.inline
  def apply(c: Int | Double = null): C = {
    val __obj = js.Dynamic.literal()
    if (c != null) __obj.updateDynamic("c")(c.asInstanceOf[js.Any])
    __obj.asInstanceOf[C]
  }
}

