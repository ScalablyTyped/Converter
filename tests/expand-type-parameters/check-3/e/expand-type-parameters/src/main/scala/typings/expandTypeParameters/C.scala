package typings.expandTypeParameters

import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

trait C extends StObject {
  
  var c: js.UndefOr[Double] = js.undefined
}
object C {
  
  inline def apply(): C = {
    val __obj = js.Dynamic.literal()
    __obj.asInstanceOf[C]
  }
  
  @scala.inline
  implicit open class MutableBuilder[Self <: C] (val x: Self) extends AnyVal {
    
    inline def setC(value: Double): Self = StObject.set(x, "c", value.asInstanceOf[js.Any])
    
    inline def setCUndefined: Self = StObject.set(x, "c", js.undefined)
  }
}
