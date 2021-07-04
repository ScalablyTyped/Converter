package typings.expandTypeParameters

import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

/* import warning: transforms.RemoveMultipleInheritance#findNewParents newComments Dropped parents 
- typings.expandTypeParameters.TA because Already inherited */ @js.native
trait A
  extends StObject
     with B {
  
  var a: Double = js.native
}
object A {
  
  @scala.inline
  def apply(a: Double, b: String): A = {
    val __obj = js.Dynamic.literal(a = a.asInstanceOf[js.Any], b = b.asInstanceOf[js.Any])
    __obj.asInstanceOf[A]
  }
  
  @scala.inline
  implicit class AMutableBuilder[Self <: A] (val x: Self) extends AnyVal {
    
    @scala.inline
    def setA(value: Double): Self = StObject.set(x, "a", value.asInstanceOf[js.Any])
  }
}
