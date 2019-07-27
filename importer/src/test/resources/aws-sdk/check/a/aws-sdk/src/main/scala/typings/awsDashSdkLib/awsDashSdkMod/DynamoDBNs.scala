package typings
package awsDashSdkLib.awsDashSdkMod

import awsDashSdkLib.clientsDynamodbMod.AttributeValue
import awsDashSdkLib.clientsDynamodbMod.ClientConfiguration
import awsDashSdkLib.libDynamodbConverterMod.ConverterNs.ConverterOptions
import awsDashSdkLib.libDynamodbDocumentUnderscoreClientMod.DocumentClientNs.DocumentClientOptions
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@JSImport("aws-sdk", "DynamoDB")
@js.native
object DynamoDBNs extends js.Object {
  @js.native
  class Converter ()
    extends awsDashSdkLib.clientsAllMod.DynamoDBNs.Converter
  
  @js.native
  /**
    * Creates a DynamoDB document client with a set of configuration options.
    */
  class DocumentClient ()
    extends awsDashSdkLib.clientsAllMod.DynamoDBNs.DocumentClient {
    def this(options: DocumentClientOptions with ClientConfiguration) = this()
  }
  
  /* static members */
  @js.native
  object Converter extends js.Object {
    def input(data: js.Any): AttributeValue = js.native
    def input(data: js.Any, options: ConverterOptions): AttributeValue = js.native
  }
  
}

