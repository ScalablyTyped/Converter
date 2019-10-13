package typings.semanticDashUiDashReact

import typings.react.reactMod.Component
import typings.react.reactMod.ComponentState
import typings.semanticDashUiDashReact.srcModulesTabTabMod.TabComponent
import typings.semanticDashUiDashReact.srcModulesTabTabMod.TabProps
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@JSImport("semantic-ui-react/src/modules/Tab", JSImport.Namespace)
@js.native
object srcModulesTabMod extends js.Object {
  @js.native
  class default protected ()
    extends Component[TabProps, ComponentState, js.Any] {
    def this(props: TabProps) = this()
    def this(props: TabProps, context: js.Any) = this()
  }
  
  val default: TabComponent = js.native
}

