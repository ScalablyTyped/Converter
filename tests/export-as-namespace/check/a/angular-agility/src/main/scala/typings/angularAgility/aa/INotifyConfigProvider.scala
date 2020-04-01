package typings.angularAgility.aa

import typings.angular.mod.IServiceProvider
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@js.native
trait INotifyConfigProvider extends IServiceProvider {
  var defaultNotifyConfig: String = js.native
  var defaultTargetContainerName: String = js.native
  var notifyConfigs: js.Any = js.native
}

object INotifyConfigProvider {
  @scala.inline
  def apply(
    $get: js.Any,
    defaultNotifyConfig: String,
    defaultTargetContainerName: String,
    notifyConfigs: js.Any
  ): INotifyConfigProvider = {
    val __obj = js.Dynamic.literal($get = $get.asInstanceOf[js.Any], defaultNotifyConfig = defaultNotifyConfig.asInstanceOf[js.Any], defaultTargetContainerName = defaultTargetContainerName.asInstanceOf[js.Any], notifyConfigs = notifyConfigs.asInstanceOf[js.Any])
  
    __obj.asInstanceOf[INotifyConfigProvider]
  }
}

