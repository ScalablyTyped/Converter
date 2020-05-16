package typings.std

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@js.native
trait SVGElementTagNameMap extends js.Object {
  var circle: SVGCircleElement = js.native
}

object SVGElementTagNameMap {
  @scala.inline
  def apply(circle: SVGCircleElement): SVGElementTagNameMap = {
    val __obj = js.Dynamic.literal(circle = circle.asInstanceOf[js.Any])
    __obj.asInstanceOf[SVGElementTagNameMap]
  }
  @scala.inline
  implicit class SVGElementTagNameMapOps[Self <: SVGElementTagNameMap] (val x: Self) extends AnyVal {
    @scala.inline
    def duplicate: Self = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x)).asInstanceOf[Self]
    @scala.inline
    def combineWith[Other /* <: js.Any */](other: Other): Self with Other = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x, other.asInstanceOf[js.Any])).asInstanceOf[Self with Other]
    @scala.inline
    def withCircle(value: SVGCircleElement): Self = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("circle")(value.asInstanceOf[js.Any])
        ret
    }
  }
  
}

