package typings.vueResource.vuejs

import typings.vueResource.anon.HttpOptionsrootstring
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

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

