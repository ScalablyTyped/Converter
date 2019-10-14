package typings.semanticDashUiDashReact

import typings.react.reactMod.Component
import typings.react.reactMod.ComponentState
import typings.semanticDashUiDashReact.srcModulesSearchSearchMod.SearchComponent
import typings.semanticDashUiDashReact.srcModulesSearchSearchMod.SearchProps
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@JSImport("semantic-ui-react/src/modules/Search", JSImport.Namespace)
@js.native
object srcModulesSearchMod extends js.Object {
  @js.native
  class default protected ()
    extends Component[SearchProps, ComponentState, js.Any] {
    def this(props: SearchProps) = this()
    def this(props: SearchProps, context: js.Any) = this()
  }
  
  val default: SearchComponent = js.native
}

