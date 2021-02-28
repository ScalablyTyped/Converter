package typings.documentation

import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

@js.native
trait Complex extends StObject {
  
  var a: (js.Function1[/* n */ Double, Unit]) | String = js.native
}
object Complex {
  
  @scala.inline
  def apply(a: (js.Function1[/* n */ Double, Unit]) | String): Complex = {
    val __obj = js.Dynamic.literal(a = a.asInstanceOf[js.Any])
    __obj.asInstanceOf[Complex]
  }
  
  @scala.inline
  implicit class ComplexMutableBuilder[Self <: Complex] (val x: Self) extends AnyVal {
    
    @scala.inline
    def setA(value: (js.Function1[/* n */ Double, Unit]) | String): Self = StObject.set(x, "a", value.asInstanceOf[js.Any])
    
    @scala.inline
    def setAFunction1(value: /* n */ Double => Unit): Self = StObject.set(x, "a", js.Any.fromFunction1(value))
  }
}
