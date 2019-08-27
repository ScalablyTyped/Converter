package typings.chartDotJs.chartDotJsMod

import org.scalablytyped.runtime.StringDictionary
import org.scalablytyped.runtime.UndefOr
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

trait ChartOptions extends js.Object {
  // Plugins can require any options
  var plugins: UndefOr[StringDictionary[js.Any]] = js.undefined
  var responsive: UndefOr[Boolean] = js.undefined
}

object ChartOptions {
  @scala.inline
  def apply(plugins: StringDictionary[js.Any] = null, responsive: `<undefined>` | Boolean = js.undefined): ChartOptions = {
    val __obj = js.Dynamic.literal()
    if (plugins != null) __obj.updateDynamic("plugins")(plugins)
    if (!js.isUndefined(responsive)) __obj.updateDynamic("responsive")(responsive)
    __obj.asInstanceOf[ChartOptions]
  }
}

