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
  class DocumentClient ()
    extends awsDashSdkLib.clientsDynamodbMod.DocumentClient {
    /**
         * Creates a DynamoDB document client with a set of configuration options.
         */
    def this(options: awsDashSdkLib.libDynamodbDocumentUnderscoreClientMod.DocumentClientNs.DocumentClientOptions with awsDashSdkLib.clientsDynamodbMod.DynamoDBNs.ClientConfiguration) = this()
  }
  
  @js.native
  class Types ()
    extends awsDashSdkLib.clientsDynamodbMod.Types {
    def this(options: awsDashSdkLib.clientsDynamodbMod.DynamoDBNs.ClientConfiguration) = this()
  }
  
  val TypesNs: this.type = js.native
  @js.native
  object Converter extends js.Object {
    def input(data: js.Any): awsDashSdkLib.clientsDynamodbMod.DynamoDBNs.AttributeValue = js.native
    def input(data: js.Any, options: awsDashSdkLib.libDynamodbConverterMod.ConverterNs.ConverterOptions): awsDashSdkLib.clientsDynamodbMod.DynamoDBNs.AttributeValue = js.native
  }
  
  @JSName("DynamoDB")
  @js.native
  object DynamoDBNs extends js.Object {
    @js.native
    class Converter ()
      extends awsDashSdkLib.clientsDynamodbMod.DynamoDBNs.Converter
    
    @js.native
    class DocumentClient ()
      extends awsDashSdkLib.clientsDynamodbMod.DynamoDBNs.DocumentClient {
      /**
           * Creates a DynamoDB document client with a set of configuration options.
           */
      def this(options: awsDashSdkLib.libDynamodbDocumentUnderscoreClientMod.DocumentClientNs.DocumentClientOptions with awsDashSdkLib.clientsDynamodbMod.DynamoDBNs.ClientConfiguration) = this()
    }
    
    val TypesNs: this.type = js.native
    @js.native
    object Converter extends js.Object {
      def input(data: js.Any): awsDashSdkLib.clientsDynamodbMod.DynamoDBNs.AttributeValue = js.native
      def input(data: js.Any, options: awsDashSdkLib.libDynamodbConverterMod.ConverterNs.ConverterOptions): awsDashSdkLib.clientsDynamodbMod.DynamoDBNs.AttributeValue = js.native
    }
    
  }
  
}

