package typings
package winstonLib.winstonMod

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

trait LoggerOptions extends js.Object {
  var levels: js.UndefOr[winstonLib.libWinstonConfigMod.AbstractConfigSetLevels] = js.undefined
}

object LoggerOptions {
  @scala.inline
  def apply(levels: winstonLib.libWinstonConfigMod.AbstractConfigSetLevels = null): LoggerOptions = {
    val __obj = js.Dynamic.literal()
    if (levels != null) __obj.updateDynamic("levels")(levels)
    __obj.asInstanceOf[LoggerOptions]
  }
}

