package typings.vueResource

import org.scalablytyped.runtime.StringDictionary
import typings.std.PromiseLike
import typings.vueResource.vuejs.HttpHeaders
import typings.vueResource.vuejs.HttpResponse
import typings.vueResource.vuejs.http
import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

object anon {
  
  @js.native
  trait Call extends StObject {
    
    def apply(options: typings.vueResource.vuejs.HttpOptions): PromiseLike[HttpResponse] = js.native
    
    def delete(url: String): PromiseLike[HttpResponse] = js.native
    def delete(url: String, data: Any): PromiseLike[HttpResponse] = js.native
    def delete(url: String, data: Any, options: typings.vueResource.vuejs.HttpOptions): PromiseLike[HttpResponse] = js.native
    def delete(url: String, data: Unit, options: typings.vueResource.vuejs.HttpOptions): PromiseLike[HttpResponse] = js.native
    def delete(url: String, options: typings.vueResource.vuejs.HttpOptions): PromiseLike[HttpResponse] = js.native
    @JSName("delete")
    var delete_Original: http = js.native
    
    def get(url: String): PromiseLike[HttpResponse] = js.native
    def get(url: String, data: Any): PromiseLike[HttpResponse] = js.native
    def get(url: String, data: Any, options: typings.vueResource.vuejs.HttpOptions): PromiseLike[HttpResponse] = js.native
    def get(url: String, data: Unit, options: typings.vueResource.vuejs.HttpOptions): PromiseLike[HttpResponse] = js.native
    def get(url: String, options: typings.vueResource.vuejs.HttpOptions): PromiseLike[HttpResponse] = js.native
    @JSName("get")
    var get_Original: http = js.native
    
    def jsonp(url: String): PromiseLike[HttpResponse] = js.native
    def jsonp(url: String, data: Any): PromiseLike[HttpResponse] = js.native
    def jsonp(url: String, data: Any, options: typings.vueResource.vuejs.HttpOptions): PromiseLike[HttpResponse] = js.native
    def jsonp(url: String, data: Unit, options: typings.vueResource.vuejs.HttpOptions): PromiseLike[HttpResponse] = js.native
    def jsonp(url: String, options: typings.vueResource.vuejs.HttpOptions): PromiseLike[HttpResponse] = js.native
    @JSName("jsonp")
    var jsonp_Original: http = js.native
    
    def patch(url: String): PromiseLike[HttpResponse] = js.native
    def patch(url: String, data: Any): PromiseLike[HttpResponse] = js.native
    def patch(url: String, data: Any, options: typings.vueResource.vuejs.HttpOptions): PromiseLike[HttpResponse] = js.native
    def patch(url: String, data: Unit, options: typings.vueResource.vuejs.HttpOptions): PromiseLike[HttpResponse] = js.native
    def patch(url: String, options: typings.vueResource.vuejs.HttpOptions): PromiseLike[HttpResponse] = js.native
    @JSName("patch")
    var patch_Original: http = js.native
    
    def post(url: String): PromiseLike[HttpResponse] = js.native
    def post(url: String, data: Any): PromiseLike[HttpResponse] = js.native
    def post(url: String, data: Any, options: typings.vueResource.vuejs.HttpOptions): PromiseLike[HttpResponse] = js.native
    def post(url: String, data: Unit, options: typings.vueResource.vuejs.HttpOptions): PromiseLike[HttpResponse] = js.native
    def post(url: String, options: typings.vueResource.vuejs.HttpOptions): PromiseLike[HttpResponse] = js.native
    @JSName("post")
    var post_Original: http = js.native
    
    def put(url: String): PromiseLike[HttpResponse] = js.native
    def put(url: String, data: Any): PromiseLike[HttpResponse] = js.native
    def put(url: String, data: Any, options: typings.vueResource.vuejs.HttpOptions): PromiseLike[HttpResponse] = js.native
    def put(url: String, data: Unit, options: typings.vueResource.vuejs.HttpOptions): PromiseLike[HttpResponse] = js.native
    def put(url: String, options: typings.vueResource.vuejs.HttpOptions): PromiseLike[HttpResponse] = js.native
    @JSName("put")
    var put_Original: http = js.native
  }
  
  /* Inlined vue-resource.vuejs.HttpOptions & {  root :string} */
  trait HttpOptions extends StObject {
    
    var before: js.UndefOr[js.Function1[/* request */ Any, Any]] = js.undefined
    
    var body: js.UndefOr[Any] = js.undefined
    
    var credentials: js.UndefOr[Boolean] = js.undefined
    
    var emulateHTTP: js.UndefOr[Boolean] = js.undefined
    
    var emulateJSON: js.UndefOr[Boolean] = js.undefined
    
    var headers: js.UndefOr[Any] = js.undefined
    
    var method: js.UndefOr[String] = js.undefined
    
    var params: js.UndefOr[Any] = js.undefined
    
    var progress: js.UndefOr[js.Function1[/* event */ Any, Any]] = js.undefined
    
    var root: String
    
    var url: js.UndefOr[String] = js.undefined
  }
  object HttpOptions {
    
    inline def apply(root: String): HttpOptions = {
      val __obj = js.Dynamic.literal(root = root.asInstanceOf[js.Any])
      __obj.asInstanceOf[HttpOptions]
    }
    
    extension [Self <: HttpOptions](x: Self) {
      
      inline def setBefore(value: /* request */ Any => Any): Self = StObject.set(x, "before", js.Any.fromFunction1(value))
      
      inline def setBeforeUndefined: Self = StObject.set(x, "before", js.undefined)
      
      inline def setBody(value: Any): Self = StObject.set(x, "body", value.asInstanceOf[js.Any])
      
      inline def setBodyUndefined: Self = StObject.set(x, "body", js.undefined)
      
      inline def setCredentials(value: Boolean): Self = StObject.set(x, "credentials", value.asInstanceOf[js.Any])
      
      inline def setCredentialsUndefined: Self = StObject.set(x, "credentials", js.undefined)
      
      inline def setEmulateHTTP(value: Boolean): Self = StObject.set(x, "emulateHTTP", value.asInstanceOf[js.Any])
      
      inline def setEmulateHTTPUndefined: Self = StObject.set(x, "emulateHTTP", js.undefined)
      
      inline def setEmulateJSON(value: Boolean): Self = StObject.set(x, "emulateJSON", value.asInstanceOf[js.Any])
      
      inline def setEmulateJSONUndefined: Self = StObject.set(x, "emulateJSON", js.undefined)
      
      inline def setHeaders(value: Any): Self = StObject.set(x, "headers", value.asInstanceOf[js.Any])
      
      inline def setHeadersUndefined: Self = StObject.set(x, "headers", js.undefined)
      
      inline def setMethod(value: String): Self = StObject.set(x, "method", value.asInstanceOf[js.Any])
      
      inline def setMethodUndefined: Self = StObject.set(x, "method", js.undefined)
      
      inline def setParams(value: Any): Self = StObject.set(x, "params", value.asInstanceOf[js.Any])
      
      inline def setParamsUndefined: Self = StObject.set(x, "params", js.undefined)
      
      inline def setProgress(value: /* event */ Any => Any): Self = StObject.set(x, "progress", js.Any.fromFunction1(value))
      
      inline def setProgressUndefined: Self = StObject.set(x, "progress", js.undefined)
      
      inline def setRoot(value: String): Self = StObject.set(x, "root", value.asInstanceOf[js.Any])
      
      inline def setUrl(value: String): Self = StObject.set(x, "url", value.asInstanceOf[js.Any])
      
      inline def setUrlUndefined: Self = StObject.set(x, "url", js.undefined)
    }
  }
  
  /* Inlined {  headers :vue-resource.vuejs.HttpHeaders | undefined, [key: string] : any} & vue-resource.vuejs.HttpOptions */
  trait HttpOptionsDictkey
    extends StObject
       with /* key */ StringDictionary[Any] {
    
    var before: js.UndefOr[js.Function1[/* request */ Any, Any]] = js.undefined
    
    var body: js.UndefOr[Any] = js.undefined
    
    var credentials: js.UndefOr[Boolean] = js.undefined
    
    var emulateHTTP: js.UndefOr[Boolean] = js.undefined
    
    var emulateJSON: js.UndefOr[Boolean] = js.undefined
    
    var headers: js.UndefOr[HttpHeaders] = js.undefined
    
    var method: js.UndefOr[String] = js.undefined
    
    var params: js.UndefOr[Any] = js.undefined
    
    var progress: js.UndefOr[js.Function1[/* event */ Any, Any]] = js.undefined
    
    var url: js.UndefOr[String] = js.undefined
  }
  object HttpOptionsDictkey {
    
    inline def apply(): HttpOptionsDictkey = {
      val __obj = js.Dynamic.literal()
      __obj.asInstanceOf[HttpOptionsDictkey]
    }
    
    extension [Self <: HttpOptionsDictkey](x: Self) {
      
      inline def setBefore(value: /* request */ Any => Any): Self = StObject.set(x, "before", js.Any.fromFunction1(value))
      
      inline def setBeforeUndefined: Self = StObject.set(x, "before", js.undefined)
      
      inline def setBody(value: Any): Self = StObject.set(x, "body", value.asInstanceOf[js.Any])
      
      inline def setBodyUndefined: Self = StObject.set(x, "body", js.undefined)
      
      inline def setCredentials(value: Boolean): Self = StObject.set(x, "credentials", value.asInstanceOf[js.Any])
      
      inline def setCredentialsUndefined: Self = StObject.set(x, "credentials", js.undefined)
      
      inline def setEmulateHTTP(value: Boolean): Self = StObject.set(x, "emulateHTTP", value.asInstanceOf[js.Any])
      
      inline def setEmulateHTTPUndefined: Self = StObject.set(x, "emulateHTTP", js.undefined)
      
      inline def setEmulateJSON(value: Boolean): Self = StObject.set(x, "emulateJSON", value.asInstanceOf[js.Any])
      
      inline def setEmulateJSONUndefined: Self = StObject.set(x, "emulateJSON", js.undefined)
      
      inline def setHeaders(value: HttpHeaders): Self = StObject.set(x, "headers", value.asInstanceOf[js.Any])
      
      inline def setHeadersUndefined: Self = StObject.set(x, "headers", js.undefined)
      
      inline def setMethod(value: String): Self = StObject.set(x, "method", value.asInstanceOf[js.Any])
      
      inline def setMethodUndefined: Self = StObject.set(x, "method", js.undefined)
      
      inline def setParams(value: Any): Self = StObject.set(x, "params", value.asInstanceOf[js.Any])
      
      inline def setParamsUndefined: Self = StObject.set(x, "params", js.undefined)
      
      inline def setProgress(value: /* event */ Any => Any): Self = StObject.set(x, "progress", js.Any.fromFunction1(value))
      
      inline def setProgressUndefined: Self = StObject.set(x, "progress", js.undefined)
      
      inline def setUrl(value: String): Self = StObject.set(x, "url", value.asInstanceOf[js.Any])
      
      inline def setUrlUndefined: Self = StObject.set(x, "url", js.undefined)
    }
  }
  
  trait Method extends StObject {
    
    var method: String
  }
  object Method {
    
    inline def apply(method: String): Method = {
      val __obj = js.Dynamic.literal(method = method.asInstanceOf[js.Any])
      __obj.asInstanceOf[Method]
    }
    
    extension [Self <: Method](x: Self) {
      
      inline def setMethod(value: String): Self = StObject.set(x, "method", value.asInstanceOf[js.Any])
    }
  }
}
