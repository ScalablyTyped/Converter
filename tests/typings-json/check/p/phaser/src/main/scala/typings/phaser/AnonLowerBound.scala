package typings.phaser

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@js.native
trait AnonLowerBound extends js.Object {
  var lowerBound: js.UndefOr[js.Array[Double]] = js.native
  var upperBound: js.UndefOr[js.Array[Double]] = js.native
}

object AnonLowerBound {
  @scala.inline
  def apply(lowerBound: js.Array[Double] = null, upperBound: js.Array[Double] = null): AnonLowerBound = {
    val __obj = js.Dynamic.literal()
    if (lowerBound != null) __obj.updateDynamic("lowerBound")(lowerBound.asInstanceOf[js.Any])
    if (upperBound != null) __obj.updateDynamic("upperBound")(upperBound.asInstanceOf[js.Any])
    __obj.asInstanceOf[AnonLowerBound]
  }
}

