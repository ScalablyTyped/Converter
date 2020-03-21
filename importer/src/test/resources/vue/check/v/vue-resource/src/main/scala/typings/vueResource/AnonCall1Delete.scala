package typings.vueResource

import typings.vueResource.vuejs.HttpOptions
import typings.vueResource.vuejs.HttpResponse
import typings.vueResource.vuejs.http
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@js.native
trait AnonCall1Delete extends js.Object {
  @JSName("delete")
  var delete_Original: http = js.native
  @JSName("get")
  var get_Original: http = js.native
  @JSName("jsonp")
  var jsonp_Original: http = js.native
  @JSName("patch")
  var patch_Original: http = js.native
  @JSName("post")
  var post_Original: http = js.native
  @JSName("put")
  var put_Original: http = js.native
  def apply(options: HttpOptions): js.Thenable[HttpResponse] = js.native
  def delete(url: String): js.Thenable[HttpResponse] = js.native
  def delete(url: String, data: js.Any): js.Thenable[HttpResponse] = js.native
  def delete(url: String, data: js.Any, options: HttpOptions): js.Thenable[HttpResponse] = js.native
  def delete(url: String, options: HttpOptions): js.Thenable[HttpResponse] = js.native
  def get(url: String): js.Thenable[HttpResponse] = js.native
  def get(url: String, data: js.Any): js.Thenable[HttpResponse] = js.native
  def get(url: String, data: js.Any, options: HttpOptions): js.Thenable[HttpResponse] = js.native
  def get(url: String, options: HttpOptions): js.Thenable[HttpResponse] = js.native
  def jsonp(url: String): js.Thenable[HttpResponse] = js.native
  def jsonp(url: String, data: js.Any): js.Thenable[HttpResponse] = js.native
  def jsonp(url: String, data: js.Any, options: HttpOptions): js.Thenable[HttpResponse] = js.native
  def jsonp(url: String, options: HttpOptions): js.Thenable[HttpResponse] = js.native
  def patch(url: String): js.Thenable[HttpResponse] = js.native
  def patch(url: String, data: js.Any): js.Thenable[HttpResponse] = js.native
  def patch(url: String, data: js.Any, options: HttpOptions): js.Thenable[HttpResponse] = js.native
  def patch(url: String, options: HttpOptions): js.Thenable[HttpResponse] = js.native
  def post(url: String): js.Thenable[HttpResponse] = js.native
  def post(url: String, data: js.Any): js.Thenable[HttpResponse] = js.native
  def post(url: String, data: js.Any, options: HttpOptions): js.Thenable[HttpResponse] = js.native
  def post(url: String, options: HttpOptions): js.Thenable[HttpResponse] = js.native
  def put(url: String): js.Thenable[HttpResponse] = js.native
  def put(url: String, data: js.Any): js.Thenable[HttpResponse] = js.native
  def put(url: String, data: js.Any, options: HttpOptions): js.Thenable[HttpResponse] = js.native
  def put(url: String, options: HttpOptions): js.Thenable[HttpResponse] = js.native
}

