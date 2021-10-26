package typingsSlinky.std

import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

trait SVGElementTagNameMap extends StObject {
  
  var circle: org.scalajs.dom.SVGCircleElement
}
object SVGElementTagNameMap {
  
  inline def apply(circle: org.scalajs.dom.SVGCircleElement): SVGElementTagNameMap = {
    val __obj = js.Dynamic.literal(circle = circle.asInstanceOf[js.Any])
    __obj.asInstanceOf[SVGElementTagNameMap]
  }
  
  extension [Self <: SVGElementTagNameMap](x: Self) {
    
    inline def setCircle(value: org.scalajs.dom.SVGCircleElement): Self = StObject.set(x, "circle", value.asInstanceOf[js.Any])
  }
}
