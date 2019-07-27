package typings.awsDashSdkLib.libConfigUnderscoreServiceUnderscorePlaceholdersMod

import typings.awsDashSdkLib.clientsDynamodbMod.apiVersion
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

trait ConfigurationServiceApiVersions extends js.Object {
  var dynamodb: js.UndefOr[apiVersion] = js.undefined
}

object ConfigurationServiceApiVersions {
  @scala.inline
  def apply(dynamodb: apiVersion = null): ConfigurationServiceApiVersions = {
    val __obj = js.Dynamic.literal()
    if (dynamodb != null) __obj.updateDynamic("dynamodb")(dynamodb)
    __obj.asInstanceOf[ConfigurationServiceApiVersions]
  }
}

