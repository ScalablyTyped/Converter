package typings.semanticDashUiDashReact

import typings.react.reactMod.Component
import typings.react.reactMod.ComponentState
import typings.semanticDashUiDashReact.srcModulesPopupPopupMod.PopupComponent
import typings.semanticDashUiDashReact.srcModulesPopupPopupMod.PopupProps
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@JSImport("semantic-ui-react/src/modules/Popup", JSImport.Namespace)
@js.native
object srcModulesPopupMod extends js.Object {
  @js.native
  class default protected ()
    extends Component[PopupProps, ComponentState, js.Any] {
    def this(props: PopupProps) = this()
    def this(props: PopupProps, context: js.Any) = this()
  }
  
  val default: PopupComponent = js.native
}

