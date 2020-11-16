package typings.awsSdk

import typings.awsSdk.configMod.Config
import typings.awsSdk.converterMod.Converter.ConverterOptions
import typings.awsSdk.documentClientMod.DocumentClient.DocumentClientOptions
import typings.awsSdk.dynamodbMod.AttributeValue
import typings.awsSdk.dynamodbMod.ClientConfiguration
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

@JSImport("aws-sdk", JSImport.Namespace)
@js.native
object mod extends js.Object {
  
  val config: Config = js.native
  
  @js.native
  class DynamoDB ()
    extends typings.awsSdk.allMod.DynamoDB {
    def this(options: ClientConfiguration) = this()
  }
  @js.native
  object DynamoDB extends js.Object {
    
    @js.native
    class Converter ()
      extends typings.awsSdk.allMod.DynamoDB.Converter
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
      extends typings.awsSdk.allMod.DynamoDB.DocumentClient {
      def this(options: DocumentClientOptions with ClientConfiguration) = this()
    }
  }
}
