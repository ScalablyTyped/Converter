package typings.angularAgility.aa

import typings.angular.angularMod.IServiceProvider
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

trait INotifyConfigProvider extends IServiceProvider {
  var defaultNotifyConfig: String
  var defaultTargetContainerName: String
  var notifyConfigs: js.Any
}

object INotifyConfigProvider {
  @scala.inline
  def apply(
    $get: js.Any,
    defaultNotifyConfig: String,
    defaultTargetContainerName: String,
    notifyConfigs: js.Any
  ): INotifyConfigProvider = {
    val __obj = js.Dynamic.literal($get = $get, defaultNotifyConfig = defaultNotifyConfig, defaultTargetContainerName = defaultTargetContainerName, notifyConfigs = notifyConfigs)
  
    __obj.asInstanceOf[INotifyConfigProvider]
  }
}

