package typings.semanticUiReact

import typings.react.reactMod.Component
import typings.react.reactMod.ComponentState
import typings.semanticUiReact.modulesPopupPopupMod.PopupComponent
import typings.semanticUiReact.modulesPopupPopupMod.PopupProps
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@JSImport("semantic-ui-react/src/modules/Popup", JSImport.Namespace)
@js.native
object modulesPopupMod extends js.Object {
  @js.native
  class default protected ()
    extends Component[PopupProps, ComponentState, js.Any] {
    def this(props: PopupProps) = this()
    def this(props: PopupProps, context: js.Any) = this()
  }
  
  val default: PopupComponent = js.native
}

