package typings.vueResource.vuejs

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

@js.native
trait HttpInterceptor extends js.Object {
  
  var request: js.UndefOr[js.Function1[/* request */ HttpOptions, HttpOptions]] = js.native
  
  var response: js.UndefOr[js.Function1[/* response */ HttpResponse, HttpResponse]] = js.native
}
object HttpInterceptor {
  
  @scala.inline
  def apply(): HttpInterceptor = {
    val __obj = js.Dynamic.literal()
    __obj.asInstanceOf[HttpInterceptor]
  }
  
  @scala.inline
  implicit class HttpInterceptorOps[Self <: HttpInterceptor] (val x: Self) extends AnyVal {
    
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
    def setRequest(value: /* request */ HttpOptions => HttpOptions): Self = this.set("request", js.Any.fromFunction1(value))
    
    @scala.inline
    def deleteRequest: Self = this.set("request", js.undefined)
    
    @scala.inline
    def setResponse(value: /* response */ HttpResponse => HttpResponse): Self = this.set("response", js.Any.fromFunction1(value))
    
    @scala.inline
    def deleteResponse: Self = this.set("response", js.undefined)
  }
}
