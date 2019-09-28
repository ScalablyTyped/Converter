package typings.winston.winstonMod

import scala.scalajs.js.annotation.ScalaJSDefined
import typings.winston.libWinstonConfigMod.AbstractConfigSetLevels
import scala.scalajs.js
import scala.scalajs.js.`|`

trait LoggerOptions extends js.Object {
  var levels: js.UndefOr[AbstractConfigSetLevels] = js.undefined
}

object LoggerOptions {
  @inline
  def apply(levels: AbstractConfigSetLevels = null): LoggerOptions = {
    val __obj = js.Dynamic.literal()
    if (levels != null) __obj.updateDynamic("levels")(levels)
    __obj.asInstanceOf[LoggerOptions]
  }
}

