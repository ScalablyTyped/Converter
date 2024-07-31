package typings.unionToInheritance

import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

trait Either[L, R] extends StObject {
  
  var value: R
}
object Either {
  
  inline def apply[L, R](value: R): Either[L, R] = {
    val __obj = js.Dynamic.literal(value = value.asInstanceOf[js.Any])
    __obj.asInstanceOf[Either[L, R]]
  }
  
  @scala.inline
  implicit open class MutableBuilder[Self <: Either[?, ?], L, R] (val x: Self & (Either[L, R])) extends AnyVal {
    
    inline def setValue(value: R): Self = StObject.set(x, "value", value.asInstanceOf[js.Any])
  }
}
