package typingsSlinky.react.mod

import org.scalajs.dom.HTMLElement
import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

trait DetailedReactHTMLElement[P /* <: HTMLAttributes[T] */, T /* <: HTMLElement */]
  extends StObject
     with DOMElement[P, T] {
  
  @JSName("type")
  var type_DetailedReactHTMLElement: /* import warning: LimitUnionLength.leaveTypeRef Was union type with length 115, starting with "a", "abbr", "address" */ String
}
object DetailedReactHTMLElement {
  
  inline def apply[P /* <: HTMLAttributes[T] */, T /* <: HTMLElement */](
    props: Any,
    `type`: /* import warning: LimitUnionLength.leaveTypeRef Was union type with length 115, starting with "a", "abbr", "address" */ String
  ): DetailedReactHTMLElement[P, T] = {
    val __obj = js.Dynamic.literal(props = props.asInstanceOf[js.Any], key = null, ref = null)
    __obj.updateDynamic("type")(`type`.asInstanceOf[js.Any])
    __obj.asInstanceOf[DetailedReactHTMLElement[P, T]]
  }
  
  @scala.inline
  implicit open class MutableBuilder[Self <: DetailedReactHTMLElement[?, ?], P /* <: HTMLAttributes[T] */, T /* <: HTMLElement */] (val x: Self & (DetailedReactHTMLElement[P, T])) extends AnyVal {
    
    inline def setType(
      value: /* import warning: LimitUnionLength.leaveTypeRef Was union type with length 115, starting with "a", "abbr", "address" */ String
    ): Self = StObject.set(x, "type", value.asInstanceOf[js.Any])
  }
}
