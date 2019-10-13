package typings.semanticDashUiDashReact

import typings.react.reactMod.Component
import typings.react.reactMod.ComponentState
import typings.semanticDashUiDashReact.srcModulesDropdownDropdownMod.DropdownComponent
import typings.semanticDashUiDashReact.srcModulesDropdownDropdownMod.DropdownProps
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@JSImport("semantic-ui-react/src/modules/Dropdown", JSImport.Namespace)
@js.native
object srcModulesDropdownMod extends js.Object {
  @js.native
  class default protected ()
    extends Component[DropdownProps, ComponentState, js.Any] {
    def this(props: DropdownProps) = this()
    def this(props: DropdownProps, context: js.Any) = this()
  }
  
  val default: DropdownComponent = js.native
}

