package typings.awsSdk

import typings.awsSdk.clientsDynamodbMod.AttributeValue
import typings.awsSdk.clientsDynamodbMod.ClientConfiguration
import typings.awsSdk.clientsDynamodbMod.^
import typings.awsSdk.libDynamodbConverterMod.Converter.ConverterOptions
import typings.awsSdk.libDynamodbDocumentUnderscoreClientMod.DocumentClient.DocumentClientOptions
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@JSImport("aws-sdk/clients/all", JSImport.Namespace)
@js.native
object clientsAllMod extends js.Object {
  @js.native
  class DynamoDB () extends ^ {
    def this(options: ClientConfiguration) = this()
  }
  
  @js.native
  object DynamoDB extends js.Object {
    @js.native
    class Converter ()
      extends typings.awsSdk.clientsDynamodbMod.Converter
    
    @js.native
    /**
      * Creates a DynamoDB document client with a set of configuration options.
      */
    class DocumentClient ()
      extends typings.awsSdk.clientsDynamodbMod.DocumentClient {
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

