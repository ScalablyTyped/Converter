package typings.semanticUiReact

import typings.react.reactMod.Component
import typings.react.reactMod.ComponentClass
import typings.react.reactMod.ComponentState
import typings.semanticUiReact.modulesProgressProgressMod.ProgressProps
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@JSImport("semantic-ui-react/src/modules/Progress", JSImport.Namespace)
@js.native
object modulesProgressMod extends js.Object {
  @js.native
  class default protected ()
    extends Component[ProgressProps, ComponentState, js.Any] {
    def this(props: ProgressProps) = this()
    def this(props: ProgressProps, context: js.Any) = this()
  }
  
  val default: ComponentClass[ProgressProps, ComponentState] = js.native
}

