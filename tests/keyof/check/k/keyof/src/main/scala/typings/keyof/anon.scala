package typings.keyof

import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

object anon {
  
  /* Inlined std.Pick<keyof.A, 'c' | 'b'> */
  trait PickAcb extends StObject {
    
    var b: Double
    
    var c: Double
  }
  object PickAcb {
    
    inline def apply(b: Double, c: Double): PickAcb = {
      val __obj = js.Dynamic.literal(b = b.asInstanceOf[js.Any], c = c.asInstanceOf[js.Any])
      __obj.asInstanceOf[PickAcb]
    }
    
    extension [Self <: PickAcb](x: Self) {
      
      inline def setB(value: Double): Self = StObject.set(x, "b", value.asInstanceOf[js.Any])
      
      inline def setC(value: Double): Self = StObject.set(x, "c", value.asInstanceOf[js.Any])
    }
  }
}
