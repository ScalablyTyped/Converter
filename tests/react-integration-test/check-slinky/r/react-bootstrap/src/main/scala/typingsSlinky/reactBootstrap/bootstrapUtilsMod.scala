package typingsSlinky.reactBootstrap

import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

object bootstrapUtilsMod {
  
  @JSImport("react-bootstrap/lib/utils/bootstrapUtils", "getBsProps")
  @js.native
  def getBsProps(props: js.Any): BSProps = js.native
  
  @js.native
  trait BSProps extends StObject {
    
    var bsClass: js.Any = js.native
  }
  object BSProps {
    
    @scala.inline
    def apply(bsClass: js.Any): BSProps = {
      val __obj = js.Dynamic.literal(bsClass = bsClass.asInstanceOf[js.Any])
      __obj.asInstanceOf[BSProps]
    }
    
    @scala.inline
    implicit class BSPropsMutableBuilder[Self <: BSProps] (val x: Self) extends AnyVal {
      
      @scala.inline
      def setBsClass(value: js.Any): Self = StObject.set(x, "bsClass", value.asInstanceOf[js.Any])
    }
  }
}
