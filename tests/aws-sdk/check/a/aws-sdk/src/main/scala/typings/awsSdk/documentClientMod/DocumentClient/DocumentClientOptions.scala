package typings.awsSdk.documentClientMod.DocumentClient

import org.scalablytyped.runtime.StringDictionary
import typings.awsSdk.dynamodbMod.^
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@js.native
trait DocumentClientOptions extends ConverterOptions {
  /**
    * An optional map of parameters to bind to every request sent by this service object.
    */
  var params: js.UndefOr[StringDictionary[js.Any]] = js.native
  /**
    * An optional pre-configured instance of the AWS.DynamoDB service object to use for requests. The object may bound parameters used by the document client.
    */
  var service: js.UndefOr[^] = js.native
}

object DocumentClientOptions {
  @scala.inline
  def apply(
    convertEmptyValues: js.UndefOr[Boolean] = js.undefined,
    params: StringDictionary[js.Any] = null,
    service: ^ = null,
    wrapNumbers: js.UndefOr[Boolean] = js.undefined
  ): DocumentClientOptions = {
    val __obj = js.Dynamic.literal()
    if (!js.isUndefined(convertEmptyValues)) __obj.updateDynamic("convertEmptyValues")(convertEmptyValues.asInstanceOf[js.Any])
    if (params != null) __obj.updateDynamic("params")(params.asInstanceOf[js.Any])
    if (service != null) __obj.updateDynamic("service")(service.asInstanceOf[js.Any])
    if (!js.isUndefined(wrapNumbers)) __obj.updateDynamic("wrapNumbers")(wrapNumbers.asInstanceOf[js.Any])
    __obj.asInstanceOf[DocumentClientOptions]
  }
  @scala.inline
  implicit class DocumentClientOptionsOps[Self <: DocumentClientOptions] (val x: Self) extends AnyVal {
    @scala.inline
    def duplicate: Self = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x)).asInstanceOf[Self]
    @scala.inline
    def combineWith[Other /* <: js.Any */](other: Other): Self with Other = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x, other.asInstanceOf[js.Any])).asInstanceOf[Self with Other]
    @scala.inline
    def withParams(params: StringDictionary[js.Any]): Self = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (params != null) ret.updateDynamic("params")(params.asInstanceOf[js.Any])
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withoutParams: Self = {
        val ret = this.duplicate
        js.special.delete(ret, "params")
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withService(service: ^): Self = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (service != null) ret.updateDynamic("service")(service.asInstanceOf[js.Any])
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withoutService: Self = {
        val ret = this.duplicate
        js.special.delete(ret, "service")
        ret.asInstanceOf[Self]
    }
  }
  
}

