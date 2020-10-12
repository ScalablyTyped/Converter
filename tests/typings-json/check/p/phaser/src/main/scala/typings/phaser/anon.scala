package typings.phaser

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

object anon {
  
  @js.native
  trait LowerBound extends js.Object {
    
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
    implicit class LowerBoundOps[Self <: LowerBound] (val x: Self) extends AnyVal {
      
      @scala.inline
      def duplicate: Self = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x)).asInstanceOf[Self]
      
      @scala.inline
      def combineWith[Other <: js.Any](other: Other): Self with Other = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x, other.asInstanceOf[js.Any])).asInstanceOf[Self with Other]
      
      @scala.inline
      def set(key: String, value: js.Any): Self = {
        x.asInstanceOf[js.Dynamic].updateDynamic(key)(value)
        x
      }
      
      @scala.inline
      def setLowerBoundVarargs(value: Double*): Self = this.set("lowerBound", js.Array(value :_*))
      
      @scala.inline
      def setLowerBound(value: js.Array[Double]): Self = this.set("lowerBound", value.asInstanceOf[js.Any])
      
      @scala.inline
      def deleteLowerBound: Self = this.set("lowerBound", js.undefined)
      
      @scala.inline
      def setUpperBoundVarargs(value: Double*): Self = this.set("upperBound", js.Array(value :_*))
      
      @scala.inline
      def setUpperBound(value: js.Array[Double]): Self = this.set("upperBound", value.asInstanceOf[js.Any])
      
      @scala.inline
      def deleteUpperBound: Self = this.set("upperBound", js.undefined)
    }
  }
}
