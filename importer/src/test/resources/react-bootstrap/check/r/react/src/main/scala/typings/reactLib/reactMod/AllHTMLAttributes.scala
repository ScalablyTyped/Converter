package typings
package reactLib.reactMod

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

trait AllHTMLAttributes[T] extends HTMLAttributes[T] {
  var accept: js.UndefOr[java.lang.String] = js.undefined
  var acceptCharset: js.UndefOr[java.lang.String] = js.undefined
}

object AllHTMLAttributes {
  @scala.inline
  def apply[T](
    accept: java.lang.String = null,
    acceptCharset: java.lang.String = null,
    children: ReactNode = null,
    dangerouslySetInnerHTML: reactLib.Anon_Html = null,
    defaultChecked: js.UndefOr[scala.Boolean] = js.undefined
  ): AllHTMLAttributes[T] = {
    val __obj = js.Dynamic.literal()
    if (accept != null) __obj.updateDynamic("accept")(accept)
    if (acceptCharset != null) __obj.updateDynamic("acceptCharset")(acceptCharset)
    if (children != null) __obj.updateDynamic("children")(children.asInstanceOf[js.Any])
    if (dangerouslySetInnerHTML != null) __obj.updateDynamic("dangerouslySetInnerHTML")(dangerouslySetInnerHTML)
    if (!js.isUndefined(defaultChecked)) __obj.updateDynamic("defaultChecked")(defaultChecked)
    __obj.asInstanceOf[AllHTMLAttributes[T]]
  }
}

