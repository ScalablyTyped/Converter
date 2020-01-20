package typingsJapgolly.semanticUiReact

import org.scalablytyped.runtime.TopLevel
import typingsJapgolly.react.mod.Component
import typingsJapgolly.react.mod.ComponentState
import typingsJapgolly.semanticUiReact.accordionAccordionMod.AccordionComponent
import typingsJapgolly.semanticUiReact.accordionAccordionMod.AccordionProps
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@JSImport("semantic-ui-react/dist/commonjs/modules/Accordion", JSImport.Namespace)
@js.native
object accordionMod extends js.Object {
  @js.native
  class default protected ()
    extends Component[AccordionProps, ComponentState, js.Any] {
    def this(props: AccordionProps) = this()
    def this(props: AccordionProps, context: js.Any) = this()
  }
  
  @js.native
  object default extends TopLevel[AccordionComponent]
  
}

