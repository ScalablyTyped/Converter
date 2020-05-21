package typingsSlinky.react.mod

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@js.native
trait InsHTMLAttributes[T] extends HTMLAttributes[T] {
  var cite: js.UndefOr[String] = js.native
  var dateTime: js.UndefOr[String] = js.native
}

object InsHTMLAttributes {
  @scala.inline
  def apply[T](): InsHTMLAttributes[T] = {
    val __obj = js.Dynamic.literal()
    __obj.asInstanceOf[InsHTMLAttributes[T]]
  }
  @scala.inline
  implicit class InsHTMLAttributesOps[Self <: InsHTMLAttributes[_], T] (val x: Self with InsHTMLAttributes[T]) extends AnyVal {
    @scala.inline
    def duplicate: Self = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x)).asInstanceOf[Self]
    @scala.inline
    def combineWith[Other <: js.Any](other: Other): Self with Other = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x, other.asInstanceOf[js.Any])).asInstanceOf[Self with Other]
    @scala.inline
    def withCite(value: String): Self = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("cite")(value.asInstanceOf[js.Any])
        ret
    }
    @scala.inline
    def withoutCite: Self = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("cite")(js.undefined)
        ret
    }
    @scala.inline
    def withDateTime(value: String): Self = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("dateTime")(value.asInstanceOf[js.Any])
        ret
    }
    @scala.inline
    def withoutDateTime: Self = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("dateTime")(js.undefined)
        ret
    }
  }
  
}

