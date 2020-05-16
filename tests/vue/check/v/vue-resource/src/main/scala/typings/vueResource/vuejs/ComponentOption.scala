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
  def apply(): ComponentOption = {
    val __obj = js.Dynamic.literal()
    __obj.asInstanceOf[ComponentOption]
  }
  @scala.inline
  implicit class ComponentOptionOps[Self <: ComponentOption] (val x: Self) extends AnyVal {
    @scala.inline
    def duplicate: Self = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x)).asInstanceOf[Self]
    @scala.inline
    def combineWith[Other /* <: js.Any */](other: Other): Self with Other = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x, other.asInstanceOf[js.Any])).asInstanceOf[Self with Other]
    @scala.inline
    def withHttp(value: headersHttpHeaderskeystri): Self = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("http")(value.asInstanceOf[js.Any])
        ret
    }
    @scala.inline
    def withoutHttp: Self = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("http")(js.undefined)
        ret
    }
  }
  
}

