package typingsJapgolly.reactBootstrap

import typingsJapgolly.reactBootstrap.bootstrapUtilsMod.BSProps
import typingsJapgolly.reactBootstrap.buttonGroupMod.^
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

@JSImport("react-bootstrap/lib", JSImport.Namespace)
@js.native
object libMod extends js.Object {
  
  @js.native
  class ButtonGroup () extends ^
  
  @js.native
  class ToggleButtonGroup ()
    extends typingsJapgolly.reactBootstrap.toggleButtonGroupMod.^
  
  @js.native
  object utils extends js.Object {
    
    def createChainedFunction(funcs: js.Function*): js.Function = js.native
    
    @js.native
    object bootstrapUtils extends js.Object {
      
      def getBsProps(props: js.Any): BSProps = js.native
    }
  }
}
