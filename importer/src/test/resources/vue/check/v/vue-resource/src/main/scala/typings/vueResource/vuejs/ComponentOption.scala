package typings.vueResource.vuejs

import typings.vueResource.headersHttpHeaderskeystringanyHttpOptionsDictkeyBefore
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@js.native
trait ComponentOption extends js.Object {
  var http: js.UndefOr[headersHttpHeaderskeystringanyHttpOptionsDictkeyBefore] = js.native
}

object ComponentOption {
  @scala.inline
  def apply(http: headersHttpHeaderskeystringanyHttpOptionsDictkeyBefore = null): ComponentOption = {
    val __obj = js.Dynamic.literal()
    if (http != null) __obj.updateDynamic("http")(http.asInstanceOf[js.Any])
    __obj.asInstanceOf[ComponentOption]
  }
}

