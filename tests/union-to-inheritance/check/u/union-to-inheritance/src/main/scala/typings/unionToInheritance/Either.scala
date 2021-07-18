package typings.unionToInheritance

import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

trait Either[L, R]
  extends StObject
     with Legal3[js.Any, L, R]
     with _Test[js.Any, L, R]
     with _Test2[R, L] {
  
  var value: R
}
object Either {
  
  inline def apply[L, R](value: R): Either[L, R] = {
    val __obj = js.Dynamic.literal(value = value.asInstanceOf[js.Any])
    __obj.asInstanceOf[Either[L, R]]
  }
  
  extension [Self <: Either[?, ?], L, R](x: Self & (Either[L, R])) {
    
    inline def setValue(value: R): Self = StObject.set(x, "value", value.asInstanceOf[js.Any])
  }
}
