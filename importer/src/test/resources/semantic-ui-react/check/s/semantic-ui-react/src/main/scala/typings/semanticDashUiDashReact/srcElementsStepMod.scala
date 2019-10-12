package typings.semanticDashUiDashReact

import typings.react.reactMod.Component
import typings.react.reactMod.ComponentState
import typings.semanticDashUiDashReact.srcElementsStepStepMod.StepComponent
import typings.semanticDashUiDashReact.srcElementsStepStepMod.StepProps
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@JSImport("semantic-ui-react/src/elements/Step", JSImport.Namespace)
@js.native
object srcElementsStepMod extends js.Object {
  @js.native
  class default protected ()
    extends Component[StepProps, ComponentState, js.Any] {
    def this(props: StepProps) = this()
    def this(props: StepProps, context: js.Any) = this()
  }
  
  val default: StepComponent = js.native
}

