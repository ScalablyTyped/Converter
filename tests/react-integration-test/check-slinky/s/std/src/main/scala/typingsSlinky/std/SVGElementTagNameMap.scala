package typingsSlinky.std

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@js.native
trait SVGElementTagNameMap extends js.Object {
  var circle: org.scalajs.dom.raw.SVGCircleElement = js.native
  var clipPath: org.scalajs.dom.raw.SVGClipPathElement = js.native
  var defs: org.scalajs.dom.raw.SVGDefsElement = js.native
}

object SVGElementTagNameMap {
  @scala.inline
  def apply(
    circle: org.scalajs.dom.raw.SVGCircleElement,
    clipPath: org.scalajs.dom.raw.SVGClipPathElement,
    defs: org.scalajs.dom.raw.SVGDefsElement
  ): SVGElementTagNameMap = {
    val __obj = js.Dynamic.literal(circle = circle.asInstanceOf[js.Any], clipPath = clipPath.asInstanceOf[js.Any], defs = defs.asInstanceOf[js.Any])
    __obj.asInstanceOf[SVGElementTagNameMap]
  }
  @scala.inline
  implicit class SVGElementTagNameMapOps[Self <: SVGElementTagNameMap] (val x: Self) extends AnyVal {
    @scala.inline
    def duplicate: Self = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x)).asInstanceOf[Self]
    @scala.inline
    def combineWith[Other /* <: js.Any */](other: Other): Self with Other = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x, other.asInstanceOf[js.Any])).asInstanceOf[Self with Other]
    @scala.inline
    def withCircle(value: org.scalajs.dom.raw.SVGCircleElement): Self = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("circle")(value.asInstanceOf[js.Any])
        ret
    }
    @scala.inline
    def withClipPath(value: org.scalajs.dom.raw.SVGClipPathElement): Self = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("clipPath")(value.asInstanceOf[js.Any])
        ret
    }
    @scala.inline
    def withDefs(value: org.scalajs.dom.raw.SVGDefsElement): Self = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("defs")(value.asInstanceOf[js.Any])
        ret
    }
  }
  
}

