package typings.vueResource.vuejs

import typings.vueResource.anon.headersHttpHeadersundefin
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

@js.native
trait ComponentOption extends js.Object {
  var http: js.UndefOr[headersHttpHeadersundefin] = js.native
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
    def combineWith[Other <: js.Any](other: Other): Self with Other = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x, other.asInstanceOf[js.Any])).asInstanceOf[Self with Other]
    @scala.inline
    def set(key: String, value: js.Any): Self = {
        x.asInstanceOf[js.Dynamic].updateDynamic(key)(value)
        x
    }
    @scala.inline
    def setHttp(value: headersHttpHeadersundefin): Self = this.set("http", value.asInstanceOf[js.Any])
    @scala.inline
    def deleteHttp: Self = this.set("http", js.undefined)
  }
  
}

