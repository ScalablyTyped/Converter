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
  @scala.inline
  implicit class HTMLAttributesOps[Self[t] <: HTMLAttributes[t], T] (val x: Self[T]) extends AnyVal {
    @scala.inline
    def duplicate: Self[T] = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x)).asInstanceOf[Self[T]]
    @scala.inline
    def combineWith[Other /* <: js.Any */](other: Other): Self[T] with Other = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x, other.asInstanceOf[js.Any])).asInstanceOf[Self[T] with Other]
    @scala.inline
    def withDefaultChecked(defaultChecked: js.UndefOr[Boolean]): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (!js.isUndefined(defaultChecked)) ret.updateDynamic("defaultChecked")(defaultChecked.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withoutDefaultChecked: Self[T] = {
        val ret = this.duplicate
        js.special.delete(ret, "defaultChecked")
        ret.asInstanceOf[Self[T]]
    }
  }
  
}

