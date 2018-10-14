package ScalablyTyped
package AwsDashSdkLib.AwsDashSdkClientsDynamodbModule

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@JSImport("aws-sdk/clients/dynamodb", "DynamoDB")
@js.native
object DynamoDBNamespace extends js.Object {
  @js.native
  class Converter () extends js.Object
  
  @js.native
  class DocumentClient () extends js.Object {
    /**
         * Creates a DynamoDB document client with a set of configuration options.
         */
    def this(options: AwsDashSdkLib.AwsDashSdkLibDynamodbDocumentUnderscoreClientModule.DocumentClientNamespace.DocumentClientOptions with ClientConfiguration) = this()
  }
  
  val TypesNamespace: this.type = js.native
  @js.native
  object Converter extends js.Object {
    def input(data: js.Any): AwsDashSdkLib.AwsDashSdkClientsDynamodbModule.DynamoDBNamespace.AttributeValue = js.native
    def input(
      data: js.Any,
      options: AwsDashSdkLib.AwsDashSdkClientsDynamodbModule.DynamoDBNamespace.DocumentClientNamespace.ConverterOptions
    ): AwsDashSdkLib.AwsDashSdkClientsDynamodbModule.DynamoDBNamespace.AttributeValue = js.native
  }
  
  @JSName("Converter")
  @js.native
  object ConverterNamespace extends js.Object {
    type ConverterOptions = AwsDashSdkLib.AwsDashSdkClientsDynamodbModule.DynamoDBNamespace.DocumentClientNamespace.ConverterOptions
  }
  
  @JSName("DocumentClient")
  @js.native
  object DocumentClientNamespace extends js.Object {
    
    trait ConverterOptions extends js.Object {
      /**
               * An optional flag indicating that the document client should cast
               * empty strings, buffers, and sets to NULL shapes
               */
      var convertEmptyValues: js.UndefOr[scala.Boolean] = js.undefined
      /**
               * Whether to return numbers as a NumberValue object instead of
               * converting them to native JavaScript numbers. This allows for the
               * safe round-trip transport of numbers of arbitrary size.
               */
      var wrapNumbers: js.UndefOr[scala.Boolean] = js.undefined
    }
    
    
    trait DocumentClientOptions
      extends AwsDashSdkLib.AwsDashSdkLibDynamodbDocumentUnderscoreClientModule.DocumentClientNamespace.ConverterOptions {
      /**
               * An optional map of parameters to bind to every request sent by this service object.
               */
      var params: js.UndefOr[ScalablyTyped.runtime.StringDictionary[js.Any]] = js.undefined
      /**
               * An optional pre-configured instance of the AWS.DynamoDB service object to use for requests. The object may bound parameters used by the document client.
               */
      var service: js.UndefOr[AwsDashSdkLib.AwsDashSdkClientsDynamodbModule.namespaced] = js.undefined
    }
    
    type AttributeAction = AwsDashSdkLib.AwsDashSdkLibStrings.ADD | AwsDashSdkLib.AwsDashSdkLibStrings.PUT | AwsDashSdkLib.AwsDashSdkLibStrings.DELETE | java.lang.String
  }
  
  type AttributeValue = js.Any
  type ClientConfiguration = js.Any
  type Types = AwsDashSdkLib.AwsDashSdkLibServicesDynamodbModule.DynamoDBCustomizations
  type apiVersion = AwsDashSdkLib.AwsDashSdkLibStrings.latest
}

