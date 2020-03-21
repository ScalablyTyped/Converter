package typings.chartJs

import org.scalablytyped.runtime.StringDictionary
import typings.chartJs.mod.ChartFontOptions
import typings.chartJs.mod.ChartOptions
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@js.native
trait AnonDictkey
  extends /* key */ StringDictionary[js.Any] {
  var global: ChartOptions with ChartFontOptions = js.native
}

object AnonDictkey {
  @scala.inline
  def apply(
    global: ChartOptions with ChartFontOptions,
    StringDictionary: /* key */ StringDictionary[js.Any] = null
  ): AnonDictkey = {
    val __obj = js.Dynamic.literal(global = global.asInstanceOf[js.Any])
    if (StringDictionary != null) js.Dynamic.global.Object.assign(__obj, StringDictionary)
    __obj.asInstanceOf[AnonDictkey]
  }
}

