package typings.vueResource

import org.scalablytyped.runtime.StringDictionary
import typings.vueResource.vuejs.HttpHeaders
import typings.vueResource.vuejs.HttpOptions
import typings.vueResource.vuejs.HttpResponse
import typings.vueResource.vuejs.http
import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

object anon {
  
  @js.native
  trait Call extends StObject {
    
    def apply(options: HttpOptions): js.Thenable[HttpResponse] = js.native
    
    def delete(url: String): js.Thenable[HttpResponse] = js.native
    def delete(url: String, data: js.Any): js.Thenable[HttpResponse] = js.native
    def delete(url: String, data: js.Any, options: HttpOptions): js.Thenable[HttpResponse] = js.native
    def delete(url: String, data: Unit, options: HttpOptions): js.Thenable[HttpResponse] = js.native
    def delete(url: String, options: HttpOptions): js.Thenable[HttpResponse] = js.native
    @JSName("delete")
    var delete_Original: http = js.native
    
    def get(url: String): js.Thenable[HttpResponse] = js.native
    def get(url: String, data: js.Any): js.Thenable[HttpResponse] = js.native
    def get(url: String, data: js.Any, options: HttpOptions): js.Thenable[HttpResponse] = js.native
    def get(url: String, data: Unit, options: HttpOptions): js.Thenable[HttpResponse] = js.native
    def get(url: String, options: HttpOptions): js.Thenable[HttpResponse] = js.native
    @JSName("get")
    var get_Original: http = js.native
    
    def jsonp(url: String): js.Thenable[HttpResponse] = js.native
    def jsonp(url: String, data: js.Any): js.Thenable[HttpResponse] = js.native
    def jsonp(url: String, data: js.Any, options: HttpOptions): js.Thenable[HttpResponse] = js.native
    def jsonp(url: String, data: Unit, options: HttpOptions): js.Thenable[HttpResponse] = js.native
    def jsonp(url: String, options: HttpOptions): js.Thenable[HttpResponse] = js.native
    @JSName("jsonp")
    var jsonp_Original: http = js.native
    
    def patch(url: String): js.Thenable[HttpResponse] = js.native
    def patch(url: String, data: js.Any): js.Thenable[HttpResponse] = js.native
    def patch(url: String, data: js.Any, options: HttpOptions): js.Thenable[HttpResponse] = js.native
    def patch(url: String, data: Unit, options: HttpOptions): js.Thenable[HttpResponse] = js.native
    def patch(url: String, options: HttpOptions): js.Thenable[HttpResponse] = js.native
    @JSName("patch")
    var patch_Original: http = js.native
    
    def post(url: String): js.Thenable[HttpResponse] = js.native
    def post(url: String, data: js.Any): js.Thenable[HttpResponse] = js.native
    def post(url: String, data: js.Any, options: HttpOptions): js.Thenable[HttpResponse] = js.native
    def post(url: String, data: Unit, options: HttpOptions): js.Thenable[HttpResponse] = js.native
    def post(url: String, options: HttpOptions): js.Thenable[HttpResponse] = js.native
    @JSName("post")
    var post_Original: http = js.native
    
    def put(url: String): js.Thenable[HttpResponse] = js.native
    def put(url: String, data: js.Any): js.Thenable[HttpResponse] = js.native
    def put(url: String, data: js.Any, options: HttpOptions): js.Thenable[HttpResponse] = js.native
    def put(url: String, data: Unit, options: HttpOptions): js.Thenable[HttpResponse] = js.native
    def put(url: String, options: HttpOptions): js.Thenable[HttpResponse] = js.native
    @JSName("put")
    var put_Original: http = js.native
  }
  
  /* Inlined vue-resource.vuejs.HttpOptions & {  root :string} */
  @js.native
  trait HttpOptionsrootstring extends StObject {
    
    var before: js.UndefOr[js.Function1[/* request */ js.Any, js.Any]] = js.native
    
    var body: js.UndefOr[js.Any] = js.native
    
    var credentials: js.UndefOr[Boolean] = js.native
    
    var emulateHTTP: js.UndefOr[Boolean] = js.native
    
    var emulateJSON: js.UndefOr[Boolean] = js.native
    
    var headers: js.UndefOr[js.Any] = js.native
    
    var method: js.UndefOr[String] = js.native
    
    var params: js.UndefOr[js.Any] = js.native
    
    var progress: js.UndefOr[js.Function1[/* event */ js.Any, js.Any]] = js.native
    
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
    implicit class HttpOptionsrootstringMutableBuilder[Self <: HttpOptionsrootstring] (val x: Self) extends AnyVal {
      
      @scala.inline
      def setBefore(value: /* request */ js.Any => js.Any): Self = StObject.set(x, "before", js.Any.fromFunction1(value))
      
      @scala.inline
      def setBeforeUndefined: Self = StObject.set(x, "before", js.undefined)
      
      @scala.inline
      def setBody(value: js.Any): Self = StObject.set(x, "body", value.asInstanceOf[js.Any])
      
      @scala.inline
      def setBodyUndefined: Self = StObject.set(x, "body", js.undefined)
      
      @scala.inline
      def setCredentials(value: Boolean): Self = StObject.set(x, "credentials", value.asInstanceOf[js.Any])
      
      @scala.inline
      def setCredentialsUndefined: Self = StObject.set(x, "credentials", js.undefined)
      
      @scala.inline
      def setEmulateHTTP(value: Boolean): Self = StObject.set(x, "emulateHTTP", value.asInstanceOf[js.Any])
      
      @scala.inline
      def setEmulateHTTPUndefined: Self = StObject.set(x, "emulateHTTP", js.undefined)
      
      @scala.inline
      def setEmulateJSON(value: Boolean): Self = StObject.set(x, "emulateJSON", value.asInstanceOf[js.Any])
      
      @scala.inline
      def setEmulateJSONUndefined: Self = StObject.set(x, "emulateJSON", js.undefined)
      
      @scala.inline
      def setHeaders(value: js.Any): Self = StObject.set(x, "headers", value.asInstanceOf[js.Any])
      
      @scala.inline
      def setHeadersUndefined: Self = StObject.set(x, "headers", js.undefined)
      
      @scala.inline
      def setMethod(value: String): Self = StObject.set(x, "method", value.asInstanceOf[js.Any])
      
      @scala.inline
      def setMethodUndefined: Self = StObject.set(x, "method", js.undefined)
      
      @scala.inline
      def setParams(value: js.Any): Self = StObject.set(x, "params", value.asInstanceOf[js.Any])
      
      @scala.inline
      def setParamsUndefined: Self = StObject.set(x, "params", js.undefined)
      
      @scala.inline
      def setProgress(value: /* event */ js.Any => js.Any): Self = StObject.set(x, "progress", js.Any.fromFunction1(value))
      
      @scala.inline
      def setProgressUndefined: Self = StObject.set(x, "progress", js.undefined)
      
      @scala.inline
      def setRoot(value: String): Self = StObject.set(x, "root", value.asInstanceOf[js.Any])
      
      @scala.inline
      def setUrl(value: String): Self = StObject.set(x, "url", value.asInstanceOf[js.Any])
      
      @scala.inline
      def setUrlUndefined: Self = StObject.set(x, "url", js.undefined)
    }
  }
  
  @js.native
  trait Method extends StObject {
    
    var method: String = js.native
  }
  object Method {
    
    @scala.inline
    def apply(method: String): Method = {
      val __obj = js.Dynamic.literal(method = method.asInstanceOf[js.Any])
      __obj.asInstanceOf[Method]
    }
    
    @scala.inline
    implicit class MethodMutableBuilder[Self <: Method] (val x: Self) extends AnyVal {
      
      @scala.inline
      def setMethod(value: String): Self = StObject.set(x, "method", value.asInstanceOf[js.Any])
    }
  }
  
  /* Inlined {  headers :vue-resource.vuejs.HttpHeaders | undefined, [key: string] : any} & vue-resource.vuejs.HttpOptions */
  @js.native
  trait headersHttpHeadersundefin
    extends StObject
       with /* key */ StringDictionary[js.Any] {
    
    var before: js.UndefOr[js.Function1[/* request */ js.Any, js.Any]] = js.native
    
    var body: js.UndefOr[js.Any] = js.native
    
    var credentials: js.UndefOr[Boolean] = js.native
    
    var emulateHTTP: js.UndefOr[Boolean] = js.native
    
    var emulateJSON: js.UndefOr[Boolean] = js.native
    
    var headers: js.UndefOr[HttpHeaders] & js.UndefOr[js.Any] = js.native
    
    var method: js.UndefOr[String] = js.native
    
    var params: js.UndefOr[js.Any] = js.native
    
    var progress: js.UndefOr[js.Function1[/* event */ js.Any, js.Any]] = js.native
    
    var url: js.UndefOr[String] = js.native
  }
  object headersHttpHeadersundefin {
    
    @scala.inline
    def apply(headers: js.UndefOr[HttpHeaders] & js.UndefOr[js.Any]): headersHttpHeadersundefin = {
      val __obj = js.Dynamic.literal(headers = headers.asInstanceOf[js.Any])
      __obj.asInstanceOf[headersHttpHeadersundefin]
    }
    
    @scala.inline
    implicit class headersHttpHeadersundefinMutableBuilder[Self <: headersHttpHeadersundefin] (val x: Self) extends AnyVal {
      
      @scala.inline
      def setBefore(value: /* request */ js.Any => js.Any): Self = StObject.set(x, "before", js.Any.fromFunction1(value))
      
      @scala.inline
      def setBeforeUndefined: Self = StObject.set(x, "before", js.undefined)
      
      @scala.inline
      def setBody(value: js.Any): Self = StObject.set(x, "body", value.asInstanceOf[js.Any])
      
      @scala.inline
      def setBodyUndefined: Self = StObject.set(x, "body", js.undefined)
      
      @scala.inline
      def setCredentials(value: Boolean): Self = StObject.set(x, "credentials", value.asInstanceOf[js.Any])
      
      @scala.inline
      def setCredentialsUndefined: Self = StObject.set(x, "credentials", js.undefined)
      
      @scala.inline
      def setEmulateHTTP(value: Boolean): Self = StObject.set(x, "emulateHTTP", value.asInstanceOf[js.Any])
      
      @scala.inline
      def setEmulateHTTPUndefined: Self = StObject.set(x, "emulateHTTP", js.undefined)
      
      @scala.inline
      def setEmulateJSON(value: Boolean): Self = StObject.set(x, "emulateJSON", value.asInstanceOf[js.Any])
      
      @scala.inline
      def setEmulateJSONUndefined: Self = StObject.set(x, "emulateJSON", js.undefined)
      
      @scala.inline
      def setHeaders(value: js.UndefOr[HttpHeaders] & js.UndefOr[js.Any]): Self = StObject.set(x, "headers", value.asInstanceOf[js.Any])
      
      @scala.inline
      def setMethod(value: String): Self = StObject.set(x, "method", value.asInstanceOf[js.Any])
      
      @scala.inline
      def setMethodUndefined: Self = StObject.set(x, "method", js.undefined)
      
      @scala.inline
      def setParams(value: js.Any): Self = StObject.set(x, "params", value.asInstanceOf[js.Any])
      
      @scala.inline
      def setParamsUndefined: Self = StObject.set(x, "params", js.undefined)
      
      @scala.inline
      def setProgress(value: /* event */ js.Any => js.Any): Self = StObject.set(x, "progress", js.Any.fromFunction1(value))
      
      @scala.inline
      def setProgressUndefined: Self = StObject.set(x, "progress", js.undefined)
      
      @scala.inline
      def setUrl(value: String): Self = StObject.set(x, "url", value.asInstanceOf[js.Any])
      
      @scala.inline
      def setUrlUndefined: Self = StObject.set(x, "url", js.undefined)
    }
  }
}
