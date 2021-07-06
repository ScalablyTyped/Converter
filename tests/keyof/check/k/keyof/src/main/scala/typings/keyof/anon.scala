package typings.keyof

import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

object anon {
  
  /* Inlined std.Pick<keyof.A, 'c' | 'b'> */
  @js.native
  trait PickAcb extends StObject {
    
    var b: Double = js.native
    
    var c: Double = js.native
  }
  object PickAcb {
    
    @scala.inline
    def apply(b: Double, c: Double): PickAcb = {
      val __obj = js.Dynamic.literal(b = b.asInstanceOf[js.Any], c = c.asInstanceOf[js.Any])
      __obj.asInstanceOf[PickAcb]
    }
    
    @scala.inline
    implicit class PickAcbMutableBuilder[Self <: PickAcb] (val x: Self) extends AnyVal {
      
      @scala.inline
      def setB(value: Double): Self = StObject.set(x, "b", value.asInstanceOf[js.Any])
      
      @scala.inline
      def setC(value: Double): Self = StObject.set(x, "c", value.asInstanceOf[js.Any])
    }
  }
}
