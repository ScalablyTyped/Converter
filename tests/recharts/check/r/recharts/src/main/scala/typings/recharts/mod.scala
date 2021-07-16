package typings.recharts

import typings.recharts.anon.Height
import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

object mod {
  
  @JSImport("recharts", JSImport.Namespace)
  @js.native
  val ^ : js.Any = js.native
  
  @scala.inline
  def rectWithPoints(hasX1Y1: Coordinate, hasX2Y2: Coordinate): Height = (^.asInstanceOf[js.Dynamic].applyDynamic("rectWithPoints")(hasX1Y1.asInstanceOf[js.Any], hasX2Y2.asInstanceOf[js.Any])).asInstanceOf[Height]
  
  @js.native
  trait Coordinate extends StObject {
    
    var x: Double = js.native
    
    var y: Double = js.native
  }
  object Coordinate {
    
    @scala.inline
    def apply(x: Double, y: Double): Coordinate = {
      val __obj = js.Dynamic.literal(x = x.asInstanceOf[js.Any], y = y.asInstanceOf[js.Any])
      __obj.asInstanceOf[Coordinate]
    }
    
    @scala.inline
    implicit class CoordinateMutableBuilder[Self <: Coordinate] (val x: Self) extends AnyVal {
      
      @scala.inline
      def setX(value: Double): Self = StObject.set(x, "x", value.asInstanceOf[js.Any])
      
      @scala.inline
      def setY(value: Double): Self = StObject.set(x, "y", value.asInstanceOf[js.Any])
    }
  }
}
