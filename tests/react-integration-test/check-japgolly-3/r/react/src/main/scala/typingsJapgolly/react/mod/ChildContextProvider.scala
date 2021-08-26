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
  
  extension [Self <: ChildContextProvider[?], CC](x: Self & ChildContextProvider[CC]) {
    
    inline def setGetChildContext(value: CallbackTo[CC]): Self = StObject.set(x, "getChildContext", value.toJsFn)
  }
}
