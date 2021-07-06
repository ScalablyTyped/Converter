package typings.awsSdk

import typings.awsSdk.dynamodbMod.ClientConfiguration
import typings.awsSdk.dynamodbMod.apiVersion
import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

object configServicePlaceholdersMod {
  
  @JSImport("aws-sdk/lib/config_service_placeholders", "ConfigurationServicePlaceholders")
  @js.native
  abstract class ConfigurationServicePlaceholders () extends StObject {
    
    var dynamodb: js.UndefOr[ClientConfiguration] = js.native
  }
  
  @js.native
  trait ConfigurationServiceApiVersions extends StObject {
    
    var dynamodb: js.UndefOr[apiVersion] = js.native
  }
  object ConfigurationServiceApiVersions {
    
    @scala.inline
    def apply(): ConfigurationServiceApiVersions = {
      val __obj = js.Dynamic.literal()
      __obj.asInstanceOf[ConfigurationServiceApiVersions]
    }
    
    @scala.inline
    implicit class ConfigurationServiceApiVersionsMutableBuilder[Self <: ConfigurationServiceApiVersions] (val x: Self) extends AnyVal {
      
      @scala.inline
      def setDynamodb(value: apiVersion): Self = StObject.set(x, "dynamodb", value.asInstanceOf[js.Any])
      
      @scala.inline
      def setDynamodbUndefined: Self = StObject.set(x, "dynamodb", js.undefined)
    }
  }
}
