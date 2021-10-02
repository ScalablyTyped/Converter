package typings.awsSdk

import org.scalablytyped.runtime.StringDictionary
import typings.awsSdk.documentClientMod.DocumentClient.DocumentClientOptions
import typings.awsSdk.dynamodbMod.ClientConfiguration
import typings.awsSdk.dynamodbMod.^
import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

object documentClientMod {
  
  @JSImport("aws-sdk/lib/dynamodb/document_client", "DocumentClient")
  @js.native
  /**
    * Creates a DynamoDB document client with a set of configuration options.
    */
  open class DocumentClient () extends StObject {
    def this(options: DocumentClientOptions & ClientConfiguration) = this()
  }
  object DocumentClient {
    
    /* Rewritten from type alias, can be one of: 
      - typings.awsSdk.awsSdkStrings.ADD
      - typings.awsSdk.awsSdkStrings.PUT
      - typings.awsSdk.awsSdkStrings.DELETE
      - java.lang.String
    */
    type AttributeAction = _AttributeAction | String
    
    trait ConverterOptions extends StObject {
      
      /**
        * An optional flag indicating that the document client should cast
        * empty strings, buffers, and sets to NULL shapes
        */
      var convertEmptyValues: js.UndefOr[Boolean] = js.undefined
      
      /**
        * Whether to return numbers as a NumberValue object instead of
        * converting them to native JavaScript numbers. This allows for the
        * safe round-trip transport of numbers of arbitrary size.
        */
      var wrapNumbers: js.UndefOr[Boolean] = js.undefined
    }
    object ConverterOptions {
      
      inline def apply(): ConverterOptions = {
        val __obj = js.Dynamic.literal()
        __obj.asInstanceOf[ConverterOptions]
      }
      
      extension [Self <: ConverterOptions](x: Self) {
        
        inline def setConvertEmptyValues(value: Boolean): Self = StObject.set(x, "convertEmptyValues", value.asInstanceOf[js.Any])
        
        inline def setConvertEmptyValuesUndefined: Self = StObject.set(x, "convertEmptyValues", js.undefined)
        
        inline def setWrapNumbers(value: Boolean): Self = StObject.set(x, "wrapNumbers", value.asInstanceOf[js.Any])
        
        inline def setWrapNumbersUndefined: Self = StObject.set(x, "wrapNumbers", js.undefined)
      }
    }
    
    trait DocumentClientOptions
      extends StObject
         with ConverterOptions {
      
      /**
        * An optional map of parameters to bind to every request sent by this service object.
        */
      var params: js.UndefOr[StringDictionary[js.Any]] = js.undefined
      
      /**
        * An optional pre-configured instance of the AWS.DynamoDB service object to use for requests. The object may bound parameters used by the document client.
        */
      var service: js.UndefOr[^] = js.undefined
    }
    object DocumentClientOptions {
      
      inline def apply(): DocumentClientOptions = {
        val __obj = js.Dynamic.literal()
        __obj.asInstanceOf[DocumentClientOptions]
      }
      
      extension [Self <: DocumentClientOptions](x: Self) {
        
        inline def setParams(value: StringDictionary[js.Any]): Self = StObject.set(x, "params", value.asInstanceOf[js.Any])
        
        inline def setParamsUndefined: Self = StObject.set(x, "params", js.undefined)
        
        inline def setService(value: ^): Self = StObject.set(x, "service", value.asInstanceOf[js.Any])
        
        inline def setServiceUndefined: Self = StObject.set(x, "service", js.undefined)
      }
    }
    
    trait _AttributeAction extends StObject
  }
}
