package typings.webpackDashEnv.__WebpackModuleApi

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

trait AcceptOptions extends js.Object {
  /**
    * Indicates that apply() is automatically called by check function
    */
  var autoApply: js.UndefOr[Boolean] = js.undefined
  /**
    * If true the update process continues even if some modules are not accepted (and would bubble to the entry point).
    */
  var ignoreUnaccepted: js.UndefOr[Boolean] = js.undefined
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
}

