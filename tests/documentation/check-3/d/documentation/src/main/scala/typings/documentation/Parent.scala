package typings.documentation

import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

trait Parent[T] extends StObject {
  
  var t: T
}
object Parent {
  
  inline def apply[T](t: T): Parent[T] = {
    val __obj = js.Dynamic.literal(t = t.asInstanceOf[js.Any])
    __obj.asInstanceOf[Parent[T]]
  }
  
  extension [Self <: Parent[?], T](x: Self & Parent[T]) {
    
    inline def setT(value: T): Self = StObject.set(x, "t", value.asInstanceOf[js.Any])
  }
}
