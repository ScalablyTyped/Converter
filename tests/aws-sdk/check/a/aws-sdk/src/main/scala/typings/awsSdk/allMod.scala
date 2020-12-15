package typings.awsSdk

import typings.awsSdk.converterMod.Converter.ConverterOptions
import typings.awsSdk.documentClientMod.DocumentClient.DocumentClientOptions
import typings.awsSdk.dynamodbMod.AttributeValue
import typings.awsSdk.dynamodbMod.ClientConfiguration
import typings.awsSdk.dynamodbMod.^
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

object allMod {
  
  @JSImport("aws-sdk/clients/all", "DynamoDB")
  @js.native
  class DynamoDB () extends ^ {
    def this(options: ClientConfiguration) = this()
  }
  object DynamoDB {
    
    @JSImport("aws-sdk/clients/all", "DynamoDB.Converter")
    @js.native
    class Converter ()
      extends typings.awsSdk.dynamodbMod.Converter
    /* static members */
    object Converter {
      
      @JSImport("aws-sdk/clients/all", "DynamoDB.Converter.input")
      @js.native
      def input(data: js.Any): AttributeValue = js.native
      @JSImport("aws-sdk/clients/all", "DynamoDB.Converter.input")
      @js.native
      def input(data: js.Any, options: ConverterOptions): AttributeValue = js.native
    }
    
    @JSImport("aws-sdk/clients/all", "DynamoDB.DocumentClient")
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
