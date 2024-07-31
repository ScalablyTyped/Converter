package typings.awsSdk

import _root_.typings.awsSdk.clientsDynamodbMod.ClientConfiguration
import _root_.typings.awsSdk.clientsDynamodbMod.apiVersion
import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

object libConfigServicePlaceholdersMod {
  
  /* note: abstract class */ @JSImport("aws-sdk/lib/config_service_placeholders", "ConfigurationServicePlaceholders")
  @js.native
  open class ConfigurationServicePlaceholders () extends StObject {
    
    var dynamodb: js.UndefOr[ClientConfiguration] = js.native
  }
  
  trait ConfigurationServiceApiVersions extends StObject {
    
    var dynamodb: js.UndefOr[apiVersion] = js.undefined
  }
  object ConfigurationServiceApiVersions {
    
    inline def apply(): ConfigurationServiceApiVersions = {
      val __obj = js.Dynamic.literal()
      __obj.asInstanceOf[ConfigurationServiceApiVersions]
    }
    
    @scala.inline
    implicit open class MutableBuilder[Self <: ConfigurationServiceApiVersions] (val x: Self) extends AnyVal {
      
      inline def setDynamodb(value: apiVersion): Self = StObject.set(x, "dynamodb", value.asInstanceOf[js.Any])
      
      inline def setDynamodbUndefined: Self = StObject.set(x, "dynamodb", js.undefined)
    }
  }
}
