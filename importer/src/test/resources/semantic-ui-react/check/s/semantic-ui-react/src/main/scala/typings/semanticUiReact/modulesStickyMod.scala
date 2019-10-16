package typings.semanticUiReact

import typings.react.reactMod.Component
import typings.react.reactMod.ComponentClass
import typings.react.reactMod.ComponentState
import typings.semanticUiReact.modulesStickyStickyMod.StickyProps
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@JSImport("semantic-ui-react/src/modules/Sticky", JSImport.Namespace)
@js.native
object modulesStickyMod extends js.Object {
  @js.native
  class default protected ()
    extends Component[StickyProps, ComponentState, js.Any] {
    def this(props: StickyProps) = this()
    def this(props: StickyProps, context: js.Any) = this()
  }
  
  val default: ComponentClass[StickyProps, ComponentState] = js.native
}

