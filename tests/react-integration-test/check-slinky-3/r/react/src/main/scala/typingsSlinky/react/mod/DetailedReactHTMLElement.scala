package typingsSlinky.react.mod

import org.scalajs.dom.raw.HTMLElement
import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

trait DetailedReactHTMLElement[P /* <: HTMLAttributes[T] */, T /* <: HTMLElement */]
  extends StObject
     with DOMElement[P, T] {
  
  @JSName("type")
  var type_DetailedReactHTMLElement: /* import warning: LimitUnionLength.leaveTypeRef Was union type with length 115 */ String
}
object DetailedReactHTMLElement {
  
  inline def apply[P /* <: HTMLAttributes[T] */, T /* <: HTMLElement */](
    props: js.Any,
    `type`: /* import warning: LimitUnionLength.leaveTypeRef Was union type with length 115 */ String
  ): DetailedReactHTMLElement[P, T] = {
    val __obj = js.Dynamic.literal(props = props.asInstanceOf[js.Any], key = null, ref = null)
    __obj.updateDynamic("type")(`type`.asInstanceOf[js.Any])
    __obj.asInstanceOf[DetailedReactHTMLElement[P, T]]
  }
  
  extension [Self <: DetailedReactHTMLElement[?, ?], P /* <: HTMLAttributes[T] */, T /* <: HTMLElement */](x: Self & (DetailedReactHTMLElement[P, T])) {
    
    inline def setType(value: /* import warning: LimitUnionLength.leaveTypeRef Was union type with length 115 */ String): Self = StObject.set(x, "type", value.asInstanceOf[js.Any])
  }
}
