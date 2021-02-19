package typingsJapgolly.react.mod

import japgolly.scalajs.react.CallbackTo
import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

@js.native
trait ChildContextProvider[CC] extends StObject {
  
  def getChildContext(): CC = js.native
}
object ChildContextProvider {
  
  @scala.inline
  def apply[CC](getChildContext: CallbackTo[CC]): ChildContextProvider[CC] = {
    val __obj = js.Dynamic.literal(getChildContext = getChildContext.toJsFn)
    __obj.asInstanceOf[ChildContextProvider[CC]]
  }
  
  @scala.inline
  implicit class ChildContextProviderMutableBuilder[Self <: ChildContextProvider[?], CC] (val x: Self & ChildContextProvider[CC]) extends AnyVal {
    
    @scala.inline
    def setGetChildContext(value: CallbackTo[CC]): Self = StObject.set(x, "getChildContext", value.toJsFn)
  }
}
