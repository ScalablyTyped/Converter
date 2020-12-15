package typingsSlinky.react.mod

import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

//
// Error Interfaces
// ----------------------------------------------------------------------
@js.native
trait ErrorInfo extends StObject {
  
  /**
    * Captures which component contained the exception, and its ancestors.
    */
  var componentStack: String = js.native
}
object ErrorInfo {
  
  @scala.inline
  def apply(componentStack: String): ErrorInfo = {
    val __obj = js.Dynamic.literal(componentStack = componentStack.asInstanceOf[js.Any])
    __obj.asInstanceOf[ErrorInfo]
  }
  
  @scala.inline
  implicit class ErrorInfoMutableBuilder[Self <: ErrorInfo] (val x: Self) extends AnyVal {
    
    @scala.inline
    def setComponentStack(value: String): Self = StObject.set(x, "componentStack", value.asInstanceOf[js.Any])
  }
}
