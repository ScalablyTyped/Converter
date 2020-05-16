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
  @scala.inline
  implicit class OptionOps[Self <: Option] (val x: Self) extends AnyVal {
    @scala.inline
    def duplicate: Self = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x)).asInstanceOf[Self]
    @scala.inline
    def combineWith[Other /* <: js.Any */](other: Other): Self with Other = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x, other.asInstanceOf[js.Any])).asInstanceOf[Self with Other]
    @scala.inline
    def withBool(bool: Boolean): Self = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        ret.updateDynamic("bool")(bool.asInstanceOf[js.Any])
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withDescription(description: String): Self = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        ret.updateDynamic("description")(description.asInstanceOf[js.Any])
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withFlags(flags: String): Self = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        ret.updateDynamic("flags")(flags.asInstanceOf[js.Any])
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withLong(long: String): Self = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        ret.updateDynamic("long")(long.asInstanceOf[js.Any])
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withOptional(optional: Boolean): Self = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        ret.updateDynamic("optional")(optional.asInstanceOf[js.Any])
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withRequired(required: Boolean): Self = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        ret.updateDynamic("required")(required.asInstanceOf[js.Any])
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withShort(short: String): Self = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (short != null) ret.updateDynamic("short")(short.asInstanceOf[js.Any])
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withoutShort: Self = {
        val ret = this.duplicate
        js.special.delete(ret, "short")
        ret.asInstanceOf[Self]
    }
  }
  
}

