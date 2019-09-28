package typings.expandDashTypeDashParameters

import scala.scalajs.js.annotation.ScalaJSDefined
import scala.scalajs.js
import scala.scalajs.js.`|`

trait C extends js.Object {
  var c: js.UndefOr[Double] = js.undefined
}

object C {
  @inline
  def apply(c: Int | Double = null): C = {
    val __obj = js.Dynamic.literal()
    if (c != null) __obj.updateDynamic("c")(c.asInstanceOf[js.Any])
    __obj.asInstanceOf[C]
  }
}

