package typingsSlinky.react.mod

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@js.native
trait BlockquoteHTMLAttributes[T] extends HTMLAttributes[T] {
  var cite: js.UndefOr[String] = js.native
}

object BlockquoteHTMLAttributes {
  @scala.inline
  def apply[T](): BlockquoteHTMLAttributes[T] = {
    val __obj = js.Dynamic.literal()
    __obj.asInstanceOf[BlockquoteHTMLAttributes[T]]
  }
  @scala.inline
  implicit class BlockquoteHTMLAttributesOps[Self <: BlockquoteHTMLAttributes[_], T] (val x: Self with BlockquoteHTMLAttributes[T]) extends AnyVal {
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
  }
  
}

