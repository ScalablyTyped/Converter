package typings.webpackEnv.WebpackModuleApi

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@js.native
trait AcceptOptions extends js.Object {
  /**
    * Indicates that apply() is automatically called by check function
    */
  var autoApply: js.UndefOr[Boolean] = js.native
  /**
    * If true the update process continues even if some modules are not accepted (and would bubble to the entry point).
    */
  var ignoreUnaccepted: js.UndefOr[Boolean] = js.native
}

object AcceptOptions {
  @scala.inline
  def apply(
    autoApply: js.UndefOr[Boolean] = js.undefined,
    ignoreUnaccepted: js.UndefOr[Boolean] = js.undefined
  ): AcceptOptions = {
    val __obj = js.Dynamic.literal()
    if (!js.isUndefined(autoApply)) __obj.updateDynamic("autoApply")(autoApply.asInstanceOf[js.Any])
    if (!js.isUndefined(ignoreUnaccepted)) __obj.updateDynamic("ignoreUnaccepted")(ignoreUnaccepted.asInstanceOf[js.Any])
    __obj.asInstanceOf[AcceptOptions]
  }
  @scala.inline
  implicit class AcceptOptionsOps[Self <: AcceptOptions] (val x: Self) extends AnyVal {
    @scala.inline
    def duplicate: Self = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x)).asInstanceOf[Self]
    @scala.inline
    def combineWith[Other /* <: js.Any */](other: Other): Self with Other = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x, other.asInstanceOf[js.Any])).asInstanceOf[Self with Other]
    @scala.inline
    def withAutoApply(autoApply: js.UndefOr[Boolean]): Self = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (!js.isUndefined(autoApply)) ret.updateDynamic("autoApply")(autoApply.asInstanceOf[js.Any])
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withoutAutoApply: Self = {
        val ret = this.duplicate
        js.special.delete(ret, "autoApply")
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withIgnoreUnaccepted(ignoreUnaccepted: js.UndefOr[Boolean]): Self = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (!js.isUndefined(ignoreUnaccepted)) ret.updateDynamic("ignoreUnaccepted")(ignoreUnaccepted.asInstanceOf[js.Any])
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withoutIgnoreUnaccepted: Self = {
        val ret = this.duplicate
        js.special.delete(ret, "ignoreUnaccepted")
        ret.asInstanceOf[Self]
    }
  }
  
}

