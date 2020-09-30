package typings.react.mod

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

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
    def set(key: String, value: js.Any): Self = {
        x.asInstanceOf[js.Dynamic].updateDynamic(key)(value)
        x
    }
    @scala.inline
    def setAnimate(value: SVGFactory): Self = this.set("animate", value.asInstanceOf[js.Any])
    @scala.inline
    def setCircle(value: SVGFactory): Self = this.set("circle", value.asInstanceOf[js.Any])
    @scala.inline
    def setClipPath(value: SVGFactory): Self = this.set("clipPath", value.asInstanceOf[js.Any])
  }
  
}

