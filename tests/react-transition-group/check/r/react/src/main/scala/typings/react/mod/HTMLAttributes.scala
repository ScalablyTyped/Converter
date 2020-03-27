package typings.react.mod

import typings.react.AnonHtml
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@js.native
trait HTMLAttributes[T] extends DOMAttributes[T] {
  var defaultChecked: js.UndefOr[Boolean] = js.native
}

object HTMLAttributes {
  @scala.inline
  def apply[T](
    children: ReactNode = null,
    dangerouslySetInnerHTML: AnonHtml = null,
    defaultChecked: js.UndefOr[Boolean] = js.undefined
  ): HTMLAttributes[T] = {
    val __obj = js.Dynamic.literal()
    if (children != null) __obj.updateDynamic("children")(children.asInstanceOf[js.Any])
    if (dangerouslySetInnerHTML != null) __obj.updateDynamic("dangerouslySetInnerHTML")(dangerouslySetInnerHTML.asInstanceOf[js.Any])
    if (!js.isUndefined(defaultChecked)) __obj.updateDynamic("defaultChecked")(defaultChecked.asInstanceOf[js.Any])
    __obj.asInstanceOf[HTMLAttributes[T]]
  }
}

