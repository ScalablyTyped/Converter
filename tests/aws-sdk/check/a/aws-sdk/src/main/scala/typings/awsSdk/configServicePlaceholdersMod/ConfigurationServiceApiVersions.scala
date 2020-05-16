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
  @scala.inline
  implicit class ConfigurationServiceApiVersionsOps[Self <: ConfigurationServiceApiVersions] (val x: Self) extends AnyVal {
    @scala.inline
    def duplicate: Self = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x)).asInstanceOf[Self]
    @scala.inline
    def combineWith[Other /* <: js.Any */](other: Other): Self with Other = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x, other.asInstanceOf[js.Any])).asInstanceOf[Self with Other]
    @scala.inline
    def withDynamodb(dynamodb: apiVersion): Self = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (dynamodb != null) ret.updateDynamic("dynamodb")(dynamodb.asInstanceOf[js.Any])
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withoutDynamodb: Self = {
        val ret = this.duplicate
        js.special.delete(ret, "dynamodb")
        ret.asInstanceOf[Self]
    }
  }
  
}

