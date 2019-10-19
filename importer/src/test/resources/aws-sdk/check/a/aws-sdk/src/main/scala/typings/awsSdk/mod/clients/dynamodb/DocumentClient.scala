package typings.awsSdk.mod.clients.dynamodb

import typings.awsSdk.mod.lib.dynamodb.documentClient.DocumentClient.DocumentClientOptions
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@JSImport("aws-sdk/clients/dynamodb", "DocumentClient")
@js.native
/**
  * Creates a DynamoDB document client with a set of configuration options.
  */
class DocumentClient ()
  extends typings.awsSdk.mod.lib.dynamodb.documentClient.DocumentClient {
  def this(options: DocumentClientOptions with ClientConfiguration) = this()
}

