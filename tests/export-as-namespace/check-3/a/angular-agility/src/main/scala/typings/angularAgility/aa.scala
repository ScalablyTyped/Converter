package typings.angularAgility

import typings.angular.mod.IServiceProvider
import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

object aa {
  
  trait INotifyConfigProvider
    extends StObject
       with IServiceProvider {
    
    var defaultNotifyConfig: String
    
    var defaultTargetContainerName: String
    
    var notifyConfigs: js.Any
  }
  object INotifyConfigProvider {
    
    inline def apply(
      $get: js.Any,
      defaultNotifyConfig: String,
      defaultTargetContainerName: String,
      notifyConfigs: js.Any
    ): INotifyConfigProvider = {
      val __obj = js.Dynamic.literal($get = $get.asInstanceOf[js.Any], defaultNotifyConfig = defaultNotifyConfig.asInstanceOf[js.Any], defaultTargetContainerName = defaultTargetContainerName.asInstanceOf[js.Any], notifyConfigs = notifyConfigs.asInstanceOf[js.Any])
      __obj.asInstanceOf[INotifyConfigProvider]
    }
    
    extension [Self <: INotifyConfigProvider](x: Self) {
      
      inline def setDefaultNotifyConfig(value: String): Self = StObject.set(x, "defaultNotifyConfig", value.asInstanceOf[js.Any])
      
      inline def setDefaultTargetContainerName(value: String): Self = StObject.set(x, "defaultTargetContainerName", value.asInstanceOf[js.Any])
      
      inline def setNotifyConfigs(value: js.Any): Self = StObject.set(x, "notifyConfigs", value.asInstanceOf[js.Any])
    }
  }
}
