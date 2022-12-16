package typingsJapgolly.react.mod

import japgolly.scalajs.react.CallbackTo
import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

trait ChildContextProvider[CC] extends StObject {
  
  def getChildContext(): CC
}
object ChildContextProvider {
  
  inline def apply[CC](getChildContext: CallbackTo[CC]): ChildContextProvider[CC] = {
    val __obj = js.Dynamic.literal(getChildContext = getChildContext.toJsFn)
    __obj.asInstanceOf[ChildContextProvider[CC]]
  }
  
  @scala.inline
  implicit open class MutableBuilder[Self <: ChildContextProvider[?], CC] (val x: Self & ChildContextProvider[CC]) extends AnyVal {
    
    inline def setGetChildContext(value: CallbackTo[CC]): Self = StObject.set(x, "getChildContext", value.toJsFn)
  }
}
