package typings.vueResource

import org.scalablytyped.runtime.StringDictionary
import typings.vueResource.vuejs.HttpHeaders
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@js.native
trait AnonHeaders
  extends /* key */ StringDictionary[js.Any] {
  var headers: js.UndefOr[HttpHeaders] = js.native
}

object AnonHeaders {
  @scala.inline
  def apply(StringDictionary: /* key */ StringDictionary[js.Any] = null, headers: HttpHeaders = null): AnonHeaders = {
    val __obj = js.Dynamic.literal()
    if (StringDictionary != null) js.Dynamic.global.Object.assign(__obj, StringDictionary)
    if (headers != null) __obj.updateDynamic("headers")(headers.asInstanceOf[js.Any])
    __obj.asInstanceOf[AnonHeaders]
  }
}

