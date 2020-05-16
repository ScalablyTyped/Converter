package typingsSlinky.react.mod

import slinky.core.TagMod
import typingsSlinky.react.AnonHtml
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@js.native
trait AllHTMLAttributes[T] extends HTMLAttributes[T] {
  var accept: js.UndefOr[String] = js.native
  var acceptCharset: js.UndefOr[String] = js.native
}

object AllHTMLAttributes {
  @scala.inline
  def apply[T](
    accept: String = null,
    acceptCharset: String = null,
    children: TagMod[Any] = null,
    dangerouslySetInnerHTML: AnonHtml = null,
    defaultChecked: js.UndefOr[Boolean] = js.undefined
  ): AllHTMLAttributes[T] = {
    val __obj = js.Dynamic.literal()
    if (accept != null) __obj.updateDynamic("accept")(accept.asInstanceOf[js.Any])
    if (acceptCharset != null) __obj.updateDynamic("acceptCharset")(acceptCharset.asInstanceOf[js.Any])
    if (children != null) __obj.updateDynamic("children")(children.asInstanceOf[js.Any])
    if (dangerouslySetInnerHTML != null) __obj.updateDynamic("dangerouslySetInnerHTML")(dangerouslySetInnerHTML.asInstanceOf[js.Any])
    if (!js.isUndefined(defaultChecked)) __obj.updateDynamic("defaultChecked")(defaultChecked.asInstanceOf[js.Any])
    __obj.asInstanceOf[AllHTMLAttributes[T]]
  }
  @scala.inline
  implicit class AllHTMLAttributesOps[Self[t] <: AllHTMLAttributes[t], T] (val x: Self[T]) extends AnyVal {
    @scala.inline
    def duplicate: Self[T] = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x)).asInstanceOf[Self[T]]
    @scala.inline
    def combineWith[Other /* <: js.Any */](other: Other): Self[T] with Other = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x, other.asInstanceOf[js.Any])).asInstanceOf[Self[T] with Other]
    @scala.inline
    def withAccept(accept: String): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (accept != null) ret.updateDynamic("accept")(accept.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withoutAccept: Self[T] = {
        val ret = this.duplicate
        js.special.delete(ret, "accept")
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withAcceptCharset(acceptCharset: String): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (acceptCharset != null) ret.updateDynamic("acceptCharset")(acceptCharset.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withoutAcceptCharset: Self[T] = {
        val ret = this.duplicate
        js.special.delete(ret, "acceptCharset")
        ret.asInstanceOf[Self[T]]
    }
  }
  
}

