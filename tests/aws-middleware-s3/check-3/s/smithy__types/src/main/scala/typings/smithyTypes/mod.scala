package typings.smithyTypes

import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

object mod {
  
  trait ClientProtocol extends StObject {
    
    def serializeRequest(): js.Promise[Any]
  }
  object ClientProtocol {
    
    inline def apply(serializeRequest: () => js.Promise[Any]): ClientProtocol = {
      val __obj = js.Dynamic.literal(serializeRequest = js.Any.fromFunction0(serializeRequest))
      __obj.asInstanceOf[ClientProtocol]
    }
    
    @scala.inline
    implicit open class MutableBuilder[Self <: ClientProtocol] (val x: Self) extends AnyVal {
      
      inline def setSerializeRequest(value: () => js.Promise[Any]): Self = StObject.set(x, "serializeRequest", js.Any.fromFunction0(value))
    }
  }
}
