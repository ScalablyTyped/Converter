package typings.vueResource

import org.scalablytyped.runtime.StringDictionary
import typings.std.Blob
import typings.vueResource.anon.Call
import typings.vueResource.anon.HttpOptionsrootstring
import typings.vueResource.anon.Method
import typings.vueResource.anon.headersHttpHeadersundefin
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

object vuejs {
  
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
  
  @js.native
  trait HttpHeaders
    extends /* key */ StringDictionary[js.Any] {
    
    var common: js.UndefOr[StringDictionary[String]] = js.native
    
    var custom: js.UndefOr[StringDictionary[String]] = js.native
    
    var delete: js.UndefOr[StringDictionary[String]] = js.native
    
    var patch: js.UndefOr[StringDictionary[String]] = js.native
    
    var post: js.UndefOr[StringDictionary[String]] = js.native
    
    var put: js.UndefOr[StringDictionary[String]] = js.native
  }
  object HttpHeaders {
    
    @scala.inline
    def apply(): HttpHeaders = {
      val __obj = js.Dynamic.literal()
      __obj.asInstanceOf[HttpHeaders]
    }
    
    @scala.inline
    implicit class HttpHeadersOps[Self <: HttpHeaders] (val x: Self) extends AnyVal {
      
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
      def setCommon(value: StringDictionary[String]): Self = this.set("common", value.asInstanceOf[js.Any])
      
      @scala.inline
      def deleteCommon: Self = this.set("common", js.undefined)
      
      @scala.inline
      def setCustom(value: StringDictionary[String]): Self = this.set("custom", value.asInstanceOf[js.Any])
      
      @scala.inline
      def deleteCustom: Self = this.set("custom", js.undefined)
      
      @scala.inline
      def setDelete(value: StringDictionary[String]): Self = this.set("delete", value.asInstanceOf[js.Any])
      
      @scala.inline
      def deleteDelete: Self = this.set("delete", js.undefined)
      
      @scala.inline
      def setPatch(value: StringDictionary[String]): Self = this.set("patch", value.asInstanceOf[js.Any])
      
      @scala.inline
      def deletePatch: Self = this.set("patch", js.undefined)
      
      @scala.inline
      def setPost(value: StringDictionary[String]): Self = this.set("post", value.asInstanceOf[js.Any])
      
      @scala.inline
      def deletePost: Self = this.set("post", js.undefined)
      
      @scala.inline
      def setPut(value: StringDictionary[String]): Self = this.set("put", value.asInstanceOf[js.Any])
      
      @scala.inline
      def deletePut: Self = this.set("put", js.undefined)
    }
  }
  
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
  
  @js.native
  trait HttpOptions extends js.Object {
    
    var before: js.UndefOr[js.Function1[/* request */ js.Any, _]] = js.native
    
    var body: js.UndefOr[js.Any] = js.native
    
    var credentials: js.UndefOr[Boolean] = js.native
    
    var emulateHTTP: js.UndefOr[Boolean] = js.native
    
    var emulateJSON: js.UndefOr[Boolean] = js.native
    
    var headers: js.UndefOr[js.Any] = js.native
    
    var method: js.UndefOr[String] = js.native
    
    var params: js.UndefOr[js.Any] = js.native
    
    var progress: js.UndefOr[js.Function1[/* event */ js.Any, _]] = js.native
    
    var url: js.UndefOr[String] = js.native
  }
  object HttpOptions {
    
    @scala.inline
    def apply(): HttpOptions = {
      val __obj = js.Dynamic.literal()
      __obj.asInstanceOf[HttpOptions]
    }
    
    @scala.inline
    implicit class HttpOptionsOps[Self <: HttpOptions] (val x: Self) extends AnyVal {
      
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
  trait HttpResponse extends js.Object {
    
    def blob(): Blob = js.native
    
    var data: js.Object = js.native
    
    var headers: js.Function = js.native
    
    def json(): js.Any = js.native
    
    var ok: Boolean = js.native
    
    var status: Double = js.native
    
    var statusText: String = js.native
    
    def text(): String = js.native
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
    implicit class HttpResponseOps[Self <: HttpResponse] (val x: Self) extends AnyVal {
      
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
      def setBlob(value: () => Blob): Self = this.set("blob", js.Any.fromFunction0(value))
      
      @scala.inline
      def setData(value: js.Object): Self = this.set("data", value.asInstanceOf[js.Any])
      
      @scala.inline
      def setHeaders(value: js.Function): Self = this.set("headers", value.asInstanceOf[js.Any])
      
      @scala.inline
      def setJson(value: () => js.Any): Self = this.set("json", js.Any.fromFunction0(value))
      
      @scala.inline
      def setOk(value: Boolean): Self = this.set("ok", value.asInstanceOf[js.Any])
      
      @scala.inline
      def setStatus(value: Double): Self = this.set("status", value.asInstanceOf[js.Any])
      
      @scala.inline
      def setStatusText(value: String): Self = this.set("statusText", value.asInstanceOf[js.Any])
      
      @scala.inline
      def setText(value: () => String): Self = this.set("text", js.Any.fromFunction0(value))
    }
  }
  
  @js.native
  trait Http_ extends js.Object {
    
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
    
    var headers: HttpHeaders = js.native
    
    var interceptors: js.Array[HttpInterceptor | js.Function0[HttpInterceptor]] = js.native
    
    def jsonp(url: String): js.Thenable[HttpResponse] = js.native
    def jsonp(url: String, data: js.UndefOr[scala.Nothing], options: HttpOptions): js.Thenable[HttpResponse] = js.native
    def jsonp(url: String, data: js.Any): js.Thenable[HttpResponse] = js.native
    def jsonp(url: String, data: js.Any, options: HttpOptions): js.Thenable[HttpResponse] = js.native
    def jsonp(url: String, options: HttpOptions): js.Thenable[HttpResponse] = js.native
    @JSName("jsonp")
    var jsonp_Original: http = js.native
    
    var options: HttpOptionsrootstring = js.native
    
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
  
  @js.native
  trait ResourceActions extends js.Object {
    
    var delete: Method = js.native
    
    var get: Method = js.native
    
    var query: Method = js.native
    
    var remove: Method = js.native
    
    var save: Method = js.native
    
    var update: Method = js.native
  }
  object ResourceActions {
    
    @scala.inline
    def apply(delete: Method, get: Method, query: Method, remove: Method, save: Method, update: Method): ResourceActions = {
      val __obj = js.Dynamic.literal(delete = delete.asInstanceOf[js.Any], get = get.asInstanceOf[js.Any], query = query.asInstanceOf[js.Any], remove = remove.asInstanceOf[js.Any], save = save.asInstanceOf[js.Any], update = update.asInstanceOf[js.Any])
      __obj.asInstanceOf[ResourceActions]
    }
    
    @scala.inline
    implicit class ResourceActionsOps[Self <: ResourceActions] (val x: Self) extends AnyVal {
      
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
      def setDelete(value: Method): Self = this.set("delete", value.asInstanceOf[js.Any])
      
      @scala.inline
      def setGet(value: Method): Self = this.set("get", value.asInstanceOf[js.Any])
      
      @scala.inline
      def setQuery(value: Method): Self = this.set("query", value.asInstanceOf[js.Any])
      
      @scala.inline
      def setRemove(value: Method): Self = this.set("remove", value.asInstanceOf[js.Any])
      
      @scala.inline
      def setSave(value: Method): Self = this.set("save", value.asInstanceOf[js.Any])
      
      @scala.inline
      def setUpdate(value: Method): Self = this.set("update", value.asInstanceOf[js.Any])
    }
  }
  
  @js.native
  trait ResourceMethod extends js.Object {
    
    def apply(): js.Thenable[HttpResponse] = js.native
    def apply(params: js.Any): js.Thenable[HttpResponse] = js.native
    def apply(
      params: js.Any,
      data: js.UndefOr[scala.Nothing],
      success: js.UndefOr[scala.Nothing],
      error: js.Function
    ): js.Thenable[HttpResponse] = js.native
    def apply(params: js.Any, data: js.UndefOr[scala.Nothing], success: js.Function): js.Thenable[HttpResponse] = js.native
    def apply(params: js.Any, data: js.UndefOr[scala.Nothing], success: js.Function, error: js.Function): js.Thenable[HttpResponse] = js.native
    def apply(params: js.Any, data: js.Any): js.Thenable[HttpResponse] = js.native
    def apply(params: js.Any, data: js.Any, success: js.UndefOr[scala.Nothing], error: js.Function): js.Thenable[HttpResponse] = js.native
    def apply(params: js.Any, data: js.Any, success: js.Function): js.Thenable[HttpResponse] = js.native
    def apply(params: js.Any, data: js.Any, success: js.Function, error: js.Function): js.Thenable[HttpResponse] = js.native
    def apply(params: js.Any, success: js.Function): js.Thenable[HttpResponse] = js.native
    def apply(params: js.Any, success: js.Function, error: js.Function): js.Thenable[HttpResponse] = js.native
    def apply(success: js.UndefOr[scala.Nothing], error: js.Function): js.Thenable[HttpResponse] = js.native
    def apply(success: js.Function): js.Thenable[HttpResponse] = js.native
    def apply(success: js.Function, error: js.Function): js.Thenable[HttpResponse] = js.native
  }
  
  @js.native
  trait ResourceMethods extends js.Object {
    
    def delete(): js.Thenable[HttpResponse] = js.native
    def delete(params: js.Any): js.Thenable[HttpResponse] = js.native
    def delete(
      params: js.Any,
      data: js.UndefOr[scala.Nothing],
      success: js.UndefOr[scala.Nothing],
      error: js.Function
    ): js.Thenable[HttpResponse] = js.native
    def delete(params: js.Any, data: js.UndefOr[scala.Nothing], success: js.Function): js.Thenable[HttpResponse] = js.native
    def delete(params: js.Any, data: js.UndefOr[scala.Nothing], success: js.Function, error: js.Function): js.Thenable[HttpResponse] = js.native
    def delete(params: js.Any, data: js.Any): js.Thenable[HttpResponse] = js.native
    def delete(params: js.Any, data: js.Any, success: js.UndefOr[scala.Nothing], error: js.Function): js.Thenable[HttpResponse] = js.native
    def delete(params: js.Any, data: js.Any, success: js.Function): js.Thenable[HttpResponse] = js.native
    def delete(params: js.Any, data: js.Any, success: js.Function, error: js.Function): js.Thenable[HttpResponse] = js.native
    def delete(params: js.Any, success: js.Function): js.Thenable[HttpResponse] = js.native
    def delete(params: js.Any, success: js.Function, error: js.Function): js.Thenable[HttpResponse] = js.native
    def delete(success: js.UndefOr[scala.Nothing], error: js.Function): js.Thenable[HttpResponse] = js.native
    def delete(success: js.Function): js.Thenable[HttpResponse] = js.native
    def delete(success: js.Function, error: js.Function): js.Thenable[HttpResponse] = js.native
    @JSName("delete")
    var delete_Original: ResourceMethod = js.native
    
    def get(): js.Thenable[HttpResponse] = js.native
    def get(params: js.Any): js.Thenable[HttpResponse] = js.native
    def get(
      params: js.Any,
      data: js.UndefOr[scala.Nothing],
      success: js.UndefOr[scala.Nothing],
      error: js.Function
    ): js.Thenable[HttpResponse] = js.native
    def get(params: js.Any, data: js.UndefOr[scala.Nothing], success: js.Function): js.Thenable[HttpResponse] = js.native
    def get(params: js.Any, data: js.UndefOr[scala.Nothing], success: js.Function, error: js.Function): js.Thenable[HttpResponse] = js.native
    def get(params: js.Any, data: js.Any): js.Thenable[HttpResponse] = js.native
    def get(params: js.Any, data: js.Any, success: js.UndefOr[scala.Nothing], error: js.Function): js.Thenable[HttpResponse] = js.native
    def get(params: js.Any, data: js.Any, success: js.Function): js.Thenable[HttpResponse] = js.native
    def get(params: js.Any, data: js.Any, success: js.Function, error: js.Function): js.Thenable[HttpResponse] = js.native
    def get(params: js.Any, success: js.Function): js.Thenable[HttpResponse] = js.native
    def get(params: js.Any, success: js.Function, error: js.Function): js.Thenable[HttpResponse] = js.native
    def get(success: js.UndefOr[scala.Nothing], error: js.Function): js.Thenable[HttpResponse] = js.native
    def get(success: js.Function): js.Thenable[HttpResponse] = js.native
    def get(success: js.Function, error: js.Function): js.Thenable[HttpResponse] = js.native
    @JSName("get")
    var get_Original: ResourceMethod = js.native
    
    def query(): js.Thenable[HttpResponse] = js.native
    def query(params: js.Any): js.Thenable[HttpResponse] = js.native
    def query(
      params: js.Any,
      data: js.UndefOr[scala.Nothing],
      success: js.UndefOr[scala.Nothing],
      error: js.Function
    ): js.Thenable[HttpResponse] = js.native
    def query(params: js.Any, data: js.UndefOr[scala.Nothing], success: js.Function): js.Thenable[HttpResponse] = js.native
    def query(params: js.Any, data: js.UndefOr[scala.Nothing], success: js.Function, error: js.Function): js.Thenable[HttpResponse] = js.native
    def query(params: js.Any, data: js.Any): js.Thenable[HttpResponse] = js.native
    def query(params: js.Any, data: js.Any, success: js.UndefOr[scala.Nothing], error: js.Function): js.Thenable[HttpResponse] = js.native
    def query(params: js.Any, data: js.Any, success: js.Function): js.Thenable[HttpResponse] = js.native
    def query(params: js.Any, data: js.Any, success: js.Function, error: js.Function): js.Thenable[HttpResponse] = js.native
    def query(params: js.Any, success: js.Function): js.Thenable[HttpResponse] = js.native
    def query(params: js.Any, success: js.Function, error: js.Function): js.Thenable[HttpResponse] = js.native
    def query(success: js.UndefOr[scala.Nothing], error: js.Function): js.Thenable[HttpResponse] = js.native
    def query(success: js.Function): js.Thenable[HttpResponse] = js.native
    def query(success: js.Function, error: js.Function): js.Thenable[HttpResponse] = js.native
    @JSName("query")
    var query_Original: ResourceMethod = js.native
    
    def remove(): js.Thenable[HttpResponse] = js.native
    def remove(params: js.Any): js.Thenable[HttpResponse] = js.native
    def remove(
      params: js.Any,
      data: js.UndefOr[scala.Nothing],
      success: js.UndefOr[scala.Nothing],
      error: js.Function
    ): js.Thenable[HttpResponse] = js.native
    def remove(params: js.Any, data: js.UndefOr[scala.Nothing], success: js.Function): js.Thenable[HttpResponse] = js.native
    def remove(params: js.Any, data: js.UndefOr[scala.Nothing], success: js.Function, error: js.Function): js.Thenable[HttpResponse] = js.native
    def remove(params: js.Any, data: js.Any): js.Thenable[HttpResponse] = js.native
    def remove(params: js.Any, data: js.Any, success: js.UndefOr[scala.Nothing], error: js.Function): js.Thenable[HttpResponse] = js.native
    def remove(params: js.Any, data: js.Any, success: js.Function): js.Thenable[HttpResponse] = js.native
    def remove(params: js.Any, data: js.Any, success: js.Function, error: js.Function): js.Thenable[HttpResponse] = js.native
    def remove(params: js.Any, success: js.Function): js.Thenable[HttpResponse] = js.native
    def remove(params: js.Any, success: js.Function, error: js.Function): js.Thenable[HttpResponse] = js.native
    def remove(success: js.UndefOr[scala.Nothing], error: js.Function): js.Thenable[HttpResponse] = js.native
    def remove(success: js.Function): js.Thenable[HttpResponse] = js.native
    def remove(success: js.Function, error: js.Function): js.Thenable[HttpResponse] = js.native
    @JSName("remove")
    var remove_Original: ResourceMethod = js.native
    
    def save(): js.Thenable[HttpResponse] = js.native
    def save(params: js.Any): js.Thenable[HttpResponse] = js.native
    def save(
      params: js.Any,
      data: js.UndefOr[scala.Nothing],
      success: js.UndefOr[scala.Nothing],
      error: js.Function
    ): js.Thenable[HttpResponse] = js.native
    def save(params: js.Any, data: js.UndefOr[scala.Nothing], success: js.Function): js.Thenable[HttpResponse] = js.native
    def save(params: js.Any, data: js.UndefOr[scala.Nothing], success: js.Function, error: js.Function): js.Thenable[HttpResponse] = js.native
    def save(params: js.Any, data: js.Any): js.Thenable[HttpResponse] = js.native
    def save(params: js.Any, data: js.Any, success: js.UndefOr[scala.Nothing], error: js.Function): js.Thenable[HttpResponse] = js.native
    def save(params: js.Any, data: js.Any, success: js.Function): js.Thenable[HttpResponse] = js.native
    def save(params: js.Any, data: js.Any, success: js.Function, error: js.Function): js.Thenable[HttpResponse] = js.native
    def save(params: js.Any, success: js.Function): js.Thenable[HttpResponse] = js.native
    def save(params: js.Any, success: js.Function, error: js.Function): js.Thenable[HttpResponse] = js.native
    def save(success: js.UndefOr[scala.Nothing], error: js.Function): js.Thenable[HttpResponse] = js.native
    def save(success: js.Function): js.Thenable[HttpResponse] = js.native
    def save(success: js.Function, error: js.Function): js.Thenable[HttpResponse] = js.native
    @JSName("save")
    var save_Original: ResourceMethod = js.native
    
    def update(): js.Thenable[HttpResponse] = js.native
    def update(params: js.Any): js.Thenable[HttpResponse] = js.native
    def update(
      params: js.Any,
      data: js.UndefOr[scala.Nothing],
      success: js.UndefOr[scala.Nothing],
      error: js.Function
    ): js.Thenable[HttpResponse] = js.native
    def update(params: js.Any, data: js.UndefOr[scala.Nothing], success: js.Function): js.Thenable[HttpResponse] = js.native
    def update(params: js.Any, data: js.UndefOr[scala.Nothing], success: js.Function, error: js.Function): js.Thenable[HttpResponse] = js.native
    def update(params: js.Any, data: js.Any): js.Thenable[HttpResponse] = js.native
    def update(params: js.Any, data: js.Any, success: js.UndefOr[scala.Nothing], error: js.Function): js.Thenable[HttpResponse] = js.native
    def update(params: js.Any, data: js.Any, success: js.Function): js.Thenable[HttpResponse] = js.native
    def update(params: js.Any, data: js.Any, success: js.Function, error: js.Function): js.Thenable[HttpResponse] = js.native
    def update(params: js.Any, success: js.Function): js.Thenable[HttpResponse] = js.native
    def update(params: js.Any, success: js.Function, error: js.Function): js.Thenable[HttpResponse] = js.native
    def update(success: js.UndefOr[scala.Nothing], error: js.Function): js.Thenable[HttpResponse] = js.native
    def update(success: js.Function): js.Thenable[HttpResponse] = js.native
    def update(success: js.Function, error: js.Function): js.Thenable[HttpResponse] = js.native
    @JSName("update")
    var update_Original: ResourceMethod = js.native
  }
  
  @js.native
  trait Resource_ extends resource {
    
    var actions: ResourceActions = js.native
  }
  
  @js.native
  trait Vue extends js.Object {
    
    @JSName("$http")
    def $http(options: HttpOptions): js.Thenable[HttpResponse] = js.native
    @JSName("$http")
    var $http_Original: Call = js.native
    
    @JSName("$resource")
    def $resource(url: String): ResourceMethods = js.native
    @JSName("$resource")
    def $resource(
      url: String,
      params: js.UndefOr[scala.Nothing],
      actions: js.UndefOr[scala.Nothing],
      options: HttpOptions
    ): ResourceMethods = js.native
    @JSName("$resource")
    def $resource(url: String, params: js.UndefOr[scala.Nothing], actions: js.Any): ResourceMethods = js.native
    @JSName("$resource")
    def $resource(url: String, params: js.UndefOr[scala.Nothing], actions: js.Any, options: HttpOptions): ResourceMethods = js.native
    @JSName("$resource")
    def $resource(url: String, params: js.Object): ResourceMethods = js.native
    @JSName("$resource")
    def $resource(url: String, params: js.Object, actions: js.UndefOr[scala.Nothing], options: HttpOptions): ResourceMethods = js.native
    @JSName("$resource")
    def $resource(url: String, params: js.Object, actions: js.Any): ResourceMethods = js.native
    @JSName("$resource")
    def $resource(url: String, params: js.Object, actions: js.Any, options: HttpOptions): ResourceMethods = js.native
    @JSName("$resource")
    var $resource_Original: resource = js.native
  }
  
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
  
  @js.native
  trait http extends js.Object {
    
    def apply(url: String): js.Thenable[HttpResponse] = js.native
    def apply(url: String, data: js.UndefOr[scala.Nothing], options: HttpOptions): js.Thenable[HttpResponse] = js.native
    def apply(url: String, data: js.Any): js.Thenable[HttpResponse] = js.native
    def apply(url: String, data: js.Any, options: HttpOptions): js.Thenable[HttpResponse] = js.native
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
