package typings.vueResource

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

/* Inlined vue-resource.vuejs.HttpOptions & {  root  :string} */
@js.native
trait HttpOptionsrootstringBefore extends js.Object {
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

object HttpOptionsrootstringBefore {
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
  ): HttpOptionsrootstringBefore = {
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
    __obj.asInstanceOf[HttpOptionsrootstringBefore]
  }
}

