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
  @scala.inline
  implicit class AnonLowerBoundOps[Self <: AnonLowerBound] (val x: Self) extends AnyVal {
    @scala.inline
    def duplicate: Self = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x)).asInstanceOf[Self]
    @scala.inline
    def combineWith[Other /* <: js.Any */](other: Other): Self with Other = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x, other.asInstanceOf[js.Any])).asInstanceOf[Self with Other]
    @scala.inline
    def withLowerBound(lowerBound: js.Array[Double]): Self = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (lowerBound != null) ret.updateDynamic("lowerBound")(lowerBound.asInstanceOf[js.Any])
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withoutLowerBound: Self = {
        val ret = this.duplicate
        js.special.delete(ret, "lowerBound")
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withUpperBound(upperBound: js.Array[Double]): Self = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (upperBound != null) ret.updateDynamic("upperBound")(upperBound.asInstanceOf[js.Any])
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withoutUpperBound: Self = {
        val ret = this.duplicate
        js.special.delete(ret, "upperBound")
        ret.asInstanceOf[Self]
    }
  }
  
}

