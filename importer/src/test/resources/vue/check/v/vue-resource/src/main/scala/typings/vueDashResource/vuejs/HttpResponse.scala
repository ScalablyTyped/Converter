package typings.vueDashResource.vuejs

import typings.std.Blob
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@js.native
trait HttpResponse extends js.Object {
  var data: js.Object = js.native
  var headers: js.Function = js.native
  var ok: Boolean = js.native
  var status: Double = js.native
  var statusText: String = js.native
  def blob(): Blob = js.native
  def json(): js.Any = js.native
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
}

