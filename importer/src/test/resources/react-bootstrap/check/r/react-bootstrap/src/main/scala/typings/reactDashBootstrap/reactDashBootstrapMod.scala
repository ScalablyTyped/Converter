package typings.reactDashBootstrap

import scala.scalajs.js.annotation.JSImport
import scala.scalajs.js.annotation.JSImport.Namespace
import scala.scalajs.js.annotation.ScalaJSDefined
import typings.react.reactMod.Component
import typings.reactDashBootstrap.libButtonGroupMod.ButtonGroupProps
import typings.reactDashBootstrap.libToggleButtonGroupMod.ToggleButtonGroupProps
import typings.reactDashBootstrap.libUtilsBootstrapUtilsMod.BSProps
import typings.std.Pick
import scala.scalajs.js
import scala.scalajs.js.`|`

@JSImport("react-bootstrap", Namespace)
@js.native
object reactDashBootstrapMod extends js.Object {
  @js.native
  class ButtonGroup () extends Component[ButtonGroupProps, js.Object]
  
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
  class ToggleButtonGroup () extends Component[ToggleButtonGroupProps, js.Object]
  
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

