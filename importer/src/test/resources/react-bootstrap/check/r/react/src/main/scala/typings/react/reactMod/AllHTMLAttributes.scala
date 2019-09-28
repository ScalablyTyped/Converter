package typings.react.reactMod

import scala.scalajs.js.annotation.ScalaJSDefined
import typings.react.Anon_Html
import scala.scalajs.js
import scala.scalajs.js.`|`

trait AllHTMLAttributes[T] extends HTMLAttributes[T] {
  var accept: js.UndefOr[String] = js.undefined
  var acceptCharset: js.UndefOr[String] = js.undefined
}

object AllHTMLAttributes {
  @inline
  def apply[T](
    accept: String = null,
    acceptCharset: String = null,
    children: ReactNode = null,
    dangerouslySetInnerHTML: Anon_Html = null,
    defaultChecked: js.UndefOr[Boolean] = js.undefined
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

