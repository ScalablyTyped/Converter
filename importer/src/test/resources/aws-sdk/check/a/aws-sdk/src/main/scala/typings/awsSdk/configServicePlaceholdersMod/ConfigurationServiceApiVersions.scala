package typings.awsSdk.configServicePlaceholdersMod

import typings.awsSdk.dynamodbMod.apiVersion
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@js.native
trait ConfigurationServiceApiVersions extends js.Object {
  var dynamodb: js.UndefOr[apiVersion] = js.native
}

object ConfigurationServiceApiVersions {
  @scala.inline
  def apply(dynamodb: apiVersion = null): ConfigurationServiceApiVersions = {
    val __obj = js.Dynamic.literal()
    if (dynamodb != null) __obj.updateDynamic("dynamodb")(dynamodb.asInstanceOf[js.Any])
    __obj.asInstanceOf[ConfigurationServiceApiVersions]
  }
}

