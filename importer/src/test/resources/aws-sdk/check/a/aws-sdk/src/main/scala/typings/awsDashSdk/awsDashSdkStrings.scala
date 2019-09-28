package typings.awsDashSdk

import typings.awsDashSdk.libDynamodbDocumentUnderscoreClientMod.DocumentClient._AttributeAction
import scala.scalajs.js
import scala.scalajs.js.`|`

object awsDashSdkStrings {
  @js.native
  sealed trait ADD extends _AttributeAction
  
  @js.native
  sealed trait DELETE extends _AttributeAction
  
  @js.native
  sealed trait PUT extends _AttributeAction
  
  @js.native
  sealed trait latest extends js.Object
  
  @inline
  def ADD: ADD = "ADD".asInstanceOf[ADD]
  @inline
  def DELETE: DELETE = "DELETE".asInstanceOf[DELETE]
  @inline
  def PUT: PUT = "PUT".asInstanceOf[PUT]
  @inline
  def latest: latest = "latest".asInstanceOf[latest]
}

