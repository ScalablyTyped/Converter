package typings.vueResource.vuejs

import typings.std.Blob
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

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

