package typings
package vueDashResourceLib.vuejsNs

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

trait Http extends js.Object {
  var delete: $http
  var get: $http
  var headers: HttpHeaders
  var interceptors: js.Array[HttpInterceptor | js.Function0[HttpInterceptor]]
  var jsonp: $http
  var options: HttpOptions with vueDashResourceLib.Anon_Root
  var patch: $http
  var post: $http
  var put: $http
}

