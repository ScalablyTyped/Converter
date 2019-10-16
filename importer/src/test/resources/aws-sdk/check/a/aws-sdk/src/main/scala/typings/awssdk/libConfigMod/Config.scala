package typings.awsSdk.libConfigMod

import typings.awsSdk.libConfigUnderscoreServiceUnderscorePlaceholdersMod.ConfigurationServicePlaceholders
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

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

