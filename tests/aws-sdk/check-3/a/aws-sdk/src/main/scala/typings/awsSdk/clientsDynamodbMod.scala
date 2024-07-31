package typings.awsSdk

import _root_.typings.awsSdk.awsSdkStrings.latest
import _root_.typings.awsSdk.libDynamodbConverterMod.Converter.ConverterOptions
import _root_.typings.awsSdk.libDynamodbDocumentClientMod.DocumentClient.DocumentClientOptions
import _root_.typings.awsSdk.libServicesDynamodbMod.DynamoDBCustomizations
import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

object clientsDynamodbMod {
  
  @JSImport("aws-sdk/clients/dynamodb", JSImport.Namespace)
  @js.native
  open class ^ () extends DynamoDBCustomizations {
    def this(options: ClientConfiguration) = this()
  }
  
  @JSImport("aws-sdk/clients/dynamodb", "Converter")
  @js.native
  open class Converter ()
    extends _root_.typings.awsSdk.libDynamodbConverterMod.Converter
  /* static members */
  object Converter {
    
    @JSImport("aws-sdk/clients/dynamodb", "Converter")
    @js.native
    val ^ : js.Any = js.native
    
    inline def input(data: Any): AttributeValue = ^.asInstanceOf[js.Dynamic].applyDynamic("input")(data.asInstanceOf[js.Any]).asInstanceOf[AttributeValue]
    inline def input(data: Any, options: ConverterOptions): AttributeValue = (^.asInstanceOf[js.Dynamic].applyDynamic("input")(data.asInstanceOf[js.Any], options.asInstanceOf[js.Any])).asInstanceOf[AttributeValue]
  }
  
  @JSImport("aws-sdk/clients/dynamodb", "DocumentClient")
  @js.native
  /**
    * Creates a DynamoDB document client with a set of configuration options.
    */
  open class DocumentClient ()
    extends _root_.typings.awsSdk.libDynamodbDocumentClientMod.DocumentClient {
    def this(options: DocumentClientOptions & ClientConfiguration) = this()
  }
  
  type AttributeValue = Any
  
  type ClientConfiguration = Any
  
  type DynamoDB = DynamoDBCustomizations
  
  type apiVersion = latest
}
