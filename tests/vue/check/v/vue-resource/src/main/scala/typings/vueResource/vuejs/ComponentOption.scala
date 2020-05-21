package typings.vueResource.vuejs

import typings.vueResource.headersHttpHeaderskeystri
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@js.native
trait ComponentOption extends js.Object {
  var http: js.UndefOr[headersHttpHeaderskeystri] = js.native
}

object ComponentOption {
  @scala.inline
  def apply(http: headersHttpHeaderskeystri = null): ComponentOption = {
    val __obj = js.Dynamic.literal()
    if (http != null) __obj.updateDynamic("http")(http.asInstanceOf[js.Any])
    __obj.asInstanceOf[ComponentOption]
  }
  @scala.inline
  implicit class ComponentOptionOps[Self <: ComponentOption] (val x: Self) extends AnyVal {
    @scala.inline
    def duplicate: Self = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x)).asInstanceOf[Self]
    @scala.inline
    def combineWith[Other /* <: js.Any */](other: Other): Self with Other = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x, other.asInstanceOf[js.Any])).asInstanceOf[Self with Other]
    @scala.inline
    def withHttp(http: headersHttpHeaderskeystri): Self = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (http != null) ret.updateDynamic("http")(http.asInstanceOf[js.Any])
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withoutHttp: Self = {
        val ret = this.duplicate
        js.special.delete(ret, "http")
        ret.asInstanceOf[Self]
    }
  }
  
}

