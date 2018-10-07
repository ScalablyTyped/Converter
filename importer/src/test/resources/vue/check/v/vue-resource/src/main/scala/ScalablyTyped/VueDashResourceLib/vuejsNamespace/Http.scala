package ScalablyTyped
package VueDashResourceLib.vuejsNamespace

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@js.native
trait Http extends js.Object {
  @JSName("delete")
  val delete_Original: $http = js.native
  @JSName("get")
  val get_Original: $http = js.native
  val headers: HttpHeaders = js.native
  val interceptors: StdLib.Array[HttpInterceptor | js.Function0[HttpInterceptor]] = js.native
  @JSName("jsonp")
  val jsonp_Original: $http = js.native
  val options: HttpOptions with VueDashResourceLib.Anon_Root = js.native
  @JSName("patch")
  val patch_Original: $http = js.native
  @JSName("post")
  val post_Original: $http = js.native
  @JSName("put")
  val put_Original: $http = js.native
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

