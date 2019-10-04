package typings.reactDashBootstrap

import typings.reactDashBootstrap.libButtonGroupMod.^
import typings.reactDashBootstrap.libUtilsBootstrapUtilsMod.BSProps
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@JSImport("react-bootstrap/lib", JSImport.Namespace)
@js.native
object libMod extends js.Object {
  @js.native
  class ButtonGroup () extends ^
  
  @js.native
  class ToggleButtonGroup ()
    extends typings.reactDashBootstrap.libToggleButtonGroupMod.^
  
  @js.native
  object utils extends js.Object {
    def createChainedFunction(funcs: js.Function*): js.Function = js.native
    @js.native
    object bootstrapUtils extends js.Object {
      def getBsProps(props: js.Any): BSProps = js.native
    }
    
  }
  
}

