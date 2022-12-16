package mylib.internal.baz.std

import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

private[internal] trait SVGElementTagNameMap extends StObject {
  
  var circle: org.scalajs.dom.SVGCircleElement
}
private[internal] object SVGElementTagNameMap {
  
  inline def apply(circle: org.scalajs.dom.SVGCircleElement): SVGElementTagNameMap = {
    val __obj = js.Dynamic.literal(circle = circle.asInstanceOf[js.Any])
    __obj.asInstanceOf[SVGElementTagNameMap]
  }
  
  @scala.inline
  implicit open class MutableBuilder[Self <: SVGElementTagNameMap] (val x: Self) extends AnyVal {
    
    inline def setCircle(value: org.scalajs.dom.SVGCircleElement): Self = StObject.set(x, "circle", value.asInstanceOf[js.Any])
  }
}
