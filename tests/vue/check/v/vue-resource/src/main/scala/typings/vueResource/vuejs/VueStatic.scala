package typings.vueResource.vuejs

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

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
    def combineWith[Other <: js.Any](other: Other): Self with Other = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x, other.asInstanceOf[js.Any])).asInstanceOf[Self with Other]
    
    @scala.inline
    def set(key: String, value: js.Any): Self = {
      x.asInstanceOf[js.Dynamic].updateDynamic(key)(value)
      x
    }
    
    @scala.inline
    def setHttp(value: Http_): Self = this.set("http", value.asInstanceOf[js.Any])
    
    @scala.inline
    def setResource(value: Resource_): Self = this.set("resource", value.asInstanceOf[js.Any])
  }
}
