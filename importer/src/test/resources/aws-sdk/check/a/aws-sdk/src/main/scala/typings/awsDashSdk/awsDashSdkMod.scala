package typings.awsDashSdk

import typings.awsDashSdk.clientsDynamodbMod.AttributeValue
import typings.awsDashSdk.clientsDynamodbMod.ClientConfiguration
import typings.awsDashSdk.libConfigMod.Config
import typings.awsDashSdk.libDynamodbConverterMod.Converter.ConverterOptions
import typings.awsDashSdk.libDynamodbDocumentUnderscoreClientMod.DocumentClient.DocumentClientOptions
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@JSImport("aws-sdk", JSImport.Namespace)
@js.native
object awsDashSdkMod extends js.Object {
  @js.native
  class DynamoDB ()
    extends typings.awsDashSdk.clientsAllMod.DynamoDB {
    def this(options: ClientConfiguration) = this()
  }
  
  val config: Config = js.native
  @js.native
  object DynamoDB extends js.Object {
    @js.native
    class Converter ()
      extends typings.awsDashSdk.clientsAllMod.DynamoDB.Converter
    
    @js.native
    /**
      * Creates a DynamoDB document client with a set of configuration options.
      */
    class DocumentClient ()
      extends typings.awsDashSdk.clientsAllMod.DynamoDB.DocumentClient {
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

