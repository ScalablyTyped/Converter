package typings.awsSdk.mod.clients.dynamodb

import typings.awsSdk.mod.lib.dynamodb.converter.Converter.ConverterOptions
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@JSImport("aws-sdk/clients/dynamodb", "Converter")
@js.native
class Converter ()
  extends typings.awsSdk.mod.lib.dynamodb.converter.Converter

/* static members */
@JSImport("aws-sdk/clients/dynamodb", "Converter")
@js.native
object Converter extends js.Object {
  def input(data: js.Any): AttributeValue = js.native
  def input(data: js.Any, options: ConverterOptions): AttributeValue = js.native
}

