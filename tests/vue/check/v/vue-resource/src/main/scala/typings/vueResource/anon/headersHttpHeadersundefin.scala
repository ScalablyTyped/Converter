package typings.vueResource.anon

import org.scalablytyped.runtime.StringDictionary
import typings.vueResource.vuejs.HttpHeaders
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

/* Inlined {  headers :vue-resource.vuejs.HttpHeaders | undefined, [key: string] : any} & vue-resource.vuejs.HttpOptions */
@js.native
trait headersHttpHeadersundefin
  extends /* key */ StringDictionary[js.Any] {
  
  var before: js.UndefOr[js.Function1[/* request */ js.Any, _]] = js.native
  
  var body: js.UndefOr[js.Any] = js.native
  
  var credentials: js.UndefOr[Boolean] = js.native
  
  var emulateHTTP: js.UndefOr[Boolean] = js.native
  
  var emulateJSON: js.UndefOr[Boolean] = js.native
  
  var headers: js.UndefOr[HttpHeaders] with js.UndefOr[js.Any] = js.native
  
  var method: js.UndefOr[String] = js.native
  
  var params: js.UndefOr[js.Any] = js.native
  
  var progress: js.UndefOr[js.Function1[/* event */ js.Any, _]] = js.native
  
  var url: js.UndefOr[String] = js.native
}
object headersHttpHeadersundefin {
  
  @scala.inline
  def apply(headers: js.UndefOr[HttpHeaders] with js.UndefOr[js.Any]): headersHttpHeadersundefin = {
    val __obj = js.Dynamic.literal(headers = headers.asInstanceOf[js.Any])
    __obj.asInstanceOf[headersHttpHeadersundefin]
  }
  
  @scala.inline
  implicit class headersHttpHeadersundefinOps[Self <: headersHttpHeadersundefin] (val x: Self) extends AnyVal {
    
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
    def setHeaders(value: js.UndefOr[HttpHeaders] with js.UndefOr[js.Any]): Self = this.set("headers", value.asInstanceOf[js.Any])
    
    @scala.inline
    def setBefore(value: /* request */ js.Any => _): Self = this.set("before", js.Any.fromFunction1(value))
    
    @scala.inline
    def deleteBefore: Self = this.set("before", js.undefined)
    
    @scala.inline
    def setBody(value: js.Any): Self = this.set("body", value.asInstanceOf[js.Any])
    
    @scala.inline
    def deleteBody: Self = this.set("body", js.undefined)
    
    @scala.inline
    def setCredentials(value: Boolean): Self = this.set("credentials", value.asInstanceOf[js.Any])
    
    @scala.inline
    def deleteCredentials: Self = this.set("credentials", js.undefined)
    
    @scala.inline
    def setEmulateHTTP(value: Boolean): Self = this.set("emulateHTTP", value.asInstanceOf[js.Any])
    
    @scala.inline
    def deleteEmulateHTTP: Self = this.set("emulateHTTP", js.undefined)
    
    @scala.inline
    def setEmulateJSON(value: Boolean): Self = this.set("emulateJSON", value.asInstanceOf[js.Any])
    
    @scala.inline
    def deleteEmulateJSON: Self = this.set("emulateJSON", js.undefined)
    
    @scala.inline
    def setMethod(value: String): Self = this.set("method", value.asInstanceOf[js.Any])
    
    @scala.inline
    def deleteMethod: Self = this.set("method", js.undefined)
    
    @scala.inline
    def setParams(value: js.Any): Self = this.set("params", value.asInstanceOf[js.Any])
    
    @scala.inline
    def deleteParams: Self = this.set("params", js.undefined)
    
    @scala.inline
    def setProgress(value: /* event */ js.Any => _): Self = this.set("progress", js.Any.fromFunction1(value))
    
    @scala.inline
    def deleteProgress: Self = this.set("progress", js.undefined)
    
    @scala.inline
    def setUrl(value: String): Self = this.set("url", value.asInstanceOf[js.Any])
    
    @scala.inline
    def deleteUrl: Self = this.set("url", js.undefined)
  }
}
