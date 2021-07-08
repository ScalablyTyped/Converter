package typings.phaser

import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

object anon {
  
  trait LowerBound extends StObject {
    
    var lowerBound: js.UndefOr[js.Array[Double]] = js.undefined
    
    var upperBound: js.UndefOr[js.Array[Double]] = js.undefined
  }
  object LowerBound {
    
    inline def apply(): LowerBound = {
      val __obj = js.Dynamic.literal()
      __obj.asInstanceOf[LowerBound]
    }
    
    extension [Self <: LowerBound](x: Self) {
      
      inline def setLowerBound(value: js.Array[Double]): Self = StObject.set(x, "lowerBound", value.asInstanceOf[js.Any])
      
      inline def setLowerBoundUndefined: Self = StObject.set(x, "lowerBound", js.undefined)
      
      inline def setLowerBoundVarargs(value: Double*): Self = StObject.set(x, "lowerBound", js.Array(value :_*))
      
      inline def setUpperBound(value: js.Array[Double]): Self = StObject.set(x, "upperBound", value.asInstanceOf[js.Any])
      
      inline def setUpperBoundUndefined: Self = StObject.set(x, "upperBound", js.undefined)
      
      inline def setUpperBoundVarargs(value: Double*): Self = StObject.set(x, "upperBound", js.Array(value :_*))
    }
  }
}
