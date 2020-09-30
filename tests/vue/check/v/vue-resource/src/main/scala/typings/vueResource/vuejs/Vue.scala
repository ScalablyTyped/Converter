package typings.vueResource.vuejs

import typings.vueResource.anon.Call
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

@js.native
trait Vue extends js.Object {
  @JSName("$http")
  var $http_Original: Call = js.native
  @JSName("$resource")
  var $resource_Original: resource = js.native
  @JSName("$http")
  def $http(options: HttpOptions): js.Thenable[HttpResponse] = js.native
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
}

