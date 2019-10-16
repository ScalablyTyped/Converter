package typings.semanticUiReact

import typings.react.reactMod.Component
import typings.react.reactMod.ComponentState
import typings.semanticUiReact.modulesTabTabMod.TabComponent
import typings.semanticUiReact.modulesTabTabMod.TabProps
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@JSImport("semantic-ui-react/src/modules/Tab", JSImport.Namespace)
@js.native
object modulesTabMod extends js.Object {
  @js.native
  class default protected ()
    extends Component[TabProps, ComponentState, js.Any] {
    def this(props: TabProps) = this()
    def this(props: TabProps, context: js.Any) = this()
  }
  
  val default: TabComponent = js.native
}

