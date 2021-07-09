package typingsSlinky.semanticUiReact

import org.scalablytyped.runtime.Shortcut
import org.scalablytyped.runtime.StringDictionary
import slinky.core.ReactComponentClass
import typingsSlinky.react.mod.Component
import typingsSlinky.react.mod.ComponentClass
import typingsSlinky.semanticUiReact.accordionAccordionAccordionMod.AccordionAccordionProps
import typingsSlinky.semanticUiReact.accordionAccordionAccordionMod.StrictAccordionAccordionProps
import typingsSlinky.semanticUiReact.accordionContentMod.AccordionContentProps
import typingsSlinky.semanticUiReact.accordionTitleMod.AccordionTitleProps
import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

object accordionAccordionMod {
  
  /* This class was inferred from a value with a constructor. In rare cases (like HTMLElement in the DOM) it might not work as you expect. */
  @JSImport("semantic-ui-react/dist/commonjs/modules/Accordion/Accordion", JSImport.Default)
  @js.native
  class default protected ()
    extends Component[AccordionProps, js.Object, js.Any] {
    def this(props: AccordionProps) = this()
    def this(props: AccordionProps, context: js.Any) = this()
  }
  object default extends Shortcut {
    
    @JSImport("semantic-ui-react/dist/commonjs/modules/Accordion/Accordion", JSImport.Default)
    @js.native
    val ^ : AccordionComponent = js.native
    
    /* This class was inferred from a value with a constructor. In rare cases (like HTMLElement in the DOM) it might not work as you expect. */
    @JSImport("semantic-ui-react/dist/commonjs/modules/Accordion/Accordion", "default.Accordion")
    @js.native
    class Accordion protected ()
      extends Component[AccordionAccordionProps, js.Object, js.Any] {
      def this(props: AccordionAccordionProps) = this()
      def this(props: AccordionAccordionProps, context: js.Any) = this()
    }
    
    /* This class was inferred from a value with a constructor. In rare cases (like HTMLElement in the DOM) it might not work as you expect. */
    @JSImport("semantic-ui-react/dist/commonjs/modules/Accordion/Accordion", "default.Title")
    @js.native
    class Title protected ()
      extends Component[AccordionTitleProps, js.Object, js.Any] {
      def this(props: AccordionTitleProps) = this()
      def this(props: AccordionTitleProps, context: js.Any) = this()
    }
    
    type _To = AccordionComponent
    
    /* This means you don't have to write `^`, but can instead just say `default.foo` */
    override def _to: AccordionComponent = ^
  }
  
  @js.native
  trait AccordionComponent
    extends StObject
       with ComponentClass[AccordionProps, js.Object] {
    
    var Accordion: ReactComponentClass[AccordionAccordionProps] = js.native
    
    var Content: ReactComponentClass[AccordionContentProps] = js.native
    
    var Title: ReactComponentClass[AccordionTitleProps] = js.native
  }
  
  @js.native
  trait AccordionProps
    extends StObject
       with StrictAccordionProps
       with /* key */ StringDictionary[js.Any]
  object AccordionProps {
    
    @scala.inline
    def apply(): AccordionProps = {
      val __obj = js.Dynamic.literal()
      __obj.asInstanceOf[AccordionProps]
    }
  }
  
  @js.native
  trait StrictAccordionProps
    extends StObject
       with StrictAccordionAccordionProps {
    
    /** Format to take up the width of its container. */
    var fluid: js.UndefOr[Boolean] = js.native
    
    /** Format for dark backgrounds. */
    var inverted: js.UndefOr[Boolean] = js.native
    
    /** Adds some basic styling to accordion panels. */
    var styled: js.UndefOr[Boolean] = js.native
  }
  object StrictAccordionProps {
    
    @scala.inline
    def apply(): StrictAccordionProps = {
      val __obj = js.Dynamic.literal()
      __obj.asInstanceOf[StrictAccordionProps]
    }
    
    @scala.inline
    implicit class StrictAccordionPropsMutableBuilder[Self <: StrictAccordionProps] (val x: Self) extends AnyVal {
      
      @scala.inline
      def setFluid(value: Boolean): Self = StObject.set(x, "fluid", value.asInstanceOf[js.Any])
      
      @scala.inline
      def setFluidUndefined: Self = StObject.set(x, "fluid", js.undefined)
      
      @scala.inline
      def setInverted(value: Boolean): Self = StObject.set(x, "inverted", value.asInstanceOf[js.Any])
      
      @scala.inline
      def setInvertedUndefined: Self = StObject.set(x, "inverted", js.undefined)
      
      @scala.inline
      def setStyled(value: Boolean): Self = StObject.set(x, "styled", value.asInstanceOf[js.Any])
      
      @scala.inline
      def setStyledUndefined: Self = StObject.set(x, "styled", js.undefined)
    }
  }
}
