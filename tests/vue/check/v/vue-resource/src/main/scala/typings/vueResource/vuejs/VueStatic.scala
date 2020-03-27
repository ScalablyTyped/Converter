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
}

