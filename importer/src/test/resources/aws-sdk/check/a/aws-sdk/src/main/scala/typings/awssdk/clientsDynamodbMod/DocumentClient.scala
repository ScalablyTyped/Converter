package typings.awsSdk.clientsDynamodbMod

import typings.awsSdk.libDynamodbDocumentClientMod.DocumentClient.DocumentClientOptions
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@JSImport("aws-sdk/clients/dynamodb", "DocumentClient")
@js.native
/**
  * Creates a DynamoDB document client with a set of configuration options.
  */
class DocumentClient ()
  extends typings.awsSdk.libDynamodbDocumentClientMod.DocumentClient {
  def this(options: DocumentClientOptions with ClientConfiguration) = this()
}

