package typings.semanticUiReact

import typings.react.reactMod.Component
import typings.react.reactMod.ComponentState
import typings.semanticUiReact.modulesAccordionAccordionMod.AccordionComponent
import typings.semanticUiReact.modulesAccordionAccordionMod.AccordionProps
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@JSImport("semantic-ui-react/src/modules/Accordion", JSImport.Namespace)
@js.native
object modulesAccordionMod extends js.Object {
  @js.native
  class default protected ()
    extends Component[AccordionProps, ComponentState, js.Any] {
    def this(props: AccordionProps) = this()
    def this(props: AccordionProps, context: js.Any) = this()
  }
  
  val default: AccordionComponent = js.native
}

