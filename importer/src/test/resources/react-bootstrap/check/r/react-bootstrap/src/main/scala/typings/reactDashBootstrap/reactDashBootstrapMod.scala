package typings.reactDashBootstrap

import typings.reactDashBootstrap.libUtilsBootstrapUtilsMod.BSProps
import typings.std.Pick
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@JSImport("react-bootstrap", JSImport.Namespace)
@js.native
object reactDashBootstrapMod extends js.Object {
  @js.native
  class ButtonGroup ()
    extends typings.reactDashBootstrap.libMod.ButtonGroup
  
  /* Rewritten from type alias, can be one of: 
    - typings.reactDashBootstrap.reactDashBootstrapStrings.xs
    - typings.reactDashBootstrap.reactDashBootstrapStrings.xsmall
    - typings.reactDashBootstrap.reactDashBootstrapStrings.sm
    - typings.reactDashBootstrap.reactDashBootstrapStrings.small
    - typings.reactDashBootstrap.reactDashBootstrapStrings.medium
    - typings.reactDashBootstrap.reactDashBootstrapStrings.lg
    - typings.reactDashBootstrap.reactDashBootstrapStrings.large
  */
  trait Sizes extends js.Object
  
  @js.native
  class ToggleButtonGroup ()
    extends typings.reactDashBootstrap.libMod.ToggleButtonGroup
  
  @js.native
  object utils extends js.Object {
    def createChainedFunction(funcs: js.Function*): js.Function = js.native
    @js.native
    object bootstrapUtils extends js.Object {
      def getBsProps(props: js.Any): BSProps = js.native
    }
    
  }
  
  type Omit[T, K /* <: String */] = Pick[
    T, 
    /* import warning: ImportType.apply Failed type conversion: {[ P in keyof T ]: P} & {[ P in K ]: never} & {[x: string] : never, [x: number] : never}[keyof T] */ js.Any
  ]
}

