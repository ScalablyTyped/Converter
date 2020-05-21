package typings.react.mod

import typings.react.AnonHtml
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@js.native
trait SVGAttributes[T] extends DOMAttributes[T] {
  // Attributes which also defined in HTMLAttributes
  // See comment in SVGDOMPropertyConfig.js
  var className: js.UndefOr[String] = js.native
  var color: js.UndefOr[String] = js.native
  var height: js.UndefOr[Double | String] = js.native
}

object SVGAttributes {
  @scala.inline
  def apply[T](
    children: ReactNode = null,
    className: String = null,
    color: String = null,
    dangerouslySetInnerHTML: AnonHtml = null,
    height: Double | String = null
  ): SVGAttributes[T] = {
    val __obj = js.Dynamic.literal()
    if (children != null) __obj.updateDynamic("children")(children.asInstanceOf[js.Any])
    if (className != null) __obj.updateDynamic("className")(className.asInstanceOf[js.Any])
    if (color != null) __obj.updateDynamic("color")(color.asInstanceOf[js.Any])
    if (dangerouslySetInnerHTML != null) __obj.updateDynamic("dangerouslySetInnerHTML")(dangerouslySetInnerHTML.asInstanceOf[js.Any])
    if (height != null) __obj.updateDynamic("height")(height.asInstanceOf[js.Any])
    __obj.asInstanceOf[SVGAttributes[T]]
  }
  @scala.inline
  implicit class SVGAttributesOps[Self[t] <: SVGAttributes[t], T] (val x: Self[T]) extends AnyVal {
    @scala.inline
    def duplicate: Self[T] = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x)).asInstanceOf[Self[T]]
    @scala.inline
    def combineWith[Other /* <: js.Any */](other: Other): Self[T] with Other = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x, other.asInstanceOf[js.Any])).asInstanceOf[Self[T] with Other]
    @scala.inline
    def withClassName(className: String): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (className != null) ret.updateDynamic("className")(className.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withoutClassName: Self[T] = {
        val ret = this.duplicate
        js.special.delete(ret, "className")
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withColor(color: String): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (color != null) ret.updateDynamic("color")(color.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withoutColor: Self[T] = {
        val ret = this.duplicate
        js.special.delete(ret, "color")
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withHeight(height: Double | String): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (height != null) ret.updateDynamic("height")(height.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withoutHeight: Self[T] = {
        val ret = this.duplicate
        js.special.delete(ret, "height")
        ret.asInstanceOf[Self[T]]
    }
  }
  
}

