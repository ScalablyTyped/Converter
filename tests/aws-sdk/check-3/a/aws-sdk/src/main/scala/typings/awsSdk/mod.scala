package typings.awsSdk

import _root_.typings.awsSdk.clientsDynamodbMod.AttributeValue
import _root_.typings.awsSdk.clientsDynamodbMod.ClientConfiguration
import _root_.typings.awsSdk.libConfigMod.Config
import _root_.typings.awsSdk.libDynamodbConverterMod.Converter.ConverterOptions
import _root_.typings.awsSdk.libDynamodbDocumentClientMod.DocumentClient.DocumentClientOptions
import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

object mod {
  
  @JSImport("aws-sdk", "DynamoDB")
  @js.native
  open class DynamoDB ()
    extends _root_.typings.awsSdk.clientsAllMod.DynamoDB {
    def this(options: ClientConfiguration) = this()
  }
  object DynamoDB {
    
    @JSImport("aws-sdk", "DynamoDB.Converter")
    @js.native
    open class Converter ()
      extends _root_.typings.awsSdk.clientsAllMod.DynamoDB.Converter
    /* static members */
    object Converter {
      
      @JSImport("aws-sdk", "DynamoDB.Converter")
      @js.native
      val ^ : js.Any = js.native
      
      inline def input(data: Any): AttributeValue = ^.asInstanceOf[js.Dynamic].applyDynamic("input")(data.asInstanceOf[js.Any]).asInstanceOf[AttributeValue]
      inline def input(data: Any, options: ConverterOptions): AttributeValue = (^.asInstanceOf[js.Dynamic].applyDynamic("input")(data.asInstanceOf[js.Any], options.asInstanceOf[js.Any])).asInstanceOf[AttributeValue]
    }
    
    @JSImport("aws-sdk", "DynamoDB.DocumentClient")
    @js.native
    /**
      * Creates a DynamoDB document client with a set of configuration options.
      */
    open class DocumentClient ()
      extends _root_.typings.awsSdk.clientsAllMod.DynamoDB.DocumentClient {
      def this(options: DocumentClientOptions & ClientConfiguration) = this()
    }
  }
  
  @JSImport("aws-sdk", "config")
  @js.native
  val config: Config = js.native
}
