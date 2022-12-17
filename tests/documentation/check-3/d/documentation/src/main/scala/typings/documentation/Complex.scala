package typings.documentation

import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

trait Complex extends StObject {
  
  var a: (js.Function1[/* n */ Double, Unit]) | String
}
object Complex {
  
  inline def apply(a: (js.Function1[/* n */ Double, Unit]) | String): Complex = {
    val __obj = js.Dynamic.literal(a = a.asInstanceOf[js.Any])
    __obj.asInstanceOf[Complex]
  }
  
  @scala.inline
  implicit open class MutableBuilder[Self <: Complex] (val x: Self) extends AnyVal {
    
    inline def setA(value: (js.Function1[/* n */ Double, Unit]) | String): Self = StObject.set(x, "a", value.asInstanceOf[js.Any])
    
    inline def setAFunction1(value: /* n */ Double => Unit): Self = StObject.set(x, "a", js.Any.fromFunction1(value))
  }
}
