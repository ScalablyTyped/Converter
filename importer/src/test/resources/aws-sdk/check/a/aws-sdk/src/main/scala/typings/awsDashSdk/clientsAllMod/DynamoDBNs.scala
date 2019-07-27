package typings.awsDashSdk.clientsAllMod

import typings.awsDashSdk.clientsDynamodbMod.AttributeValue
import typings.awsDashSdk.clientsDynamodbMod.ClientConfiguration
import typings.awsDashSdk.libDynamodbConverterMod.ConverterNs.ConverterOptions
import typings.awsDashSdk.libDynamodbDocumentUnderscoreClientMod.DocumentClientNs.DocumentClientOptions
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@JSImport("aws-sdk/clients/all", "DynamoDB")
@js.native
object DynamoDBNs extends js.Object {
  @js.native
  class Converter ()
    extends typings.awsDashSdk.clientsDynamodbMod.Converter
  
  @js.native
  /**
    * Creates a DynamoDB document client with a set of configuration options.
    */
  class DocumentClient ()
    extends typings.awsDashSdk.clientsDynamodbMod.DocumentClient {
    def this(options: DocumentClientOptions with ClientConfiguration) = this()
  }
  
  /* static members */
  @js.native
  object Converter extends js.Object {
    def input(data: js.Any): AttributeValue = js.native
    def input(data: js.Any, options: ConverterOptions): AttributeValue = js.native
  }
  
}

