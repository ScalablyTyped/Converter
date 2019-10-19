package typings.awsSdk

import typings.awsSdk.mod.lib.dynamodb.documentClient.DocumentClient._AttributeAction
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

object awsSdkStrings {
  @js.native
  sealed trait ADD extends _AttributeAction
  
  @js.native
  sealed trait DELETE extends _AttributeAction
  
  @js.native
  sealed trait PUT extends _AttributeAction
  
  @js.native
  sealed trait latest extends js.Object
  
  @scala.inline
  def ADD: ADD = "ADD".asInstanceOf[ADD]
  @scala.inline
  def DELETE: DELETE = "DELETE".asInstanceOf[DELETE]
  @scala.inline
  def PUT: PUT = "PUT".asInstanceOf[PUT]
  @scala.inline
  def latest: latest = "latest".asInstanceOf[latest]
}

