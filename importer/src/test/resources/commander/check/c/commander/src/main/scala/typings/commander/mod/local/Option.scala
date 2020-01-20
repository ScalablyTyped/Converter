package typings.commander.mod.local

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@js.native
trait Option extends js.Object {
  var bool: Boolean = js.native
  var description: String = js.native
  var flags: String = js.native
  var long: String = js.native
  var optional: Boolean = js.native
  var required: Boolean = js.native
  var short: js.UndefOr[String] = js.native
}

object Option {
  @scala.inline
  def apply(
    bool: Boolean,
    description: String,
    flags: String,
    long: String,
    optional: Boolean,
    required: Boolean,
    short: String = null
  ): Option = {
    val __obj = js.Dynamic.literal(bool = bool.asInstanceOf[js.Any], description = description.asInstanceOf[js.Any], flags = flags.asInstanceOf[js.Any], long = long.asInstanceOf[js.Any], optional = optional.asInstanceOf[js.Any], required = required.asInstanceOf[js.Any])
    if (short != null) __obj.updateDynamic("short")(short.asInstanceOf[js.Any])
    __obj.asInstanceOf[Option]
  }
}

