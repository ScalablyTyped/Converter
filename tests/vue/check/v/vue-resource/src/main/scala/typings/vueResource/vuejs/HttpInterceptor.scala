package typings.vueResource.vuejs

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@js.native
trait HttpInterceptor extends js.Object {
  var request: js.UndefOr[js.Function1[/* request */ HttpOptions, HttpOptions]] = js.native
  var response: js.UndefOr[js.Function1[/* response */ HttpResponse, HttpResponse]] = js.native
}

object HttpInterceptor {
  @scala.inline
  def apply(
    request: /* request */ HttpOptions => HttpOptions = null,
    response: /* response */ HttpResponse => HttpResponse = null
  ): HttpInterceptor = {
    val __obj = js.Dynamic.literal()
    if (request != null) __obj.updateDynamic("request")(js.Any.fromFunction1(request))
    if (response != null) __obj.updateDynamic("response")(js.Any.fromFunction1(response))
    __obj.asInstanceOf[HttpInterceptor]
  }
  @scala.inline
  implicit class HttpInterceptorOps[Self <: HttpInterceptor] (val x: Self) extends AnyVal {
    @scala.inline
    def duplicate: Self = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x)).asInstanceOf[Self]
    @scala.inline
    def combineWith[Other /* <: js.Any */](other: Other): Self with Other = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x, other.asInstanceOf[js.Any])).asInstanceOf[Self with Other]
    @scala.inline
    def withRequest(request: /* request */ HttpOptions => HttpOptions): Self = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (request != null) ret.updateDynamic("request")(js.Any.fromFunction1(request))
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withoutRequest: Self = {
        val ret = this.duplicate
        js.special.delete(ret, "request")
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withResponse(response: /* response */ HttpResponse => HttpResponse): Self = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (response != null) ret.updateDynamic("response")(js.Any.fromFunction1(response))
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withoutResponse: Self = {
        val ret = this.duplicate
        js.special.delete(ret, "response")
        ret.asInstanceOf[Self]
    }
  }
  
}

