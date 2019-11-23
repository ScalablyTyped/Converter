package typings.semanticDashUiDashReact

import typings.react.reactMod.Component
import typings.react.reactMod.ComponentState
import typings.semanticDashUiDashReact.srcModulesModalModalMod.ModalComponent
import typings.semanticDashUiDashReact.srcModulesModalModalMod.ModalProps
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@JSImport("semantic-ui-react/src/modules/Modal", JSImport.Namespace)
@js.native
object srcModulesModalMod extends js.Object {
  @js.native
  class default protected ()
    extends Component[ModalProps, ComponentState, js.Any] {
    def this(props: ModalProps) = this()
    def this(props: ModalProps, context: js.Any) = this()
  }
  
  val default: ModalComponent = js.native
}

