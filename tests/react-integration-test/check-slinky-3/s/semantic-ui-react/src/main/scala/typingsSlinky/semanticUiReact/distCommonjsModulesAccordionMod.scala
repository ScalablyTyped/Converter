package typingsSlinky.semanticUiReact

import org.scalablytyped.runtime.Shortcut
import typingsSlinky.react.mod.Component
import typingsSlinky.semanticUiReact.distCommonjsModulesAccordionAccordionAccordionMod.AccordionAccordionProps
import typingsSlinky.semanticUiReact.distCommonjsModulesAccordionAccordionMod.AccordionComponent
import typingsSlinky.semanticUiReact.distCommonjsModulesAccordionAccordionMod.AccordionProps
import typingsSlinky.semanticUiReact.distCommonjsModulesAccordionAccordionTitleMod.AccordionTitleProps
import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

object distCommonjsModulesAccordionMod {
  
  /* This class was inferred from a value with a constructor. In rare cases (like HTMLElement in the DOM) it might not work as you expect. */
  @JSImport("semantic-ui-react/dist/commonjs/modules/Accordion", JSImport.Default)
  @js.native
  open class default protected ()
    extends Component[AccordionProps, js.Object, Any] {
    def this(props: AccordionProps) = this()
    def this(props: AccordionProps, context: Any) = this()
  }
  object default extends Shortcut {
    
    @JSImport("semantic-ui-react/dist/commonjs/modules/Accordion", JSImport.Default)
    @js.native
    val ^ : AccordionComponent = js.native
    
    /* This class was inferred from a value with a constructor. In rare cases (like HTMLElement in the DOM) it might not work as you expect. */
    @JSImport("semantic-ui-react/dist/commonjs/modules/Accordion", "default.Accordion")
    @js.native
    open class Accordion protected ()
      extends Component[AccordionAccordionProps, js.Object, Any] {
      def this(props: AccordionAccordionProps) = this()
      def this(props: AccordionAccordionProps, context: Any) = this()
    }
    
    /* This class was inferred from a value with a constructor. In rare cases (like HTMLElement in the DOM) it might not work as you expect. */
    @JSImport("semantic-ui-react/dist/commonjs/modules/Accordion", "default.Title")
    @js.native
    open class Title protected ()
      extends Component[AccordionTitleProps, js.Object, Any] {
      def this(props: AccordionTitleProps) = this()
      def this(props: AccordionTitleProps, context: Any) = this()
    }
    
    type _To = AccordionComponent
    
    /* This means you don't have to write `^`, but can instead just say `default.foo` */
    override def _to: AccordionComponent = ^
  }
}
