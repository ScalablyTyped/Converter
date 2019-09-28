package typings.vueDashResource

import org.scalablytyped.runtime.StringDictionary
import scala.scalajs.js.annotation.ScalaJSDefined
import typings.vueDashResource.vuejs.HttpHeaders
import scala.scalajs.js
import scala.scalajs.js.`|`

trait Anon_Headers extends /* key */ StringDictionary[js.Any] {
  var headers: js.UndefOr[HttpHeaders] = js.undefined
}

object Anon_Headers {
  @inline
  def apply(StringDictionary: /* key */ StringDictionary[js.Any] = null, headers: HttpHeaders = null): Anon_Headers = {
    val __obj = js.Dynamic.literal()
    js.Dynamic.global.Object.assign(__obj, StringDictionary)
    if (headers != null) __obj.updateDynamic("headers")(headers)
    __obj.asInstanceOf[Anon_Headers]
  }
}

