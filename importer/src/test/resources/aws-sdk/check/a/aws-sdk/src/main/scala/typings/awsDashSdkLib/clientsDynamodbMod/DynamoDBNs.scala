package typings
package awsDashSdkLib.clientsDynamodbMod

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@JSImport("aws-sdk/clients/dynamodb", "DynamoDB")
@js.native
object DynamoDBNs extends js.Object {
  @js.native
  class Converter () extends js.Object
  
  @js.native
  class DocumentClient () extends js.Object {
    /**
         * Creates a DynamoDB document client with a set of configuration options.
         */
    def this(options: awsDashSdkLib.libDynamodbDocumentUnderscoreClientMod.DocumentClientNs.DocumentClientOptions with ClientConfiguration) = this()
  }
  
  val TypesNs: this.type = js.native
  @js.native
  object Converter extends js.Object {
    def input(data: js.Any): awsDashSdkLib.clientsDynamodbMod.DynamoDBNs.AttributeValue = js.native
    def input(data: js.Any, options: awsDashSdkLib.libDynamodbConverterMod.ConverterNs.ConverterOptions): awsDashSdkLib.clientsDynamodbMod.DynamoDBNs.AttributeValue = js.native
  }
  
  @JSName("Converter")
  @js.native
  object ConverterNs extends js.Object {
    type ConverterOptions = awsDashSdkLib.clientsDynamodbMod.DynamoDBNs.DocumentClientNs.ConverterOptions
  }
  
  @JSName("DocumentClient")
  @js.native
  object DocumentClientNs extends js.Object {
    
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
      extends awsDashSdkLib.libDynamodbDocumentUnderscoreClientMod.DocumentClientNs.ConverterOptions {
      /**
               * An optional map of parameters to bind to every request sent by this service object.
               */
      var params: js.UndefOr[ScalablyTyped.runtime.StringDictionary[js.Any]] = js.undefined
      /**
               * An optional pre-configured instance of the AWS.DynamoDB service object to use for requests. The object may bound parameters used by the document client.
               */
      var service: js.UndefOr[awsDashSdkLib.clientsDynamodbMod.namespaced] = js.undefined
    }
    
    type AttributeAction = awsDashSdkLib.awsDashSdkLibStrings.ADD | awsDashSdkLib.awsDashSdkLibStrings.PUT | awsDashSdkLib.awsDashSdkLibStrings.DELETE | java.lang.String
  }
  
  type AttributeValue = js.Any
  type ClientConfiguration = js.Any
  type Types = awsDashSdkLib.libServicesDynamodbMod.DynamoDBCustomizations
  type apiVersion = awsDashSdkLib.awsDashSdkLibStrings.latest
}

