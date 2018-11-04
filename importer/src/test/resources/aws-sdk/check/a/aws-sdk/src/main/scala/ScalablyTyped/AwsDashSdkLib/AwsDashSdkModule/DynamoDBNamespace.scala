package ScalablyTyped
package AwsDashSdkLib.AwsDashSdkModule

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@JSImport("aws-sdk", "DynamoDB")
@js.native
object DynamoDBNamespace extends js.Object {
  @js.native
  class Converter ()
    extends AwsDashSdkLib.AwsDashSdkClientsAllModule.DynamoDBNamespace.Converter
  
  @js.native
  class DocumentClient ()
    extends AwsDashSdkLib.AwsDashSdkClientsAllModule.DynamoDBNamespace.DocumentClient {
    /**
         * Creates a DynamoDB document client with a set of configuration options.
         */
    def this(options: AwsDashSdkLib.AwsDashSdkLibDynamodbDocumentUnderscoreClientModule.DocumentClientNamespace.DocumentClientOptions with AwsDashSdkLib.AwsDashSdkClientsDynamodbModule.DynamoDBNamespace.ClientConfiguration) = this()
  }
  
  @js.native
  class Types ()
    extends AwsDashSdkLib.AwsDashSdkClientsAllModule.DynamoDBNamespace.Types {
    def this(options: AwsDashSdkLib.AwsDashSdkClientsDynamodbModule.DynamoDBNamespace.TypesNamespace.ClientConfiguration) = this()
  }
  
  val TypesNamespace: this.type = js.native
  @js.native
  object Converter extends js.Object {
    def input(data: js.Any): AwsDashSdkLib.AwsDashSdkClientsDynamodbModule.DynamoDBNamespace.AttributeValue = js.native
    def input(
      data: js.Any,
      options: AwsDashSdkLib.AwsDashSdkLibDynamodbConverterModule.ConverterNamespace.ConverterOptions
    ): AwsDashSdkLib.AwsDashSdkClientsDynamodbModule.DynamoDBNamespace.AttributeValue = js.native
  }
  
  @JSName("DynamoDB")
  @js.native
  object DynamoDBNamespace extends js.Object {
    @js.native
    class Converter ()
      extends AwsDashSdkLib.AwsDashSdkClientsAllModule.DynamoDBNamespace.DynamoDBNamespace.Converter
    
    @js.native
    class DocumentClient ()
      extends AwsDashSdkLib.AwsDashSdkClientsAllModule.DynamoDBNamespace.DynamoDBNamespace.DocumentClient {
      /**
           * Creates a DynamoDB document client with a set of configuration options.
           */
      def this(options: AwsDashSdkLib.AwsDashSdkLibDynamodbDocumentUnderscoreClientModule.DocumentClientNamespace.DocumentClientOptions with AwsDashSdkLib.AwsDashSdkClientsDynamodbModule.DynamoDBNamespace.ClientConfiguration) = this()
    }
    
    val TypesNamespace: this.type = js.native
    @js.native
    object Converter extends js.Object {
      def input(data: js.Any): AwsDashSdkLib.AwsDashSdkClientsDynamodbModule.DynamoDBNamespace.AttributeValue = js.native
      def input(
        data: js.Any,
        options: AwsDashSdkLib.AwsDashSdkLibDynamodbConverterModule.ConverterNamespace.ConverterOptions
      ): AwsDashSdkLib.AwsDashSdkClientsDynamodbModule.DynamoDBNamespace.AttributeValue = js.native
    }
    
  }
  
}

