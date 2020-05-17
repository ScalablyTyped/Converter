package typings.awsSdk.documentClientMod.DocumentClient

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

/* Rewritten from type alias, can be one of: 
  - typings.awsSdk.awsSdkStrings.ADD
  - typings.awsSdk.awsSdkStrings.PUT
  - typings.awsSdk.awsSdkStrings.DELETE
  - java.lang.String
*/
trait AttributeAction extends js.Object

object AttributeAction {
  @scala.inline
  def ADD: typings.awsSdk.awsSdkStrings.ADD = "ADD".asInstanceOf[typings.awsSdk.awsSdkStrings.ADD]
  @scala.inline
  def PUT: typings.awsSdk.awsSdkStrings.PUT = "PUT".asInstanceOf[typings.awsSdk.awsSdkStrings.PUT]
  @scala.inline
  def DELETE: typings.awsSdk.awsSdkStrings.DELETE = "DELETE".asInstanceOf[typings.awsSdk.awsSdkStrings.DELETE]
  @scala.inline
  implicit def apply(value: String): AttributeAction = value.asInstanceOf[AttributeAction]
}

