package typings.chartDotJs.chartDotJsMod

import org.scalablytyped.runtime.StringDictionary
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

trait ChartOptions extends js.Object {
  // Plugins can require any options
  var plugins: js.UndefOr[StringDictionary[js.Any]] = js.undefined
  var responsive: js.UndefOr[Boolean] = js.undefined
}

object ChartOptions {
  @scala.inline
  def apply(plugins: StringDictionary[js.Any] = null, responsive: js.UndefOr[Boolean] = js.undefined): ChartOptions = {
    val __obj = js.Dynamic.literal()
    if (plugins != null) __obj.updateDynamic("plugins")(plugins.asInstanceOf[js.Any])
    if (!js.isUndefined(responsive)) __obj.updateDynamic("responsive")(responsive.asInstanceOf[js.Any])
    __obj.asInstanceOf[ChartOptions]
  }
}

