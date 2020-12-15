package typings.awsSdk

import typings.awsSdk.configMod.Config
import typings.awsSdk.converterMod.Converter.ConverterOptions
import typings.awsSdk.documentClientMod.DocumentClient.DocumentClientOptions
import typings.awsSdk.dynamodbMod.AttributeValue
import typings.awsSdk.dynamodbMod.ClientConfiguration
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

object mod {
  
  @JSImport("aws-sdk", "config")
  @js.native
  val config: Config = js.native
  
  @JSImport("aws-sdk", "DynamoDB")
  @js.native
  class DynamoDB ()
    extends typings.awsSdk.allMod.DynamoDB {
    def this(options: ClientConfiguration) = this()
  }
  object DynamoDB {
    
    @JSImport("aws-sdk", "DynamoDB.Converter")
    @js.native
    class Converter ()
      extends typings.awsSdk.allMod.DynamoDB.Converter
    /* static members */
    object Converter {
      
      @JSImport("aws-sdk", "DynamoDB.Converter.input")
      @js.native
      def input(data: js.Any): AttributeValue = js.native
      @JSImport("aws-sdk", "DynamoDB.Converter.input")
      @js.native
      def input(data: js.Any, options: ConverterOptions): AttributeValue = js.native
    }
    
    @JSImport("aws-sdk", "DynamoDB.DocumentClient")
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
