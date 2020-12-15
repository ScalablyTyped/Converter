package typings.awsSdk

import typings.awsSdk.awsSdkStrings.latest
import typings.awsSdk.configServicePlaceholdersMod.ConfigurationServiceApiVersions
import typings.awsSdk.configServicePlaceholdersMod.ConfigurationServicePlaceholders
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

object configMod {
  
  @js.native
  trait APIVersions extends js.Object {
    
    /**
      * A string in YYYY-MM-DD format that represents the latest possible API version that can be used in all services (unless overridden by apiVersions). Specify \'latest\' to use the latest possible version.
      */
    var apiVersion: js.UndefOr[latest | String] = js.native
    
    /**
      * A map of service identifiers (the lowercase service class name) with the API version to use when instantiating a service. Specify 'latest' for each individual that can use the latest available version.
      */
    var apiVersions: js.UndefOr[ConfigurationServiceApiVersions] = js.native
  }
  object APIVersions {
    
    @scala.inline
    def apply(): APIVersions = {
      val __obj = js.Dynamic.literal()
      __obj.asInstanceOf[APIVersions]
    }
    
    @scala.inline
    implicit class APIVersionsOps[Self <: APIVersions] (val x: Self) extends AnyVal {
      
      @scala.inline
      def duplicate: Self = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x)).asInstanceOf[Self]
      
      @scala.inline
      def combineWith[Other <: js.Any](other: Other): Self with Other = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x, other.asInstanceOf[js.Any])).asInstanceOf[Self with Other]
      
      @scala.inline
      def set(key: String, value: js.Any): Self = {
        x.asInstanceOf[js.Dynamic].updateDynamic(key)(value)
        x
      }
      
      @scala.inline
      def setApiVersion(value: latest | String): Self = this.set("apiVersion", value.asInstanceOf[js.Any])
      
      @scala.inline
      def deleteApiVersion: Self = this.set("apiVersion", js.undefined)
      
      @scala.inline
      def setApiVersions(value: ConfigurationServiceApiVersions): Self = this.set("apiVersions", value.asInstanceOf[js.Any])
      
      @scala.inline
      def deleteApiVersions: Self = this.set("apiVersions", js.undefined)
    }
  }
  
  @JSImport("aws-sdk/lib/config", "Config")
  @js.native
  /**
    * Creates a new configuration object.
    * This is the object that passes option data along to service requests, including credentials, security, region information, and some service specific settings.
    */
  class Config () extends js.Object {
    def this(options: ConfigurationServicePlaceholders with APIVersions) = this()
    
    /**
      * Loads configuration data from a JSON file into this config object.
      * Loading configuration willr eset all existing configuration on the object.
      * This feature is not supported in the browser environment of the SDK.
      *
      * @param {string} path - the path relative to your process's current working directory to load configuration from.
      */
    def loadFromPath(path: String): Config with ConfigurationServicePlaceholders with APIVersions = js.native
  }
}
