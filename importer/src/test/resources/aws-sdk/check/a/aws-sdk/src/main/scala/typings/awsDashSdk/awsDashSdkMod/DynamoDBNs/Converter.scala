package typings.awsDashSdk.awsDashSdkMod.DynamoDBNs

import typings.awsDashSdk.clientsDynamodbMod.AttributeValue
import typings.awsDashSdk.libDynamodbConverterMod.ConverterNs.ConverterOptions
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@JSImport("aws-sdk", "DynamoDB.Converter")
@js.native
class Converter ()
  extends typings.awsDashSdk.clientsAllMod.DynamoDBNs.Converter

/* static members */
@JSImport("aws-sdk", "DynamoDB.Converter")
@js.native
object Converter extends js.Object {
  def input(data: js.Any): AttributeValue = js.native
  def input(data: js.Any, options: ConverterOptions): AttributeValue = js.native
}

