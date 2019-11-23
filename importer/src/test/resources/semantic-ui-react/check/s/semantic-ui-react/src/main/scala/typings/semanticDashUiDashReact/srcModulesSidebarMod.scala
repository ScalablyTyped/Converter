package typings.semanticDashUiDashReact

import typings.react.reactMod.Component
import typings.react.reactMod.ComponentState
import typings.semanticDashUiDashReact.srcModulesSidebarSidebarMod.SidebarComponent
import typings.semanticDashUiDashReact.srcModulesSidebarSidebarMod.SidebarProps
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@JSImport("semantic-ui-react/src/modules/Sidebar", JSImport.Namespace)
@js.native
object srcModulesSidebarMod extends js.Object {
  @js.native
  class default protected ()
    extends Component[SidebarProps, ComponentState, js.Any] {
    def this(props: SidebarProps) = this()
    def this(props: SidebarProps, context: js.Any) = this()
  }
  
  val default: SidebarComponent = js.native
}

