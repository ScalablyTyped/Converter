package typings.semanticDashUiDashReact

import typings.react.reactMod.Component
import typings.react.reactMod.ComponentState
import typings.semanticDashUiDashReact.srcModulesTransitionTransitionMod.TransitionComponent
import typings.semanticDashUiDashReact.srcModulesTransitionTransitionMod.TransitionProps
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@JSImport("semantic-ui-react/src/modules/Transition", JSImport.Namespace)
@js.native
object srcModulesTransitionMod extends js.Object {
  @js.native
  class default protected ()
    extends Component[TransitionProps, ComponentState, js.Any] {
    def this(props: TransitionProps) = this()
    def this(props: TransitionProps, context: js.Any) = this()
  }
  
  val default: TransitionComponent = js.native
}

