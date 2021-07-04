package typings.angularAgility

import typings.angular.mod.IServiceProvider
import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

object aa {
  
  @js.native
  trait INotifyConfigProvider
    extends StObject
       with IServiceProvider {
    
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
    
    @scala.inline
    implicit class INotifyConfigProviderMutableBuilder[Self <: INotifyConfigProvider] (val x: Self) extends AnyVal {
      
      @scala.inline
      def setDefaultNotifyConfig(value: String): Self = StObject.set(x, "defaultNotifyConfig", value.asInstanceOf[js.Any])
      
      @scala.inline
      def setDefaultTargetContainerName(value: String): Self = StObject.set(x, "defaultTargetContainerName", value.asInstanceOf[js.Any])
      
      @scala.inline
      def setNotifyConfigs(value: js.Any): Self = StObject.set(x, "notifyConfigs", value.asInstanceOf[js.Any])
    }
  }
}
