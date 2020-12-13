package typings.awsSdk

import typings.awsSdk.awsSdkStrings.latest
import typings.awsSdk.converterMod.Converter.ConverterOptions
import typings.awsSdk.documentClientMod.DocumentClient.DocumentClientOptions
import typings.awsSdk.servicesDynamodbMod.DynamoDBCustomizations
import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

object dynamodbMod {
  
  @JSImport("aws-sdk/clients/dynamodb", JSImport.Namespace)
  @js.native
  class ^ () extends DynamoDBCustomizations {
    def this(options: ClientConfiguration) = this()
  }
  
  @JSImport("aws-sdk/clients/dynamodb", "Converter")
  @js.native
  class Converter ()
    extends typings.awsSdk.converterMod.Converter
  /* static members */
  object Converter {
    
    @JSImport("aws-sdk/clients/dynamodb", "Converter.input")
    @js.native
    def input(data: js.Any): AttributeValue = js.native
    @JSImport("aws-sdk/clients/dynamodb", "Converter.input")
    @js.native
    def input(data: js.Any, options: ConverterOptions): AttributeValue = js.native
  }
  
  @JSImport("aws-sdk/clients/dynamodb", "DocumentClient")
  @js.native
  /**
    * Creates a DynamoDB document client with a set of configuration options.
    */
  class DocumentClient ()
    extends typings.awsSdk.documentClientMod.DocumentClient {
    def this(options: DocumentClientOptions with ClientConfiguration) = this()
  }
  
  type AttributeValue = js.Any
  
  type ClientConfiguration = js.Any
  
  type DynamoDB = DynamoDBCustomizations
  
  type apiVersion = latest
}
