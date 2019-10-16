package typings.semanticUiReact

import typings.react.reactMod.Component
import typings.react.reactMod.ComponentState
import typings.semanticUiReact.modulesSearchSearchMod.SearchComponent
import typings.semanticUiReact.modulesSearchSearchMod.SearchProps
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@JSImport("semantic-ui-react/src/modules/Search", JSImport.Namespace)
@js.native
object modulesSearchMod extends js.Object {
  @js.native
  class default protected ()
    extends Component[SearchProps, ComponentState, js.Any] {
    def this(props: SearchProps) = this()
    def this(props: SearchProps, context: js.Any) = this()
  }
  
  val default: SearchComponent = js.native
}

