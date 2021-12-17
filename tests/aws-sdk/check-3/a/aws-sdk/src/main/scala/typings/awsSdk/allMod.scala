package typings.awsSdk

import typings.awsSdk.converterMod.Converter.ConverterOptions
import typings.awsSdk.documentClientMod.DocumentClient.DocumentClientOptions
import typings.awsSdk.dynamodbMod.AttributeValue
import typings.awsSdk.dynamodbMod.ClientConfiguration
import typings.awsSdk.dynamodbMod.^
import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

object allMod {
  
  @JSImport("aws-sdk/clients/all", "DynamoDB")
  @js.native
  open class DynamoDB () extends ^ {
    def this(options: ClientConfiguration) = this()
  }
  object DynamoDB {
    
    @JSImport("aws-sdk/clients/all", "DynamoDB.Converter")
    @js.native
    open class Converter ()
      extends typings.awsSdk.dynamodbMod.Converter
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
      extends typings.awsSdk.dynamodbMod.DocumentClient {
      def this(options: DocumentClientOptions & ClientConfiguration) = this()
    }
  }
}
