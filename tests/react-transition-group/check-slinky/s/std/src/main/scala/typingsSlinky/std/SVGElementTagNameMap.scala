package typingsSlinky.std

import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

@js.native
trait SVGElementTagNameMap extends StObject {
  
  var circle: org.scalajs.dom.raw.SVGCircleElement = js.native
}
object SVGElementTagNameMap {
  
  @scala.inline
  def apply(circle: org.scalajs.dom.raw.SVGCircleElement): SVGElementTagNameMap = {
    val __obj = js.Dynamic.literal(circle = circle.asInstanceOf[js.Any])
    __obj.asInstanceOf[SVGElementTagNameMap]
  }
  
  @scala.inline
  implicit class SVGElementTagNameMapMutableBuilder[Self <: SVGElementTagNameMap] (val x: Self) extends AnyVal {
    
    @scala.inline
    def setCircle(value: org.scalajs.dom.raw.SVGCircleElement): Self = StObject.set(x, "circle", value.asInstanceOf[js.Any])
  }
}
