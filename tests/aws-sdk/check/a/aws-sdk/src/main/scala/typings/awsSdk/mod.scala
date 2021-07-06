package typings.awsSdk

import typings.awsSdk.configMod.Config
import typings.awsSdk.converterMod.Converter.ConverterOptions
import typings.awsSdk.documentClientMod.DocumentClient.DocumentClientOptions
import typings.awsSdk.dynamodbMod.AttributeValue
import typings.awsSdk.dynamodbMod.ClientConfiguration
import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

object mod {
  
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
      
      @JSImport("aws-sdk", "DynamoDB.Converter")
      @js.native
      val ^ : js.Any = js.native
      
      @scala.inline
      def input(data: js.Any): AttributeValue = ^.asInstanceOf[js.Dynamic].applyDynamic("input")(data.asInstanceOf[js.Any]).asInstanceOf[AttributeValue]
      @scala.inline
      def input(data: js.Any, options: ConverterOptions): AttributeValue = (^.asInstanceOf[js.Dynamic].applyDynamic("input")(data.asInstanceOf[js.Any], options.asInstanceOf[js.Any])).asInstanceOf[AttributeValue]
    }
    
    @JSImport("aws-sdk", "DynamoDB.DocumentClient")
    @js.native
    /**
      * Creates a DynamoDB document client with a set of configuration options.
      */
    class DocumentClient ()
      extends typings.awsSdk.allMod.DynamoDB.DocumentClient {
      def this(options: DocumentClientOptions & ClientConfiguration) = this()
    }
  }
  
  @JSImport("aws-sdk", "config")
  @js.native
  val config: Config = js.native
}
