package typings.react.mod

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@js.native
trait TableHTMLAttributes[T] extends HTMLAttributes[T] {
  var cellPadding: js.UndefOr[Double | String] = js.native
  var cellSpacing: js.UndefOr[Double | String] = js.native
  var summary: js.UndefOr[String] = js.native
}

object TableHTMLAttributes {
  @scala.inline
  def apply[T](): TableHTMLAttributes[T] = {
    val __obj = js.Dynamic.literal()
    __obj.asInstanceOf[TableHTMLAttributes[T]]
  }
  @scala.inline
  implicit class TableHTMLAttributesOps[Self <: TableHTMLAttributes[_], T] (val x: Self with TableHTMLAttributes[T]) extends AnyVal {
    @scala.inline
    def duplicate: Self = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x)).asInstanceOf[Self]
    @scala.inline
    def combineWith[Other <: js.Any](other: Other): Self with Other = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x, other.asInstanceOf[js.Any])).asInstanceOf[Self with Other]
    @scala.inline
    def withCellPadding(value: Double | String): Self = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("cellPadding")(value.asInstanceOf[js.Any])
        ret
    }
    @scala.inline
    def withoutCellPadding: Self = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("cellPadding")(js.undefined)
        ret
    }
    @scala.inline
    def withCellSpacing(value: Double | String): Self = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("cellSpacing")(value.asInstanceOf[js.Any])
        ret
    }
    @scala.inline
    def withoutCellSpacing: Self = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("cellSpacing")(js.undefined)
        ret
    }
    @scala.inline
    def withSummary(value: String): Self = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("summary")(value.asInstanceOf[js.Any])
        ret
    }
    @scala.inline
    def withoutSummary: Self = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("summary")(js.undefined)
        ret
    }
  }
  
}

