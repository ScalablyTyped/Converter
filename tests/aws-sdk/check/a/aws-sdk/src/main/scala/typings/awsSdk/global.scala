package typings.awsSdk

import typings.awsSdk.configMod.Config
import typings.awsSdk.converterMod.Converter.ConverterOptions
import typings.awsSdk.documentClientMod.DocumentClient.DocumentClientOptions
import typings.awsSdk.dynamodbMod.AttributeValue
import typings.awsSdk.dynamodbMod.ClientConfiguration
import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

object global {
  
  object AWS {
    
    @JSGlobal("AWS.DynamoDB")
    @js.native
    class DynamoDB ()
      extends typings.awsSdk.mod.DynamoDB {
      def this(options: ClientConfiguration) = this()
    }
    object DynamoDB {
      
      @JSGlobal("AWS.DynamoDB.Converter")
      @js.native
      class Converter ()
        extends typings.awsSdk.mod.DynamoDB.Converter
      /* static members */
      object Converter {
        
        @JSGlobal("AWS.DynamoDB.Converter")
        @js.native
        val ^ : js.Any = js.native
        
        inline def input(data: js.Any): AttributeValue = ^.asInstanceOf[js.Dynamic].applyDynamic("input")(data.asInstanceOf[js.Any]).asInstanceOf[AttributeValue]
        inline def input(data: js.Any, options: ConverterOptions): AttributeValue = (^.asInstanceOf[js.Dynamic].applyDynamic("input")(data.asInstanceOf[js.Any], options.asInstanceOf[js.Any])).asInstanceOf[AttributeValue]
      }
      
      @JSGlobal("AWS.DynamoDB.DocumentClient")
      @js.native
      /**
        * Creates a DynamoDB document client with a set of configuration options.
        */
      class DocumentClient ()
        extends typings.awsSdk.mod.DynamoDB.DocumentClient {
        def this(options: DocumentClientOptions & ClientConfiguration) = this()
      }
    }
    
    @JSGlobal("AWS.config")
    @js.native
    val config: Config = js.native
  }
}
