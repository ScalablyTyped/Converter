package typings.awsSdk

import typings.awsSdk.clientsDynamodbMod.AttributeValue
import typings.awsSdk.clientsDynamodbMod.ClientConfiguration
import typings.awsSdk.libConfigMod.Config
import typings.awsSdk.libDynamodbConverterMod.Converter.ConverterOptions
import typings.awsSdk.libDynamodbDocumentUnderscoreClientMod.DocumentClient.DocumentClientOptions
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@JSImport("aws-sdk", JSImport.Namespace)
@js.native
object awsSdkMod extends js.Object {
  @js.native
  class DynamoDB ()
    extends typings.awsSdk.clientsAllMod.DynamoDB {
    def this(options: ClientConfiguration) = this()
  }
  
  val config: Config = js.native
  @js.native
  object DynamoDB extends js.Object {
    @js.native
    class Converter ()
      extends typings.awsSdk.clientsAllMod.DynamoDB.Converter
    
    @js.native
    /**
      * Creates a DynamoDB document client with a set of configuration options.
      */
    class DocumentClient ()
      extends typings.awsSdk.clientsAllMod.DynamoDB.DocumentClient {
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

