package typings.phaser

import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

object anon {
  
  @js.native
  trait LowerBound extends StObject {
    
    var lowerBound: js.UndefOr[js.Array[Double]] = js.native
    
    var upperBound: js.UndefOr[js.Array[Double]] = js.native
  }
  object LowerBound {
    
    @scala.inline
    def apply(): LowerBound = {
      val __obj = js.Dynamic.literal()
      __obj.asInstanceOf[LowerBound]
    }
    
    @scala.inline
    implicit class LowerBoundMutableBuilder[Self <: LowerBound] (val x: Self) extends AnyVal {
      
      @scala.inline
      def setLowerBound(value: js.Array[Double]): Self = StObject.set(x, "lowerBound", value.asInstanceOf[js.Any])
      
      @scala.inline
      def setLowerBoundUndefined: Self = StObject.set(x, "lowerBound", js.undefined)
      
      @scala.inline
      def setLowerBoundVarargs(value: Double*): Self = StObject.set(x, "lowerBound", js.Array(value :_*))
      
      @scala.inline
      def setUpperBound(value: js.Array[Double]): Self = StObject.set(x, "upperBound", value.asInstanceOf[js.Any])
      
      @scala.inline
      def setUpperBoundUndefined: Self = StObject.set(x, "upperBound", js.undefined)
      
      @scala.inline
      def setUpperBoundVarargs(value: Double*): Self = StObject.set(x, "upperBound", js.Array(value :_*))
    }
  }
}
