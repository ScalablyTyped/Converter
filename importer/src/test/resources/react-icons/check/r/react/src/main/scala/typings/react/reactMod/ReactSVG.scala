package typings.react.reactMod

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

trait ReactSVG extends js.Object {
  var animate: SVGFactory
  var circle: SVGFactory
  var clipPath: SVGFactory
}

object ReactSVG {
  @scala.inline
  def apply(animate: SVGFactory, circle: SVGFactory, clipPath: SVGFactory): ReactSVG = {
    val __obj = js.Dynamic.literal(animate = animate, circle = circle, clipPath = clipPath)
  
    __obj.asInstanceOf[ReactSVG]
  }
}

