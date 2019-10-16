package typings.semanticUiReact

import typings.react.reactMod.Component
import typings.react.reactMod.ComponentState
import typings.semanticUiReact.elementsLabelLabelMod.LabelComponent
import typings.semanticUiReact.elementsLabelLabelMod.LabelProps
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@JSImport("semantic-ui-react/src/elements/Label", JSImport.Namespace)
@js.native
object elementsLabelMod extends js.Object {
  @js.native
  class default protected ()
    extends Component[LabelProps, ComponentState, js.Any] {
    def this(props: LabelProps) = this()
    def this(props: LabelProps, context: js.Any) = this()
  }
  
  val default: LabelComponent = js.native
}

