package typings.awsSdk.mod.clients

import typings.awsSdk.mod.clients.dynamodb.AttributeValue
import typings.awsSdk.mod.clients.dynamodb.ClientConfiguration
import typings.awsSdk.mod.clients.dynamodb.^
import typings.awsSdk.mod.lib.dynamodb.converter.Converter.ConverterOptions
import typings.awsSdk.mod.lib.dynamodb.documentClient.DocumentClient.DocumentClientOptions
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@JSImport("aws-sdk/clients/all", JSImport.Namespace)
@js.native
object all extends js.Object {
  @js.native
  class DynamoDB () extends ^ {
    def this(options: ClientConfiguration) = this()
  }
  
  @js.native
  object DynamoDB extends js.Object {
    @js.native
    class Converter ()
      extends typings.awsSdk.mod.clients.dynamodb.Converter
    
    @js.native
    /**
      * Creates a DynamoDB document client with a set of configuration options.
      */
    class DocumentClient ()
      extends typings.awsSdk.mod.clients.dynamodb.DocumentClient {
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

