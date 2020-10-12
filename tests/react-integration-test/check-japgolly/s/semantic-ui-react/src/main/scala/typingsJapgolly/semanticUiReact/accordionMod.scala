package typingsJapgolly.semanticUiReact

import typingsJapgolly.react.mod.Component
import typingsJapgolly.semanticUiReact.accordionAccordionAccordionMod.AccordionAccordionProps
import typingsJapgolly.semanticUiReact.accordionAccordionMod.AccordionComponent
import typingsJapgolly.semanticUiReact.accordionAccordionMod.AccordionProps
import typingsJapgolly.semanticUiReact.accordionTitleMod.AccordionTitleProps
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

object accordionMod {
  
  /* This class was inferred from a value with a constructor. In rare cases (like HTMLElement in the DOM) it might not work as you expect. */
  @JSImport("semantic-ui-react/dist/commonjs/modules/Accordion", JSImport.Default)
  @js.native
  class default protected ()
    extends Component[AccordionProps, js.Object, js.Any] {
    def this(props: AccordionProps) = this()
    def this(props: AccordionProps, context: js.Any) = this()
  }
  object default {
    
    @JSImport("semantic-ui-react/dist/commonjs/modules/Accordion", JSImport.Default)
    @js.native
    val ^ : AccordionComponent = js.native
    
    /* Syntax to write `default` instead of `default.^` */
    @scala.inline
    implicit def __is(ignored: default.type): AccordionComponent = typingsJapgolly.semanticUiReact.accordionMod.default.^
    
    /* This class was inferred from a value with a constructor. In rare cases (like HTMLElement in the DOM) it might not work as you expect. */
    @JSImport("semantic-ui-react/dist/commonjs/modules/Accordion", "default.Accordion")
    @js.native
    class Accordion protected ()
      extends Component[AccordionAccordionProps, js.Object, js.Any] {
      def this(props: AccordionAccordionProps) = this()
      def this(props: AccordionAccordionProps, context: js.Any) = this()
    }
    
    /* This class was inferred from a value with a constructor. In rare cases (like HTMLElement in the DOM) it might not work as you expect. */
    @JSImport("semantic-ui-react/dist/commonjs/modules/Accordion", "default.Title")
    @js.native
    class Title protected ()
      extends Component[AccordionTitleProps, js.Object, js.Any] {
      def this(props: AccordionTitleProps) = this()
      def this(props: AccordionTitleProps, context: js.Any) = this()
    }
  }
}
