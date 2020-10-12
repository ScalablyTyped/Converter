package typingsJapgolly.reactBootstrap

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

object bootstrapUtilsMod {
  
  @JSImport("react-bootstrap/lib/utils/bootstrapUtils", "getBsProps")
  @js.native
  def getBsProps(props: js.Any): BSProps = js.native
  
  @js.native
  trait BSProps extends js.Object {
    
    var bsClass: js.Any = js.native
  }
  object BSProps {
    
    @scala.inline
    def apply(bsClass: js.Any): BSProps = {
      val __obj = js.Dynamic.literal(bsClass = bsClass.asInstanceOf[js.Any])
      __obj.asInstanceOf[BSProps]
    }
    
    @scala.inline
    implicit class BSPropsOps[Self <: BSProps] (val x: Self) extends AnyVal {
      
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
      def setBsClass(value: js.Any): Self = this.set("bsClass", value.asInstanceOf[js.Any])
    }
  }
}
