package typings.vueDashResource.vuejs

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@js.native
trait VueStatic extends js.Object {
  var http: Http = js.native
  var resource: Resource = js.native
}

object VueStatic {
  @scala.inline
  def apply(http: Http, resource: Resource): VueStatic = {
    val __obj = js.Dynamic.literal(http = http.asInstanceOf[js.Any], resource = resource.asInstanceOf[js.Any])
  
    __obj.asInstanceOf[VueStatic]
  }
}

