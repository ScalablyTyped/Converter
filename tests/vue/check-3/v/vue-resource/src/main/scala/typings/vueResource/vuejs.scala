package typings.vueResource

import org.scalablytyped.runtime.StringDictionary
import typings.std.Blob
import typings.std.PromiseLike
import typings.vueResource.anon.Call
import typings.vueResource.anon.HttpOptionsDictkey
import typings.vueResource.anon.Method
import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

object vuejs {
  
  trait ComponentOption extends StObject {
    
    var http: js.UndefOr[HttpOptionsDictkey] = js.undefined
  }
  object ComponentOption {
    
    inline def apply(): ComponentOption = {
      val __obj = js.Dynamic.literal()
      __obj.asInstanceOf[ComponentOption]
    }
    
    extension [Self <: ComponentOption](x: Self) {
      
      inline def setHttp(value: HttpOptionsDictkey): Self = StObject.set(x, "http", value.asInstanceOf[js.Any])
      
      inline def setHttpUndefined: Self = StObject.set(x, "http", js.undefined)
    }
  }
  
  trait HttpHeaders
    extends StObject
       with /* key */ StringDictionary[Any] {
    
    var common: js.UndefOr[StringDictionary[String]] = js.undefined
    
    var custom: js.UndefOr[StringDictionary[String]] = js.undefined
    
    var delete: js.UndefOr[StringDictionary[String]] = js.undefined
    
    var patch: js.UndefOr[StringDictionary[String]] = js.undefined
    
    var post: js.UndefOr[StringDictionary[String]] = js.undefined
    
    var put: js.UndefOr[StringDictionary[String]] = js.undefined
  }
  object HttpHeaders {
    
    inline def apply(): HttpHeaders = {
      val __obj = js.Dynamic.literal()
      __obj.asInstanceOf[HttpHeaders]
    }
    
    extension [Self <: HttpHeaders](x: Self) {
      
      inline def setCommon(value: StringDictionary[String]): Self = StObject.set(x, "common", value.asInstanceOf[js.Any])
      
      inline def setCommonUndefined: Self = StObject.set(x, "common", js.undefined)
      
      inline def setCustom(value: StringDictionary[String]): Self = StObject.set(x, "custom", value.asInstanceOf[js.Any])
      
      inline def setCustomUndefined: Self = StObject.set(x, "custom", js.undefined)
      
      inline def setDelete(value: StringDictionary[String]): Self = StObject.set(x, "delete", value.asInstanceOf[js.Any])
      
      inline def setDeleteUndefined: Self = StObject.set(x, "delete", js.undefined)
      
      inline def setPatch(value: StringDictionary[String]): Self = StObject.set(x, "patch", value.asInstanceOf[js.Any])
      
      inline def setPatchUndefined: Self = StObject.set(x, "patch", js.undefined)
      
      inline def setPost(value: StringDictionary[String]): Self = StObject.set(x, "post", value.asInstanceOf[js.Any])
      
      inline def setPostUndefined: Self = StObject.set(x, "post", js.undefined)
      
      inline def setPut(value: StringDictionary[String]): Self = StObject.set(x, "put", value.asInstanceOf[js.Any])
      
      inline def setPutUndefined: Self = StObject.set(x, "put", js.undefined)
    }
  }
  
  trait HttpInterceptor extends StObject {
    
    var request: js.UndefOr[js.Function1[/* request */ HttpOptions, HttpOptions]] = js.undefined
    
    var response: js.UndefOr[js.Function1[/* response */ HttpResponse, HttpResponse]] = js.undefined
  }
  object HttpInterceptor {
    
    inline def apply(): HttpInterceptor = {
      val __obj = js.Dynamic.literal()
      __obj.asInstanceOf[HttpInterceptor]
    }
    
    extension [Self <: HttpInterceptor](x: Self) {
      
      inline def setRequest(value: /* request */ HttpOptions => HttpOptions): Self = StObject.set(x, "request", js.Any.fromFunction1(value))
      
      inline def setRequestUndefined: Self = StObject.set(x, "request", js.undefined)
      
      inline def setResponse(value: /* response */ HttpResponse => HttpResponse): Self = StObject.set(x, "response", js.Any.fromFunction1(value))
      
      inline def setResponseUndefined: Self = StObject.set(x, "response", js.undefined)
    }
  }
  
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
    
    var url: js.UndefOr[String] = js.undefined
  }
  object HttpOptions {
    
    inline def apply(): HttpOptions = {
      val __obj = js.Dynamic.literal()
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
      
      inline def setUrl(value: String): Self = StObject.set(x, "url", value.asInstanceOf[js.Any])
      
      inline def setUrlUndefined: Self = StObject.set(x, "url", js.undefined)
    }
  }
  
  trait HttpResponse extends StObject {
    
    def blob(): Blob
    
    var data: js.Object
    
    var headers: js.Function
    
    def json(): Any
    
    var ok: Boolean
    
    var status: Double
    
    var statusText: String
    
    def text(): String
  }
  object HttpResponse {
    
    inline def apply(
      blob: () => Blob,
      data: js.Object,
      headers: js.Function,
      json: () => Any,
      ok: Boolean,
      status: Double,
      statusText: String,
      text: () => String
    ): HttpResponse = {
      val __obj = js.Dynamic.literal(blob = js.Any.fromFunction0(blob), data = data.asInstanceOf[js.Any], headers = headers.asInstanceOf[js.Any], json = js.Any.fromFunction0(json), ok = ok.asInstanceOf[js.Any], status = status.asInstanceOf[js.Any], statusText = statusText.asInstanceOf[js.Any], text = js.Any.fromFunction0(text))
      __obj.asInstanceOf[HttpResponse]
    }
    
    extension [Self <: HttpResponse](x: Self) {
      
      inline def setBlob(value: () => Blob): Self = StObject.set(x, "blob", js.Any.fromFunction0(value))
      
      inline def setData(value: js.Object): Self = StObject.set(x, "data", value.asInstanceOf[js.Any])
      
      inline def setHeaders(value: js.Function): Self = StObject.set(x, "headers", value.asInstanceOf[js.Any])
      
      inline def setJson(value: () => Any): Self = StObject.set(x, "json", js.Any.fromFunction0(value))
      
      inline def setOk(value: Boolean): Self = StObject.set(x, "ok", value.asInstanceOf[js.Any])
      
      inline def setStatus(value: Double): Self = StObject.set(x, "status", value.asInstanceOf[js.Any])
      
      inline def setStatusText(value: String): Self = StObject.set(x, "statusText", value.asInstanceOf[js.Any])
      
      inline def setText(value: () => String): Self = StObject.set(x, "text", js.Any.fromFunction0(value))
    }
  }
  
  trait Http_ extends StObject {
    
    def delete(url: String): PromiseLike[HttpResponse]
    def delete(url: String, data: Any): PromiseLike[HttpResponse]
    def delete(url: String, data: Any, options: HttpOptions): PromiseLike[HttpResponse]
    def delete(url: String, data: Unit, options: HttpOptions): PromiseLike[HttpResponse]
    def delete(url: String, options: HttpOptions): PromiseLike[HttpResponse]
    @JSName("delete")
    var delete_Original: http
    
    def get(url: String): PromiseLike[HttpResponse]
    def get(url: String, data: Any): PromiseLike[HttpResponse]
    def get(url: String, data: Any, options: HttpOptions): PromiseLike[HttpResponse]
    def get(url: String, data: Unit, options: HttpOptions): PromiseLike[HttpResponse]
    def get(url: String, options: HttpOptions): PromiseLike[HttpResponse]
    @JSName("get")
    var get_Original: http
    
    var headers: HttpHeaders
    
    var interceptors: js.Array[HttpInterceptor | js.Function0[HttpInterceptor]]
    
    def jsonp(url: String): PromiseLike[HttpResponse]
    def jsonp(url: String, data: Any): PromiseLike[HttpResponse]
    def jsonp(url: String, data: Any, options: HttpOptions): PromiseLike[HttpResponse]
    def jsonp(url: String, data: Unit, options: HttpOptions): PromiseLike[HttpResponse]
    def jsonp(url: String, options: HttpOptions): PromiseLike[HttpResponse]
    @JSName("jsonp")
    var jsonp_Original: http
    
    var options: typings.vueResource.anon.HttpOptions
    
    def patch(url: String): PromiseLike[HttpResponse]
    def patch(url: String, data: Any): PromiseLike[HttpResponse]
    def patch(url: String, data: Any, options: HttpOptions): PromiseLike[HttpResponse]
    def patch(url: String, data: Unit, options: HttpOptions): PromiseLike[HttpResponse]
    def patch(url: String, options: HttpOptions): PromiseLike[HttpResponse]
    @JSName("patch")
    var patch_Original: http
    
    def post(url: String): PromiseLike[HttpResponse]
    def post(url: String, data: Any): PromiseLike[HttpResponse]
    def post(url: String, data: Any, options: HttpOptions): PromiseLike[HttpResponse]
    def post(url: String, data: Unit, options: HttpOptions): PromiseLike[HttpResponse]
    def post(url: String, options: HttpOptions): PromiseLike[HttpResponse]
    @JSName("post")
    var post_Original: http
    
    def put(url: String): PromiseLike[HttpResponse]
    def put(url: String, data: Any): PromiseLike[HttpResponse]
    def put(url: String, data: Any, options: HttpOptions): PromiseLike[HttpResponse]
    def put(url: String, data: Unit, options: HttpOptions): PromiseLike[HttpResponse]
    def put(url: String, options: HttpOptions): PromiseLike[HttpResponse]
    @JSName("put")
    var put_Original: http
  }
  object Http_ {
    
    inline def apply(
      delete: http,
      get: http,
      headers: HttpHeaders,
      interceptors: js.Array[HttpInterceptor | js.Function0[HttpInterceptor]],
      jsonp: http,
      options: typings.vueResource.anon.HttpOptions,
      patch: http,
      post: http,
      put: http
    ): Http_ = {
      val __obj = js.Dynamic.literal(delete = delete.asInstanceOf[js.Any], get = get.asInstanceOf[js.Any], headers = headers.asInstanceOf[js.Any], interceptors = interceptors.asInstanceOf[js.Any], jsonp = jsonp.asInstanceOf[js.Any], options = options.asInstanceOf[js.Any], patch = patch.asInstanceOf[js.Any], post = post.asInstanceOf[js.Any], put = put.asInstanceOf[js.Any])
      __obj.asInstanceOf[Http_]
    }
    
    extension [Self <: Http_](x: Self) {
      
      inline def setDelete(value: http): Self = StObject.set(x, "delete", value.asInstanceOf[js.Any])
      
      inline def setGet(value: http): Self = StObject.set(x, "get", value.asInstanceOf[js.Any])
      
      inline def setHeaders(value: HttpHeaders): Self = StObject.set(x, "headers", value.asInstanceOf[js.Any])
      
      inline def setInterceptors(value: js.Array[HttpInterceptor | js.Function0[HttpInterceptor]]): Self = StObject.set(x, "interceptors", value.asInstanceOf[js.Any])
      
      inline def setInterceptorsVarargs(value: (HttpInterceptor | js.Function0[HttpInterceptor])*): Self = StObject.set(x, "interceptors", js.Array(value*))
      
      inline def setJsonp(value: http): Self = StObject.set(x, "jsonp", value.asInstanceOf[js.Any])
      
      inline def setOptions(value: typings.vueResource.anon.HttpOptions): Self = StObject.set(x, "options", value.asInstanceOf[js.Any])
      
      inline def setPatch(value: http): Self = StObject.set(x, "patch", value.asInstanceOf[js.Any])
      
      inline def setPost(value: http): Self = StObject.set(x, "post", value.asInstanceOf[js.Any])
      
      inline def setPut(value: http): Self = StObject.set(x, "put", value.asInstanceOf[js.Any])
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
    
    inline def apply(delete: Method, get: Method, query: Method, remove: Method, save: Method, update: Method): ResourceActions = {
      val __obj = js.Dynamic.literal(delete = delete.asInstanceOf[js.Any], get = get.asInstanceOf[js.Any], query = query.asInstanceOf[js.Any], remove = remove.asInstanceOf[js.Any], save = save.asInstanceOf[js.Any], update = update.asInstanceOf[js.Any])
      __obj.asInstanceOf[ResourceActions]
    }
    
    extension [Self <: ResourceActions](x: Self) {
      
      inline def setDelete(value: Method): Self = StObject.set(x, "delete", value.asInstanceOf[js.Any])
      
      inline def setGet(value: Method): Self = StObject.set(x, "get", value.asInstanceOf[js.Any])
      
      inline def setQuery(value: Method): Self = StObject.set(x, "query", value.asInstanceOf[js.Any])
      
      inline def setRemove(value: Method): Self = StObject.set(x, "remove", value.asInstanceOf[js.Any])
      
      inline def setSave(value: Method): Self = StObject.set(x, "save", value.asInstanceOf[js.Any])
      
      inline def setUpdate(value: Method): Self = StObject.set(x, "update", value.asInstanceOf[js.Any])
    }
  }
  
  @js.native
  trait ResourceMethod extends StObject {
    
    def apply(): PromiseLike[HttpResponse] = js.native
    def apply(params: Any): PromiseLike[HttpResponse] = js.native
    def apply(params: Any, data: Any): PromiseLike[HttpResponse] = js.native
    def apply(params: Any, data: Any, success: js.Function): PromiseLike[HttpResponse] = js.native
    def apply(params: Any, data: Any, success: js.Function, error: js.Function): PromiseLike[HttpResponse] = js.native
    def apply(params: Any, data: Any, success: Unit, error: js.Function): PromiseLike[HttpResponse] = js.native
    def apply(params: Any, data: Unit, success: js.Function): PromiseLike[HttpResponse] = js.native
    def apply(params: Any, data: Unit, success: js.Function, error: js.Function): PromiseLike[HttpResponse] = js.native
    def apply(params: Any, data: Unit, success: Unit, error: js.Function): PromiseLike[HttpResponse] = js.native
    def apply(params: Any, success: js.Function): PromiseLike[HttpResponse] = js.native
    def apply(params: Any, success: js.Function, error: js.Function): PromiseLike[HttpResponse] = js.native
    def apply(success: js.Function): PromiseLike[HttpResponse] = js.native
    def apply(success: js.Function, error: js.Function): PromiseLike[HttpResponse] = js.native
    def apply(success: Unit, error: js.Function): PromiseLike[HttpResponse] = js.native
  }
  
  trait ResourceMethods extends StObject {
    
    def delete(): PromiseLike[HttpResponse]
    def delete(params: Any): PromiseLike[HttpResponse]
    def delete(params: Any, data: Any): PromiseLike[HttpResponse]
    def delete(params: Any, data: Any, success: js.Function): PromiseLike[HttpResponse]
    def delete(params: Any, data: Any, success: js.Function, error: js.Function): PromiseLike[HttpResponse]
    def delete(params: Any, data: Any, success: Unit, error: js.Function): PromiseLike[HttpResponse]
    def delete(params: Any, data: Unit, success: js.Function): PromiseLike[HttpResponse]
    def delete(params: Any, data: Unit, success: js.Function, error: js.Function): PromiseLike[HttpResponse]
    def delete(params: Any, data: Unit, success: Unit, error: js.Function): PromiseLike[HttpResponse]
    def delete(params: Any, success: js.Function): PromiseLike[HttpResponse]
    def delete(params: Any, success: js.Function, error: js.Function): PromiseLike[HttpResponse]
    def delete(success: js.Function): PromiseLike[HttpResponse]
    def delete(success: js.Function, error: js.Function): PromiseLike[HttpResponse]
    def delete(success: Unit, error: js.Function): PromiseLike[HttpResponse]
    @JSName("delete")
    var delete_Original: ResourceMethod
    
    def get(): PromiseLike[HttpResponse]
    def get(params: Any): PromiseLike[HttpResponse]
    def get(params: Any, data: Any): PromiseLike[HttpResponse]
    def get(params: Any, data: Any, success: js.Function): PromiseLike[HttpResponse]
    def get(params: Any, data: Any, success: js.Function, error: js.Function): PromiseLike[HttpResponse]
    def get(params: Any, data: Any, success: Unit, error: js.Function): PromiseLike[HttpResponse]
    def get(params: Any, data: Unit, success: js.Function): PromiseLike[HttpResponse]
    def get(params: Any, data: Unit, success: js.Function, error: js.Function): PromiseLike[HttpResponse]
    def get(params: Any, data: Unit, success: Unit, error: js.Function): PromiseLike[HttpResponse]
    def get(params: Any, success: js.Function): PromiseLike[HttpResponse]
    def get(params: Any, success: js.Function, error: js.Function): PromiseLike[HttpResponse]
    def get(success: js.Function): PromiseLike[HttpResponse]
    def get(success: js.Function, error: js.Function): PromiseLike[HttpResponse]
    def get(success: Unit, error: js.Function): PromiseLike[HttpResponse]
    @JSName("get")
    var get_Original: ResourceMethod
    
    def query(): PromiseLike[HttpResponse]
    def query(params: Any): PromiseLike[HttpResponse]
    def query(params: Any, data: Any): PromiseLike[HttpResponse]
    def query(params: Any, data: Any, success: js.Function): PromiseLike[HttpResponse]
    def query(params: Any, data: Any, success: js.Function, error: js.Function): PromiseLike[HttpResponse]
    def query(params: Any, data: Any, success: Unit, error: js.Function): PromiseLike[HttpResponse]
    def query(params: Any, data: Unit, success: js.Function): PromiseLike[HttpResponse]
    def query(params: Any, data: Unit, success: js.Function, error: js.Function): PromiseLike[HttpResponse]
    def query(params: Any, data: Unit, success: Unit, error: js.Function): PromiseLike[HttpResponse]
    def query(params: Any, success: js.Function): PromiseLike[HttpResponse]
    def query(params: Any, success: js.Function, error: js.Function): PromiseLike[HttpResponse]
    def query(success: js.Function): PromiseLike[HttpResponse]
    def query(success: js.Function, error: js.Function): PromiseLike[HttpResponse]
    def query(success: Unit, error: js.Function): PromiseLike[HttpResponse]
    @JSName("query")
    var query_Original: ResourceMethod
    
    def remove(): PromiseLike[HttpResponse]
    def remove(params: Any): PromiseLike[HttpResponse]
    def remove(params: Any, data: Any): PromiseLike[HttpResponse]
    def remove(params: Any, data: Any, success: js.Function): PromiseLike[HttpResponse]
    def remove(params: Any, data: Any, success: js.Function, error: js.Function): PromiseLike[HttpResponse]
    def remove(params: Any, data: Any, success: Unit, error: js.Function): PromiseLike[HttpResponse]
    def remove(params: Any, data: Unit, success: js.Function): PromiseLike[HttpResponse]
    def remove(params: Any, data: Unit, success: js.Function, error: js.Function): PromiseLike[HttpResponse]
    def remove(params: Any, data: Unit, success: Unit, error: js.Function): PromiseLike[HttpResponse]
    def remove(params: Any, success: js.Function): PromiseLike[HttpResponse]
    def remove(params: Any, success: js.Function, error: js.Function): PromiseLike[HttpResponse]
    def remove(success: js.Function): PromiseLike[HttpResponse]
    def remove(success: js.Function, error: js.Function): PromiseLike[HttpResponse]
    def remove(success: Unit, error: js.Function): PromiseLike[HttpResponse]
    @JSName("remove")
    var remove_Original: ResourceMethod
    
    def save(): PromiseLike[HttpResponse]
    def save(params: Any): PromiseLike[HttpResponse]
    def save(params: Any, data: Any): PromiseLike[HttpResponse]
    def save(params: Any, data: Any, success: js.Function): PromiseLike[HttpResponse]
    def save(params: Any, data: Any, success: js.Function, error: js.Function): PromiseLike[HttpResponse]
    def save(params: Any, data: Any, success: Unit, error: js.Function): PromiseLike[HttpResponse]
    def save(params: Any, data: Unit, success: js.Function): PromiseLike[HttpResponse]
    def save(params: Any, data: Unit, success: js.Function, error: js.Function): PromiseLike[HttpResponse]
    def save(params: Any, data: Unit, success: Unit, error: js.Function): PromiseLike[HttpResponse]
    def save(params: Any, success: js.Function): PromiseLike[HttpResponse]
    def save(params: Any, success: js.Function, error: js.Function): PromiseLike[HttpResponse]
    def save(success: js.Function): PromiseLike[HttpResponse]
    def save(success: js.Function, error: js.Function): PromiseLike[HttpResponse]
    def save(success: Unit, error: js.Function): PromiseLike[HttpResponse]
    @JSName("save")
    var save_Original: ResourceMethod
    
    def update(): PromiseLike[HttpResponse]
    def update(params: Any): PromiseLike[HttpResponse]
    def update(params: Any, data: Any): PromiseLike[HttpResponse]
    def update(params: Any, data: Any, success: js.Function): PromiseLike[HttpResponse]
    def update(params: Any, data: Any, success: js.Function, error: js.Function): PromiseLike[HttpResponse]
    def update(params: Any, data: Any, success: Unit, error: js.Function): PromiseLike[HttpResponse]
    def update(params: Any, data: Unit, success: js.Function): PromiseLike[HttpResponse]
    def update(params: Any, data: Unit, success: js.Function, error: js.Function): PromiseLike[HttpResponse]
    def update(params: Any, data: Unit, success: Unit, error: js.Function): PromiseLike[HttpResponse]
    def update(params: Any, success: js.Function): PromiseLike[HttpResponse]
    def update(params: Any, success: js.Function, error: js.Function): PromiseLike[HttpResponse]
    def update(success: js.Function): PromiseLike[HttpResponse]
    def update(success: js.Function, error: js.Function): PromiseLike[HttpResponse]
    def update(success: Unit, error: js.Function): PromiseLike[HttpResponse]
    @JSName("update")
    var update_Original: ResourceMethod
  }
  object ResourceMethods {
    
    inline def apply(
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
    
    extension [Self <: ResourceMethods](x: Self) {
      
      inline def setDelete(value: ResourceMethod): Self = StObject.set(x, "delete", value.asInstanceOf[js.Any])
      
      inline def setGet(value: ResourceMethod): Self = StObject.set(x, "get", value.asInstanceOf[js.Any])
      
      inline def setQuery(value: ResourceMethod): Self = StObject.set(x, "query", value.asInstanceOf[js.Any])
      
      inline def setRemove(value: ResourceMethod): Self = StObject.set(x, "remove", value.asInstanceOf[js.Any])
      
      inline def setSave(value: ResourceMethod): Self = StObject.set(x, "save", value.asInstanceOf[js.Any])
      
      inline def setUpdate(value: ResourceMethod): Self = StObject.set(x, "update", value.asInstanceOf[js.Any])
    }
  }
  
  @js.native
  trait Resource_ extends resource {
    
    var actions: ResourceActions = js.native
  }
  
  trait Vue extends StObject {
    
    @JSName("$http")
    def $http(options: HttpOptions): PromiseLike[HttpResponse]
    @JSName("$http")
    var $http_Original: Call
    
    @JSName("$resource")
    def $resource(url: String): ResourceMethods
    @JSName("$resource")
    def $resource(url: String, params: js.Object): ResourceMethods
    @JSName("$resource")
    def $resource(url: String, params: js.Object, actions: Any): ResourceMethods
    @JSName("$resource")
    def $resource(url: String, params: js.Object, actions: Any, options: HttpOptions): ResourceMethods
    @JSName("$resource")
    def $resource(url: String, params: js.Object, actions: Unit, options: HttpOptions): ResourceMethods
    @JSName("$resource")
    def $resource(url: String, params: Unit, actions: Any): ResourceMethods
    @JSName("$resource")
    def $resource(url: String, params: Unit, actions: Any, options: HttpOptions): ResourceMethods
    @JSName("$resource")
    def $resource(url: String, params: Unit, actions: Unit, options: HttpOptions): ResourceMethods
    @JSName("$resource")
    var $resource_Original: resource
  }
  object Vue {
    
    inline def apply(
      $http: Call,
      $resource: (/* url */ String, /* params */ js.UndefOr[js.Object], /* actions */ js.UndefOr[Any], /* options */ js.UndefOr[HttpOptions]) => ResourceMethods
    ): Vue = {
      val __obj = js.Dynamic.literal($http = $http.asInstanceOf[js.Any], $resource = js.Any.fromFunction4($resource))
      __obj.asInstanceOf[Vue]
    }
    
    extension [Self <: Vue](x: Self) {
      
      inline def set$http(value: Call): Self = StObject.set(x, "$http", value.asInstanceOf[js.Any])
      
      inline def set$resource(
        value: (/* url */ String, /* params */ js.UndefOr[js.Object], /* actions */ js.UndefOr[Any], /* options */ js.UndefOr[HttpOptions]) => ResourceMethods
      ): Self = StObject.set(x, "$resource", js.Any.fromFunction4(value))
    }
  }
  
  trait VueStatic extends StObject {
    
    var http: Http_
    
    var resource: Resource_
  }
  object VueStatic {
    
    inline def apply(http: Http_, resource: Resource_): VueStatic = {
      val __obj = js.Dynamic.literal(http = http.asInstanceOf[js.Any], resource = resource.asInstanceOf[js.Any])
      __obj.asInstanceOf[VueStatic]
    }
    
    extension [Self <: VueStatic](x: Self) {
      
      inline def setHttp(value: Http_): Self = StObject.set(x, "http", value.asInstanceOf[js.Any])
      
      inline def setResource(value: Resource_): Self = StObject.set(x, "resource", value.asInstanceOf[js.Any])
    }
  }
  
  @js.native
  trait http extends StObject {
    
    def apply(url: String): PromiseLike[HttpResponse] = js.native
    def apply(url: String, data: Any): PromiseLike[HttpResponse] = js.native
    def apply(url: String, data: Any, options: HttpOptions): PromiseLike[HttpResponse] = js.native
    def apply(url: String, data: Unit, options: HttpOptions): PromiseLike[HttpResponse] = js.native
    def apply(url: String, options: HttpOptions): PromiseLike[HttpResponse] = js.native
  }
  
  type resource = js.Function4[
    /* url */ String, 
    /* params */ js.UndefOr[js.Object], 
    /* actions */ js.UndefOr[Any], 
    /* options */ js.UndefOr[HttpOptions], 
    ResourceMethods
  ]
}
