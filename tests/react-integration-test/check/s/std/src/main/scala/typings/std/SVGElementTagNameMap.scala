package typings.std

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@js.native
trait SVGElementTagNameMap extends js.Object {
  var circle: SVGCircleElement = js.native
  var clipPath: SVGClipPathElement = js.native
  var defs: SVGDefsElement = js.native
}

object SVGElementTagNameMap {
  @scala.inline
  def apply(circle: SVGCircleElement, clipPath: SVGClipPathElement, defs: SVGDefsElement): SVGElementTagNameMap = {
    val __obj = js.Dynamic.literal(circle = circle.asInstanceOf[js.Any], clipPath = clipPath.asInstanceOf[js.Any], defs = defs.asInstanceOf[js.Any])
  
    __obj.asInstanceOf[SVGElementTagNameMap]
  }
}

