package typings.semanticUiReact

import typings.react.reactMod.Component
import typings.react.reactMod.ComponentState
import typings.semanticUiReact.modulesTransitionTransitionMod.TransitionComponent
import typings.semanticUiReact.modulesTransitionTransitionMod.TransitionProps
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@JSImport("semantic-ui-react/src/modules/Transition", JSImport.Namespace)
@js.native
object modulesTransitionMod extends js.Object {
  @js.native
  class default protected ()
    extends Component[TransitionProps, ComponentState, js.Any] {
    def this(props: TransitionProps) = this()
    def this(props: TransitionProps, context: js.Any) = this()
  }
  
  val default: TransitionComponent = js.native
}

