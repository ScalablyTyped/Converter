package typings.react.mod

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@js.native
trait ReactSVG extends js.Object {
  var animate: SVGFactory = js.native
  var circle: SVGFactory = js.native
  var clipPath: SVGFactory = js.native
}

object ReactSVG {
  @scala.inline
  def apply(animate: SVGFactory, circle: SVGFactory, clipPath: SVGFactory): ReactSVG = {
    val __obj = js.Dynamic.literal(animate = animate.asInstanceOf[js.Any], circle = circle.asInstanceOf[js.Any], clipPath = clipPath.asInstanceOf[js.Any])
    __obj.asInstanceOf[ReactSVG]
  }
  @scala.inline
  implicit class ReactSVGOps[Self <: ReactSVG] (val x: Self) extends AnyVal {
    @scala.inline
    def duplicate: Self = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x)).asInstanceOf[Self]
    @scala.inline
    def combineWith[Other <: js.Any](other: Other): Self with Other = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x, other.asInstanceOf[js.Any])).asInstanceOf[Self with Other]
    @scala.inline
    def withAnimate(value: SVGFactory): Self = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("animate")(value.asInstanceOf[js.Any])
        ret
    }
    @scala.inline
    def withCircle(value: SVGFactory): Self = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("circle")(value.asInstanceOf[js.Any])
        ret
    }
    @scala.inline
    def withClipPath(value: SVGFactory): Self = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("clipPath")(value.asInstanceOf[js.Any])
        ret
    }
  }
  
}

