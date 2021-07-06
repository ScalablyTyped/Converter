package typings.vueResource

import org.scalablytyped.runtime.StringDictionary
import typings.std.Blob
import typings.vueResource.anon.Call
import typings.vueResource.anon.HttpOptionsrootstring
import typings.vueResource.anon.Method
import typings.vueResource.anon.headersHttpHeadersundefin
import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

object vuejs {
  
  trait ComponentOption extends StObject {
    
    var http: js.UndefOr[headersHttpHeadersundefin] = js.undefined
  }
  object ComponentOption {
    
    @scala.inline
    def apply(): ComponentOption = {
      val __obj = js.Dynamic.literal()
      __obj.asInstanceOf[ComponentOption]
    }
    
    @scala.inline
    implicit class ComponentOptionMutableBuilder[Self <: ComponentOption] (val x: Self) extends AnyVal {
      
      @scala.inline
      def setHttp(value: headersHttpHeadersundefin): Self = StObject.set(x, "http", value.asInstanceOf[js.Any])
      
      @scala.inline
      def setHttpUndefined: Self = StObject.set(x, "http", js.undefined)
    }
  }
  
  trait HttpHeaders
    extends StObject
       with /* key */ StringDictionary[js.Any] {
    
    var common: js.UndefOr[StringDictionary[String]] = js.undefined
    
    var custom: js.UndefOr[StringDictionary[String]] = js.undefined
    
    var delete: js.UndefOr[StringDictionary[String]] = js.undefined
    
    var patch: js.UndefOr[StringDictionary[String]] = js.undefined
    
    var post: js.UndefOr[StringDictionary[String]] = js.undefined
    
    var put: js.UndefOr[StringDictionary[String]] = js.undefined
  }
  object HttpHeaders {
    
    @scala.inline
    def apply(): HttpHeaders = {
      val __obj = js.Dynamic.literal()
      __obj.asInstanceOf[HttpHeaders]
    }
    
    @scala.inline
    implicit class HttpHeadersMutableBuilder[Self <: HttpHeaders] (val x: Self) extends AnyVal {
      
      @scala.inline
      def setCommon(value: StringDictionary[String]): Self = StObject.set(x, "common", value.asInstanceOf[js.Any])
      
      @scala.inline
      def setCommonUndefined: Self = StObject.set(x, "common", js.undefined)
      
      @scala.inline
      def setCustom(value: StringDictionary[String]): Self = StObject.set(x, "custom", value.asInstanceOf[js.Any])
      
      @scala.inline
      def setCustomUndefined: Self = StObject.set(x, "custom", js.undefined)
      
      @scala.inline
      def setDelete(value: StringDictionary[String]): Self = StObject.set(x, "delete", value.asInstanceOf[js.Any])
      
      @scala.inline
      def setDeleteUndefined: Self = StObject.set(x, "delete", js.undefined)
      
      @scala.inline
      def setPatch(value: StringDictionary[String]): Self = StObject.set(x, "patch", value.asInstanceOf[js.Any])
      
      @scala.inline
      def setPatchUndefined: Self = StObject.set(x, "patch", js.undefined)
      
      @scala.inline
      def setPost(value: StringDictionary[String]): Self = StObject.set(x, "post", value.asInstanceOf[js.Any])
      
      @scala.inline
      def setPostUndefined: Self = StObject.set(x, "post", js.undefined)
      
      @scala.inline
      def setPut(value: StringDictionary[String]): Self = StObject.set(x, "put", value.asInstanceOf[js.Any])
      
      @scala.inline
      def setPutUndefined: Self = StObject.set(x, "put", js.undefined)
    }
  }
  
  trait HttpInterceptor extends StObject {
    
    var request: js.UndefOr[js.Function1[/* request */ HttpOptions, HttpOptions]] = js.undefined
    
    var response: js.UndefOr[js.Function1[/* response */ HttpResponse, HttpResponse]] = js.undefined
  }
  object HttpInterceptor {
    
    @scala.inline
    def apply(): HttpInterceptor = {
      val __obj = js.Dynamic.literal()
      __obj.asInstanceOf[HttpInterceptor]
    }
    
    @scala.inline
    implicit class HttpInterceptorMutableBuilder[Self <: HttpInterceptor] (val x: Self) extends AnyVal {
      
      @scala.inline
      def setRequest(value: /* request */ HttpOptions => HttpOptions): Self = StObject.set(x, "request", js.Any.fromFunction1(value))
      
      @scala.inline
      def setRequestUndefined: Self = StObject.set(x, "request", js.undefined)
      
      @scala.inline
      def setResponse(value: /* response */ HttpResponse => HttpResponse): Self = StObject.set(x, "response", js.Any.fromFunction1(value))
      
      @scala.inline
      def setResponseUndefined: Self = StObject.set(x, "response", js.undefined)
    }
  }
  
  trait HttpOptions extends StObject {
    
    var before: js.UndefOr[js.Function1[/* request */ js.Any, js.Any]] = js.undefined
    
    var body: js.UndefOr[js.Any] = js.undefined
    
    var credentials: js.UndefOr[Boolean] = js.undefined
    
    var emulateHTTP: js.UndefOr[Boolean] = js.undefined
    
    var emulateJSON: js.UndefOr[Boolean] = js.undefined
    
    var headers: js.UndefOr[js.Any] = js.undefined
    
    var method: js.UndefOr[String] = js.undefined
    
    var params: js.UndefOr[js.Any] = js.undefined
    
    var progress: js.UndefOr[js.Function1[/* event */ js.Any, js.Any]] = js.undefined
    
    var url: js.UndefOr[String] = js.undefined
  }
  object HttpOptions {
    
    @scala.inline
    def apply(): HttpOptions = {
      val __obj = js.Dynamic.literal()
      __obj.asInstanceOf[HttpOptions]
    }
    
    @scala.inline
    implicit class HttpOptionsMutableBuilder[Self <: HttpOptions] (val x: Self) extends AnyVal {
      
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
      def setUrl(value: String): Self = StObject.set(x, "url", value.asInstanceOf[js.Any])
      
      @scala.inline
      def setUrlUndefined: Self = StObject.set(x, "url", js.undefined)
    }
  }
  
  trait HttpResponse extends StObject {
    
    def blob(): Blob
    
    var data: js.Object
    
    var headers: js.Function
    
    def json(): js.Any
    
    var ok: Boolean
    
    var status: Double
    
    var statusText: String
    
    def text(): String
  }
  object HttpResponse {
    
    @scala.inline
    def apply(
      blob: () => Blob,
      data: js.Object,
      headers: js.Function,
      json: () => js.Any,
      ok: Boolean,
      status: Double,
      statusText: String,
      text: () => String
    ): HttpResponse = {
      val __obj = js.Dynamic.literal(blob = js.Any.fromFunction0(blob), data = data.asInstanceOf[js.Any], headers = headers.asInstanceOf[js.Any], json = js.Any.fromFunction0(json), ok = ok.asInstanceOf[js.Any], status = status.asInstanceOf[js.Any], statusText = statusText.asInstanceOf[js.Any], text = js.Any.fromFunction0(text))
      __obj.asInstanceOf[HttpResponse]
    }
    
    @scala.inline
    implicit class HttpResponseMutableBuilder[Self <: HttpResponse] (val x: Self) extends AnyVal {
      
      @scala.inline
      def setBlob(value: () => Blob): Self = StObject.set(x, "blob", js.Any.fromFunction0(value))
      
      @scala.inline
      def setData(value: js.Object): Self = StObject.set(x, "data", value.asInstanceOf[js.Any])
      
      @scala.inline
      def setHeaders(value: js.Function): Self = StObject.set(x, "headers", value.asInstanceOf[js.Any])
      
      @scala.inline
      def setJson(value: () => js.Any): Self = StObject.set(x, "json", js.Any.fromFunction0(value))
      
      @scala.inline
      def setOk(value: Boolean): Self = StObject.set(x, "ok", value.asInstanceOf[js.Any])
      
      @scala.inline
      def setStatus(value: Double): Self = StObject.set(x, "status", value.asInstanceOf[js.Any])
      
      @scala.inline
      def setStatusText(value: String): Self = StObject.set(x, "statusText", value.asInstanceOf[js.Any])
      
      @scala.inline
      def setText(value: () => String): Self = StObject.set(x, "text", js.Any.fromFunction0(value))
    }
  }
  
  trait Http_ extends StObject {
    
    def delete(url: String): js.Thenable[HttpResponse]
    def delete(url: String, data: js.Any): js.Thenable[HttpResponse]
    def delete(url: String, data: js.Any, options: HttpOptions): js.Thenable[HttpResponse]
    def delete(url: String, data: Unit, options: HttpOptions): js.Thenable[HttpResponse]
    def delete(url: String, options: HttpOptions): js.Thenable[HttpResponse]
    @JSName("delete")
    var delete_Original: http
    
    def get(url: String): js.Thenable[HttpResponse]
    def get(url: String, data: js.Any): js.Thenable[HttpResponse]
    def get(url: String, data: js.Any, options: HttpOptions): js.Thenable[HttpResponse]
    def get(url: String, data: Unit, options: HttpOptions): js.Thenable[HttpResponse]
    def get(url: String, options: HttpOptions): js.Thenable[HttpResponse]
    @JSName("get")
    var get_Original: http
    
    var headers: HttpHeaders
    
    var interceptors: js.Array[HttpInterceptor | js.Function0[HttpInterceptor]]
    
    def jsonp(url: String): js.Thenable[HttpResponse]
    def jsonp(url: String, data: js.Any): js.Thenable[HttpResponse]
    def jsonp(url: String, data: js.Any, options: HttpOptions): js.Thenable[HttpResponse]
    def jsonp(url: String, data: Unit, options: HttpOptions): js.Thenable[HttpResponse]
    def jsonp(url: String, options: HttpOptions): js.Thenable[HttpResponse]
    @JSName("jsonp")
    var jsonp_Original: http
    
    var options: HttpOptionsrootstring
    
    def patch(url: String): js.Thenable[HttpResponse]
    def patch(url: String, data: js.Any): js.Thenable[HttpResponse]
    def patch(url: String, data: js.Any, options: HttpOptions): js.Thenable[HttpResponse]
    def patch(url: String, data: Unit, options: HttpOptions): js.Thenable[HttpResponse]
    def patch(url: String, options: HttpOptions): js.Thenable[HttpResponse]
    @JSName("patch")
    var patch_Original: http
    
    def post(url: String): js.Thenable[HttpResponse]
    def post(url: String, data: js.Any): js.Thenable[HttpResponse]
    def post(url: String, data: js.Any, options: HttpOptions): js.Thenable[HttpResponse]
    def post(url: String, data: Unit, options: HttpOptions): js.Thenable[HttpResponse]
    def post(url: String, options: HttpOptions): js.Thenable[HttpResponse]
    @JSName("post")
    var post_Original: http
    
    def put(url: String): js.Thenable[HttpResponse]
    def put(url: String, data: js.Any): js.Thenable[HttpResponse]
    def put(url: String, data: js.Any, options: HttpOptions): js.Thenable[HttpResponse]
    def put(url: String, data: Unit, options: HttpOptions): js.Thenable[HttpResponse]
    def put(url: String, options: HttpOptions): js.Thenable[HttpResponse]
    @JSName("put")
    var put_Original: http
  }
  object Http_ {
    
    @scala.inline
    def apply(
      delete: http,
      get: http,
      headers: HttpHeaders,
      interceptors: js.Array[HttpInterceptor | js.Function0[HttpInterceptor]],
      jsonp: http,
      options: HttpOptionsrootstring,
      patch: http,
      post: http,
      put: http
    ): Http_ = {
      val __obj = js.Dynamic.literal(delete = delete.asInstanceOf[js.Any], get = get.asInstanceOf[js.Any], headers = headers.asInstanceOf[js.Any], interceptors = interceptors.asInstanceOf[js.Any], jsonp = jsonp.asInstanceOf[js.Any], options = options.asInstanceOf[js.Any], patch = patch.asInstanceOf[js.Any], post = post.asInstanceOf[js.Any], put = put.asInstanceOf[js.Any])
      __obj.asInstanceOf[Http_]
    }
    
    @scala.inline
    implicit class Http_MutableBuilder[Self <: Http_] (val x: Self) extends AnyVal {
      
      @scala.inline
      def setDelete(value: http): Self = StObject.set(x, "delete", value.asInstanceOf[js.Any])
      
      @scala.inline
      def setGet(value: http): Self = StObject.set(x, "get", value.asInstanceOf[js.Any])
      
      @scala.inline
      def setHeaders(value: HttpHeaders): Self = StObject.set(x, "headers", value.asInstanceOf[js.Any])
      
      @scala.inline
      def setInterceptors(value: js.Array[HttpInterceptor | js.Function0[HttpInterceptor]]): Self = StObject.set(x, "interceptors", value.asInstanceOf[js.Any])
      
      @scala.inline
      def setInterceptorsVarargs(value: (HttpInterceptor | js.Function0[HttpInterceptor])*): Self = StObject.set(x, "interceptors", js.Array(value :_*))
      
      @scala.inline
      def setJsonp(value: http): Self = StObject.set(x, "jsonp", value.asInstanceOf[js.Any])
      
      @scala.inline
      def setOptions(value: HttpOptionsrootstring): Self = StObject.set(x, "options", value.asInstanceOf[js.Any])
      
      @scala.inline
      def setPatch(value: http): Self = StObject.set(x, "patch", value.asInstanceOf[js.Any])
      
      @scala.inline
      def setPost(value: http): Self = StObject.set(x, "post", value.asInstanceOf[js.Any])
      
      @scala.inline
      def setPut(value: http): Self = StObject.set(x, "put", value.asInstanceOf[js.Any])
    }
  }
  
  trait ResourceActions extends StObject {
    
    var delete: Method
    
    var get: Method
    
    var query: Method
    
    var remove: Method
    
    var save: Method
    
    var update: Method
  }
  object ResourceActions {
    
    @scala.inline
    def apply(delete: Method, get: Method, query: Method, remove: Method, save: Method, update: Method): ResourceActions = {
      val __obj = js.Dynamic.literal(delete = delete.asInstanceOf[js.Any], get = get.asInstanceOf[js.Any], query = query.asInstanceOf[js.Any], remove = remove.asInstanceOf[js.Any], save = save.asInstanceOf[js.Any], update = update.asInstanceOf[js.Any])
      __obj.asInstanceOf[ResourceActions]
    }
    
    @scala.inline
    implicit class ResourceActionsMutableBuilder[Self <: ResourceActions] (val x: Self) extends AnyVal {
      
      @scala.inline
      def setDelete(value: Method): Self = StObject.set(x, "delete", value.asInstanceOf[js.Any])
      
      @scala.inline
      def setGet(value: Method): Self = StObject.set(x, "get", value.asInstanceOf[js.Any])
      
      @scala.inline
      def setQuery(value: Method): Self = StObject.set(x, "query", value.asInstanceOf[js.Any])
      
      @scala.inline
      def setRemove(value: Method): Self = StObject.set(x, "remove", value.asInstanceOf[js.Any])
      
      @scala.inline
      def setSave(value: Method): Self = StObject.set(x, "save", value.asInstanceOf[js.Any])
      
      @scala.inline
      def setUpdate(value: Method): Self = StObject.set(x, "update", value.asInstanceOf[js.Any])
    }
  }
  
  @js.native
  trait ResourceMethod extends StObject {
    
    def apply(): js.Thenable[HttpResponse] = js.native
    def apply(params: js.Any): js.Thenable[HttpResponse] = js.native
    def apply(params: js.Any, data: js.Any): js.Thenable[HttpResponse] = js.native
    def apply(params: js.Any, data: js.Any, success: js.Function): js.Thenable[HttpResponse] = js.native
    def apply(params: js.Any, data: js.Any, success: js.Function, error: js.Function): js.Thenable[HttpResponse] = js.native
    def apply(params: js.Any, data: js.Any, success: Unit, error: js.Function): js.Thenable[HttpResponse] = js.native
    def apply(params: js.Any, data: Unit, success: js.Function): js.Thenable[HttpResponse] = js.native
    def apply(params: js.Any, data: Unit, success: js.Function, error: js.Function): js.Thenable[HttpResponse] = js.native
    def apply(params: js.Any, data: Unit, success: Unit, error: js.Function): js.Thenable[HttpResponse] = js.native
    def apply(params: js.Any, success: js.Function): js.Thenable[HttpResponse] = js.native
    def apply(params: js.Any, success: js.Function, error: js.Function): js.Thenable[HttpResponse] = js.native
    def apply(success: js.Function): js.Thenable[HttpResponse] = js.native
    def apply(success: js.Function, error: js.Function): js.Thenable[HttpResponse] = js.native
    def apply(success: Unit, error: js.Function): js.Thenable[HttpResponse] = js.native
  }
  
  trait ResourceMethods extends StObject {
    
    def delete(): js.Thenable[HttpResponse]
    def delete(params: js.Any): js.Thenable[HttpResponse]
    def delete(params: js.Any, data: js.Any): js.Thenable[HttpResponse]
    def delete(params: js.Any, data: js.Any, success: js.Function): js.Thenable[HttpResponse]
    def delete(params: js.Any, data: js.Any, success: js.Function, error: js.Function): js.Thenable[HttpResponse]
    def delete(params: js.Any, data: js.Any, success: Unit, error: js.Function): js.Thenable[HttpResponse]
    def delete(params: js.Any, data: Unit, success: js.Function): js.Thenable[HttpResponse]
    def delete(params: js.Any, data: Unit, success: js.Function, error: js.Function): js.Thenable[HttpResponse]
    def delete(params: js.Any, data: Unit, success: Unit, error: js.Function): js.Thenable[HttpResponse]
    def delete(params: js.Any, success: js.Function): js.Thenable[HttpResponse]
    def delete(params: js.Any, success: js.Function, error: js.Function): js.Thenable[HttpResponse]
    def delete(success: js.Function): js.Thenable[HttpResponse]
    def delete(success: js.Function, error: js.Function): js.Thenable[HttpResponse]
    def delete(success: Unit, error: js.Function): js.Thenable[HttpResponse]
    @JSName("delete")
    var delete_Original: ResourceMethod
    
    def get(): js.Thenable[HttpResponse]
    def get(params: js.Any): js.Thenable[HttpResponse]
    def get(params: js.Any, data: js.Any): js.Thenable[HttpResponse]
    def get(params: js.Any, data: js.Any, success: js.Function): js.Thenable[HttpResponse]
    def get(params: js.Any, data: js.Any, success: js.Function, error: js.Function): js.Thenable[HttpResponse]
    def get(params: js.Any, data: js.Any, success: Unit, error: js.Function): js.Thenable[HttpResponse]
    def get(params: js.Any, data: Unit, success: js.Function): js.Thenable[HttpResponse]
    def get(params: js.Any, data: Unit, success: js.Function, error: js.Function): js.Thenable[HttpResponse]
    def get(params: js.Any, data: Unit, success: Unit, error: js.Function): js.Thenable[HttpResponse]
    def get(params: js.Any, success: js.Function): js.Thenable[HttpResponse]
    def get(params: js.Any, success: js.Function, error: js.Function): js.Thenable[HttpResponse]
    def get(success: js.Function): js.Thenable[HttpResponse]
    def get(success: js.Function, error: js.Function): js.Thenable[HttpResponse]
    def get(success: Unit, error: js.Function): js.Thenable[HttpResponse]
    @JSName("get")
    var get_Original: ResourceMethod
    
    def query(): js.Thenable[HttpResponse]
    def query(params: js.Any): js.Thenable[HttpResponse]
    def query(params: js.Any, data: js.Any): js.Thenable[HttpResponse]
    def query(params: js.Any, data: js.Any, success: js.Function): js.Thenable[HttpResponse]
    def query(params: js.Any, data: js.Any, success: js.Function, error: js.Function): js.Thenable[HttpResponse]
    def query(params: js.Any, data: js.Any, success: Unit, error: js.Function): js.Thenable[HttpResponse]
    def query(params: js.Any, data: Unit, success: js.Function): js.Thenable[HttpResponse]
    def query(params: js.Any, data: Unit, success: js.Function, error: js.Function): js.Thenable[HttpResponse]
    def query(params: js.Any, data: Unit, success: Unit, error: js.Function): js.Thenable[HttpResponse]
    def query(params: js.Any, success: js.Function): js.Thenable[HttpResponse]
    def query(params: js.Any, success: js.Function, error: js.Function): js.Thenable[HttpResponse]
    def query(success: js.Function): js.Thenable[HttpResponse]
    def query(success: js.Function, error: js.Function): js.Thenable[HttpResponse]
    def query(success: Unit, error: js.Function): js.Thenable[HttpResponse]
    @JSName("query")
    var query_Original: ResourceMethod
    
    def remove(): js.Thenable[HttpResponse]
    def remove(params: js.Any): js.Thenable[HttpResponse]
    def remove(params: js.Any, data: js.Any): js.Thenable[HttpResponse]
    def remove(params: js.Any, data: js.Any, success: js.Function): js.Thenable[HttpResponse]
    def remove(params: js.Any, data: js.Any, success: js.Function, error: js.Function): js.Thenable[HttpResponse]
    def remove(params: js.Any, data: js.Any, success: Unit, error: js.Function): js.Thenable[HttpResponse]
    def remove(params: js.Any, data: Unit, success: js.Function): js.Thenable[HttpResponse]
    def remove(params: js.Any, data: Unit, success: js.Function, error: js.Function): js.Thenable[HttpResponse]
    def remove(params: js.Any, data: Unit, success: Unit, error: js.Function): js.Thenable[HttpResponse]
    def remove(params: js.Any, success: js.Function): js.Thenable[HttpResponse]
    def remove(params: js.Any, success: js.Function, error: js.Function): js.Thenable[HttpResponse]
    def remove(success: js.Function): js.Thenable[HttpResponse]
    def remove(success: js.Function, error: js.Function): js.Thenable[HttpResponse]
    def remove(success: Unit, error: js.Function): js.Thenable[HttpResponse]
    @JSName("remove")
    var remove_Original: ResourceMethod
    
    def save(): js.Thenable[HttpResponse]
    def save(params: js.Any): js.Thenable[HttpResponse]
    def save(params: js.Any, data: js.Any): js.Thenable[HttpResponse]
    def save(params: js.Any, data: js.Any, success: js.Function): js.Thenable[HttpResponse]
    def save(params: js.Any, data: js.Any, success: js.Function, error: js.Function): js.Thenable[HttpResponse]
    def save(params: js.Any, data: js.Any, success: Unit, error: js.Function): js.Thenable[HttpResponse]
    def save(params: js.Any, data: Unit, success: js.Function): js.Thenable[HttpResponse]
    def save(params: js.Any, data: Unit, success: js.Function, error: js.Function): js.Thenable[HttpResponse]
    def save(params: js.Any, data: Unit, success: Unit, error: js.Function): js.Thenable[HttpResponse]
    def save(params: js.Any, success: js.Function): js.Thenable[HttpResponse]
    def save(params: js.Any, success: js.Function, error: js.Function): js.Thenable[HttpResponse]
    def save(success: js.Function): js.Thenable[HttpResponse]
    def save(success: js.Function, error: js.Function): js.Thenable[HttpResponse]
    def save(success: Unit, error: js.Function): js.Thenable[HttpResponse]
    @JSName("save")
    var save_Original: ResourceMethod
    
    def update(): js.Thenable[HttpResponse]
    def update(params: js.Any): js.Thenable[HttpResponse]
    def update(params: js.Any, data: js.Any): js.Thenable[HttpResponse]
    def update(params: js.Any, data: js.Any, success: js.Function): js.Thenable[HttpResponse]
    def update(params: js.Any, data: js.Any, success: js.Function, error: js.Function): js.Thenable[HttpResponse]
    def update(params: js.Any, data: js.Any, success: Unit, error: js.Function): js.Thenable[HttpResponse]
    def update(params: js.Any, data: Unit, success: js.Function): js.Thenable[HttpResponse]
    def update(params: js.Any, data: Unit, success: js.Function, error: js.Function): js.Thenable[HttpResponse]
    def update(params: js.Any, data: Unit, success: Unit, error: js.Function): js.Thenable[HttpResponse]
    def update(params: js.Any, success: js.Function): js.Thenable[HttpResponse]
    def update(params: js.Any, success: js.Function, error: js.Function): js.Thenable[HttpResponse]
    def update(success: js.Function): js.Thenable[HttpResponse]
    def update(success: js.Function, error: js.Function): js.Thenable[HttpResponse]
    def update(success: Unit, error: js.Function): js.Thenable[HttpResponse]
    @JSName("update")
    var update_Original: ResourceMethod
  }
  object ResourceMethods {
    
    @scala.inline
    def apply(
      delete: ResourceMethod,
      get: ResourceMethod,
      query: ResourceMethod,
      remove: ResourceMethod,
      save: ResourceMethod,
      update: ResourceMethod
    ): ResourceMethods = {
      val __obj = js.Dynamic.literal(delete = delete.asInstanceOf[js.Any], get = get.asInstanceOf[js.Any], query = query.asInstanceOf[js.Any], remove = remove.asInstanceOf[js.Any], save = save.asInstanceOf[js.Any], update = update.asInstanceOf[js.Any])
      __obj.asInstanceOf[ResourceMethods]
    }
    
    @scala.inline
    implicit class ResourceMethodsMutableBuilder[Self <: ResourceMethods] (val x: Self) extends AnyVal {
      
      @scala.inline
      def setDelete(value: ResourceMethod): Self = StObject.set(x, "delete", value.asInstanceOf[js.Any])
      
      @scala.inline
      def setGet(value: ResourceMethod): Self = StObject.set(x, "get", value.asInstanceOf[js.Any])
      
      @scala.inline
      def setQuery(value: ResourceMethod): Self = StObject.set(x, "query", value.asInstanceOf[js.Any])
      
      @scala.inline
      def setRemove(value: ResourceMethod): Self = StObject.set(x, "remove", value.asInstanceOf[js.Any])
      
      @scala.inline
      def setSave(value: ResourceMethod): Self = StObject.set(x, "save", value.asInstanceOf[js.Any])
      
      @scala.inline
      def setUpdate(value: ResourceMethod): Self = StObject.set(x, "update", value.asInstanceOf[js.Any])
    }
  }
  
  @js.native
  trait Resource_ extends resource {
    
    var actions: ResourceActions = js.native
  }
  
  trait Vue extends StObject {
    
    @JSName("$http")
    def $http(options: HttpOptions): js.Thenable[HttpResponse]
    @JSName("$http")
    var $http_Original: Call
    
    @JSName("$resource")
    def $resource(url: String): ResourceMethods
    @JSName("$resource")
    def $resource(url: String, params: js.Object): ResourceMethods
    @JSName("$resource")
    def $resource(url: String, params: js.Object, actions: js.Any): ResourceMethods
    @JSName("$resource")
    def $resource(url: String, params: js.Object, actions: js.Any, options: HttpOptions): ResourceMethods
    @JSName("$resource")
    def $resource(url: String, params: js.Object, actions: Unit, options: HttpOptions): ResourceMethods
    @JSName("$resource")
    def $resource(url: String, params: Unit, actions: js.Any): ResourceMethods
    @JSName("$resource")
    def $resource(url: String, params: Unit, actions: js.Any, options: HttpOptions): ResourceMethods
    @JSName("$resource")
    def $resource(url: String, params: Unit, actions: Unit, options: HttpOptions): ResourceMethods
    @JSName("$resource")
    var $resource_Original: resource
  }
  object Vue {
    
    @scala.inline
    def apply(
      $http: Call,
      $resource: (/* url */ String, /* params */ js.UndefOr[js.Object], /* actions */ js.UndefOr[js.Any], /* options */ js.UndefOr[HttpOptions]) => ResourceMethods
    ): Vue = {
      val __obj = js.Dynamic.literal($http = $http.asInstanceOf[js.Any], $resource = js.Any.fromFunction4($resource))
      __obj.asInstanceOf[Vue]
    }
    
    @scala.inline
    implicit class VueMutableBuilder[Self <: Vue] (val x: Self) extends AnyVal {
      
      @scala.inline
      def set$http(value: Call): Self = StObject.set(x, "$http", value.asInstanceOf[js.Any])
      
      @scala.inline
      def set$resource(
        value: (/* url */ String, /* params */ js.UndefOr[js.Object], /* actions */ js.UndefOr[js.Any], /* options */ js.UndefOr[HttpOptions]) => ResourceMethods
      ): Self = StObject.set(x, "$resource", js.Any.fromFunction4(value))
    }
  }
  
  trait VueStatic extends StObject {
    
    var http: Http_
    
    var resource: Resource_
  }
  object VueStatic {
    
    @scala.inline
    def apply(http: Http_, resource: Resource_): VueStatic = {
      val __obj = js.Dynamic.literal(http = http.asInstanceOf[js.Any], resource = resource.asInstanceOf[js.Any])
      __obj.asInstanceOf[VueStatic]
    }
    
    @scala.inline
    implicit class VueStaticMutableBuilder[Self <: VueStatic] (val x: Self) extends AnyVal {
      
      @scala.inline
      def setHttp(value: Http_): Self = StObject.set(x, "http", value.asInstanceOf[js.Any])
      
      @scala.inline
      def setResource(value: Resource_): Self = StObject.set(x, "resource", value.asInstanceOf[js.Any])
    }
  }
  
  @js.native
  trait http extends StObject {
    
    def apply(url: String): js.Thenable[HttpResponse] = js.native
    def apply(url: String, data: js.Any): js.Thenable[HttpResponse] = js.native
    def apply(url: String, data: js.Any, options: HttpOptions): js.Thenable[HttpResponse] = js.native
    def apply(url: String, data: Unit, options: HttpOptions): js.Thenable[HttpResponse] = js.native
    def apply(url: String, options: HttpOptions): js.Thenable[HttpResponse] = js.native
  }
  
  type resource = js.Function4[
    /* url */ String, 
    /* params */ js.UndefOr[js.Object], 
    /* actions */ js.UndefOr[js.Any], 
    /* options */ js.UndefOr[HttpOptions], 
    ResourceMethods
  ]
}
