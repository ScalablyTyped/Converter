package typings.awsDashSdk

import scala.scalajs.js.annotation.JSImport
import scala.scalajs.js.annotation.JSImport.Namespace
import typings.awsDashSdk.clientsDynamodbMod.AttributeValue
import typings.awsDashSdk.clientsDynamodbMod.ClientConfiguration
import typings.awsDashSdk.clientsDynamodbMod.^
import typings.awsDashSdk.libDynamodbConverterMod.Converter.ConverterOptions
import typings.awsDashSdk.libDynamodbDocumentUnderscoreClientMod.DocumentClient.DocumentClientOptions
import scala.scalajs.js
import scala.scalajs.js.`|`

@JSImport("aws-sdk/clients/all", Namespace)
@js.native
object clientsAllMod extends js.Object {
  @js.native
  class DynamoDB () extends ^ {
    def this(options: ClientConfiguration) = this()
  }
  
  @js.native
  object DynamoDB extends js.Object {
    @js.native
    class Converter () extends typings.awsDashSdk.clientsDynamodbMod.Converter
    
    @js.native
    /**
      * Creates a DynamoDB document client with a set of configuration options.
      */
    class DocumentClient () extends typings.awsDashSdk.clientsDynamodbMod.DocumentClient {
      def this(options: DocumentClientOptions with ClientConfiguration) = this()
    }
    
    /* static members */
    @js.native
    object Converter extends js.Object {
      def input(data: js.Any): AttributeValue = js.native
      def input(data: js.Any, options: ConverterOptions): AttributeValue = js.native
    }
    
  }
  
}

