package typingsJapgolly.react.mod

import japgolly.scalajs.react.vdom.VdomNode
import typingsJapgolly.react.anon.Html
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

@js.native
trait HTMLAttributes[T] extends DOMAttributes[T] {
  
  var defaultChecked: js.UndefOr[Boolean] = js.native
}
object HTMLAttributes {
  
  @scala.inline
  def apply[T](
    children: VdomNode = null,
    dangerouslySetInnerHTML: Html = null,
    defaultChecked: js.UndefOr[Boolean] = js.undefined
  ): HTMLAttributes[T] = {
    val __obj = js.Dynamic.literal()
    if (children != null) __obj.updateDynamic("children")(children.rawNode.asInstanceOf[js.Any])
    if (dangerouslySetInnerHTML != null) __obj.updateDynamic("dangerouslySetInnerHTML")(dangerouslySetInnerHTML.asInstanceOf[js.Any])
    if (!js.isUndefined(defaultChecked)) __obj.updateDynamic("defaultChecked")(defaultChecked.get.asInstanceOf[js.Any])
    __obj.asInstanceOf[HTMLAttributes[T]]
  }
}
