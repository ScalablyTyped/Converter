package typings.awsSdk

import typings.awsSdk.awsSdkStrings.latest
import typings.awsSdk.converterMod.Converter.ConverterOptions
import typings.awsSdk.documentClientMod.DocumentClient.DocumentClientOptions
import typings.awsSdk.servicesDynamodbMod.DynamoDBCustomizations
import org.scalablytyped.runtime.StObject
import scala.scalajs.js
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
    
    @JSImport("aws-sdk/clients/dynamodb", "Converter")
    @js.native
    val ^ : js.Any = js.native
    
    @scala.inline
    def input(data: js.Any): AttributeValue = ^.asInstanceOf[js.Dynamic].applyDynamic("input")(data.asInstanceOf[js.Any]).asInstanceOf[AttributeValue]
    @scala.inline
    def input(data: js.Any, options: ConverterOptions): AttributeValue = (^.asInstanceOf[js.Dynamic].applyDynamic("input")(data.asInstanceOf[js.Any], options.asInstanceOf[js.Any])).asInstanceOf[AttributeValue]
  }
  
  @JSImport("aws-sdk/clients/dynamodb", "DocumentClient")
  @js.native
  /**
    * Creates a DynamoDB document client with a set of configuration options.
    */
  class DocumentClient ()
    extends typings.awsSdk.documentClientMod.DocumentClient {
    def this(options: DocumentClientOptions & ClientConfiguration) = this()
  }
  
  type AttributeValue = js.Any
  
  type ClientConfiguration = js.Any
  
  type DynamoDB = DynamoDBCustomizations
  
  type apiVersion = latest
}
