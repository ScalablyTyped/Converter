package typings.expandTypeParameters

import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

/* import warning: transforms.RemoveMultipleInheritance#findNewParents newComments Dropped parents 
- typings.expandTypeParameters.TA because Already inherited */ trait A
  extends StObject
     with B {
  
  var a: Double
}
object A {
  
  inline def apply(a: Double, b: String): A = {
    val __obj = js.Dynamic.literal(a = a.asInstanceOf[js.Any], b = b.asInstanceOf[js.Any])
    __obj.asInstanceOf[A]
  }
  
  @scala.inline
  implicit open class MutableBuilder[Self <: A] (val x: Self) extends AnyVal {
    
    inline def setA(value: Double): Self = StObject.set(x, "a", value.asInstanceOf[js.Any])
  }
}
