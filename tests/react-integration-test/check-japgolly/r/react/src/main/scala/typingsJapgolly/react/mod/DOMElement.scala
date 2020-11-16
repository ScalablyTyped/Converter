package typingsJapgolly.react.mod

import japgolly.scalajs.react.Callback
import japgolly.scalajs.react.raw.React.DomElement
import japgolly.scalajs.react.raw.React.RefHandle
import org.scalajs.dom.raw.Element
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

// string fallback for custom web-components
@js.native
trait DOMElement[P /* <: HTMLAttributes[T] | SVGAttributes[T] */, T /* <: Element */] extends ReactElement {
  
  var ref: LegacyRef[T] = js.native
}
object DOMElement {
  
  @scala.inline
  def apply[P /* <: HTMLAttributes[T] | SVGAttributes[T] */, T /* <: Element */](props: js.Any, `type`: js.Any): DOMElement[P, T] = {
    val __obj = js.Dynamic.literal(props = props.asInstanceOf[js.Any])
    __obj.updateDynamic("type")(`type`.asInstanceOf[js.Any])
    __obj.asInstanceOf[DOMElement[P, T]]
  }
  
  @scala.inline
  implicit class DOMElementOps[Self <: DomElement, P /* <: HTMLAttributes[T] | SVGAttributes[T] */, T /* <: Element */] (val x: Self with DomElement) extends AnyVal {
    
    @scala.inline
    def duplicate: Self = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x)).asInstanceOf[Self]
    
    @scala.inline
    def combineWith[Other <: js.Any](other: Other): Self with Other = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x, other.asInstanceOf[js.Any])).asInstanceOf[Self with Other]
    
    @scala.inline
    def set(key: String, value: js.Any): Self = {
      x.asInstanceOf[js.Dynamic].updateDynamic(key)(value)
      x
    }
    
    @scala.inline
    def setRefRefObject(value: RefHandle[T]): Self = this.set("ref", value.asInstanceOf[js.Any])
    
    @scala.inline
    def setRefFunction1(value: /* instance */ T | Null => Callback): Self = this.set("ref", js.Any.fromFunction1((t0: /* instance */ T | Null) => value(t0).runNow()))
    
    @scala.inline
    def setRef(value: LegacyRef[T]): Self = this.set("ref", value.asInstanceOf[js.Any])
    
    @scala.inline
    def setRefNull: Self = this.set("ref", null)
  }
}
