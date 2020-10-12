package typings.vueResource

import org.scalablytyped.runtime.StringDictionary
import typings.vueResource.vuejs.HttpHeaders
import typings.vueResource.vuejs.HttpOptions
import typings.vueResource.vuejs.HttpResponse
import typings.vueResource.vuejs.http
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

object anon {
  
  @js.native
  trait Call extends js.Object {
    
    def apply(options: HttpOptions): js.Thenable[HttpResponse] = js.native
    
    def delete(url: String): js.Thenable[HttpResponse] = js.native
    def delete(url: String, data: js.UndefOr[scala.Nothing], options: HttpOptions): js.Thenable[HttpResponse] = js.native
    def delete(url: String, data: js.Any): js.Thenable[HttpResponse] = js.native
    def delete(url: String, data: js.Any, options: HttpOptions): js.Thenable[HttpResponse] = js.native
    def delete(url: String, options: HttpOptions): js.Thenable[HttpResponse] = js.native
    @JSName("delete")
    var delete_Original: http = js.native
    
    def get(url: String): js.Thenable[HttpResponse] = js.native
    def get(url: String, data: js.UndefOr[scala.Nothing], options: HttpOptions): js.Thenable[HttpResponse] = js.native
    def get(url: String, data: js.Any): js.Thenable[HttpResponse] = js.native
    def get(url: String, data: js.Any, options: HttpOptions): js.Thenable[HttpResponse] = js.native
    def get(url: String, options: HttpOptions): js.Thenable[HttpResponse] = js.native
    @JSName("get")
    var get_Original: http = js.native
    
    def jsonp(url: String): js.Thenable[HttpResponse] = js.native
    def jsonp(url: String, data: js.UndefOr[scala.Nothing], options: HttpOptions): js.Thenable[HttpResponse] = js.native
    def jsonp(url: String, data: js.Any): js.Thenable[HttpResponse] = js.native
    def jsonp(url: String, data: js.Any, options: HttpOptions): js.Thenable[HttpResponse] = js.native
    def jsonp(url: String, options: HttpOptions): js.Thenable[HttpResponse] = js.native
    @JSName("jsonp")
    var jsonp_Original: http = js.native
    
    def patch(url: String): js.Thenable[HttpResponse] = js.native
    def patch(url: String, data: js.UndefOr[scala.Nothing], options: HttpOptions): js.Thenable[HttpResponse] = js.native
    def patch(url: String, data: js.Any): js.Thenable[HttpResponse] = js.native
    def patch(url: String, data: js.Any, options: HttpOptions): js.Thenable[HttpResponse] = js.native
    def patch(url: String, options: HttpOptions): js.Thenable[HttpResponse] = js.native
    @JSName("patch")
    var patch_Original: http = js.native
    
    def post(url: String): js.Thenable[HttpResponse] = js.native
    def post(url: String, data: js.UndefOr[scala.Nothing], options: HttpOptions): js.Thenable[HttpResponse] = js.native
    def post(url: String, data: js.Any): js.Thenable[HttpResponse] = js.native
    def post(url: String, data: js.Any, options: HttpOptions): js.Thenable[HttpResponse] = js.native
    def post(url: String, options: HttpOptions): js.Thenable[HttpResponse] = js.native
    @JSName("post")
    var post_Original: http = js.native
    
    def put(url: String): js.Thenable[HttpResponse] = js.native
    def put(url: String, data: js.UndefOr[scala.Nothing], options: HttpOptions): js.Thenable[HttpResponse] = js.native
    def put(url: String, data: js.Any): js.Thenable[HttpResponse] = js.native
    def put(url: String, data: js.Any, options: HttpOptions): js.Thenable[HttpResponse] = js.native
    def put(url: String, options: HttpOptions): js.Thenable[HttpResponse] = js.native
    @JSName("put")
    var put_Original: http = js.native
  }
  
  /* Inlined vue-resource.vuejs.HttpOptions & {  root :string} */
  @js.native
  trait HttpOptionsrootstring extends js.Object {
    
    var before: js.UndefOr[js.Function1[/* request */ js.Any, _]] = js.native
    
    var body: js.UndefOr[js.Any] = js.native
    
    var credentials: js.UndefOr[Boolean] = js.native
    
    var emulateHTTP: js.UndefOr[Boolean] = js.native
    
    var emulateJSON: js.UndefOr[Boolean] = js.native
    
    var headers: js.UndefOr[js.Any] = js.native
    
    var method: js.UndefOr[String] = js.native
    
    var params: js.UndefOr[js.Any] = js.native
    
    var progress: js.UndefOr[js.Function1[/* event */ js.Any, _]] = js.native
    
    var root: String = js.native
    
    var url: js.UndefOr[String] = js.native
  }
  object HttpOptionsrootstring {
    
    @scala.inline
    def apply(root: String): HttpOptionsrootstring = {
      val __obj = js.Dynamic.literal(root = root.asInstanceOf[js.Any])
      __obj.asInstanceOf[HttpOptionsrootstring]
    }
    
    @scala.inline
    implicit class HttpOptionsrootstringOps[Self <: HttpOptionsrootstring] (val x: Self) extends AnyVal {
      
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
      def setRoot(value: String): Self = this.set("root", value.asInstanceOf[js.Any])
      
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
      def setHeaders(value: js.Any): Self = this.set("headers", value.asInstanceOf[js.Any])
      
      @scala.inline
      def deleteHeaders: Self = this.set("headers", js.undefined)
      
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
  
  @js.native
  trait Method extends js.Object {
    
    var method: String = js.native
  }
  object Method {
    
    @scala.inline
    def apply(method: String): Method = {
      val __obj = js.Dynamic.literal(method = method.asInstanceOf[js.Any])
      __obj.asInstanceOf[Method]
    }
    
    @scala.inline
    implicit class MethodOps[Self <: Method] (val x: Self) extends AnyVal {
      
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
      def setMethod(value: String): Self = this.set("method", value.asInstanceOf[js.Any])
    }
  }
  
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
}
