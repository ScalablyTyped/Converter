package typingsJapgolly.react

import org.scalajs.dom.SVGCircleElement
import org.scalajs.dom.SVGClipPathElement
import org.scalajs.dom.SVGDefsElement
import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

trait SVGElementTagNameMap extends StObject {
  
  var circle: SVGCircleElement
  
  var clipPath: SVGClipPathElement
  
  var defs: SVGDefsElement
}
object SVGElementTagNameMap {
  
  inline def apply(circle: SVGCircleElement, clipPath: SVGClipPathElement, defs: SVGDefsElement): SVGElementTagNameMap = {
    val __obj = js.Dynamic.literal(circle = circle.asInstanceOf[js.Any], clipPath = clipPath.asInstanceOf[js.Any], defs = defs.asInstanceOf[js.Any])
    __obj.asInstanceOf[SVGElementTagNameMap]
  }
  
  @scala.inline
  implicit open class MutableBuilder[Self <: SVGElementTagNameMap] (val x: Self) extends AnyVal {
    
    inline def setCircle(value: SVGCircleElement): Self = StObject.set(x, "circle", value.asInstanceOf[js.Any])
    
    inline def setClipPath(value: SVGClipPathElement): Self = StObject.set(x, "clipPath", value.asInstanceOf[js.Any])
    
    inline def setDefs(value: SVGDefsElement): Self = StObject.set(x, "defs", value.asInstanceOf[js.Any])
  }
}
