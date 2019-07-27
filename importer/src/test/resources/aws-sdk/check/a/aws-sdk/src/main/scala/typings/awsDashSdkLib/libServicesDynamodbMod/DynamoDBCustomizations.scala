package typings
package awsDashSdkLib.libServicesDynamodbMod

import awsDashSdkLib.clientsDynamodbMod.ClientConfiguration
import awsDashSdkLib.libDynamodbDocumentUnderscoreClientMod.DocumentClientNs.DocumentClientOptions
import org.scalablytyped.runtime.Instantiable1
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@JSImport("aws-sdk/lib/services/dynamodb", "DynamoDBCustomizations")
@js.native
class DynamoDBCustomizations () extends js.Object

/* static members */
@JSImport("aws-sdk/lib/services/dynamodb", "DynamoDBCustomizations")
@js.native
object DynamoDBCustomizations extends js.Object {
  /**
    * The document client simplifies working with items in Amazon DynamoDB by abstracting away the notion of attribute values.
    * This abstraction annotates native JavaScript types supplied as input parameters, as well as converts annotated response data to native JavaScript types.
    */
  var DocumentClient: Instantiable1[
    js.UndefOr[/* options */ DocumentClientOptions with ClientConfiguration], 
    awsDashSdkLib.libDynamodbDocumentUnderscoreClientMod.DocumentClient
  ] = js.native
}

