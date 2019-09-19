package typings.awsDashSdk.awsDashSdkMod.DynamoDBNs

import typings.awsDashSdk.clientsDynamodbMod.ClientConfiguration
import typings.awsDashSdk.libDynamodbDocumentUnderscoreClientMod.DocumentClientNs.DocumentClientOptions
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@JSImport("aws-sdk", "DynamoDB.DocumentClient")
@js.native
/**
  * Creates a DynamoDB document client with a set of configuration options.
  */
class DocumentClient ()
  extends typings.awsDashSdk.clientsAllMod.DynamoDBNs.DocumentClient {
  def this(options: DocumentClientOptions with ClientConfiguration) = this()
}

