package typings.awsDashSdk.libConfigUnderscoreServiceUnderscorePlaceholdersMod

import scala.scalajs.js.annotation.ScalaJSDefined
import typings.awsDashSdk.clientsDynamodbMod.apiVersion
import scala.scalajs.js
import scala.scalajs.js.`|`

trait ConfigurationServiceApiVersions extends js.Object {
  var dynamodb: js.UndefOr[apiVersion] = js.undefined
}

object ConfigurationServiceApiVersions {
  @inline
  def apply(dynamodb: apiVersion = null): ConfigurationServiceApiVersions = {
    val __obj = js.Dynamic.literal()
    if (dynamodb != null) __obj.updateDynamic("dynamodb")(dynamodb)
    __obj.asInstanceOf[ConfigurationServiceApiVersions]
  }
}

