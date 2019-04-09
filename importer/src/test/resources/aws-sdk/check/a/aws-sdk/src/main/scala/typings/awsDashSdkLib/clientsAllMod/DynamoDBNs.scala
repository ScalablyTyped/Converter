package typings
package awsDashSdkLib.clientsAllMod

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@JSImport("aws-sdk/clients/all", "DynamoDB")
@js.native
object DynamoDBNs extends js.Object {
  @js.native
  class Converter ()
    extends awsDashSdkLib.clientsDynamodbMod.Converter
  
  @js.native
  /**
    * Creates a DynamoDB document client with a set of configuration options.
    */
  class DocumentClient ()
    extends awsDashSdkLib.clientsDynamodbMod.DocumentClient {
    def this(options: awsDashSdkLib.libDynamodbDocumentUnderscoreClientMod.DocumentClientNs.DocumentClientOptions with awsDashSdkLib.clientsDynamodbMod.ClientConfiguration) = this()
  }
  
  /* static members */
  @js.native
  object Converter extends js.Object {
    def input(data: js.Any): awsDashSdkLib.clientsDynamodbMod.AttributeValue = js.native
    def input(data: js.Any, options: awsDashSdkLib.libDynamodbConverterMod.ConverterNs.ConverterOptions): awsDashSdkLib.clientsDynamodbMod.AttributeValue = js.native
  }
  
}

