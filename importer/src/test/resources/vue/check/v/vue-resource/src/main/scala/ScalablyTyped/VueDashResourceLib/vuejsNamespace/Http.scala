package ScalablyTyped
package VueDashResourceLib.vuejsNamespace

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@js.native
trait Http extends js.Object {
  @JSName("delete")
  var delete_Original: $http = js.native
  @JSName("get")
  var get_Original: $http = js.native
  var headers: HttpHeaders = js.native
  var interceptors: js.Array[HttpInterceptor | js.Function0[HttpInterceptor]] = js.native
  @JSName("jsonp")
  var jsonp_Original: $http = js.native
  var options: HttpOptions with VueDashResourceLib.Anon_Root = js.native
  @JSName("patch")
  var patch_Original: $http = js.native
  @JSName("post")
  var post_Original: $http = js.native
  @JSName("put")
  var put_Original: $http = js.native
  def delete(url: java.lang.String): StdLib.PromiseLike = js.native
  def delete(url: java.lang.String, data: js.Any): StdLib.PromiseLike = js.native
  def delete(url: java.lang.String, data: js.Any, options: HttpOptions): StdLib.PromiseLike = js.native
  def delete(url: java.lang.String, options: HttpOptions): StdLib.PromiseLike = js.native
  def get(url: java.lang.String): StdLib.PromiseLike = js.native
  def get(url: java.lang.String, data: js.Any): StdLib.PromiseLike = js.native
  def get(url: java.lang.String, data: js.Any, options: HttpOptions): StdLib.PromiseLike = js.native
  def get(url: java.lang.String, options: HttpOptions): StdLib.PromiseLike = js.native
  def jsonp(url: java.lang.String): StdLib.PromiseLike = js.native
  def jsonp(url: java.lang.String, data: js.Any): StdLib.PromiseLike = js.native
  def jsonp(url: java.lang.String, data: js.Any, options: HttpOptions): StdLib.PromiseLike = js.native
  def jsonp(url: java.lang.String, options: HttpOptions): StdLib.PromiseLike = js.native
  def patch(url: java.lang.String): StdLib.PromiseLike = js.native
  def patch(url: java.lang.String, data: js.Any): StdLib.PromiseLike = js.native
  def patch(url: java.lang.String, data: js.Any, options: HttpOptions): StdLib.PromiseLike = js.native
  def patch(url: java.lang.String, options: HttpOptions): StdLib.PromiseLike = js.native
  def post(url: java.lang.String): StdLib.PromiseLike = js.native
  def post(url: java.lang.String, data: js.Any): StdLib.PromiseLike = js.native
  def post(url: java.lang.String, data: js.Any, options: HttpOptions): StdLib.PromiseLike = js.native
  def post(url: java.lang.String, options: HttpOptions): StdLib.PromiseLike = js.native
  def put(url: java.lang.String): StdLib.PromiseLike = js.native
  def put(url: java.lang.String, data: js.Any): StdLib.PromiseLike = js.native
  def put(url: java.lang.String, data: js.Any, options: HttpOptions): StdLib.PromiseLike = js.native
  def put(url: java.lang.String, options: HttpOptions): StdLib.PromiseLike = js.native
}

