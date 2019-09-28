package typings.react.reactMod

import scala.scalajs.js.annotation.ScalaJSDefined
import typings.react.Anon_Html
import scala.scalajs.js
import scala.scalajs.js.`|`

trait SVGAttributes[T] extends DOMAttributes[T] {
  // Attributes which also defined in HTMLAttributes
  // See comment in SVGDOMPropertyConfig.js
  var className: js.UndefOr[String] = js.undefined
  var color: js.UndefOr[String] = js.undefined
  var height: js.UndefOr[Double | String] = js.undefined
}

object SVGAttributes {
  @inline
  def apply[T](
    children: ReactNode = null,
    className: String = null,
    color: String = null,
    dangerouslySetInnerHTML: Anon_Html = null,
    height: Double | String = null
  ): SVGAttributes[T] = {
    val __obj = js.Dynamic.literal()
    if (children != null) __obj.updateDynamic("children")(children.asInstanceOf[js.Any])
    if (className != null) __obj.updateDynamic("className")(className)
    if (color != null) __obj.updateDynamic("color")(color)
    if (dangerouslySetInnerHTML != null) __obj.updateDynamic("dangerouslySetInnerHTML")(dangerouslySetInnerHTML)
    if (height != null) __obj.updateDynamic("height")(height.asInstanceOf[js.Any])
    __obj.asInstanceOf[SVGAttributes[T]]
  }
}

