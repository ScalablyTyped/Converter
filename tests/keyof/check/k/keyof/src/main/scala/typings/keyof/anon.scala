package typings.keyof

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

object anon {
  
  /* Inlined std.Pick<keyof.A, 'c' | 'b'> */
  @js.native
  trait PickAcb extends js.Object {
    
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
    implicit class PickAcbOps[Self <: PickAcb] (val x: Self) extends AnyVal {
      
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
      def setB(value: Double): Self = this.set("b", value.asInstanceOf[js.Any])
      
      @scala.inline
      def setC(value: Double): Self = this.set("c", value.asInstanceOf[js.Any])
    }
  }
}
