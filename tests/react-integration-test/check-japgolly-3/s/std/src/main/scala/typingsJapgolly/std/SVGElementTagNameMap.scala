package typingsJapgolly.std

import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

trait SVGElementTagNameMap extends StObject {
  
  var circle: org.scalajs.dom.SVGCircleElement
  
  var clipPath: org.scalajs.dom.SVGClipPathElement
  
  var defs: org.scalajs.dom.SVGDefsElement
}
object SVGElementTagNameMap {
  
  inline def apply(
    circle: org.scalajs.dom.SVGCircleElement,
    clipPath: org.scalajs.dom.SVGClipPathElement,
    defs: org.scalajs.dom.SVGDefsElement
  ): SVGElementTagNameMap = {
    val __obj = js.Dynamic.literal(circle = circle.asInstanceOf[js.Any], clipPath = clipPath.asInstanceOf[js.Any], defs = defs.asInstanceOf[js.Any])
    __obj.asInstanceOf[SVGElementTagNameMap]
  }
  
  @scala.inline
  implicit open class MutableBuilder[Self <: SVGElementTagNameMap] (val x: Self) extends AnyVal {
    
    inline def setCircle(value: org.scalajs.dom.SVGCircleElement): Self = StObject.set(x, "circle", value.asInstanceOf[js.Any])
    
    inline def setClipPath(value: org.scalajs.dom.SVGClipPathElement): Self = StObject.set(x, "clipPath", value.asInstanceOf[js.Any])
    
    inline def setDefs(value: org.scalajs.dom.SVGDefsElement): Self = StObject.set(x, "defs", value.asInstanceOf[js.Any])
  }
}
