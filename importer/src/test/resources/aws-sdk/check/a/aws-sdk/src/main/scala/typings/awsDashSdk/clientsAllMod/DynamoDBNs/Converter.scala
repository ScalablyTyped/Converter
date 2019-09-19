package typings.awsDashSdk.clientsAllMod.DynamoDBNs

import typings.awsDashSdk.clientsDynamodbMod.AttributeValue
import typings.awsDashSdk.libDynamodbConverterMod.ConverterNs.ConverterOptions
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@JSImport("aws-sdk/clients/all", "DynamoDB.Converter")
@js.native
class Converter ()
  extends typings.awsDashSdk.clientsDynamodbMod.Converter

/* static members */
@JSImport("aws-sdk/clients/all", "DynamoDB.Converter")
@js.native
object Converter extends js.Object {
  def input(data: js.Any): AttributeValue = js.native
  def input(data: js.Any, options: ConverterOptions): AttributeValue = js.native
}

