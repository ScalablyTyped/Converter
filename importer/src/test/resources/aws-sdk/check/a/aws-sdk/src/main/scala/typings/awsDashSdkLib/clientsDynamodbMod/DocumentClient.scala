package typings
package awsDashSdkLib.clientsDynamodbMod

import awsDashSdkLib.libDynamodbDocumentUnderscoreClientMod.DocumentClientNs.DocumentClientOptions
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@JSImport("aws-sdk/clients/dynamodb", "DocumentClient")
@js.native
/**
  * Creates a DynamoDB document client with a set of configuration options.
  */
class DocumentClient ()
  extends awsDashSdkLib.libDynamodbDocumentUnderscoreClientMod.DocumentClient {
  def this(options: DocumentClientOptions with ClientConfiguration) = this()
}

