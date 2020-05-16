package typings.awsSdk.configMod

import typings.awsSdk.awsSdkStrings.latest
import typings.awsSdk.configServicePlaceholdersMod.ConfigurationServiceApiVersions
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

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
    def withApiVersion(value: latest | String): Self = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("apiVersion")(value.asInstanceOf[js.Any])
        ret
    }
    @scala.inline
    def withoutApiVersion: Self = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("apiVersion")(js.undefined)
        ret
    }
    @scala.inline
    def withApiVersions(value: ConfigurationServiceApiVersions): Self = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("apiVersions")(value.asInstanceOf[js.Any])
        ret
    }
    @scala.inline
    def withoutApiVersions: Self = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("apiVersions")(js.undefined)
        ret
    }
  }
  
}

