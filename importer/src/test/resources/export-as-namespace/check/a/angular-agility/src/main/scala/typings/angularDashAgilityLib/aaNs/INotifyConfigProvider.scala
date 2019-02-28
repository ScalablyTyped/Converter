package typings
package angularDashAgilityLib.aaNs

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

trait INotifyConfigProvider
  extends angularLib.angularMod.angularNs.IServiceProvider {
  var defaultNotifyConfig: java.lang.String
  var defaultTargetContainerName: java.lang.String
  var notifyConfigs: js.Any
}

object INotifyConfigProvider {
  @scala.inline
  def apply(
    $get: js.Any,
    defaultNotifyConfig: java.lang.String,
    defaultTargetContainerName: java.lang.String,
    notifyConfigs: js.Any
  ): INotifyConfigProvider = {
    val __obj = js.Dynamic.literal($get = $get, defaultNotifyConfig = defaultNotifyConfig, defaultTargetContainerName = defaultTargetContainerName, notifyConfigs = notifyConfigs)
  
    __obj.asInstanceOf[INotifyConfigProvider]
  }
}

