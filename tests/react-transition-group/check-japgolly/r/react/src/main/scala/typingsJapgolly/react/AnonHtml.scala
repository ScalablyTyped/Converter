package typingsJapgolly.react

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@js.native
trait AnonHtml extends js.Object {
  var __html: String = js.native
}

object AnonHtml {
  @scala.inline
  def apply(__html: String): AnonHtml = {
    val __obj = js.Dynamic.literal(__html = __html.asInstanceOf[js.Any])
    __obj.asInstanceOf[AnonHtml]
  }
  @scala.inline
  implicit class AnonHtmlOps[Self <: AnonHtml] (val x: Self) extends AnyVal {
    @scala.inline
    def duplicate: Self = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x)).asInstanceOf[Self]
    @scala.inline
    def combineWith[Other <: js.Any](other: Other): Self with Other = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x, other.asInstanceOf[js.Any])).asInstanceOf[Self with Other]
    @scala.inline
    def with__html(value: String): Self = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("__html")(value.asInstanceOf[js.Any])
        ret
    }
  }
  
}

