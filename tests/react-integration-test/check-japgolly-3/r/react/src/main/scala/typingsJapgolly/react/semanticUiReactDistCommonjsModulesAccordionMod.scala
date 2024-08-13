package typingsJapgolly.react

import org.scalablytyped.runtime.Shortcut
import typingsJapgolly.react.mod.Component
import typingsJapgolly.react.semanticUiReactDistCommonjsModulesAccordionAccordionAccordionMod.AccordionAccordionProps
import typingsJapgolly.react.semanticUiReactDistCommonjsModulesAccordionAccordionMod.AccordionComponent
import typingsJapgolly.react.semanticUiReactDistCommonjsModulesAccordionAccordionMod.AccordionProps
import typingsJapgolly.react.semanticUiReactDistCommonjsModulesAccordionAccordionTitleMod.AccordionTitleProps
import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

object semanticUiReactDistCommonjsModulesAccordionMod {
  
  /* This class was inferred from a value with a constructor. In rare cases (like HTMLElement in the DOM) it might not work as you expect. */
  @JSImport("react/semantic-ui-react/dist/commonjs/modules/Accordion", JSImport.Default)
  @js.native
  open class default protected ()
    extends Component[AccordionProps, js.Object, Any] {
    def this(props: AccordionProps) = this()
    def this(props: AccordionProps, context: Any) = this()
  }
  object default extends Shortcut {
    
    @JSImport("react/semantic-ui-react/dist/commonjs/modules/Accordion", JSImport.Default)
    @js.native
    val ^ : AccordionComponent = js.native
    
    /* This class was inferred from a value with a constructor. In rare cases (like HTMLElement in the DOM) it might not work as you expect. */
    @JSImport("react/semantic-ui-react/dist/commonjs/modules/Accordion", "default.Accordion")
    @js.native
    open class Accordion protected ()
      extends Component[AccordionAccordionProps, js.Object, Any] {
      def this(props: AccordionAccordionProps) = this()
      def this(props: AccordionAccordionProps, context: Any) = this()
    }
    
    /* This class was inferred from a value with a constructor. In rare cases (like HTMLElement in the DOM) it might not work as you expect. */
    @JSImport("react/semantic-ui-react/dist/commonjs/modules/Accordion", "default.Title")
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
