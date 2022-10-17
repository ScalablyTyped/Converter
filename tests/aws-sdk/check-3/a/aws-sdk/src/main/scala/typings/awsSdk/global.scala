package typings.awsSdk

import typings.awsSdk.clientsDynamodbMod.AttributeValue
import typings.awsSdk.clientsDynamodbMod.ClientConfiguration
import typings.awsSdk.libConfigMod.Config
import typings.awsSdk.libDynamodbConverterMod.Converter.ConverterOptions
import typings.awsSdk.libDynamodbDocumentClientMod.DocumentClient.DocumentClientOptions
import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

object global {
  
  object AWS {
    
    @JSGlobal("AWS.DynamoDB")
    @js.native
    open class DynamoDB ()
      extends typings.awsSdk.mod.DynamoDB {
      def this(options: ClientConfiguration) = this()
    }
    object DynamoDB {
      
      @JSGlobal("AWS.DynamoDB.Converter")
      @js.native
      open class Converter ()
        extends typings.awsSdk.mod.DynamoDB.Converter
      /* static members */
      object Converter {
        
        @JSGlobal("AWS.DynamoDB.Converter")
        @js.native
        val ^ : js.Any = js.native
        
        inline def input(data: Any): AttributeValue = ^.asInstanceOf[js.Dynamic].applyDynamic("input")(data.asInstanceOf[js.Any]).asInstanceOf[AttributeValue]
        inline def input(data: Any, options: ConverterOptions): AttributeValue = (^.asInstanceOf[js.Dynamic].applyDynamic("input")(data.asInstanceOf[js.Any], options.asInstanceOf[js.Any])).asInstanceOf[AttributeValue]
      }
      
      @JSGlobal("AWS.DynamoDB.DocumentClient")
      @js.native
      /**
        * Creates a DynamoDB document client with a set of configuration options.
        */
      open class DocumentClient ()
        extends typings.awsSdk.mod.DynamoDB.DocumentClient {
        def this(options: DocumentClientOptions & ClientConfiguration) = this()
      }
    }
    
    @JSGlobal("AWS.config")
    @js.native
    val config: Config = js.native
  }
}
