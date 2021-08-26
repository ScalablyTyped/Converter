package typings.awsSdk

import typings.awsSdk.documentClientMod.DocumentClient._AttributeAction
import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

object awsSdkStrings {
  
  @js.native
  sealed trait ADD
    extends StObject
       with _AttributeAction
  inline def ADD: ADD = "ADD".asInstanceOf[ADD]
  
  @js.native
  sealed trait DELETE
    extends StObject
       with _AttributeAction
  inline def DELETE: DELETE = "DELETE".asInstanceOf[DELETE]
  
  @js.native
  sealed trait PUT
    extends StObject
       with _AttributeAction
  inline def PUT: PUT = "PUT".asInstanceOf[PUT]
  
  @js.native
  sealed trait latest extends StObject
  inline def latest: latest = "latest".asInstanceOf[latest]
}
