package typingsJapgolly.react.mod

import japgolly.scalajs.react.raw.React.Node
import japgolly.scalajs.react.vdom.VdomNode
import typingsJapgolly.react.anon.Html
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

@js.native
trait DOMAttributes[T] extends js.Object {
  
  var children: js.UndefOr[Node] = js.native
  
  var dangerouslySetInnerHTML: js.UndefOr[Html] = js.native
}
object DOMAttributes {
  
  @scala.inline
  def apply[T](): DOMAttributes[T] = {
    val __obj = js.Dynamic.literal()
    __obj.asInstanceOf[DOMAttributes[T]]
  }
  
  @scala.inline
  implicit class DOMAttributesOps[Self <: DOMAttributes[_], T] (val x: Self with DOMAttributes[T]) extends AnyVal {
    
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
    def setChildren(value: VdomNode): Self = this.set("children", value.rawNode.asInstanceOf[js.Any])
    
    @scala.inline
    def deleteChildren: Self = this.set("children", js.undefined)
    
    @scala.inline
    def setDangerouslySetInnerHTML(value: Html): Self = this.set("dangerouslySetInnerHTML", value.asInstanceOf[js.Any])
    
    @scala.inline
    def deleteDangerouslySetInnerHTML: Self = this.set("dangerouslySetInnerHTML", js.undefined)
  }
}
