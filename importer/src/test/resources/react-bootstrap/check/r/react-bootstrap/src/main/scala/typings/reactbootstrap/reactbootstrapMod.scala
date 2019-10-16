package typings.reactBootstrap

import typings.react.reactMod.Component
import typings.reactBootstrap.libButtonGroupMod.ButtonGroupProps
import typings.reactBootstrap.libToggleButtonGroupMod.ToggleButtonGroupProps
import typings.reactBootstrap.libUtilsBootstrapUtilsMod.BSProps
import typings.std.Pick
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@JSImport("react-bootstrap", JSImport.Namespace)
@js.native
object reactBootstrapMod extends js.Object {
  @js.native
  class ButtonGroup ()
    extends Component[ButtonGroupProps, js.Object]
  
  /* Rewritten from type alias, can be one of: 
    - typings.reactBootstrap.reactBootstrapStrings.xs
    - typings.reactBootstrap.reactBootstrapStrings.xsmall
    - typings.reactBootstrap.reactBootstrapStrings.sm
    - typings.reactBootstrap.reactBootstrapStrings.small
    - typings.reactBootstrap.reactBootstrapStrings.medium
    - typings.reactBootstrap.reactBootstrapStrings.lg
    - typings.reactBootstrap.reactBootstrapStrings.large
  */
  trait Sizes extends js.Object
  
  @js.native
  class ToggleButtonGroup ()
    extends Component[ToggleButtonGroupProps, js.Object]
  
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

