package typingsSlinky.react.mod

import typingsSlinky.react.reactStrings.center
import typingsSlinky.react.reactStrings.char
import typingsSlinky.react.reactStrings.justify
import typingsSlinky.react.reactStrings.left
import typingsSlinky.react.reactStrings.right
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@js.native
trait ThHTMLAttributes[T] extends HTMLAttributes[T] {
  var align: js.UndefOr[left | center | right | justify | char] = js.native
  var colSpan: js.UndefOr[Double] = js.native
  var headers: js.UndefOr[String] = js.native
  var rowSpan: js.UndefOr[Double] = js.native
  var scope: js.UndefOr[String] = js.native
}

object ThHTMLAttributes {
  @scala.inline
  def apply[T](): ThHTMLAttributes[T] = {
    val __obj = js.Dynamic.literal()
    __obj.asInstanceOf[ThHTMLAttributes[T]]
  }
  @scala.inline
  implicit class ThHTMLAttributesOps[Self[t] <: ThHTMLAttributes[t], T] (val x: Self[T]) extends AnyVal {
    @scala.inline
    def duplicate: Self[T] = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x)).asInstanceOf[Self[T]]
    @scala.inline
    def combineWith[Other /* <: js.Any */](other: Other): Self[T] with Other = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x, other.asInstanceOf[js.Any])).asInstanceOf[Self[T] with Other]
    @scala.inline
    def withAlign(value: left | center | right | justify | char): Self[T] = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("align")(value.asInstanceOf[js.Any])
        ret
    }
    @scala.inline
    def withoutAlign: Self[T] = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("align")(js.undefined)
        ret
    }
    @scala.inline
    def withColSpan(value: Double): Self[T] = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("colSpan")(value.asInstanceOf[js.Any])
        ret
    }
    @scala.inline
    def withoutColSpan: Self[T] = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("colSpan")(js.undefined)
        ret
    }
    @scala.inline
    def withHeaders(value: String): Self[T] = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("headers")(value.asInstanceOf[js.Any])
        ret
    }
    @scala.inline
    def withoutHeaders: Self[T] = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("headers")(js.undefined)
        ret
    }
    @scala.inline
    def withRowSpan(value: Double): Self[T] = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("rowSpan")(value.asInstanceOf[js.Any])
        ret
    }
    @scala.inline
    def withoutRowSpan: Self[T] = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("rowSpan")(js.undefined)
        ret
    }
    @scala.inline
    def withScope(value: String): Self[T] = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("scope")(value.asInstanceOf[js.Any])
        ret
    }
    @scala.inline
    def withoutScope: Self[T] = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("scope")(js.undefined)
        ret
    }
  }
  
}

