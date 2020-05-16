package typings.winston.mod

import typings.winston.configMod.AbstractConfigSetLevels
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@js.native
trait LoggerOptions extends js.Object {
  var levels: js.UndefOr[AbstractConfigSetLevels] = js.native
}

object LoggerOptions {
  @scala.inline
  def apply(levels: AbstractConfigSetLevels = null): LoggerOptions = {
    val __obj = js.Dynamic.literal()
    if (levels != null) __obj.updateDynamic("levels")(levels.asInstanceOf[js.Any])
    __obj.asInstanceOf[LoggerOptions]
  }
  @scala.inline
  implicit class LoggerOptionsOps[Self <: LoggerOptions] (val x: Self) extends AnyVal {
    @scala.inline
    def duplicate: Self = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x)).asInstanceOf[Self]
    @scala.inline
    def combineWith[Other /* <: js.Any */](other: Other): Self with Other = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x, other.asInstanceOf[js.Any])).asInstanceOf[Self with Other]
    @scala.inline
    def withLevels(levels: AbstractConfigSetLevels): Self = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (levels != null) ret.updateDynamic("levels")(levels.asInstanceOf[js.Any])
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withoutLevels: Self = {
        val ret = this.duplicate
        js.special.delete(ret, "levels")
        ret.asInstanceOf[Self]
    }
  }
  
}

