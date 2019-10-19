package typings.awsSdk.mod

import typings.awsSdk.mod.clients.dynamodb.AttributeValue
import typings.awsSdk.mod.clients.dynamodb.ClientConfiguration
import typings.awsSdk.mod.lib.dynamodb.converter.Converter.ConverterOptions
import typings.awsSdk.mod.lib.dynamodb.documentClient.DocumentClient.DocumentClientOptions
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@JSImport("aws-sdk", "DynamoDB")
@js.native
class DynamoDB ()
  extends typings.awsSdk.mod.clients.all.DynamoDB {
  def this(options: ClientConfiguration) = this()
}

@JSImport("aws-sdk", "DynamoDB")
@js.native
object DynamoDB extends js.Object {
  @js.native
  class Converter ()
    extends typings.awsSdk.mod.clients.all.DynamoDB.Converter
  
  @js.native
  /**
    * Creates a DynamoDB document client with a set of configuration options.
    */
  class DocumentClient ()
    extends typings.awsSdk.mod.clients.all.DynamoDB.DocumentClient {
    def this(options: DocumentClientOptions with ClientConfiguration) = this()
  }
  
  /* static members */
  @js.native
  object Converter extends js.Object {
    def input(data: js.Any): AttributeValue = js.native
    def input(data: js.Any, options: ConverterOptions): AttributeValue = js.native
  }
  
}

