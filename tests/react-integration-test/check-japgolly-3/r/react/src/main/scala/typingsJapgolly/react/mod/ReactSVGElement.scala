package typingsJapgolly.react.mod

import org.scalajs.dom.raw.SVGElement
import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

// ReactSVG for ReactSVGElement
trait ReactSVGElement
  extends StObject
     with DOMElement[SVGAttributes[SVGElement], SVGElement] {
  
  @JSName("type")
  var type_ReactSVGElement: /* import warning: LimitUnionLength.leaveTypeRef Was union type with length 55 */ String
}
object ReactSVGElement {
  
  inline def apply(
    props: js.Any,
    `type`: /* import warning: LimitUnionLength.leaveTypeRef Was union type with length 55 */ String
  ): ReactSVGElement = {
    val __obj = js.Dynamic.literal(props = props.asInstanceOf[js.Any], key = null, ref = null)
    __obj.updateDynamic("type")(`type`.asInstanceOf[js.Any])
    __obj.asInstanceOf[ReactSVGElement]
  }
  
  extension [Self <: ReactSVGElement](x: Self) {
    
    inline def setType(value: /* import warning: LimitUnionLength.leaveTypeRef Was union type with length 55 */ String): Self = StObject.set(x, "type", value.asInstanceOf[js.Any])
  }
}
