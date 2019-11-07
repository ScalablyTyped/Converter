package typings.awsSdk

import typings.awsSdk.clientsDynamodbMod.AttributeValue
import typings.awsSdk.libDynamodbConverterMod.Converter.ConverterOptions
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@JSImport("aws-sdk/lib/dynamodb/converter", JSImport.Namespace)
@js.native
object libDynamodbConverterMod extends js.Object {
  @js.native
  class Converter () extends js.Object
  
  /* static members */
  @js.native
  object Converter extends js.Object {
    def input(data: js.Any): AttributeValue = js.native
    def input(data: js.Any, options: ConverterOptions): AttributeValue = js.native
    type ConverterOptions = typings.awsSdk.libDynamodbDocumentClientMod.DocumentClient.ConverterOptions
  }
  
}

