package typings.chartDotJs

import org.scalablytyped.runtime.StringDictionary
import typings.chartDotJs.chartDotJsMod.ChartFontOptions
import typings.chartDotJs.chartDotJsMod.ChartOptions
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

trait Anon_Global
  extends /* key */ StringDictionary[js.Any] {
  var global: ChartOptions with ChartFontOptions
}

object Anon_Global {
  @scala.inline
  def apply(
    global: ChartOptions with ChartFontOptions,
    StringDictionary: /* key */ StringDictionary[js.Any] = null
  ): Anon_Global = {
    val __obj = js.Dynamic.literal(global = global)
    js.Dynamic.global.Object.assign(__obj, StringDictionary)
    __obj.asInstanceOf[Anon_Global]
  }
}

