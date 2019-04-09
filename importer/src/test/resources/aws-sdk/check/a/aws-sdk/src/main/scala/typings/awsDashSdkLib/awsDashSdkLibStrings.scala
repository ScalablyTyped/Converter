package typings
package awsDashSdkLib

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

object awsDashSdkLibStrings {
  @js.native
  sealed trait ADD
    extends awsDashSdkLib.libDynamodbDocumentUnderscoreClientMod.DocumentClientNs._AttributeAction
  
  @js.native
  sealed trait DELETE
    extends awsDashSdkLib.libDynamodbDocumentUnderscoreClientMod.DocumentClientNs._AttributeAction
  
  @js.native
  sealed trait PUT
    extends awsDashSdkLib.libDynamodbDocumentUnderscoreClientMod.DocumentClientNs._AttributeAction
  
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

