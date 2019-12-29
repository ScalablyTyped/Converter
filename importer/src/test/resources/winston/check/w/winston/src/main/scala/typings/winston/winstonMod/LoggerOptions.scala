package typings.winston.winstonMod

import typings.winston.libWinstonConfigMod.AbstractConfigSetLevels
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
}

