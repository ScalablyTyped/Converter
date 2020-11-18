package typings.awsSdk

import typings.awsSdk.configMod.Config
import typings.awsSdk.documentClientMod.DocumentClient.ConverterOptions
import typings.awsSdk.documentClientMod.DocumentClient.DocumentClientOptions
import typings.awsSdk.dynamodbMod.AttributeValue
import typings.awsSdk.dynamodbMod.ClientConfiguration
import typings.awsSdk.dynamodbMod.^
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

@JSImport("aws-sdk", JSImport.Namespace)
@js.native
object mod extends js.Object {
  
  val config: Config = js.native
  
  @js.native
  class DynamoDB () extends ^ {
    def this(options: ClientConfiguration) = this()
  }
  @js.native
  object DynamoDB extends js.Object {
    
    @js.native
    class Converter ()
      extends typings.awsSdk.dynamodbMod.Converter
    /* static members */
    @js.native
    object Converter extends js.Object {
      
      def input(data: js.Any): AttributeValue = js.native
      def input(data: js.Any, options: ConverterOptions): AttributeValue = js.native
    }
    
    @js.native
    /**
      * Creates a DynamoDB document client with a set of configuration options.
      */
    class DocumentClient ()
      extends typings.awsSdk.dynamodbMod.DocumentClient {
      def this(options: DocumentClientOptions with ClientConfiguration) = this()
    }
  }
}
