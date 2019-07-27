package typings.winstonLib.winstonMod

import typings.winstonLib.libWinstonConfigMod.AbstractConfigSetLevels
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

trait LoggerOptions extends js.Object {
  var levels: js.UndefOr[AbstractConfigSetLevels] = js.undefined
}

object LoggerOptions {
  @scala.inline
  def apply(levels: AbstractConfigSetLevels = null): LoggerOptions = {
    val __obj = js.Dynamic.literal()
    if (levels != null) __obj.updateDynamic("levels")(levels)
    __obj.asInstanceOf[LoggerOptions]
  }
}

