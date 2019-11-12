package typings.react.reactMod

import japgolly.scalajs.react.raw.React.Node
import typings.react.Anon_Html
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

trait DOMAttributes[T] extends js.Object {
  var children: js.UndefOr[Node] = js.undefined
  var dangerouslySetInnerHTML: js.UndefOr[Anon_Html] = js.undefined
}

object DOMAttributes {
  @scala.inline
  def apply[T](children: Node = null, dangerouslySetInnerHTML: Anon_Html = null): DOMAttributes[T] = {
    val __obj = js.Dynamic.literal()
    if (children != null) __obj.updateDynamic("children")(children.asInstanceOf[js.Any])
    if (dangerouslySetInnerHTML != null) __obj.updateDynamic("dangerouslySetInnerHTML")(dangerouslySetInnerHTML)
    __obj.asInstanceOf[DOMAttributes[T]]
  }
}

