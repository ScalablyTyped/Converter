package typings.awsDashSdkLib.clientsAllMod

import typings.awsDashSdkLib.clientsDynamodbMod.AttributeValue
import typings.awsDashSdkLib.clientsDynamodbMod.ClientConfiguration
import typings.awsDashSdkLib.libDynamodbConverterMod.ConverterNs.ConverterOptions
import typings.awsDashSdkLib.libDynamodbDocumentUnderscoreClientMod.DocumentClientNs.DocumentClientOptions
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@JSImport("aws-sdk/clients/all", "DynamoDB")
@js.native
object DynamoDBNs extends js.Object {
  @js.native
  class Converter ()
    extends typings.awsDashSdkLib.clientsDynamodbMod.Converter
  
  @js.native
  /**
    * Creates a DynamoDB document client with a set of configuration options.
    */
  class DocumentClient ()
    extends typings.awsDashSdkLib.clientsDynamodbMod.DocumentClient {
    def this(options: DocumentClientOptions with ClientConfiguration) = this()
  }
  
  /* static members */
  @js.native
  object Converter extends js.Object {
    def input(data: js.Any): AttributeValue = js.native
    def input(data: js.Any, options: ConverterOptions): AttributeValue = js.native
  }
  
}

