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
  def apply[T](children: VdomNode = null, dangerouslySetInnerHTML: Html = null): DOMAttributes[T] = {
    val __obj = js.Dynamic.literal()
    if (children != null) __obj.updateDynamic("children")(children.rawNode.asInstanceOf[js.Any])
    if (dangerouslySetInnerHTML != null) __obj.updateDynamic("dangerouslySetInnerHTML")(dangerouslySetInnerHTML.asInstanceOf[js.Any])
    __obj.asInstanceOf[DOMAttributes[T]]
  }
}
