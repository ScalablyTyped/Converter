package typings
package reactLib.reactMod.ReactNs

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

trait DOMAttributes[T] extends js.Object {
  var children: js.UndefOr[ReactNode] = js.undefined
  var dangerouslySetInnerHTML: js.UndefOr[reactLib.Anon_Html] = js.undefined
}

object DOMAttributes {
  @scala.inline
  def apply[T](children: ReactNode = null, dangerouslySetInnerHTML: reactLib.Anon_Html = null): DOMAttributes[T] = {
    val __obj = js.Dynamic.literal()
    if (children != null) __obj.updateDynamic("children")(children.asInstanceOf[js.Any])
    if (dangerouslySetInnerHTML != null) __obj.updateDynamic("dangerouslySetInnerHTML")(dangerouslySetInnerHTML)
    __obj.asInstanceOf[DOMAttributes[T]]
  }
}

