package typings.vueResource.vuejs

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

@js.native
trait http extends js.Object {
  
  def apply(url: String): js.Thenable[HttpResponse] = js.native
  def apply(url: String, data: js.UndefOr[scala.Nothing], options: HttpOptions): js.Thenable[HttpResponse] = js.native
  def apply(url: String, data: js.Any): js.Thenable[HttpResponse] = js.native
  def apply(url: String, data: js.Any, options: HttpOptions): js.Thenable[HttpResponse] = js.native
  def apply(url: String, options: HttpOptions): js.Thenable[HttpResponse] = js.native
}
