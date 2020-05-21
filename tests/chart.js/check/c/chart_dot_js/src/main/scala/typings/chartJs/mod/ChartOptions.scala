package typings.chartJs.mod

import org.scalablytyped.runtime.StringDictionary
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@js.native
trait ChartOptions extends js.Object {
  // Plugins can require any options
  var plugins: js.UndefOr[StringDictionary[js.Any]] = js.native
  var responsive: js.UndefOr[Boolean] = js.native
}

object ChartOptions {
  @scala.inline
  def apply(plugins: StringDictionary[js.Any] = null, responsive: js.UndefOr[Boolean] = js.undefined): ChartOptions = {
    val __obj = js.Dynamic.literal()
    if (plugins != null) __obj.updateDynamic("plugins")(plugins.asInstanceOf[js.Any])
    if (!js.isUndefined(responsive)) __obj.updateDynamic("responsive")(responsive.asInstanceOf[js.Any])
    __obj.asInstanceOf[ChartOptions]
  }
  @scala.inline
  implicit class ChartOptionsOps[Self <: ChartOptions] (val x: Self) extends AnyVal {
    @scala.inline
    def duplicate: Self = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x)).asInstanceOf[Self]
    @scala.inline
    def combineWith[Other /* <: js.Any */](other: Other): Self with Other = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x, other.asInstanceOf[js.Any])).asInstanceOf[Self with Other]
    @scala.inline
    def withPlugins(plugins: StringDictionary[js.Any]): Self = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (plugins != null) ret.updateDynamic("plugins")(plugins.asInstanceOf[js.Any])
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withoutPlugins: Self = {
        val ret = this.duplicate
        js.special.delete(ret, "plugins")
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withResponsive(responsive: js.UndefOr[Boolean]): Self = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (!js.isUndefined(responsive)) ret.updateDynamic("responsive")(responsive.asInstanceOf[js.Any])
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withoutResponsive: Self = {
        val ret = this.duplicate
        js.special.delete(ret, "responsive")
        ret.asInstanceOf[Self]
    }
  }
  
}

