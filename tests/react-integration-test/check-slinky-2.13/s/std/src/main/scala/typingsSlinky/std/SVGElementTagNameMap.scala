package typingsSlinky.std

import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

@js.native
trait SVGElementTagNameMap extends StObject {
  
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
  implicit class SVGElementTagNameMapMutableBuilder[Self <: SVGElementTagNameMap] (val x: Self) extends AnyVal {
    
    @scala.inline
    def setCircle(value: org.scalajs.dom.raw.SVGCircleElement): Self = StObject.set(x, "circle", value.asInstanceOf[js.Any])
    
    @scala.inline
    def setClipPath(value: org.scalajs.dom.raw.SVGClipPathElement): Self = StObject.set(x, "clipPath", value.asInstanceOf[js.Any])
    
    @scala.inline
    def setDefs(value: org.scalajs.dom.raw.SVGDefsElement): Self = StObject.set(x, "defs", value.asInstanceOf[js.Any])
  }
}
