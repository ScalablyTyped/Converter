package typings.vueResource

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

/* Inlined vue-resource.vuejs.HttpOptions & {  root  :string} */
@js.native
trait HttpOptionsrootstring extends js.Object {
  var before: js.UndefOr[js.Function1[/* request */ js.Any, _]] = js.native
  var body: js.UndefOr[js.Any] = js.native
  var credentials: js.UndefOr[Boolean] = js.native
  var emulateHTTP: js.UndefOr[Boolean] = js.native
  var emulateJSON: js.UndefOr[Boolean] = js.native
  var headers: js.UndefOr[js.Any] = js.native
  var method: js.UndefOr[String] = js.native
  var params: js.UndefOr[js.Any] = js.native
  var progress: js.UndefOr[js.Function1[/* event */ js.Any, _]] = js.native
  var root: String = js.native
  var url: js.UndefOr[String] = js.native
}

object HttpOptionsrootstring {
  @scala.inline
  def apply(
    root: String,
    before: /* request */ js.Any => _ = null,
    body: js.Any = null,
    credentials: js.UndefOr[Boolean] = js.undefined,
    emulateHTTP: js.UndefOr[Boolean] = js.undefined,
    emulateJSON: js.UndefOr[Boolean] = js.undefined,
    headers: js.Any = null,
    method: String = null,
    params: js.Any = null,
    progress: /* event */ js.Any => _ = null,
    url: String = null
  ): HttpOptionsrootstring = {
    val __obj = js.Dynamic.literal(root = root.asInstanceOf[js.Any])
    if (before != null) __obj.updateDynamic("before")(js.Any.fromFunction1(before))
    if (body != null) __obj.updateDynamic("body")(body.asInstanceOf[js.Any])
    if (!js.isUndefined(credentials)) __obj.updateDynamic("credentials")(credentials.asInstanceOf[js.Any])
    if (!js.isUndefined(emulateHTTP)) __obj.updateDynamic("emulateHTTP")(emulateHTTP.asInstanceOf[js.Any])
    if (!js.isUndefined(emulateJSON)) __obj.updateDynamic("emulateJSON")(emulateJSON.asInstanceOf[js.Any])
    if (headers != null) __obj.updateDynamic("headers")(headers.asInstanceOf[js.Any])
    if (method != null) __obj.updateDynamic("method")(method.asInstanceOf[js.Any])
    if (params != null) __obj.updateDynamic("params")(params.asInstanceOf[js.Any])
    if (progress != null) __obj.updateDynamic("progress")(js.Any.fromFunction1(progress))
    if (url != null) __obj.updateDynamic("url")(url.asInstanceOf[js.Any])
    __obj.asInstanceOf[HttpOptionsrootstring]
  }
  @scala.inline
  implicit class HttpOptionsrootstringOps[Self <: HttpOptionsrootstring] (val x: Self) extends AnyVal {
    @scala.inline
    def duplicate: Self = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x)).asInstanceOf[Self]
    @scala.inline
    def combineWith[Other /* <: js.Any */](other: Other): Self with Other = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x, other.asInstanceOf[js.Any])).asInstanceOf[Self with Other]
    @scala.inline
    def withRoot(root: String): Self = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        ret.updateDynamic("root")(root.asInstanceOf[js.Any])
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withBefore(before: /* request */ js.Any => _): Self = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (before != null) ret.updateDynamic("before")(js.Any.fromFunction1(before))
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withoutBefore: Self = {
        val ret = this.duplicate
        js.special.delete(ret, "before")
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withBody(body: js.Any): Self = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (body != null) ret.updateDynamic("body")(body.asInstanceOf[js.Any])
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withoutBody: Self = {
        val ret = this.duplicate
        js.special.delete(ret, "body")
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withCredentials(credentials: js.UndefOr[Boolean]): Self = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (!js.isUndefined(credentials)) ret.updateDynamic("credentials")(credentials.asInstanceOf[js.Any])
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withoutCredentials: Self = {
        val ret = this.duplicate
        js.special.delete(ret, "credentials")
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withEmulateHTTP(emulateHTTP: js.UndefOr[Boolean]): Self = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (!js.isUndefined(emulateHTTP)) ret.updateDynamic("emulateHTTP")(emulateHTTP.asInstanceOf[js.Any])
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withoutEmulateHTTP: Self = {
        val ret = this.duplicate
        js.special.delete(ret, "emulateHTTP")
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withEmulateJSON(emulateJSON: js.UndefOr[Boolean]): Self = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (!js.isUndefined(emulateJSON)) ret.updateDynamic("emulateJSON")(emulateJSON.asInstanceOf[js.Any])
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withoutEmulateJSON: Self = {
        val ret = this.duplicate
        js.special.delete(ret, "emulateJSON")
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withHeaders(headers: js.Any): Self = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (headers != null) ret.updateDynamic("headers")(headers.asInstanceOf[js.Any])
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withoutHeaders: Self = {
        val ret = this.duplicate
        js.special.delete(ret, "headers")
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withMethod(method: String): Self = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (method != null) ret.updateDynamic("method")(method.asInstanceOf[js.Any])
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withoutMethod: Self = {
        val ret = this.duplicate
        js.special.delete(ret, "method")
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withParams(params: js.Any): Self = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (params != null) ret.updateDynamic("params")(params.asInstanceOf[js.Any])
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withoutParams: Self = {
        val ret = this.duplicate
        js.special.delete(ret, "params")
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withProgress(progress: /* event */ js.Any => _): Self = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (progress != null) ret.updateDynamic("progress")(js.Any.fromFunction1(progress))
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withoutProgress: Self = {
        val ret = this.duplicate
        js.special.delete(ret, "progress")
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withUrl(url: String): Self = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (url != null) ret.updateDynamic("url")(url.asInstanceOf[js.Any])
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withoutUrl: Self = {
        val ret = this.duplicate
        js.special.delete(ret, "url")
        ret.asInstanceOf[Self]
    }
  }
  
}

