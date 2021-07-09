package typings.keyof

import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

@js.native
trait A extends StObject {
  
  var a: Double = js.native
  
  var b: Double = js.native
  
  var c: Double = js.native
}
object A {
  
  @scala.inline
  def apply(a: Double, b: Double, c: Double): A = {
    val __obj = js.Dynamic.literal(a = a.asInstanceOf[js.Any], b = b.asInstanceOf[js.Any], c = c.asInstanceOf[js.Any])
    __obj.asInstanceOf[A]
  }
  
  @scala.inline
  implicit class AMutableBuilder[Self <: A] (val x: Self) extends AnyVal {
    
    @scala.inline
    def setA(value: Double): Self = StObject.set(x, "a", value.asInstanceOf[js.Any])
    
    @scala.inline
    def setB(value: Double): Self = StObject.set(x, "b", value.asInstanceOf[js.Any])
    
    @scala.inline
    def setC(value: Double): Self = StObject.set(x, "c", value.asInstanceOf[js.Any])
  }
}
