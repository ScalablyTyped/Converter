package typingsSlinky.reactBootstrap

import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

object libUtilsBootstrapUtilsMod {
  
  @JSImport("react-bootstrap/lib/utils/bootstrapUtils", JSImport.Namespace)
  @js.native
  val ^ : js.Any = js.native
  
  inline def getBsProps(props: Any): BSProps = ^.asInstanceOf[js.Dynamic].applyDynamic("getBsProps")(props.asInstanceOf[js.Any]).asInstanceOf[BSProps]
  
  trait BSProps extends StObject {
    
    var bsClass: Any
  }
  object BSProps {
    
    inline def apply(bsClass: Any): BSProps = {
      val __obj = js.Dynamic.literal(bsClass = bsClass.asInstanceOf[js.Any])
      __obj.asInstanceOf[BSProps]
    }
    
    extension [Self <: BSProps](x: Self) {
      
      inline def setBsClass(value: Any): Self = StObject.set(x, "bsClass", value.asInstanceOf[js.Any])
    }
  }
}
