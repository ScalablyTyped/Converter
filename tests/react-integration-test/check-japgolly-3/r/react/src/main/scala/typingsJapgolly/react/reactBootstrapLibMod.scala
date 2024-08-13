package typingsJapgolly.react

import typingsJapgolly.react.reactBootstrapLibButtonGroupMod.^
import typingsJapgolly.react.reactBootstrapLibUtilsBootstrapUtilsMod.BSProps
import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

object reactBootstrapLibMod {
  
  @JSImport("react/react-bootstrap/lib", "ButtonGroup")
  @js.native
  open class ButtonGroup () extends ^
  
  @JSImport("react/react-bootstrap/lib", "ToggleButtonGroup")
  @js.native
  open class ToggleButtonGroup ()
    extends typingsJapgolly.react.reactBootstrapLibToggleButtonGroupMod.^
  
  object utils {
    
    @JSImport("react/react-bootstrap/lib", "utils")
    @js.native
    val ^ : js.Any = js.native
    
    object bootstrapUtils {
      
      @JSImport("react/react-bootstrap/lib", "utils.bootstrapUtils")
      @js.native
      val ^ : js.Any = js.native
      
      inline def getBsProps(props: Any): BSProps = ^.asInstanceOf[js.Dynamic].applyDynamic("getBsProps")(props.asInstanceOf[js.Any]).asInstanceOf[BSProps]
    }
    
    inline def createChainedFunction(funcs: js.Function*): js.Function = ^.asInstanceOf[js.Dynamic].applyDynamic("createChainedFunction")(funcs.asInstanceOf[Seq[js.Any]]*).asInstanceOf[js.Function]
  }
}
