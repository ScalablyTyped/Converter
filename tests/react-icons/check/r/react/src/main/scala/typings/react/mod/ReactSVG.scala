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
}

