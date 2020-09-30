package typings.awsSdk.configServicePlaceholdersMod

import typings.awsSdk.dynamodbMod.apiVersion
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

@js.native
trait ConfigurationServiceApiVersions extends js.Object {
  var dynamodb: js.UndefOr[apiVersion] = js.native
}

object ConfigurationServiceApiVersions {
  @scala.inline
  def apply(): ConfigurationServiceApiVersions = {
    val __obj = js.Dynamic.literal()
    __obj.asInstanceOf[ConfigurationServiceApiVersions]
  }
  @scala.inline
  implicit class ConfigurationServiceApiVersionsOps[Self <: ConfigurationServiceApiVersions] (val x: Self) extends AnyVal {
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
    def setDynamodb(value: apiVersion): Self = this.set("dynamodb", value.asInstanceOf[js.Any])
    @scala.inline
    def deleteDynamodb: Self = this.set("dynamodb", js.undefined)
  }
  
}

