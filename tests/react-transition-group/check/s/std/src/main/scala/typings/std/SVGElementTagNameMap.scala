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
    def combineWith[Other <: js.Any](other: Other): Self with Other = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x, other.asInstanceOf[js.Any])).asInstanceOf[Self with Other]
    @scala.inline
    def set(key: String, value: js.Any): Self = {
        x.asInstanceOf[js.Dynamic].updateDynamic(key)(value)
        x
    }
    @scala.inline
    def setCircle(value: SVGCircleElement): Self = this.set("circle", value.asInstanceOf[js.Any])
  }
  
}

