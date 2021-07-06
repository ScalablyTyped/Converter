package typings.expandTypeParameters

import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

@js.native
trait B
  extends StObject
     with TA {
  
  var b: String = js.native
}
object B {
  
  @scala.inline
  def apply(b: String): B = {
    val __obj = js.Dynamic.literal(b = b.asInstanceOf[js.Any])
    __obj.asInstanceOf[B]
  }
  
  @scala.inline
  implicit class BMutableBuilder[Self <: B] (val x: Self) extends AnyVal {
    
    @scala.inline
    def setB(value: String): Self = StObject.set(x, "b", value.asInstanceOf[js.Any])
  }
}
