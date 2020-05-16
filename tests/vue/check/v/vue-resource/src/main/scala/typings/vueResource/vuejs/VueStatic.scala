package typings.vueResource.vuejs

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@js.native
trait VueStatic extends js.Object {
  var http: Http_ = js.native
  var resource: Resource_ = js.native
}

object VueStatic {
  @scala.inline
  def apply(http: Http_, resource: Resource_): VueStatic = {
    val __obj = js.Dynamic.literal(http = http.asInstanceOf[js.Any], resource = resource.asInstanceOf[js.Any])
    __obj.asInstanceOf[VueStatic]
  }
  @scala.inline
  implicit class VueStaticOps[Self <: VueStatic] (val x: Self) extends AnyVal {
    @scala.inline
    def duplicate: Self = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x)).asInstanceOf[Self]
    @scala.inline
    def combineWith[Other /* <: js.Any */](other: Other): Self with Other = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x, other.asInstanceOf[js.Any])).asInstanceOf[Self with Other]
    @scala.inline
    def withHttp(http: Http_): Self = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        ret.updateDynamic("http")(http.asInstanceOf[js.Any])
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withResource(resource: Resource_): Self = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        ret.updateDynamic("resource")(resource.asInstanceOf[js.Any])
        ret.asInstanceOf[Self]
    }
  }
  
}

