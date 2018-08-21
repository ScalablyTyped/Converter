package ScalablyTyped
package AwsSdkLib
package AwsSdkModule

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@JSImport("aws-sdk", "DynamoDB")
@js.native
class DynamoDB protected () extends AwsSdkLib.LibDynamodbDocumentClientModule.DocumentClient with AwsSdkLib.ClientsDynamodbModule.DynamoDB {
  def this(options: AwsSdkLib.ClientsDynamodbModule.TypesNamespace.ClientConfiguration = ???) = this()
/**
     * Creates a DynamoDB document client with a set of configuration options.
     */
  def this(options: AwsSdkLib.LibDynamodbDocumentClientModule.DocumentClientNamespace.DocumentClientOptions with AwsSdkLib.ClientsDynamodbModule.TypesNamespace.ClientConfiguration = ???) = this()
}

@JSImport("aws-sdk", "DynamoDB")
@js.native
object DynamoDB extends js.Object {
  def input(data: js.Any, options: js.UndefOr[AwsSdkLib.LibDynamodbConverterModule.ConverterNamespace.ConverterOptions]): AwsSdkLib.ClientsDynamodbModule.TypesNamespace.AttributeValue = js.native
}

