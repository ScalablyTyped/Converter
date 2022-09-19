package typings.awsSdk

import typings.awsSdk.clientsDynamodbMod.AttributeValue
import typings.awsSdk.clientsDynamodbMod.ClientConfiguration
import typings.awsSdk.clientsDynamodbMod.^
import typings.awsSdk.libDynamodbConverterMod.Converter.ConverterOptions
import typings.awsSdk.libDynamodbDocumentClientMod.DocumentClient.DocumentClientOptions
import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

object clientsAllMod {
  
  @JSImport("aws-sdk/clients/all", "DynamoDB")
  @js.native
  open class DynamoDB () extends ^ {
    def this(options: ClientConfiguration) = this()
  }
  object DynamoDB {
    
    @JSImport("aws-sdk/clients/all", "DynamoDB.Converter")
    @js.native
    open class Converter ()
      extends typings.awsSdk.clientsDynamodbMod.Converter
    /* static members */
    object Converter {
      
      @JSImport("aws-sdk/clients/all", "DynamoDB.Converter")
      @js.native
      val ^ : js.Any = js.native
      
      inline def input(data: Any): AttributeValue = ^.asInstanceOf[js.Dynamic].applyDynamic("input")(data.asInstanceOf[js.Any]).asInstanceOf[AttributeValue]
      inline def input(data: Any, options: ConverterOptions): AttributeValue = (^.asInstanceOf[js.Dynamic].applyDynamic("input")(data.asInstanceOf[js.Any], options.asInstanceOf[js.Any])).asInstanceOf[AttributeValue]
    }
    
    @JSImport("aws-sdk/clients/all", "DynamoDB.DocumentClient")
    @js.native
    /**
      * Creates a DynamoDB document client with a set of configuration options.
      */
    open class DocumentClient ()
      extends typings.awsSdk.clientsDynamodbMod.DocumentClient {
      def this(options: DocumentClientOptions & ClientConfiguration) = this()
    }
  }
}
