package typings.recharts

import typings.recharts.anon.Height
import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

object mod {
  
  @JSImport("recharts", JSImport.Namespace)
  @js.native
  val ^ : js.Any = js.native
  
  inline def rectWithPoints(param0: Coordinate, param1: Coordinate): Height = (^.asInstanceOf[js.Dynamic].applyDynamic("rectWithPoints")(param0.asInstanceOf[js.Any], param1.asInstanceOf[js.Any])).asInstanceOf[Height]
  
  trait Coordinate extends StObject {
    
    var x: Double
    
    var y: Double
  }
  object Coordinate {
    
    inline def apply(x: Double, y: Double): Coordinate = {
      val __obj = js.Dynamic.literal(x = x.asInstanceOf[js.Any], y = y.asInstanceOf[js.Any])
      __obj.asInstanceOf[Coordinate]
    }
    
    @scala.inline
    implicit open class MutableBuilder[Self <: Coordinate] (val x: Self) extends AnyVal {
      
      inline def setX(value: Double): Self = StObject.set(x, "x", value.asInstanceOf[js.Any])
      
      inline def setY(value: Double): Self = StObject.set(x, "y", value.asInstanceOf[js.Any])
    }
  }
}
