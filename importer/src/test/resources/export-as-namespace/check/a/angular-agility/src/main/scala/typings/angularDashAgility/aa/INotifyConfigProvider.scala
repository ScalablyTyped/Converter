package typings.angularDashAgility.aa

import scala.scalajs.js.annotation.ScalaJSDefined
import typings.angular.angularMod.IServiceProvider
import scala.scalajs.js
import scala.scalajs.js.`|`

trait INotifyConfigProvider extends IServiceProvider {
  var defaultNotifyConfig: String
  var defaultTargetContainerName: String
  var notifyConfigs: js.Any
}

object INotifyConfigProvider {
  @inline
  def apply(
    $get: js.Any,
    defaultNotifyConfig: String,
    defaultTargetContainerName: String,
    hasOwnProperty: String => Boolean,
    isPrototypeOf: js.Object => Boolean,
    notifyConfigs: js.Any,
    propertyIsEnumerable: String => Boolean,
    toLocaleString: () => String,
    valueOf: () => js.Any
  ): INotifyConfigProvider = {
    val __obj = js.Dynamic.literal($get = $get, defaultNotifyConfig = defaultNotifyConfig, defaultTargetContainerName = defaultTargetContainerName, hasOwnProperty = js.Any.fromFunction1(hasOwnProperty), isPrototypeOf = js.Any.fromFunction1(isPrototypeOf), notifyConfigs = notifyConfigs, propertyIsEnumerable = js.Any.fromFunction1(propertyIsEnumerable), toLocaleString = js.Any.fromFunction0(toLocaleString), valueOf = js.Any.fromFunction0(valueOf))
  
    __obj.asInstanceOf[INotifyConfigProvider]
  }
}

